package org.dominokit.domino.labels.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.labels.client.presenters.LabelsPresenter;
import org.dominokit.domino.labels.client.views.CodeResource;
import org.dominokit.domino.labels.client.views.LabelsView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.labels.Label;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Background;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = LabelsPresenter.class)
public class LabelsViewImpl extends ComponentView<HTMLDivElement> implements LabelsView {

    private HTMLDivElement element = Elements.div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("LABELS").asElement());
        initLabels();
        initMaterialLabels();
    }

    private void initMaterialLabels() {
        Card labels = Card.create("LABELS WITH MATERIAL DESIGN COLORS", "You can use material design color with labels");

        Row row = Row.create();

        Column column = Column.create()
                .onLarge(Column.OnLarge.one)
                .onMedium(Column.OnMedium.two)
                .onSmall(Column.OnSmall.six)
                .onXSmall(Column.OnXSmall.twelve);

        HTMLElement red = Label.create("Red").setBackground(Background.RED).asElement();
        HTMLElement pink = Label.create("Pink").setBackground(Background.PINK).asElement();
        HTMLElement purple = Label.create("Purple").setBackground(Background.PURPLE).asElement();
        HTMLElement deepPurple = Label.create("Deep Purple").setBackground(Background.DEEP_PURPLE).asElement();
        HTMLElement indigo = Label.create("Indigo").setBackground(Background.INDIGO).asElement();
        HTMLElement blue = Label.create("Blue").setBackground(Background.BLUE).asElement();
        HTMLElement lightBlue = Label.create("Light Blue").setBackground(Background.LIGHT_BLUE).asElement();
        HTMLElement cyan = Label.create("Cyan").setBackground(Background.CYAN).asElement();
        HTMLElement teal = Label.create("Teal").setBackground(Background.TEAL).asElement();
        HTMLElement green = Label.create("Green").setBackground(Background.GREEN).asElement();
        HTMLElement orange = Label.create("Orange").setBackground(Background.ORANGE).asElement();
        HTMLElement yellow = Label.create("Yellow").setBackground(Background.YELLOW).asElement();

        red.style.margin = CSSProperties.MarginUnionType.of("10px");
        pink.style.margin = CSSProperties.MarginUnionType.of("10px");
        purple.style.margin = CSSProperties.MarginUnionType.of("10px");
        deepPurple.style.margin = CSSProperties.MarginUnionType.of("10px");
        indigo.style.margin = CSSProperties.MarginUnionType.of("10px");
        blue.style.margin = CSSProperties.MarginUnionType.of("10px");
        lightBlue.style.margin = CSSProperties.MarginUnionType.of("10px");
        cyan.style.margin = CSSProperties.MarginUnionType.of("10px");
        teal.style.margin = CSSProperties.MarginUnionType.of("10px");
        green.style.margin = CSSProperties.MarginUnionType.of("10px");
        orange.style.margin = CSSProperties.MarginUnionType.of("10px");
        yellow.style.margin = CSSProperties.MarginUnionType.of("10px");

        row.addColumn(column.addElement(red))
                .addColumn(column.copy().addElement(pink))
                .addColumn(column.copy().addElement(purple))
                .addColumn(column.copy().addElement(deepPurple))
                .addColumn(column.copy().addElement(indigo))
                .addColumn(column.copy().addElement(blue))
                .addColumn(column.copy().addElement(lightBlue))
                .addColumn(column.copy().addElement(cyan))
                .addColumn(column.copy().addElement(teal))
                .addColumn(column.copy().addElement(green))
                .addColumn(column.copy().addElement(orange))
                .addColumn(column.copy().addElement(yellow));

        labels.appendContent(row.asElement());

        element.appendChild(labels.asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initMaterialLabels()).asElement());
    }

    private void initLabels() {
        Card labels = Card.create("LABELS");

        Row row = Row.create();

        Column column = Column.create()
                .onLarge(Column.OnLarge.one)
                .onMedium(Column.OnMedium.two)
                .onSmall(Column.OnSmall.six)
                .onXSmall(Column.OnXSmall.twelve);

        HTMLElement defaultLabel = Label.createDefault("DEFAULT").asElement();
        HTMLElement primaryLabel = Label.createPrimary("PRIMARY").asElement();
        HTMLElement successLabel = Label.createSuccess("SUCCESS").asElement();
        HTMLElement infoLabel = Label.createInfo("INFO").asElement();
        HTMLElement warningLabel = Label.createWarning("WARNING").asElement();
        HTMLElement dangerLabel = Label.createDanger("DANGER").asElement();


        defaultLabel.style.margin = CSSProperties.MarginUnionType.of("10px");
        primaryLabel.style.margin = CSSProperties.MarginUnionType.of("10px");
        successLabel.style.margin = CSSProperties.MarginUnionType.of("10px");
        infoLabel.style.margin = CSSProperties.MarginUnionType.of("10px");
        warningLabel.style.margin = CSSProperties.MarginUnionType.of("10px");
        dangerLabel.style.margin = CSSProperties.MarginUnionType.of("10px");

        row.addColumn(column.addElement(defaultLabel))
                .addColumn(column.copy().addElement(primaryLabel))
                .addColumn(column.copy().addElement(successLabel))
                .addColumn(column.copy().addElement(infoLabel))
                .addColumn(column.copy().addElement(warningLabel))
                .addColumn(column.copy().addElement(dangerLabel));

        labels.appendContent(row.asElement());

        labels.appendContent(Elements.hr().asElement());


        HTMLHeadingElement h1 = Elements.h(1).textContent("Example heading ").asElement();
        HTMLHeadingElement h2 = Elements.h(2).textContent("Example heading ").asElement();
        HTMLHeadingElement h3 = Elements.h(3).textContent("Example heading ").asElement();
        HTMLHeadingElement h4 = Elements.h(4).textContent("Example heading ").asElement();
        HTMLHeadingElement h5 = Elements.h(5).textContent("Example heading ").asElement();
        HTMLHeadingElement h6 = Elements.h(6).textContent("Example heading ").asElement();

        h1.style.textAlign = "left";
        h1.appendChild(Label.createDanger("New").asElement());
        h2.appendChild(Label.createWarning("New").asElement());
        h3.appendChild(Label.createInfo("New").asElement());
        h4.appendChild(Label.createSuccess("New").asElement());
        h5.appendChild(Label.createPrimary("New").asElement());
        h6.appendChild(Label.createDefault("New").asElement());

        labels.appendContent(h1)
                .appendContent(h2)
                .appendContent(h3)
                .appendContent(h4)
                .appendContent(h5)
                .appendContent(h6);

        this.element.appendChild(labels.asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.initLabels()).asElement());
    }
}