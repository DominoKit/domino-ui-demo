package org.dominokit.domino.cards.client.views;

public class CodeResource {

    public static String cardsWithHeaders() {
        return "Column column = Column.create()\n" +
                "                .onLarge(OnLarge.four)\n" +
                "                .onMedium(OnMedium.four)\n" +
                "                .onSmall(OnSmall.twelve)\n" +
                "                .onXSmall(OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> DomGlobal.console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> DomGlobal.console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());";
    }

    public static String coloredCards() {
        return "Column column = Column.create()\n" +
                "        .onLarge(OnLarge.four)\n" +
                "        .onMedium(OnMedium.four)\n" +
                "        .onSmall(OnSmall.twelve)\n" +
                "        .onXSmall(OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(Card.create(\"Light Blue Card\", \"Description text here...\")\n" +
                "                .setBackground(Color.LIGHT_BLUE)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> DomGlobal.console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Light Green Card\", \"Description text here...\")\n" +
                "                .setBackground(Color.LIGHT_GREEN)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Amber card\", \"Description text here...\")\n" +
                "                .setBackground(Color.AMBER)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> DomGlobal.console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Pink Card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Color.PINK)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> DomGlobal.console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Blue Grey Card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Color.BLUE_GREY)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Deep Orange card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Color.DEEP_ORANGE)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> DomGlobal.console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Light Blue Card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Color.BLUE)\n" +
                "                .setBodyBackground(Color.LIGHT_BLUE)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> DomGlobal.console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Light Green Card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Color.GREEN)\n" +
                "                .setBodyBackground(Color.LIGHT_GREEN)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Amber card\", \"Description text here...\")\n" +
                "                .setHeaderBackground(Color.ORANGE)\n" +
                "                .setBodyBackground(Color.AMBER)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> DomGlobal.console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());";
    }

    public static String collapsibleCards() {
        return "Column column = Column.create()\n" +
                "        .onLarge(OnLarge.four)\n" +
                "        .onMedium(OnMedium.four)\n" +
                "        .onSmall(OnSmall.twelve)\n" +
                "        .onXSmall(OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .setCollapsible()\n" +
                "                .setHeaderBackground(Color.THEME)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.ALL.more_vert(), event -> DomGlobal.console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .setCollapsible()\n" +
                "                .setHeaderBackground(Color.BROWN)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info(\"Play sound\"))\n" +
                "                .asElement()))\n" +
                "\n" +
                "        .addColumn(column.copy().addElement(Card.create(\"Card Title\", \"Description text here...\")\n" +
                "                .setCollapsible()\n" +
                "                .collapse()\n" +
                "                .setHeaderBackground(Color.CYAN)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT))\n" +
                "                .addHeaderAction(Icons.AV_ICONS.mic(), event -> DomGlobal.console.info(\"Play sound\"))\n" +
                "                .addHeaderAction(Icons.NAVIGATION_ICONS.more_vert(), event -> DomGlobal.console.info(\"More action selected\"))\n" +
                "                .asElement()))\n" +
                "        .asElement());";
    }

    public static String noHeaderCards() {
        return "Column column = Column.create().onLarge(OnLarge.four)\n" +
                "        .onMedium(OnMedium.four)\n" +
                "        .onSmall(OnSmall.twelve)\n" +
                "        .onXSmall(OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(Card.create()\n" +
                "                .setBackground(Color.GREEN)\n" +
                "                .appendContent(new Text(SAMPLE_CONTENT)).asElement()))\n" +
                "        .addColumn(column.copy().addElement(Card.create()\n" +
                "                .setBackground(Color.LIGHT_BLUE).appendContent(new Text(SAMPLE_CONTENT)).asElement()))\n" +
                "        .addColumn(column.copy().addElement(Card.create()\n" +
                "                .setBackground(Color.PURPLE).appendContent(new Text(SAMPLE_CONTENT)).asElement()))\n" +
                "        .asElement());";
    }

}

