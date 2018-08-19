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
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

import static org.dominokit.domino.menu.shared.extension.MenuContext.CanAddMenuItem;
import static org.dominokit.domino.menu.shared.extension.MenuContext.OnMenuSelectedHandler;

@UiView(presentable = MenuPresenter.class)
public class MenuViewImpl implements MenuView {

    private Tree menu;
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
        menu = Tree.create("Demo menu");
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
            fixLeftPanel(layout);
            Notification.create("Switched to XLarge screen").show();
        });

        MediaQuery.addOnLargeListener(() -> {
            fixLeftPanel(layout);
            Notification.create("Switched to Large screen").show();
        });
        MediaQuery.addOnMediumListener(() -> {
            unfixLeftPanel(layout);
            Notification.create("Switched to Medium screen").show();
        });

        MediaQuery.addOnSmallListener(() -> {
            unfixLeftPanel(layout);
            Notification.create("Switched to Small screen").show();
        });

        MediaQuery.addOnXSmallListener(() -> {
            unfixLeftPanel(layout);
            Notification.create("Switched to XSmall screen").show();
        });


    }

    private void fixLeftPanel(IsLayout layout) {
        layout.fixLeftPanelPosition();
        Style.of(lockIcon).setDisplay("block");
        locked = true;
    }

    private void unfixLeftPanel(IsLayout layout) {
        layout.unfixLeftPanelPosition();
        layout.hideLeftPanel();
        Style.of(lockIcon).setDisplay("none");
        locked = false;
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName, OnMenuSelectedHandler selectionHandler) {
        TreeItem menuItem = TreeItem.create(title, Icon.create(iconName));
        menu.addTreeItem(menuItem);
        menuItem.getClickableElement().addEventListener("click", e -> selectionHandler.onMenuSelected());
        return new SubMenu(menuItem);
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName) {
        TreeItem menuItem = TreeItem.create(title, Icon.create(iconName));
        menu.addTreeItem(menuItem);
        return new SubMenu(menuItem);
    }

    private class SubMenu implements CanAddMenuItem {


        private final TreeItem menuItem;

        private SubMenu(TreeItem menuItem) {
            this.menuItem = menuItem;
        }

        @Override
        public CanAddMenuItem addMenuItem(String title) {
            TreeItem item = TreeItem.create(title);
            menuItem.addTreeItem(item);
            return new SubMenu(item);
        }

        @Override
        public CanAddMenuItem addMenuItem(String title, OnMenuSelectedHandler selectionHandler) {
            TreeItem item = TreeItem.create(title);
            menuItem.addTreeItem(item);
            item.getClickableElement().addEventListener("click", e -> selectionHandler.onMenuSelected());
            return new SubMenu(item);
        }

    }
}