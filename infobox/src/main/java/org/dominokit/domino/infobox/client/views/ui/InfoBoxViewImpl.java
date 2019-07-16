package org.dominokit.domino.infobox.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.infobox.client.presenters.InfoBoxProxy;
import org.dominokit.domino.infobox.client.views.InfoBoxView;
import org.dominokit.domino.ui.counter.Counter;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = InfoBoxProxy.class)
@SampleClass
public class InfoBoxViewImpl extends BaseDemoView<HTMLDivElement> implements InfoBoxView{

    private HTMLDivElement element= Elements.div().asElement();
    private Counter counter;

    @Override
    protected void init(HTMLDivElement root) {
        element.appendChild(LinkToSourceCode.create("infobox", this.getClass()).asElement());

        basicInfoBoxes();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicInfoBoxes()).asElement());

        hoverZoomEffect();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.hoverZoomEffect()).asElement());

        rightAligned();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.rightAligned()).asElement());
    }

    @Override
    public HTMLDivElement createRoot() {
        element= Elements.div().asElement();
        return element;
    }


    @Override
    public void restartCounters() {
        counter.startCounting();
    }

    @SampleMethod
    private void basicInfoBoxes() {
        element.appendChild(BlockHeader.create("BASIC INFO BOX AND COUNTERS", "Simple info box without effects, and counters to update the value.").asElement());

        element.appendChild(Row.create()
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.shopping_cart(), "NEW ORDERS", "125")
                        .setIconBackground(Color.RED)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.face(), "NEW MEMBERS", "257")
                        .setIconBackground(Color.INDIGO)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.shopping_cart(), "BOOKMARKS", "117")
                        .setIconBackground(Color.PURPLE)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.favorite(), "LIKES", "1432")
                        .setIconBackground(Color.DEEP_PURPLE)))
                .asElement());

        InfoBox new_orders = InfoBox.create(Icons.ALL.shopping_cart(), "NEW ORDERS", "0");
        InfoBox new_members = InfoBox.create(Icons.ALL.face(), "NEW MEMBERS", "0");
        InfoBox bookmarks = InfoBox.create(Icons.ALL.shopping_cart(), "BOOKMARKS", "0");
        InfoBox likes = InfoBox.create(Icons.ALL.favorite(), "LIKES", "0");

        element.appendChild(Row.create()
                .addColumn(Column.span3().appendChild(new_orders
                        .setIconBackground(Color.RED)))
                .addColumn(Column.span3().appendChild(new_members
                        .setIconBackground(Color.INDIGO)))
                .addColumn(Column.span3().appendChild(bookmarks
                        .setIconBackground(Color.PURPLE)))
                .addColumn(Column.span3().appendChild(likes
                        .setIconBackground(Color.DEEP_PURPLE)))
                .asElement());

        counter = Counter.countFrom(0)
                .countTo(125)
                .every(40)
                .incrementBy(5)
                .onCount(count -> {
                    new_orders.getValueElement().setTextContent(Integer.toString(count));
                    new_members.getValueElement().setTextContent(Integer.toString(count));
                    bookmarks.getValueElement().setTextContent(Integer.toString(count));
                    likes.getValueElement().setTextContent(Integer.toString(count));
                });



    }

    @SampleMethod
    private void hoverZoomEffect() {
        element.appendChild(BlockHeader.create("HOVER EFFECTS", "Apply Zoom or Expand effects on hover").asElement());

        element.appendChild(Row.create()
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.email(), "MESSAGES", "15")
                        .setBackground(Color.PINK)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.devices(), "CPU USAGE", "92%")
                        .setBackground(Color.BLUE)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.alarm(), "ALARM", "07:00 AM")
                        .setBackground(Color.AMBER)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.gps_fixed(), "LOCATION", "Jordan")
                        .setBackground(Color.DEEP_PURPLE)
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .asElement());

        element.appendChild(Row.create()
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.equalizer(), "BOUNCE RATE", "62%")
                        .setIconBackground(Color.TEAL)
                        .setBackground(Color.TEAL)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.flight_takeoff(), "FLIGHT", "02:59 PM")
                        .setIconBackground(Color.GREEN)
                        .setBackground(Color.GREEN)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.battery_charging_full(), "BATTERY", "Charging")
                        .setIconBackground(Color.LIGHT_GREEN)
                        .setBackground(Color.LIGHT_GREEN)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.brightness_low(), "BRIGHTNESS RATE", "40%")
                        .setIconBackground(Color.LIME)
                        .setBackground(Color.LIME)
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .asElement());


    }

    @SampleMethod
    private void rightAligned() {
        element.appendChild(BlockHeader.create("ICON ALIGN AND COUNTERS", "Change icon position, and update info value with counters").asElement());

        element.appendChild(Row.create()
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.email(), "MESSAGES", "15")
                        .setIconBackground(Color.WHITE)
                        .setIconColor(Color.PINK)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.devices(), "CPU USAGE", "92%")
                        .setIconBackground(Color.WHITE)
                        .setIconColor(Color.BLUE)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.alarm(), "ALARM", "07:00 AM")
                        .setIconBackground(Color.WHITE)
                        .setIconColor(Color.AMBER)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.gps_fixed(), "LOCATION", "Jordan")
                        .setIconBackground(Color.WHITE)
                        .setIconColor(Color.DEEP_PURPLE)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.ZOOM)))
                .asElement());

        element.appendChild(Row.create()
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.equalizer(), "BOUNCE RATE", "62%")
                        .setIconBackground(Color.TEAL)
                        .setBackground(Color.TEAL)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.flight_takeoff(), "FLIGHT", "02:59 PM")
                        .setIconBackground(Color.GREEN)
                        .setBackground(Color.GREEN)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.battery_charging_full(), "BATTERY", "Charging")
                        .setIconBackground(Color.LIGHT_GREEN)
                        .setBackground(Color.LIGHT_GREEN)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .addColumn(Column.span3().appendChild(InfoBox.create(Icons.ALL.brightness_low(), "BRIGHTNESS RATE", "40%")
                        .setIconBackground(Color.LIME)
                        .setBackground(Color.LIME)
                        .flip()
                        .setHoverEffect(InfoBox.HoverEffect.EXPAND)))
                .asElement());


    }
}