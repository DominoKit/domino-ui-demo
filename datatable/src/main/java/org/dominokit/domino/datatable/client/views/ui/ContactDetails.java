package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.media.MediaObject;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.img;

public class ContactDetails implements IsElement<HTMLElement> {

    private Row rowElement = Row.create()
            .style().add(Styles.margin_0).get();
    private CellRenderer.CellInfo<Contact> cell;

    public ContactDetails(CellRenderer.CellInfo<Contact> cell) {
        this.cell = cell;
        initDetails();
    }


    private void initDetails() {
        TableRow<Contact> row = cell.getTableRow();

        SwitchButton activeButton = SwitchButton.create()
                .setColor(Color.BLUE);
        activeButton.setValue(row.getRecord().isActive());

        activeButton.addChangeHandler(value -> {
            row.getRecord().setActive(value);
            row.getCell("status").updateCell();
        });

        rowElement
                .addColumn(Column.span4()
                        .appendChild(MediaObject.create()
                                .setHeader(row.getRecord().getName())
                                .setLeftMedia(a().add(img(cell.getRecord().getPicture().replace("gender", ContactUiUtils.getGenderIconName(cell.getRecord())).replace("index", ContactUiUtils.getAvatarIndex(cell.getRecord())))
                                        .attr("width", "64")
                                        .attr("height", "64")))
                                .appendChild(TextNode.of(cell.getRecord().getAbout()))))
                .addColumn(Column.span4()
                        .appendChild(Style.of(ContactUiUtils.getEyeColorElement(cell.getRecord()))
                                .setPadding("5px"))
                        .appendChild(Style.of(ContactUiUtils.getGenderElement(cell.getRecord()))
                                .setPadding("5px"))
                        .appendChild(Style.of(BlockHeader.create(row.getRecord().getBalance() + "", "BALANCE").invert())
                                .setMarginTop("30px"))
                        .appendChild(Style.of(ContactUiUtils.getBalanceElement(cell.getRecord()))
                                .setMarginTop("5px"))
                        .appendChild(Style.of(BlockHeader.create("ACTIVE").appendChild(activeButton))
                                .setMarginTop("30px"))
                )

                .addColumn(Column.span4()
                        .appendChild(Style.of(BlockHeader.create(row.getRecord().getCompany() + "", "COMPANY").invert())
                                .setMarginTop("5px"))
                        .appendChild(Style.of(BlockHeader.create(row.getRecord().getAddress() + "", "ADDRESS").invert())
                                .setMarginTop("10px"))
                        .appendChild(Style.of(BlockHeader.create(row.getRecord().getAge() + "", "AGE").invert())
                                .setMargin("5px")
                                .setMarginTop("30px"))
                );

    }

    @Override
    public HTMLElement asElement() {
        return rowElement.asElement();
    }
}
