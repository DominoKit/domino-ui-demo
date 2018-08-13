package org.dominokit.domino.steppers.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.steppers.client.presenters.SteppersPresenter;
import org.dominokit.domino.steppers.client.steppers.Step;
import org.dominokit.domino.steppers.client.steppers.Stepper;
import org.dominokit.domino.steppers.client.views.SteppersView;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;

import static org.dominokit.domino.ui.column.Column.span12;
import static org.dominokit.domino.ui.column.Column.span6;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = SteppersPresenter.class)
public class SteppersViewImpl extends ComponentView<HTMLDivElement> implements SteppersView {

    private final HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(Alert.warning().appendStrong("Warning: ").appendText("This is still a work in progress").asElement());
        element.appendChild(BlockHeader.create("STEPPERS").asElement());

        Stepper stepper = Stepper.create();

        FieldsGrouping stepOneFieldsGrouping = FieldsGrouping.create();
        FieldsGrouping stepTowFieldsGrouping = FieldsGrouping.create();
        FieldsGrouping stepThreeFieldsGrouping = FieldsGrouping.create();

        TextBox firstNameTextBox = TextBox.create("First name")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.label())
                .groupBy(stepOneFieldsGrouping);

        TextBox lastNameTextBox = TextBox.create("Last name")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.label())
                .groupBy(stepOneFieldsGrouping);

        TextBox emailTextBox = TextBox.create("Email")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.email())
                .groupBy(stepOneFieldsGrouping);

        TextBox phoneNumberTextBox = ElementUtil.numbersOnly(TextBox.create("Phone number"))
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.phone())
                .groupBy(stepOneFieldsGrouping);

        TextBox addressLine1TextBox = TextBox.create("Address line 1")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.location_on())
                .groupBy(stepTowFieldsGrouping);

        TextBox addressLine2TextBox = TextBox.create("Address line 2")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.location_on())
                .groupBy(stepTowFieldsGrouping);

        TextBox cityTextBox = TextBox.create("City")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.location_city())
                .groupBy(stepTowFieldsGrouping);

        TextBox stateTextBox = TextBox.create("State / Province")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.location_city())
                .groupBy(stepTowFieldsGrouping);

        TextBox postalCodeTextBox = TextBox.create("Postal / Zip code")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.label())
                .groupBy(stepTowFieldsGrouping);

        Select<String> countrySelect = Select.<String>create("Country")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.location_city())
                .groupBy(stepTowFieldsGrouping)
                .addOption(SelectOption.create("Jordan", "Jordan"))
                .addOption(SelectOption.create("Qatar", "Qatar"))
                .addOption(SelectOption.create("Italy", "Italy"));

        TextBox organizationTextBox = TextBox.create("Organization")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.domain())
                .groupBy(stepThreeFieldsGrouping);

        TextBox jobTitleTextBox = TextBox.create("Job title")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.domain())
                .groupBy(stepThreeFieldsGrouping);


        HTMLDivElement stepOneContainer = div()
                .add(Row.create()
                        .addColumn(span6().addElement(firstNameTextBox))
                        .addColumn(span6().addElement(lastNameTextBox))
                ).add(Row.create()
                        .addColumn(span6().addElement(emailTextBox))
                        .addColumn(span6().addElement(phoneNumberTextBox))
                ).add(Row.create()
                        .addColumn(span12().addElement(Style.of(Button.createPrimary("Next"))
                                .setMinWidth("120px")
                                .setMarginRight("5px")
                                .get()
                                .addClickListener(evt -> stepper.next())
                        )))
                .asElement();

        HTMLDivElement stepTowContainer = div()
                .add(Row.create()
                        .addColumn(span12().addElement(addressLine1TextBox))
                        .addColumn(span12().addElement(addressLine2TextBox))
                ).add(Row.create()
                        .addColumn(span6().addElement(cityTextBox))
                        .addColumn(span6().addElement(stateTextBox))
                ).add(Row.create()
                        .addColumn(span6().addElement(postalCodeTextBox))
                        .addColumn(span6().addElement(countrySelect))
                ).add(Row.create()
                        .addColumn(span12()
                                .addElement(Style.of(Button.createPrimary("Back"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> stepper.back()))
                                .addElement(Style.of(Button.createPrimary("Next"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> stepper.next())
                                )))
                .asElement();


        HTMLDivElement stepThreeContainer = div()
                .add(Row.create()
                        .addColumn(span6().addElement(organizationTextBox))
                        .addColumn(span6().addElement(jobTitleTextBox))
                ).add(Row.create()
                        .addColumn(span12()
                                .addElement(Style.of(Button.createPrimary("Back"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> {
                                            stepper.back();
                                        }))
                                .addElement(Style.of(Button.createPrimary("Finish"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> stepper.finish())
                                )))
                .asElement();


        Step stepOne = Step.create("Contact info", "Contact basic information")
                .appendChild(stepOneContainer)
                .setValidator(() -> stepOneFieldsGrouping.validate().isValid());
        Step stepTow = Step.create("Address info", "Contact address information")
                .appendChild(stepTowContainer)
                .setValidator(() -> stepTowFieldsGrouping.validate().isValid());
        Step stepThree = Step.create("Organization", "Contact organization and job title")
                .appendChild(stepThreeContainer)
                .setValidator(() -> stepThreeFieldsGrouping.validate().isValid());


        stepper
                .addStep(stepOne)
                .addStep(stepTow)
                .addStep(stepThree)
        .setCompletionHandler(() -> Notification.create("All step completed").show());
        element.appendChild(Card.create()
                .appendChild(Row.create()
                        .addColumn(span6().addElement(stepper)))
                .asElement());

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}