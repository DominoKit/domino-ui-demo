package org.dominokit.domino.menu.client.views.ui;

import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.menu.client.presenters.MenuPresenter;
import org.dominokit.domino.menu.client.views.MenuView;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;

import static org.dominokit.domino.menu.shared.extension.MenuContext.CanAddMenuItem;
import static org.dominokit.domino.menu.shared.extension.MenuContext.OnMenuSelectedHandler;

@UiView(presentable = MenuPresenter.class)
public class MenuViewImpl implements MenuView {

    private Menu menu;
    private Icon lockIcon = Icons.ALL.lock_open().setColor(Color.GREY);
    private boolean locked = false;

    public MenuViewImpl() {
        lockIcon.asElement().style.marginBottom = CSSProperties.MarginBottomUnionType.of(0);
        lockIcon.asElement().style.marginTop = CSSProperties.MarginTopUnionType.of(0);
        lockIcon.asElement().classList.add("pull-right");
        lockIcon.asElement().style.cursor = "pointer";
    }

    @Override
    public void setTitle(String title) {
        menu.getTitle().textContent = title;
    }

    @Override
    public void init(IsLayout layout) {
        menu = Menu.create("Demo menu");
        menu.getRoot().style.height = CSSProperties.HeightUnionType.of("calc(100vh - 250px)");
        HTMLElement leftPanel = Js.cast(layout.getLeftPanel().get());
        leftPanel.appendChild(menu.asElement());
        menu.getHeader().appendChild(lockIcon.asElement());
        menu.asElement().style.height = CSSProperties.HeightUnionType.of("calc(100vh - 237px)");
        lockIcon.asElement().addEventListener("click", evt -> {

            if (locked) {
                layout.unfixLeftPanelPosition();
                lockIcon.asElement().textContent = Icons.ALL.lock().getName();
                layout.hideLeftPanel();
                locked = false;
            } else {
                layout.fixLeftPanelPosition();
                lockIcon.asElement().textContent = Icons.ALL.lock_open().getName();
                locked = true;
            }
        });

        MediaQuery.addOnXLargeListener(() -> {
            layout.fixLeftPanelPosition();
            Style.of(lockIcon).setDisplay("block");
        });

        MediaQuery.addOnLargeListener(() -> {
            layout.fixLeftPanelPosition();
            Style.of(lockIcon).setDisplay("block");
        });
        MediaQuery.addOnMediumListener(() -> {
            layout.unfixLeftPanelPosition();
            layout.hideLeftPanel();
            Style.of(lockIcon).setDisplay("none");
        });
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName, OnMenuSelectedHandler selectionHandler) {
        MenuItem menuItem = menu.addMenuItem(title, Icon.create(iconName));
        menuItem.getClickableElement().addEventListener("click", e -> selectionHandler.onMenuSelected());
        return new SubMenu(menuItem);
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName) {
        MenuItem menuItem = menu.addMenuItem(title, Icon.create(iconName));
        return new SubMenu(menuItem);
    }

    private class SubMenu implements CanAddMenuItem {


        private final MenuItem menuItem;

        private SubMenu(MenuItem menuItem) {
            this.menuItem = menuItem;
        }

        @Override
        public CanAddMenuItem addMenuItem(String title) {
            MenuItem item = menuItem.addMenuItem(title);
            return new SubMenu(item);
        }

        @Override
        public CanAddMenuItem addMenuItem(String title, OnMenuSelectedHandler selectionHandler) {
            MenuItem item = menuItem.addMenuItem(title);
            item.getClickableElement().addEventListener("click", e -> selectionHandler.onMenuSelected());
            return new SubMenu(item);
        }

    }
}