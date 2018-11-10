package org.dominokit.domino.menu.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.menu.shared.extension.MenuContext;

public interface MenuView extends ContentView {
    void init(IsLayout layout);

    MenuContext.CanAddMenuItem addMenuItem(String title, String iconName, MenuContext.OnMenuSelectedHandler selectionHandler);

    MenuContext.CanAddMenuItem addMenuItem(String title, String iconName);

    void setTitle(String title);
}