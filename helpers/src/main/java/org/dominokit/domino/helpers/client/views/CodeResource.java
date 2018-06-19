package org.dominokit.domino.helpers.client.views;

public class CodeResource {

    public static String textStyles() {
        return "Row row = Row.create();\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.two)\n" +
                "        .onMedium(Column.OnMedium.two)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Card.create(\"TEXT STYLES\", \"Use ready classes to style your paragraphs.\")\n" +
                "        .appendContent(row\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Normal\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Bold\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").bold().asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").bold().setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").bold().setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").bold().setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").bold().setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").bold().setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Italic\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").italic().asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").italic().setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").italic().setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").italic().setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").italic().setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").italic().setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Underline\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").underLine().asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").underLine().setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").underLine().setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").underLine().setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").underLine().setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").underLine().setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Line through\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").lineThrough().asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").lineThrough().setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").lineThrough().setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").lineThrough().setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").lineThrough().setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").lineThrough().setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Over line\").asElement()).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Default text\").overLine().asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text pink color\").overLine().setColor(Color.PINK).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text cyan color\").overLine().setColor(Color.CYAN).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text teal color\").overLine().setColor(Color.TEAL).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text orange color\").overLine().setColor(Color.ORANGE).asElement())\n" +
                "                        .addElement(Paragraph.create(\"Text blue grey color\").overLine().setColor(Color.BLUE_GREY).asElement())\n" +
                "                )\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String fontSize() {
        return "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.two)\n" +
                "        .onMedium(Column.OnMedium.two)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Card.create(\"FONT SIZES\", \"Use ready classes to change text font size.\")\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_6).textContent(\"font-6\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_10).textContent(\"font-10\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_12).textContent(\"font-12\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_15).textContent(\"font-15\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_20).textContent(\"font-20\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_24).textContent(\"font-24\").asElement()))\n" +
                "                .asElement())\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_32).textContent(\"font-32\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_40).textContent(\"font-40\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_42).textContent(\"font-42\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_45).textContent(\"font-45\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_48).textContent(\"font-48\").asElement()))\n" +
                "                .addColumn(column.copy().addElement(div().css(Styles.font_50).textContent(\"font-50\").asElement()))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String textAligns() {
        return "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.three)\n" +
                "        .onMedium(Column.OnMedium.three)\n" +
                "        .onSmall(Column.OnSmall.twelve)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Card.create(\"TEXT ALIGNS\", \"You can use ready classes to change text alignment.\")\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Align left\").asElement()).alignLeft().asElement())\n" +
                "                        .addElement(div().css(Styles.align_left).textContent(SAMPLE_TEXT).asElement())\n" +
                "                )\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Align center\").asElement()).alignCenter().asElement())\n" +
                "                        .addElement(div().css(Styles.align_center).textContent(SAMPLE_TEXT).asElement())\n" +
                "                )\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Align right\").asElement()).alignRight().asElement())\n" +
                "                        .addElement(div().css(Styles.align_right).textContent(SAMPLE_TEXT).asElement())\n" +
                "                )\n" +
                "                .addColumn(column.copy()\n" +
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Align justify\").asElement()).alignJustify().asElement())\n" +
                "                        .addElement(div().css(Styles.align_justify).textContent(SAMPLE_TEXT).asElement())\n" +
                "                )\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }
}

