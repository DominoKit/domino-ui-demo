package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.CorporateProfile;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.datepicker.DateBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Style;

import java.util.Date;

import static org.dominokit.domino.formsamples.client.views.ui.Constants.DATE_PATTERN;
import static org.jboss.gwt.elemento.core.Elements.div;

public class GeneralSection implements ImportSection {

    private DateBox creationDateBox;
    private TextBox placeTextBox;
    private HTMLDivElement element = div().asElement();

    public GeneralSection(CorporateProfile corporateProfile) {
        element.appendChild(BlockHeader.create("General").asElement());

        creationDateBox = DateBox.create();
        placeTextBox = TextBox.create("Place")
                .setValue("Amman");

        element.appendChild(Style.of(Card.create())
                .setPaddingTop("20px")
                .get()
                .appendChild(Row.create()
                        .addColumn(Style.of(Column.span6()).setMarginBottom("0px").get()
                                .addElement(creationDateBox
                                        .setPattern(DATE_PATTERN)
                                        .setHelperText(DATE_PATTERN)
                                        .setLabel("Date")
                                        .setLeftAddon(Icons.ALL.date_range())
                                        .setReadOnly(true)
                                        .setValue(new Date())))
                        .addColumn(Style.of(Column.span6())
                                .setMarginBottom("0px")
                                .get()
                                .addElement(placeTextBox
                                        .setReadOnly(true)
                                        .setLeftAddon(Icons.ALL.location_on())
                                        .setValue(corporateProfile.getAddress().getCountryISOCode() + " - " + corporateProfile.getAddress().getCity())))
                )
                .asElement());
    }


    @Override
    public void collect(LetterOfCredit letterOfCredit) {

    }

    @Override
    public boolean validate() {
        return true;
    }


    @Override
    public HTMLElement asElement() {
        return element;
    }
}
