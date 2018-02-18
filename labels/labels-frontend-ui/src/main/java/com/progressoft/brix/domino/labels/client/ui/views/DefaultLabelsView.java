package com.progressoft.brix.domino.labels.client.ui.views;

import com.google.gwt.user.client.ui.Composite;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.labels.client.presenters.LabelsPresenter;
import com.progressoft.brix.domino.labels.client.views.LabelsView;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.labels.Label;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = LabelsPresenter.class)
public class DefaultLabelsView extends Composite implements LabelsView {

    private HTMLElement element = Elements.div().asElement();

    public DefaultLabelsView() {
        element.appendChild(BlockHeader.create("LABELS").asElement());
        initLabels();
        initMaterialLabels();
    }

    private void initMaterialLabels() {
        Card labels = Card.create("LABELS WITH MATERIAL DESIGN COLORS", "You can use material design color with labels");

        HTMLElement red = Label.create("Red").setBackground(Background.RED).asElement();
        HTMLElement pink = Label.create("Pink").setBackground(Background.PINK).asElement();
        HTMLElement purple = Label.create("Purple").setBackground(Background.PURPLE).asElement();
        HTMLElement deepPurple = Label.create("Deep Purple").setBackground(Background.DEEP_PURPLE).asElement();
        HTMLElement indigo = Label.create("Indigo").setBackground(Background.INDIGO).asElement();
        HTMLElement blue = Label.create("Blue").setBackground(Background.BLUE).asElement();
        HTMLElement lightBlue = Label.create("Light Blue").setBackground(Background.LIGHT_BLUE).asElement();
        HTMLElement cyan = Label.create("Cyan").setBackground(Background.CYAN).asElement();
        HTMLElement teal = Label.create("Teal").setBackground(Background.TEAL).asElement();

        red.style.margin = CSSProperties.MarginUnionType.of("10px");
        pink.style.margin = CSSProperties.MarginUnionType.of("10px");
        purple.style.margin = CSSProperties.MarginUnionType.of("10px");
        deepPurple.style.margin = CSSProperties.MarginUnionType.of("10px");
        indigo.style.margin = CSSProperties.MarginUnionType.of("10px");
        blue.style.margin = CSSProperties.MarginUnionType.of("10px");
        lightBlue.style.margin = CSSProperties.MarginUnionType.of("10px");
        cyan.style.margin = CSSProperties.MarginUnionType.of("10px");
        teal.style.margin = CSSProperties.MarginUnionType.of("10px");

        labels.appendContent(red)
                .appendContent(pink)
                .appendContent(purple)
                .appendContent(deepPurple)
                .appendContent(indigo)
                .appendContent(blue)
                .appendContent(lightBlue)
                .appendContent(cyan)
                .appendContent(teal);

        element.appendChild(labels.asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Label.create(\"Red\").setBackground(Background.RED).asElement());\n" +
                "element.appendChild(Label.create(\"Pink\").setBackground(Background.PINK).asElement());\n" +
                "element.appendChild(Label.create(\"Purple\").setBackground(Background.PURPLE).asElement());\n" +
                "element.appendChild(Label.create(\"Deep Purple\").setBackground(Background.DEEP_PURPLE).asElement());\n" +
                "element.appendChild(Label.create(\"Indigo\").setBackground(Background.INDIGO).asElement());\n" +
                "element.appendChild(Label.create(\"Blue\").setBackground(Background.BLUE).asElement());\n" +
                "element.appendChild(Label.create(\"Light Blue\").setBackground(Background.LIGHT_BLUE).asElement());\n" +
                "element.appendChild(Label.create(\"Cyan\").setBackground(Background.CYAN).asElement());\n" +
                "element.appendChild(Label.create(\"Teal\").setBackground(Background.TEAL).asElement());").asElement());
    }

    private void initLabels() {
        Card labels = Card.create("LABELS");

        Row row = Row.create();

        Column column = Column.create()
                .onLarge(Column.OnLarge.twelve)
                .onMedium(Column.OnMedium.twelve)
                .onSmall(Column.OnSmall.twelve)
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

        labels.appendContent(defaultLabel);
        labels.appendContent(primaryLabel);
        labels.appendContent(successLabel);
        labels.appendContent(infoLabel);
        labels.appendContent(warningLabel);
        labels.appendContent(dangerLabel);

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

        column.asElement().appendChild(labels.asElement());
        row.addColumn(column);
        this.element.appendChild(row.asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Label.createDefault(\"DEFAULT\").asElement());\n" +
                "element.appendChild(Label.createPrimary(\"PRIMARY\").asElement());\n" +
                "element.appendChild(Label.createSuccess(\"SUCCESS\").asElement());\n" +
                "element.appendChild(Label.createInfo(\"INFO\").asElement());\n" +
                "element.appendChild(Label.createWarning(\"WARNING\").asElement());\n" +
                "element.appendChild(Label.createDanger(\"DANGER\").asElement());").asElement());
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}