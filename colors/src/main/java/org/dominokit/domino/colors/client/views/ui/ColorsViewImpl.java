package org.dominokit.domino.colors.client.views.ui;

import org.dominokit.domino.colors.client.views.ColorsView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.colors.client.presenters.ColorsPresenter;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Background;
import org.dominokit.domino.ui.style.Color;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import jsinterop.base.Js;
import org.dominokit.domino.colors.client.presenters.ColorsPresenter;
import org.dominokit.domino.colors.client.views.ColorsView;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = ColorsPresenter.class)
public class ColorsViewImpl extends ComponentView<HTMLDivElement> implements ColorsView {

    private HTMLDivElement element = div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("COLORS").asElement());

        Column column = Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(Card.create("MATERIAL DESIGN COLORS", "Taken by Google's Material Design Color page which link is ")
                .appendDescriptionContent(a()
                        .attr("href", "https://material.google.com/style/color.html#color-color-palette")
                        .textContent("material.google.com/style/color.html#color-color-palette")
                        .title("Google's Material Design Color").asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(makeColorBox(Color.RED, Background.RED)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.PINK, Background.PINK)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.PURPLE, Background.PURPLE)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.DEEP_PURPLE, Background.DEEP_PURPLE)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(makeColorBox(Color.INDIGO, Background.INDIGO)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.BLUE, Background.BLUE)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.LIGHT_BLUE, Background.LIGHT_BLUE)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.CYAN, Background.CYAN)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(makeColorBox(Color.TEAL, Background.TEAL)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.GREEN, Background.GREEN)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.LIGHT_GREEN, Background.LIGHT_GREEN)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.LIME, Background.LIME)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(makeColorBox(Color.YELLOW, Background.YELLOW)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.AMBER, Background.AMBER)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.ORANGE, Background.ORANGE)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.DEEP_ORANGE, Background.DEEP_ORANGE)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(makeColorBox(Color.BROWN, Background.BROWN)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.GREY, Background.GREY)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.BLUE_GREY, Background.BLUE_GREY)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.BLACK, Background.BLACK)))
                        .asElement())
                .asElement());
    }

    private HTMLElement makeColorBox(Color color, Background background) {
        return div().css("demo-color-box", background.getStyle())
                .add(div().css("color-name").textContent(color.getName()))
                .add(div().css("color-code").textContent(color.getHex()))
                .add(div().css("color-class-name").textContent(background.getStyle()))
                .add(div().css("color-class-name").textContent(color.getStyle()))
                .asElement();
    }

}