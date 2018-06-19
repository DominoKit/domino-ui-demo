package org.dominokit.domino.modals.client.views;

public class CodeResource {

    public static String initModalsSize() {
        return "Row row = Row.create();\n" +
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
                "Button defaultSizeButton = Button.createDefault(\"MODAL - DEFAULT SIZE\");\n" +
                "defaultSizeButton.getClickableElement().addEventListener(\"click\", e -> defaultSizeModal.open());\n" +
                "\n" +
                "row.addColumn(column.addElement(defaultSizeButton.asElement()));\n" +
                "\n" +
                "// ------------ Large size -------------\n" +
                "\n" +
                "ModalDialog largeSizeModal = createModalDialog().large();\n" +
                "\n" +
                "Button largeSizeButton = Button.createDefault(\"MODAL - LARGE SIZE\");\n" +
                "largeSizeButton.getClickableElement().addEventListener(\"click\", e -> largeSizeModal.open());\n" +
                "\n" +
                "\n" +
                "row.addColumn(column.copy().addElement(largeSizeButton.asElement()));\n" +
                "\n" +
                "// ------------ Small size -------------\n" +
                "\n" +
                "ModalDialog smallSizeModal = createModalDialog().small();\n" +
                "\n" +
                "Button smallSizeButton = Button.createDefault(\"MODAL - LARGE SIZE\");\n" +
                "smallSizeButton.getClickableElement().addEventListener(\"click\", e -> smallSizeModal.open());\n" +
                "\n" +
                "\n" +
                "row.addColumn(column.copy().addElement(smallSizeButton.asElement()));\n" +
                "\n" +
                "element.appendChild(Card.create(\"MODAL SIZE EXAMPLE\", \"Modals are streamlined, but flexible, dialog prompts with the minimum required functionality and smart defaults.\")\n" +
                "        .appendContent(row.asElement())\n" +
                "        .asElement());\n" +
                "\n" +
                "\n" +
                "//------------------------\n" +
                "\n" +
                "private ModalDialog createModalDialog() {\n" +
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
                "}";
    }

    public static String initModalColor() {
        return "HTMLDivElement buttonsContainer = Elements.div().css(\"button-demo\").asElement();\n" +
                "card.appendContent(buttonsContainer);\n" +
                "\n" +
                "//------------ Red ------------\n" +
                "ModalDialog modalDialogRed=createModalDialog().setModalColor(Color.RED);\n" +
                "Button redButton=Button.create(\"RED\").setBackground(Background.RED);\n" +
                "redButton.getClickableElement().addEventListener(\"click\", e-> modalDialogRed.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(redButton.asElement());\n" +
                "\n" +
                "//------------ Pink ------------\n" +
                "ModalDialog modalDialogPink=createModalDialog().setModalColor(Color.PINK);\n" +
                "Button pinkButton=Button.create(\"PINK\").setBackground(Background.PINK);\n" +
                "pinkButton.getClickableElement().addEventListener(\"click\", e-> modalDialogPink.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(pinkButton.asElement());\n" +
                "\n" +
                "//------------ Purple ------------\n" +
                "ModalDialog modalDialogPurple=createModalDialog().setModalColor(Color.PURPLE);\n" +
                "Button purpleButton=Button.create(\"PURPLE\").setBackground(Background.PURPLE);\n" +
                "purpleButton.getClickableElement().addEventListener(\"click\", e-> modalDialogPurple.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(purpleButton.asElement());\n" +
                "\n" +
                "//------------ Deep Purple ------------\n" +
                "ModalDialog modalDialogDeepPurple=createModalDialog().setModalColor(Color.DEEP_PURPLE);\n" +
                "Button deepPurpleButton=Button.create(\"DEEP PURPLE\").setBackground(Background.DEEP_PURPLE);\n" +
                "deepPurpleButton.getClickableElement().addEventListener(\"click\", e-> modalDialogDeepPurple.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(deepPurpleButton.asElement());\n" +
                "\n" +
                "//------------ Indigo ------------\n" +
                "ModalDialog modalDialogIndigo=createModalDialog().setModalColor(Color.INDIGO);\n" +
                "Button indigoButton=Button.create(\"INDIGO\").setBackground(Background.INDIGO);\n" +
                "indigoButton.getClickableElement().addEventListener(\"click\", e-> modalDialogIndigo.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(indigoButton.asElement());\n" +
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
                "\n" +
                "\n" +
                "//------------ Green ------------\n" +
                "ModalDialog modalDialogGreen=createModalDialog().setModalColor(Color.GREEN);\n" +
                "Button greenButton=Button.create(\"GREEN\").setBackground(Background.GREEN);\n" +
                "greenButton.getClickableElement().addEventListener(\"click\", e-> modalDialogGreen.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(greenButton.asElement());\n" +
                "\n" +
                "\n" +
                "//------------ Teal ------------\n" +
                "ModalDialog modalDialogTeal=createModalDialog().setModalColor(Color.TEAL);\n" +
                "Button tealButton=Button.create(\"TEAL\").setBackground(Background.TEAL);\n" +
                "tealButton.getClickableElement().addEventListener(\"click\", e-> modalDialogTeal.open());\n" +
                "\n" +
                "buttonsContainer.appendChild(tealButton.asElement());\n" +
                "\n" +
                "element.appendChild(card.asElement());\n" +
                "\n" +
                "\n" +
                "\n" +
                "//------------------------\n" +
                "\n" +
                "private ModalDialog createModalDialog() {\n" +
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
                "}";
    }
}

