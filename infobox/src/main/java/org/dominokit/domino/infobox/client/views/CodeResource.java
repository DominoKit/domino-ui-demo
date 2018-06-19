package org.dominokit.domino.infobox.client.views;

public class CodeResource {

    public static String basicInfoBoxes() {
        return "Column column=Column.create()\n" +
                "        .onLarge(Column.OnLarge.three)\n" +
                "        .onMedium(Column.OnMedium.three)\n" +
                "        .onSmall(Column.OnSmall.six)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(InfoBox.create(Icons.ALL.shopping_cart(), \"NEW ORDERS\", \"125\")\n" +
                "                .setIconBackground(Color.RED).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.face(), \"NEW MEMBERS\", \"257\")\n" +
                "                .setIconBackground(Color.INDIGO).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.shopping_cart(), \"BOOKMARKS\", \"117\")\n" +
                "                .setIconBackground(Color.PURPLE).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.favorite(), \"LIKES\", \"1432\")\n" +
                "                .setIconBackground(Color.DEEP_PURPLE).asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "InfoBox new_orders = InfoBox.create(Icons.ALL.shopping_cart(), \"NEW ORDERS\", \"0\");\n" +
                "InfoBox new_members = InfoBox.create(Icons.ALL.face(), \"NEW MEMBERS\", \"0\");\n" +
                "InfoBox bookmarks = InfoBox.create(Icons.ALL.shopping_cart(), \"BOOKMARKS\", \"0\");\n" +
                "InfoBox likes = InfoBox.create(Icons.ALL.favorite(), \"LIKES\", \"0\");\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.copy().addElement(new_orders\n" +
                "                .setIconBackground(Background.RED).asElement()))\n" +
                "        .addColumn(column.copy().addElement(new_members\n" +
                "                .setIconBackground(Background.INDIGO).asElement()))\n" +
                "        .addColumn(column.copy().addElement(bookmarks\n" +
                "                .setIconBackground(Background.PURPLE).asElement()))\n" +
                "        .addColumn(column.copy().addElement(likes\n" +
                "                .setIconBackground(Background.DEEP_PURPLE).asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "counter = Counter.countFrom(0)\n" +
                "        .countTo(125)\n" +
                "        .every(40)\n" +
                "        .incrementBy(5)\n" +
                "        .onCount(count -> {\n" +
                "            new_orders.getValueElement().textContent = Integer.toString(count);\n" +
                "            new_members.getValueElement().textContent = Integer.toString(count);\n" +
                "            bookmarks.getValueElement().textContent = Integer.toString(count);\n" +
                "            likes.getValueElement().textContent = Integer.toString(count);\n" +
                "        });";
    }

    public static String hoverZoomEffect() {
        return "Column column=Column.create()\n" +
                "        .onLarge(Column.OnLarge.three)\n" +
                "        .onMedium(Column.OnMedium.three)\n" +
                "        .onSmall(Column.OnSmall.six)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(InfoBox.create(Icons.ALL.email(), \"MESSAGES\", \"15\")\n" +
                "                .setBackground(Color.PINK)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.devices(), \"CPU USAGE\", \"92%\")\n" +
                "                .setBackground(Color.BLUE)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.alarm(), \"ALARM\", \"07:00 AM\")\n" +
                "                .setBackground(Color.AMBER)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.gps_fixed(), \"LOCATION\", \"Jordan\")\n" +
                "                .setBackground(Color.DEEP_PURPLE)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.equalizer(), \"BOUNCE RATE\", \"62%\")\n" +
                "                .setIconBackground(Color.TEAL)\n" +
                "                .setBackground(Color.TEAL)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.flight_takeoff(), \"FLIGHT\", \"02:59 PM\")\n" +
                "                .setIconBackground(Color.GREEN)\n" +
                "                .setBackground(Color.GREEN)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.battery_charging_full(), \"BATTERY\", \"Charging\")\n" +
                "                .setIconBackground(Color.LIGHT_GREEN)\n" +
                "                .setBackground(Color.LIGHT_GREEN)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.brightness_low(), \"BRIGHTNESS RATE\", \"40%\")\n" +
                "                .setIconBackground(Color.LIME)\n" +
                "                .setBackground(Color.LIME)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .asElement());";
    }

    public static String rightAligned() {
        return "Column column=Column.create()\n" +
                "        .onLarge(Column.OnLarge.three)\n" +
                "        .onMedium(Column.OnMedium.three)\n" +
                "        .onSmall(Column.OnSmall.six)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(InfoBox.create(Icons.ALL.email(), \"MESSAGES\", \"15\")\n" +
                "                .setIconBackground(Color.WHITE)\n" +
                "                .setIconColor(Color.PINK)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.devices(), \"CPU USAGE\", \"92%\")\n" +
                "                .setIconBackground(Color.WHITE)\n" +
                "                .setIconColor(Color.BLUE)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.alarm(), \"ALARM\", \"07:00 AM\")\n" +
                "                .setIconBackground(Color.WHITE)\n" +
                "                .setIconColor(Color.AMBER)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.gps_fixed(), \"LOCATION\", \"Jordan\")\n" +
                "                .setIconBackground(Color.WHITE)\n" +
                "                .setIconColor(Color.DEEP_PURPLE)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.equalizer(), \"BOUNCE RATE\", \"62%\")\n" +
                "                .setIconBackground(Color.TEAL)\n" +
                "                .setBackground(Color.TEAL)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.flight_takeoff(), \"FLIGHT\", \"02:59 PM\")\n" +
                "                .setIconBackground(Color.GREEN)\n" +
                "                .setBackground(Color.GREEN)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.battery_charging_full(), \"BATTERY\", \"Charging\")\n" +
                "                .setIconBackground(Color.LIGHT_GREEN)\n" +
                "                .setBackground(Color.LIGHT_GREEN)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.brightness_low(), \"BRIGHTNESS RATE\", \"40%\")\n" +
                "                .setIconBackground(Color.LIME)\n" +
                "                .setBackground(Color.LIME)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .asElement());";
    }
}

