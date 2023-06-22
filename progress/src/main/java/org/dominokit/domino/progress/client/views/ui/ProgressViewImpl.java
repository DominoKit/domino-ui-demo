package org.dominokit.domino.progress.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.FrameRequestCallback;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.progress.client.presenters.ProgressProxy;
import org.dominokit.domino.progress.client.views.ProgressView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.progress.Progress;
import org.dominokit.domino.ui.progress.ProgressBar;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.gwtproject.timer.client.Timer;

@UiView(presentable = ProgressProxy.class)
@SampleClass
public class ProgressViewImpl extends BaseDemoView<HTMLDivElement> implements ProgressView {

    private DivElement element;
    private ProgressBar movingBar;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("progress", this.getClass()));
        element.appendChild(BlockHeader.create("PROGRESS BARS"));

        basicSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicSample()));

        contextualAlternatives();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.contextualAlternatives()));

        stripedSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.stripedSample()));

        animatedSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.animatedSample()));

        stackedSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.stackedSample()));

        materialDesignColors();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.materialDesignColors()));

        return element.element();
    }

    @SampleMethod
    private void basicSample() {
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
                        .appendChild(movingBar = ProgressBar.create(1000)))
        );

        restartProgress();
    }

    @SampleMethod
    private void contextualAlternatives() {
        element.appendChild(Card.create("CONTEXTUAL ALTERNATIVES", "Progress bars use some of the same button and alert classes for consistent styles.")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_success)
                                .setValue(80)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_warning)
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_info)
                                .setValue(70)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_error)
                                .setValue(30)))
        );
    }

    @SampleMethod
    private void stripedSample() {
        element.appendChild(Card.create("STRIPED", "Uses a gradient to create a striped effect.")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .addCss(dui_success)
                                .setValue(80)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .addCss(dui_warning)
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .addCss(dui_info)
                                .setValue(70)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .addCss(dui_error)
                                .setValue(30)))
        );
    }

    @SampleMethod
    private void animatedSample() {
        element.appendChild(Card.create("ANIMATED", "Animating the bar will add stripes by default.")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .addCss(dui_success)
                                .setValue(80)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .addCss(dui_warning)
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .addCss(dui_info)
                                .setValue(70)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .addCss(dui_error)
                                .setValue(30)))
        );
    }

    @SampleMethod
    private void stackedSample() {
        element.appendChild(Card.create("STACKED", "You can stack more than one progress bar in a progress element.")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .animate()
                                .addCss(dui_success)
                                .setValue(40))
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_warning)
                                .setValue(30))
                        .appendChild(ProgressBar.create(100)
                                .striped()
                                .addCss(dui_error)
                                .setValue(20))
                )
        );
    }

    @SampleMethod
    private void materialDesignColors() {
        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You use material design colors to style the progress bar.")
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_pink)
                                .striped()
                                .setValue(90)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .showText()
                                .addCss(dui_purple)
                                .striped()
                                .setValue(60)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_teal)
                                .striped()
                                .setValue(75)))
                .appendChild(Progress.create()
                        .appendChild(ProgressBar.create(100)
                                .addCss(dui_brown)
                                .striped()
                                .setValue(40)))
        );
    }

    private void restartProgress() {
        movingBar.setValue(0);
        movingBar.textExpression("{percent}%");
        new Timer() {
            @Override
            public void run() {
                if (movingBar.getValue() >= movingBar.getMaxValue()) {
                    movingBar.textExpression("Done");
                } else {
                    movingBar.setValue(movingBar.getValue() + 1);
                }
            }
        }.scheduleRepeating(10);
    }
}