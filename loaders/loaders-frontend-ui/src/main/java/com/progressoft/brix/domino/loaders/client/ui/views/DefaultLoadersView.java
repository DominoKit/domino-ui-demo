package com.progressoft.brix.domino.loaders.client.ui.views;

import com.google.gwt.user.client.Timer;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.loaders.client.presenters.LoadersPresenter;
import com.progressoft.brix.domino.loaders.client.views.LoadersView;
import com.progressoft.brix.domino.ui.button.Button;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.code.Code;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.icons.Icons;
import com.progressoft.brix.domino.ui.loaders.Loader;
import com.progressoft.brix.domino.ui.loaders.LoaderEffect;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.br;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = LoadersPresenter.class)
public class DefaultLoadersView implements LoadersView {
    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";

    private HTMLDivElement element = div().asElement();

    public DefaultLoadersView() {
        element.appendChild(BlockHeader.create("Loaders", "Use loaders to mask an element until some action is completed.").asElement());

        Column column = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        Row row = Row.create();
        element.appendChild(row.asElement());

        row.addColumn(column
                .addElement(createCard(LoaderEffect.BOUNCE, "Loading ... ", Background.BLUE_GREY, Background.BLUE_GREY)
                .asElement()));
        row.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.FACEBOOK, "Loading ... ", Background.LIGHT_BLUE, Background.BLUE)
                .asElement()));
        row.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.IOS, "Loading ... ", Background.LIGHT_GREEN, Background.GREEN)
                .asElement()));


        Row secondRow = Row.create();
        element.appendChild(secondRow.asElement());

        secondRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.ROTATE_PLANE, "Waiting ... ", Background.BLUE_GREY, Background.BLUE_GREY)
                .asElement()));
        secondRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.ROTATION, "Waiting ... ", Background.LIGHT_BLUE, Background.BLUE)
                .asElement()));
        secondRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.ROUND_BOUNCE, "Waiting ... ", Background.LIGHT_GREEN, Background.GREEN)
                .asElement()));


        Row thirdRow = Row.create();
        element.appendChild(thirdRow.asElement());

        thirdRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.TIMER, " ... ", Background.BLUE_GREY, Background.BLUE_GREY)
                .asElement()));
        thirdRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.WIN8, " ... ", Background.LIGHT_BLUE, Background.BLUE)
                .asElement()));
        thirdRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.WIN8_LINEAR, " ... ", Background.LIGHT_GREEN, Background.GREEN)
                .asElement()));


        Row fourthRow = Row.create();
        element.appendChild(fourthRow.asElement());

        fourthRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.ORBIT, "", Background.BLUE_GREY, Background.BLUE_GREY)
                .asElement()));
        fourthRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.STRETCH, "", Background.LIGHT_BLUE, Background.BLUE)
                .asElement()));
        fourthRow.addColumn(column.copy()
                .addElement(createCard(LoaderEffect.NONE, "", Background.LIGHT_GREEN, Background.GREEN)
                .asElement()));

        Card codeCard = Card.createCodeCard("Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.four)\n" +
                "        .onMedium(Column.OnMedium.four)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "Row row = Row.create();\n" +
                "element.appendChild(row.asElement());\n" +
                "\n" +
                "row.addColumn(column\n" +
                "        .addElement(createCard(LoaderEffect.BOUNCE, \"Loading ... \", Background.BLUE_GREY, Background.BLUE_GREY)\n" +
                "        .asElement()));\n" +
                "row.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.FACEBOOK, \"Loading ... \", Background.LIGHT_BLUE, Background.BLUE)\n" +
                "        .asElement()));\n" +
                "row.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.IOS, \"Loading ... \", Background.LIGHT_GREEN, Background.GREEN)\n" +
                "        .asElement()));\n" +
                "\n" +
                "\n" +
                "Row secondRow = Row.create();\n" +
                "element.appendChild(secondRow.asElement());\n" +
                "\n" +
                "secondRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.ROTATE_PLANE, \"Waiting ... \", Background.BLUE_GREY, Background.BLUE_GREY)\n" +
                "        .asElement()));\n" +
                "secondRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.ROTATION, \"Waiting ... \", Background.LIGHT_BLUE, Background.BLUE)\n" +
                "        .asElement()));\n" +
                "secondRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.ROUND_BOUNCE, \"Waiting ... \", Background.LIGHT_GREEN, Background.GREEN)\n" +
                "        .asElement()));\n" +
                "\n" +
                "\n" +
                "Row thirdRow = Row.create();\n" +
                "element.appendChild(thirdRow.asElement());\n" +
                "\n" +
                "thirdRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.TIMER, \" ... \", Background.BLUE_GREY, Background.BLUE_GREY)\n" +
                "        .asElement()));\n" +
                "thirdRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.WIN8, \" ... \", Background.LIGHT_BLUE, Background.BLUE)\n" +
                "        .asElement()));\n" +
                "thirdRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.WIN8_LINEAR, \" ... \", Background.LIGHT_GREEN, Background.GREEN)\n" +
                "        .asElement()));\n" +
                "\n" +
                "\n" +
                "Row fourthRow = Row.create();\n" +
                "element.appendChild(fourthRow.asElement());\n" +
                "\n" +
                "fourthRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.ORBIT, \"\", Background.BLUE_GREY, Background.BLUE_GREY)\n" +
                "        .asElement()));\n" +
                "fourthRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.STRETCH, \"\", Background.LIGHT_BLUE, Background.BLUE)\n" +
                "        .asElement()));\n" +
                "fourthRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.NONE, \"\", Background.LIGHT_GREEN, Background.GREEN)\n" +
                "        .asElement()));");

        codeCard.appendContent(Code.block("private Card createCard(LoaderEffect effect, String loadingText, Background bodyBackground, Background headerBackground) {\n" +
                "    Card card = Card.create(effect.toString(), effect.toString().toLowerCase() + \" loader effect.\")\n" +
                "            .setBodyBackground(bodyBackground)\n" +
                "            .setHeaderBackground(headerBackground);\n" +
                "\n" +
                "    EventListener loaderListener = e -> {\n" +
                "        Loader loader = Loader.create(card.asElement(), effect)\n" +
                "                .setLoadingText(loadingText)\n" +
                "                .start();\n" +
                "        new Timer() {\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                loader.stop();\n" +
                "            }\n" +
                "        }.schedule(7000);\n" +
                "    };\n" +
                "\n" +
                "    Button button = Button.createDefault(\"CLICK ME\").addClickListener(loaderListener);\n" +
                "    card.appendContent(new Text(SAMPLE_CONTENT))\n" +
                "            .appendContent(br().asElement())\n" +
                "            .appendContent(br().asElement())\n" +
                "    .appendContent(div().attr(\"style\", \"text-align: center\").add(button.asElement()).asElement());\n" +
                "\n" +
                "    return card;\n" +
                "}").asElement());
        element.appendChild(codeCard
                .asElement());

    }

    private Card createCard(LoaderEffect effect, String loadingText, Background bodyBackground, Background headerBackground) {
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
                .appendContent(br().asElement())
                .appendContent(br().asElement())
        .appendContent(div().attr("style", "text-align: center").add(button.asElement()).asElement());

        return card;
    }


    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}