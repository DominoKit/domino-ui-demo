package org.dominokit.domino.buttons.client.views;

public class CodeResource {

    public static String initBootstrapButtons() {
        return "Button.createDefault(\"DEFAULT\").asElement();\n" +
                "Button.createPrimary(\"PRIMARY\").asElement();\n" +
                "Button.createSuccess(\"SUCCESS\").asElement();\n" +
                "Button.createInfo(\"INFO\").asElement();\n" +
                "Button.createWarning(\"WARNING\").asElement();\n" +
                "Button.createDanger(\"DANGER\").asElement();";
    }

    public static String initMaterialDesignButtons() {
        return "Button.create(\"RED\").setBackground(Color.RED).asElement();\n" +
                "Button.create(\"PURPLE\").setBackground(Color.PURPLE).asElement();\n" +
                "Button.create(\"INDIGO\").setBackground(Color.INDIGO).asElement();\n" +
                "Button.create(\"LIGHT BLUE\").setBackground(Color.LIGHT_BLUE).asElement();\n" +
                "Button.create(\"GREEN\").setBackground(Color.GREEN).asElement();";
    }

    public static String initButtonSizes() {
        return "Button.createDefault(LARGE).setSize(ButtonSize.LARGE).asElement();\n" +
                "Button.createDefault(DEFAULT).asElement();\n" +
                "Button.createDefault(SMALL).setSize(Buttonize.SMALL).asElement();\n" +
                "Button.createDefault(XSMALL).setSize(ButtonSize.XSMALL).asElement();";
    }

    public static String initBlockButtons() {
        return "Button.createDefault(DEFAULT).setBlock(true).asElement();\n" +
                "Button.createPrimary(PRIMARY).setBlock(true).asElement();\n" +
                "Button.createInfo(INFO).setBlock(true).asElement();\n" +
                "Button.createWarning(WARNING).setBlock(true).asElement();\n" +
                "Button.createDanger(DANGER).setBlock(true).asElment();";
    }

    public static String initDisabledButtons() {
        return "Button.createDefault(DEFAULT).setBlock(true).disbale().asElement();\n" +
                "Button.createPrimary(PRIMARY).setBlock(true).disbale().asElement();\n" +
                "Button.createInfo(INFO).setBlock(true).disbale().asElement();\n" +
                "Button.createWarning(WARNING).setBlock(true).disbale().asElement();\n" +
                "Button.createDanger(DANGER).setBlock(true).disbale().asElment();";
    }

    public static String initIconButtons() {
        return "// NORMAL\n" +
                "IconButton.create(Icons.ALL.home()).setButtonType(StyleType.DEFAULT).asElement();\n" +
                "IconButton.create(Icons.ALL.mic()).setButtonType(StyleType.PRIMARY).asElement();\n" +
                "IconButton.create(Icons.ALL.more()).setButtonType(StyleType.INFO).asElement();\n" +
                "IconButton.create(Icons.ALL.keyboard()).setButtonType(StyleType.SUCCESS).asElement();\n" +
                "IconButton.create(Icons.ALL.ac_unit()).setButtonType(StyleType.WARNING).asElement();\n" +
                "IconButton.create(Icons.ALL.access_alarm()).setButtonType(StyleType.DANGER).asElement();\n" +
                "\n" +
                "// SMALL CIRCLE\n" +
                "IconButton.create(Icons.ALL.add_circle()).setButtonType(StyleType.DEFAULT).circle(CircleSize.SMALL).asElement();\n" +
                "IconButton.create(Icons.ALL.place()).setButtonType(StyleType.PRIMARY).circle(CircleSize.SMALL).asElement();\n" +
                "IconButton.create(Icons.ALL.airplanemode_active()).setButtonType(StyleType.INFO).circle(CircleSize.SMALL).asElement();\n" +
                "IconButton.create(Icons.ALL.album()).setButtonType(StyleType.SUCCESS).circle(CircleSize.SMALL).asElement();\n" +
                "IconButton.create(Icons.ALL.weekend()).setButtonType(StyleType.WARNING).circle(CircleSize.SMALL).asElement();\n" +
                "IconButton.create(Icons.ALL.airplay()).setButtonType(StyleType.DANGER).circle(CircleSize.SMALL).asElement();\n" +
                "\n" +
                "// LARGE CIRCLE\n" +
                "IconButton.create(Icons.ALL.adjust()).setButtonType(StyleType.DEFAULT).circle(CircleSize.LARGE).asElement();\n" +
                "IconButton.create(Icons.ALL.all_out()).setButtonType(StyleType.PRIMARY).circle(CircleSize.LARGE).asElement();\n" +
                "IconButton.create(Icons.ALL.apps()).setButtonType(StyleType.INFO).circle(CircleSize.LARGE).asElement();\n" +
                "IconButton.create(Icons.ALL.art_track()).setButtonType(StyleType.SUCCESS).circle(CircleSize.LARGE).asElement();\n" +
                "IconButton.create(Icons.ALL.assessment()).setButtonType(StyleType.WARNING).circle(CircleSize.LARGE).asElement();\n" +
                "IconButton.create(Icons.ALL.assistant()).setButtonType(StyleType.DANGER).circle(CircleSize.LARGE).asElement();";
    }

