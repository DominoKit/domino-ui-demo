package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.media.MediaObject;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class ContactDetails extends BaseDominoElement<HTMLDivElement, ContactDetails> {

    private Row rowElement = Row.create()
            .addCss(dui_m_0);
    private CellRenderer.CellInfo<Contact> cell;

    public ContactDetails(CellRenderer.CellInfo<Contact> cell) {
        this.cell = cell;
        initDetails();
    }


    private void initDetails() {
        TableRow<Contact> row = cell.getTableRow();

        SwitchButton activeButton = SwitchButton.create()
                .addCss(dui_accent_blue);
        activeButton.setValue(row.getRecord().isActive());

        activeButton.addChangeListener((oldValue, value) -> {
            row.getRecord().setActive(value);
            row.getCell("status").updateCell();
        });

        rowElement
                .appendChild(Column.span4()
                        .appendChild(MediaObject.create()
                                .setHeader(row.getRecord().getName())
                                .setLeftMedia(a()
                                        .appendChild(img(cell
                                                .getRecord()
                                                .getPicture()
                                                .replace("gender", ContactUiUtils.getGenderIconName(cell.getRecord())).replace("index", ContactUiUtils.getAvatarIndex(cell.getRecord())))
                                                .setAttribute("width", "64")
                                                .setAttribute("height", "64")))
                                .appendChild(text(cell.getRecord().getAbout())))
                )
                .appendChild(Column.span4()
                        .appendChild(elementOf(ContactUiUtils.getEyeColorElement(cell.getRecord()))
                                .setPadding("5px")
                        )
                        .appendChild(elementOf(ContactUiUtils.getGenderElement(cell.getRecord()))
                                .setPadding("5px"))
                        .appendChild(BlockHeader.create(row.getRecord().getBalance() + "", "BALANCE")
                                .setReversed(true)
                                .setMarginTop("30px")
                        )
                        .appendChild(elementOf(ContactUiUtils.getBalanceElement(cell.getRecord()))
                                .setMarginTop("5px"))
                        .appendChild(elementOf(BlockHeader.create("ACTIVE").appendChild(activeButton))
                                .setMarginTop("30px"))
                )

                .appendChild(Column.span4()
                        .appendChild(BlockHeader.create(row.getRecord().getCompany() + "", "COMPANY")
                                .setReversed(true)
                                .setMarginTop("5px")
                        )
                        .appendChild(BlockHeader.create(row.getRecord().getAddress() + "", "ADDRESS")
                                .setReversed(true)
                                .setMarginTop("10px")
                        )
                        .appendChild(BlockHeader.create(row.getRecord().getAge() + "", "AGE")
                                .setReversed(true)
                                .setMargin("5px")
                                .setMarginTop("30px"))
                );

    }

    @Override
    public HTMLDivElement element() {
        return rowElement.element();
    }
}
