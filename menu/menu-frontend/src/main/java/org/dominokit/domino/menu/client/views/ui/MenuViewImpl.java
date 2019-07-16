package org.dominokit.domino.menu.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.menu.client.presenters.MenuProxy;
import org.dominokit.domino.menu.client.views.MenuView;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.view.BaseElementView;

import static org.dominokit.domino.ui.style.Unit.px;
import static org.dominokit.domino.ui.style.Unit.vh;

@UiView(presentable = MenuProxy.class)
public class MenuViewImpl extends BaseElementView<HTMLDivElement> implements MenuView {

    private Tree<String> menu;
    private Icon lockIcon = Icons.ALL.lock_open()
            .style()
            .setMarginBottom("0px")
            .setMarginTop("0px")
            .setCursor("pointer")
            .add(Styles.pull_right)
            .get();
    private boolean locked = false;
    private Collapsible lockCollapsible = Collapsible.create(lockIcon).show();
    private MenuUiHandlers uiHandlers;

    @Override
    protected void init(HTMLDivElement root) {

        menu.getHeader().appendChild(lockIcon.asElement());

        menu.enableSearch()
                .autoExpandFound()
                .style()
                .setHeight(Calc.sub(vh.of(100), px.of(186))).get();

        lockIcon.addClickListener(evt -> {
            if (locked) {
                uiHandlers.onUnLocked();
                lockIcon.asElement().textContent = Icons.ALL.lock().getName();
                locked = false;
            } else {
                uiHandlers.onLocked();
                lockIcon.asElement().textContent = Icons.ALL.lock_open().getName();
                locked = true;
            }
        });

        addMenuItems();
        addMediaQueries();
    }

    private void addMenuItems() {
        menu
                .appendChild(TreeItem.create("Home", Icons.ALL.home())
                        .addClickListener(evt -> uiHandlers.onMenuItemSelected("home"))
                )
                .appendChild(TreeItem.create("Setup", Icons.ALL.build())
                        .addClickListener(evt -> uiHandlers.onMenuItemSelected("setup"))
                )
                .appendChild(TreeItem.create("Samples", Icons.ALL.pages())
                        .addClickListener(evt -> uiHandlers.onMenuItemSelected("samples"))
                )
                .appendChild(TreeItem.create("Layout", Icons.ALL.dashboard())
                        .appendChild(makeSubMenu("App layout", "layout/app-layout"))
                        .appendChild(makeSubMenu("Grid layout", "layout/grid-layout"))
                        .appendChild(makeSubMenu("Grids", "layout/grids"))
                        .appendChild(makeSubMenu("Split panel", "layout/split-panel"))
                        .appendChild(makeSubMenu("Flex layout", "layout/flex-layout"))
                )
                .appendChild(TreeItem.create("Components", Icons.ALL.widgets())
                        .appendChild(makeSubMenu("Alerts", "components/alerts"))
                        .appendChild(makeSubMenu("Badges", "components/badges"))
                        .appendChild(makeSubMenu("Breadcrumbs", "components/breadcrumbs"))
                        .appendChild(makeSubMenu("Buttons", "components/buttons"))
                        .appendChild(makeSubMenu("Cards", "components/cards"))
                        .appendChild(makeSubMenu("Carousel", "components/carousel"))
                        .appendChild(makeSubMenu("Chips", "components/chips"))
                        .appendChild(makeSubMenu("Collapse", "components/collapse"))
                        .appendChild(makeSubMenu("Dialogs", "components/dialogs"))
                        .appendChild(makeSubMenu("Info box", "components/infobox"))
                        .appendChild(makeSubMenu("Labels", "components/labels"))
                        .appendChild(makeSubMenu("Lists", "components/lists"))
                        .appendChild(makeSubMenu("Loaders", "components/loaders"))
                        .appendChild(makeSubMenu("Media objects", "components/media"))
                        .appendChild(makeSubMenu("Modals", "components/modals"))
                        .appendChild(makeSubMenu("Notifications", "components/notifications"))
                        .appendChild(makeSubMenu("Pagination", "components/pagination"))
                        .appendChild(makeSubMenu("Preloaders", "components/preloaders"))
                        .appendChild(makeSubMenu("Progress bars", "components/progress"))
                        .appendChild(makeSubMenu("Sliders", "components/sliders"))
                        .appendChild(makeSubMenu("Spin", "components/spin"))
                        .appendChild(makeSubMenu("Tabs", "components/tabs"))
                        .appendChild(makeSubMenu("Thumbnails", "components/thumbnails"))
                        .appendChild(makeSubMenu("Tooltip & Popover", "components/tooltips-popover"))
                        .appendChild(makeSubMenu("Tree", "components/tree"))
                        .appendChild(makeSubMenu("Waves", "components/waves"))
                )
                .appendChild(TreeItem.create("Forms", Icons.ALL.assignment())
                        .appendChild(makeSubMenu("Basic forms", "forms/basic-form-elements"))
                        .appendChild(makeSubMenu("Advanced forms", "forms/advanced-form-elements"))
                        .appendChild(makeSubMenu("Date picker", "forms/datepicker"))
                        .appendChild(makeSubMenu("Time picker", "forms/timepicker"))
                        .appendChild(makeSubMenu("Field decoration", "forms/fields-decoration"))
                        .appendChild(makeSubMenu("Input fields", "forms/input-fields"))
                        .appendChild(makeSubMenu("Steppers", "forms/steppers"))
                        .appendChild(makeSubMenu("Form sample", "forms/form-sample"))
                        .appendChild(makeSubMenu("Login samples", "forms/login-sample"))
                )
                .appendChild(TreeItem.create("Data table", Icons.ALL.view_list())
                        .addClickListener(evt -> uiHandlers.onMenuItemSelected("datatable"))
                )
                .appendChild(TreeItem.create("Icons", Icons.ALL.spa())
                        .addClickListener(evt -> uiHandlers.onMenuItemSelected("icons"))
                )
                .appendChild(TreeItem.create("MDI Icons", Icons.ALL.local_florist())
                        .addClickListener(evt -> uiHandlers.onMenuItemSelected("mdiicons"))
                )
                .appendChild(TreeItem.create("Typography", Icons.ALL.text_fields())
                        .addClickListener(evt -> uiHandlers.onMenuItemSelected("typography"))
                )
                .appendChild(TreeItem.create("Helper classes", Icons.ALL.layers())
                        .addClickListener(evt -> uiHandlers.onMenuItemSelected("helpers"))
                )
                .appendChild(TreeItem.create("Colors", Icons.ALL.color_lens())
                        .addClickListener(evt -> uiHandlers.onMenuItemSelected("colors"))
                )
                .appendChild(TreeItem.create("Animations", Icons.ALL.movie())
                        .addClickListener(evt -> uiHandlers.onMenuItemSelected("animations"))
                );
    }

