package org.dominokit.domino.media.client.views;

public class CodeResource {

    public static String defaultMedia() {
        return "element.appendChild(Card.create(\"DEFAULT MEDIA\",\n" +
                "            \"The default media displays a media object (images, video, audio) to the left or right of a content block.\")\n" +
                "        .appendContent(MediaObject.create()\n" +
                "                .setHeader(\"Media heading\")\n" +
                "                .setLeftMedia(a().add(img(\"http://placehold.it/64x64\")\n" +
                "                        .attr(\"width\", \"64\")\n" +
                "                        .attr(\"height\", \"64\"))\n" +
                "                        .asElement())\n" +
                "                .appendContent(new Text(SAMPLE_TEXT))\n" +
                "                .asElement())\n" +
                "        .appendContent(MediaObject.create()\n" +
                "                .setHeader(\"Media heading\")\n" +
                "                .setLeftMedia(a().add(img(\"http://placehold.it/64x64\")\n" +
                "                        .attr(\"width\", \"64\")\n" +
                "                        .attr(\"height\", \"64\"))\n" +
                "                        .asElement())\n" +
                "                .appendContent(new Text(SAMPLE_TEXT))\n" +
                "                .appendContent(MediaObject.create()\n" +
                "                        .setHeader(\"Media heading\")\n" +
                "                        .setLeftMedia(a().add(img(\"http://placehold.it/64x64\")\n" +
                "                                .attr(\"width\", \"64\")\n" +
                "                                .attr(\"height\", \"64\"))\n" +
                "                                .asElement())\n" +
                "                        .appendContent(new Text(SAMPLE_TEXT))\n" +
                "                        .asElement())\n" +
                "                .asElement())\n" +
                "        .appendContent(MediaObject.create()\n" +
                "                .setHeader(\"Media heading\")\n" +
                "                .setRightMedia(a().add(img(\"http://placehold.it/64x64\")\n" +
                "                        .attr(\"width\", \"64\")\n" +
                "                        .attr(\"height\", \"64\"))\n" +
                "                        .asElement())\n" +
                "                .appendContent(new Text(SAMPLE_TEXT))\n" +
                "                .asElement())\n" +
                "        .appendContent(MediaObject.create()\n" +
                "                .setHeader(\"Media heading\")\n" +
                "                .setRightMedia(a().add(img(\"http://placehold.it/64x64\")\n" +
                "                        .attr(\"width\", \"64\")\n" +
                "                        .attr(\"height\", \"64\"))\n" +
                "                        .asElement())\n" +
                "                .setLeftMedia(a().add(img(\"http://placehold.it/64x64\")\n" +
                "                        .attr(\"width\", \"64\")\n" +
                "                        .attr(\"height\", \"64\"))\n" +
                "                        .asElement())\n" +
                "                .appendContent(new Text(SAMPLE_TEXT))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String mediaAlignment() {
        return "element.appendChild(Card.create(\"MEDIA ALIGNMENT\",\"The images or other media can be aligned top, middle, or bottom. The default is top aligned.\")\n" +
                "        .appendContent(MediaObject.create()\n" +
                "                .setHeader(\"Media heading\")\n" +
                "                .setLeftMedia(a().add(img(\"http://placehold.it/64x64\")\n" +
                "                        .attr(\"width\", \"64\")\n" +
                "                        .attr(\"height\", \"64\"))\n" +
                "                        .asElement())\n" +
                "                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                .asElement())\n" +
                "        .appendContent(MediaObject.create()\n" +
                "                .setHeader(\"Media heading\")\n" +
                "                .setLeftMedia(a().add(img(\"http://placehold.it/64x64\")\n" +
                "                        .attr(\"width\", \"64\")\n" +
                "                        .attr(\"height\", \"64\"))\n" +
                "                        .asElement())\n" +
                "                .alignLeftMedia(MediaObject.MediaAlign.MIDDLE)\n" +
                "                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                .asElement())\n" +
                "        .appendContent(MediaObject.create()\n" +
                "                .setHeader(\"Media heading\")\n" +
                "                .setLeftMedia(a().add(img(\"http://placehold.it/64x64\")\n" +
                "                        .attr(\"width\", \"64\")\n" +
                "                        .attr(\"height\", \"64\"))\n" +
                "                        .asElement())\n" +
                "                .alignLeftMedia(MediaObject.MediaAlign.BOTTOM)\n" +
                "                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                .appendContent(Paragraph.create(SAMPLE_TEXT).asElement())\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }
}
