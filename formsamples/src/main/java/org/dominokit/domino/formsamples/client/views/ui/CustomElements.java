package org.dominokit.domino.formsamples.client.views.ui;

import elemental2.dom.DomGlobal;
import org.dominokit.domino.formsamples.shared.model.Country;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.ElementUtil;

import java.util.List;

import static org.dominokit.domino.formsamples.client.views.ui.Constants.NUMBERS_ONLY;
import static org.dominokit.domino.ui.utils.ElementUtil.numbersOnly;

public class CustomElements {

    public static final String NUMBER_OF_COPIES = "Number of copies";

    public static TextBox createDescriptionField() {
        return TextBox.create("Description").addLeftAddOn(Icons.ALL.note_mdi())
                .setAutoValidation(true)
                .setRequired(true);
    }

    public static SwitchButton createRequiredField() {
        return SwitchButton.create().setOffTitle("Required")
                .style()
                .setMarginBottom("0px")
                .get();
    }

    public static TextBox createCopiesField() {
        return numbersOnly(TextBox.create(NUMBER_OF_COPIES))
                .setHelperText(NUMBERS_ONLY)
                .addLeftAddOn(Icons.ALL.content_copy_mdi())
                .setAutoValidation(true)
                .setRequired(true);
    }

    public static Select<Country> createCountriesSelect(String label, List<Country> countries) {
        Select<Country> countrySelect = Select.create(label);
        countrySelect.addLeftAddOn(Icons.ALL.map_mdi());

        countries.forEach(country -> {
            countrySelect.appendChild(SelectOption.create(country, country.getName()));
        });
        return countrySelect;
    }

    public static void markCardValidation(Card card, boolean isValid, boolean scroll) {
        if (!isValid) {
            card.style().addCss("invalid-section");

            if (scroll) {
                ElementUtil.scrollToElement(card);
                DomGlobal.document.body.scrollTop = DomGlobal.document.body.scrollTop - 110;
                DomGlobal.document.documentElement.scrollTop = DomGlobal.document.documentElement.scrollTop - 110;
            }
        } else {
            card.style().removeCss("invalid-section");
        }
    }

    public static boolean isInvalidatedCard(Card card) {
        return card.style().containsCss("invalid-section");
    }

    public static void markCardValidation(Card card, boolean isValid) {
        markCardValidation(card, isValid, true);
    }

    public static ValidationResult validatePercent(TextBox textBox) {
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
