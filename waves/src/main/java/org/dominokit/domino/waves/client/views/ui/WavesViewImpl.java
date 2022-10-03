package org.dominokit.domino.waves.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.style.WaveColor;
import org.dominokit.domino.ui.style.WaveStyle;
import org.dominokit.domino.ui.style.WavesSupport;
import org.dominokit.domino.ui.utils.TextNode;
import org.dominokit.domino.waves.client.presenters.WavesProxy;
import org.dominokit.domino.waves.client.views.WavesView;
import org.jboss.elemento.IsElement;

import java.util.Arrays;

import static org.jboss.elemento.Elements.div;

@UiView(presentable = WavesProxy.class)
@SampleClass
public class WavesViewImpl extends BaseDemoView<HTMLDivElement> implements WavesView {

    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        element.appendChild(LinkToSourceCode.create("waves", this.getClass()).element());
        element.appendChild(BlockHeader.create("WAVES", "Click effect inspired by Google's Material Design")
                .element());

        element.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Card.create("COLOR VARIATIONS")
                                .appendChild(ListGroup.<IsElement<?>>create()
                                        .setItemRenderer((listGroup, listItem) -> listItem
                                                .css(Styles.padding_10)
                                                .appendChild(listItem.getValue()))
                                        .setItems(Arrays.asList(
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("Default"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button.createDefault("CLICK ME").style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.LIGHT"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createPrimary("CLICK ME")
                                                                        .setWaveColor(WaveColor.LIGHT)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.RED"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.RED)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.PINK"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.PINK)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.PURPLE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.PURPLE)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.DEEP_PURPLE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.DEEP_PURPLE)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.INDIGO"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.INDIGO)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.BLUE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.BLUE)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.LIGHT_BLUE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.LIGHT_BLUE)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.CYAN"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.CYAN)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.TEAL"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.TEAL)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.GREEN"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.GREEN)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.LIGHT_GREEN"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.LIGHT_GREEN)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.LIME"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.LIME)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.YELLOW"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.YELLOW)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.AMBER"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.AMBER)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.ORANGE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.ORANGE)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.DEEP_ORANGE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.DEEP_ORANGE)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.BROWN"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.BROWN)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.GREY"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.GREY)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.BLUE_GREY"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.BLUE_GREY)
                                                                        .style().setMinWidth("120px"))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.BLACK"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault("CLICK ME")
                                                                        .setWaveColor(WaveColor.BLACK)
                                                                        .style().setMinWidth("120px"))
                                                        )

                                                )
                                        )
                                )
                        )
                )
                .addColumn(Column.span6()
                        .appendChild(Card.create("CIRCLE")
                                .appendChild(ListGroup.<IsElement<?>>create()
                                        .setItemRenderer((listGroup, listItem) -> listItem
                                                .css(Styles.padding_10)
                                                .appendChild(listItem.getValue()))
                                        .setItems(Arrays.asList(
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("Default"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button.createDefault(Icons.ALL.microphone_mdi())
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.LIGHT"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createPrimary(Icons.ALL.keyboard_mdi())
                                                                        .setWaveColor(WaveColor.LIGHT)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.RED"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.content_cut_mdi())
                                                                        .setWaveColor(WaveColor.RED)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.PINK"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.content_paste_mdi())
                                                                        .setWaveColor(WaveColor.PINK)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.PURPLE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.alarm_mdi())
                                                                        .setWaveColor(WaveColor.PURPLE)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.DEEP_PURPLE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.timeline_mdi())
                                                                        .setWaveColor(WaveColor.DEEP_PURPLE)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.INDIGO"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.account_mdi())
                                                                        .setWaveColor(WaveColor.INDIGO)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.BLUE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.seat_mdi())
                                                                        .setWaveColor(WaveColor.BLUE)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.LIGHT_BLUE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.alarm_mdi())
                                                                        .setWaveColor(WaveColor.LIGHT_BLUE)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.CYAN"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.air_conditioner_mdi())
                                                                        .setWaveColor(WaveColor.CYAN)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.TEAL"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.apps_mdi())
                                                                        .setWaveColor(WaveColor.TEAL)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.GREEN"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.assistant_mdi())
                                                                        .setWaveColor(WaveColor.GREEN)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.LIGHT_GREEN"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.android_mdi())
                                                                        .setWaveColor(WaveColor.LIGHT_GREEN)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.LIME"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.album_mdi())
                                                                        .setWaveColor(WaveColor.LIME)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.YELLOW"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.aspect_ratio_mdi())
                                                                        .setWaveColor(WaveColor.YELLOW)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.AMBER"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.autorenew_mdi())
                                                                        .setWaveColor(WaveColor.AMBER)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.ORANGE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.plus_mdi())
                                                                        .setWaveColor(WaveColor.ORANGE)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.DEEP_ORANGE"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.location_enter_mdi())
                                                                        .setWaveColor(WaveColor.DEEP_ORANGE)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.BROWN"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.plus_box_mdi())
                                                                        .setWaveColor(WaveColor.BROWN)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.GREY"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.book_remove_mdi())
                                                                        .setWaveColor(WaveColor.GREY)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.BLUE_GREY"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.book_plus_mdi())
                                                                        .setWaveColor(WaveColor.BLUE_GREY)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        ),
                                                FlexLayout.create()
                                                        .appendChild(FlexItem.create()
                                                                .setFlexGrow(1)
                                                                .appendChild(TextNode.of("WaveColor.BLACK"))
                                                        )
                                                        .appendChild(FlexItem.create()
                                                                .appendChild(Button
                                                                        .createDefault(Icons.ALL.adjust_mdi())
                                                                        .setWaveColor(WaveColor.BLACK)
                                                                        .circle()
                                                                        .setSize(ButtonSize.SMALL))
                                                        )

                                                )
                                        )
                                )
                        )
                )
                .element());

        element.appendChild(CodeCard.createCodeCard(
                "//Elements extending WaveElement will have waves by default\n" +
                        "//to add Waves to elements that does not extend from WaveElement use the WaveSupport class\n\n" +
                        CodeResource.INSTANCE.sample()
        ).element());

        return element;
    }

    @SampleMethod
    private void sample() {
        HTMLElement element = div().element();
        WavesSupport.addFor(element)
                .setWaveColor(WaveColor.YELLOW)
                .applyWaveStyle(WaveStyle.CIRCLE);
    }
}