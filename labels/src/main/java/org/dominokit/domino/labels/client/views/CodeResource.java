package org.dominokit.domino.labels.client.views;

public class CodeResource {

    public static String initLabels() {
        return "Label.createDefault(\"DEFAULT\").asElement();\n" +
                "Label.createPrimary(\"PRIMARY\").asElement();\n" +
                "Label.createSuccess(\"SUCCESS\").asElement();\n" +
                "Label.createInfo(\"INFO\").asElement();\n" +
                "Label.createWarning(\"WARNING\").asElement();\n" +
                "Label.createDanger(\"DANGER\").asElement();";
    }

    public static String initMaterialLabels() {
        return "Label.create(\"Red\").setBackground(Color.RED).asElement();\n" +
                "Label.create(\"Pink\").setBackground(Color.PINK).asElement();\n" +
                "Label.create(\"Purple\").setBackground(Color.PURPLE).asElement();\n" +
                "Label.create(\"Deep Purple\").setBackground(Color.DEEP_PURPLE).asElement();\n" +
                "Label.create(\"Indigo\").setBackground(Color.INDIGO).asElement();\n" +
                "Label.create(\"Blue\").setBackground(Color.BLUE).asElement();\n" +
                "Label.create(\"Light Blue\").setBackground(Color.LIGHT_BLUE).asElement();\n" +
                "Label.create(\"Cyan\").setBackground(Color.CYAN).asElement();\n" +
                "Label.create(\"Teal\").setBackground(Color.TEAL).asElement();";
    }
}

