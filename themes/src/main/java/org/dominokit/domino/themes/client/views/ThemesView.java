package org.dominokit.domino.themes.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.View;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.layout.shared.extension.IsLayout;

public interface ThemesView extends ContentView {
    void setLayout(IsLayout layout);
    void applyTheme(String theme);

    void registerTheme(String theme);
    void registerTheme(String theme, boolean active);

    void onThemeApplied(ThemeAppliedHandler themeAppliedHandler);

    @FunctionalInterface
    interface ThemeAppliedHandler {
        void onThemeApplied(String theme);
    }
}