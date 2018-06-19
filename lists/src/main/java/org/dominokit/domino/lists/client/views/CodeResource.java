package org.dominokit.domino.lists.client.views;

public class CodeResource {

    public static String basicListsSample() {
        return "Row row = Row.create();\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.six)\n" +
                "        .onMedium(Column.OnMedium.six)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "element.appendChild(row.asElement());\n" +
                "\n" +
                "row.addColumn(column.addElement(Card.create(\"BASIC EXAMPLES\", \"The most basic list group is simply an unordered list with list items, and the proper classes.\")\n" +
                "        .appendContent(SimpleListGroup.create()\n" +
                "                .appendItem(\"Cras justo odio\")\n" +
                "                .appendItem(\"Dapibus ac facilisis in\")\n" +
                "                .appendItem(\"Morbi leo risus\")\n" +
                "                .appendItem(\"Porta ac consectetur ac\")\n" +
                "                .appendItem(\"Vestibulum at eros\")\n" +
                "                .asElement()).asElement()));\n" +
                "\n" +
                "row.addColumn(column.copy().addElement(Card.create(\"BADGES\", \"Add the badges component to any list group item and it will automatically be positioned on the right.\")\n" +
                "        .appendContent(SimpleListGroup.create()\n" +
                "                .appendItem(SimpleListItem.create(\"Cras justo odio\")\n" +
                "                        .appendContent(Badge.create(\"14 new\").setBackground(Background.PINK).asElement()))\n" +
                "\n" +
                "                .appendItem(SimpleListItem.create(\"Dapibus ac facilisis in\")\n" +
                "                        .appendContent(Badge.create(\"99 unread\").setBackground(Background.CYAN).asElement()))\n" +
                "\n" +
                "                .appendItem(SimpleListItem.create(\"Morbi leo risus\")\n" +
                "                        .appendContent(Badge.create(\"99+\").setBackground(Background.TEAL).asElement()))\n" +
                "\n" +
                "                .appendItem(SimpleListItem.create(\"Porta ac consectetur ac\")\n" +
                "                        .appendContent(Badge.create(\"21\").setBackground(Background.ORANGE).asElement()))\n" +
                "\n" +
                "                .appendItem(SimpleListItem.create(\"Vestibulum at eros\")\n" +
                "                        .appendContent(Badge.create(\"Pending\").setBackground(Background.PURPLE).asElement()))\n" +
                "                .asElement()).asElement()));";
    }

    public static String selectableSample() {
        return "Row row = Row.create();\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.six)\n" +
                "        .onMedium(Column.OnMedium.six)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "element.appendChild(row.asElement());\n" +
                "\n" +
                "ListGroup<String> listGroup = ListGroup.create();\n" +
                "listGroup\n" +
                "        .multiSelect()\n" +
                "        .appendItem(listGroup.createItem(\"Value1\", \"Cras justo odio\").select())\n" +
                "        .appendItem(listGroup.createItem(\"Value2\", \"Dapibus ac facilisis in\"))\n" +
                "        .appendItem(listGroup.createItem(\"Value3\", \"Morbi leo risus\"))\n" +
                "        .appendItem(listGroup.createItem(\"Value4\", \"Porta ac consectetur ac\"))\n" +
                "        .appendItem(listGroup.createItem(\"Value5\", \"Vestibulum at eros\"));\n" +
                "\n" +
                "row.addColumn(column.addElement(Card.create(\"SELECTABLE ITEMS\", \"Use ListGroup instead of SimpleListGroup to make items selectable, use multiSelect to select more than one item.\")\n" +
                "        .appendContent(listGroup.asElement()).asElement()));\n" +
                "\n" +
                "ListGroup<String> disabledItems = ListGroup.create();\n" +
                "disabledItems\n" +
                "        .appendItem(disabledItems.createItem(\"Value1\", \"Cras justo odio\").disable())\n" +
                "        .appendItem(disabledItems.createItem(\"Value2\", \"Dapibus ac facilisis in\").select())\n" +
                "        .appendItem(disabledItems.createItem(\"Value3\", \"Morbi leo risus\").disable())\n" +
                "        .appendItem(disabledItems.createItem(\"Value4\", \"Porta ac consectetur ac\"))\n" +
                "        .appendItem(disabledItems.createItem(\"Value5\", \"Vestibulum at eros\"));\n" +
                "\n" +
                "row.addColumn(column.copy().addElement(Card.create(\"DISABLED ITEMS\", \"List group items can be disabled and prevented from being selected.\")\n" +
                "        .appendContent(disabledItems.asElement()).asElement()));";
    }

