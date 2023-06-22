package org.dominokit.domino.waves.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.lists.ListGroup;
import org.dominokit.domino.ui.style.ColorsCss;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.waves.client.presenters.WavesProxy;
import org.dominokit.domino.waves.client.views.WavesView;

import java.util.Arrays;

import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_accent;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_amber;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_black;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_blue;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_blue_grey;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_brown;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_cyan;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_deep_orange;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_deep_purple;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_green;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_grey;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_indigo;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_light_blue;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_light_green;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_lime;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_orange;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_pink;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_purple;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_red;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_teal;
import static org.dominokit.domino.ui.style.WavesStyles.dui_waves_yellow;

@UiView(presentable = WavesProxy.class)
@SampleClass
public class WavesViewImpl extends BaseDemoView<HTMLDivElement> implements WavesView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("waves", this.getClass()).element());
        element.appendChild(BlockHeader.create("WAVES", "Click effect inspired by Google's Material Design")
                .element());

//        element.appendChild(Button.create("ADD button")
//                .addClickListener(evt -> element.appendChild(Button
//                        .create("CLICK ME").addCss(dui_w_28)
//                        .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_accent))))
//        );

        waves();

        element.appendChild(CodeCard.createCodeCard(
                "//Elements extending WaveElement will have waves by default\n" +
                        "//to add Waves to elements that does not extend from WaveElement use the WaveSupport class\n\n" +
                        CodeResource.INSTANCE.waves()
        ));

        return element.element();
    }

    @SampleMethod
    private void waves() {
        element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .appendChild(Card.create("COLOR VARIATIONS")
                                .appendChild(ListGroup.<IsElement<?>>create()
                                        .setSelectable(false)
                                        .setItemRenderer((listGroup, listItem) -> listItem
                                                .addCss(dui_p_3)
                                                .appendChild(listItem.getValue()))
                                        .setItems(Arrays.asList(
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1)
                                                                        .appendChild(text("Default"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button.create("CLICK ME").addCss(dui_w_28))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_accent)
                                                                        .appendChild(text("ACCENT"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_accent)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_red)
                                                                        .appendChild(text("RED"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_red)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_pink)
                                                                        .appendChild(text("PINK"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_pink)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_purple)
                                                                        .appendChild(text("PURPLE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_purple)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_deep_purple)
                                                                        .appendChild(text("DEEP_PURPLE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_deep_purple)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_indigo)
                                                                        .appendChild(text("INDIGO"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_indigo)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_blue)
                                                                        .appendChild(text("BLUE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_blue)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_light_blue)
                                                                        .appendChild(text("LIGHT_BLUE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_light_blue)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_cyan)
                                                                        .appendChild(text("CYAN"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_cyan)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_teal)
                                                                        .appendChild(text("TEAL"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_teal)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_green)
                                                                        .appendChild(text("GREEN"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_green)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_light_green)
                                                                        .appendChild(text("LIGHT_GREEN"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_light_green)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_lime)
                                                                        .appendChild(text("LIME"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_lime)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_yellow)
                                                                        .appendChild(text("YELLOW"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_yellow)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_amber)
                                                                        .appendChild(text("AMBER"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_amber)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_orange)
                                                                        .appendChild(text("ORANGE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_orange)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_deep_orange)
                                                                        .appendChild(text("DEEP_ORANGE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_deep_orange)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_brown)
                                                                        .appendChild(text("BROWN"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_brown)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_grey)
                                                                        .appendChild(text("GREY"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_grey)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_blue_grey)
                                                                        .appendChild(text("BLUE_GREY"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_blue_grey)))
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_black)
                                                                        .appendChild(text("BLACK"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create("CLICK ME").addCss(dui_w_28)
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_black)))
                                                                )

                                                )
                                        )
                                )
                        )
                )
                .appendChild(Column.span6()
                        .appendChild(Card.create("CIRCLE")
                                .appendChild(ListGroup.<IsElement<?>>create()
                                        .setSelectable(false)
                                        .setItemRenderer((listGroup, listItem) -> listItem
                                                .addCss(dui_p_3)
                                                .appendChild(listItem.getValue()))
                                        .setItems(Arrays.asList(
                                                        div().addCss(dui_flex).addCss(dui_items_center).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1)
                                                                        .appendChild(text("Default"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button.create(Icons.microphone())
                                                                                .circle()
                                                                                .withWaves()
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_accent)
                                                                        .appendChild(text("ACCENT"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button.create(Icons.keyboard())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_accent))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_red)
                                                                        .appendChild(text("RED"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.content_cut())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_red))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_pink)
                                                                        .appendChild(text("PINK"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.content_paste())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_pink))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_purple)
                                                                        .appendChild(text("PURPLE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.alarm())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_purple))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_deep_purple)
                                                                        .appendChild(text("DEEP_PURPLE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.timeline())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_deep_purple))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_indigo)
                                                                        .appendChild(text("INDIGO"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.account())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_indigo))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_blue)
                                                                        .appendChild(text("BLUE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.seat()).circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_blue))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_light_blue)
                                                                        .appendChild(text("LIGHT_BLUE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.alarm())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_light_blue))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_cyan)
                                                                        .appendChild(text("CYAN"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.air_conditioner())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_cyan))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_teal)
                                                                        .appendChild(text("TEAL"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.apps())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_teal))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_green)
                                                                        .appendChild(text("GREEN"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.assistant())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_green))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_light_green)
                                                                        .appendChild(text("LIGHT_GREEN"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.android())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_light_green))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_lime)
                                                                        .appendChild(text("LIME"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.album())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_lime))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_yellow)
                                                                        .appendChild(text("YELLOW"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.aspect_ratio())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_yellow))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_amber)
                                                                        .appendChild(text("AMBER"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.autorenew())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_amber))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_orange)
                                                                        .appendChild(text("ORANGE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.plus())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_orange))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_deep_orange)
                                                                        .appendChild(text("DEEP_ORANGE"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.location_enter())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_deep_orange))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_brown)
                                                                        .appendChild(text("BROWN"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.plus_box())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_brown))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_grey)
                                                                        .appendChild(text("GREY"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.book_remove())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_grey))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_blue_grey)
                                                                        .appendChild(text("BLUE_GREY"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.book_plus())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_blue_grey))
                                                                        )
                                                                ),
                                                        div().addCss(dui_flex).addCss(dui_items_center)
                                                                .appendChild(div().addCss(dui_grow_1, dui_fg_black)
                                                                        .appendChild(text("BLACK"))
                                                                )
                                                                .appendChild(div()
                                                                        .appendChild(Button
                                                                                .create(Icons.adjust())
                                                                                .circle()
                                                                                .withWaves(wavesSupport -> wavesSupport.getElement().addCss(dui_waves_black))
                                                                        )
                                                                )
                                                )
                                        )
                                )
                        )
                )
        );
    }
}