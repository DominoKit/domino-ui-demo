package org.dominokit.domino.formsamples.client.views.ui.section;

import com.google.gwt.i18n.client.NumberFormat;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.CurrenciesComponent;
import org.dominokit.domino.formsamples.shared.model.CreditAmount;
import org.dominokit.domino.formsamples.shared.model.CurrencyData;
import org.dominokit.domino.formsamples.shared.model.LcAmount;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.ValidationResult;

import java.util.List;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.validatePercent;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.i;

public class CreditAmountAndToleranceSection implements ImportSection {
    private List<CurrencyData> currencies;
    private TextBox amountFieldTextBox;
    private Select<CurrencyData> currencySelect;
    private TextBox toleranceTextBox;
    private CheckBox maximumCheckBox;
    private Card card;
    private HTMLDivElement element = div().asElement();
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

    public CreditAmountAndToleranceSection(List<CurrencyData> currencies) {
        element.appendChild(BlockHeader.create("Credit Amount And Tolerance *").asElement());

        card = Card.create();

        CurrenciesComponent currenciesComponent = CurrenciesComponent.create()
                .setCurrencies(currencies);

        revalidate();

        amountFieldTextBox = currenciesComponent
                .getAmountField()
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true);
        amountFieldTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        currencySelect = currenciesComponent
                .getCurrencySelect()
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .addSelectionHandler(option -> revalidate());

        toleranceTextBox = ElementUtil.numbersOnly(TextBox.create("Tolerance"))
                .groupBy(fieldsGrouping)
                .setRequired(true)
                .setAutoValidation(true)
                .addValidator(this::validateTolerance);
        toleranceTextBox.getInputElement().addEventListener("input", evt -> revalidate());

        maximumCheckBox = CheckBox.create("Maximum");
        maximumCheckBox.addChangeHandler(value -> {
            if (value) {
                toleranceTextBox.collapse();
                toleranceTextBox.setRequired(false);
            } else {
                toleranceTextBox.expand();
                toleranceTextBox.setRequired(true);
                toleranceTextBox.setAutoValidation(true);
                toleranceTextBox.validate();
            }

            revalidate();
        });


        element.appendChild(Style.of(card)
                .setPaddingTop("20px")
                .get()
                .appendContent(Row.create()
                        .addColumn(Column.span3()
                                .addElement(currencySelect)
                        ).addColumn(Column.span3()
                                .addElement(amountFieldTextBox)
                        )
                        .addColumn(Column.span3()
                                .addElement(maximumCheckBox)
                        )
                        .addColumn(Column.span3()
                                .addElement(toleranceTextBox
                                        .setLeftAddon(i().css("fas", "fa-percent", "fa-sm")))
                        )

                )
                .asElement());

    }

    private void revalidate() {
        if (isInvalidatedCard(card) && fieldsGrouping.validate().isValid()) {
            markCardValidation(card, true, false);
        }
    }

    private ValidationResult validateTolerance() {
        if (maximumCheckBox.getValue())
            return ValidationResult.valid();

        return validatePercent(toleranceTextBox);
    }

    @Override
    public boolean validate() {
        boolean valid = fieldsGrouping.validate().isValid();
        markCardValidation(card, valid);
        return valid;
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        CreditAmount creditAmount = letterOfCredit.getCreditAmount();
        creditAmount.setMaximum(maximumCheckBox.getValue());
        if (!creditAmount.isMaximum()) {
            creditAmount.setTolerance(Double.parseDouble(toleranceTextBox.getValue()));
        }
        LcAmount lcAmount = new LcAmount();
        lcAmount.setCurrency(currencySelect.getValue().getCurrencyCode());
        double amount = NumberFormat.getCurrencyFormat(lcAmount.getCurrency())
                .parse(amountFieldTextBox.getValue());
        lcAmount.setValue(amount);
        creditAmount.setLcAmount(lcAmount);
    }


    @Override
    public HTMLElement asElement() {
        return element;
    }
}
