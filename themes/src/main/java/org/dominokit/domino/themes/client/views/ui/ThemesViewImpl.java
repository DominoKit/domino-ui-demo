package org.dominokit.domino.themes.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.themes.client.presenters.ThemesProxy;
import org.dominokit.domino.themes.client.views.ThemesView;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.themes.DominoThemeAccent;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.themes.IsDominoTheme;
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
                        .appendChild(themDiv(dui_bg_red, DominoThemeAccent.RED))
                        .appendChild(themDiv(dui_bg_pink, DominoThemeAccent.PINK))
                        .appendChild(themDiv(dui_bg_purple, DominoThemeAccent.PURPLE))
                        .appendChild(themDiv(dui_bg_deep_purple, DominoThemeAccent.DEEP_PURPLE))
                        .appendChild(themDiv(dui_bg_indigo, DominoThemeAccent.INDIGO))
                        .appendChild(themDiv(dui_bg_blue, DominoThemeAccent.BLUE))
                        .appendChild(themDiv(dui_bg_light_blue, DominoThemeAccent.LIGHT_BLUE))
                        .appendChild(themDiv(dui_bg_cyan, DominoThemeAccent.CYAN))
                        .appendChild(themDiv(dui_bg_teal, DominoThemeAccent.TEAL))
                        .appendChild(themDiv(dui_bg_green, DominoThemeAccent.GREEN))
                        .appendChild(themDiv(dui_bg_light_green, DominoThemeAccent.LIGHT_GREEN))
                        .appendChild(themDiv(dui_bg_lime, DominoThemeAccent.LIME))
                        .appendChild(themDiv(dui_bg_yellow, DominoThemeAccent.YELLOW))
                        .appendChild(themDiv(dui_bg_amber, DominoThemeAccent.AMBER))
                        .appendChild(themDiv(dui_bg_orange, DominoThemeAccent.ORANGE))
                        .appendChild(themDiv(dui_bg_deep_orange, DominoThemeAccent.DEEP_ORANGE))
                        .appendChild(themDiv(dui_bg_brown, DominoThemeAccent.BROWN))
                        .appendChild(themDiv(dui_bg_grey, DominoThemeAccent.GREY))
                        .appendChild(themDiv(dui_bg_blue_grey, DominoThemeAccent.BLUE_GREY))

                );

        return root.element();
    }

    private DivElement themDiv(CssClass bg, IsDominoTheme theme) {
        return div()
                .addCss(bg, dui_w_4, dui_h_4, dui_cursor_pointer)
                .addClickListener(evt -> {
                    DominoThemeManager.INSTANCE.apply(theme);
                });
    }

    @Override
    public void setUiHandlers(ThemesUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }

}