    public static String initTextIconButtons() {
        return "Button.create(EXTENSION).setIcon(Icons.ALL.extension()).asElement();\n" +
                "Button.createPrimary(HOME).setIcon(Icons.ALL.home()).asElement();\n" +
                "Button.createSuccess(LOCK).setIcon(Icons.ALL.lock()).asElement();\n" +
                "Button.createInfo(SCAN WIFI).setIcon(Icons.ALL.perm_scan_wifi()).asElement();\n" +
                "Button.createWarning(TAKE OFF).setIcon(Icons.ALL.flight_takeoff()).asElement();\n" +
                "Button.createDanger(PRINT).setIcon(Icons.ALL.print()).asElement();";
    }

    public static String initButtonsBasicGroup() {
        return "ButtonsGroup group = ButtonsGroup.create()\n" +
                "    .addButton(Button.createDefault(LEFT))\n" +
                "    .addButton(Button.createDefault(MIDDLE))\n" +
                "    .addButton(Button.createDefault(RIGHT));\n" +
                "    \n" +
                "element.appendChild(group.asElement());";
    }

    public static String initButtonsToolbar() {
        return "ButtonsGroup firstGroup = ButtonsGroup.create()\n" +
                "    .addButton(Button.createDefault(\"1\"))\n" +
                "    .addButton(Button.createDefault(\"2\"))\n" +
                "    .addButton(Button.createDefault(\"3\"));\n" +
                "    \n" +
                "ButtonsGroup secondGroup = ButtonsGroup.create()\n" +
                "    .addButton(Button.createDefault(\"4\"))\n" +
                "    .addButton(Button.createDefault(\"5\"))\n" +
                "    .addButton(Button.createDefault(\"6\"));\n" +
                "    \n" +
                "ButtonsGroup thirdGroup = ButtonsGroup.create()\n" +
                "    .addButton(Button.createDefault(\"7\"));\n" +
                "    \n" +
                "ButtonsToolbar buttonsToolbar = ButtonsToolbar.create()\n" +
                "    .addGroup(firstGroup)\n" +
                "    .addGroup(secondGroup)\n" +
                "    .addGroup(thirdGroup);\n" +
                "    \n" +
                "element.appendChild(buttonsToolbar.asElement());";
    }

    public static String initSizingGroup() {
        return "ButtonsGroup.create()\n" +
                "    .addButton(Button.createDefault(\"LEFT\"))\n" +
                "    .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "    .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "    .setSize(ButtonSize.LARGE)\n" +
                "    .asElement();\n" +
                "\n" +
                "ButtonsGroup.create()\n" +
                "    .addButton(Button.createDefault(\"LEFT\"))\n" +
                "    .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "    .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "    .asElement();\n" +
                "\n" +
                "ButtonsGroup.create()\n" +
                "    .addButton(Button.createDefault(\"LEFT\"))\n" +
                "    .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "    .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "    .setSize(ButtonSize.SMALL)\n" +
                "    .asElement();\n" +
                "\n" +
                "ButtonsGroup.create()\n" +
                "    .addButton(Button.createDefault(\"LEFT\"))\n" +
                "    .addButton(Button.createDefault(\"MIDDLE\"))\n" +
                "    .addButton(Button.createDefault(\"RIGHT\"))\n" +
                "    .setSize(ButtonSize.XSMALL)\n" +
                "    .asElement();";
    }

