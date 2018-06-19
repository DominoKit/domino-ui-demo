package org.dominokit.domino.thumbnails.client.views;

public class CodeResource {

    public static String basicSample() {
        return "element.appendChild(Card.create(\"DEFAULT EXAMPLE\", \"By default, thumbnails are designed to showcase linked images with minimal required markup\")\n" +
                "    .appendContent(Row.create()\n" +
                "            .addColumn(column.copy().addElement(Thumbnail.create()\n" +
                "                    .setContent(a()\n" +
                "                            .add(img(GWT.getModuleBaseURL() + \"/images/image-gallery/5.jpg\")\n" +
                "                                    .css(Styles.img_responsive).asElement())\n" +
                "                            .asElement())\n" +
                "                    .asElement()))\n" +
                "            .addColumn(column.copy().addElement(Thumbnail.create()\n" +
                "                    .setContent(a()\n" +
                "                            .add(img(GWT.getModuleBaseURL() + \"/images/image-gallery/6.jpg\")\n" +
                "                                    .css(Styles.img_responsive).asElement())\n" +
                "                            .asElement())\n" +
                "                    .asElement()))\n" +
                "            .addColumn(column.copy().addElement(Thumbnail.create()\n" +
                "                    .setContent(a()\n" +
                "                            .add(img(GWT.getModuleBaseURL() + \"/images/image-gallery/7.jpg\")\n" +
                "                                    .css(Styles.img_responsive).asElement())\n" +
                "                            .asElement())\n" +
                "                    .asElement()))\n" +
                "            .addColumn(column.copy().addElement(Thumbnail.create()\n" +
                "                    .setContent(a()\n" +
                "                            .add(img(GWT.getModuleBaseURL() + \"/images/image-gallery/8.jpg\")\n" +
                "                                    .css(Styles.img_responsive).asElement())\n" +
                "                            .asElement())\n" +
                "                    .asElement()))\n" +
                "            .asElement())\n" +
                "    .asElement());";
    }

    public static String withExtraContentSample() {
        return "element.appendChild(Card.create(\"CUSTOM CONTENT\", \"With a bit of extra markup, it's possible to add any kind of HTML content like headings, paragraphs, or buttons into thumbnails.\")\n" +
                "    .appendContent(Row.create()\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(Thumbnail.create()\n" +
                "                            .setContent(a().add(img(GWT.getModuleBaseURL() + \"/images/image-gallery/1.jpg\")\n" +
                "                                    .css(Styles.img_responsive)\n" +
                "                                    .asElement())\n" +
                "                                    .asElement())\n" +
                "                            .appendCaptionContent(h(3).textContent(\"Thumbnail label\").asElement())\n" +
                "                            .appendCaptionContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                            .appendCaptionContent(Button.createPrimary(\"BUTTON\").asElement())\n" +
                "                            .asElement()))\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(Thumbnail.create()\n" +
                "                            .setContent(a().add(img(GWT.getModuleBaseURL() + \"/images/image-gallery/2.jpg\")\n" +
                "                                    .css(Styles.img_responsive)\n" +
                "                                    .asElement())\n" +
                "                                    .asElement())\n" +
                "                            .appendCaptionContent(h(3).textContent(\"Thumbnail label\").asElement())\n" +
                "                            .appendCaptionContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                            .appendCaptionContent(Button.createPrimary(\"BUTTON\").asElement())\n" +
                "                            .asElement()))\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(Thumbnail.create()\n" +
                "                            .setContent(a().add(img(GWT.getModuleBaseURL() + \"/images/image-gallery/3.jpg\")\n" +
                "                                    .css(Styles.img_responsive)\n" +
                "                                    .asElement())\n" +
                "                                    .asElement())\n" +
                "                            .appendCaptionContent(h(3).textContent(\"Thumbnail label\").asElement())\n" +
                "                            .appendCaptionContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                            .appendCaptionContent(Button.createPrimary(\"BUTTON\").asElement())\n" +
                "                            .asElement()))\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(Thumbnail.create()\n" +
                "                            .setContent(a().add(img(GWT.getModuleBaseURL() + \"/images/image-gallery/4.jpg\")\n" +
                "                                    .css(Styles.img_responsive)\n" +
                "                                    .asElement())\n" +
                "                                    .asElement())\n" +
                "                            .appendCaptionContent(h(3).textContent(\"Thumbnail label\").asElement())\n" +
                "                            .appendCaptionContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                            .appendCaptionContent(Button.createPrimary(\"BUTTON\").asElement())\n" +
                "                            .asElement()))\n" +
                "            .asElement())\n" +
                "    .asElement());";
    }

}
