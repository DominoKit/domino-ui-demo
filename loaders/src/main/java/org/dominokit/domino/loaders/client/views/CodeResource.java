package org.dominokit.domino.loaders.client.views;

public class CodeResource {

    public static String loadersSample() {
        return "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.four)\n" +
                "        .onMedium(Column.OnMedium.four)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "Row row = Row.create();\n" +
                "element.appendChild(row.asElement());\n" +
                "\n" +
                "row.addColumn(column\n" +
                "        .addElement(createCard(LoaderEffect.BOUNCE, \"Loading ... \", Background.BLUE_GREY, Background.BLUE_GREY)\n" +
                "        .asElement()));\n" +
                "row.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.FACEBOOK, \"Loading ... \", Background.LIGHT_BLUE, Background.BLUE)\n" +
                "        .asElement()));\n" +
                "row.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.IOS, \"Loading ... \", Background.LIGHT_GREEN, Background.GREEN)\n" +
                "        .asElement()));\n" +
                "\n" +
                "\n" +
                "Row secondRow = Row.create();\n" +
                "element.appendChild(secondRow.asElement());\n" +
                "\n" +
                "secondRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.ROTATE_PLANE, \"Waiting ... \", Background.BLUE_GREY, Background.BLUE_GREY)\n" +
                "        .asElement()));\n" +
                "secondRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.ROTATION, \"Waiting ... \", Background.LIGHT_BLUE, Background.BLUE)\n" +
                "        .asElement()));\n" +
                "secondRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.ROUND_BOUNCE, \"Waiting ... \", Background.LIGHT_GREEN, Background.GREEN)\n" +
                "        .asElement()));\n" +
                "\n" +
                "\n" +
                "Row thirdRow = Row.create();\n" +
                "element.appendChild(thirdRow.asElement());\n" +
                "\n" +
                "thirdRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.TIMER, \" ... \", Background.BLUE_GREY, Background.BLUE_GREY)\n" +
                "        .asElement()));\n" +
                "thirdRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.WIN8, \" ... \", Background.LIGHT_BLUE, Background.BLUE)\n" +
                "        .asElement()));\n" +
                "thirdRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.WIN8_LINEAR, \" ... \", Background.LIGHT_GREEN, Background.GREEN)\n" +
                "        .asElement()));\n" +
                "\n" +
                "\n" +
                "Row fourthRow = Row.create();\n" +
                "element.appendChild(fourthRow.asElement());\n" +
                "\n" +
                "fourthRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.ORBIT, \"\", Background.BLUE_GREY, Background.BLUE_GREY)\n" +
                "        .asElement()));\n" +
                "fourthRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.STRETCH, \"\", Background.LIGHT_BLUE, Background.BLUE)\n" +
                "        .asElement()));\n" +
                "fourthRow.addColumn(column.copy()\n" +
                "        .addElement(createCard(LoaderEffect.NONE, \"\", Background.LIGHT_GREEN, Background.GREEN)\n" +
                "        .asElement()));\n" +
                "\n" +
                "//------------------------------\n" +
                "\n" +
                "private Card createCard(LoaderEffect effect, String loadingText, Background bodyBackground, Background headerBackground) {\n" +
                "    Card card = Card.create(effect.toString(), effect.toString().toLowerCase() + \" loader effect.\")\n" +
                "            .setBodyBackground(bodyBackground)\n" +
                "            .setHeaderBackground(headerBackground);\n" +
                "\n" +
                "    EventListener loaderListener = e -> {\n" +
                "        Loader loader = Loader.create(card.asElement(), effect)\n" +
                "                .setLoadingText(loadingText)\n" +
                "                .start();\n" +
                "        new Timer() {\n" +
                "            @Override\n" +
                "            public void run() {\n" +
                "                loader.stop();\n" +
                "            }\n" +
                "        }.schedule(7000);\n" +
                "    };\n" +
                "\n" +
                "    Button button = Button.createDefault(\"CLICK ME\").addClickListener(loaderListener);\n" +
                "    card.appendContent(new Text(SAMPLE_CONTENT))\n" +
                "            .appendContent(Elements.br().asElement())\n" +
                "            .appendContent(Elements.br().asElement())\n" +
                "    .appendContent(Elements.div().attr(\"style\", \"text-align: center\").add(button.asElement()).asElement());\n" +
                "\n" +
                "    return card;\n" +
                "}";
    }
}

