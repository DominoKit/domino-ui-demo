package com.progressoft.brix.domino.progress.client.views.ui;

import com.google.gwt.user.client.Timer;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentView;
import com.progressoft.brix.domino.progress.client.views.CodeResource;
import com.progressoft.brix.domino.progress.client.views.ProgressView;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.progress.client.presenters.ProgressPresenter;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.progress.Progress;
import com.progressoft.brix.domino.ui.progress.ProgressBar;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.time;

@UiView(presentable = ProgressPresenter.class)
public class ProgressViewImpl extends ComponentView<HTMLDivElement> implements ProgressView {

    private HTMLDivElement element = div().asElement();
    private Timer timer;
    private ProgressBar movingBar;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("PROGRESS BARS").asElement());

        basicSample();
        contextualAlternatives();
        stripedSample();
        animatedSample();
        stackedSample();
        materialDesignColors();

    }

    private void basicSample() {
        movingBar = ProgressBar.create(100).showText();

        element.appendChild(Card.create("BASIC EXAMPLES")
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .setValue(90))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .showText()
                                .setValue(60))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .showText()
                                .textExpression("{value} out of {maxValue} completed")
                                .setValue(75))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .showText()
                                .textExpression("{value} out of {maxValue} completed")
                                .setValue(40))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(movingBar)
                        .asElement())
                .asElement());

        timer = new Timer() {
            @Override
            public void run() {
                if (movingBar.getValue() >= movingBar.getMaxValue()) {
                    this.cancel();
                    movingBar.textExpression("Done");
                } else
                    movingBar.setValue(movingBar.getValue() + 1);
            }
        };
        timer.scheduleRepeating(100);

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basicSample()).asElement());
    }

    private void contextualAlternatives() {
        element.appendChild(Card.create("CONTEXTUAL ALTERNATIVES", "Progress bars use some of the same button and alert classes for consistent styles.")
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .showText()
                                .success()
                                .setValue(80))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .showText()
                                .warning()
                                .setValue(60))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .showText()
                                .info()
                                .setValue(70))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .showText()
                                .danger()
                                .setValue(30))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.contextualAlternatives()).asElement());
    }

    private void stripedSample() {
        element.appendChild(Card.create("STRIPED", "Uses a gradient to create a striped effect.")
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .striped()
                                .success()
                                .setValue(80))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .striped()
                                .warning()
                                .setValue(60))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .striped()
                                .info()
                                .setValue(70))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .striped()
                                .danger()
                                .setValue(30))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.stripedSample()).asElement());
    }

    private void animatedSample() {
        element.appendChild(Card.create("ANIMATED", "Animating the bar will add stripes by default.")
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .animate()
                                .success()
                                .setValue(80))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .animate()
                                .warning()
                                .setValue(60))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .animate()
                                .info()
                                .setValue(70))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .animate()
                                .danger()
                                .setValue(30))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.animatedSample()).asElement());
    }

    private void stackedSample() {
        element.appendChild(Card.create("STACKED", "You can stack more than one progress bar in a progress element.")
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .animate()
                                .success()
                                .setValue(40))
                        .addBar(ProgressBar.create(100)
                                .warning()
                                .setValue(30))
                        .addBar(ProgressBar.create(100)
                                .striped()
                                .danger()
                                .setValue(20))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.stackedSample()).asElement());
    }

    private void materialDesignColors() {
        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You use material design colors to style the progress bar.")
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .setBackground(Background.PINK)
                                .striped()
                                .setValue(90))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .showText()
                                .setBackground(Background.PURPLE)
                                .striped()
                                .setValue(60))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .setBackground(Background.TEAL)
                                .striped()
                                .setValue(75))
                        .asElement())
                .appendContent(Progress.create()
                        .addBar(ProgressBar.create(100)
                                .setBackground(Background.BROWN)
                                .striped()
                                .setValue(40))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.materialDesignColors()).asElement());
    }

    @Override
    public ComponentCase.ComponentRevealedHandler restartProgress() {

        return () -> {
            if(movingBar.getValue()>=100) {
                timer.cancel();
                movingBar.setValue(0);
                movingBar.textExpression("{percent}%");
                new Timer() {
                    @Override
                    public void run() {
                        timer.scheduleRepeating(100);
                    }
                }.schedule(2000);
            }
        };
    }
}