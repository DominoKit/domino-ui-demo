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
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import jsinterop.base.Js;

import static com.progressoft.brix.domino.ui.column.Column.*;
import static elemental2.dom.DomGlobal.console;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = CardsPresenter.class)
public class DefaultCardsView implements CardsView{

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";
    private HTMLDivElement element=div().asElement();

    public DefaultCardsView() {
        cardsWithHeaders();
        coloredCards();
        collapsibleCards();
        noHeaderCards();
    }

    private void cardsWithHeaders() {
        element.appendChild(BlockHeader.create("CARDS WITH HEADERS", "cards can have a header that has a Title and an optional description.").asElement());

        Column column = Column.create()
                .onLarge(OnLarge.four)
                .onMedium(OnMedium.four)
                .onSmall(OnSmall.twelve)
                .onXSmall(OnXSmall.twelve);

        element.appendChild(Row.create()
                .addColumn(column.addElement(Card.create("Card Title", "Description text here...")
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.ALL.more_vert(), event -> console.info("More action selected"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Card Title", "Description text here...")
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Card Title", "Description text here...")
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info("More action selected"))
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard("Column column = Column.create()\n" +
                "        .onLarge(OnLarge.four)\n" +
                "        .onMedium(OnMedium.four)\n" +
                "        .onSmall(OnSmall.twelve)\n" +
                "        .onXSmall(OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());").asElement());
    }

    private void coloredCards() {
        element.appendChild(BlockHeader.create("COLORED CARDS", "You can control the background color of card, card header and card body.").asElement());

        Column column = Column.create()
                .onLarge(OnLarge.four)
                .onMedium(OnMedium.four)
                .onSmall(OnSmall.twelve)
                .onXSmall(OnXSmall.twelve);

        element.appendChild(Row.create()
                .addColumn(column.addElement(Card.create("Light Blue Card", "Description text here...")
                        .setBackground(Background.LIGHT_BLUE)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.ALL.more_vert(), event -> console.info("More action selected"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Light Green Card", "Description text here...")
                        .setBackground(Background.LIGHT_GREEN)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Amber card", "Description text here...")
                        .setBackground(Background.AMBER)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info("More action selected"))
                        .asElement()))
                .asElement());

        element.appendChild(Row.create()
                .addColumn(column.copy().addElement(Card.create("Pink Card", "Description text here...")
                        .setHeaderBackground(Background.PINK)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.ALL.more_vert(), event -> console.info("More action selected"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Blue Grey Card", "Description text here...")
                        .setHeaderBackground(Background.BLUE_GREY)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Deep Orange card", "Description text here...")
                        .setHeaderBackground(Background.DEEP_ORANGE)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info("More action selected"))
                        .asElement()))
                .asElement());

        element.appendChild(Row.create()
                .addColumn(column.copy().addElement(Card.create("Light Blue Card", "Description text here...")
                        .setHeaderBackground(Background.BLUE)
                        .setBodyBackground(Background.LIGHT_BLUE)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.ALL.more_vert(), event -> console.info("More action selected"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Light Green Card", "Description text here...")
                        .setHeaderBackground(Background.GREEN)
                        .setBodyBackground(Background.LIGHT_GREEN)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Amber card", "Description text here...")
                        .setHeaderBackground(Background.ORANGE)
                        .setBodyBackground(Background.AMBER)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info("More action selected"))
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard("Column column = Column.create()\n" +
                "        .onLarge(OnLarge.four)\n" +
                "        .onMedium(OnMedium.four)\n" +
                "        .onSmall(OnSmall.twelve)\n" +
                "        .onXSmall(OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(Card.create(\"Light Blue Card\", \"Description text here...\")\n" +
                "                .setBackground(Background.LIGHT_BLUE)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Light Green Card\", \"Description text here...\")\n" +
                "                .setBackground(Background.LIGHT_GREEN)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Amber card\", \"Description text here...\")\n" +
                "                .setBackground(Background.AMBER)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Pink Card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Background.PINK)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Blue Grey Card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Background.BLUE_GREY)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Deep Orange card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Background.DEEP_ORANGE)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Light Blue Card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Background.BLUE)\n" +
                "                .setBodyBackground(Background.LIGHT_BLUE)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Light Green Card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Background.GREEN)\n" +
                "                .setBodyBackground(Background.LIGHT_GREEN)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Amber card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Background.ORANGE)\n" +
                "                .setBodyBackground(Background.AMBER)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());").asElement());
    }

    private void collapsibleCards() {
        element.appendChild(BlockHeader.create("COLLAPSIBLE CARDS", "cards can be collapsible.").asElement());

        Column column = Column.create()
                .onLarge(OnLarge.four)
                .onMedium(OnMedium.four)
                .onSmall(OnSmall.twelve)
                .onXSmall(OnXSmall.twelve);

        element.appendChild(Row.create()
                .addColumn(column.addElement(Card.create("Card Title", "Description text here...")
                        .setCollapsible()
                        .setHeaderBackground(Background.THEME)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.ALL.more_vert(), event -> console.info("More action selected"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Card Title", "Description text here...")
                        .setCollapsible()
                        .setHeaderBackground(Background.BROWN)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Card Title", "Description text here...")
                        .setCollapsible()
                        .collapse()
                        .setHeaderBackground(Background.CYAN)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info("More action selected"))
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard("Column column = Column.create()\n" +
                "        .onLarge(OnLarge.four)\n" +
                "        .onMedium(OnMedium.four)\n" +
                "        .onSmall(OnSmall.twelve)\n" +
                "        .onXSmall(OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .setCollapsible()\n" +
                "                .setHeaderBackground(Background.THEME)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .setCollapsible()\n" +
                "                .setHeaderBackground(Background.BROWN)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .setCollapsible()\n" +
                "                .collapse()\n" +
                "                .setHeaderBackground(Background.CYAN)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());").asElement());
    }

    private void noHeaderCards() {
        element.appendChild(BlockHeader.create("NO HEADER CARDS", "You can also create cards without headers.").asElement());

        Column column = Column.create().onLarge(OnLarge.four)
                .onMedium(OnMedium.four)
                .onSmall(OnSmall.twelve)
                .onXSmall(OnXSmall.twelve);

        element.appendChild(Row.create()
                .addColumn(column.addElement(Card.create()
                        .setBackground(Background.GREEN)
                        .appendContent(new Text(SAMPLE_CONTENT)).asElement()))
                .addColumn(column.copy().addElement(Card.create()
                        .setBackground(Background.LIGHT_BLUE).appendContent(new Text(SAMPLE_CONTENT)).asElement()))
                .addColumn(column.copy().addElement(Card.create()
                        .setBackground(Background.PURPLE).appendContent(new Text(SAMPLE_CONTENT)).asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard("Column column = Column.create().onLarge(OnLarge.four)\n" +
                "        .onMedium(OnMedium.four)\n" +
                "        .onSmall(OnSmall.twelve)\n" +
                "        .onXSmall(OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(Card.create()\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT)).asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create()\n" +
                "                .setBackground(Background.THEME).appendContent(new Text(SAMPLE_CONTENT)).asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create()\n" +
                "                .setBackground(Background.CYAN).appendContent(new Text(SAMPLE_CONTENT)).asElement()))\n" +
                "        .asElement());").asElement());
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement= Js.cast(content.get());
        contentElement.appendChild(element);
    }
}