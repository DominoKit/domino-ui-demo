package org.dominokit.domino.collapse.client.views;

public class CodeResource {

    public static String example() {
        return "Collapsible collapsible = Collapsible.create(Elements.div()\n" +
                "        .add(Elements.div()\n" +
                "                .css(\"well\")\n" +
                "                .textContent(SAMPLE_CONTENT)\n" +
                "                .asElement())\n" +
                "        .asElement());\n" +
                "EventListener collapsibleListener = evt -> {\n" +
                "    if (collapsible.isCollapsed())\n" +
                "        collapsible.expand();\n" +
                "    else\n" +
                "        collapsible.collapse();\n" +
                "};\n" +
                "\n" +
                "Button anchorButton = Button.create(\"LINK WITH HREF\");\n" +
                "anchorButton.justify();\n" +
                "anchorButton.getClickableElement().addEventListener(\"click\", collapsibleListener);\n" +
                "\n" +
                "Button button = Button.create(\"BUTTON\");\n" +
                "button.getClickableElement().addEventListener(\"click\", collapsibleListener);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(Card.create(\"EXAMPLE\", \"click the buttons below to show and hide another element via class changes.\")\n" +
                "                        .appendContent(anchorButton.htmlBuilder()\n" +
                "                                .css(CssStyles.M_B_15).component().setBackground(Color.PINK)\n" +
                "                                .asElement())\n" +
                "                        .appendContent(new Text(\"\\n\"))\n" +
                "                        .appendContent(button.htmlBuilder()\n" +
                "                                .css(CssStyles.M_B_15).component()\n" +
                "                                .setBackground(Color.CYAN)\n" +
                "                                .asElement())\n" +
                "                        .appendContent(collapsible.asElement())\n" +
                "                        .asElement())).asElement());";
    }

    public static String accordionSample() {
        return "Row row = Row.create();\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.six)\n" +
                "        .onMedium(Column.OnMedium.six)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(row.addColumn(column.copy()\n" +
                "        .addElement(Card.create(\"BASIC EXAMPLES\", \"Extend the default collapse behavior to create an accordion with the panel component.\")\n" +
                "                .setCollapsible()\n" +
                "                .appendContent(Elements.b().textContent(\"Panel Primary\").asElement())\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT)).expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .asElement())\n" +
                "                .appendContent(Elements.b().textContent(\"Panel Success\").asElement())\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT)).expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .success()\n" +
                "                        .asElement())\n" +
                "                .appendContent(Elements.b().textContent(\"Panel Warning\").asElement())\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT)).expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .warning()\n" +
                "                        .asElement())\n" +
                "                .appendContent(Elements.b().textContent(\"Panel Danger\").asElement())\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT)).expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .danger()\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"FULL BODY EXAMPLES\", \"If you want to also colorful body, you need to use fullBody method.\")\n" +
                "                .setCollapsible()\n" +
                "                .appendContent(Elements.b().textContent(\"Panel Primary\").asElement())\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .fullBody()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT)).expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .asElement())\n" +
                "                .appendContent(Elements.b().textContent(\"Panel Success\").asElement())\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .fullBody()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT)).expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .success()\n" +
                "                        .asElement())\n" +
                "                .appendContent(Elements.b().textContent(\"Panel Warning\").asElement())\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .fullBody()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT)).expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .warning()\n" +
                "                        .asElement())\n" +
                "                .appendContent(Elements.b().textContent(\"Panel Danger\").asElement())\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .fullBody()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT)).expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT)))\n" +
                "                        .danger()\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .asElement());";
    }

    public static String colorFullWithIcons() {
        return "Row row = Row.create();\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.six)\n" +
                "        .onMedium(Column.OnMedium.six)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(row.addColumn(column.copy()\n" +
                "        .addElement(Card.create(\"COLORFUL PANEL ITEMS WITH ICON\")\n" +
                "                .setCollapsible()\n" +
                "                .appendContent(Elements.b().textContent(\"Panel Primary\").asElement())\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.perm_contact_calendar())\n" +
                "                                .setColor(Color.PINK)\n" +
                "                                .expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.cloud_download())\n" +
                "                                .setColor(Color.CYAN))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.contact_phone())\n" +
                "                                .setColor(Color.TEAL))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 4\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.folder_shared())\n" +
                "                                .setColor(Color.ORANGE))\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"FULL BODY COLORFUL PANEL ITEMS WITH ICON\")\n" +
                "                .setCollapsible()\n" +
                "                .appendContent(Elements.b().textContent(\"Panel Primary\").asElement())\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .fullBody()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.perm_contact_calendar())\n" +
                "                                .setColor(Color.PINK)\n" +
                "                                .expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.cloud_download())\n" +
                "                                .setColor(Color.CYAN))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.contact_phone())\n" +
                "                                .setColor(Color.TEAL))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 4\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.folder_shared())\n" +
                "                                .setColor(Color.ORANGE))\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .asElement());";
    }

    public static String multiOpenItems() {
        return "Row row = Row.create();\n" +
                "\n" +
                "element.appendChild(row.addColumn(column.copy()\n" +
                "        .addElement(Card.create(\"MULTIPLE ITEMS TO BE OPEN\")\n" +
                "                .setCollapsible()\n" +
                "                .appendContent(Accordion.create()\n" +
                "                        .multiOpen()\n" +
                "                        .fullBody()\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 1\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.perm_contact_calendar())\n" +
                "                                .setColor(Color.PINK)\n" +
                "                                .expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 2\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.cloud_download())\n" +
                "                                .setColor(Color.CYAN))\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 3\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.contact_phone())\n" +
                "                                .setColor(Color.TEAL)\n" +
                "                                .expand())\n" +
                "                        .addPanel(AccordionPanel.create(\"Collapsible item 4\", new Text(SAMPLE_CONTENT))\n" +
                "                                .setIcon(Icons.ALL.folder_shared())\n" +
                "                                .setColor(Color.ORANGE))\n" +
                "                        .asElement())\n" +
                "                .asElement()))\n" +
                "        .asElement());";
    }
}

