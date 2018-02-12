package com.progressoft.brix.domino.menu.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import com.progressoft.brix.domino.menu.client.presenters.MenuPresenter;
import com.progressoft.brix.domino.menu.client.views.MenuView;
import com.progressoft.brix.domino.ui.icons.Icon;
import com.progressoft.brix.domino.ui.menu.Menu;
import com.progressoft.brix.domino.ui.menu.MenuItem;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

import static com.progressoft.brix.domino.menu.shared.extension.MenuContext.*;

@UiView(presentable = MenuPresenter.class)
public class DefaultMenuView implements MenuView{

    private Menu menu;

    public DefaultMenuView() {
    }

    @Override
    public void init(IsLayout layout) {
        menu = Menu.create("Demo menu");
        HTMLElement leftPanel= Js.cast(layout.getLeftPanel().get());
        leftPanel.appendChild(menu.asElement());
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName, OnMenuSelectedHandler selectionHandler) {
        MenuItem menuItem = menu.addMenuItem(title, Icon.create(iconName));
        menuItem.clickableElement().addEventListener("click", e-> selectionHandler.onMenuSelected());
        return new SubMenu(menuItem);
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName) {
        MenuItem menuItem = menu.addMenuItem(title, Icon.create(iconName));
        return new SubMenu(menuItem);
    }

    private class SubMenu implements CanAddMenuItem{

        private final MenuItem menuItem;

        private SubMenu(MenuItem menuItem) {
            this.menuItem = menuItem;
        }

        @Override
        public CanAddMenuItem addMenuItem(String title) {
            MenuItem item=menuItem.addMenuItem(title);
            return new SubMenu(item);
        }

        @Override
        public CanAddMenuItem addMenuItem(String title, OnMenuSelectedHandler selectionHandler) {
            MenuItem item=menuItem.addMenuItem(title);
            item.clickableElement().addEventListener("click", e->selectionHandler.onMenuSelected());
            return new SubMenu(item);
        }
    }
}