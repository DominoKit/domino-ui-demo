package com.progressoft.brix.domino.infobox.client.ui.views;

import com.google.gwt.user.client.ui.Composite;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.infobox.client.presenters.InfoBoxPresenter;
import com.progressoft.brix.domino.infobox.client.views.InfoBoxView;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.counter.Counter;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.icons.Icons;
import com.progressoft.brix.domino.ui.infoboxes.InfoBox;
import com.progressoft.brix.domino.ui.row.Row;
import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.col;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = InfoBoxPresenter.class)
public class DefaultInfoBoxView extends Composite implements InfoBoxView{

    private HTMLDivElement element=div().asElement();
    private Counter counter;

    public DefaultInfoBoxView() {
        basicInfoBoxes();
        hoverZoomEffect();
        rightAligned();
    }


    private void basicInfoBoxes() {
        element.appendChild(BlockHeader.create("BASIC INFO BOX AND COUNTERS", "Simple info box without effects, and counters to update the value.").asElement());

        Column column=Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.six)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(Row.create()
                .addColumn(column.addElement(InfoBox.create(Icons.ALL.shopping_cart(), "NEW ORDERS", "125")
                        .setIconBackground(Background.RED).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.face(), "NEW MEMBERS", "257")
                        .setIconBackground(Background.INDIGO).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.shopping_cart(), "BOOKMARKS", "117")
                        .setIconBackground(Background.PURPLE).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.favorite(), "LIKES", "1432")
                        .setIconBackground(Background.DEEP_PURPLE).asElement()))
                .asElement());

        InfoBox new_orders = InfoBox.create(Icons.ALL.shopping_cart(), "NEW ORDERS", "0");
        InfoBox new_members = InfoBox.create(Icons.ALL.face(), "NEW MEMBERS", "0");
        InfoBox bookmarks = InfoBox.create(Icons.ALL.shopping_cart(), "BOOKMARKS", "0");
        InfoBox likes = InfoBox.create(Icons.ALL.favorite(), "LIKES", "0");

        element.appendChild(Row.create()
                .addColumn(column.copy().addElement(new_orders
                        .setIconBackground(Background.RED).asElement()))
                .addColumn(column.copy().addElement(new_members
                        .setIconBackground(Background.INDIGO).asElement()))
                .addColumn(column.copy().addElement(bookmarks
                        .setIconBackground(Background.PURPLE).asElement()))
                .addColumn(column.copy().addElement(likes
                        .setIconBackground(Background.DEEP_PURPLE).asElement()))
                .asElement());

        counter = Counter.countFrom(0)
                .countTo(125)
                .every(40)
                .incrementBy(5)
                .onCount(count -> {
                    new_orders.getValueElement().textContent = Integer.toString(count);
                    new_members.getValueElement().textContent = Integer.toString(count);
                    bookmarks.getValueElement().textContent = Integer.toString(count);
                    likes.getValueElement().textContent = Integer.toString(count);
                });


        element.appendChild(Card.createCodeCard("Column column=Column.create()\n" +
                "        .onLarge(Column.OnLarge.three)\n" +
                "        .onMedium(Column.OnMedium.three)\n" +
                "        .onSmall(Column.OnSmall.six)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(InfoBox.create(Icons.ALL.shopping_cart(), \"NEW ORDERS\", \"125\")\n" +
                "                .setIconBackground(Background.RED).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.face(), \"NEW MEMBERS\", \"257\")\n" +
                "                .setIconBackground(Background.INDIGO).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.shopping_cart(), \"BOOKMARKS\", \"117\")\n" +
                "                .setIconBackground(Background.PURPLE).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.favorite(), \"LIKES\", \"1432\")\n" +
                "                .setIconBackground(Background.DEEP_PURPLE).asElement()))\n" +
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
                "Counter.countFrom(0)\n" +
                "        .countTo(125)\n" +
                "        .every(40)\n" +
                "        .incrementBy(5)\n" +
                "        .onCount(count -> {\n" +
                "            new_orders.getValueElement().textContent=Integer.toString(count);\n" +
                "            new_members.getValueElement().textContent=Integer.toString(count);\n" +
                "            bookmarks.getValueElement().textContent=Integer.toString(count);\n" +
                "            likes.getValueElement().textContent=Integer.toString(count);\n" +
                "        }).startCounting();").asElement());
    }

    private void hoverZoomEffect() {
        element.appendChild(BlockHeader.create("HOVER EFFECTS", "Apply Zoom or Expand effects on hover").asElement());

        Column column=Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.six)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(Row.create()
                .addColumn(column.addElement(InfoBox.create(Icons.ALL.email(), "MESSAGES", "15")
                        .setBackground(Background.PINK)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.devices(), "CPU USAGE", "92%")
                        .setBackground(Background.BLUE)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.alarm(), "ALARM", "07:00 AM")
                        .setBackground(Background.AMBER)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.gps_fixed(), "LOCATION", "Jordan")
                        .setBackground(Background.DEEP_PURPLE)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))
                .asElement());

        element.appendChild(Row.create()
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.equalizer(), "BOUNCE RATE", "62%")
                        .setIconBackground(Background.TEAL)
                        .setBackground(Background.TEAL)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.flight_takeoff(), "FLIGHT", "02:59 PM")
                        .setIconBackground(Background.GREEN)
                        .setBackground(Background.GREEN)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.battery_charging_full(), "BATTERY", "Charging")
                        .setIconBackground(Background.LIGHT_GREEN)
                        .setBackground(Background.LIGHT_GREEN)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.brightness_low(), "BRIGHTNESS RATE", "40%")
                        .setIconBackground(Background.LIME)
                        .setBackground(Background.LIME)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard("Column column=Column.create()\n" +
                "        .onLarge(Column.OnLarge.three)\n" +
                "        .onMedium(Column.OnMedium.three)\n" +
                "        .onSmall(Column.OnSmall.six)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(InfoBox.create(Icons.ALL.email(), \"MESSAGES\", \"15\")\n" +
                "                .setIconBackground(Background.PINK)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.devices(), \"CPU USAGE\", \"92%\")\n" +
                "                .setIconBackground(Background.BLUE)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.alarm(), \"ALARM\", \"07:00 AM\")\n" +
                "                .setIconBackground(Background.BLUE)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.gps_fixed(), \"LOCATION\", \"Jordan\")\n" +
                "                .setIconBackground(Background.DEEP_PURPLE)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.equalizer(), \"BOUNCE RATE\", \"62%\")\n" +
                "                .setIconBackground(Background.TEAL)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.flight_takeoff(), \"FLIGHT\", \"02:59 PM\")\n" +
                "                .setIconBackground(Background.GREEN)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.battery_charging_full(), \"BATTERY\", \"Charging\")\n" +
                "                .setIconBackground(Background.LIGHT_GREEN)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.brightness_low(), \"BRIGHTNESS RATE\", \"40%\")\n" +
                "                .setIconBackground(Background.LIME)\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .asElement());").asElement());
    }

    private void rightAligned() {
        element.appendChild(BlockHeader.create("ICON ALIGN AND COUNTERS", "Change icon position, and update info value with counters").asElement());

        Column column=Column.create()
                .onLarge(Column.OnLarge.three)
                .onMedium(Column.OnMedium.three)
                .onSmall(Column.OnSmall.six)
                .onXSmall(Column.OnXSmall.twelve);

        element.appendChild(Row.create()
                .addColumn(column.addElement(InfoBox.create(Icons.ALL.email(), "MESSAGES", "15")
                        .setIconBackground(Background.WHITE)
                        .setIconColor(Color.PINK)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.devices(), "CPU USAGE", "92%")
                        .setIconBackground(Background.WHITE)
                        .setIconColor(Color.BLUE)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.alarm(), "ALARM", "07:00 AM")
                        .setIconBackground(Background.WHITE)
                        .setIconColor(Color.AMBER)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.gps_fixed(), "LOCATION", "Jordan")
                        .setIconBackground(Background.WHITE)
                        .setIconColor(Color.DEEP_PURPLE)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))
                .asElement());

        element.appendChild(Row.create()
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.equalizer(), "BOUNCE RATE", "62%")
                        .setIconBackground(Background.TEAL)
                        .setBackground(Background.TEAL)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.flight_takeoff(), "FLIGHT", "02:59 PM")
                        .setIconBackground(Background.GREEN)
                        .setBackground(Background.GREEN)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.battery_charging_full(), "BATTERY", "Charging")
                        .setIconBackground(Background.LIGHT_GREEN)
                        .setBackground(Background.LIGHT_GREEN)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))
                .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.brightness_low(), "BRIGHTNESS RATE", "40%")
                        .setIconBackground(Background.LIME)
                        .setBackground(Background.LIME)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard("Column column=Column.create()\n" +
                "        .onLarge(Column.OnLarge.three)\n" +
                "        .onMedium(Column.OnMedium.three)\n" +
                "        .onSmall(Column.OnSmall.six)\n" +
                "        .onXSmall(Column.OnXSmall.twelve);\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.addElement(InfoBox.create(Icons.ALL.email(), \"MESSAGES\", \"15\")\n" +
                "                .setIconBackground(Background.WHITE)\n" +
                "                .setIconColor(Color.PINK)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.devices(), \"CPU USAGE\", \"92%\")\n" +
                "                .setIconBackground(Background.WHITE)\n" +
                "                .setIconColor(Color.BLUE)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.alarm(), \"ALARM\", \"07:00 AM\")\n" +
                "                .setIconBackground(Background.WHITE)\n" +
                "                .setIconColor(Color.AMBER)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.gps_fixed(), \"LOCATION\", \"Jordan\")\n" +
                "                .setIconBackground(Background.WHITE)\n" +
                "                .setIconColor(Color.DEEP_PURPLE)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.ZOOM).asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "element.appendChild(Row.create()\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.equalizer(), \"BOUNCE RATE\", \"62%\")\n" +
                "                .setIconBackground(Background.TEAL)\n" +
                "                .setBackground(Background.TEAL)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.flight_takeoff(), \"FLIGHT\", \"02:59 PM\")\n" +
                "                .setIconBackground(Background.GREEN)\n" +
                "                .setBackground(Background.GREEN)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.battery_charging_full(), \"BATTERY\", \"Charging\")\n" +
                "                .setIconBackground(Background.LIGHT_GREEN)\n" +
                "                .setBackground(Background.LIGHT_GREEN)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .addColumn(column.copy().addElement(InfoBox.create(Icons.ALL.brightness_low(), \"BRIGHTNESS RATE\", \"40%\")\n" +
                "                .setIconBackground(Background.LIME)\n" +
                "                .setBackground(Background.LIME)\n" +
                "                .flip()\n" +
                "                .setHoverEffect(InfoBox.HoverEffect.EXPAND).asElement()))\n" +
                "        .asElement());").asElement());
    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement= Js.cast(content.get());
        contentElement.appendChild(this.element);
        counter.startCounting();
    }
}