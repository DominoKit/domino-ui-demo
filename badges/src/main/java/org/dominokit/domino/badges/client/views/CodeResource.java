package org.dominokit.domino.badges.client.views;

public class CodeResource{

    public static String buttonExample(){
        return "Button.createSuccess(SUCCESS).large().block()\n" +
                "        .appendContent(Badge.create(\"4\").asElement())\n" +
                "        .asElement();\n" +
                "\n" +
                "Button.createPrimary(PRIMARY).large().block()\n" +
                "        .appendContent(Badge.create(\"10\").asElement())\n" +
                "        .asElement();\n" +
                "\n" +
                "Button.createDanger(DANGER).large().block()\n" +
                "        .appendContent(Badge.create(\"8\").asElement())\n" +
                "        .asElement();\n" +
                "\n" +
                "Button.createWarning(WARNING).large().block()\n" +
                "        .appendContent(Badge.create(\"3\").asElement())\n" +
                "        .asElement();";
    }

    public static String buttonExamplesWithMaterialDesignColors(){
        return "Button.create(\"GREEN\").setBackground(Color.GREEN).large().block()\n" +
                "        .appendContent(Badge.create(\"2\").asElement())\n" +
                "        .asElement();\n" +
                "Button.create(\"BLUE\").setBackground(Color.BLUE).large().block()\n" +
                "        .appendContent(Badge.create(\"10+\").asElement())\n" +
                "        .asElement();\n" +
                "Button.create(\"RED\").setBackground(Color.RED).large().block()\n" +
                "        .appendContent(Badge.create(\"13\").asElement())\n" +
                "        .asElement();\n" +
                "Button.create(\"ORANGE\").setBackground(Color.ORANGE).large().block()\n" +
                "        .appendContent(Badge.create(\"5\").asElement())\n" +
                "        .asElement();\n" +
                "Button.create(\"PINK\").setBackground(Color.PINK).large().block()\n" +
                "        .appendContent(Badge.create(\"14\").asElement())\n" +
                "        .asElement();\n" +
                "Button.create(\"CYAN\").setBackground(Color.CYAN).large().block()\n" +
                "        .appendContent(Badge.create(\"99+\").asElement())\n" +
                "        .asElement();\n" +
                "Button.create(\"TEAL\").setBackground(Color.TEAL).large().block()\n" +
                "        .appendContent(Badge.create(\"26\").asElement())\n" +
                "        .asElement();\n" +
                "Button.create(\"PURPLE\").setBackground(Color.PURPLE).large().block()\n" +
                "        .appendContent(Badge.create(\"47\").asElement())\n" +
                "        .asElement();";
    }

    public static String listExample(){
        return "ListGroup<String> listGroup = ListGroup.create();\n" +
                "listGroup.addItem(\"SomeValue\").setText(\"Cras justo odio\")\n" +
                "    .appendContent(Badge.create(\"14 new\").setBackground(Color.RED).asElement());\n" +
                "listGroup.addItem(\"SomeValue\").setText(\"Dapibus ac facilisis in\")\n" +
                "    .appendContent(Badge.create(\"99 unread\").setBackground(Color.CYAN).asElement());\n" +
                "listGroup.addItem(\"SomeValue\").setText(\"Morbi leo risus\")\n" +
                "    .appendContent(Badge.create(\"99+\").setBackground(Color.TEAL).asElement());\n" +
                "listGroup.addItem(\"SomeValue\").setText(\"Porta ac consectetur ac\")\n" +
                "    .appendContent(Badge.create(\"21\").setBackground(Color.ORANGE).asElement());\n" +
                "listGroup.addItem(\"SomeValue\").setText(\"Vestibulum at eros\")\n" +
                "    .appendContent(Badge.create(\"18\").setBackground(Color.PURPLE).asElement());";
    }

}