    private TreeItem<String> makeSubMenu(String title, String token) {
        return TreeItem.create(title)
                .setActiveIcon(Icons.ALL.keyboard_arrow_right())
                .addClickListener(evt -> uiHandlers.onMenuItemSelected(token));
    }

    @Override
    public HTMLDivElement createRoot() {
        menu = Tree.create("Demo menu");
        return menu.asElement();
    }

    @Override
    public void setUiHandlers(MenuUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }

    private void addMediaQueries() {
        MediaQuery.addOnXLargeListener(() -> {
            uiHandlers.onXLargeMedia();
            fix();
            Notification.create("Switched to XLarge screen")
                    .setPosition(Notification.TOP_CENTER)
                    .show();
        });

        MediaQuery.addOnLargeListener(() -> {
            uiHandlers.onLargeMedia();
            fix();
            Notification.create("Switched to Large screen")
                    .setPosition(Notification.TOP_CENTER)
                    .show();
        });
        MediaQuery.addOnMediumListener(() -> {
            uiHandlers.onMediumMedia();
            unfix();
            Notification.create("Switched to Medium screen")
                    .setPosition(Notification.TOP_CENTER)
                    .show();
        });

        MediaQuery.addOnSmallListener(() -> {
            uiHandlers.onSmallMedia();
            unfix();
            Notification.create("Switched to Small screen")
                    .setPosition(Notification.TOP_CENTER)
                    .show();
        });

        MediaQuery.addOnXSmallListener(() -> {
            uiHandlers.onXSmallMedia();
            unfix();
            Notification.create("Switched to XSmall screen")
                    .setPosition(Notification.TOP_CENTER)
                    .show();
        });
    }

    private void fix() {
        lockCollapsible.show();
        locked = true;
    }

    private void unfix() {
        lockCollapsible.hide();
        locked = false;
    }
}