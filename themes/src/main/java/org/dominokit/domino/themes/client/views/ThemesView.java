package org.dominokit.domino.themes.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface ThemesView extends ContentView, HasUiHandlers<ThemesView.ThemesUiHandlers> {

    interface ThemesUiHandlers extends UiHandlers{
        void onThemeApplied(String theme);
    }
}