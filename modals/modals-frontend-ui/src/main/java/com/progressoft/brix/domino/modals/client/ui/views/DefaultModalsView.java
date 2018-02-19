package com.progressoft.brix.domino.modals.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.modals.client.presenters.ModalsPresenter;
import com.progressoft.brix.domino.modals.client.views.ModalsView;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.modals.Link;
import com.progressoft.brix.domino.ui.modals.Modal;
import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = ModalsPresenter.class)
public class DefaultModalsView implements ModalsView {

    private HTMLElement element = Elements.div().asElement();

    public DefaultModalsView() {
        element.appendChild(BlockHeader.create("MODALS").asElement());
        initModalsSize();
        initModalColor();
    }

    private void initModalColor() {
        Card card = Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors.");

        Link redClose = Link.create("CLOSE");
        Modal redModal = Modal.create("RED")
                .setBackground(Background.RED)
                .setTitle("Modal title")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.")
                .addLink(Link.create("SAVE CHANGES"))
                .addLink(redClose)
                .setModalColor(Color.RED)
                .autoHide();

        redClose.asElement().addEventListener("click", event -> {
            redModal.hide();
        });

        // --------------------

        Link purpleClose = Link.create("CLOSE");
        Modal purpleModal = Modal.create("PURPLE")
                .setBackground(Background.PURPLE)
                .setTitle("Modal title")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.")
                .addLink(Link.create("SAVE CHANGES"))
                .addLink(purpleClose)
                .setModalColor(Color.PURPLE)
                .autoHide();

        purpleClose.asElement().addEventListener("click", event -> {
            purpleModal.hide();
        });

        // --------------------

        Link indigoClose = Link.create("CLOSE");
        Modal indigoModal = Modal.create("INDIGO")
                .setBackground(Background.INDIGO)
                .setTitle("Modal title")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.")
                .addLink(Link.create("SAVE CHANGES"))
                .addLink(indigoClose)
                .setModalColor(Color.INDIGO)
                .autoHide();

        indigoClose.asElement().addEventListener("click", event -> {
            indigoModal.hide();
        });

        // --------------------

        Link blueClose = Link.create("CLOSE");
        Modal blueModal = Modal.create("BLUE")
                .setBackground(Background.BLUE)
                .setTitle("Modal title")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.")
                .addLink(Link.create("SAVE CHANGES"))
                .addLink(blueClose)
                .setModalColor(Color.BLUE)
                .autoHide();

        blueClose.asElement().addEventListener("click", event -> {
            blueModal.hide();
        });

        redModal.asElement().style.margin = CSSProperties.MarginUnionType.of("10px");
        purpleModal.asElement().style.margin = CSSProperties.MarginUnionType.of("10px");
        indigoModal.asElement().style.margin = CSSProperties.MarginUnionType.of("10px");
        blueModal.asElement().style.margin = CSSProperties.MarginUnionType.of("10px");

        card.appendContent(redModal.asElement());
        card.appendContent(purpleModal.asElement());
        card.appendContent(indigoModal.asElement());
        card.appendContent(blueModal.asElement());

        element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("Link redClose = Link.create(\"CLOSE\");\n" +
                "Modal redModal = Modal.create(\"RED\")\n" +
                "        .setBackground(Background.RED)\n" +
                "        .setTitle(\"Modal title\")\n" +
                "        .setDescription(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.\")\n" +
                "        .addLink(Link.create(\"SAVE CHANGES\"))\n" +
                "        .addLink(redClose)\n" +
                "        .setModalColor(Color.RED)\n" +
                "        .autoHide();\n" +
                "\n" +
                "redClose.asElement().addEventListener(\"click\", event -> {\n" +
                "    redModal.hide();\n" +
                "});\n" +
                "\n" +
                "element.appendChild(redModal.asElement());\n" +
                "\n" +
                "// --------------------\n" +
                "\n" +
                "Link purpleClose = Link.create(\"CLOSE\");\n" +
                "Modal purpleModal = Modal.create(\"PURPLE\")\n" +
                "        .setBackground(Background.PURPLE)\n" +
                "        .setTitle(\"Modal title\")\n" +
                "        .setDescription(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.\")\n" +
                "        .addLink(Link.create(\"SAVE CHANGES\"))\n" +
                "        .addLink(purpleClose)\n" +
                "        .setModalColor(Color.PURPLE)\n" +
                "        .autoHide();\n" +
                "\n" +
                "purpleClose.asElement().addEventListener(\"click\", event -> {\n" +
                "    purpleModal.hide();\n" +
                "});\n" +
                "\n" +
                "element.appendChild(purpleModal.asElement());\n" +
                "\n" +
                "// --------------------\n" +
                "\n" +
                "Link indigoClose = Link.create(\"CLOSE\");\n" +
                "Modal indigoModal = Modal.create(\"INDIGO\")\n" +
                "        .setBackground(Background.INDIGO)\n" +
                "        .setTitle(\"Modal title\")\n" +
                "        .setDescription(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.\")\n" +
                "        .addLink(Link.create(\"SAVE CHANGES\"))\n" +
                "        .addLink(indigoClose)\n" +
                "        .setModalColor(Color.INDIGO)\n" +
                "        .autoHide();\n" +
                "\n" +
                "indigoClose.asElement().addEventListener(\"click\", event -> {\n" +
                "    indigoModal.hide();\n" +
                "});\n" +
                "\n" +
                "element.appendChild(indigoModal.asElement());\n" +
                "\n" +
                "// --------------------\n" +
                "\n" +
                "Link blueClose = Link.create(\"CLOSE\");\n" +
                "Modal blueModal = Modal.create(\"BLUE\")\n" +
                "        .setBackground(Background.BLUE)\n" +
                "        .setTitle(\"Modal title\")\n" +
                "        .setDescription(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.\")\n" +
                "        .addLink(Link.create(\"SAVE CHANGES\"))\n" +
                "        .addLink(blueClose)\n" +
                "        .setModalColor(Color.BLUE)\n" +
                "        .autoHide();\n" +
                "\n" +
                "blueClose.asElement().addEventListener(\"click\", event -> {\n" +
                "    blueModal.hide();\n" +
                "});\n" +
                "\n" +
                "element.appendChild(blueModal.asElement());").asElement());
    }

    private void initModalsSize() {
        Card card = Card.create("MODAL SIZE EXAMPLE", "Modals are streamlined, but flexible, dialog prompts with the minimum required functionality and smart defaults.");

        Link defaultClose = Link.create("CLOSE");
        Modal defaultModal = Modal.createDefault("MODAL - DEFAULT SIZE")
                .setTitle("Modal title")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.")
                .addLink(Link.create("SAVE CHANGES"))
                .addLink(defaultClose)
                .autoHide();

        defaultClose.asElement().addEventListener("click", event -> {
            defaultModal.hide();
        });

        // --------------------------------

        Link largeClose = Link.create("CLOSE");
        Modal largeModal = Modal.createDefault("MODAL - LARGE SIZE")
                .largeSize()
                .setTitle("Modal title")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.")
                .addLink(Link.create("SAVE CHANGES"))
                .addLink(largeClose)
                .autoHide();

        largeClose.asElement().addEventListener("click", event -> {
            largeModal.hide();
        });

        // --------------------------------

        Link smallClose = Link.create("CLOSE");
        Modal smallModal = Modal.createDefault("MODAL - SMALL SIZE")
                .smallSize()
                .setTitle("Modal title")
                .setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.")
                .addLink(Link.create("SAVE CHANGES"))
                .addLink(smallClose)
                .autoHide();

        smallClose.asElement().addEventListener("click", event -> {
            smallModal.hide();
        });

        defaultModal.asElement().style.margin = CSSProperties.MarginUnionType.of("10px");
        largeModal.asElement().style.margin = CSSProperties.MarginUnionType.of("10px");
        smallModal.asElement().style.margin = CSSProperties.MarginUnionType.of("10px");

        card.appendContent(defaultModal.asElement());
        card.appendContent(largeModal.asElement());
        card.appendContent(smallModal.asElement());

        this.element.appendChild(card.asElement());

        element.appendChild(Card.createCodeCard("// ------------------------ DEAFULT SIZE\n" +
                "\n" +
                "Link defaultClose = Link.create(\"CLOSE\");\n" +
                "Modal defaultModal = Modal.createDefault(\"MODAL - DEFAULT SIZE\")\n" +
                "        .setTitle(\"Modal title\")\n" +
                "        .setDescription(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam     scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.\")\n" +
                "        .addLink(Link.create(\"SAVE CHANGES\"))\n" +
                "        .addLink(defaultClose)\n" +
                "        .autoHide();\n" +
                "\n" +
                "defaultClose.asElement().addEventListener(\"click\", event -> {\n" +
                "    defaultModal.hide();\n" +
                "});\n" +
                "\n" +
                "element.appendChild(defaultModal.asElement());\n" +
                "\n" +
                "// ------------------------ LARGE SIZE\n" +
                "\n" +
                "Link largeClose = Link.create(\"CLOSE\");\n" +
                "Modal largeModal = Modal.createDefault(\"MODAL - LARGE SIZE\")\n" +
                "        .largeSize()\n" +
                "        .setTitle(\"Modal title\")\n" +
                "        .setDescription(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.\")\n" +
                "        .addLink(Link.create(\"SAVE CHANGES\"))\n" +
                "        .addLink(largeClose)\n" +
                "        .autoHide();\n" +
                "\n" +
                "largeClose.asElement().addEventListener(\"click\", event -> {\n" +
                "    largeModal.hide();\n" +
                "});\n" +
                "\n" +
                "element.appendChild(largeModal.asElement());\n" +
                "\n" +
                "// ------------------------ SMALL SIZE\n" +
                "\n" +
                "Link smallClose = Link.create(\"CLOSE\");\n" +
                "Modal smallModal = Modal.createDefault(\"MODAL - SMALL SIZE\")\n" +
                "        .smallSize()\n" +
                "        .setTitle(\"Modal title\")\n" +
                "        .setDescription(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.\")\n" +
                "        .addLink(Link.create(\"SAVE CHANGES\"))\n" +
                "        .addLink(smallClose)\n" +
                "        .autoHide();\n" +
                "\n" +
                "smallClose.asElement().addEventListener(\"click\", event -> {\n" +
                "    smallModal.hide();\n" +
                "});\n" +
                "\n" +
                "element.appendChild(smallModal.asElement());").asElement());
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}