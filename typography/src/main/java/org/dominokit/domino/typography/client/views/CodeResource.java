package org.dominokit.domino.typography.client.views;

public class CodeResource {

    public static String bodyCopy() {
        return "element.appendChild(Card.create(\"BODY COPY\", \"Use LEAD style make a paragraph with larger fonts on big screens.\")\n" +
                "        .appendContent(p().css(Styles.LEAD).textContent(SMALLER_PARAGRAPH).asElement())\n" +
                "        .appendContent(p().textContent(LARGE_PARAGRAPH).asElement())\n" +
                "        .appendContent(p().textContent(SMALL_PARAGRAPH).asElement())\n" +
                "        .asElement());";
    }

    public static String heading() {
        return "element.appendChild(Card.create(\"HEADINGS\")\n" +
                "        .appendContent(h(1).textContent(\"h1. Text Heading.\").asElement())\n" +
                "        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "        .appendContent(h(2).textContent(\"h2. Text Heading.\").asElement())\n" +
                "        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "        .appendContent(h(3).textContent(\"h3. Text Heading.\").asElement())\n" +
                "        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "        .appendContent(h(4).textContent(\"h4. Text Heading.\").asElement())\n" +
                "        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "        .appendContent(h(5).textContent(\"h5. Text Heading.\").asElement())\n" +
                "        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "        .appendContent(h(6).textContent(\"h6. Text Heading.\").asElement())\n" +
                "        .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "        .asElement());";
    }

    public static String textStyles() {
        return "element.appendChild(Card.create(\"TEXT STYLES\", \"Use ready classes to style your paragraphs.\")\n" +
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
                "                        .addElement(Paragraph.create().appendContent(b().textContent(\"Under line\").asElement()).asElement())\n" +
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

    public static String blockqoute() {
        return "element.appendChild(Card.create(\"BLOCKQUOTES\")\n" +
                "        .appendContent(Blockquote.create(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.\")\n" +
                "                .asElement())\n" +
                "        .appendContent(Blockquote.create(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.\")\n" +
                "                .appendFooterContent(new Text(\"Someone famous in \"))\n" +
                "                .appendFooterContent(cite().textContent(\"source title.\").asElement())\n" +
                "                .asElement())\n" +
                "        .appendContent(Blockquote.create(\"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.\")\n" +
                "                .appendFooterContent(new Text(\"Someone famous in \"))\n" +
                "                .appendFooterContent(cite().textContent(\"source title.\").asElement())\n" +
                "                .reverse()\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String lists() {
        return "element.appendChild(row\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(Card.create(\"UNORDERED LIST\")\n" +
                "                        .appendContent(ul()\n" +
                "                                .add(li().textContent(\"Lorem ipsum dolor sit amet\"))\n" +
                "                                .add(li().textContent(\"Consectetur adipiscing elit\"))\n" +
                "                                .add(li().textContent(\"Integer molestie lorem at massa\"))\n" +
                "                                .add(li().textContent(\"Facilisis in pretium nisl aliquet\"))\n" +
                "                                .add(li().textContent(\"Nulla volutpat aliquam velit\")\n" +
                "                                        .add(ul()\n" +
                "                                                .add(li().textContent(\"Phasellus iaculis neque\"))\n" +
                "                                                .add(li().textContent(\"Purus sodales ultricies\"))\n" +
                "                                                .add(li().textContent(\"Vestibulum laoreet porttitor sem\"))\n" +
                "                                                .add(li().textContent(\"Ac tristique libero volutpat at\"))\n" +
                "                                        )\n" +
                "                                )\n" +
                "                                .add(li().textContent(\"Faucibus porta lacus fringilla vel\"))\n" +
                "                                .add(li().textContent(\"Aenean sit amet erat nunc\"))\n" +
                "                                .add(li().textContent(\"Eget porttitor lorem\"))\n" +
                "                                .asElement())\n" +
                "                        .asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(Card.create(\"ORDERED LIST\")\n" +
                "                        .appendContent(ol()\n" +
                "                                .add(li().textContent(\"Lorem ipsum dolor sit amet\"))\n" +
                "                                .add(li().textContent(\"Consectetur adipiscing elit\"))\n" +
                "                                .add(li().textContent(\"Integer molestie lorem at massa\"))\n" +
                "                                .add(li().textContent(\"Facilisis in pretium nisl aliquet\"))\n" +
                "                                .add(li().textContent(\"Nulla volutpat aliquam velit\")\n" +
                "                                        .add(ol()\n" +
                "                                                .add(li().textContent(\"Phasellus iaculis neque\"))\n" +
                "                                                .add(li().textContent(\"Purus sodales ultricies\"))\n" +
                "                                                .add(li().textContent(\"Vestibulum laoreet porttitor sem\"))\n" +
                "                                                .add(li().textContent(\"Ac tristique libero volutpat at\"))\n" +
                "                                        )\n" +
                "                                )\n" +
                "                                .add(li().textContent(\"Faucibus porta lacus fringilla vel\"))\n" +
                "                                .add(li().textContent(\"Aenean sit amet erat nunc\"))\n" +
                "                                .add(li().textContent(\"Eget porttitor lorem\"))\n" +
                "                                .asElement())\n" +
                "                        .asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(Card.create(\"UNSTYLED LIST\")\n" +
                "                        .appendContent(ul().css(Styles.LIST_UNSTYLED)\n" +
                "                                .add(li().textContent(\"Lorem ipsum dolor sit amet\"))\n" +
                "                                .add(li().textContent(\"Consectetur adipiscing elit\"))\n" +
                "                                .add(li().textContent(\"Integer molestie lorem at massa\"))\n" +
                "                                .add(li().textContent(\"Facilisis in pretium nisl aliquet\"))\n" +
                "                                .add(li().textContent(\"Nulla volutpat aliquam velit\")\n" +
                "                                        .add(ul()\n" +
                "                                                .add(li().textContent(\"Phasellus iaculis neque\"))\n" +
                "                                                .add(li().textContent(\"Purus sodales ultricies\"))\n" +
                "                                                .add(li().textContent(\"Vestibulum laoreet porttitor sem\"))\n" +
                "                                                .add(li().textContent(\"Ac tristique libero volutpat at\"))\n" +
                "                                        )\n" +
                "                                )\n" +
                "                                .add(li().textContent(\"Faucibus porta lacus fringilla vel\"))\n" +
                "                                .add(li().textContent(\"Aenean sit amet erat nunc\"))\n" +
                "                                .add(li().textContent(\"Eget porttitor lorem\"))\n" +
                "                                .asElement())\n" +
                "                        .asElement()))\n" +
                "        .asElement());";
    }

}

