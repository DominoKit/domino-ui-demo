package org.dominokit.domino.formsamples.client.views.ui.section;

import com.google.gwt.i18n.client.DateTimeFormat;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.Constants;
import org.dominokit.domino.formsamples.client.views.ui.CountriesComponent;
import org.dominokit.domino.formsamples.shared.model.Country;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.formsamples.shared.model.Validity;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datepicker.DateBox;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;

import java.util.List;

import static org.dominokit.domino.formsamples.client.views.ui.Constants.DATE_PATTERN;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.dominokit.domino.ui.grid.Column.span3;
import static org.dominokit.domino.ui.utils.ElementUtil.numbersOnly;
import static org.jboss.gwt.elemento.core.Elements.div;

public class ValiditySection implements ImportSection {

    private Select<Country> countrySelect;
    private Select<String> citySelect;

    private DateBox validityExpiryDateBox;
    private TextBox daysForShipmentTextBox;
    private Card card;
    private HTMLDivElement element = div().asElement();
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    public ValiditySection(List<Country> countries) {
        element.appendChild(BlockHeader.create("Validity *").asElement());

        CountriesComponent countriesComponent = CountriesComponent.create(countries);

        card = Card.create();

        revalidate();

        countrySelect = countriesComponent.getCountriesSelect()
                .setRequired(true)
                .setAutoValidation(true)
                .groupBy(fieldsGrouping)
                .addSelectionHandler(option -> revalidate());

        citySelect = countriesComponent.getCitiesSelect()
                .setLabel("City / Town")
                .setRequired(true)
                .setAutoValidation(true)
                .groupBy(fieldsGrouping)
                .addSelectionHandler(option -> revalidate());

        validityExpiryDateBox = DateBox.create()
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setPattern(DATE_PATTERN)
                .setLabel("Expiry Date Of Credit")
                .setLeftAddon(Icons.ALL.date_range())
                .setHelperText(DATE_PATTERN);
        validityExpiryDateBox.getInputElement().addEventListener("input", evt -> revalidate());
        validityExpiryDateBox.getDatePicker().addDateSelectionHandler((date, dateTimeFormatInfo) -> revalidate());

        daysForShipmentTextBox = TextBox.create("Days for Shipping Documents")
                .setValue("21")
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.looks_one())
                .setHelperText(Constants.NUMBERS_ONLY);
        daysForShipmentTextBox.getInputElement().addEventListener("input", evt -> revalidate());


        element.appendChild(card
                .style()
                .setPaddingTop("20px")
                .get()
                .appendChild(Row.create()
                        .addColumn(span3().appendChild(validityExpiryDateBox))
                        .addColumn(span3().appendChild(countrySelect))
                        .addColumn(span3().appendChild(citySelect))
                        .addColumn(span3().appendChild(numbersOnly(daysForShipmentTextBox)))
                )
                .asElement());

    }

    private void revalidate() {
        if (isInvalidatedCard(card) && fieldsGrouping.validate().isValid()) {
            markCardValidation(card, true, false);
        }
    }

    @Override
    public boolean validate() {
        boolean valid = fieldsGrouping.validate().isValid();
        markCardValidation(card, valid);
        return valid;
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        Validity validity = letterOfCredit.getValidity();
        validity.setCity(citySelect.getValue());
        validity.setCountry(countrySelect.getValue().getIso());
        validity.setDaysForPresentingDocuments(Integer.parseInt(daysForShipmentTextBox.getValue()));
        validity.setExpiryDateOfCredit(DateTimeFormat.getFormat(DATE_PATTERN).format(validityExpiryDateBox.getValue()));
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
