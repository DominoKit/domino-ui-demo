package org.dominokit.domino.flexlayout.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.flexlayout.client.presenters.FlexLayoutProxy;
import org.dominokit.domino.flexlayout.client.views.FlexLayoutView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.Radio;
import org.dominokit.domino.ui.forms.RadioGroup;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.*;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.TextNode;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;
import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = FlexLayoutProxy.class)
@SampleClass
public class FlexLayoutViewImpl extends BaseDemoView<HTMLDivElement> implements FlexLayoutView {

    private HTMLDivElement element;
    private Card layoutPlaygroundCard;
    private Card flexItemsCard;

    @Override
    protected void init(HTMLDivElement root) {
        element.appendChild(LinkToSourceCode.create("flexlayout", this.getClass()).element());
        element.appendChild(BlockHeader.create("FLEX LAYOUT").element());
        element.appendChild(p().textContent("You can find a complete guide for Flex layout ")
                .style("color: #666;")
                .add(a().attr("href", "https://css-tricks.com/snippets/css/a-guide-to-flexbox/")
                        .textContent("here."))
                .add(TextNode.of(" Or flex documentation on "))
                .add(a().attr("href", "https://developer.mozilla.org/en-US/docs/Web/CSS/flex")
                        .textContent("MDN."))
                .element());
        layoutPlaygroundCard = Card.create("LAYOUT PLAYGROUND");
        flexItemsCard = Card.create("FLEX ITEMS");

        initLayoutPlayground();
        initFlexItems();

        element.appendChild(layoutPlaygroundCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initLayoutPlayground()).element());
        element.appendChild(flexItemsCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initFlexItems()).element());
    }

    @Override
    public HTMLDivElement createRoot() {
        element = div().element();
        return element;
    }

    @SampleMethod
    private void initLayoutPlayground() {
        RadioGroup<String> alignItemsRadioGroup = RadioGroup.<String>create("align-items").hide();
        CheckBox fillHeightCheckBox = CheckBox.create("Fill height");
        RadioGroup<String> directionsRadioGroup = RadioGroup.create("direction");
        RadioGroup<String> justifyContentRadioGroup = RadioGroup.create("justify-content");

        // ********* settings part ********* //
        Button addBlockButton = Button.create("ADD BLOCK");
        Button resetButton = Button.create("RESET");
        RadioGroup<String> wrapRadioGroup = RadioGroup.create("wrap", "Wrap");
        layoutPlaygroundCard.setBodyPaddingTop("40px")
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(directionsRadioGroup
                                        .setHelperText("Containers inside Flex Layout can have different directions")
                                        .setLabel("Directions")
                                        .appendChild(Radio.create(FlexDirection.LEFT_TO_RIGHT.name(), "Left to right").check())
                                        .appendChild(Radio.create(FlexDirection.RIGHT_TO_LEFT.name(), "Right to left"))
                                        .appendChild(Radio.create(FlexDirection.TOP_TO_BOTTOM.name(), "Top to bottom"))
                                        .appendChild(Radio.create(FlexDirection.BOTTOM_TO_TOP.name(), "Bottom to top"))
                                        .horizontal()
                                ))
                        .appendChild(Column.span2()
                                .appendChild(fillHeightCheckBox))
                        .appendChild(Column.span4()
                                .appendChild(wrapRadioGroup
                                        .appendChild(Radio.create(FlexWrap.NO_WRAP.name(), "No wrap").check())
                                        .appendChild(Radio.create(FlexWrap.WRAP_TOP_TO_BOTTOM.name(), "Wrap top to bottom"))
                                        .appendChild(Radio.create(FlexWrap.WRAP_BOTTOM_TO_TOP.name(), "Wrap bottom to top"))
                                        .horizontal())
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(justifyContentRadioGroup
                                        .setHelperText("Containers inside Flex Layout can be placed in different ways")
                                        .setLabel("Justify Content")
                                        .appendChild(Radio.create(FlexJustifyContent.START.name(), "Start").check())
                                        .appendChild(Radio.create(FlexJustifyContent.END.name(), "End"))
                                        .appendChild(Radio.create(FlexJustifyContent.CENTER.name(), "Center"))
                                        .appendChild(Radio.create(FlexJustifyContent.SPACE_BETWEEN.name(), "Space between"))
                                        .appendChild(Radio.create(FlexJustifyContent.SPACE_AROUND.name(), "Space around"))
                                        .appendChild(Radio.create(FlexJustifyContent.SPACE_EVENLY.name(), "Space evenly"))
                                        .horizontal()
                                ))
                        .appendChild(Column.span6()
                                .appendChild(alignItemsRadioGroup
                                        .setHelperText("Containers inside Flex Layout can be aligned in different ways")
                                        .setLabel("Align items")
                                        .appendChild(Radio.create(FlexAlign.START.name(), "Start"))
                                        .appendChild(Radio.create(FlexAlign.END.name(), "End"))
                                        .appendChild(Radio.create(FlexAlign.CENTER.name(), "Center"))
                                        .appendChild(Radio.create(FlexAlign.STRETCH.name(), "Stretch").check())
                                        .appendChild(Radio.create(FlexAlign.BASE_LINE.name(), "Base line"))
                                        .horizontal()
                                )
                        )
                )
                .appendChild(Row.create()
                        .fullSpan(column -> {
                            column.appendChild(resetButton.linkify().style().add(Styles.pull_right))
                                    .appendChild(addBlockButton.linkify().style().add(Styles.pull_right));
                        })
                );

        // ********* flex layout part ********* //
        FlexLayout flexLayout = FlexLayout.create()
                .style()
                .add("demo-flex-layout-container")
                .get()
                .appendChild(FlexItem.create()
                        .style()
                        .add("demo-flex-layout-block")
                        .get()
                        .appendChild(h(4)))
                .appendChild(FlexItem.create()
                        .style()
                        .add("demo-flex-layout-block")
                        .get()
                        .appendChild(h(4)))
                .appendChild(FlexItem.create()
                        .style()
                        .add("demo-flex-layout-block")
                        .get()
                        .appendChild(h(4)))
                .setDirection(FlexDirection.LEFT_TO_RIGHT);

        layoutPlaygroundCard.appendChild(div()
                .css("demo-flex-layout-result-container")
                .add(flexLayout)
                .element());

        // ********* listeners part ********* //
        directionsRadioGroup.addChangeHandler(direction -> {
            FlexDirection flexDirection = FlexDirection.valueOf(direction);
            if (fillHeightCheckBox.isChecked() || isVerticalDirection(flexDirection)) {
                flexLayout.style().add("fill-height");
            } else {
                flexLayout.style().remove("fill-height");
            }
            flexLayout.setDirection(flexDirection);
        });

        fillHeightCheckBox.addChangeHandler(value -> {
            if (value) {
                alignItemsRadioGroup.show();
                flexLayout.style().add("fill-height");
            } else {
                alignItemsRadioGroup.hide();
                flexLayout.style().remove("fill-height");
            }
        });

        justifyContentRadioGroup.addChangeHandler(direction -> {
            flexLayout.setJustifyContent(FlexJustifyContent.valueOf(direction));
        });

        alignItemsRadioGroup.addChangeHandler(direction -> {
            flexLayout.setAlignItems(FlexAlign.valueOf(direction));
        });

        wrapRadioGroup.addChangeHandler(value -> {
            flexLayout.setWrap(FlexWrap.valueOf(value));
        });

        List<FlexItem> dynamicAddedItems = new ArrayList<>();

        addBlockButton.addClickListener(evt -> {
            FlexItem item = FlexItem.create()
                    .style()
                    .add("demo-flex-layout-block")
                    .get()
                    .appendChild(h(4));
            flexLayout.appendChild(item);
            dynamicAddedItems.add(item);
        });

        resetButton.addClickListener(evt -> {
            for (FlexItem dynamicAddedItem : dynamicAddedItems) {
                dynamicAddedItem.remove();
            }
            dynamicAddedItems.clear();
        });
    }

    @SampleMethod
    private void initFlexItems() {
        Slider orderSlider = Slider.create(6);
        Slider flexGrowSlider = Slider.create(10);
        Slider flexShrinkSlider = Slider.create(10);
        TextBox flexBasisTextBox = TextBox.create("Flex Basis").setHelperText("Default size of an element before the remaining space is distributed");
        RadioGroup<String> targetBlockRadioGroup = RadioGroup.create("target-block", "Target block # to play with");
        RadioGroup<String> alignSelfRadioGroup = RadioGroup.create("align-self", "Align self");

        flexItemsCard.setBodyPaddingTop("40px")
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
                                        .appendChild(Radio.create(FlexAlign.START.name(), "Start"))
                                        .appendChild(Radio.create(FlexAlign.END.name(), "End"))
                                        .appendChild(Radio.create(FlexAlign.CENTER.name(), "Center"))
                                        .appendChild(Radio.create(FlexAlign.STRETCH.name(), "Stretch"))
                                        .appendChild(Radio.create(FlexAlign.BASE_LINE.name(), "Base line"))
                                        .horizontal()
                                )
                        )
                );

        FlexLayout flexLayout = FlexLayout.create()
                .style()
                .add("demo-flex-layout-container")
                .add("fill-height")
                .get()
                .setDirection(FlexDirection.LEFT_TO_RIGHT);

        Map<String, FlexItem> items = new HashMap<>();
        for (int i = 0; i < 5; i++) {
            FlexItem item = FlexItem.create()
                    .style()
                    .add("demo-flex-layout-block")
                    .add(colorOf(i + 1).getBackground())
                    .get()
                    .setAlignSelf(FlexAlign.START)
                    .setOrder(i + 1)
                    .appendChild(h(4));
            items.put(i + "", item);
            flexLayout.appendChild(item);
        }

        flexItemsCard.appendChild(div()
                .css("demo-flex-layout-result-container")
                .add(flexLayout)
                .element());


        orderSlider.addSlideHandler(value -> {
            items.get(targetBlockRadioGroup.getValue())
                    .setOrder((int) value);
        });

        flexGrowSlider.addSlideHandler(value -> {
            items.get(targetBlockRadioGroup.getValue())
                    .setFlexGrow((int) value);
        });

        flexShrinkSlider.addSlideHandler(value -> {
            items.get(targetBlockRadioGroup.getValue())
                    .setFlexShrink((int) value);
        });

        alignSelfRadioGroup.addChangeHandler(value -> {
            items.get(targetBlockRadioGroup.getValue())
                    .setAlignSelf(FlexAlign.valueOf(value));
        });

        flexBasisTextBox.addChangeHandler(value -> {
            items.get(targetBlockRadioGroup.getValue())
                    .setFlexBasis(value);
        });

        targetBlockRadioGroup.addChangeHandler(value -> {
            FlexItem flexItem = items.get(targetBlockRadioGroup.getValue());
            flexGrowSlider.setValue(flexItem.getFlexGrow());
            orderSlider.setValue(flexItem.getOrder());
            flexShrinkSlider.setValue(flexItem.getFlexShrink());
            flexBasisTextBox.setValue(isNull(flexItem.getFlexBasis()) ? "" : flexItem.getFlexBasis());
            alignSelfRadioGroup.setValue(flexItem.getAlignSelf().name());
        });

        targetBlockRadioGroup.setValue("2");
    }

    private Color colorOf(int i) {
        switch (i) {
            case 1:
                return Color.RED;
            case 2:
                return Color.BLUE;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.WHITE;
            case 5:
                return Color.TEAL;
            default:
                return Color.BLACK;
        }
    }

    private boolean isVerticalDirection(FlexDirection flexDirection) {
        return FlexDirection.TOP_TO_BOTTOM.equals(flexDirection) || FlexDirection.BOTTOM_TO_TOP.equals(flexDirection);
    }
}