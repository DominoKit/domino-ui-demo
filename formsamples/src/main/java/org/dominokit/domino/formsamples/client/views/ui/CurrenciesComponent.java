package org.dominokit.domino.formsamples.client.views.ui;

import com.google.gwt.i18n.client.NumberFormat;
import org.dominokit.domino.formsamples.shared.model.CurrencyData;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.icons.Icons;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementUtil.numbersOnly;
import static org.jboss.gwt.elemento.core.Elements.i;

public class CurrenciesComponent {

    private Select<CurrencyData> currencySelect;
    private TextBox amountField;
    private String oldCurrencyCode;

    public CurrenciesComponent() {
        currencySelect = Select.<CurrencyData>create("Currency")
                .setLeftAddon(i().css("fas", "fa-money-bill-alt", "fa-lg"));
        amountField = numbersOnly(TextBox.create("Amount")
                .setHelperText("Numbers only")
                .setLeftAddon(Icons.ALL.attach_money()));

        amountField.getInputElement().addEventListener("change", evt -> formatAmount(currencySelect.getSelectedOption()));

        currencySelect.addSelectionHandler(this::formatAmount);
    }

    private void formatAmount(SelectOption<CurrencyData> option) {
        if (nonNull(option) && !amountField.isEmpty()) {
            String value = amountField.getValue();
            String currencyCode = option.getKey();
            double amount = parseAmount(oldCurrencyCode, value);
            String formattedAmount = NumberFormat.getCurrencyFormat(currencyCode).format(amount);
            amountField.setValue(formattedAmount);
            this.oldCurrencyCode = option.getKey();
        }
    }

    private double parseAmount(String currencyCode, String amount) {
        try {
            return NumberFormat.getCurrencyFormat(currencyCode).parse(amount);
        } catch (Exception ex) {
            return Double.parseDouble(amount);
        }
    }

    public static CurrenciesComponent create() {
        return new CurrenciesComponent();
    }

    public CurrenciesComponent setCurrencies(List<CurrencyData> currencies) {
        currencySelect.removeAllOptions();
        for (CurrencyData cd : currencies) {
            currencySelect.appendChild(SelectOption.create(cd, cd.getCurrencyCode(), cd.getCurrencyCode() + " - " + cd.getDisplayName()));
        }
        return this;
    }

    public Select<CurrencyData> getCurrencySelect() {
        return currencySelect;
    }

    public TextBox getAmountField() {
        return amountField;
    }
}
