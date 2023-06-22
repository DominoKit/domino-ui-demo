package org.dominokit.domino.demomenu.client.views.ui;

import elemental2.core.Global;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.URL;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.demomenu.client.presenters.DemoMenuProxy;
import org.dominokit.domino.demomenu.client.views.DemoMenuView;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.icons.lib.MdiTags;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.SpacingCss;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.ui.tree.TreeItemIcon;
import org.dominokit.domino.ui.utils.ElementHandler;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.view.BaseElementView;

@UiView(presentable = DemoMenuProxy.class)
public class DemoMenuViewImpl extends BaseElementView<HTMLDivElement> implements DemoMenuView {

    private Tree<String> menu;
    private boolean locked = false;
    private boolean spanUp = false;
    private boolean spanDown = true;
    private MenuUiHandlers uiHandlers;
    private ToggleMdiIcon lockIcon;

    private static ElementHandler<TreeItem<String>> addToggleIcon() {
        return self -> {
            ToggleMdiIcon icon = ToggleMdiIcon.create(Icons.plus(), Icons.minus());
            self.appendChild(PostfixAddOn.of(icon));
            self.addBeforeCollapseListener(icon::toggle);
            self.addBeforeExpandListener(icon::toggle);
        };
    }

    @Override
    protected HTMLDivElement init() {
        lockIcon = ToggleMdiIcon.create(Icons.lock_open()
                        .addCss(SpacingCss.dui_font_size_4)
                        .clickable(),
                Icons.lock()
                        .addCss(SpacingCss.dui_font_size_4)
                        .clickable());

        menu = Tree.<String>create("Demo menu")
                .addCss(dui_order_20)
                .withHeader((self, header) -> {
                    header
                            .addCss(dui_h_12)
                            .appendChild(PostfixAddOn.of(lockIcon
                                            .apply(icon -> {
                                                icon.addClickListener(evt -> {
                                                    if (locked) {
                                                        uiHandlers.onUnLocked();
                                                        locked = false;
                                                    } else {
                                                        uiHandlers.onLocked();
                                                        locked = true;
                                                    }
                                                    icon.toggle();
                                                });
                                            })
                                    )
                            )
                            .appendChild(PostfixAddOn.of(ToggleMdiIcon.create(Icons.arrow_collapse_up()
                                                            .addCss(SpacingCss.dui_font_size_4)
                                                            .clickable(),
                                                    Icons.arrow_collapse_down()
                                                            .addCss(SpacingCss.dui_font_size_4)
                                                            .clickable())
                                            .clickable()
                                            .apply(icon -> {
                                                icon.addClickListener(evt -> {
                                                    uiHandlers.onSpanUp(!spanUp);
                                                    spanUp = !spanUp;
                                                    icon.toggle();
                                                });
                                            })
                                    )
                            )
                            .appendChild(PostfixAddOn.of(ToggleMdiIcon.create(Icons.arrow_collapse_up()
                                                            .addCss(SpacingCss.dui_font_size_4)
                                                            .clickable(),
                                                    Icons.arrow_collapse_down()
                                                            .addCss(SpacingCss.dui_font_size_4)
                                                            .clickable())
                                            .clickable()
                                            .apply(icon -> {
                                                icon.addClickListener(evt -> {
                                                    uiHandlers.onSpanDown(!spanDown);
                                                    spanDown = !spanDown;
                                                    icon.toggle();
                                                });
                                            })
                                    )
                            );
                })
                .setSearchable(true)
                .setAutoExpandFound(true);

        addMenuItems();
        addMediaQueries();

        return menu.element();
    }

