package org.dominokit.domino.loaders.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.loaders.client.presenters.LoadersPresenter;
import org.dominokit.domino.loaders.client.views.CodeResource;
import org.dominokit.domino.loaders.client.views.LoadersView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.row.Row;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.gwtproject.timer.client.Timer;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = LoadersPresenter.class)
public class LoadersViewImpl extends ComponentView<HTMLDivElement> implements LoadersView {
    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private HTMLDivElement element = Elements.div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("Loaders", "Use loaders to mask an element until some action is completed.").asElement());

        Column column = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        Row row = Row.create();
        element.appendChild(row.asElement());

        row.addColumn(column
                .addElement(createCard(LoaderEffect.BOUNCE, "Loading ... ", Color.BLUE_GREY, Color.BLUE_GREY)
                .asElement()));
        row.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.FACEBOOK, "Loading ... ", Color.LIGHT_BLUE, Color.BLUE)
                .asElement()));
        row.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.IOS, "Loading ... ", Color.LIGHT_GREEN, Color.GREEN)
                .asElement()));


        Row secondRow = Row.create();
        element.appendChild(secondRow.asElement());

        secondRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.ROTATE_PLANE, "Waiting ... ", Color.BLUE_GREY, Color.BLUE_GREY)
                .asElement()));
        secondRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.ROTATION, "Waiting ... ", Color.LIGHT_BLUE, Color.BLUE)
                .asElement()));
        secondRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.ROUND_BOUNCE, "Waiting ... ", Color.LIGHT_GREEN, Color.GREEN)
                .asElement()));


        Row thirdRow = Row.create();
        element.appendChild(thirdRow.asElement());

        thirdRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.TIMER, " ... ", Color.BLUE_GREY, Color.BLUE_GREY)
                .asElement()));
        thirdRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.WIN8, " ... ", Color.LIGHT_BLUE, Color.BLUE)
                .asElement()));
        thirdRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.WIN8_LINEAR, " ... ", Color.LIGHT_GREEN, Color.GREEN)
                .asElement()));


        Row fourthRow = Row.create();
        element.appendChild(fourthRow.asElement());

        fourthRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.ORBIT, "", Color.BLUE_GREY, Color.BLUE_GREY)
                .asElement()));
        fourthRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.STRETCH, "", Color.LIGHT_BLUE, Color.BLUE)
                .asElement()));
        fourthRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.NONE, "", Color.LIGHT_GREEN, Color.GREEN)
                .asElement()));

        element.appendChild(createCodeCard(CodeResource.loadersSample())
                .asElement());
    }

    private Card createCard(LoaderEffect effect, String loadingText, Color bodyBackground, Color headerBackground) {
        Card card = Card.create(effect.toString(), effect.toString().toLowerCase() + " loader effect.")
                .setBodyBackground(bodyBackground)
                .setHeaderBackground(headerBackground);

        EventListener loaderListener = e -> {
            Loader loader = Loader.create(card.asElement(), effect)
                    .setLoadingText(loadingText)
                    .start();
            new Timer() {
                @Override
                public void run() {
                    loader.stop();
                }
            }.schedule(7000);
        };

        Button button = Button.createDefault("CLICK ME").addClickListener(loaderListener);
        card.appendContent(new Text(SAMPLE_CONTENT))
                .appendContent(Elements.br().asElement())
                .appendContent(Elements.br().asElement())
        .appendContent(Elements.div().attr("style", "text-align: center").add(button.asElement()).asElement());

        return card;
    }

}