    public static String coloredSample() {
        return "Row row = Row.create();\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.six)\n" +
                "        .onMedium(Column.OnMedium.six)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "element.appendChild(row.asElement());\n" +
                "\n" +
                "ListGroup<String> contextualGroup = ListGroup.create();\n" +
                "contextualGroup\n" +
                "        .appendItem(contextualGroup.createItem(\"Value1\", \"Cras justo odio\").select().success())\n" +
                "        .appendItem(contextualGroup.createItem(\"Value2\", \"Dapibus ac facilisis in\").info())\n" +
                "        .appendItem(contextualGroup.createItem(\"Value3\", \"Morbi leo risus\").warning())\n" +
                "        .appendItem(contextualGroup.createItem(\"Value4\", \"Porta ac consectetur ac\").error())\n" +
                "        .appendItem(contextualGroup.createItem(\"Value5\", \"Vestibulum at eros\"));\n" +
                "\n" +
                "row.addColumn(column.addElement(Card.create(\"CONTEXTUAL CLASSES\", \"Use contextual classes to style list items.\")\n" +
                "        .appendContent(contextualGroup.asElement()).asElement()));\n" +
                "\n" +
                "ListGroup<String> coloredGroup = ListGroup.create();\n" +
                "coloredGroup\n" +
                "        .appendItem(coloredGroup.createItem(\"Value1\", \"Cras justo odio\").disable().setBackground(Background.PINK))\n" +
                "        .appendItem(coloredGroup.createItem(\"Value2\", \"Dapibus ac facilisis in\").setBackground(Background.TEAL))\n" +
                "        .appendItem(coloredGroup.createItem(\"Value3\", \"Morbi leo risus\").setBackground(Background.LIGHT_GREEN))\n" +
                "        .appendItem(coloredGroup.createItem(\"Value4\", \"Porta ac consectetur ac\").setBackground(Background.AMBER))\n" +
                "        .appendItem(coloredGroup.createItem(\"Value5\", \"Vestibulum at eros\").setBackground(Background.DEEP_PURPLE));\n" +
                "\n" +
                "row.addColumn(column.copy().addElement(Card.create(\"MATERIAL DESIGN COLORS\", \"Use Material design background colors to style list items.\")\n" +
                "        .appendContent(coloredGroup.asElement()).asElement()));";
    }

    public static String richItems() {
        return "ListGroup<String> listGroup = ListGroup.create();\n" +
                "listGroup\n" +
                "        .appendItem(listGroup.createItem(\"value1\", SAMPLE_CONTENT).setHeading(\"Cras justo odio\"))\n" +
                "        .appendItem(listGroup.createItem(\"value2\", SAMPLE_CONTENT).setHeading(\"Dapibus ac facilisis in\"))\n" +
                "        .appendItem(listGroup.createItem(\"value3\", SAMPLE_CONTENT).setHeading(\"Morbi leo risus\"))\n" +
                "        .appendItem(listGroup.createItem(\"value4\", SAMPLE_CONTENT).setHeading(\"Porta ac consectetur ac\").select())\n" +
                "        .appendItem(listGroup.createItem(\"value5\", SAMPLE_CONTENT).setHeading(\"Vestibulum at eros\"));\n" +
                "\n" +
                "element.appendChild(Card.create(\"RICH ITEMS\", \"Add rich items with header and description.\")\n" +
                "        .appendContent(listGroup.asElement()).asElement());";
    }
}

