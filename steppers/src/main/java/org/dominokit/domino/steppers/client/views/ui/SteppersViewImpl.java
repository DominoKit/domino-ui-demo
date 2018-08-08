package org.dominokit.domino.steppers.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.steppers.client.presenters.SteppersPresenter;
import org.dominokit.domino.steppers.client.steppers.Step;
import org.dominokit.domino.steppers.client.steppers.Stepper;
import org.dominokit.domino.steppers.client.views.SteppersView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = SteppersPresenter.class)
public class SteppersViewImpl extends ComponentView<HTMLDivElement> implements SteppersView {

    private final HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("STEPPERS").asElement());
        Stepper stepper = Stepper.create();
        Step step2 = Step.create("Second step", "first step description");
        element.appendChild(Card.create()
                .appendChild(stepper
                        .addStep(Step.create("First step", "first step description")
                                .appendContent(Card.create("Sample card")
                                        .appendContent(Button.createPrimary("Next")
                                                .addClickListener(evt -> stepper.next()))
                                )
                        )
                        .addStep(step2
                                .appendContent(Card.create("Sample card")
                                        .appendContent(Button.createPrimary("Back")
                                                .addClickListener(evt -> stepper.back()))
                                        .appendContent(Button.createPrimary("Next")
                                                .addClickListener(evt -> stepper.next()))
                                        .appendContent(Button.createDanger("Invalidate")
                                                .addClickListener(evt -> step2.invalidate()))
                                )
                        )
                        .addStep(Step.create("Third step", "first step description")
                                .appendContent(Card.create("Sample card")
                                        .appendContent(Button.createPrimary("Back")
                                                .addClickListener(evt -> stepper.back()))
                                        .appendContent(Button.createPrimary("Next")
                                                .addClickListener(evt -> stepper.next()))
                                )
                        )
                )
                .asElement());

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}