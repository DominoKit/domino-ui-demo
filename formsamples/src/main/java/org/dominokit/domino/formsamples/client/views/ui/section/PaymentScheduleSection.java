package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.Constants;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.formsamples.shared.model.PaymentScheduleItem;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.lists.ListItem;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.forms.validations.ValidationResult;

import java.util.List;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.dominokit.domino.ui.grid.Column.span12;
import static org.dominokit.domino.ui.grid.Column.span4;
import static org.dominokit.domino.ui.utils.ElementUtil.numbersOnly;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.i;
import static org.jboss.gwt.elemento.core.Elements.small;

public class PaymentScheduleSection implements ImportSection {

    private final HTMLElement validationMessageElement = small().textContent("Total payment schedules should be 100%").css(Color.RED.getStyle()).asElement();
    private TextBox numberOfDaysTextBox;
    private Select<String> paymentScheduleAfterSelect;
    private TextBox percentageTextBox;
    private RadioGroup paymentScheduleRadioGroup;
    private ListGroup<PaymentScheduleItem> paymentScheduleItemsListGroup;
    private Button addButton;
    private Collapsible valuesContainerCollapsible;
    private Card paymentScheduleCard;
    private HTMLDivElement element = div().asElement();
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();
    private final Row paymentSchedulerListGroupRow;

    public PaymentScheduleSection() {

        numberOfDaysTextBox = numbersOnly(TextBox.create("No. Of Days")
                .setLeftAddon(Icons.ALL.looks_one())
                .setHelperText(Constants.NUMBERS_ONLY))
                .groupBy(fieldsGrouping)
                .setAutoValidation(true);

        Column numberOfDaysColumn = span4()
                .appendChild(numberOfDaysTextBox).hide();

        paymentScheduleAfterSelect = Select.<String>create("After").appendChild(SelectOption.create("Presentation Of Documents", "Presentation Of Documents"))
                .appendChild(SelectOption.create("Bill Of Lading Date", "Bill Of Lading Date"))
                .appendChild(SelectOption.create("Commercial Invoice", "Commercial Invoice"))
                .setLeftAddon(Icons.ALL.redo())
                .groupBy(fieldsGrouping)
                .setAutoValidation(true);

        Column paymentScheduleAfterColumn = span4()
                .appendChild(paymentScheduleAfterSelect).hide();

        percentageTextBox = numbersOnly(TextBox.create("Percentage"))
                .setHelperText("Numbers only")
                .setAutoValidation(true)
                .value("100")
                .setRequired(true)
                .groupBy(fieldsGrouping)
                .setLeftAddon(i().css("fas", "fa-percent", "fa-sm"))
                .addValidator(() -> {
                    int percentage = Integer.parseInt(percentageTextBox.getValue());
                    int remainingPercentage = remainingPercentage();
                    if (percentage > 0 && percentage <= remainingPercentage) {
                        return ValidationResult.valid();
                    }
                    return ValidationResult.invalid("Maximum allowed percentage is " + remainingPercentage);
                });

        paymentScheduleItemsListGroup = ListGroup.<PaymentScheduleItem>create()
                .setSelectable(false);

        paymentScheduleRadioGroup = RadioGroup.create("paymentSchedule")
                .addRadio(Radio.create("SIGHT", "Payment Sight").withGap().check())
                .addRadio(Radio.create("NEGOTIATION", "Negotiation").withGap())
                .addRadio(Radio.create("ACCEPTANCE", "Acceptance at").withGap())
                .addRadio(Radio.create("DEFERRED", "Deferred Payment").withGap())
                .addChangeHandler(selectedRadio -> {
                    if (selectedRadio.getValue().equals("DEFERRED") || selectedRadio.getValue().equals("ACCEPTANCE")) {
                        numberOfDaysColumn.show();
                        paymentScheduleAfterColumn.show();
                        numberOfDaysTextBox.setRequired(true);
                        paymentScheduleAfterSelect.setRequired(true);
                    } else {
                        numberOfDaysColumn.hide();
                        paymentScheduleAfterColumn.hide();
                        numberOfDaysTextBox.setRequired(false);
                        paymentScheduleAfterSelect.setRequired(false);
                    }
                })
                .horizontal();

        paymentScheduleCard = Card.create("Payment Schedule *");
        addButton = Button.createDefault(Icons.ALL.add())
                .setContent("ADD")
                .linkify()
                .style()
                .setMarginTop("-10px")
                .get()
        ;
        paymentScheduleCard.getHeaderBar()
                .appendChild(addButton
                        .addClickListener(evt -> {
                            if (fieldsGrouping.validate().isValid()) {
                                addPaymentSchedule();
                            }
                        }).asElement());


        Row paymentTypeRow = Row.create()
                .addColumn(span12()
                        .appendChild(paymentScheduleRadioGroup));


        Row paymentValuesRow = Row.create()
                .addColumn(span4().appendChild(percentageTextBox))
                .addColumn(numberOfDaysColumn)
                .addColumn(paymentScheduleAfterColumn);

        HTMLDivElement valuesContainer = div()
                .add(paymentTypeRow)
                .add(paymentValuesRow).asElement();

        valuesContainerCollapsible = Collapsible.create(valuesContainer)
                .show();

        paymentSchedulerListGroupRow = Row.create();
        element.appendChild(paymentScheduleCard
                .appendChild(valuesContainer)
                .appendChild(paymentSchedulerListGroupRow
                        .addColumn(Column.span12()
                                .appendChild(paymentScheduleItemsListGroup))
                        .hide()
                )
                .asElement());
    }

