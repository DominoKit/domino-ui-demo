package org.dominokit.domino.preloaders.client.views;

public class CodeResource {

    public static String sizesSample() {
        return "element.appendChild(Card.create(\"PRELOADERS - DIFFERENT SIZES\")\n" +
                "                .appendContent(div().css(\"demo-preloader\")\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setSize(Preloader.Size.xLarge)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setSize(Preloader.Size.large)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setSize(Preloader.Size.medium)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setSize(Preloader.Size.small)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setSize(Preloader.Size.xSmall)\n" +
                "                                .asElement())\n" +
                "                        .asElement())\n" +
                "                .asElement());";
    }

    public static String colorsSample() {
        return "element.appendChild(Card.create(\"WITH MATERIAL DESIGN COLORS\",\"You can use the material design colors.\")\n" +
                "                .appendContent(div().css(\"demo-preloader\")\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.RED)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.BLACK)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.BLUE_GREY)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.BLUE)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.GREY)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.BROWN)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.DEEP_ORANGE)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.ORANGE)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.LIME)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.LIGHT_GREEN)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.TEAL)\n" +
                "                                .asElement())\n" +
                "                        .add(Preloader.create()\n" +
                "                                .setColor(Color.INDIGO)\n" +
                "                                .asElement())\n" +
                "                        .asElement())\n" +
                "                .asElement());";
    }
}
