package org.dominokit.domino.spin.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.spin.client.presenters.SpinSelectPresenter;
import org.dominokit.domino.spin.client.views.SpinSelectView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.spin.HSpinSelect;
import org.dominokit.domino.ui.spin.SpinItem;
import org.dominokit.domino.ui.spin.VSpinSelect;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.TextNode;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.img;

@UiView(presentable = SpinSelectPresenter.class)
public class SpinSelectViewImpl extends ComponentView<HTMLDivElement> implements SpinSelectView {

    public static final String MODULE_NAME = "spin";
    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(LinkToSourceCode.create(MODULE_NAME, this.getClass()).asElement());
        element.appendChild(BlockHeader.create("SPIN").asElement());
        horizontalSpin();
        verticalSpin();
    }

    private void horizontalSpin() {
        element.appendChild(Card.create("HORIZONTAL SPIN")
                .appendChild(Row.create()
                        .appendChild(Column.span2()
                                .appendChild(HSpinSelect.<String>create()
                                        .appendChild(SpinItem.create("item 1", div().css("sample-spin-item", Color.BLUE.getBackground()).textContent("1")))
                                        .appendChild(SpinItem.create("item 2", div().css("sample-spin-item", Color.RED.getBackground()).textContent("2")))
                                        .appendChild(SpinItem.create("item 3", div().css("sample-spin-item", Color.BLUE_GREY.getBackground()).textContent("3")))
                                        .appendChild(SpinItem.create("item 4", div().css("sample-spin-item", Color.ORANGE.getBackground()).textContent("4")))
                                        .appendChild(SpinItem.create("item 5", div().css("sample-spin-item", Color.BROWN.getBackground()).textContent("5")))
                                        .appendChild(SpinItem.create("item 6", div().css("sample-spin-item", Color.GREEN.getBackground()).textContent("6")))
                                        .appendChild(SpinItem.create("item 7", div().css("sample-spin-item", Color.PINK.getBackground()).textContent("7")))
                                        .appendChild(SpinItem.create("item 8", div().css("sample-spin-item", Color.TEAL.getBackground()).textContent("8")))
                                        .appendChild(SpinItem.create("item 9", div().css("sample-spin-item", Color.CYAN.getBackground()).textContent("9")))
                                        .appendChild(SpinItem.create("item 10", div().css("sample-spin-item", Color.PURPLE.getBackground()).textContent("10")))
                                ))
                        .appendChild(Column.span2()
                                .appendChild(HSpinSelect.<String>create()
                                        .appendChild(SpinItem.create("item 1", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.battery_charging_full())))
                                        .appendChild(SpinItem.create("item 2", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.bluetooth())))
                                        .appendChild(SpinItem.create("item 3", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.data_usage())))
                                        .appendChild(SpinItem.create("item 4", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.brightness_medium())))
                                        .appendChild(SpinItem.create("item 5", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.devices())))
                                        .appendChild(SpinItem.create("item 6", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.gps_fixed())))
                                        .appendChild(SpinItem.create("item 7", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.graphic_eq())))
                                        .appendChild(SpinItem.create("item 8", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.location_searching())))
                                        .appendChild(SpinItem.create("item 9", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.access_alarms())))
                                        .appendChild(SpinItem.create("item 10", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.airplanemode_active())))
                                ))
                        .appendChild(Column.span2()
                                .appendChild(HSpinSelect.<String>create()
                                        .appendChild(SpinItem.create("item 1", div().css("sample-spin-item").add(img("./images/flags/jordan.png").style("width: 48px; height: 48px;"))))
                                        .appendChild(SpinItem.create("item 2", div().css("sample-spin-item").add(img("./images/flags/oman.png").style("width: 48px; height: 48px;"))))
                                        .appendChild(SpinItem.create("item 3", div().css("sample-spin-item").add(img("./images/flags/palestine.png").style("width: 48px; height: 48px;"))))
                                        .appendChild(SpinItem.create("item 4", div().css("sample-spin-item").add(img("./images/flags/brazil.png").style("width: 48px; height: 48px;"))))
                                        .appendChild(SpinItem.create("item 5", div().css("sample-spin-item").add(img("./images/flags/european-union.png").style("width: 48px; height: 48px;"))))
                                ))
                        .appendChild(Column.span6()
                                .appendChild(HSpinSelect.<String>create(Icons.ALL.arrow_back(), Icons.ALL.arrow_forward())
                                        .appendChild(SpinItem.create("item 1", div().css("sample-spin-item").add(TextNode.of("Cras justo odio"))))
                                        .appendChild(SpinItem.create("item 2", div().css("sample-spin-item").add(TextNode.of("Dapibus ac facilisis in"))))
                                        .appendChild(SpinItem.create("item 3", div().css("sample-spin-item").add(TextNode.of("Morbi leo risus"))))
                                        .appendChild(SpinItem.create("item 4", div().css("sample-spin-item").add(TextNode.of("Porta ac consectetur ac"))))
                                        .appendChild(SpinItem.create("item 5", div().css("sample-spin-item").add(TextNode.of("Vestibulum at eros"))))
                                ))
                ).asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"horizontalSpin").asElement());
    }

    private void verticalSpin() {
        element.appendChild(Card.create("VERTICAL SPIN", "For vertical spins to work the height should be fixed.")
                .appendChild(Row.create()
                        .appendChild(Column.span2()
                                .appendChild(VSpinSelect.<String>create()
                                        .setHeight("50px")
                                        .appendChild(SpinItem.create("item 1", div().css("sample-spin-item", Color.BLUE.getBackground()).textContent("1")))
                                        .appendChild(SpinItem.create("item 2", div().css("sample-spin-item", Color.RED.getBackground()).textContent("2")))
                                        .appendChild(SpinItem.create("item 3", div().css("sample-spin-item", Color.BLUE_GREY.getBackground()).textContent("3")))
                                        .appendChild(SpinItem.create("item 4", div().css("sample-spin-item", Color.ORANGE.getBackground()).textContent("4")))
                                        .appendChild(SpinItem.create("item 5", div().css("sample-spin-item", Color.BROWN.getBackground()).textContent("5")))
                                        .appendChild(SpinItem.create("item 6", div().css("sample-spin-item", Color.GREEN.getBackground()).textContent("6")))
                                        .appendChild(SpinItem.create("item 7", div().css("sample-spin-item", Color.PINK.getBackground()).textContent("7")))
                                        .appendChild(SpinItem.create("item 8", div().css("sample-spin-item", Color.TEAL.getBackground()).textContent("8")))
                                        .appendChild(SpinItem.create("item 9", div().css("sample-spin-item", Color.CYAN.getBackground()).textContent("9")))
                                        .appendChild(SpinItem.create("item 10", div().css("sample-spin-item", Color.PURPLE.getBackground()).textContent("10")))
                                ))
                        .appendChild(Column.span2()
                                .appendChild(VSpinSelect.<String>create()
                                        .setHeight("50px")
                                        .appendChild(SpinItem.create("item 1", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.battery_charging_full().style().add(Styles.vertical_center))))
                                        .appendChild(SpinItem.create("item 2", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.bluetooth().style().add(Styles.vertical_center))))
                                        .appendChild(SpinItem.create("item 3", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.data_usage().style().add(Styles.vertical_center))))
                                        .appendChild(SpinItem.create("item 4", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.brightness_medium().style().add(Styles.vertical_center))))
                                        .appendChild(SpinItem.create("item 5", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.devices().style().add(Styles.vertical_center))))
                                        .appendChild(SpinItem.create("item 6", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.gps_fixed().style().add(Styles.vertical_center))))
                                        .appendChild(SpinItem.create("item 7", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.graphic_eq().style().add(Styles.vertical_center))))
                                        .appendChild(SpinItem.create("item 8", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.location_searching().style().add(Styles.vertical_center))))
                                        .appendChild(SpinItem.create("item 9", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.access_alarms().style().add(Styles.vertical_center))))
                                        .appendChild(SpinItem.create("item 10", div().css("sample-spin-item").add(Icons.DEVICE_ICONS.airplanemode_active().style().add(Styles.vertical_center))))
                                ))
                        .appendChild(Column.span2()
                                .appendChild(VSpinSelect.<String>create()
                                        .setHeight("50px")
                                        .appendChild(SpinItem.create("item 1", div().css("sample-spin-item").add(img("./images/flags/jordan.png").style("width: 48px; height: 48px;"))))
                                        .appendChild(SpinItem.create("item 2", div().css("sample-spin-item").add(img("./images/flags/oman.png").style("width: 48px; height: 48px;"))))
                                        .appendChild(SpinItem.create("item 3", div().css("sample-spin-item").add(img("./images/flags/palestine.png").style("width: 48px; height: 48px;"))))
                                        .appendChild(SpinItem.create("item 4", div().css("sample-spin-item").add(img("./images/flags/brazil.png").style("width: 48px; height: 48px;"))))
                                        .appendChild(SpinItem.create("item 5", div().css("sample-spin-item").add(img("./images/flags/european-union.png").style("width: 48px; height: 48px;"))))
                                ))
                        .appendChild(Column.span6()
                                .appendChild(VSpinSelect.<String>create(Icons.ALL.arrow_upward(), Icons.ALL.arrow_downward())
                                        .setHeight("50px")
                                        .appendChild(SpinItem.create("item 1", div().css("sample-spin-item").add(TextNode.of("Cras justo odio"))))
                                        .appendChild(SpinItem.create("item 2", div().css("sample-spin-item").add(TextNode.of("Dapibus ac facilisis in"))))
                                        .appendChild(SpinItem.create("item 3", div().css("sample-spin-item").add(TextNode.of("Morbi leo risus"))))
                                        .appendChild(SpinItem.create("item 4", div().css("sample-spin-item").add(TextNode.of("Porta ac consectetur ac"))))
                                        .appendChild(SpinItem.create("item 5", div().css("sample-spin-item").add(TextNode.of("Vestibulum at eros"))))
                                ))
                ).asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"verticalSpin").asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}