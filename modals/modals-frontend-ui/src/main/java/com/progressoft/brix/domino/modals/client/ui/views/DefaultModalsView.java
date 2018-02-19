package com.progressoft.brix.domino.modals.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.modals.client.presenters.ModalsPresenter;
import com.progressoft.brix.domino.modals.client.views.ModalsView;
import com.progressoft.brix.domino.ui.button.Button;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.code.Code;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.modals.ModalDialog;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.*;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = ModalsPresenter.class)
public class DefaultModalsView implements ModalsView {

    private static final String SAMPLE_CONTENT = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Proin sodales orci ante, sed ornare eros vestibulum ut. Ut accumsan vitae eros sit amet tristique. Nullam scelerisque nunc enim, non dignissim nibh faucibus ullamcorper. Fusce pulvinar libero vel ligula iaculis ullamcorper. Integer dapibus, mi ac tempor varius, purus nibh mattis erat, vitae porta nunc nisi non tellus. Vivamus mollis ante non massa egestas fringilla. Vestibulum egestas consectetur nunc at ultricies. Morbi quis consectetur nunc.";
    private HTMLElement element = div().asElement();

    public DefaultModalsView() {
        element.appendChild(BlockHeader.create("MODALS").asElement());
        initModalsSize();
        initModalColor();
    }

