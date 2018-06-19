package org.dominokit.domino.alerts.client.views;

public class CodeResource{


    public static String basicAlerts(){
        return "element.appendChild(Card.create(\"BASIC ALERTS\", \"Use one of the pre-customized alert types.\")\n" +
                "                .appendContent(Alert.success().appendStrong(\"Well done! \")\n" +
                "                    .appendText(\"You successfully read this important alert message.\").asElement())\n" +
                "                .appendContent(Alert.info().appendStrong(\"Heads up! \")\n" +
                "                    .appendText(\"This alert needs your attention, but it's not super important.\").asElement())\n" +
                "                .appendContent(Alert.warning().appendStrong(\"Warning! \")\n" +
                "                    .appendText(\"Better check yourself, you're not looking too good.\").asElement())\n" +
                "                .appendContent(Alert.error().appendStrong(\"Oh snap! \").appendText(\"Change a few things up and try submitting again.\")\n" +
                "                    .asElement())\n" +
                "                .asElement());";
    }

    public static String customBackgrounds(){
        return "element.appendChild(Card.create(\"MATERIAL DESIGN ALERTS\", \"ou can use material design colors backgrounds\")\n" +
                "                .appendContent(Alert.create(Color.PINK)\n" +
                "                        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "                        .asElement())\n" +
                "                .appendContent(Alert.create(Color.ORANGE)\n" +
                "                        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "                        .asElement())\n" +
                "                .appendContent(Alert.create(Color.TEAL)\n" +
                "                        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "                        .asElement())\n" +
                "                .appendContent(Alert.create(Color.GREEN)\n" +
                "                        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "                        .asElement())\n" +
                "                .appendContent(Alert.create(Color.RED)\n" +
                "                        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "                        .asElement())\n" +
                "                .asElement());";
    }

    public static String dismissibleAlerts(){
        return "element.appendChild(Card.create(\"DISMISSIBLE ALERTS\", \"Add a close button to any alert by making it dismissible\")\n" +
                "                .appendContent(Alert.warning()\n" +
                "                        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "                        .dismissible()\n" +
                "                        .asElement())\n" +
                "                .appendContent(Alert.create(Color.PINK)\n" +
                "                        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "                        .dismissible()\n" +
                "                        .asElement())\n" +
                "                .appendContent(Alert.create(Color.TEAL)\n" +
                "                        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "                        .dismissible()\n" +
                "                        .asElement())\n" +
                "                .appendContent(Alert.create(Color.GREEN)\n" +
                "                        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "                        .dismissible()\n" +
                "                        .asElement())\n" +
                "                .asElement());";
    }

    public static String linksInAlerts(){
        return "element.appendChild(Card.create(\"LINKS IN ALERTS\", \"Use the appendLink utility class to quickly provide matching colored links within any alert.\")\n" +
                "            .appendContent(Alert.success()\n" +
                "                    .appendStrong(\"Well done! \")\n" +
                "                    .appendText(\"You successfully read \")\n" +
                "                    .appendLink(Elements.a().add(\"important alert message.\").asElement())\n" +
                "                    .asElement())\n" +
                "            .appendContent(Alert.info()\n" +
                "                    .appendStrong(\"Heads up! \")\n" +
                "                    .appendText(\"This \")\n" +
                "                    .appendLink(Elements.a().add(\"alert needs your attention, \").asElement())\n" +
                "                    .appendText(\"but it's not super important.\")\n" +
                "                    .asElement())\n" +
                "            .appendContent(Alert.warning()\n" +
                "                    .appendStrong(\"Warning! \")\n" +
                "                    .appendText(\"Better check yourself, \")\n" +
                "                    .appendLink(Elements.a().add(\"you're not looking too good.\").asElement())\n" +
                "                    .asElement())\n" +
                "            .appendContent(Alert.error()\n" +
                "                    .appendStrong(\"Oh snap! \")\n" +
                "                    .appendLink(Elements.a().add(\"Change a few things up\").asElement())\n" +
                "                    .appendText(\" and try submitting again.\")\n" +
                "                    .asElement())\n" +
                "            .appendContent(Alert.create(Color.PINK)\n" +
                "                    .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id \")\n" +
                "                    .appendLink(Elements.a().add(\"alert link.\").asElement())\n" +
                "                    .asElement())\n" +
                "            .asElement());";
    }
}
