package org.dominokit.domino.checktree.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.checktree.client.presenters.CheckTreeProxy;
import org.dominokit.domino.checktree.client.views.Countries;
import org.dominokit.domino.checktree.client.views.Country;
import org.dominokit.domino.checktree.client.views.CheckTreeView;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.tree.ToggleTarget;
import org.dominokit.domino.ui.tree.TreeItemIcon;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.pro.domino.ui.tree.CheckTree;
import org.dominokit.pro.domino.ui.tree.CheckTreeItem;

import java.util.List;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.checktree.client.views.Countries.COUNTRIES;
import static org.dominokit.domino.ui.utils.Domino.*;

@UiView(presentable = CheckTreeProxy.class)
@SampleClass
public class CheckTreeViewImpl extends BaseDemoView<HTMLDivElement> implements CheckTreeView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();
        element.appendChild(LinkToSourceCode.createLink("checktree", this.getClass()));
        element.appendChild(BlockHeader.create("Check Tree"));

        checkTree();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.checkTree()));

        nestedCheckTree();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.nestedCheckTree()));

        activeAndExpandIcons();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.activeAndExpandIcons()));

        return element.element();
    }

    @SampleMethod
    private void checkTree() {
        CheckTree<String> hardwareTree = CheckTree.<String>create("HARDWARE")
                .addSelectionListener((treeItem, selection) -> DomGlobal.console.info(treeItem.get().getValue()))
                .appendChild(CheckTreeItem.create(Icons.laptop(), "Computer")
                        .addClickListener(evt -> Notification.create("Computer").show()))
                .appendChild(CheckTreeItem.create(Icons.headset(), "Headset")
                        .addClickListener(evt -> Notification.create("Headset").show()))
                .appendChild(CheckTreeItem.create(Icons.keyboard(), "Keyboard")
                        .addClickListener(evt -> Notification.create("Keyboard").show()))
                .appendChild(CheckTreeItem.create(Icons.mouse(), "Mouse")
                        .addClickListener(evt -> Notification.create("Mouse").show()))
                .addSeparator()
                .appendChild(CheckTreeItem.create(Icons.laptop(), "Laptop")
                        .addClickListener(evt -> Notification.create("Laptop").show()))
                .appendChild(CheckTreeItem.create(Icons.cellphone(), "Smart phone")
                        .addClickListener(evt -> Notification.create("Smart phone").show()))
                .appendChild(CheckTreeItem.create(Icons.tablet(), "Tablet")
                        .addClickListener(evt -> Notification.create("Tablet").show()))
                .appendChild(CheckTreeItem.create(Icons.speaker(), "Speaker")
                        .addClickListener(evt -> Notification.create("Speaker").show()));

        CheckTree<String> filesTree = CheckTree.<String>create("FILES")
                .setToggleTarget(ToggleTarget.ICON)
                .appendChild(CheckTreeItem.create(Icons.folder(), "Folder")
                        .addClickListener(evt -> Notification.create("Folder").show()))
                .appendChild(CheckTreeItem.create(Icons.folder_open(), "Folder open")
                        .addClickListener(evt -> Notification.create("Folder open").show()))
                .appendChild(CheckTreeItem.create(Icons.file_upload(), "Upload")
                        .addClickListener(evt -> Notification.create("Upload").show()))
                .appendChild(CheckTreeItem.create(Icons.file_download(), "Download")
                        .addClickListener(evt -> Notification.create("Download").show()))
                .appendChild(CheckTreeItem.create(Icons.folder_plus(), "New folder")
                        .addClickListener(evt -> Notification.create("New folder").show()))
                .appendChild(CheckTreeItem.create(Icons.folder_account(), "Shared")
                        .addClickListener(evt -> Notification.create("Shared").show()))
                .appendChild(CheckTreeItem.create(Icons.attachment(), "Attachments")
                        .addClickListener(evt -> Notification.create("Attachments").show()))
                .appendChild(CheckTreeItem.create(Icons.cloud(), "Cloud")
                        .addClickListener(evt -> Notification.create("Cloud").show()));

        element.appendChild(Card.create("SIMPLE MENU")
                .appendChild(Row.create()
                        .appendChild(Column.span6().appendChild(hardwareTree))
                        .appendChild(Column.span6().appendChild(filesTree))
                ));


    }

    @SampleMethod
    private void nestedCheckTree() {
        CheckTree<String> hardwareTree = CheckTree.<String>create("HARDWARE")
                .addNodeActivationListener((parent, self) -> {
                    Notification.create(self.getValue()).show();
                })
                .appendChild(CheckTreeItem.create(Icons.desktop_classic(), "Computer")
                        .addSelectionChangeListener((source, selection) -> Notification.create("Computer").show())
                        .appendChild(CheckTreeItem.create(Icons.headset(), "Headset")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Headset").show()))
                        .appendChild(CheckTreeItem.create(Icons.keyboard(), "Keyboard")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Keyboard").show()))
                        .appendChild(CheckTreeItem.create(Icons.mouse(), "Mouse")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Mouse").show())))

                .appendChild(CheckTreeItem.create(Icons.laptop(), "Laptop")
                        .addSelectionChangeListener((source, selection) -> Notification.create("Laptop").show())

                        .appendChild(CheckTreeItem.create(Icons.laptop(), "Chromebook")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Chromebook").show()))
                        .appendChild(CheckTreeItem.create(Icons.laptop_account(), "MacBook")
                                .addSelectionChangeListener((source, selection) -> Notification.create("MacBook").show())))

                .appendChild(CheckTreeItem.create(Icons.cellphone(), "Smart phone")
                        .addSelectionChangeListener((source, selection) -> Notification.create("Smart phone").show())
                        .appendChild(CheckTreeItem.create(Icons.tablet(), "Tablet")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Tablet").show()))
                        .appendChild(CheckTreeItem.create(Icons.cellphone(), "Android")
                                .addSelectionChangeListener((source, selection) -> Notification.create("Android").show()))
                        .appendChild(CheckTreeItem.create(Icons.cellphone_cog(), "iPhone")
                                .addSelectionChangeListener((source, selection) -> Notification.create("iPhone").show())));


        CheckTree<String> hardwareMenu2 = CheckTree.<String>create("FILES")
                .setToggleTarget(ToggleTarget.ICON)
                .setAutoCollapse(false)
                .addSelectionChangeListener((treeItem, selection) -> DomGlobal.console.info(treeItem.get().getValue()))
                .withHeader((tree, header)-> {
                    header.withPostfixElement((head, postfix) -> {
                        postfix.appendChild(Icons.checkbox_multiple_outline().clickable().addClickListener(evt-> tree.selectAll()));
                        postfix.appendChild(Icons.checkbox_multiple_blank_outline().clickable().addClickListener(evt-> tree.deselectAll()));
                    });
                })

                .appendChild(CheckTreeItem.create(Icons.folder(), "Folder")
                        .addSelectionChangeListener((source, selection) -> Notification.create("Folder").show())
                        .appendChild(CheckTreeItem.create(Icons.folder_star(), "My files")
                                .addSelectionChangeListener((source, selection) -> Notification.create("My files").show())
                                .appendChild(CheckTreeItem.create(Icons.note(), "File 1")
                                        .addSelectionChangeListener((source, selection) -> Notification.create("File 1").show()))
                                .appendChild(CheckTreeItem.create(Icons.note(), "File 2")
                                        .addSelectionChangeListener((source, selection) -> Notification.create("File 2").show()))
                                .appendChild((CheckTreeItem.create(Icons.note(), "File 3"))
                                        .addSelectionChangeListener((source, selection) -> Notification.create("File 3").show()))
                                .appendChild(CheckTreeItem.create(Icons.note(), "File 4")
                                        .addSelectionChangeListener((source, selection) -> Notification.create("File 4").show()))
                        )
                        .appendChild(CheckTreeItem.create(Icons.file_upload(), "Upload"))
                        .appendChild(CheckTreeItem.create(Icons.file_download(), "Download"))
                        .appendChild(CheckTreeItem.create(Icons.folder_plus(), "New folder"))
                        .appendChild(CheckTreeItem.create(Icons.folder_account(), "Shared"))
                        .appendChild(CheckTreeItem.create(Icons.attachment(), "Attachments"))
                ).appendChild(CheckTreeItem.create(Icons.cloud(), "Cloud")
                        .appendChild(CheckTreeItem.create(Icons.cloud_upload(), "Upload"))
                        .appendChild(CheckTreeItem.create(Icons.cloud_download(), "Download"))
                        .appendChild(CheckTreeItem.create(Icons.cloud_off_outline(), "Offline"))
                        .appendChild(CheckTreeItem.create(Icons.cloud_question(), "Queue"))
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

        CheckTree<String> citiesTree = CheckTree.<String>create("CITIES")
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
                                .appendChild(CheckTreeItem.<String>create(Icons.map(), country.getName())
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

                                                    country.getCities().forEach(city -> countryItem.appendChild(CheckTreeItem.create(Icons.city(), city)));
                                                }
                                        )
                                );
                    })
                    ;
                });


        CheckTree<String> foldersExpand = CheckTree.<String>create("FILES")
                .setAutoCollapse(false)
                .setFoldable(true)
                .setSearchable(true)
                .setNodeIconSupplier((item) -> TreeItemIcon.of(Icons.folder(), Icons.folder_open(), Icons.file(), Icons.file_check_outline()))
                .appendChild(CheckTreeItem.create("Folder 1")
                        .appendChild(CheckTreeItem.create("Folder 1-1")
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                        ).appendChild(CheckTreeItem.create("Folder 1-2")
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                        )
                ).appendChild(CheckTreeItem.create("Folder 2")
                        .appendChild(CheckTreeItem.create("Folder 2-1")
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                        )
                        .appendChild(CheckTreeItem.create("Folder 2-2")
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                        )
                )
                .appendChild(CheckTreeItem.create("Folder 3")
                        .appendChild(CheckTreeItem.create("Folder 3-1")
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                                .expand()
                        ).appendChild(CheckTreeItem.create("Folder 3-2")
                                .expand()
                                .appendChild(CheckTreeItem.create("File 1"))
                                .appendChild(CheckTreeItem.create("File 2"))
                                .appendChild(CheckTreeItem.create("File 3"))
                                .appendChild(CheckTreeItem.create("File 4"))
                                .expand()
                        )
                                .expand()
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