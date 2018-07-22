package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.media.MediaObject;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.HasChangeHandlers;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.img;

public class ContactDetails implements IsElement<HTMLElement> {

    private Row rowElement = Row.create();
    private CellRenderer.CellInfo<Contact> cell;

    public ContactDetails(CellRenderer.CellInfo<Contact> cell) {
        this.cell = cell;
        initDetails();
    }


    private void initDetails() {
        TableRow<Contact> row = cell.getTableRow();
        Column column = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        Column column2 = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        Column column3 = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        SwitchButton activeButton = SwitchButton.create()
                .setColor(Color.BLUE);
        activeButton.setValue(row.getRecord().isActive());

        activeButton.addChangeHandler(value -> {
            row.getRecord().setActive(value);
            row.getCell("status").updateCell();
        });

        rowElement
                .addColumn(column.copy()
                        .addElement(MediaObject.create()
                                .setHeader(row.getRecord().getName())
                                .setLeftMedia(a().add(img(cell.getRecord().getPicture().replace("gender", ContactUiUtils.getGenderIconName(cell.getRecord())).replace("index", ContactUiUtils.getAvatarIndex(cell.getRecord())))
                                        .attr("width", "64")
                                        .attr("height", "64"))
                                        .asElement())
                                .appendContent(new Text(cell.getRecord().getAbout()))
                                .asElement()))
                .addColumn(column2.copy()
                        .addElement(Style.of(ContactUiUtils.getEyeColorElement(cell.getRecord()))
                                .setPadding("5px")
                                .asElement())
                        .addElement(Style.of(ContactUiUtils.getGenderElement(cell.getRecord()))
                                .setPadding("5px")
                                .asElement())
                        .addElement(Style.of(BlockHeader.create(row.getRecord().getBalance() + "", "BALANCE").invert())
                                .setMarginTop("30px")
                                .asElement())
                        .addElement(Style.of(ContactUiUtils.getBalanceElement(cell.getRecord()))
                                .setMarginTop("5px")
                                .asElement())
                        .addElement(Style.of(BlockHeader.create("ACTIVE").appendContent(activeButton.asElement()))
                                .setMarginTop("30px").asElement())
                )

                .addColumn(column3.copy()

                        .addElement(Style.of(BlockHeader.create(row.getRecord().getCompany() + "", "COMPANY").invert())
                                .setMarginTop("5px")
                                .asElement())
                        .addElement(Style.of(BlockHeader.create(row.getRecord().getAddress() + "", "ADDRESS").invert())
                                .setMarginTop("10px")
                                .asElement())
                        .addElement(Style.of(BlockHeader.create(row.getRecord().getAge() + "", "AGE").invert())
                                .setMargin("5px")
                                .setMarginTop("30px")
                                .asElement())
                );

        Style.of(rowElement).css(Styles.margin_0);
    }

    @Override
    public HTMLElement asElement() {
        return rowElement.asElement();
    }
}
