package org.dominokit.domino.tree.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.tree.client.presenters.TreePresenter;
import org.dominokit.domino.tree.client.views.CodeResource;
import org.dominokit.domino.tree.client.views.TreeView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = TreePresenter.class)
public class TreeViewImpl extends ComponentView<HTMLDivElement> implements TreeView {

    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {

        element.appendChild(BlockHeader.create("Tree").asElement());

        simpleTree();

        nestedTree();

        activeAndExpandIcons();
    }

    private void simpleTree() {
        Tree hardwareTree = Tree.create("HARDWARE")
                .addTreeItem(TreeItem.create("Computer", Icons.ALL.computer())
                        .addClickListener(evt -> Notification.create("Computer").show()))
                .addTreeItem(TreeItem.create("Headset", Icons.ALL.headset())
                        .addClickListener(evt -> Notification.create("Headset").show()))
                .addTreeItem(TreeItem.create("Keyboard", Icons.ALL.keyboard())
                        .addClickListener(evt -> Notification.create("Keyboard").show()))
                .addTreeItem(TreeItem.create("Mouse", Icons.ALL.mouse())
                        .addClickListener(evt -> Notification.create("Mouse").show()))
                .addSeparator()
                .addTreeItem(TreeItem.create("Laptop", Icons.ALL.laptop())
                        .addClickListener(evt -> Notification.create("Laptop").show()))
                .addTreeItem(TreeItem.create("Smart phone", Icons.ALL.smartphone())
                        .addClickListener(evt -> Notification.create("Smart phone").show()))
                .addTreeItem(TreeItem.create("Tablet", Icons.ALL.tablet())
                        .addClickListener(evt -> Notification.create("Tablet").show()))
                .addTreeItem(TreeItem.create("Speaker", Icons.ALL.speaker())
                        .addClickListener(evt -> Notification.create("Speaker").show()));

        Tree filesTree = Tree.create("FILES")
                .addTreeItem(TreeItem.create("Folder", Icons.ALL.folder())
                        .addClickListener(evt -> Notification.create("Folder").show()))
                .addTreeItem(TreeItem.create("Folder open", Icons.ALL.folder_open())
                        .addClickListener(evt -> Notification.create("Folder open").show()))
                .addTreeItem(TreeItem.create("Upload", Icons.ALL.file_upload())
                        .addClickListener(evt -> Notification.create("Upload").show()))
                .addTreeItem(TreeItem.create("Download", Icons.ALL.file_download())
                        .addClickListener(evt -> Notification.create("Download").show()))
                .addTreeItem(TreeItem.create("New folder", Icons.ALL.create_new_folder())
                        .addClickListener(evt -> Notification.create("New folder").show()))
                .addTreeItem(TreeItem.create("Shared", Icons.ALL.folder_shared())
                        .addClickListener(evt -> Notification.create("Shared").show()))
                .addTreeItem(TreeItem.create("Attachments", Icons.ALL.attachment())
                        .addClickListener(evt -> Notification.create("Attachments").show()))
                .addTreeItem(TreeItem.create("Cloud", Icons.ALL.cloud())
                        .addClickListener(evt -> Notification.create("Cloud").show()));

        element.appendChild(Card.create("SIMPLE MENU")
                .appendChild(Row.create()
                        .addColumn(Column.span6().addElement(hardwareTree))
                        .addColumn(Column.span6().addElement(filesTree))
                ).asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.simpleTree()).asElement());
    }

    private void nestedTree() {
        Tree hardwareTree = Tree.create("HARDWARE")
                .addTreeItem(TreeItem.create("Computer", Icons.ALL.desktop_windows())
                        .addClickListener(evt -> Notification.create("Computer").show())

                        .addTreeItem(TreeItem.create("Headset", Icons.ALL.headset())
                                .addClickListener(evt -> Notification.create("Headset").show()))
                        .addTreeItem(TreeItem.create("Keyboard", Icons.ALL.keyboard())
                                .addClickListener(evt -> Notification.create("Keyboard").show()))
                        .addTreeItem(TreeItem.create("Mouse", Icons.ALL.mouse())
                                .addClickListener(evt -> Notification.create("Mouse").show())))

                .addTreeItem(TreeItem.create("Laptop", Icons.ALL.laptop())
                        .addClickListener(evt -> Notification.create("Laptop").show())

                        .addTreeItem(TreeItem.create("Chromebook", Icons.ALL.laptop_chromebook())
                                .addClickListener(evt -> Notification.create("Chromebook").show()))
                        .addTreeItem(TreeItem.create("MacBook", Icons.ALL.laptop_mac())
                                .addClickListener(evt -> Notification.create("MacBook").show())))

                .addTreeItem(TreeItem.create("Smart phone", Icons.ALL.smartphone())
                        .addClickListener(evt -> Notification.create("Smart phone").show())

                        .addTreeItem(TreeItem.create("Tablet", Icons.ALL.tablet())
                                .addClickListener(evt -> Notification.create("Tablet").show()))
                        .addTreeItem(TreeItem.create("Android", Icons.ALL.phone_android())
                                .addClickListener(evt -> Notification.create("Android").show()))
                        .addTreeItem(TreeItem.create("iPhone", Icons.ALL.phone_iphone())
                                .addClickListener(evt -> Notification.create("iPhone").show())));


        Tree hardwareMenu2 = Tree.create("FILES")
                .setAutoCollapse(false)
                .addTreeItem(TreeItem.create("Folder", Icons.ALL.folder())
                        .addTreeItem(TreeItem.create("My files", Icons.ALL.folder_special())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.description())
                                        .addClickListener(evt -> Notification.create("File 1").show()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.description())
                                        .addClickListener(evt -> Notification.create("File 2").show()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.description())
                                        .addClickListener(evt -> Notification.create("File 3").show()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.description())
                                        .addClickListener(evt -> Notification.create("File 4").show()))
                        )
                        .addTreeItem(TreeItem.create("Upload", Icons.ALL.file_upload()))
                        .addTreeItem(TreeItem.create("Download", Icons.ALL.file_download()))
                        .addTreeItem(TreeItem.create("New folder", Icons.ALL.create_new_folder()))
                        .addTreeItem(TreeItem.create("Shared", Icons.ALL.folder_shared()))
                        .addTreeItem(TreeItem.create("Attachments", Icons.ALL.attachment()))
                ).addTreeItem(TreeItem.create("Cloud", Icons.ALL.cloud())
                        .addTreeItem(TreeItem.create("Upload", Icons.ALL.cloud_upload()))
                        .addTreeItem(TreeItem.create("Download", Icons.ALL.cloud_download()))
                        .addTreeItem(TreeItem.create("Offline", Icons.ALL.cloud_off()))
                        .addTreeItem(TreeItem.create("Queue", Icons.ALL.cloud_queue()))
                );


        element.appendChild(Card.create("SIMPLE NESTED MENU")
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .addElement(BlockHeader.create("Auto collapse"))
                                .addElement(hardwareTree))
                        .addColumn(Column.span6()
                                .addElement(BlockHeader.create("Auto collapse OFF"))
                                .addElement(hardwareMenu2))
                ).asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.nestedTree()).asElement());
    }

    private void activeAndExpandIcons() {
        Tree foldersActive = Tree.create("FILES")
                .setAutoCollapse(false)
                .enableFolding()
                .enableSearch()
                .autoExpandFound()
                .addTreeItem(TreeItem.create("Folder 1", Icons.ALL.folder())
                        .addTreeItem(TreeItem.create("Folder 1-1", Icons.ALL.folder())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        ).addTreeItem(TreeItem.create("Folder 1-2", Icons.ALL.folder())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        )
                ).addTreeItem(TreeItem.create("Folder 2", Icons.ALL.folder())
                        .addTreeItem(TreeItem.create("Folder 2-1", Icons.ALL.folder())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        ).addTreeItem(TreeItem.create("Folder 2-2", Icons.ALL.folder())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        )
                ).addTreeItem(TreeItem.create("Folder 3", Icons.ALL.folder())
                        .addTreeItem(TreeItem.create("Folder 3-1", Icons.ALL.folder())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        ).addTreeItem(TreeItem.create("Folder 3-2", Icons.ALL.folder())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        )
                );

        Tree foldersExpand = Tree.create("FILES")
                .setAutoCollapse(false)
                .enableFolding()
                .enableSearch()
                .addTreeItem(TreeItem.create("Folder 1", Icons.ALL.folder())
                        .setExpandIcon(Icons.ALL.folder_open())
                        .addTreeItem(TreeItem.create("Folder 1-1", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        ).addTreeItem(TreeItem.create("Folder 1-2", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        )
                ).addTreeItem(TreeItem.create("Folder 2", Icons.ALL.folder())
                        .setExpandIcon(Icons.ALL.folder_open())
                        .addTreeItem(TreeItem.create("Folder 2-1", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        ).addTreeItem(TreeItem.create("Folder 2-2", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                        )
                ).addTreeItem(TreeItem.create("Folder 3", Icons.ALL.folder())
                        .setExpandIcon(Icons.ALL.folder_open())
                        .addTreeItem(TreeItem.create("Folder 3-1", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .expand()
                        ).addTreeItem(TreeItem.create("Folder 3-2", Icons.ALL.folder())
                                .setExpandIcon(Icons.ALL.folder_open())
                                .expand()
                                .addTreeItem(TreeItem.create("File 1", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 2", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 3", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .addTreeItem(TreeItem.create("File 4", Icons.ALL.insert_drive_file())
                                        .setActiveIcon(Icons.ALL.description()))
                                .expand()
                        ).expand()
                );

        element.appendChild(Card.create("ACTIVE/EXPAND ICONS, SEARCH & FOLDING")
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .addElement(BlockHeader.create("Active icon"))
                                .addElement(foldersActive))
                        .addColumn(Column.span6()
                                        .addElement(BlockHeader.create("Expand icon"))
                                .addElement(foldersExpand))
                        ).asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.featuredTree()).asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}