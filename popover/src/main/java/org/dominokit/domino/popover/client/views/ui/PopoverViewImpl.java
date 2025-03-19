package org.dominokit.domino.popover.client.views.ui;

import elemental2.dom.HTMLDivElement;
import static org.dominokit.domino.ui.utils.Domino.*;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.popover.client.presenters.PopoverProxy;
import org.dominokit.domino.popover.client.views.PopoverView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;

@UiView(presentable = PopoverProxy.class)
@SampleClass
public class PopoverViewImpl extends BaseDemoView<HTMLDivElement> implements PopoverView {

    private DivElement element;

    private Button popOverButton(String text, DropDirection direction) {
        return Button.create(text)
                .addCss(dui_bg_accent)
                .apply(button -> {
                    Popover.create(button)
                            .addCss(dui_bg_accent, dui_rounded_sm)
                            .setPosition(direction)
                            .appendChild(Card.create(text)
                                    .setIcon(Icons.message_settings_outline())
                                    .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                    .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                    .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                            );
                });
    }


    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("popover", this.getClass()));
        element.appendChild(BlockHeader.create("TOOLTIPS & POPOVER"));

        tooltips();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.tooltips()));

        popover();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.popover()));

        dropDirection();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.dropDirection()));

        return element.element();
    }

    @SampleMethod
    private void tooltips() {
        element.appendChild(Card.create("TOOLTIPS")
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(Button.create("TOOLTIP ON RIGHT")
                                        .addCss(dui_bg_accent)
                                        .setTooltip("Tooltip on right", DropDirection.RIGHT_MIDDLE)
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("TOOLTIP ON TOP")
                                        .addCss(dui_bg_accent)
                                        .setTooltip("Tooltip on top", DropDirection.TOP_MIDDLE)
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("TOOLTIP ON BOTTOM 1s delay")
                                        .addCss(dui_bg_accent)
                                        .setTooltip("Tooltip on bottom with 1s delay", DropDirection.BOTTOM_MIDDLE)
                                        .withToolTip((parent, self) -> self.ifPresent(tooltip -> {
                                            tooltip.setOpenDelay(1000);
                                        }))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("TOOLTIP ON LEFT")
                                        .addCss(dui_bg_accent)
                                        .setTooltip("Tooltip on bottom", DropDirection.LEFT_MIDDLE)
                                )
                        )
                )
        );
    }

    @SampleMethod
    private void popover() {
        element.appendChild(Card.create("POPOVER")
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(Button.create("POPOVER ON RIGHT")
                                        .addCss(dui_bg_accent)
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .addCss(dui_bg_accent, dui_rounded_sm)
                                                    .setPosition(DropDirection.RIGHT_MIDDLE)
                                                    .appendChild(Card.create("Popover on right")
                                                            .setIcon(Icons.message_settings_outline())
                                                            .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                            .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                            .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                                    );
                                        })
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("POPOVER ON TOP")
                                        .addCss(dui_bg_accent)
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .addCss(dui_bg_accent, dui_rounded_sm)
                                                    .setPosition(DropDirection.TOP_MIDDLE)
                                                    .appendChild(Card.create("Popover on TOP")
                                                            .setIcon(Icons.message_settings_outline())
                                                            .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                            .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                            .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                                    );
                                        })
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("POPOVER ON BOTTOM")
                                        .addCss(dui_bg_accent)
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .addCss(dui_bg_accent, dui_rounded_sm)
                                                    .setPosition(DropDirection.BOTTOM_MIDDLE)
                                                    .appendChild(Card.create("Popover on BOTTOM")
                                                            .setIcon(Icons.message_settings_outline())
                                                            .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                            .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                            .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                                    );
                                        })
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(Button.create("POPOVER ON LEFT")
                                        .addCss(dui_bg_accent, dui_fg)
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .addCss(dui_bg_accent, dui_rounded_sm)
                                                    .setPosition(DropDirection.LEFT_MIDDLE)
                                                    .appendChild(Card.create("Popover on left")
                                                            .setIcon(Icons.message_settings_outline())
                                                            .addCss(dui_bg_accent, dui_fg, dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                            .appendChild(PostfixAddOn.of(Icons.dots_vertical().clickable()))
                                                            .appendChild(h(4).addCss(dui_m_t_0).appendChild("Headline here"))
                                                            .appendChild(p("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                                                    );
                                        })
                                )
                        )
                )
        );
    }

    @SampleMethod
    private void dropDirection() {
        element.appendChild(Card.create("DROP DIRECTION", "Drop direction will try to best fit with a preferred position")
                .appendChild(Row.create()
                        .span3(popOverButton("BEST FIT SIDE", DropDirection.BEST_FIT_SIDE))
                        .span3(popOverButton("BEST FIT SIDE", DropDirection.BEST_FIT_SIDE))
                        .span3(popOverButton("BEST FIT SIDE", DropDirection.BEST_FIT_SIDE))
                        .span3(popOverButton("BEST FIT SIDE", DropDirection.BEST_FIT_SIDE))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("BEST MIDDLE DOWN/UP", DropDirection.BEST_MIDDLE_DOWN_UP))
                        .span3(popOverButton("BEST MIDDLE DOWN/UP", DropDirection.BEST_MIDDLE_DOWN_UP))
                        .span3(popOverButton("BEST MIDDLE DOWN/UP", DropDirection.BEST_MIDDLE_DOWN_UP))
                        .span3(popOverButton("BEST MIDDLE DOWN/UP", DropDirection.BEST_MIDDLE_DOWN_UP))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("BEST MIDDLE UP/DOWN", DropDirection.BEST_MIDDLE_UP_DOWN))
                        .span3(popOverButton("BEST MIDDLE UP/DOWN", DropDirection.BEST_MIDDLE_UP_DOWN))
                        .span3(popOverButton("BEST MIDDLE UP/DOWN", DropDirection.BEST_MIDDLE_UP_DOWN))
                        .span3(popOverButton("BEST MIDDLE UP/DOWN", DropDirection.BEST_MIDDLE_UP_DOWN))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("BEST MIDDLE SIDE", DropDirection.BEST_MIDDLE_SIDE))
                        .span3(popOverButton("BEST MIDDLE SIDE", DropDirection.BEST_MIDDLE_SIDE))
                        .span3(popOverButton("BEST MIDDLE SIDE", DropDirection.BEST_MIDDLE_SIDE))
                        .span3(popOverButton("BEST MIDDLE SIDE", DropDirection.BEST_MIDDLE_SIDE))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("BEST SIDE UP/DOWN", DropDirection.BEST_SIDE_UP_DOWN))
                        .span3(popOverButton("BEST SIDE UP/DOWN", DropDirection.BEST_SIDE_UP_DOWN))
                        .span3(popOverButton("BEST SIDE UP/DOWN", DropDirection.BEST_SIDE_UP_DOWN))
                        .span3(popOverButton("BEST SIDE UP/DOWN", DropDirection.BEST_SIDE_UP_DOWN))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("BOTTOM LEFT", DropDirection.BOTTOM_LEFT))
                        .span3(popOverButton("BOTTOM LEFT", DropDirection.BOTTOM_LEFT))
                        .span3(popOverButton("BOTTOM LEFT", DropDirection.BOTTOM_LEFT))
                        .span3(popOverButton("BOTTOM LEFT", DropDirection.BOTTOM_LEFT))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("BOTTOM MIDDLE", DropDirection.BOTTOM_MIDDLE))
                        .span3(popOverButton("BOTTOM MIDDLE", DropDirection.BOTTOM_MIDDLE))
                        .span3(popOverButton("BOTTOM MIDDLE", DropDirection.BOTTOM_MIDDLE))
                        .span3(popOverButton("BOTTOM MIDDLE", DropDirection.BOTTOM_MIDDLE))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("BOTTOM RIGHT", DropDirection.BOTTOM_RIGHT))
                        .span3(popOverButton("BOTTOM RIGHT", DropDirection.BOTTOM_RIGHT))
                        .span3(popOverButton("BOTTOM RIGHT", DropDirection.BOTTOM_RIGHT))
                        .span3(popOverButton("BOTTOM RIGHT", DropDirection.BOTTOM_RIGHT))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("LEFT DOWN", DropDirection.LEFT_DOWN))
                        .span3(popOverButton("LEFT DOWN", DropDirection.LEFT_DOWN))
                        .span3(popOverButton("LEFT DOWN", DropDirection.LEFT_DOWN))
                        .span3(popOverButton("LEFT DOWN", DropDirection.LEFT_DOWN))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("LEFT MIDDLE", DropDirection.LEFT_MIDDLE))
                        .span3(popOverButton("LEFT MIDDLE", DropDirection.LEFT_MIDDLE))
                        .span3(popOverButton("LEFT MIDDLE", DropDirection.LEFT_MIDDLE))
                        .span3(popOverButton("LEFT MIDDLE", DropDirection.LEFT_MIDDLE))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("LEFT UP", DropDirection.LEFT_UP))
                        .span3(popOverButton("LEFT UP", DropDirection.LEFT_UP))
                        .span3(popOverButton("LEFT UP", DropDirection.LEFT_UP))
                        .span3(popOverButton("LEFT UP", DropDirection.LEFT_UP))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("MIDDLE SCREEN", DropDirection.MIDDLE_SCREEN))
                        .span3(popOverButton("MIDDLE SCREEN", DropDirection.MIDDLE_SCREEN))
                        .span3(popOverButton("MIDDLE SCREEN", DropDirection.MIDDLE_SCREEN))
                        .span3(popOverButton("MIDDLE SCREEN", DropDirection.MIDDLE_SCREEN))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("MOUSE BEST FIT", DropDirection.BEST_MOUSE_FIT))
                        .span3(popOverButton("MOUSE BEST FIT", DropDirection.BEST_MOUSE_FIT))
                        .span3(popOverButton("MOUSE BEST FIT", DropDirection.BEST_MOUSE_FIT))
                        .span3(popOverButton("MOUSE BEST FIT", DropDirection.BEST_MOUSE_FIT))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("RIGHT DOWN", DropDirection.RIGHT_DOWN))
                        .span3(popOverButton("RIGHT DOWN", DropDirection.RIGHT_DOWN))
                        .span3(popOverButton("RIGHT DOWN", DropDirection.RIGHT_DOWN))
                        .span3(popOverButton("RIGHT DOWN", DropDirection.RIGHT_DOWN))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("RIGHT MIDDLE", DropDirection.RIGHT_MIDDLE))
                        .span3(popOverButton("RIGHT MIDDLE", DropDirection.RIGHT_MIDDLE))
                        .span3(popOverButton("RIGHT MIDDLE", DropDirection.RIGHT_MIDDLE))
                        .span3(popOverButton("RIGHT MIDDLE", DropDirection.RIGHT_MIDDLE))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("RIGHT UP", DropDirection.RIGHT_UP))
                        .span3(popOverButton("RIGHT UP", DropDirection.RIGHT_UP))
                        .span3(popOverButton("RIGHT UP", DropDirection.RIGHT_UP))
                        .span3(popOverButton("RIGHT UP", DropDirection.RIGHT_UP))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("TOP LEFT", DropDirection.TOP_LEFT))
                        .span3(popOverButton("TOP LEFT", DropDirection.TOP_LEFT))
                        .span3(popOverButton("TOP LEFT", DropDirection.TOP_LEFT))
                        .span3(popOverButton("TOP LEFT", DropDirection.TOP_LEFT))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("TOP MIDDLE", DropDirection.TOP_MIDDLE))
                        .span3(popOverButton("TOP MIDDLE", DropDirection.TOP_MIDDLE))
                        .span3(popOverButton("TOP MIDDLE", DropDirection.TOP_MIDDLE))
                        .span3(popOverButton("TOP MIDDLE", DropDirection.TOP_MIDDLE))
                )
                .appendChild(Row.create()
                        .span3(popOverButton("TOP RIGHT", DropDirection.TOP_RIGHT))
                        .span3(popOverButton("TOP RIGHT", DropDirection.TOP_RIGHT))
                        .span3(popOverButton("TOP RIGHT", DropDirection.TOP_RIGHT))
                        .span3(popOverButton("TOP RIGHT", DropDirection.TOP_RIGHT))
                )
        );
    }
}