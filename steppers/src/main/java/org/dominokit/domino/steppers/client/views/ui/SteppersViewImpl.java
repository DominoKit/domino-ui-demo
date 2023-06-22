package org.dominokit.domino.steppers.client.views.ui;

import elemental2.dom.HTMLDivElement;
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
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.CustomEvents;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.stepper.*;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import java.util.Objects;

@UiView(presentable = SteppersProxy.class)
@SampleClass
public class SteppersViewImpl extends BaseDemoView<HTMLDivElement> implements SteppersView {

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";
    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("steppers", this.getClass()));
        element.appendChild(BlockHeader.create("STEPPERS"));

        horizontalStepperTrack();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.horizontalStepperTrack()));
        verticalStepperTrack();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.verticalStepperTrack()));
        horizontalStepper();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.horizontalStepper()));
        verticalStepper();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.verticalStepper()));

        return element.element();
    }

    @SampleMethod
    private void horizontalStepperTrack() {
        StepperTrack simpleTrack;
        StepperTrack withText;
        StepperTrack withTextReversed;
        StepperTrack withAddons;
        StepTracker.TrackerListener trackerListener = (tracker, state) -> {
            Notification.create("Tracker [" + tracker.getKey() + "] changed state to [" + state.getKey() + "], active : " + tracker.isActive())
                    .setDismissible(true)
                    .show();
        };
        element
                .appendChild(Card.create("HORIZONTAL STEPPER TRACK")
                        .setCollapsible(true)
                        .appendChild(BlockHeader.create("SIMPLE").addCss(dui_m_y_8))
                        .appendChild(simpleTrack = StepperTrack.create()
                                .addCss(dui_m_y_4)
                                .appendChild(StepTracker.create("Step 1")
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 2")
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 3")
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 4")
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 5")
                                        .disable()
                                        .setState(StepState.DISABLED)
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 6")
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create("Step 7")
                                        .addStateListener(trackerListener)
                                )
                                .start(StepState.ACTIVE)
                        )
                        .appendChild(div()
                                .addCss(dui_flex, dui_justify_center, dui_gap_4)
                                .appendChild(Button.create("Previous").addClickListener(evt -> {
                                    simpleTrack.prev((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                    simpleTrack.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                    simpleTrack.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                    simpleTrack.next(1, (deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                    simpleTrack.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                    simpleTrack.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                        )
                        .appendChild(BlockHeader.create("WITH TEXT").addCss(dui_m_y_8))
                        .appendChild(withText = StepperTrack.create()
                                .addCss(dui_m_y_4)
                                .appendChild(StepTracker.create()
                                        .appendChild(p("1. Step one").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("2. Step two").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("3. Step three").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("4. Step four").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("5. Step five").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                        .disable()
                                        .setState(StepState.DISABLED)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("6. Step Six").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("7. Step seven").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .start(StepState.ACTIVE)
                        )
                        .appendChild(div()
                                .addCss(dui_flex, dui_justify_center, dui_gap_4)
                                .appendChild(Button.create("Previous").addClickListener(evt -> {
                                    withText.prev((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                    withText.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                    withText.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                    withText.next(1, (deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                    withText.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                    withText.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))

                        )
                        .appendChild(BlockHeader.create("WITH TEXT POSITION REVERSED").addCss(dui_m_y_8))
                        .appendChild(withTextReversed = StepperTrack.create()
                                .addCss(dui_m_y_4)
                                .setTextPositionReversed(true)
                                .appendChild(StepTracker.create()
                                        .appendChild(p("1. Step one").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("2. Step two").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("3. Step three").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("4. Step four").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("5. Step five").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                        .disable()
                                        .setState(StepState.DISABLED)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("6. Step Six").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(p("7. Step seven").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .start(StepState.ACTIVE)
                        )
                        .appendChild(div()
                                .addCss(dui_flex, dui_justify_center, dui_gap_4)
                                .appendChild(Button.create("Previous").addClickListener(evt -> {
                                    withTextReversed.prev((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                    withTextReversed.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                    withTextReversed.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                    withTextReversed.next(1, (deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                    withTextReversed.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                    withTextReversed.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))

                        )
                        .appendChild(BlockHeader.create("WITH ADDONS").addCss(dui_m_y_8))
                        .appendChild(withAddons = StepperTrack.create()
                                .addCss(dui_m_y_4)
                                .appendChild(StepTracker.create()
                                        .appendChild(PrefixAddOn.of(span().textContent("1.").addCss(dui_m_2)))
                                        .appendChild(PostfixAddOn.of(Icons.account().addCss(dui_fg_accent, dui_m_2)))
                                        .appendChild(p("Personal info").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(PrefixAddOn.of(span().textContent("2.").addCss(dui_m_2)))
                                        .appendChild(PostfixAddOn.of(Icons.phone().addCss(dui_fg_accent, dui_m_2)))
                                        .appendChild(p("Contact info").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(PrefixAddOn.of(span().textContent("3.").addCss(dui_m_2)))
                                        .appendChild(PostfixAddOn.of(Icons.map_marker_account().addCss(dui_fg_accent, dui_m_2)))
                                        .appendChild(p("Address").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(PrefixAddOn.of(span().textContent("4.").addCss(dui_m_2)))
                                        .appendChild(PostfixAddOn.of(Icons.cloud_upload().addCss(dui_fg_accent, dui_m_2)))
                                        .appendChild(p("Photo upload").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .appendChild(StepTracker.create()
                                        .appendChild(PrefixAddOn.of(span().textContent("5.").addCss(dui_m_2)))
                                        .appendChild(PostfixAddOn.of(Icons.shield_check().addCss(dui_fg_accent, dui_m_2)))
                                        .appendChild(p("Verification").addCss(dui_m_0, dui_p_l_2))
                                        .addStateListener(trackerListener)
                                )
                                .start(StepState.ACTIVE)
                        )
                        .appendChild(div()
                                .addCss(dui_flex, dui_justify_center, dui_gap_4)
                                .appendChild(Button.create("Previous").addClickListener(evt -> {
                                    withAddons.prev((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                    withAddons.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                    withAddons.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                    withAddons.next(1, (deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                    withAddons.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                                .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                    withAddons.next((deactivated, activated) -> {
                                        deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                    });
                                }))
                        )
                );
    }

    @SampleMethod
    private void verticalStepperTrack() {
        StepperTrack simpleTrack;
        StepperTrack withText;
        StepperTrack withTextReversed;
        StepperTrack withAddons;
        element
                .appendChild(Card.create("VERTICAL STEPPER TRACK")
                        .setCollapsible(true)
                        .appendChild(Row.create()
                                .appendChild(Column.span6()
                                        .appendChild(BlockHeader.create("SIMPLE").addCss(dui_m_y_8))
                                        .appendChild(div()
                                                .addCss(dui_flex, dui_gap_4)
                                                .appendChild(simpleTrack = StepperTrack.create()
                                                        .setCssProperty("height", "800px")
                                                        .addCss(dui_vertical, dui_m_y_4)
                                                        .appendChild(StepTracker.create())
                                                        .appendChild(StepTracker.create())
                                                        .appendChild(StepTracker.create())
                                                        .appendChild(StepTracker.create())
                                                        .appendChild(StepTracker.create()
                                                                .disable()
                                                                .setState(StepState.DISABLED)
                                                        )
                                                        .appendChild(StepTracker.create())
                                                        .appendChild(StepTracker.create())
                                                        .start(StepState.ACTIVE)
                                                )
                                                .appendChild(div()
                                                        .addCss(dui_flex, dui_justify_center, dui_gap_4, dui_flex_col)
                                                        .appendChild(Button.create("Previous").addClickListener(evt -> {
                                                            simpleTrack.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                                            simpleTrack.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                                            simpleTrack.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                                            simpleTrack.next(1, (deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                                            simpleTrack.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                                            simpleTrack.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                )
                                        )
                                )
                                .appendChild(Column.span6()
                                        .appendChild(BlockHeader.create("WITH TEXT").addCss(dui_m_y_8))
                                        .appendChild(div()
                                                .addCss(dui_flex, dui_gap_4)
                                                .appendChild(withText = StepperTrack.create()
                                                        .setCssProperty("height", "800px")
                                                        .addCss(dui_vertical, dui_m_y_4)
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("1. Step one").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("2. Step two").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("3. Step three").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("4. Step four").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("5. Step five").addCss(dui_m_0, dui_p_l_2))
                                                                .disable()
                                                                .setState(StepState.DISABLED)
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("6. Step Six").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("7. Step seven").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .start(StepState.ACTIVE)
                                                )
                                                .appendChild(div()
                                                        .addCss(dui_flex, dui_justify_center, dui_gap_4, dui_flex_col)
                                                        .appendChild(Button.create("Previous").addClickListener(evt -> {
                                                            withText.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                                            withText.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                                            withText.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                                            withText.next(1, (deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                                            withText.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                                            withText.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))

                                                )
                                        )
                                )

                        )
                        .appendChild(Row.create()
                                .appendChild(Column.span6()
                                        .appendChild(BlockHeader.create("WITH TEXT POSITION REVERSED").addCss(dui_m_y_8))
                                        .appendChild(div()
                                                .addCss(dui_flex, dui_gap_4)
                                                .appendChild(withTextReversed = StepperTrack.create()
                                                        .setCssProperty("height", "800px")
                                                        .setTextPositionReversed(true)
                                                        .addCss(dui_vertical, dui_m_y_4)
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step one 1.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step two 2.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step three 3.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step four 4.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step five 5.").addCss(dui_m_0, dui_p_l_2))
                                                                .disable()
                                                                .setState(StepState.DISABLED)
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step Six 6.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(p("Step seven 7.").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .start(StepState.ACTIVE)
                                                )
                                                .appendChild(div()
                                                        .addCss(dui_flex, dui_justify_center, dui_gap_4, dui_flex_col)
                                                        .appendChild(Button.create("Previous").addClickListener(evt -> {
                                                            withTextReversed.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                                            withTextReversed.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                                            withTextReversed.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                                            withTextReversed.next(1, (deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                                            withTextReversed.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                                            withTextReversed.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                )
                                        )
                                )
                                .appendChild(Column.span6()
                                        .appendChild(BlockHeader.create("WITH ADDONS").addCss(dui_m_y_8))
                                        .appendChild(div()
                                                .addCss(dui_flex, dui_gap_4)
                                                .appendChild(withAddons = StepperTrack.create()
                                                        .setCssProperty("height", "800px")
                                                        .addCss(dui_vertical, dui_m_y_4)
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(PrefixAddOn.of(span().textContent("1.").addCss(dui_m_2)))
                                                                .appendChild(PostfixAddOn.of(Icons.account().addCss(dui_fg_accent, dui_m_2)))
                                                                .appendChild(p("Personal info").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(PrefixAddOn.of(span().textContent("2.").addCss(dui_m_2)))
                                                                .appendChild(PostfixAddOn.of(Icons.phone().addCss(dui_fg_accent, dui_m_2)))
                                                                .appendChild(p("Contact info").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(PrefixAddOn.of(span().textContent("3.").addCss(dui_m_2)))
                                                                .appendChild(PostfixAddOn.of(Icons.map_marker_account().addCss(dui_fg_accent, dui_m_2)))
                                                                .appendChild(p("Address").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(PrefixAddOn.of(span().textContent("4.").addCss(dui_m_4)))
                                                                .appendChild(PostfixAddOn.of(Icons.cloud_upload().addCss(dui_fg_accent, dui_m_2)))
                                                                .appendChild(p("Photo upload").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                        .appendChild(StepTracker.create()
                                                                .appendChild(PrefixAddOn.of(span().textContent("5.").addCss(dui_m_2)))
                                                                .appendChild(PostfixAddOn.of(Icons.shield_check().addCss(dui_fg_accent, dui_m_2)))
                                                                .appendChild(p("Verification").addCss(dui_m_0, dui_p_l_2))
                                                        )
                                                )
                                                .appendChild(div()
                                                        .addCss(dui_flex, dui_justify_center, dui_gap_4, dui_flex_col)
                                                        .appendChild(Button.create("Previous").addClickListener(evt -> {
                                                            withAddons.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and next").addClickListener(evt -> {
                                                            withAddons.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Complete and Skip next").addClickListener(evt -> {
                                                            withAddons.getNextTracker().ifPresent(stepTracker -> stepTracker.setState(StepState.SKIPPED));
                                                            withAddons.next(1, (deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.COMPLETED));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Warning and next").addClickListener(evt -> {
                                                            withAddons.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.WARNING));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                        .appendChild(Button.create("Error and next").addClickListener(evt -> {
                                                            withAddons.next((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> stepTracker.setState(StepState.ERROR));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        }))
                                                )
                                        )
                                )
                        )

                );
    }

    @SampleMethod
    private void horizontalStepper() {
        element.appendChild(Card.create("HORIZONTAL STEPPER")
                .setCollapsible(true)
                .appendChild(Stepper.create()
                        .addCss(dui_reversed)
                        .appendChild(Step.create("Name and Nickname")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("1. Personal info").addCss(dui_m_0, dui_p_l_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.account()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Name and nickname will be used in notifications and user info.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    TextBox firstName = TextBox.create("First name")
                                            .groupBy(stepGroup);
                                    TextBox lastName = TextBox.create("Last name")
                                            .groupBy(stepGroup);
                                    TextBox nickname = TextBox.create("Nickname")
                                            .groupBy(stepGroup);
                                    stepGroup.setRequired(true);

                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_p_x_48, dui_items_center, dui_justify_center, dui_flex_col)
                                                    .appendChild(firstName)
                                                    .appendChild(lastName)
                                                    .appendChild(nickname)
                                            );

                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_flex, dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Next")
                                                        .addCss(dui_success, dui_w_24)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                step.next((deactivated, activated) -> {
                                                                    deactivated.ifPresent(stepTracker -> step.setState(StepState.COMPLETED));
                                                                    activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                });
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .appendChild(Step.create("Residency location")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("2. Address").addCss(dui_m_0, dui_p_l_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.map_marker()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Will be used for shipments.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    TextBox country = TextBox.create("Country")
                                            .groupBy(stepGroup);
                                    TextBox city = TextBox.create("City")
                                            .groupBy(stepGroup);
                                    TextBox zipCode = TextBox.create("ZIP Code")
                                            .setHelperText("Leave empty to mark step with warning.");
                                    stepGroup.setRequired(true);
                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        zipCode.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });
                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_p_x_48, dui_items_center, dui_justify_center, dui_flex_col)
                                                    .appendChild(country)
                                                    .appendChild(city)
                                                    .appendChild(zipCode)
                                            );

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Back")
                                                        .setIcon(Icons.arrow_left())
                                                        .addClickListener(evt -> {
                                                            step.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> step.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        })
                                                )
                                                .appendChild(Button.create("Next")
                                                        .addCss(dui_success)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                if (zipCode.isEmpty()) {
                                                                    step.next((deactivated, activated) -> {
                                                                        deactivated.ifPresent(stepTracker -> step.setState(StepState.WARNING));
                                                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                    });
                                                                } else {
                                                                    step.next((deactivated, activated) -> {
                                                                        deactivated.ifPresent(stepTracker -> step.setState(StepState.COMPLETED));
                                                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                    });
                                                                }
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .appendChild(Step.create("Notification channels")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("3. Contact information").addCss(dui_m_0, dui_p_l_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.phone()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Will be used for notifications and verification.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    EmailBox email = EmailBox.create("Email")
                                            .groupBy(stepGroup);
                                    TelephoneBox phone = TelephoneBox.create("Phone number")
                                            .groupBy(stepGroup);
                                    stepGroup.setRequired(true);
                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });
                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_p_x_48, dui_items_center, dui_justify_center, dui_flex_col)
                                                    .appendChild(email)
                                                    .appendChild(phone)
                                            );

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Back")
                                                        .setIcon(Icons.arrow_left())
                                                        .addClickListener(evt -> {
                                                            step.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> step.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        })
                                                )
                                                .appendChild(Button.create("Next")
                                                        .addCss(dui_success)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                step.next((deactivated, activated) -> {
                                                                    deactivated.ifPresent(stepTracker -> step.setState(StepState.COMPLETED));
                                                                    activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                });
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .appendChild(Step.create("Account protection")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("4. Security").addCss(dui_m_0, dui_p_l_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.shield()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Will be used for login and verification.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    PasswordBox password = PasswordBox.create("Password")
                                            .groupBy(stepGroup);
                                    PasswordBox confirm = PasswordBox.create("Confirm password")
                                            .groupBy(stepGroup);
                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });
                                    stepGroup
                                            .setRequired(true)
                                            .addValidator(group -> {
                                                if (Objects.equals(password.getValue(), confirm.getValue())) {
                                                    return ValidationResult.valid();
                                                } else {
                                                    return ValidationResult.invalid("Password and confirmation does not match.");
                                                }
                                            });

                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_p_x_48, dui_items_center, dui_justify_center, dui_flex_col)
                                                    .appendChild(password)
                                                    .appendChild(confirm)
                                            );

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Back")
                                                        .setIcon(Icons.arrow_left())
                                                        .addClickListener(evt -> {
                                                            step.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> step.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        })
                                                )
                                                .appendChild(Button.create("Finish")
                                                        .addCss(dui_success)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                step.finish(StepState.COMPLETED);
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .withFinishContent((stepper, finishElement) -> {
                            finishElement
                                    .addCss(dui_flex, dui_p_x_48, dui_items_center, dui_justify_center, dui_flex_col)
                                    .appendChild(Icons.checkbox_marked_circle_outline()
                                            .addCss(dui_fg_success, dui_font_size_32)
                                    )
                                    .appendChild(h(2).textContent("Registration completed."))
                                    .appendChild(Button.create("RESET")
                                            .addCss(dui_success)
                                            .setIcon(Icons.reply_all_outline())
                                            .setReversed(true)
                                            .addClickListener(evt -> {
                                                stepper.reset(StepState.ACTIVE, steps -> {
                                                    steps.forEach(step -> step.dispatchEvent(CustomEvents.create("stepreset")));
                                                });
                                            }));
                        })
                        .start(StepState.ACTIVE)
                )
        );
    }

    @SampleMethod
    private void verticalStepper() {

        element.appendChild(Card.create("VERTICAL STEPPER")
                .setCollapsible(true)
                .appendChild(Stepper.create()
                        .addCss(dui_reversed, dui_vertical)
                        .appendChild(Step.create("Name and Nickname")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("Personal info 1.").addCss(dui_m_0, dui_p_r_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.account()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Name and nickname will be used in notifications and user info.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    TextBox firstName = TextBox.create("First name")
                                            .groupBy(stepGroup);
                                    TextBox lastName = TextBox.create("Last name")
                                            .groupBy(stepGroup);
                                    TextBox nickname = TextBox.create("Nickname")
                                            .groupBy(stepGroup);
                                    stepGroup.setRequired(true);

                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_items_center, dui_justify_center, dui_flex_col, dui_p_l_6)
                                                    .appendChild(firstName)
                                                    .appendChild(lastName)
                                                    .appendChild(nickname)
                                            );

                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_flex, dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Next")
                                                        .addCss(dui_success, dui_w_24)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                step.next((deactivated, activated) -> {
                                                                    deactivated.ifPresent(stepTracker -> step.setState(StepState.COMPLETED));
                                                                    activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                });
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .appendChild(Step.create("Residency location")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("Address 2.").addCss(dui_m_0, dui_p_r_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.map_marker()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Will be used for shipments.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    TextBox country = TextBox.create("Country")
                                            .groupBy(stepGroup);
                                    TextBox city = TextBox.create("City")
                                            .groupBy(stepGroup);
                                    TextBox zipCode = TextBox.create("ZIP Code")
                                            .setHelperText("Leave empty to mark step with warning.");
                                    stepGroup.setRequired(true);
                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        zipCode.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });
                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_items_center, dui_justify_center, dui_flex_col, dui_p_l_6)
                                                    .appendChild(country)
                                                    .appendChild(city)
                                                    .appendChild(zipCode)
                                            );

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Back")
                                                        .setIcon(Icons.arrow_left())
                                                        .addClickListener(evt -> {
                                                            step.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> step.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        })
                                                )
                                                .appendChild(Button.create("Next")
                                                        .addCss(dui_success)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                if (zipCode.isEmpty()) {
                                                                    step.next((deactivated, activated) -> {
                                                                        deactivated.ifPresent(stepTracker -> step.setState(StepState.WARNING));
                                                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                    });
                                                                } else {
                                                                    step.next((deactivated, activated) -> {
                                                                        deactivated.ifPresent(stepTracker -> step.setState(StepState.COMPLETED));
                                                                        activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                    });
                                                                }
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .appendChild(Step.create("Notification channels")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("Contact information 3.").addCss(dui_m_0, dui_p_r_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.phone()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Will be used for notifications and verification.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    EmailBox email = EmailBox.create("Email")
                                            .groupBy(stepGroup);
                                    TelephoneBox phone = TelephoneBox.create("Phone number")
                                            .groupBy(stepGroup);
                                    stepGroup.setRequired(true);
                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });
                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_items_center, dui_justify_center, dui_flex_col, dui_p_l_6)
                                                    .appendChild(email)
                                                    .appendChild(phone)
                                            );

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Back")
                                                        .setIcon(Icons.arrow_left())
                                                        .addClickListener(evt -> {
                                                            step.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> step.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        })
                                                )
                                                .appendChild(Button.create("Next")
                                                        .addCss(dui_success)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                step.next((deactivated, activated) -> {
                                                                    deactivated.ifPresent(stepTracker -> step.setState(StepState.COMPLETED));
                                                                    activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                                });
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .appendChild(Step.create("Account protection")
                                .withTracker((parent, tracker) -> tracker.appendChild(p("Security 4.").addCss(dui_m_0, dui_p_r_2)))
                                .withHeader((parent, header) -> {
                                    header
                                            .appendChild(PrefixAddOn.of(Icons.shield()))
                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical()))
                                            .setDescription("Will be used for login and verification.")
                                    ;
                                })
                                .withContent((step, content) -> {
                                    FieldsGrouping stepGroup = FieldsGrouping.create();
                                    PasswordBox password = PasswordBox.create("Password")
                                            .groupBy(stepGroup);
                                    PasswordBox confirm = PasswordBox.create("Confirm password")
                                            .groupBy(stepGroup);
                                    step.addEventListener("stepreset", evt -> {
                                        stepGroup.clear(true);
                                        step.setState(StepState.INACTIVE);
                                    });
                                    stepGroup
                                            .setRequired(true)
                                            .addValidator(group -> {
                                                if (Objects.equals(password.getValue(), confirm.getValue())) {
                                                    return ValidationResult.valid();
                                                } else {
                                                    return ValidationResult.invalid("Password and confirmation does not match.");
                                                }
                                            });

                                    content
                                            .appendChild(div()
                                                    .addCss(dui_flex, dui_items_center, dui_justify_center, dui_flex_col, dui_p_l_6)
                                                    .appendChild(password)
                                                    .appendChild(confirm)
                                            );

                                    step.withFooter((parent, footer) -> {
                                        footer
                                                .addCss(dui_justify_center, dui_gap_1, dui_p_4)
                                                .appendChild(Button.create("Back")
                                                        .setIcon(Icons.arrow_left())
                                                        .addClickListener(evt -> {
                                                            step.prev((deactivated, activated) -> {
                                                                deactivated.ifPresent(stepTracker -> step.setState(StepState.INACTIVE));
                                                                activated.ifPresent(stepTracker -> stepTracker.setState(StepState.ACTIVE));
                                                            });
                                                        })
                                                )
                                                .appendChild(Button.create("Finish")
                                                        .addCss(dui_success)
                                                        .setIcon(Icons.arrow_right())
                                                        .setReversed(true)
                                                        .addClickListener(evt -> {
                                                            if (stepGroup.validate().isValid()) {
                                                                step.finish(StepState.COMPLETED);
                                                            } else {
                                                                step.setState(StepState.ERROR);
                                                            }
                                                        })
                                                );
                                    });
                                })
                        )
                        .withFinishContent((stepper, finishElement) -> {
                            finishElement
                                    .addCss(dui_flex, dui_items_center, dui_justify_center, dui_flex_col)
                                    .appendChild(Icons.checkbox_marked_circle_outline()
                                            .addCss(dui_fg_success, dui_font_size_32)
                                    )
                                    .appendChild(h(2).textContent("Registration completed."))
                                    .appendChild(Button.create("RESET")
                                            .addCss(dui_success)
                                            .setIcon(Icons.reply_all_outline())
                                            .setReversed(true)
                                            .addClickListener(evt -> {
                                                stepper.reset(StepState.ACTIVE, steps -> {
                                                    steps.forEach(step -> step.dispatchEvent(CustomEvents.create("stepreset")));
                                                });
                                            }));
                        })
                        .start(StepState.ACTIVE)
                )
        );

    }
}