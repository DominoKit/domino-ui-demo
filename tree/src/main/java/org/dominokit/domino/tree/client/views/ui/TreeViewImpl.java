package org.dominokit.domino.tree.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.tree.client.presenters.TreeProxy;
import org.dominokit.domino.tree.client.views.Countries;
import org.dominokit.domino.tree.client.views.Country;
import org.dominokit.domino.tree.client.views.TreeView;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.icons.StateChangeMdiIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.tree.ToggleTarget;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.ui.tree.TreeItemIcon;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;

import java.util.List;
import java.util.function.Supplier;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.tree.client.views.Countries.COUNTRIES;

@UiView(presentable = TreeProxy.class)
@SampleClass
public class TreeViewImpl extends BaseDemoView<HTMLDivElement> implements TreeView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();
        element.appendChild(LinkToSourceCode.createLink("tree", this.getClass()));
        element.appendChild(BlockHeader.create("Tree"));

        simpleTree();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.simpleTree()));

        nestedTree();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.nestedTree()));

        activeAndExpandIcons();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.activeAndExpandIcons()));

        return element.element();
    }

    @SampleMethod
    private void simpleTree() {
        Tree<String> hardwareTree = Tree.<String>create("HARDWARE")
                .addSelectionListener((treeItem, selection) -> DomGlobal.console.info(treeItem.get().getValue()))
                .appendChild(TreeItem.create(Icons.laptop(), "Computer")
                        .addClickListener(evt -> Notification.create("Computer").show()))
                .appendChild(TreeItem.create(Icons.headset(), "Headset")
                        .addClickListener(evt -> Notification.create("Headset").show()))
                .appendChild(TreeItem.create(Icons.keyboard(), "Keyboard")
                        .addClickListener(evt -> Notification.create("Keyboard").show()))
                .appendChild(TreeItem.create(Icons.mouse(), "Mouse")
                        .addClickListener(evt -> Notification.create("Mouse").show()))
                .addSeparator()
                .appendChild(TreeItem.create(Icons.laptop(), "Laptop")
                        .addClickListener(evt -> Notification.create("Laptop").show()))
                .appendChild(TreeItem.create(Icons.cellphone(), "Smart phone")
                        .addClickListener(evt -> Notification.create("Smart phone").show()))
                .appendChild(TreeItem.create(Icons.tablet(), "Tablet")
                        .addClickListener(evt -> Notification.create("Tablet").show()))
                .appendChild(TreeItem.create(Icons.speaker(), "Speaker")
                        .addClickListener(evt -> Notification.create("Speaker").show()));

        Tree<String> filesTree = Tree.<String>create("FILES")
                .setToggleTarget(ToggleTarget.ICON)
                .appendChild(TreeItem.create(Icons.folder(), "Folder")
                        .addClickListener(evt -> Notification.create("Folder").show()))
                .appendChild(TreeItem.create(Icons.folder_open(), "Folder open")
                        .addClickListener(evt -> Notification.create("Folder open").show()))
                .appendChild(TreeItem.create(Icons.file_upload(), "Upload")
                        .addClickListener(evt -> Notification.create("Upload").show()))
                .appendChild(TreeItem.create(Icons.file_download(), "Download")
                        .addClickListener(evt -> Notification.create("Download").show()))
                .appendChild(TreeItem.create(Icons.folder_plus(), "New folder")
                        .addClickListener(evt -> Notification.create("New folder").show()))
                .appendChild(TreeItem.create(Icons.folder_account(), "Shared")
                        .addClickListener(evt -> Notification.create("Shared").show()))
                .appendChild(TreeItem.create(Icons.attachment(), "Attachments")
                        .addClickListener(evt -> Notification.create("Attachments").show()))
                .appendChild(TreeItem.create(Icons.cloud(), "Cloud")
                        .addClickListener(evt -> Notification.create("Cloud").show()));

        element.appendChild(Card.create("SIMPLE MENU")
                .appendChild(Row.create()
                        .appendChild(Column.span6().appendChild(hardwareTree))
                        .appendChild(Column.span6().appendChild(filesTree))
                ));


    }

    @SampleMethod
    private void nestedTree() {
        Tree<String> hardwareTree = Tree.<String>create("HARDWARE")
                .appendChild(TreeItem.create(Icons.desktop_classic(), "Computer")
                        .addClickListener(evt -> Notification.create("Computer").show())
                        .appendChild(TreeItem.create(Icons.headset(), "Headset")
                                .addClickListener(evt -> Notification.create("Headset").show()))
                        .appendChild(TreeItem.create(Icons.keyboard(), "Keyboard")
                                .addClickListener(evt -> Notification.create("Keyboard").show()))
                        .appendChild(TreeItem.create(Icons.mouse(), "Mouse")
                                .addClickListener(evt -> Notification.create("Mouse").show())))

                .appendChild(TreeItem.create(Icons.laptop(), "Laptop")
                        .addClickListener(evt -> Notification.create("Laptop").show())

                        .appendChild(TreeItem.create(Icons.laptop(), "Chromebook")
                                .addClickListener(evt -> Notification.create("Chromebook").show()))
                        .appendChild(TreeItem.create(Icons.laptop_account(), "MacBook")
                                .addClickListener(evt -> Notification.create("MacBook").show())))

                .appendChild(TreeItem.create(Icons.cellphone(), "Smart phone")
                        .addClickListener(evt -> Notification.create("Smart phone").show())

                        .appendChild(TreeItem.create(Icons.tablet(), "Tablet")
                                .addClickListener(evt -> Notification.create("Tablet").show()))
                        .appendChild(TreeItem.create(Icons.cellphone(), "Android")
                                .addClickListener(evt -> Notification.create("Android").show()))
                        .appendChild(TreeItem.create(Icons.cellphone_cog(), "iPhone")
                                .addClickListener(evt -> Notification.create("iPhone").show())));


        Tree<String> hardwareMenu2 = Tree.<String>create("FILES")
                .setToggleTarget(ToggleTarget.ICON)
                .setAutoCollapse(false)
                .addSelectionListener((treeItem, selection) -> DomGlobal.console.info(treeItem.get().getValue()))
                .appendChild(TreeItem.create(Icons.folder(), "Folder")
                        .appendChild(TreeItem.create(Icons.folder_star(), "My files")
                                .appendChild(TreeItem.create(Icons.note(), "File 1")
                                        .addClickListener(evt -> Notification.create("File 1").show()))
                                .appendChild(TreeItem.create(Icons.note(), "File 2")
                                        .addClickListener(evt -> Notification.create("File 2").show()))
                                .appendChild((TreeItem.create(Icons.note(), "File 3"))
                                        .addClickListener(evt -> Notification.create("File 3").show()))
                                .appendChild(TreeItem.create(Icons.note(), "File 4")
                                        .addClickListener(evt -> Notification.create("File 4").show()))
                        )
                        .appendChild(TreeItem.create(Icons.file_upload(), "Upload"))
                        .appendChild(TreeItem.create(Icons.file_download(), "Download"))
                        .appendChild(TreeItem.create(Icons.folder_plus(), "New folder"))
                        .appendChild(TreeItem.create(Icons.folder_account(), "Shared"))
                        .appendChild(TreeItem.create(Icons.attachment(), "Attachments"))
                ).appendChild(TreeItem.create(Icons.cloud(), "Cloud")
                        .appendChild(TreeItem.create(Icons.cloud_upload(), "Upload"))
                        .appendChild(TreeItem.create(Icons.cloud_download(), "Download"))
                        .appendChild(TreeItem.create(Icons.cloud_off_outline(), "Offline"))
                        .appendChild(TreeItem.create(Icons.cloud_question(), "Queue"))
                );


        element.appendChild(Card.create("SIMPLE NESTED MENU")
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Auto collapse"))
                                .appendChild(hardwareTree)
                        )
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Auto collapse OFF"))
                                .appendChild(hardwareMenu2)
                        )
                ));
    }

    @SampleMethod
    private void activeAndExpandIcons() {

        List<Country> countries = Countries.MAPPER.read(COUNTRIES).getCountries();

        Tree<String> citiesTree = Tree.<String>create("CITIES")
                .setFilter((treeItem, searchToken) -> {
                            boolean result = treeItem.getTitle().toLowerCase().contains(searchToken.toLowerCase());
                            if (treeItem.getParent().isPresent()) {
                                result = result || treeItem.getParent()
                                        .map(parent -> nonNull(parent.getValue()) && parent.getValue().toLowerCase().contains(searchToken.toLowerCase()))
                                        .orElse(false);
                            }
                            return result;
                        }
                )
                .setAutoCollapse(false)
                .setFoldable(true)
                .setSearchable(true)
                .setAutoExpandFound(true)
                .apply(tree -> {
                    countries.forEach(country -> {
                        tree
                                .appendChild(TreeItem.<String>create(Icons.map(), country.getName())
                                        .apply(countryItem -> {
                                                    countryItem
                                                            .appendChild(PostfixAddOn.of(Badge.create(String.valueOf(country.getCities().size()))
                                                                            .addCss(dui_bg_accent_d_2, dui_rounded_full)
                                                                    )
                                                            )
                                                            .appendChild(PostfixAddOn.of(ToggleMdiIcon.create(Icons.plus(), Icons.minus())
                                                                    .apply(icon -> {
                                                                        countryItem
                                                                                .addBeforeCollapseListener(icon::toggle)
                                                                                .addBeforeExpandListener(icon::toggle);
                                                                    })
                                                            ));

                                                    country.getCities().forEach(city -> countryItem.appendChild(TreeItem.create(Icons.city(), city)));
                                                }
                                        )
                                );
                    })
                    ;
                });


        Tree<String> foldersExpand = Tree.<String>create("FILES")
                .setAutoCollapse(false)
                .setFoldable(true)
                .setSearchable(true)
                .setTreeItemIconSupplier((item) -> TreeItemIcon.of(Icons.folder(), Icons.folder_open(), Icons.file(), Icons.file_check_outline()))
                .appendChild(TreeItem.create("Folder 1")
                        .appendChild(TreeItem.create("Folder 1-1")
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                        ).appendChild(TreeItem.create("Folder 1-2")
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                        )
                ).appendChild(TreeItem.create("Folder 2")
                        .appendChild(TreeItem.create("Folder 2-1")
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                        )
                        .appendChild(TreeItem.create("Folder 2-2")
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                        )
                )
                .appendChild(TreeItem.create("Folder 3")
                        .appendChild(TreeItem.create("Folder 3-1")
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                                .expand()
                        ).appendChild(TreeItem.create("Folder 3-2")
                                .expand()
                                .appendChild(TreeItem.create("File 1"))
                                .appendChild(TreeItem.create("File 2"))
                                .appendChild(TreeItem.create("File 3"))
                                .appendChild(TreeItem.create("File 4"))
                                .expand()
                        ).expand()
                );

        element.appendChild(Card.create("ACTIVE/EXPAND ICONS, SEARCH & FOLDING")
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Active icon"))
                                .appendChild(citiesTree))
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Expand icon"))
                                .appendChild(foldersExpand))
                ));


    }
}