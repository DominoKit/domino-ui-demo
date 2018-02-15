package com.progressoft.brix.domino.buttons.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.buttons.client.presenters.ButtonsPresenter;
import com.progressoft.brix.domino.buttons.client.views.ButtonsView;
import com.progressoft.brix.domino.ui.button.Button;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = ButtonsPresenter.class)
public class DefaultButtonsView implements ButtonsView {

    private HTMLDivElement element = div().asElement();

    public DefaultButtonsView() {
        element.appendChild(BlockHeader.create("BUTTONS").asElement());
        initBootstrapButtons();
        initMaterialDesignButtons();
    }

    private void initBootstrapButtons() {
        Card card = Card.create("BOOTSTRAP DEFAULT BUTTONS", "Use any of the available button classes to quickly create a styled button");

        HTMLElement defaultBtn = Button.createDefault("DEFAULT").asElement();
        setStyle(defaultBtn);
        card.appendContent(defaultBtn);

        HTMLElement primaryBtn = Button.createPrimary("PRIMARY").asElement();
        setStyle(primaryBtn);
        card.appendContent(primaryBtn);

        HTMLElement successBtn = Button.createSuccess("SUCCESS").asElement();
        setStyle(successBtn);
        card.appendContent(successBtn);

        HTMLElement infoBtn = Button.createInfo("INFO").asElement();
        setStyle(infoBtn);
        card.appendContent(infoBtn);

        HTMLElement warningBtn = Button.createWarning("WARNING").asElement();
        setStyle(warningBtn);
        card.appendContent(warningBtn);

        HTMLElement dangerBtn = Button.createDanger("DANGER").asElement();
        setStyle(dangerBtn);
        card.appendContent(dangerBtn);

        element.appendChild(card.asElement());


        element.appendChild(Card.createCodeCard("element.appendContent(Button.createDefault(\"DEFAULT\").asElement());\n" +
                "element.appendContent(Button.createPrimary(\"PRIMARY\").asElement());\n" +
                "element.appendContent(Button.createSuccess(\"SUCCESS\").asElement());\n" +
                "element.appendContent(Button.createInfo(\"INFO\").asElement());\n" +
                "element.appendContent(Button.createWarning(\"WARNING\").asElement());\n" +
                "element.appendContent(Button.createDanger(\"DANGER\").asElement());").setHeaderBackground(Background.WHITE).asElement());
    }

    private void initMaterialDesignButtons() {
        Card card = Card.create("METARIAL DESIGN BUTTONS", "Use any of the available button classes to quickly create a styled button");

        HTMLElement redBtn = Button.create("RED").setBackground(Background.RED).asElement();
        setStyle(redBtn);
        card.appendContent(redBtn);

        HTMLElement purpleBtn = Button.create("PURPLE").setBackground(Background.PURPLE).asElement();
        setStyle(purpleBtn);
        card.appendContent(purpleBtn);

        HTMLElement indigoBtn = Button.create("INDIGO").setBackground(Background.INDIGO).asElement();
        setStyle(indigoBtn);
        card.appendContent(indigoBtn);

        HTMLElement lightBlueBtn = Button.create("LIGHT BLUE").setBackground(Background.LIGHT_BLUE).asElement();
        setStyle(lightBlueBtn);
        card.appendContent(lightBlueBtn);

        HTMLElement greenBtn = Button.create("GREEN").setBackground(Background.GREEN).asElement();
        setStyle(greenBtn);
        card.appendContent(greenBtn);

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("card.appendContent(Button.create(\"RED\").setBackground(Background.RED).asElement());\n" +
                "card.appendContent(Button.create(\"PURPLE\").setBackground(Background.PURPLE).asElement());\n" +
                "card.appendContent(Button.create(\"INDIGO\").setBackground(Background.INDIGO).asElement());\n" +
                "card.appendContent(Button.create(\"LIGHT BLUE\").setBackground(Background.LIGHT_BLUE).asElement());\n" +
                "card.appendContent(Button.create(\"GREEN\").setBackground(Background.GREEN).asElement());")
                .setHeaderBackground(Background.WHITE).asElement());
    }

    private void setStyle(HTMLElement element) {
        element.style.margin = CSSProperties.MarginUnionType.of("5px");
        element.style.minWidth = CSSProperties.MinWidthUnionType.of("120px");
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}