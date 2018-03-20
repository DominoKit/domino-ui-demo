package org.dominokit.domino.cards.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.cards.client.presenters.CardsPresenter;
import org.dominokit.domino.cards.client.views.CardsView;
import org.dominokit.domino.cards.client.views.CodeResource;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Background;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Text;
import org.jboss.gwt.elemento.core.Elements;

import static org.dominokit.domino.ui.column.Column.*;

@UiView(presentable = CardsPresenter.class)
public class CardsViewImpl extends ComponentView<HTMLDivElement> implements CardsView{

    private static final String SAMPLE_CONTENT = "Quis pharetra a pharetra fames blandit. Risus faucibus velit Risus imperdiet mattis neque volutpat, etiam lacinia netus dictum magnis per facilisi sociosqu. Volutpat. Ridiculus nostra.";
    private HTMLDivElement element= Elements.div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
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
                        .addHeaderAction(Icons.ALL.more_vert(), event -> DomGlobal.console.info("More action selected"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Card Title", "Description text here...")
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info("Play sound"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Card Title", "Description text here...")
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> DomGlobal.console.info("More action selected"))
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.cardsWithHeaders()).asElement());
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
                        .addHeaderAction(Icons.ALL.more_vert(), event -> DomGlobal.console.info("More action selected"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Light Green Card", "Description text here...")
                        .setBackground(Background.LIGHT_GREEN)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info("Play sound"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Amber card", "Description text here...")
                        .setBackground(Background.AMBER)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> DomGlobal.console.info("More action selected"))
                        .asElement()))
                .asElement());

        element.appendChild(Row.create()
                .addColumn(column.copy().addElement(Card.create("Pink Card", "Description text here...")
                        .setHeaderBackground(Background.PINK)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.ALL.more_vert(), event -> DomGlobal.console.info("More action selected"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Blue Grey Card", "Description text here...")
                        .setHeaderBackground(Background.BLUE_GREY)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info("Play sound"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Deep Orange card", "Description text here...")
                        .setHeaderBackground(Background.DEEP_ORANGE)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> DomGlobal.console.info("More action selected"))
                        .asElement()))
                .asElement());

        element.appendChild(Row.create()
                .addColumn(column.copy().addElement(Card.create("Light Blue Card", "Description text here...")
                        .setHeaderBackground(Background.BLUE)
                        .setBodyBackground(Background.LIGHT_BLUE)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.ALL.more_vert(), event -> DomGlobal.console.info("More action selected"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Light Green Card", "Description text here...")
                        .setHeaderBackground(Background.GREEN)
                        .setBodyBackground(Background.LIGHT_GREEN)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info("Play sound"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Amber card", "Description text here...")
                        .setHeaderBackground(Background.ORANGE)
                        .setBodyBackground(Background.AMBER)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> DomGlobal.console.info("More action selected"))
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.coloredCards()).asElement());
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
                        .addHeaderAction(Icons.ALL.more_vert(), event -> DomGlobal.console.info("More action selected"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Card Title", "Description text here...")
                        .setCollapsible()
                        .setHeaderBackground(Background.BROWN)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info("Play sound"))
                        .asElement()))

                .addColumn(column.copy().addElement(Card.create("Card Title", "Description text here...")
                        .setCollapsible()
                        .collapse()
                        .setHeaderBackground(Background.CYAN)
                        .appendContent(new Text(SAMPLE_CONTENT))
                        .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info("Play sound"))
                        .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> DomGlobal.console.info("More action selected"))
                        .asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.collapsibleCards()).asElement());
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

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.noHeaderCards()).asElement());
    }
}