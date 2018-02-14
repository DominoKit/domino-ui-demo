package com.progressoft.brix.domino.menu.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import com.progressoft.brix.domino.menu.client.presenters.MenuPresenter;
import com.progressoft.brix.domino.menu.client.views.MenuView;
import com.progressoft.brix.domino.ui.icons.Icon;
import com.progressoft.brix.domino.ui.icons.Icons;
import com.progressoft.brix.domino.ui.menu.Menu;
import com.progressoft.brix.domino.ui.menu.MenuItem;
import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.CSSProperties;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

import static com.progressoft.brix.domino.menu.shared.extension.MenuContext.*;

@UiView(presentable = MenuPresenter.class)
public class DefaultMenuView implements MenuView{

    private Menu menu;
    private Icon lockIcon=Icons.ALL.lock_open().setColor(Color.GREY);
    private boolean locked=true;

    public DefaultMenuView() {
        lockIcon.asElement().style.marginBottom= CSSProperties.MarginBottomUnionType.of(0);
        lockIcon.asElement().style.marginTop= CSSProperties.MarginTopUnionType.of(0);
        lockIcon.asElement().classList.add("pull-right");
        lockIcon.asElement().style.cursor="pointer";
    }

    @Override
    public void init(IsLayout layout) {
        menu = Menu.create("Demo menu");
        HTMLElement leftPanel= Js.cast(layout.getLeftPanel().get());
        leftPanel.appendChild(menu.asElement());
        menu.getHeader().appendChild(lockIcon.asElement());
        lockIcon.asElement().addEventListener("click", evt -> {

            if(locked){
                layout.unfixLeftPanelPosition();
                lockIcon.asElement().textContent=Icons.ALL.lock().getName();
                layout.hideLeftPanel();
                locked=false;
            }else{
                layout.fixLeftPanelPosition();
                lockIcon.asElement().textContent=Icons.ALL.lock_open().getName();
                locked=true;
            }
        });

        layout.fixLeftPanelPosition();
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName, OnMenuSelectedHandler selectionHandler) {
        MenuItem menuItem = menu.addMenuItem(title, Icon.create(iconName));
        menuItem.getClickableElement().addEventListener("click", e-> selectionHandler.onMenuSelected());
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
            item.getClickableElement().addEventListener("click", e->selectionHandler.onMenuSelected());
            return new SubMenu(item);
        }
    }
}