package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.CorporateProfile;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datepicker.DateBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;

import java.util.Date;

import static org.dominokit.domino.formsamples.client.views.ui.Constants.DATE_PATTERN;
import static org.jboss.elemento.Elements.div;

public class GeneralSection implements ImportSection {

    private DateBox creationDateBox;
    private TextBox placeTextBox;
    private HTMLDivElement element = div().element();

    public GeneralSection(CorporateProfile corporateProfile) {
        element.appendChild(BlockHeader.create("General").element());

        creationDateBox = DateBox.create();
        placeTextBox = TextBox.create("Place")
                .value("Amman");

        element.appendChild(Card.create()
                .style()
                .setPaddingTop("20px")
                .get()
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .style()
                                .setMarginBottom("0px").get()
                                .appendChild(creationDateBox
                                        .setPattern(DATE_PATTERN)
                                        .setHelperText(DATE_PATTERN)
                                        .setLabel("Date")
                                        .addLeftAddOn(Icons.ALL.calendar_range_mdi())
                                        .setReadOnly(true)
                                        .value(new Date())))
                        .addColumn(Column.span6()
                                .style()
                                .setMarginBottom("0px")
                                .get()
                                .appendChild(placeTextBox
                                        .setReadOnly(true)
                                        .addLeftAddOn(Icons.ALL.location_enter_mdi())
                                        .value(corporateProfile.getAddress().getCountryISOCode() + " - " + corporateProfile.getAddress().getCity())))
                )
                .element());
    }


    @Override
    public void collect(LetterOfCredit letterOfCredit) {

    }

    @Override
    public boolean validate() {
        return true;
    }


    @Override
    public HTMLElement element() {
        return element;
    }
}
