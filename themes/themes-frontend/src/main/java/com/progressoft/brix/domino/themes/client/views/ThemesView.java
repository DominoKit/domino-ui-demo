package com.progressoft.brix.domino.themes.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;

public interface ThemesView extends View {
    void setLayout(IsLayout layout);
    Content themesContent();

    void registerTheme(String theme);
    void registerTheme(String theme, boolean active);
}