    private void initModalColor() {
        Card card = Card.create("WITH MATERIAL DESIGN COLORS", "You can use material design colors.");

        HTMLDivElement buttonsContainer = div().css("button-demo").asElement();
        card.appendContent(buttonsContainer);

        //------------ Red ------------
        ModalDialog modalDialogRed=createModalDialog().setModalColor(Color.RED);
        Button redButton=Button.create("RED").setBackground(Background.RED);
        redButton.getClickableElement().addEventListener("click", e-> modalDialogRed.open());

        buttonsContainer.appendChild(redButton.asElement());
        element.appendChild(modalDialogRed.asElement());

        //------------ Pink ------------
        ModalDialog modalDialogPink=createModalDialog().setModalColor(Color.PINK);
        Button pinkButton=Button.create("PINK").setBackground(Background.PINK);
        pinkButton.getClickableElement().addEventListener("click", e-> modalDialogPink.open());

        buttonsContainer.appendChild(pinkButton.asElement());
        element.appendChild(modalDialogPink.asElement());

        //------------ Purple ------------
        ModalDialog modalDialogPurple=createModalDialog().setModalColor(Color.PURPLE);
        Button purpleButton=Button.create("PURPLE").setBackground(Background.PURPLE);
        purpleButton.getClickableElement().addEventListener("click", e-> modalDialogPurple.open());

        buttonsContainer.appendChild(purpleButton.asElement());
        element.appendChild(modalDialogPurple.asElement());

        //------------ Deep Purple ------------
        ModalDialog modalDialogDeepPurple=createModalDialog().setModalColor(Color.DEEP_PURPLE);
        Button deepPurpleButton=Button.create("DEEP PURPLE").setBackground(Background.DEEP_PURPLE);
        deepPurpleButton.getClickableElement().addEventListener("click", e-> modalDialogDeepPurple.open());

        buttonsContainer.appendChild(deepPurpleButton.asElement());
        element.appendChild(modalDialogDeepPurple.asElement());

        //------------ Indigo ------------
        ModalDialog modalDialogIndigo=createModalDialog().setModalColor(Color.INDIGO);
        Button indigoButton=Button.create("INDIGO").setBackground(Background.INDIGO);
        indigoButton.getClickableElement().addEventListener("click", e-> modalDialogIndigo.open());

        buttonsContainer.appendChild(indigoButton.asElement());
        element.appendChild(modalDialogIndigo.asElement());

        //------------ Blue ------------
        ModalDialog modalDialogBlue=createModalDialog().setModalColor(Color.BLUE);
        Button blueButton=Button.create("BLUE").setBackground(Background.BLUE);
        blueButton.getClickableElement().addEventListener("click", e-> modalDialogBlue.open());

        buttonsContainer.appendChild(blueButton.asElement());
        element.appendChild(modalDialogBlue.asElement());

        //------------ Orange ------------
        ModalDialog modalDialogOrange=createModalDialog().setModalColor(Color.ORANGE);
        Button orangeButton=Button.create("ORANGE").setBackground(Background.ORANGE);
        orangeButton.getClickableElement().addEventListener("click", e-> modalDialogOrange.open());

        buttonsContainer.appendChild(orangeButton.asElement());
        element.appendChild(modalDialogOrange.asElement());


        //------------ Green ------------
        ModalDialog modalDialogGreen=createModalDialog().setModalColor(Color.GREEN);
        Button greenButton=Button.create("GREEN").setBackground(Background.GREEN);
        greenButton.getClickableElement().addEventListener("click", e-> modalDialogGreen.open());

        buttonsContainer.appendChild(greenButton.asElement());
        element.appendChild(modalDialogGreen.asElement());


        //------------ Teal ------------
        ModalDialog modalDialogTeal=createModalDialog().setModalColor(Color.TEAL);
        Button tealButton=Button.create("TEAL").setBackground(Background.TEAL);
        tealButton.getClickableElement().addEventListener("click", e-> modalDialogTeal.open());

        buttonsContainer.appendChild(tealButton.asElement());
        element.appendChild(modalDialogTeal.asElement());

        element.appendChild(card.asElement());

        Card codeCard = Card.createCodeCard("//------------ Red ------------\n" +
                "ModalDialog modalDialogRed=createModalDialog().setModalColor(Color.RED);\n" +
                "Button redButton=Button.create(\"RED\").setBackground(Background.RED);\n" +
                "redButton.getClickableElement().addEventListener(\"click\", e-> modalDialogRed.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(redButton.asElement());\n" +
                "element.appendChild(modalDialogRed.asElement());\n" +
                "\n" +
                "//------------ Pink ------------\n" +
                "ModalDialog modalDialogPink=createModalDialog().setModalColor(Color.PINK);\n" +
                "Button pinkButton=Button.create(\"PINK\").setBackground(Background.PINK);\n" +
                "pinkButton.getClickableElement().addEventListener(\"click\", e-> modalDialogPink.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(pinkButton.asElement());\n" +
                "element.appendChild(modalDialogPink.asElement());\n" +
                "\n" +
                "//------------ Purple ------------\n" +
                "ModalDialog modalDialogPurple=createModalDialog().setModalColor(Color.PURPLE);\n" +
                "Button purpleButton=Button.create(\"PURPLE\").setBackground(Background.PURPLE);\n" +
                "purpleButton.getClickableElement().addEventListener(\"click\", e-> modalDialogPurple.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(purpleButton.asElement());\n" +
                "element.appendChild(modalDialogPurple.asElement());\n" +
                "\n" +
                "//------------ Deep Purple ------------\n" +
                "ModalDialog modalDialogDeepPurple=createModalDialog().setModalColor(Color.DEEP_PURPLE);\n" +
                "Button deepPurpleButton=Button.create(\"DEEP PURPLE\").setBackground(Background.DEEP_PURPLE);\n" +
                "deepPurpleButton.getClickableElement().addEventListener(\"click\", e-> modalDialogDeepPurple.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(deepPurpleButton.asElement());\n" +
                "element.appendChild(modalDialogDeepPurple.asElement());\n" +
                "\n" +
                "//------------ Indigo ------------\n" +
                "ModalDialog modalDialogIndigo=createModalDialog().setModalColor(Color.INDIGO);\n" +
                "Button indigoButton=Button.create(\"INDIGO\").setBackground(Background.INDIGO);\n" +
                "indigoButton.getClickableElement().addEventListener(\"click\", e-> modalDialogIndigo.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(indigoButton.asElement());\n" +
                "element.appendChild(modalDialogIndigo.asElement());\n" +
                "\n" +
                "//------------ Blue ------------\n" +
                "ModalDialog modalDialogBlue=createModalDialog().setModalColor(Color.BLUE);\n" +
                "Button blueButton=Button.create(\"BLUE\").setBackground(Background.BLUE);\n" +
                "blueButton.getClickableElement().addEventListener(\"click\", e-> modalDialogBlue.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(blueButton.asElement());\n" +
                "element.appendChild(modalDialogBlue.asElement());\n" +
                "\n" +
                "//------------ Orange ------------\n" +
                "ModalDialog modalDialogOrange=createModalDialog().setModalColor(Color.ORANGE);\n" +
                "Button orangeButton=Button.create(\"ORANGE\").setBackground(Background.ORANGE);\n" +
                "orangeButton.getClickableElement().addEventListener(\"click\", e-> modalDialogOrange.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(orangeButton.asElement());\n" +
                "element.appendChild(modalDialogOrange.asElement());\n" +
                "\n" +
                "\n" +
                "//------------ Green ------------\n" +
                "ModalDialog modalDialogGreen=createModalDialog().setModalColor(Color.GREEN);\n" +
                "Button greenButton=Button.create(\"GREEN\").setBackground(Background.GREEN);\n" +
                "greenButton.getClickableElement().addEventListener(\"click\", e-> modalDialogGreen.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(greenButton.asElement());\n" +
                "element.appendChild(modalDialogGreen.asElement());\n" +
                "\n" +
                "\n" +
                "//------------ Teal ------------\n" +
                "ModalDialog modalDialogTeal=createModalDialog().setModalColor(Color.TEAL);\n" +
                "Button tealButton=Button.create(\"TEAL\").setBackground(Background.TEAL);\n" +
                "tealButton.getClickableElement().addEventListener(\"click\", e-> modalDialogTeal.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(tealButton.asElement());\n" +
                "element.appendChild(modalDialogTeal.asElement());");
        element.appendChild(codeCard.asElement());
        codeCard.appendContent(Code.block("private ModalDialog createModalDialog() {\n" +
                "    ModalDialog modal = ModalDialog.create(\"Modal title\");\n" +
                "    modal.appendContent(new Text(SAMPLE_CONTENT));\n" +
                "    Button closeButton = Button.create(\"CLOSE\").linkify();\n" +
                "    Button saveButton = Button.create(\"SAVE CHANGES\").linkify();\n" +
                "\n" +
                "    EventListener closeModalListener = evt -> modal.close();\n" +
                "\n" +
                "    closeButton.getClickableElement().addEventListener(\"click\", closeModalListener);\n" +
                "    saveButton.getClickableElement().addEventListener(\"click\", closeModalListener);\n" +
                "    modal.appendFooterContent(saveButton.asElement());\n" +
                "    modal.appendFooterContent(closeButton.asElement());\n" +
                "    return modal;\n" +
                "}\n").asElement());

    }

