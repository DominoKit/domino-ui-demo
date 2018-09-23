package org.dominokit.domino.steppers.client.views.ui;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.steppers.client.presenters.SteppersPresenter;
import org.dominokit.domino.steppers.client.views.CodeResource;
import org.dominokit.domino.steppers.client.views.SteppersView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.steppers.Step;
import org.dominokit.domino.ui.steppers.Stepper;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;

import static org.dominokit.domino.ui.grid.Column.span12;
import static org.dominokit.domino.ui.grid.Column.span6;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = SteppersPresenter.class)
public class SteppersViewImpl extends ComponentView<HTMLDivElement> implements SteppersView {

    private final HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(LinkToSourceCode.create("steppers", this.getClass()).asElement());
        element.appendChild(BlockHeader.create("STEPPERS").asElement());

        verticalStepper();

        horizontalStepper();
    }

    private void verticalStepper() {
        Stepper stepper = Stepper.create()
                .setColor(Color.INDIGO);


        TextBox nameTextBox = TextBox.create("Name")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.label());

        nameTextBox.getInputElement().addEventListener("keypress", evt -> {
            if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                stepper.next();
            }
        });

        TextBox email = TextBox.create("Email")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.email());

        email.getInputElement().addEventListener("keypress", evt -> {
            if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                stepper.next();
            }
        });

        TextBox phone = ElementUtil.numbersOnly(TextBox.create("Phone"))
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.phone());

        phone.getInputElement().addEventListener("keypress", evt -> {
            if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                stepper.finish();
            }
        });


        Step stepOne = Step.create("Contact name", "Contact name step")
                .setValidator(() -> nameTextBox.validate().isValid())
                .onActivated(step -> nameTextBox.focus())
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(nameTextBox)))
                .appendFooterChild(Row.create()
                        .addColumn(span6().appendChild(Style.of(Button.createPrimary("Next"))
                                .setMinWidth("120px")
                                .setMarginRight("5px")
                                .get()
                                .addClickListener(evt -> stepper.next())
                        )));

        Step stepTow = Step.create("Contact email", "Contact email step")
                .setValidator(() -> email.validate().isValid())
                .onActivated(step -> email.focus())
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(email)))
                .appendFooterChild(Row.create()
                        .addColumn(span6()
                                .appendChild(Style.of(Button.createPrimary("Back"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> stepper.back())))
                        .addColumn(span6()
                                .appendChild(Style.of(Button.createPrimary("Next"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> stepper.next())
                                )));

        Step stepThree = Step.create("Contact phone", "Contact phone step")
                .setValidator(() -> phone.validate().isValid())
                .onActivated(step -> phone.focus())
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(phone)))
                .appendFooterChild(Row.create()
                        .addColumn(span6()
                                .appendChild(Style.of(Button.createPrimary("Back"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> stepper.back())))
                        .addColumn(span6()
                                .appendChild(Style.of(Button.createPrimary("Finish"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> stepper.finish())
                                )));


        stepper
                .appendChild(stepOne)
                .appendChild(stepTow)
                .appendChild(stepThree)
                .setCompletionHandler(() -> Notification.create("All step completed").show());

        element.appendChild(Card.create("VERTICAL STEPPER")
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(stepper)))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.verticalStepper()).asElement());
    }

    private void horizontalStepper() {
        Stepper stepper = Stepper.create()
                .setMinHeight("300px")
                .setHorizontal(true);

        TextBox nameTextBox = TextBox.create("Name")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.label());
        nameTextBox.getInputElement().addEventListener("keypress", evt -> {
            if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                stepper.next();
            }
        });

        TextBox email = TextBox.create("Email")
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.email());

        email.getInputElement().addEventListener("keypress", evt -> {
            if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                stepper.next();
            }
        });

        TextBox phone = ElementUtil.numbersOnly(TextBox.create("Phone"))
                .setRequired(true)
                .setAutoValidation(true)
                .setLeftAddon(Icons.ALL.phone());

        phone.getInputElement().addEventListener("keypress", evt -> {
            if (ElementUtil.isEnterKey(Js.uncheckedCast(evt))) {
                stepper.finish();
            }
        });

        Step stepOne = Step.create("Contact name", "Contact name step")
                .setValidator(() -> nameTextBox.validate().isValid())
                .onActivated(step -> nameTextBox.focus())
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(nameTextBox)))
                .appendFooterChild(Row.create()
                        .addColumn(span12().appendChild(Style.of(Button.createPrimary("Next"))
                                .setMinWidth("120px")
                                .setMarginRight("5px")
                                .get()
                                .addClickListener(evt -> stepper.next())
                        )));

        Step stepTow = Step.create("Contact email", "Contact email step")
                .setValidator(() -> email.validate().isValid())
                .onActivated(step -> email.focus())
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(email)))
                .appendFooterChild(Row.create()
                        .addColumn(span6()
                                .appendChild(Style.of(Button.createPrimary("Back"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> stepper.back()))
                                .appendChild(Style.of(Button.createPrimary("Next"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> stepper.next())
                                )));

        Step stepThree = Step.create("Contact phone", "Contact phone step")
                .setValidator(() -> phone.validate().isValid())
                .onActivated(step -> phone.focus())
                .appendChild(Row.create()
                        .addColumn(span6().appendChild(phone)))
                .appendFooterChild(Row.create()
                        .addColumn(span6()
                                .appendChild(Style.of(Button.createPrimary("Back"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> {
                                            stepper.back();
                                        }))
                                .appendChild(Style.of(Button.createPrimary("Finish"))
                                        .setMinWidth("120px")
                                        .setMarginRight("5px")
                                        .get()
                                        .addClickListener(evt -> stepper.finish())
                                )));


        stepper
                .appendChild(stepOne)
                .appendChild(stepTow)
                .appendChild(stepThree)
                .setCompletionHandler(() -> Notification.create("All step completed").show());

        element.appendChild(Card.create("HORIZONTAL STEPPER")
                .appendChild(Row.create()
                        .addColumn(span12().appendChild(stepper)))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.horizontalStepper()).asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}