package org.dominokit.domino.themes.client.views.ui;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.themes.client.presenters.ThemesButtonProxy;
import org.dominokit.domino.themes.client.views.ThemesButtonView;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.layout.LayoutActionItem;
import org.dominokit.domino.view.BaseElementView;

@UiView(presentable = ThemesButtonProxy.class)
public class ThemesButtonViewImpl extends BaseElementView<HTMLElement> implements ThemesButtonView {

    private LayoutActionItem actionItem;
    private ThemesButtonUiHandlers uiHandlers;

    @Override
    protected HTMLElement init() {
        actionItem = LayoutActionItem.create(Icons.ALL.theme_light_dark_mdi()
                .addClickListener(evt -> uiHandlers.onShowHideThemes()));
        return actionItem.element();
    }

    @Override
    public void setUiHandlers(ThemesButtonUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }
}