    private void addPaymentSchedule() {
        PaymentScheduleItem item = new PaymentScheduleItem();
        item.setType(paymentScheduleRadioGroup.getValue());
        if (paymentScheduleAfterSelect.isRequired())
            item.setAfterIncident(paymentScheduleAfterSelect.getValue());

        if (numberOfDaysTextBox.isRequired())
            item.setNumberOfDays(Integer.parseInt(numberOfDaysTextBox.getValue()));

        item.setPercentage(Integer.parseInt(percentageTextBox.getValue()));
        ListItem<PaymentScheduleItem> listItem = paymentScheduleItemsListGroup.addItem(item, paymentScheduleRadioGroup.getSelectedRadio().getLabel());
        Icon delete = Icons.ALL.delete();
        delete.asElement().addEventListener("click", evt1 -> {
            paymentScheduleItemsListGroup.removeItem(listItem);
            percentageTextBox.setValue(remainingPercentage() + "");
            addButton.show();
            valuesContainerCollapsible.show();
            if (paymentScheduleItemsListGroup.getAllValues().size() == 0) {
                paymentSchedulerListGroupRow.hide();
            }

            revalidate();
        });
        listItem
                .appendChild(delete
                        .style()
                        .add(Styles.pull_right)
                        .setMarginTop("-3px")
                        .setMarginLeft("10px")
                        .asElement());

        if (numberOfDaysTextBox.isRequired()) {
            listItem.appendChild(Badge.create(item.getNumberOfDays() + " days after " + item.getAfterIncident().toLowerCase())
                    .setBackground(Color.GREEN)
                    .style()
                    .add(Styles.pull_right)
                    .asElement());
        }

        listItem.appendChild(Badge.create(item.getPercentage() + "%")
                .setBackground(Color.GREEN)
                .style()
                .add(Styles.pull_right)
                .asElement());

        int remainingPercentage = remainingPercentage();
        if (remainingPercentage == 0) {
            addButton.hide();
            valuesContainerCollapsible.hide();
        } else {
            if (addButton.isHidden())
                addButton.show();
            if (valuesContainerCollapsible.isHidden())
                valuesContainerCollapsible.show();
            percentageTextBox.setValue(remainingPercentage + "");
        }
        numberOfDaysTextBox.clear();
        paymentScheduleAfterSelect.clear();
        paymentSchedulerListGroupRow.show();

        revalidate();

    }

    public void revalidate(){
        if(isInvalidatedCard(paymentScheduleCard) && remainingPercentage()==0){
            markCardValidation(paymentScheduleCard, true, false);
            markWithValidationMessage(true);
        }
    }

    @Override
    public boolean validate() {
        boolean valid = remainingPercentage() == 0;
        markCardValidation(paymentScheduleCard, valid);
        markWithValidationMessage(valid);
        return valid;
    }

    private void markWithValidationMessage(boolean valid) {
        if(!valid){
            paymentScheduleCard.getHeaderDescription().appendChild(validationMessageElement);
        }else{
            validationMessageElement.remove();
        }
    }

    private int remainingPercentage() {
        List<PaymentScheduleItem> allValues = paymentScheduleItemsListGroup.getAllValues();
        return 100 - allValues.stream().mapToInt(PaymentScheduleItem::getPercentage).sum();
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        letterOfCredit.getPaymentSchedule().addAll(paymentScheduleItemsListGroup.getAllValues());
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