    private void initModalsSize() {
        Row row = Row.create();
        Column column = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        // ------------ Default size -------------

        ModalDialog defaultSizeModal = createModalDialog();

        Button defaultSizeButton = Button.createDefault("MODAL - DEFAULT SIZE");
        defaultSizeButton.getClickableElement().addEventListener("click", e -> defaultSizeModal.open());

        element.appendChild(defaultSizeModal.asElement());

        row.addColumn(column.addElement(defaultSizeButton.asElement()));

        // ------------ Large size -------------

        ModalDialog largeSizeModal = createModalDialog().large();

        Button largeSizeButton = Button.createDefault("MODAL - LARGE SIZE");
        largeSizeButton.getClickableElement().addEventListener("click", e -> largeSizeModal.open());


        element.appendChild(largeSizeModal.asElement());

        row.addColumn(column.copy().addElement(largeSizeButton.asElement()));

        // ------------ Small size -------------

        ModalDialog smallSizeModal = createModalDialog().small();

        Button smallSizeButton = Button.createDefault("MODAL - LARGE SIZE");
        smallSizeButton.getClickableElement().addEventListener("click", e -> smallSizeModal.open());


        element.appendChild(smallSizeModal.asElement());

        row.addColumn(column.copy().addElement(smallSizeButton.asElement()));

        element.appendChild(Card.create("MODAL SIZE EXAMPLE", "Modals are streamlined, but flexible, dialog prompts with the minimum required functionality and smart defaults.")
                .appendContent(row.asElement())
                .asElement());

        Card codeCard = Card.createCodeCard("Row row = Row.create();\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.four)\n" +
                "        .onMedium(Column.OnMedium.four)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "// ------------ Default size -------------\n" +
                "\n" +
                "ModalDialog defaultSizeModal = createModalDialog();\n" +
                "\n" +
                "Button defaultSizeButton = Button.create(\"MODAL - DEFAULT SIZE\");\n" +
                "defaultSizeButton.getClickableElement().addEventListener(\"click\", e -> defaultSizeModal.open());\n" +
                "\n" +
                "element.appendChild(defaultSizeModal.asElement());\n" +
                "\n" +
                "row.addColumn(column.addElement(defaultSizeButton.asElement()));\n" +
                "\n" +
                "// ------------ Large size -------------\n" +
                "\n" +
                "ModalDialog largeSizeModal = createModalDialog().large();\n" +
                "\n" +
                "Button largeSizeButton = Button.create(\"MODAL - LARGE SIZE\");\n" +
                "largeSizeButton.getClickableElement().addEventListener(\"click\", e -> largeSizeModal.open());\n" +
                "\n" +
                "\n" +
                "element.appendChild(largeSizeModal.asElement());\n" +
                "\n" +
                "row.addColumn(column.copy().addElement(largeSizeButton.asElement()));\n" +
                "\n" +
                "// ------------ Small size -------------\n" +
                "\n" +
                "ModalDialog smallSizeModal = createModalDialog().small();\n" +
                "\n" +
                "Button smallSizeButton = Button.create(\"MODAL - LARGE SIZE\");\n" +
                "smallSizeButton.getClickableElement().addEventListener(\"click\", e -> smallSizeModal.open());\n" +
                "\n" +
                "\n" +
                "element.appendChild(smallSizeModal.asElement());\n" +
                "\n" +
                "row.addColumn(column.copy().addElement(smallSizeButton.asElement()));\n" +
                "\n" +
                "element.appendChild(Card.create(\"MODAL SIZE EXAMPLE\", \"Modals are streamlined, but flexible, dialog prompts with the minimum required functionality and smart defaults.\")\n" +
                "        .appendContent(row.asElement())\n" +
                "        .asElement());");

        codeCard.appendContent(Code.block("private ModalDialog createModalDialog() {\n" +
                "    ModalDialog modal = ModalDialog.create(\"Modal title\");\n" +
                "    modal.appendContent(new Text(SAMPLE_CONTENT));\n" +
                "    Button closeButton = Button.create(\"CLOSE\").linkify();\n" +
                "    Button saveButton = Button.create(\"SAVE CHANGES\").linkify();\n" +
                "\n" +
                "    EventListener closeModalListener = evt -> modal.close();\n" +
                "\n" +
                "    closeButton.getClickableElement().addEventListener(\"click\", closeModalListener);\n" +
                "    saveButton.getClickableElement().addEventListener(\"click\", closeModalListener);\n" +
                "    modal.appendFooterContent(saveButton.asElement());\n" +
                "    modal.appendFooterContent(closeButton.asElement());\n" +
                "    return modal;\n" +
                "}").asElement());

        element.appendChild(codeCard
                .asElement());


    }

    private ModalDialog createModalDialog() {
        ModalDialog modal = ModalDialog.create("Modal title");
        modal.appendContent(new Text(SAMPLE_CONTENT));
        Button closeButton = Button.create("CLOSE").linkify();
        Button saveButton = Button.create("SAVE CHANGES").linkify();

        EventListener closeModalListener = evt -> modal.close();

        closeButton.getClickableElement().addEventListener("click", closeModalListener);
        saveButton.getClickableElement().addEventListener("click", closeModalListener);
        modal.appendFooterContent(saveButton.asElement());
        modal.appendFooterContent(closeButton.asElement());
        return modal;
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}