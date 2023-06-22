package org.dominokit.domino.themes.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.themes.client.presenters.ThemesProxy;
import org.dominokit.domino.themes.client.views.ThemesView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.ElementsFactory;
import org.dominokit.domino.view.BaseElementView;

@UiView(presentable = ThemesProxy.class)
public class ThemesViewImpl extends BaseElementView<HTMLDivElement> implements ThemesView, ElementsFactory {

    private DivElement root;
    private ThemesUiHandlers uiHandlers;
    private SwapCssClass themeCss =  SwapCssClass.of();

    @Override
    protected HTMLDivElement init() {

        root = div().addCss(dui_p_4)
                .appendChild(BlockHeader.create("Theme accent", "Pick color to change the them accent."))
                .appendChild(div()
                        .addCss(dui_flex, dui_flex_wrap, dui_gap_0_5)
                        .appendChild(themDiv(dui_bg_red, dui_accent_red))
                        .appendChild(themDiv(dui_bg_pink, dui_accent_pink))
                        .appendChild(themDiv(dui_bg_purple, dui_accent_purple))
                        .appendChild(themDiv(dui_bg_deep_purple, dui_accent_deep_purple))
                        .appendChild(themDiv(dui_bg_indigo, dui_accent_indigo))
                        .appendChild(themDiv(dui_bg_blue, dui_accent_blue))
                        .appendChild(themDiv(dui_bg_light_blue, dui_accent_light_blue))
                        .appendChild(themDiv(dui_bg_cyan, dui_accent_cyan))
                        .appendChild(themDiv(dui_bg_teal, dui_accent_teal))
                        .appendChild(themDiv(dui_bg_green, dui_accent_green))
                        .appendChild(themDiv(dui_bg_light_green, dui_accent_light_green))
                        .appendChild(themDiv(dui_bg_lime, dui_accent_lime))
                        .appendChild(themDiv(dui_bg_yellow, dui_accent_yellow))
                        .appendChild(themDiv(dui_bg_amber, dui_accent_amber))
                        .appendChild(themDiv(dui_bg_orange, dui_accent_orange))
                        .appendChild(themDiv(dui_bg_deep_orange, dui_accent_deep_orange))
                        .appendChild(themDiv(dui_bg_brown, dui_accent_brown))
                        .appendChild(themDiv(dui_bg_grey, dui_accent_grey))
                        .appendChild(themDiv(dui_bg_blue_grey, dui_accent_blue_grey))
                        .appendChild(themDiv(dui_bg_white, dui_accent_white))
                        .appendChild(themDiv(dui_bg_black, dui_accent_black))

                );

        return root.element();
    }

    private DivElement themDiv(CssClass bg, CssClass accent) {
        return div()
                .addCss(bg, dui_w_4, dui_h_4, dui_cursor_pointer)
                .addClickListener(evt -> body().addCss(themeCss.replaceWith(accent)));
    }

    @Override
    public void setUiHandlers(ThemesUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }

}