    public static String initNestingGroup() {
        return "DropdownButton defaultDropDown = DropdownButton.create(\"Dropdown\")\n" +
                "    .addAction(DropdownAction.create(\"Dropdown link\"))\n" +
                "    .addAction(DropdownAction.create(\"Dropdown link\"));\n" +
                "\n" +
                "ButtonsGroup.create()\n" +
                "    .addButton(Button.create(\"1\"))\n" +
                "    .addButton(Button.create(\"2\"))\n" +
                "    .addDropDown(defaultDropDown);";
    }

    public static String initVerticalGroup() {
        return "ButtonsGroup.create()\n" +
                "    .addButton(Button.create(\"Button\"))\n" +
                "    .addButton(Button.createPrimary(\"Button\"))\n" +
                "    .addDropDown(DropdownButton.createInfo(\"Dropdown\")\n" +
                "            .addAction(DropdownAction.create(\"Dropdown link\"))\n" +
                "            .addAction(DropdownAction.create(\"Dropdown link\")))\n" +
                "    .addButton(Button.createDanger(\"Button\"))\n" +
                "    .verticalAlign();";
    }

    public static String initJustifyGroup() {
        return "JustifiedGroup justifiedGroup = JustifiedGroup.create();\n" +
                "justifiedGroup.addButton(Button.createPrimary(\"LEFT\"));\n" +
                "justifiedGroup.addButton(Button.createInfo(\"MIDDLE\"));\n" +
                "justifiedGroup.addButton(Button.createDanger(\"RIGHT\"));\n" +
                "justifiedGroup.addDropDown(dropDown);";
    }

    public static String initSingleDropdownButtons() {
        return "DropdownButton.createWarning(\"WARNING\")\n" +
                "    .addAction(DropdownAction.create(\"Action\"))\n" +
                "    .addAction(DropdownAction.create(\"Another action\"))\n" +
                "        .addAction(DropdownAction.create(\"Something else here\"))\n" +
                "            separator()\n" +
                "            .addAction(DropdownAction.create(\"Separated link\"));";
    }

    public static String initSplitButton() {
        return "DropdownButton infoDropdown = DropdownButton.createInfo(\"Toggle Dropdown\")\n" +
                "    .addAction(DropdownAction.create(\"Action\"))\n" +
                "    .addAction(DropdownAction.create(\"Another action\"))\n" +
                "    .addAction(DropdownAction.create(\"Something else here\"))\n" +
                "            .separator()\n" +
                "            .addAction(DropdownAction.create(\"Separated link\"));\n" +
                "            \n" +
                "SplitButton.createInfo(\"INFO\")\n" +
                "    .addDropdown(infoDropdown)";
    }

    public static String initDropUp() {
        return "DropdownButton.createDanger(\"Dropdown\")\n" +
                "    .addAction(DropdownAction.create(\"Action\"))\n" +
                "    .addAction(DropdownAction.create(\"Another action\"))\n" +
                "    .dropup();\n" +
                "\n" +
                "// in group\n" +
                "DropdownButton danger = DropdownButton.createDanger(\"Dropdown\")\n" +
                "    .addAction(DropdownAction.create(\"Action\"))\n" +
                "    .addAction(DropdownAction.create(\"Another action\"))\n" +
                "    .dropup();\n" +
                "\n" +
                "\n" +
                "ButtonsGroup.create()\n" +
                "    .addButton(Button.createDanger(\"DANGER\"))\n" +
                "    .addDropDown(danger);";
    }


}

