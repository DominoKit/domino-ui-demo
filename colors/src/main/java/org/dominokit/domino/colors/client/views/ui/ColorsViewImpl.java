package org.dominokit.domino.colors.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.colors.client.presenters.ColorsPresenter;
import org.dominokit.domino.colors.client.views.ColorsView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;

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
                        .addColumn(column.copy().addElement(makeColorBox(Color.RED, Color.RED)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.PINK, Color.PINK)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.PURPLE, Color.PURPLE)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.DEEP_PURPLE, Color.DEEP_PURPLE)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(makeColorBox(Color.INDIGO, Color.INDIGO)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.BLUE, Color.BLUE)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.LIGHT_BLUE, Color.LIGHT_BLUE)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.CYAN, Color.CYAN)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(makeColorBox(Color.TEAL, Color.TEAL)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.GREEN, Color.GREEN)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.LIGHT_GREEN, Color.LIGHT_GREEN)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.LIME, Color.LIME)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(makeColorBox(Color.YELLOW, Color.YELLOW)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.AMBER, Color.AMBER)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.ORANGE, Color.ORANGE)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.DEEP_ORANGE, Color.DEEP_ORANGE)))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(makeColorBox(Color.BROWN, Color.BROWN)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.GREY, Color.GREY)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.BLUE_GREY, Color.BLUE_GREY)))
                        .addColumn(column.copy().addElement(makeColorBox(Color.BLACK, Color.BLACK)))
                        .asElement())
                .asElement());
    }

    private HTMLElement makeColorBox(Color color, Color background) {
        return div().css("demo-color-box", background.getBackground())
                .add(div().css("color-name").textContent(color.getName()))
                .add(div().css("color-code").textContent(color.getHex()))
                .add(div().css("color-class-name").textContent(background.getBackground()))
                .add(div().css("color-class-name").textContent(color.getStyle()))
                .asElement();
    }

}