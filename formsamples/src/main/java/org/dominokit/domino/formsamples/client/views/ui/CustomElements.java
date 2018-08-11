package org.dominokit.domino.formsamples.client.views.ui;

import elemental2.dom.DomGlobal;
import org.dominokit.domino.formsamples.shared.model.Country;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.ValidationResult;

import java.util.List;

import static org.dominokit.domino.formsamples.client.views.ui.Constants.NUMBERS_ONLY;
import static org.dominokit.domino.ui.utils.ElementUtil.numbersOnly;

public class CustomElements {

    public static final String NUMBER_OF_COPIES = "Number of copies";

    public static TextBox createDescriptionField() {
        return TextBox.create("Description").setLeftAddon(Icons.ALL.description())
                .setAutoValidation(true)
                .setRequired(true);
    }

    public static SwitchButton createRequiredField() {
        return Style.of(SwitchButton.create().setOffTitle("Required"))
                .setMarginBottom("0px")
                .get();
    }

    public static TextBox createCopiesField() {
        return numbersOnly(TextBox.create(NUMBER_OF_COPIES))
                .setHelperText(NUMBERS_ONLY)
                .setLeftAddon(Icons.ALL.content_copy())
                .setAutoValidation(true)
                .setRequired(true);
    }

    public static Select<Country> createCountriesSelect(String label, List<Country> countries) {
        Select<Country> countrySelect = Select.create(label);
        countrySelect.setLeftAddon(Icons.ALL.map());

        countries.forEach(country -> {
            countrySelect.addOption(SelectOption.create(country, country.getName()));
        });
        return countrySelect;
    }

    public static void markCardValidation(Card card, boolean isValid, boolean scroll){
        if (!isValid) {
            Style.of(card).css("invalid-section");

            if(scroll) {
                ElementUtil.scrollToElement(card);
                DomGlobal.document.body.scrollTop = DomGlobal.document.body.scrollTop - 110;
                DomGlobal.document.documentElement.scrollTop = DomGlobal.document.documentElement.scrollTop - 110;
            }
        } else {
            Style.of(card).removeClass("invalid-section");
        }
    }

    public static boolean isInvalidatedCard(Card card){
        return Style.of(card).hasClass("invalid-section");
    }

    public static void markCardValidation(Card card, boolean isValid){
        markCardValidation(card, isValid, true);
    }

    public static ValidationResult validatePercent(TextBox textBox){
        try {
            int percent = Integer.parseInt(textBox.getValue());
            if ((percent > 0 && percent <= 100)) {
                return ValidationResult.valid();
            }
        } catch (NumberFormatException ex) {
            return ValidationResult.invalid("Accepted value between 1 - 100");
        }

        return ValidationResult.invalid("Accepted value between 1 - 100");
    }
}
