package org.dominokit.domino.demomenu.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.demomenu.client.views.DemoMenuView;
import org.dominokit.domino.demomenu.client.presenters.DemoMenuProxy;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.view.BaseElementView;

import static org.dominokit.domino.ui.style.Unit.px;
import static org.dominokit.domino.ui.style.Unit.vh;

@UiView(presentable = DemoMenuProxy.class)
public class DemoMenuViewImpl extends BaseElementView<HTMLDivElement> implements DemoMenuView {

    private Tree<String> menu;
    private MdiIcon lockIcon = Icons.ALL.lock_open_mdi()
            .style()
            .setMarginBottom("0px")
            .setMarginTop("0px")
            .setCursor("pointer")
            .addCss(Styles.pull_right)
            .get();
    private boolean locked = false;
    private Collapsible lockCollapsible = Collapsible.create(lockIcon).show();
    private MenuUiHandlers uiHandlers;

    @Override
    protected HTMLDivElement init() {
        menu = Tree.create("Demo menu");

        menu.getHeader().appendChild(lockIcon.element());

        menu.enableSearch()
                .autoExpandFound()
                .style()
                .setHeight(Calc.sub(vh.of(100), px.of(186))).get();

        lockIcon.addClickListener(evt -> {
            if (locked) {
                uiHandlers.onUnLocked();
                lockIcon.element().textContent = Icons.ALL.lock_mdi().getName();
                locked = false;
            } else {
                uiHandlers.onLocked();
                lockIcon.element().textContent = Icons.ALL.lock_open_mdi().getName();
                locked = true;
            }
        });

        addMenuItems();
        addMediaQueries();

        return menu.element();
    }

    private void addMenuItems() {
        menu
                .appendChild(TreeItem.create("Home", Icons.ALL.home_mdi())
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "home"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("home");
                        })
                )
                .appendChild(TreeItem.create("Setup", Icons.ALL.wrench_mdi())
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "setup"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("setup");
                        })
                )
                .appendChild(TreeItem.create("Samples", Icons.ALL.apps_mdi())
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "samples"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("samples");
                        })
                )
                .appendChild(TreeItem.create("Layout", Icons.ALL.view_dashboard_mdi())
                        .appendChild(makeSubMenu("App layout", "layout/app-layout"))
                        .appendChild(makeSubMenu("Grid layout", "layout/grid-layout"))
                        .appendChild(makeSubMenu("Grids", "layout/grids"))
                        .appendChild(makeSubMenu("Split panel", "layout/split-panel"))
                        .appendChild(makeSubMenu("Flex layout", "layout/flex-layout"))
                )
                .appendChild(TreeItem.create("Components", Icons.ALL.widgets_mdi())
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
                        .appendChild(makeSubMenu("Menu", "components/menu"))
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
                .appendChild(TreeItem.create("Forms", Icons.ALL.textbox_mdi())
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
                .appendChild(TreeItem.create("Data table", Icons.ALL.view_list_mdi())
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "datatable"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("datatable");
                        })
                )
                .appendChild(TreeItem.create("Icons", Icons.ALL.spa_mdi())
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "icons"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("icons");
                        })
                )
                .appendChild(TreeItem.create("MDI Icons", Icons.ALL.flower_mdi())
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "mdiicons"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("mdiicons");
                        })
                )
                .appendChild(TreeItem.create("Typography", Icons.ALL.format_font_mdi())
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "typography"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("typography");
                        })
                )
                .appendChild(TreeItem.create("Helper classes", Icons.ALL.layers_mdi())
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "helpers"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("helpers");
                        })
                )
                .appendChild(TreeItem.create("Colors", Icons.ALL.select_color_mdi())
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "colors"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("colors");
                        })
                )
                .appendChild(TreeItem.create("Animations", Icons.ALL.animation_mdi())
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "animations"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("animations");
                        })
                );
    }

    private TreeItem<String> makeSubMenu(String title, String token) {
        return TreeItem.create(title)
                .setActiveIcon(Icons.ALL.arrow_up_mdi())
                .apply(self -> self.getClickableElement().setAttribute("href", token))
                .addClickListener(evt -> {
                    evt.preventDefault();
                    uiHandlers.onMenuItemSelected(token);
                });
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