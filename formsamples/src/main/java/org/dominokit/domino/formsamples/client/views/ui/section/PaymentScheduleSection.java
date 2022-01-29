package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.client.views.ui.Constants;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.formsamples.shared.model.PaymentScheduleItem;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.Radio;
import org.dominokit.domino.ui.forms.RadioGroup;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.List;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.dominokit.domino.ui.grid.Column.span12;
import static org.dominokit.domino.ui.grid.Column.span4;
import static org.dominokit.domino.ui.utils.ElementUtil.numbersOnly;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.i;
import static org.jboss.elemento.Elements.small;

public class PaymentScheduleSection implements ImportSection {

    private final HTMLElement validationMessageElement = small().textContent("Total payment schedules should be 100%").css(Color.RED.getStyle()).element();
    private TextBox numberOfDaysTextBox;
    private Select<String> paymentScheduleAfterSelect;
    private TextBox percentageTextBox;
    private RadioGroup<String> paymentScheduleRadioGroup;
    private ListGroup<PaymentScheduleItem> paymentScheduleItemsListGroup;
    private Button addButton;
    private Collapsible valuesContainerCollapsible;
    private Card paymentScheduleCard;
    private HTMLDivElement element = div().element();
    private FieldsGrouping fieldsGrouping = FieldsGrouping.create();
    private final Row paymentSchedulerListGroupRow;

    public PaymentScheduleSection() {

        numberOfDaysTextBox = numbersOnly(TextBox.create("No. Of Days")
                .addLeftAddOn(Icons.ALL.looks_one())
                .setHelperText(Constants.NUMBERS_ONLY))
                .groupBy(fieldsGrouping)
                .setAutoValidation(true);

        Column numberOfDaysColumn = span4()
                .appendChild(numberOfDaysTextBox).hide();

        paymentScheduleAfterSelect = Select.<String>create("After").appendChild(SelectOption.create("Presentation Of Documents", "Presentation Of Documents"))
                .appendChild(SelectOption.create("Bill Of Lading Date", "Bill Of Lading Date"))
                .appendChild(SelectOption.create("Commercial Invoice", "Commercial Invoice"))
                .addLeftAddOn(Icons.ALL.redo())
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
                .addLeftAddOn(i().css("fas", "fa-percent", "fa-sm"))
                .addValidator(() -> {
                    int percentage = Integer.parseInt(percentageTextBox.getValue());
                    int remainingPercentage = remainingPercentage();
                    if (percentage > 0 && percentage <= remainingPercentage) {
                        return ValidationResult.valid();
                    }
                    return ValidationResult.invalid("Maximum allowed percentage is " + remainingPercentage);
                });

        paymentSchedulerListGroupRow = Row.create();

        paymentScheduleItemsListGroup = ListGroup.<PaymentScheduleItem>create()
                .setItemRenderer((listGroup, listItem) -> {
                    Icon delete = Icons.ALL.delete()
                            .clickable()
                            .styler(style -> style
                                    .setMarginTop("-3px")
                                    .setMarginLeft("10px")
                            )
                            .addEventListener("click", evt1 -> {
                                paymentScheduleItemsListGroup.removeItem(listItem);
                                percentageTextBox.setValue(remainingPercentage() + "");
                                addButton.show();
                                valuesContainerCollapsible.show();
                                if (listGroup.getValues().size() == 0) {
                                    paymentSchedulerListGroupRow.hide();
                                }

                                revalidate();
                            });
                    FlexLayout flexLayout = FlexLayout.create()
                            .css(Styles.padding_10);
                    listItem
                            .appendChild(flexLayout
                                    .appendChild(FlexItem.create()
                                            .setFlexGrow(1)
                                            .appendChild(TextNode.of(paymentScheduleRadioGroup.getSelectedRadio().getLabel().get()))
                                    )
                                    .appendChild(FlexItem.create()
                                            .appendChild(delete)
                                    )
                            );

                    if (numberOfDaysTextBox.isRequired()) {
                        flexLayout.appendChild(FlexItem.create()
                                .appendChild(Badge.create(listItem.getValue().getNumberOfDays() + " days after " + listItem.getValue().getAfterIncident().toLowerCase())
                                        .setBackground(Color.GREEN)
                                ));
                    }

                    flexLayout.appendChild(FlexItem.create()
                            .appendChild(Badge.create(listItem.getValue().getPercentage() + "%")
                                    .setBackground(Color.GREEN)));

                });

        paymentScheduleRadioGroup = RadioGroup.<String>create("paymentSchedule")
                .appendChild(Radio.create("SIGHT", "Payment Sight").withGap().check())
                .appendChild(Radio.create("NEGOTIATION", "Negotiation").withGap())
                .appendChild(Radio.create("ACCEPTANCE", "Acceptance at").withGap())
                .appendChild(Radio.create("DEFERRED", "Deferred Payment").withGap())
                .addChangeHandler(value -> {
                    if (value.equals("DEFERRED") || value.equals("ACCEPTANCE")) {
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
                        }).element());


        Row paymentTypeRow = Row.create()
                .addColumn(span12()
                        .appendChild(paymentScheduleRadioGroup));


        Row paymentValuesRow = Row.create()
                .addColumn(span4().appendChild(percentageTextBox))
                .addColumn(numberOfDaysColumn)
                .addColumn(paymentScheduleAfterColumn);

        HTMLDivElement valuesContainer = div()
                .add(paymentTypeRow)
                .add(paymentValuesRow).element();

        valuesContainerCollapsible = Collapsible.create(valuesContainer)
                .show();


        element.appendChild(paymentScheduleCard
                .appendChild(valuesContainer)
                .appendChild(paymentSchedulerListGroupRow
                        .addColumn(Column.span12()
                                .appendChild(paymentScheduleItemsListGroup))
                        .hide()
                )
                .element());
    }

    private void addPaymentSchedule() {
        PaymentScheduleItem item = new PaymentScheduleItem();
        item.setType(paymentScheduleRadioGroup.getValue());
        if (paymentScheduleAfterSelect.isRequired())
            item.setAfterIncident(paymentScheduleAfterSelect.getValue());

        if (numberOfDaysTextBox.isRequired())
            item.setNumberOfDays(Integer.parseInt(numberOfDaysTextBox.getValue()));

        item.setPercentage(Integer.parseInt(percentageTextBox.getValue()));
        paymentScheduleItemsListGroup.addItem(item);


        int remainingPercentage = remainingPercentage();
        if (remainingPercentage == 0) {
            addButton.hide();
            valuesContainerCollapsible.hide();
        } else {
            if (addButton.isCollapsed())
                addButton.show();
            if (valuesContainerCollapsible.isCollapsed())
                valuesContainerCollapsible.show();
            percentageTextBox.setValue(remainingPercentage + "");
        }
        numberOfDaysTextBox.clear();
        paymentScheduleAfterSelect.clear();
        paymentSchedulerListGroupRow.show();

        revalidate();

    }

    public void revalidate() {
        if (isInvalidatedCard(paymentScheduleCard) && remainingPercentage() == 0) {
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
        if (!valid) {
            paymentScheduleCard.getHeaderDescription().appendChild(validationMessageElement);
        } else {
            validationMessageElement.remove();
        }
    }

    private int remainingPercentage() {
        List<PaymentScheduleItem> allValues = paymentScheduleItemsListGroup.getValues();
        return 100 - allValues.stream().mapToInt(PaymentScheduleItem::getPercentage).sum();
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        letterOfCredit.getPaymentSchedule().addAll(paymentScheduleItemsListGroup.getValues());
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
