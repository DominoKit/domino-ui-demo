package org.dominokit.domino.popover.client.views;

public class CodeResource {

    public static String tooltips() {
        return "HTMLElement tooltip_on_right = Button.createPrimary(\"TOOLTIP ON RIGHT\").block().asElement();\n" +
                "\n" +
                "Tooltip.create(tooltip_on_right, \"Tooltip on right\")\n" +
                "        .position(PopupPosition.RIGHT);\n" +
                "\n" +
                "HTMLElement tooltip_on_top = Button.createPrimary(\"TOOLTIP ON TOP\").block().asElement();\n" +
                "\n" +
                "Tooltip.create(tooltip_on_top, \"Tooltip on top\")\n" +
                "        .position(PopupPosition.TOP);\n" +
                "\n" +
                "HTMLElement tooltip_on_bottom = Button.createPrimary(\"TOOLTIP ON BOTTOM\").block().asElement();\n" +
                "\n" +
                "Tooltip.create(tooltip_on_bottom, \"Tooltip on bottom\")\n" +
                "        .position(PopupPosition.BOTTOM);\n" +
                "\n" +
                "HTMLElement tooltip_on_left = Button.createPrimary(\"TOOLTIP ON LEFT\").block().asElement();\n" +
                "\n" +
                "Tooltip.create(tooltip_on_left, \"Tooltip on left\")\n" +
                "        .position(PopupPosition.LEFT);\n" +
                "\n" +
                "element.appendChild(Card.create(\"TOOLTIPS\")\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(tooltip_on_right))\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(tooltip_on_top))\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(tooltip_on_bottom))\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(tooltip_on_left))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String popover() {
        return "HTMLElement popover_on_right = Button.createPrimary(\"POPOVER ON RIGHT\").block().asElement();\n" +
                "\n" +
                "Popover.create(popover_on_right, \"Popover on right\", Paragraph.create(\"Vivamus sagittis lacus vel augue laoreet rutrum faucibus.\").asElement())\n" +
                "        .position(PopupPosition.RIGHT);\n" +
                "\n" +
                "HTMLElement popover_on_top = Button.createPrimary(\"POPOVER ON TOP\").block().asElement();\n" +
                "\n" +
                "Popover.create(popover_on_top, \"Popover on right\", Paragraph.create(\"Vivamus sagittis lacus vel augue laoreet rutrum faucibus.\").asElement())\n" +
                "        .position(PopupPosition.TOP);\n" +
                "\n" +
                "HTMLElement popover_on_bottom = Button.createPrimary(\"POPOVER ON BOTTOM\").block().asElement();\n" +
                "\n" +
                "Popover.create(popover_on_bottom, \"Popover on right\", Paragraph.create(\"Vivamus sagittis lacus vel augue laoreet rutrum faucibus.\").asElement())\n" +
                "        .position(PopupPosition.BOTTOM);\n" +
                "\n" +
                "HTMLElement popover_on_left = Button.createPrimary(\"POPOVER ON LEFT\").block().asElement();\n" +
                "\n" +
                "Popover.create(popover_on_left, \"Popover on right\", Paragraph.create(\"Vivamus sagittis lacus vel augue laoreet rutrum faucibus.\").asElement())\n" +
                "        .position(PopupPosition.LEFT);\n" +
                "\n" +
                "element.appendChild(Card.create(\"POPOVER\")\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(popover_on_right))\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(popover_on_top))\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(popover_on_bottom))\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(popover_on_left))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }
}
