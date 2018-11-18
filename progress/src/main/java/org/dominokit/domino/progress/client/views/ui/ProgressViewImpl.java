package org.dominokit.domino.progress.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.progress.client.presenters.ProgressPresenter;
import org.dominokit.domino.progress.client.views.ProgressView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.style.Color;
import org.gwtproject.timer.client.Timer;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = ProgressPresenter.class)
public class ProgressViewImpl extends ComponentView<HTMLDivElement> implements ProgressView {

    public static final String MODULE_NAME = "progress";
    private HTMLDivElement element = div().asElement();
    private ProgressBar movingBar;
    private int animationFrame = 0;
    private DomGlobal.RequestAnimationFrameCallbackFn animationFrameCallback;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(LinkToSourceCode.create(MODULE_NAME, this.getClass()).asElement());
        element.appendChild(BlockHeader.create("PROGRESS BARS").asElement());

        basicSample();
        contextualAlternatives();
        stripedSample();
        animatedSample();
        stackedSample();
        materialDesignColors();

    }

    private void basicSample() {
        movingBar = ProgressBar.create(1000);
        //we are doing this since we want to move the progress for the demo,
        // in real use cases progress bar value increases by some data feedback.
        movingBar.asElement().style.setProperty("transition", "width 500ms linear", "important");

        element.appendChild(Card.create("BASIC EXAMPLES")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .setValue(90)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .textExpression("{value} out of {maxValue} completed")
                                .setValue(75)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .textExpression("{value} out of {maxValue} completed")
                                .setValue(40)))
                .appendChild(Progress.create()
                        .appendChild(movingBar))
                .asElement());

        animationFrameCallback = p0 -> {
            if (movingBar.getValue() >= movingBar.getMaxValue()) {
                movingBar.textExpression("Done");
            } else
                movingBar.setValue(movingBar.getValue() + 1);

            animationFrame = DomGlobal.requestAnimationFrame(animationFrameCallback);
        };

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"basicSample").asElement());
    }

    private void contextualAlternatives() {
        element.appendChild(Card.create("CONTEXTUAL ALTERNATIVES", "Progress bars use some of the same button and alert classes for consistent styles.")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .success()
                                .setValue(80)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .warning()
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .info()
                                .setValue(70)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .danger()
                                .setValue(30)))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"contextualAlternatives").asElement());
    }

    private void stripedSample() {
        element.appendChild(Card.create("STRIPED", "Uses a gradient to create a striped effect.")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .success()
                                .setValue(80)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .warning()
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .info()
                                .setValue(70)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .danger()
                                .setValue(30)))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"stripedSample").asElement());
    }

    private void animatedSample() {
        element.appendChild(Card.create("ANIMATED", "Animating the bar will add stripes by default.")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .success()
                                .setValue(80)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .warning()
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .info()
                                .setValue(70)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .danger()
                                .setValue(30)))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"animatedSample").asElement());
    }

    private void stackedSample() {
        element.appendChild(Card.create("STACKED", "You can stack more than one progress bar in a progress element.")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .success()
                                .setValue(40))
                        .appendChild(ProgressBar.create(100)
                                .warning()
                                .setValue(30))
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .danger()
                                .setValue(20))
                        .asElement())
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"stackedSample").asElement());
    }

    private void materialDesignColors() {
        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You use material design colors to style the progress bar.")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .setBackground(Color.PINK)
                                .striped()
                                .setValue(90)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .setBackground(Color.PURPLE)
                                .striped()
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .setBackground(Color.TEAL)
                                .striped()
                                .setValue(75)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .setBackground(Color.BROWN)
                                .striped()
                                .setValue(40)))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"materialDesignColors").asElement());
    }

    @Override
    public ComponentCase.ComponentRevealedHandler restartProgress() {
        return () -> {
            DomGlobal.cancelAnimationFrame(animationFrame);
            movingBar.setValue(0);
            movingBar.textExpression("{percent}%");
            new Timer() {
                @Override
                public void run() {
                    DomGlobal.requestAnimationFrame(animationFrameCallback);
                }
            }.schedule(1000);

        };
    }
}