    private void addMenuItems() {
        menu
                .appendChild(TreeItem.create(Icons.home(), "Home")
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "home"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("home");
                        })
                )
                .appendChild(TreeItem.create(Icons.wrench(), "Setup")
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "setup"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("setup");
                        })
                )
                .appendChild(TreeItem.create(Icons.apps(), "Samples")
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "samples"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("samples");
                        })
                )
                .appendChild(TreeItem.create(Icons.view_dashboard(), "Layout")
                        .apply(addToggleIcon())
                        .appendChild(makeSubMenu("App layout", "layout/app-layout"))
                        .appendChild(makeSubMenu("Grid layout", "layout/grid-layout"))
                        .appendChild(makeSubMenu("Grids", "layout/grids"))
                        .appendChild(makeSubMenu("Split panel", "layout/split-panel"))
                        .appendChild(makeSubMenu("Flex layout", "layout/flex-layout"))
                )
                .appendChild(TreeItem.create(Icons.widgets(), "Components")
                        .apply(addToggleIcon())
                        .appendChild(makeSubMenu("Alerts", "components/alerts"))
                        .appendChild(makeSubMenu("Badges", "components/badges"))
                        .appendChild(makeSubMenu("Breadcrumbs", "components/breadcrumbs"))
                        .appendChild(makeSubMenu("Buttons", "components/buttons"))
                        .appendChild(makeSubMenu("Cards", "components/cards"))
                        .appendChild(makeSubMenu("Carousel", "components/carousel"))
                        .appendChild(makeSubMenu("Chips", "components/chips"))
                        .appendChild(makeSubMenu("Collapse", "components/collapse"))
                        .appendChild(makeSubMenu("Dialogs", "components/dialogs"))
                        .appendChild(makeSubMenu("Drag and drop", "components/dnd"))
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
                .appendChild(TreeItem.create(Icons.form_textbox(), "Forms")
                        .apply(addToggleIcon())
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
                .appendChild(TreeItem.create(Icons.view_list(), "Data table")
                        .apply(addToggleIcon())
                        .appendChild(makeSubMenu("Basic table", "datatable/basic-table"))
                        .appendChild(makeSubMenu("Column resize plugin", "datatable/column-resize-plugin"))
                        .appendChild(makeSubMenu("Column pin plugin", "datatable/column-pin-plugin"))
                        .appendChild(makeSubMenu("Column groups", "datatable/column-groups"))
                        .appendChild(makeSubMenu("Drag-Drop plugin", "datatable/drag-drop-plugin"))
                        .appendChild(makeSubMenu("Editable table", "datatable/editable-table"))
                        .appendChild(makeSubMenu("Empty state", "datatable/empty-state"))
                        .appendChild(makeSubMenu("Fixed table", "datatable/fixed-table"))
                        .appendChild(makeSubMenu("Grouping plugin", "datatable/grouping-plugin"))
                        .appendChild(makeSubMenu("Header bar plugin", "datatable/header-bar-plugin"))
                        .appendChild(makeSubMenu("Marker plugin", "datatable/marker-plugin"))
                        .appendChild(makeSubMenu("Selection plugin", "datatable/selection-plugin"))
                        .appendChild(makeSubMenu("Pagination plugins", "datatable/pagination-plugin"))
                        .appendChild(makeSubMenu("Record details plugin", "datatable/record-details-plugin"))
                        .appendChild(makeSubMenu("Row menu plugin", "datatable/row-menu-plugin"))
                        .appendChild(makeSubMenu("Sort and search plugins", "datatable/sort-search-plugin"))
                        .appendChild(makeSubMenu("Scroll loading", "datatable/scroll-loading"))
                        .appendChild(makeSubMenu("Summary plugin", "datatable/summary-plugin"))
                        .appendChild(makeSubMenu("Top panel plugin", "datatable/top-panel-plugin"))
                        .appendChild(makeSubMenu("Tree plugin - eager", "datatable/eager-tree-plugin"))
                        .appendChild(makeSubMenu("Tree plugin - Lazy", "datatable/lazy-tree-plugin"))
                        .appendChild(makeSubMenu("Plugins mix", "datatable/mix-plugins"))
                )
                .appendChild(TreeItem.create(Icons.flower(), "MDI Icons")
                        .apply(addToggleIcon())
                        .apply(self -> {
                            self
                                    .appendChild(TreeItem.create("All Icons")
                                            .addClickListener(evt -> {
                                                evt.preventDefault();
                                                uiHandlers.onMenuItemSelected("mdiicons/all");
                                            })
                                    )
                                    .appendChild(TreeItem.create("Untagged")
                                            .addClickListener(evt -> {
                                                evt.preventDefault();
                                                uiHandlers.onMenuItemSelected("mdiicons/Untagged");
                                            })
                                    );
                            MdiTags.TAGS.forEach(tag -> {
                                self
                                        .appendChild(TreeItem.create(tag)
                                                .addClickListener(evt -> {
                                                    evt.preventDefault();
                                                    uiHandlers.onMenuItemSelected("mdiicons/" + Global.encodeURI(tag.replace("/", "--")));
                                                })
                                        );
                            });

                        })
                )
                .appendChild(TreeItem.create(Icons.format_font(), "Typography")
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "typography"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("typography");
                        })
                )
                .appendChild(TreeItem.create(Icons.layers(), "Helper classes")
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "helpers"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("helpers");
                        })
                )
                .appendChild(TreeItem.create(Icons.select_color(), "Colors")
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "colors"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("colors");
                        })
                )
                .appendChild(TreeItem.create(Icons.animation(), "Animations")
                        .apply(self -> self.getClickableElement()
                                .setAttribute("href", "animations"))
                        .addClickListener(evt -> {
                            evt.preventDefault();
                            uiHandlers.onMenuItemSelected("animations");
                        })
                );
    }

    private void addMediaQueries() {
        MediaQuery.addOnXLargeListener(() -> {
            uiHandlers.onXLargeMedia();
            fix();
            Notification.create("Switched to XLarge screen")
                    .setPosition(Notification.Position.TOP_MIDDLE)
                    .show();
        });

        MediaQuery.addOnLargeListener(() -> {
            uiHandlers.onLargeMedia();
            fix();
            Notification.create("Switched to Large screen")
                    .setPosition(Notification.Position.TOP_MIDDLE)
                    .show();
        });
        MediaQuery.addOnMediumListener(() -> {
            uiHandlers.onMediumMedia();
            unfix();
            Notification.create("Switched to Medium screen")
                    .setPosition(Notification.Position.TOP_MIDDLE)
                    .show();
        });

        MediaQuery.addOnSmallListener(() -> {
            uiHandlers.onSmallMedia();
            unfix();
            Notification.create("Switched to Small screen")
                    .setPosition(Notification.Position.TOP_MIDDLE)
                    .show();
        });

        MediaQuery.addOnXSmallListener(() -> {
            uiHandlers.onXSmallMedia();
            unfix();
            Notification.create("Switched to XSmall screen")
                    .setPosition(Notification.Position.TOP_MIDDLE)
                    .show();
        });
    }

    private TreeItem<String> makeSubMenu(String title, String token) {
        return TreeItem.create(title)
                .setIcon(TreeItemIcon.of(Icons.circle_small(), Icons.circle_small(), Icons.circle_small(), Icons.chevron_right()))
                .apply(self -> self.getClickableElement().setAttribute("href", token))
                .addClickListener(evt -> {
                    evt.preventDefault();
                    uiHandlers.onMenuItemSelected(token);
                });
    }

    private void fix() {
        lockIcon.show();
        locked = true;
    }

    private void unfix() {
        lockIcon.hide();
        locked = false;
    }

    @Override
    public void setUiHandlers(MenuUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }
}