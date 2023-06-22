package org.dominokit.domino.loaders.client.views.ui;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.loaders.client.presenters.LoadersProxy;
import org.dominokit.domino.loaders.client.views.LoadersView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.gwtproject.timer.client.Timer;

@UiView(presentable = LoadersProxy.class)
@SampleClass
public class LoadersViewImpl extends BaseDemoView<HTMLDivElement> implements LoadersView {
    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        this.element.appendChild(LinkToSourceCode.createLink("loaders", this.getClass()).element());
        this.element.appendChild(BlockHeader.create("Loaders", "Use loaders to mask an element until some action is completed.").element());

        initSample();
        this.element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sample())
                .element());

        return element.element();
    }

    private void initSample() {
        this.element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.BOUNCE, "Loading ... ", Color.BLUE_GREY)))
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.FACEBOOK, "Loading ... ", Color.LIGHT_BLUE)))
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.IOS, "Loading ... ", Color.LIGHT_GREEN)))
                .element());

        this.element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.ROTATE_PLANE, "Waiting ... ", Color.BLUE_GREY)))
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.ROTATION, "Waiting ... ", Color.LIGHT_BLUE)))
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.ROUND_BOUNCE, "Waiting ... ", Color.LIGHT_GREEN)))
                .element());

        this.element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.TIMER, " ... ", Color.BLUE_GREY)))
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.WIN8, " ... ", Color.LIGHT_BLUE)))
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.WIN8_LINEAR, " ... ", Color.LIGHT_GREEN)))
                .element());

        this.element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.PULSE, "Loading ... ", Color.BLUE_GREY)))
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.PROGRESS_BAR, "Loading ... ", Color.LIGHT_BLUE)))
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.BOUNCE_PULSE, "Loading ... ", Color.LIGHT_GREEN)))
                .element());

        this.element.appendChild(Row.create()
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.ORBIT, "", Color.BLUE_GREY)))
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.STRETCH, "", Color.LIGHT_BLUE)))
                .appendChild(Column.span4()
                        .appendChild(createCard(LoaderEffect.NONE, "", Color.LIGHT_GREEN)))
                .element());
    }

    private Card createCard(LoaderEffect effect, String loadingText, Color color) {
        Card card = Card.create(effect.toString(), effect.toString().toLowerCase() + " loader effect.")
                .addCss(color.getCss());

        EventListener loaderListener = e -> {
            Loader loader = Loader.create(card.element(), effect)
                    .setLoadingText(loadingText)
                    .start();
            new Timer() {
                @Override
                public void run() {
                    loader.stop();
                }
            }.schedule(7000);
        };

        Button button = Button.create(Icons.cursor_default_click(), "CLICK ME").addClickListener(loaderListener);
        card.appendChild(text(SAMPLE_CONTENT))
                .appendChild(br())
                .appendChild(br())
        .appendChild(div().addCss(dui_text_center).appendChild(button));

        return card;
    }

    @SampleMethod
    private void sample(){
        Card card = Card.create("Loaders", "loader sample");
        Button button = Button.create(Icons.cursor_default_click(),"CLICK ME")
                .addClickListener(evt -> {
                    Loader loader = Loader.create(card.element(), LoaderEffect.PULSE)
                            .setLoadingText("Loading ...")
                            .start();
                    new Timer() {
                        @Override
                        public void run() {
                            loader.stop();
                        }
                    }.schedule(7000);
                });
        card.appendChild(text(SAMPLE_CONTENT))
                .appendChild(br())
                .appendChild(br())
                .appendChild(div()
                        .addCss(dui_text_center)
                        .appendChild(button));
    }

}