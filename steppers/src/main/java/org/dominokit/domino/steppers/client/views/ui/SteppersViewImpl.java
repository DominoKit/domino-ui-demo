package org.dominokit.domino.steppers.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.steppers.client.presenters.SteppersProxy;
import org.dominokit.domino.steppers.client.views.SteppersView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.stepper.Step;
import org.dominokit.domino.ui.stepper.Stepper;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;

import java.util.function.Function;

import static org.dominokit.domino.ui.grid.Column.span12;
import static org.dominokit.domino.ui.grid.Column.span6;
import static org.jboss.elemento.Elements.*;

@UiView(presentable = SteppersProxy.class)
@SampleClass
public class SteppersViewImpl extends BaseDemoView<HTMLDivElement> implements SteppersView {

    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        element.appendChild(LinkToSourceCode.create("steppers", this.getClass()).element());
        element.appendChild(BlockHeader.create("STEPPERS").element());

        verticalStepper();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.verticalStepper()).element());

        horizontalStepper();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.horizontalStepper()).element());

        customColors();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.customColors()).element());

        customIcons();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.customIcons()).element());

        return element;
    }

    @SampleMethod
    private void verticalStepper() {

        TextBox nameTextBox = TextBox.create("Name")
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.label());


        TextBox emailTextBox = TextBox.create("Email")
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.email());

        TextBox phone = ElementUtil.numbersOnly(TextBox.create("Phone"))
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.phone());

        Button nextButton = Button.createDefault("Next")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        Button prevButton = Button.createDefault("Previous")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        Button finishButton = Button.createDefault("Finish")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        DominoElement<HTMLDivElement> completeContent = DominoElement.div()
                .css(Styles.align_center)
                .appendChild(h(3).textContent("Setup completed!"))
                .appendChild(Icons.ALL.checkbox_multiple_marked_circle_outline_mdi()
                        .size48()
                        .setColor(Color.GREEN)
                );

        Stepper stepper = Stepper.create()
                .addStateChangeListener((oldState, step, stepper1) -> {
                    DomGlobal.console.info("Step state changed : from STEPPER. for STEP : " +step.getIndex() + " old State : " + oldState.name());
                })
                .setDirection(Stepper.StepperDirection.VERTICAL)
                .apply(self -> self
                        .appendChild(Step.create("Contact name", "Contact name step")
//                                .addStateChangeListener((oldState, step, stepper1) -> {
//                                    if(step.isActive()) {
//                                        Notification.create("Step state changed : STEP - 1").show();
//                                    }
//                                })
                                .appendChild(Row.create()
                                        .appendChild(span6()
                                                .appendChild(nameTextBox
                                                        .apply(nameBox -> {
                                                            KeyboardEvents.listenOn(nameBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(nameTextBox::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        nameTextBox.focus();
                                    }
                                })
                        )
                        .appendChild(Step.create("Contact emailTextBox", "Contact emailTextBox step")
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if(step.isActive() && oldState == Stepper.StepState.INACTIVE) {
                                        DomGlobal.console.info("Step state changed : STEP - 2 : for step " +step.getIndex() +" old state : "+oldState.name());
                                    }
                                })
                                .appendChild(Row.create()
                                        .appendChild(span6().appendChild(emailTextBox
                                                        .apply(emailBox -> {
                                                            KeyboardEvents.listenOn(emailBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(emailTextBox::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        emailTextBox.focus();
                                    }
                                })
                        )
                        .appendChild(Step.create("Contact phone", "Contact phone step")
//                                .addStateChangeListener((oldState, step, stepper1) -> {
//                                    Notification.create("Step state changed : STEP - 3").show();
//                                })
                                .appendChild(Row.create()
                                        .appendChild(span6().appendChild(phone
                                                        .apply(phoneBox -> {
                                                            KeyboardEvents.listenOn(phoneBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                            self.complete(completeContent);
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(phone::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        phone.focus();
                                    }
                                })
                        )
                        .setStepFooter(FlexLayout.create()
                                .setJustifyContent(FlexJustifyContent.SPACE_AROUND)
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(prevButton
                                                .hide()
                                                .addClickListener(evt -> {
                                                    self.previous();
                                                })
                                        )
                                )
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(finishButton
                                                .hide()
                                                .addClickListener(evt -> {
                                                    if (self.getActiveStep().validate().isValid()) {
                                                        self.getActiveStep().complete();
                                                        self.complete(completeContent);
                                                    }
                                                }))
                                )
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(nextButton
                                                .addClickListener(evt -> {
                                                    if (self.getActiveStep().validate().isValid()) {
                                                        self.getActiveStep().complete();
                                                    }
                                                }))
                                )
                        )
                        .addStateChangeListener((oldState, step, thisStepper) -> {
                            prevButton.toggleDisplay(!step.isFirstStep());
                            nextButton.toggleDisplay(!step.isLastStep());
                            finishButton.toggleDisplay(step.isLastStep());
                        })
                        .addCompleteListener(thisStepper -> Notification.create("All steps completed").show()));

        element.appendChild(Card.create("VERTICAL STEPPER")
                .appendChild(Row.create()
                        .appendChild(span12().appendChild(stepper)))
                .element());

    }

    @SampleMethod
    private void horizontalStepper() {
        TextBox nameTextBox = TextBox.create("Name")
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.label());


        TextBox emailTextBox = TextBox.create("Email")
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.email());

        TextBox phone = ElementUtil.numbersOnly(TextBox.create("Phone"))
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.phone());

        Button nextButton = Button.createDefault("Next")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        Button prevButton = Button.createDefault("Previous")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        Button finishButton = Button.createDefault("Finish")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        DominoElement<HTMLDivElement> completeContent = DominoElement.div()
                .css(Styles.align_center)
                .appendChild(h(3).textContent("Setup completed!"))
                .appendChild(Icons.ALL.checkbox_multiple_marked_circle_outline_mdi()
                        .size48()
                        .setColor(Color.GREEN)
                );

        Stepper stepper = Stepper.create()
                .apply(self -> self
                        .appendChild(Step.create("Contact name", "Contact name step", Stepper.StepState.ACTIVE)
                                .appendChild(Row.create()
                                        .appendChild(span6()
                                                .appendChild(nameTextBox
                                                        .apply(nameBox -> {
                                                            KeyboardEvents.listenOn(nameBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(nameTextBox::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        nameTextBox.focus();
                                    }
                                })
                        )
                        .appendChild(Step.create("Contact emailTextBox", "Contact emailTextBox step")
                                .appendChild(Row.create()
                                        .appendChild(span6().appendChild(emailTextBox
                                                        .apply(emailBox -> {
                                                            KeyboardEvents.listenOn(emailBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(emailTextBox::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        emailTextBox.focus();
                                    }
                                })
                        )
                        .appendChild(Step.create("Contact phone", "Contact phone step")
                                .disable()
                                .appendChild(Row.create()
                                        .appendChild(span6().appendChild(phone
                                                        .apply(phoneBox -> {
                                                            KeyboardEvents.listenOn(phoneBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                            self.complete(completeContent);
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(phone::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        phone.focus();
                                    }
                                })
                        )
                        .setStepFooter(FlexLayout.create()
                                .setJustifyContent(FlexJustifyContent.SPACE_AROUND)
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(prevButton
                                                .hide()
                                                .addClickListener(evt -> {
                                                    self.previous();
                                                })
                                        )
                                )
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(finishButton
                                                .hide()
                                                .addClickListener(evt -> {
                                                    if (self.getActiveStep().validate().isValid()) {
                                                        self.getActiveStep().complete();
                                                        self.complete(completeContent);
                                                    }
                                                }))
                                )
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(nextButton
                                                .addClickListener(evt -> {
                                                    if (self.getActiveStep().validate().isValid()) {
                                                        self.getActiveStep().complete();
                                                    }
                                                }))
                                )
                        )
                        .addStateChangeListener((oldState, step, thisStepper) -> {
                            prevButton.toggleDisplay(!step.isFirstStep());
                            nextButton.toggleDisplay(!step.isLastStep());
                            finishButton.toggleDisplay(step.isLastStep());
                        })
                        .addCompleteListener(thisStepper -> Notification.create("All steps completed").show()));

        element.appendChild(Card.create("HORIZONTAL STEPPER")
                .appendChild(Row.create()
                        .addColumn(span12().appendChild(Button.create("test action")
                                .addClickListener(evt -> {
                                    stepper.reset();
                                })
                        )))
                .appendChild(Row.create()
                        .addColumn(span12().appendChild(stepper)))
                .element());
    }

    @SampleMethod
    private void customColors() {
        TextBox nameTextBox = TextBox.create("Name")
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.label());


        TextBox emailTextBox = TextBox.create("Email")
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.email());

        TextBox phone = ElementUtil.numbersOnly(TextBox.create("Phone"))
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.phone());

        Button nextButton = Button.createDefault("Next")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        Button prevButton = Button.createDefault("Previous")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        Button finishButton = Button.createDefault("Finish")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        DominoElement<HTMLDivElement> completeContent = DominoElement.div()
                .css(Styles.align_center)
                .appendChild(h(3).textContent("Setup completed!"))
                .appendChild(Icons.ALL.checkbox_multiple_marked_circle_outline_mdi()
                        .size48()
                        .setColor(Color.GREEN)
                );

        Stepper stepper = Stepper.create()
                .setStepStateColors(new Stepper.StepStateColors() {
                    @Override
                    public Color inactive() {
                        return Color.BLACK;
                    }

                    @Override
                    public Color active() {
                        return Color.TEAL;
                    }

                    @Override
                    public Color error() {
                        return Color.PINK;
                    }

                    @Override
                    public Color completed() {
                        return Color.BLUE;
                    }

                    @Override
                    public Color disabled() {
                        return Color.BLUE_GREY;
                    }
                })
                .apply(self -> self
                        .appendChild(Step.create("Contact name", "Contact name step")
                                .appendChild(Row.create()
                                        .appendChild(span6()
                                                .appendChild(nameTextBox
                                                        .apply(nameBox -> {
                                                            KeyboardEvents.listenOn(nameBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(nameTextBox::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        nameTextBox.focus();
                                    }
                                })
                        )
                        .appendChild(Step.create("Contact emailTextBox", "Contact emailTextBox step")
                                .disable()
                                .appendChild(Row.create()
                                        .appendChild(span6().appendChild(emailTextBox
                                                        .apply(emailBox -> {
                                                            KeyboardEvents.listenOn(emailBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(emailTextBox::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        emailTextBox.focus();
                                    }
                                })
                        )
                        .appendChild(Step.create("Contact phone", "Contact phone step")
                                .appendChild(Row.create()
                                        .appendChild(span6().appendChild(phone
                                                        .apply(phoneBox -> {
                                                            KeyboardEvents.listenOn(phoneBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                            self.complete(completeContent);
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(phone::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        phone.focus();
                                    }
                                })
                        )
                        .setStepFooter(FlexLayout.create()
                                .setJustifyContent(FlexJustifyContent.SPACE_AROUND)
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(prevButton
                                                .hide()
                                                .addClickListener(evt -> {
                                                    self.previous();
                                                })
                                        )
                                )
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(finishButton
                                                .hide()
                                                .addClickListener(evt -> {
                                                    if (self.getActiveStep().validate().isValid()) {
                                                        self.getActiveStep().complete();
                                                        self.complete(completeContent);
                                                    }
                                                }))
                                )
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(nextButton
                                                .addClickListener(evt -> {
                                                    if (self.getActiveStep().validate().isValid()) {
                                                        self.getActiveStep().complete();
                                                    }
                                                }))
                                )
                        )
                        .addStateChangeListener((oldState, step, thisStepper) -> {
                            prevButton.toggleDisplay(!step.isFirstStep());
                            nextButton.toggleDisplay(!step.isLastStep());
                            finishButton.toggleDisplay(step.isLastStep());
                        })
                        .addCompleteListener(thisStepper -> Notification.create("All steps completed").show()));

        element.appendChild(Card.create("CUSTOM COLORS STEPPER")
                .appendChild(Row.create()
                        .addColumn(span12().appendChild(stepper)))
                .element());
    }

    @SampleMethod
    private void customIcons() {
        TextBox nameTextBox = TextBox.create("Name")
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.label());


        TextBox emailTextBox = TextBox.create("Email")
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.email());

        TextBox phone = ElementUtil.numbersOnly(TextBox.create("Phone"))
                .setRequired(true)
                .setAutoValidation(true)
                .setFixErrorsPosition(true)
                .addLeftAddOn(Icons.ALL.phone());

        Button nextButton = Button.createDefault("Next")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        Button prevButton = Button.createDefault("Previous")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        Button finishButton = Button.createDefault("Finish")
                .linkify()
                .styler(style -> style
                        .setMinWidth("120px")
                        .add(Styles.m_l_5, Styles.m_r_5)
                );

        DominoElement<HTMLDivElement> completeContent = DominoElement.div()
                .css(Styles.align_center)
                .appendChild(h(3).textContent("Setup completed!"))
                .appendChild(Icons.ALL.checkbox_multiple_marked_circle_outline_mdi()
                        .size48()
                        .setColor(Color.GREEN)
                );

        Function<Step, DominoElement<HTMLElement>> stepIconSupplier = (step) -> DominoElement.of(span())
                .apply(self -> {
                    if(step.getIndex() ==0){
                        self.appendChild(Icons.ALL.account_mdi().size18());
                    }else if(step.getIndex() ==1){
                        self.appendChild(Icons.ALL.contact_mail_mdi().size18());
                    }else {
                        self.appendChild(Icons.ALL.contact_phone_mdi().size18());
                    }
                });

        Stepper stepper = Stepper.create()
                .setStepNumberRenderer(new Stepper.StepNumberRenderer() {
                    @Override
                    public Node inactiveElement(Step step, Stepper.StepStateColors stepStateColors) {
                        return stepIconSupplier.apply(step)
                                .css(stepStateColors.inactive().getBackground())
                                .element();
                    }

                    @Override
                    public Node activeElement(Step step, Stepper.StepStateColors stepStateColors) {
                        return stepIconSupplier.apply(step)
                                .css(stepStateColors.active().getBackground())
                                .element();
                    }

                    @Override
                    public Node errorElement(Step step, Stepper.StepStateColors stepStateColors) {
                        return stepIconSupplier.apply(step)
                                .css(stepStateColors.error().getBackground())
                                .element();
                    }

                    @Override
                    public Node completedElement(Step step, Stepper.StepStateColors stepStateColors) {
                        return stepIconSupplier.apply(step)
                                .css(stepStateColors.completed().getBackground())
                                .element();
                    }

                    @Override
                    public Node disabledElement(Step step, Stepper.StepStateColors stepStateColors) {
                        return stepIconSupplier.apply(step)
                                .css(stepStateColors.disabled().getBackground())
                                .element();
                    }
                })
                .apply(self -> self
                        .appendChild(Step.create("Contact name", "Contact name step")
                                .appendChild(Row.create()
                                        .appendChild(span6()
                                                .appendChild(nameTextBox
                                                        .apply(nameBox -> {
                                                            KeyboardEvents.listenOn(nameBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(nameTextBox::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        nameTextBox.focus();
                                    }
                                })
                        )
                        .appendChild(Step.create("Contact emailTextBox", "Contact emailTextBox step")
                                .appendChild(Row.create()
                                        .appendChild(span6().appendChild(emailTextBox
                                                        .apply(emailBox -> {
                                                            KeyboardEvents.listenOn(emailBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(emailTextBox::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        emailTextBox.focus();
                                    }
                                })
                        )
                        .appendChild(Step.create("Contact phone", "Contact phone step")
                                .appendChild(Row.create()
                                        .appendChild(span6().appendChild(phone
                                                        .apply(phoneBox -> {
                                                            KeyboardEvents.listenOn(phoneBox.getInputElement())
                                                                    .onEnter(evt -> {
                                                                        if (self.getActiveStep().validate().isValid()) {
                                                                            self.getActiveStep().complete();
                                                                            self.complete(completeContent);
                                                                        }
                                                                    });
                                                        })
                                                )
                                        )
                                )
                                .addValidator(phone::validate)
                                .addStateChangeListener((oldState, step, stepper1) -> {
                                    if (step.isActive()) {
                                        phone.focus();
                                    }
                                })
                        )
                        .setStepFooter(FlexLayout.create()
                                .setJustifyContent(FlexJustifyContent.SPACE_AROUND)
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(prevButton
                                                .hide()
                                                .addClickListener(evt -> {
                                                    self.previous();
                                                })
                                        )
                                )
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(finishButton
                                                .hide()
                                                .addClickListener(evt -> {
                                                    if (self.getActiveStep().validate().isValid()) {
                                                        self.getActiveStep().complete();
                                                        self.complete(completeContent);
                                                    }
                                                }))
                                )
                                .appendChild(FlexItem.create()
                                        .css(Styles.align_center)
                                        .appendChild(nextButton
                                                .addClickListener(evt -> {
                                                    if (self.getActiveStep().validate().isValid()) {
                                                        self.getActiveStep().complete();
                                                    }
                                                }))
                                )
                        )
                        .addStateChangeListener((oldState, step, thisStepper) -> {
                            prevButton.toggleDisplay(!step.isFirstStep());
                            nextButton.toggleDisplay(!step.isLastStep());
                            finishButton.toggleDisplay(step.isLastStep());
                        })
                        .addCompleteListener(thisStepper -> Notification.create("All steps completed").show()));

        element.appendChild(Card.create("CUSTOM ICONS STEPPER")
                .appendChild(Row.create()
                        .addColumn(span12().appendChild(stepper)))
                .element());
    }
}