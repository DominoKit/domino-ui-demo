package org.dominokit.domino.flexlayout.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.flexlayout.client.presenters.FlexLayoutProxy;
import org.dominokit.domino.flexlayout.client.views.FlexLayoutView;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.Radio;
import org.dominokit.domino.ui.forms.RadioGroup;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.LimitOneOfCssClass;
import org.dominokit.domino.ui.typography.BlockHeader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UiView(presentable = FlexLayoutProxy.class)
@SampleClass
public class FlexLayoutViewImpl extends BaseDemoView<HTMLDivElement> implements FlexLayoutView {

    private DivElement element;
    private Card layoutPlaygroundCard;
    private Card flexItemsCard;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("flexlayout", this.getClass()));
        element.appendChild(BlockHeader.create("FLEX LAYOUT"));
        element.appendChild(p().textContent("You can find a complete guide for Flex layout ")
                .style("color: #666;")
                .appendChild(a().setAttribute("href", "https://css-tricks.com/snippets/css/a-guide-to-flexbox/")
                        .textContent("here."))
                .appendChild(text(" Or flex documentation on "))
                .appendChild(a().setAttribute("href", "https://developer.mozilla.org/en-US/docs/Web/CSS/flex")
                        .textContent("MDN."))
        );
        layoutPlaygroundCard = Card.create("LAYOUT PLAYGROUND");
        flexItemsCard = Card.create("FLEX ITEMS");

        initLayoutPlayground();
        initFlexItems();

        element.appendChild(layoutPlaygroundCard);
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initLayoutPlayground()));
        element.appendChild(flexItemsCard);
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initFlexItems()));

        return element.element();
    }


    @SampleMethod
    private void initLayoutPlayground() {
        RadioGroup<CssClass> alignItemsRadioGroup = RadioGroup.create("align-items");
        RadioGroup<CssClass> directionsRadioGroup = RadioGroup.create("direction");
        RadioGroup<CssClass> justifyContentRadioGroup = RadioGroup.create("justify-content");

        // ********* settings part ********* //
        LinkButton addBlockButton = LinkButton.create("ADD BLOCK");
        LinkButton resetButton = LinkButton.create("RESET");
        RadioGroup<CssClass> wrapRadioGroup = RadioGroup.create("wrap", "Wrap");
        LimitOneOfCssClass directionCss = LimitOneOfCssClass.of(
                dui_flex_row,
                dui_flex_row_reverse,
                dui_flex_col,
                dui_flex_col_reverse
        );

        LimitOneOfCssClass wrapCss = LimitOneOfCssClass.of(
                dui_flex_wrap,
                dui_flex_wrap_reverse,
                dui_flex_nowrap
        );

        LimitOneOfCssClass justifyContentCss = LimitOneOfCssClass.of(
                dui_justify_start,
                dui_justify_end,
                dui_justify_center,
                dui_justify_around,
                dui_justify_evenly,
                dui_justify_between
        );

        LimitOneOfCssClass alignItemsCss = LimitOneOfCssClass.of(
                dui_items_start,
                dui_items_end,
                dui_items_center,
                dui_items_stretch,
                dui_items_baseline
        );
        layoutPlaygroundCard
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(directionsRadioGroup
                                        .setHelperText("Containers inside Flex Layout can have different directions")
                                        .setLabel("Directions")
                                        .appendChild(Radio.create(dui_flex_row, "Left to right").check())
                                        .appendChild(Radio.create(dui_flex_row_reverse, "Right to left"))
                                        .appendChild(Radio.create(dui_flex_col, "Top to bottom"))
                                        .appendChild(Radio.create(dui_flex_col_reverse, "Bottom to top"))
                                        .horizontal()
                                ))
                        .appendChild(Column.span6()
                                .appendChild(wrapRadioGroup
                                        .appendChild(Radio.create(dui_flex_nowrap, "No wrap").check())
                                        .appendChild(Radio.create(dui_flex_wrap, "Wrap top to bottom"))
                                        .appendChild(Radio.create(dui_flex_wrap_reverse, "Wrap bottom to top"))
                                        .horizontal())
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(justifyContentRadioGroup
                                        .setHelperText("Containers inside Flex Layout can be placed in different ways")
                                        .setLabel("Justify Content")
                                        .appendChild(Radio.create(dui_justify_start, "Start").check())
                                        .appendChild(Radio.create(dui_justify_end, "End"))
                                        .appendChild(Radio.create(dui_justify_center, "Center"))
                                        .appendChild(Radio.create(dui_justify_between, "Space between"))
                                        .appendChild(Radio.create(dui_justify_around, "Space around"))
                                        .appendChild(Radio.create(dui_justify_evenly, "Space evenly"))
                                        .horizontal()
                                ))
                        .appendChild(Column.span6()
                                .appendChild(alignItemsRadioGroup
                                        .setHelperText("Containers inside Flex Layout can be aligned in different ways")
                                        .setLabel("Align items")
                                        .appendChild(Radio.create(dui_items_start, "Start").check())
                                        .appendChild(Radio.create(dui_items_end, "End"))
                                        .appendChild(Radio.create(dui_items_center, "Center"))
                                        .appendChild(Radio.create(dui_items_stretch, "Stretch"))
                                        .appendChild(Radio.create(dui_items_baseline, "Base line"))
                                        .horizontal()
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(resetButton.addCss(dui_float_right))
                                .appendChild(addBlockButton.addCss(dui_float_right)))
                );
        // ********* flex layout part ********* //
        DivElement flexLayout = div().addCss(dui_flex, dui_flex_row, dui_h_full, dui_items_start, dui_gap_4)
                .setCssProperty("counter-reset", "section")
                .appendChild(div()
                        .addCss(() -> "demo-flex-layout-block")
                        .appendChild(h(4)))
                .appendChild(div().addCss(() -> "demo-flex-layout-block")
                        .appendChild(h(4)))
                .appendChild(div().addCss(() -> "demo-flex-layout-block")
                        .appendChild(h(4)));

        layoutPlaygroundCard.appendChild(div()
                .addCss(dui_h_96, dui_bg_accent)
                .appendChild(flexLayout)
                .element());

        // ********* listeners part ********* //
        directionsRadioGroup.addChangeListener((old, direction) -> flexLayout.addCss(directionCss.use(direction)));


        justifyContentRadioGroup.addChangeListener((old, justify) -> flexLayout.addCss(justifyContentCss.use(justify)));

        alignItemsRadioGroup.addChangeListener((old, align) -> flexLayout.addCss(alignItemsCss.use(align)));

        wrapRadioGroup.addChangeListener((old, wrap) -> flexLayout.addCss(wrapCss.use(wrap)));

        List<DivElement> dynamicAddedItems = new ArrayList<>();

        addBlockButton.addClickListener(evt -> {
            DivElement item = div()
                    .addCss("demo-flex-layout-block")
                    .appendChild(h(4));
            flexLayout.appendChild(item);
            dynamicAddedItems.add(item);
        });

        resetButton.addClickListener(evt -> {
            for (DivElement dynamicAddedItem : dynamicAddedItems) {
                dynamicAddedItem.remove();
            }
            dynamicAddedItems.clear();
        });
    }

    @SampleMethod
    private void initFlexItems() {
        Slider orderSlider = Slider.create(7);
        Slider flexGrowSlider = Slider.create(10);
        Slider flexShrinkSlider = Slider.create(10);
        TextBox flexBasisTextBox = TextBox.create("Flex Basis").setHelperText("Default size of an element before the remaining space is distributed");
        RadioGroup<String> targetBlockRadioGroup = RadioGroup.create("target-block", "Target block # to play with");
        RadioGroup<CssClass> alignSelfRadioGroup = RadioGroup.create("align-self", "Align self");

        LimitOneOfCssClass alignSelfCss = LimitOneOfCssClass.of(
                dui_self_start,
                dui_self_end,
                dui_self_center,
                dui_self_stretch,
                dui_self_baseline
        );

        flexItemsCard
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(targetBlockRadioGroup
                                        .appendChild(Radio.create("0", "1"))
                                        .appendChild(Radio.create("1", "2"))
                                        .appendChild(Radio.create("2", "3"))
                                        .appendChild(Radio.create("3", "4"))
                                        .appendChild(Radio.create("4", "5"))
                                        .horizontal()
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(orderSlider.withThumb())
                                .appendChild(h(5).textContent("Order"))
                        )
                        .appendChild(Column.span4()
                                .appendChild(flexGrowSlider.withThumb())
                                .appendChild(h(5).textContent("Flex Grow"))
                        )
                        .appendChild(Column.span4()
                                .appendChild(flexShrinkSlider.withThumb())
                                .appendChild(h(5).textContent("Flex Shrink"))
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(flexBasisTextBox)
                        )
                        .appendChild(Column.span6()
                                .appendChild(alignSelfRadioGroup
                                        .appendChild(Radio.create(dui_self_start, "Start"))
                                        .appendChild(Radio.create(dui_self_end, "End"))
                                        .appendChild(Radio.create(dui_self_center, "Center"))
                                        .appendChild(Radio.create(dui_self_stretch, "Stretch"))
                                        .appendChild(Radio.create(dui_self_baseline, "Base line"))
                                        .horizontal()
                                )
                        )
                );

        DivElement flexLayout = div()
                .addCss(dui_flex, dui_flex_row, dui_h_full, dui_items_start, dui_gap_4)
                .setCssProperty("counter-reset", "section");

        Map<String, DivElement> items = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            DivElement item = div()
                    .addCss(dui_self_start, () -> "demo-flex-layout-block", background(i + 1), order(i))
                    .appendChild(h(4));
            items.put(String.valueOf(i), item);
            flexLayout.appendChild(item);
        }

        flexItemsCard.appendChild(div()
                .addCss(()->"demo-flex-layout-result-container", dui_bg_accent_d_4)
                .appendChild(flexLayout)
                .element());

        LimitOneOfCssClass orderCss = LimitOneOfCssClass.of(
                dui_order_1,
                dui_order_10,
                dui_order_20,
                dui_order_30,
                dui_order_40,
                dui_order_50,
                dui_order_60,
                dui_order_70
        );

        LimitOneOfCssClass growCss = LimitOneOfCssClass.of(
                dui_grow_0,
                dui_grow_1,
                dui_grow_2,
                dui_grow_3,
                dui_grow_4,
                dui_grow_5,
                dui_grow_6,
                dui_grow_7,
                dui_grow_8,
                dui_grow_9,
                dui_grow_10,
                dui_grow_11,
                dui_grow_12
        );

        LimitOneOfCssClass shrinkCss = LimitOneOfCssClass.of(
                dui_shrink_0,
                dui_shrink_1,
                dui_shrink_2,
                dui_shrink_3,
                dui_shrink_4,
                dui_shrink_5,
                dui_shrink_6,
                dui_shrink_7,
                dui_shrink_8,
                dui_shrink_9,
                dui_shrink_10,
                dui_shrink_11,
                dui_shrink_12
        );
        orderSlider.addChangeListener((old, value) -> items
                .get(targetBlockRadioGroup.getValue())
                .addCss(orderCss.use(order(value.intValue())))
                .setAttribute("dui-demo-order", value.intValue())
        );

        flexGrowSlider.addChangeListener((old, value) -> items.get(targetBlockRadioGroup.getValue())
                .addCss(growCss.use(grow(value.intValue())))
                .setAttribute("dui-demo-grow", value.intValue())
        );

        flexShrinkSlider.addChangeListener((old, value) -> items.get(targetBlockRadioGroup.getValue())
                .addCss(shrinkCss.use(shrink(value.intValue())))
                .setAttribute("dui-demo-shrink", value.intValue())
        );

        alignSelfRadioGroup.addChangeListener((old, value) -> items.get(targetBlockRadioGroup.getValue())
                .addCss(alignSelfCss.use(value))
        );

        flexBasisTextBox.addChangeListener((old, value) -> items.get(targetBlockRadioGroup.getValue())
                .setCssProperty("flex-basis", value)
                .setAttribute("dui-demo-basis", value)
        );

        targetBlockRadioGroup.addChangeListener((old, value) -> {
            DivElement flexItem = items.get(targetBlockRadioGroup.getValue());
            flexGrowSlider.setValue( Double.parseDouble(flexItem.getAttribute("dui-demo-grow", "0")));
            orderSlider.setValue(Double.parseDouble(flexItem.getAttribute("dui-demo-order", value)));
            flexShrinkSlider.setValue(Double.parseDouble(flexItem.getAttribute("dui-demo-shrink", "0")));
            flexBasisTextBox.setValue(flexItem.getAttribute("dui-demo-basis", "auto"));
            alignSelfCss.getActive(flexItem.element())
                            .ifPresent(alignSelfRadioGroup::setValue);

        });

        targetBlockRadioGroup.setValue("2");
    }

    private CssClass background(int i) {
        switch (i) {
            case 1:
                return dui_bg_accent;
            case 2:
                return dui_bg_accent_l_1;
            case 3:
                return dui_bg_accent_l_2;
            case 4:
                return dui_bg_accent_l_3;
            case 5:
                return dui_bg_accent_l_4;
            default:
                return dui_bg_accent_l_5;
        }
    }

    private CssClass order(int i) {
        switch (i) {
            case 0:
                return dui_order_10;
            case 1:
                return dui_order_20;
            case 2:
                return dui_order_30;
            case 3:
                return dui_order_40;
            case 4:
                return dui_order_50;
            case 5:
                return dui_order_60;
            default:
                return dui_order_70;
        }
    }

    private CssClass grow(int i) {
        switch (i) {
            case 0:
                return dui_grow_0;
            case 1:
                return dui_grow_1;
            case 2:
                return dui_grow_2;
            case 3:
                return dui_grow_3;
            case 4:
                return dui_grow_4;
            case 5:
                return dui_grow_5;
            case 6:
                return dui_grow_6;
            case 7:
                return dui_grow_7;
            case 8:
                return dui_grow_8;
            case 9:
                return dui_grow_9;
            case 10:
                return dui_grow_10;
            default:
                return dui_grow_12;
        }
    }

    private CssClass shrink(int i) {
        switch (i) {
            case 0:
                return dui_shrink_0;
            case 1:
                return dui_shrink_1;
            case 2:
                return dui_shrink_2;
            case 3:
                return dui_shrink_3;
            case 4:
                return dui_shrink_4;
            case 5:
                return dui_shrink_5;
            case 6:
                return dui_shrink_6;
            case 7:
                return dui_shrink_7;
            case 8:
                return dui_shrink_8;
            case 9:
                return dui_shrink_9;
            case 10:
                return dui_shrink_10;
            default:
                return dui_shrink_12;
        }
    }
}