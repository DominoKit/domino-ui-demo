package org.dominokit.domino.popover.client.views.ui;

import elemental2.dom.HTMLDivElement;
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

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("popover", this.getClass()));
        element.appendChild(BlockHeader.create("TOOLTIPS & POPOVER"));

        tooltips();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.tooltips()));

        popover();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.popover()));

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
                                .appendChild(Button.create("TOOLTIP ON BOTTOM")
                                        .addCss(dui_bg_accent)
                                        .setTooltip("Tooltip on bottom", DropDirection.BOTTOM_MIDDLE)
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
}