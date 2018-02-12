package com.progressoft.brix.domino.menu.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import com.progressoft.brix.domino.menu.shared.extension.MenuContext;

public interface MenuView extends View{
    void init(IsLayout layout);

    MenuContext.CanAddMenuItem addMenuItem(String title, String iconName, MenuContext.OnMenuSelectedHandler selectionHandler);

    MenuContext.CanAddMenuItem addMenuItem(String title, String iconName);
}