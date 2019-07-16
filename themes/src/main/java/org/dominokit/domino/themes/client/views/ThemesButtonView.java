package org.dominokit.domino.themes.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface ThemesButtonView extends ContentView, HasUiHandlers<ThemesButtonView.ThemesButtonUiHandlers> {
    @FunctionalInterface
    interface ThemesButtonUiHandlers extends UiHandlers {
        void onShowHideThemes();
    }
}