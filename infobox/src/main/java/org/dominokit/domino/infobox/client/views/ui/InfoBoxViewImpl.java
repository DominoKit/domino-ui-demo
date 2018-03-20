package org.dominokit.domino.infobox.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.infobox.client.presenters.InfoBoxPresenter;
import org.dominokit.domino.infobox.client.views.CodeResource;
import org.dominokit.domino.infobox.client.views.InfoBoxView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.counter.Counter;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Background;
import org.dominokit.domino.ui.style.Color;
import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = InfoBoxPresenter.class)
public class InfoBoxViewImpl extends ComponentView<HTMLDivElement> implements InfoBoxView{

    private HTMLDivElement element= Elements.div().asElement();
    private Counter counter;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void restartCounters() {
        counter.startCounting();
    }

    @Override
    public void init() {
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


        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basicInfoBoxes()).asElement());
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

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.hoverZoomEffect()).asElement());
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

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.rightAligned()).asElement());
    }
}