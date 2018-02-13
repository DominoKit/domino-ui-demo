package com.progressoft.brix.domino.cards.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.cards.client.presenters.CardsPresenter;
import com.progressoft.brix.domino.cards.client.views.CardsView;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.code.Code;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.icons.Icons;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import jsinterop.base.Js;

import static com.progressoft.brix.domino.ui.column.Column.*;
import static elemental2.dom.DomGlobal.*;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = CardsPresenter.class)
public class DefaultCardsView implements CardsView{

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";
    private HTMLDivElement root=div().asElement();

    public DefaultCardsView() {

        noHeaderCards();
        cardsWithHeaders();

    }

    private void noHeaderCards() {
        root.appendChild(BlockHeader.create("NO HEADER CARDS").asElement());

        Column column = Column.create().onLarge(OnLarge.four)
                .onMedium(OnMedium.four)
                .onSmall(OnSmall.twelve)
                .onXSmall(OnXSmall.twelve);

        root.appendChild(Row.create()
                .addColumn(column.addElement(Card.create()
                        .appendContent(new Text(SAMPLE_CONTENT)).asElement()))
                .addColumn(column.duplicate().addElement(Card.create()
                        .setBackground(Background.THEME).appendContent(new Text(SAMPLE_CONTENT)).asElement()))
                .addColumn(column.duplicate().addElement(Card.create()
                        .setBackground(Background.CYAN).appendContent(new Text(SAMPLE_CONTENT)).asElement()))
                .asElement());

        Card codeCard=Card.create("Code");
        codeCard.getBody().appendChild(Code.block("Column column = Column.create().onLarge(OnLarge.four)\n" +
                "        .onMedium(OnMedium.four)\n" +
                "        .onSmall(OnSmall.twelve)\n" +
                "        .onXSmall(OnXSmall.twelve);\n" +
                "\n" +
                "root.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(Card.create()\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT)).asElement()))\n" +
                "\n" +
                "        .addColumn(column.duplicate().addElement(Card.create()\n" +
                "                .setBackground(Background.THEME).appendContent(new Text(SAMPLE_CONTENT)).asElement()))\n" +
                "\n" +
                "        .addColumn(column.duplicate().addElement(Card.create()\n" +
                "                .setBackground(Background.CYAN).appendContent(new Text(SAMPLE_CONTENT)).asElement()))\n" +
                "        .asElement());").asElement());

        root.appendChild(codeCard.asElement());
    }

    private void cardsWithHeaders() {
        root.appendChild(BlockHeader.create("CARDS WITH HEADERS").asElement());

        Column column = Column.create().onLarge(OnLarge.four)
                .onMedium(OnMedium.four)
                .onSmall(OnSmall.twelve)
                .onXSmall(OnXSmall.twelve);

        root.appendChild(Row.create()
                .addColumn(column.addElement(Card.create("Card Title")
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.ALL.more_vert(), event -> console.info("More action selected"))
                        .asElement()))

                .addColumn(column.duplicate().addElement(Card.create("Card Title", "Description text here...")
                        .setBackground(Background.THEME)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .asElement()))

                .addColumn(column.duplicate().addElement(Card.create("Card Title", "Description text here...")
                        .setHeaderBackground(Background.CYAN)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info("More action selected"))
                        .asElement()))
                .asElement());

        Card codeCard=Card.create("Code");
        codeCard.getBody().appendChild(Code.block("Column column = Column.create().onLarge(OnLarge.four)\n" +
                "        .onMedium(OnMedium.four)\n" +
                "        .onSmall(OnSmall.twelve)\n" +
                "        .onXSmall(OnXSmall.twelve);\n" +
                "\n" +
                "root.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(Card.create(\"Card Title\")\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.duplicate().addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .setBackground(Background.THEME)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.duplicate().addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Background.CYAN)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());").asElement());

        root.appendChild(codeCard.asElement());
    }


    @Override
    public void showIn(Content content) {
        HTMLElement contentElement= Js.cast(content.get());
        contentElement.appendChild(root);
    }
}