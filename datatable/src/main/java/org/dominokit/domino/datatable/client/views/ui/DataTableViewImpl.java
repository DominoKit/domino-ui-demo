package org.dominokit.domino.datatable.client.views.ui;

import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.core.Global;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLTableCellElement;
import jsinterop.annotations.JsProperty;
import jsinterop.annotations.JsType;
import jsinterop.base.Js;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.DatatableProxy;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.JsonResource;
import org.dominokit.domino.datatable.client.views.model.*;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.*;
import org.dominokit.domino.ui.datatable.plugins.filter.header.*;
import org.dominokit.domino.ui.datatable.plugins.pincolumns.PinColumnMeta;
import org.dominokit.domino.ui.datatable.plugins.pincolumns.PinColumnsPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.datatable.store.LocalListScrollingDataSource;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.*;
import java.util.stream.Collectors;

import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.*;

@UiView(presentable = DatatableProxy.class)
@SampleClass
public class DataTableViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

    private HTMLDivElement element;
    private List<ContactListParseHandler> contactListParseHandlers = new ArrayList<>();
    private Random random = new Random();

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        uiHandlers.startLoading();
        element.appendChild(LinkToSourceCode.create("datatable", this.getClass()).element());
        element.appendChild(BlockHeader.create("DATA TABLES", "For detailed demo code please visit: ")
                .appendChild(a().attr("href", "https://github.com/DominoKit/domino-ui-demo/tree/master/datatable")
                        .attr("target", "_blank")
                        .textContent("Data table demo source code").element())
                .element());

        basicTable();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.basicTable()).element());

        editableTable();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.editableTable()).element());

        basicFixedTable();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.basicFixedTable()).element());

        singleSelectionPlugin();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.singleSelectionPlugin()).element());

        multiSelectionPlugin();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.multiSelectionPlugin()).element());

        markerPlugin();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.markerPlugin()).element());

        recordDetailsPlugin();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.recordDetailsPlugin()).element());

        tableHeaderBarPlugin();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.tableHeaderBarPlugin()).element());

        sortAndSearch();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.sortAndSearch()).element());

        simplePagination();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.simplePagination()).element());

        scrollingPagination();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.scrollingPagination()).element());

        advancedPagination();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.advancedPagination()).element());

        scrollableTable();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.scrollableTable()).element());

        topPanelPlugin();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.topPanelPlugin()).element());

        groupingTable();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.groupingTable()).element());

        treeGridFullParentSpan();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.treeGridFullParentSpan()).element());

        lazyTreeGridFullParentSpan();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.lazyTreeGridFullParentSpan()).element());

        treeGridParentColumns();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.treeGridParentColumns()).element());

        lazyTreeGridParentColumns();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.lazyTreeGridParentColumns()).element());

        resizableColumns();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.resizableColumns()).element());

        pinColumns();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.pinColumns()).element());

        groupColumns();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.groupColumns()).element());

        groupPinResizeColumns();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.groupPinResizeColumns()).element());

        dragAndDrop();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.dragAndDrop()).element());

        dragAndDropDifferentSources();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.dragAndDropDifferentSources()).element());

        allInOne();
        element.appendChild(CodeCard.createLazyCodeCard(CodeResource.INSTANCE.allInOne()).element());


        try {
            JsonResource.INSTANCE.generatedJson().getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load json", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    ContactList contactList = ContactList.MAPPER.read(resource.getText());
                    List<Contact> contacts = contactList.getContacts();
                    List<Contact> level1 = addFriends(contacts, contacts.subList(0, 20));
                    List<Contact> level2 = addFriends(contacts, level1);
                    addFriends(contacts, level2);
                    contactListParseHandlers.forEach(contactListParseHandler ->
                            contactListParseHandler.onContactsParsed(contacts));
                    uiHandlers.stopLoading();
                }
            });
        } catch (ResourceException e) {
            DomGlobal.console.error("could not load json", e);
        }

        return element;
    }

    @SampleMethod
    private void dragAndDropDifferentSources() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        DragDropPlugin<Contact> dragDropPlugin = new DragDropPlugin<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))

                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .addPlugin(dragDropPlugin);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        //------ second table

        TableConfig<Contact> tableConfig2 = new TableConfig<>();
        DragDropPlugin<Contact> dragDropPlugin2 = new DragDropPlugin<>();
        tableConfig2
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))

                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .addPlugin(dragDropPlugin2);

        LocalListDataStore<Contact> localListDataStore2 = new LocalListDataStore<>();
        DataTable<Contact> table2 = new DataTable<>(tableConfig2, localListDataStore2);

        dragDropPlugin.linkWith(table2);
        dragDropPlugin2.linkWith(table);

        element.appendChild(Card.create("DRAG & DROP DIFFERENT TABLES", "Moving records by dragging and dropping them from/to data tables")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(FlexLayout.create()
                        .setGap("20px")
                        .setDirection(FlexDirection.TOP_TO_BOTTOM)
                        .setJustifyContent(FlexJustifyContent.SPACE_BETWEEN)
                        .appendChild(FlexItem.create()
                                .appendChild(BlockHeader.create("TABLE - 1"))
                                .appendChild(table))
                        .appendChild(FlexItem.create()
                                .appendChild(BlockHeader.create("TABLE - 2"))
                                .appendChild(table2))
                )
                .element());

        contactListParseHandlers.add(contacts -> {
            List<Contact> data = subList(contacts);
            localListDataStore.setData(data.subList(0, data.size() / 2));
            localListDataStore2.setData(data.subList(data.size() / 2, data.size()));
        });
    }

    @SampleMethod
    private void resizableColumns() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                        .applyMeta(ResizeColumnMeta.create().setResizable(false))
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))

                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .addPlugin(new ResizeColumnsPlugin<>());

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("RESIZABLE COLUMNS", "Allow the user to change the size of the table columns.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });
    }

    @SampleMethod
    private void pinColumns() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        })
                        .applyMeta(PinColumnMeta.left())
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName()))
                        .setWidth("300px")
                )

                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center")
                        .setWidth("300px")
                )

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center")
                        .setWidth("300px")
                )

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .setWidth("500px")
                )

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail()))
                        .setWidth("500px")
                )

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone()))
                        .setWidth("400px")
                )

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        })
                        .applyMeta(PinColumnMeta.right())
                )
                .addPlugin(new PinColumnsPlugin<Contact>().configure(config -> config
                        .setShowPinMenu(true)
                        .setShowPinIcon(true)
                ));

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("PIN COLUMNS", "The pin columns plugin allow the user to pin columns left or right so they dont scroll with the table.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });
    }

    @SampleMethod
    private void groupColumns() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("personalInfo", "Personal info")
                        .addColumn(ColumnConfig.<Contact>create("identity", "Identity")
                                .addColumn(ColumnConfig.<Contact>create("id", "#")
                                        .textAlign("right")
                                        .asHeader()
                                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                                )
                                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName()))
                                )
                        )
                        .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                                .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                                .textAlign("center")
                        )
                        .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                                .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                                .textAlign("center")
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        })
                )

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                )
                .addColumn(ColumnConfig.<Contact>create("contact", "Contact")
                        .addColumn(ColumnConfig.<Contact>create("email", "Email")
                                .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail()))
                        )

                        .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                                .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone()))
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        })
                );

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);
        table.bordered();
        element.appendChild(Card.create("GROUP COLUMNS", "Group columns together for resize and pinning.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });
    }


    @SampleMethod
    private void groupPinResizeColumns() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("identity", "Identity")
                        .addColumn(ColumnConfig.<Contact>create("id", "#")
                                .textAlign("right")
                                .asHeader()
                                .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                        )
                        .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                                .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName()))
                        )
                        .applyMeta(PinColumnMeta.left())
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center")
                )
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center")
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                )
                .addColumn(ColumnConfig.<Contact>create("contact", "Contact")
                        .addColumn(ColumnConfig.<Contact>create("email", "Email")
                                .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail()))
                        )

                        .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                                .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone()))
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        })
                )
                .addPlugin(new PinColumnsPlugin<Contact>()
                        .configure(config -> config
                                .setShowPinIcon(true)
                                .setShowPinMenu(true))
                )
                .addPlugin(new ResizeColumnsPlugin<>())
        ;

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);
        table.bordered();
        element.appendChild(Card.create("GROUP, PIN, RESIZE COLUMNS", "Column groups works with ping and resize plugins.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });
    }

    @SampleMethod
    private void dragAndDrop() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))

                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .addPlugin(new DragDropPlugin<>());

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("DRAG & DROP", "Reorder records by dragging and dropping them")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });
    }

    private List<Contact> addFriends(List<Contact> pool, List<Contact> contacts) {
        List<Contact> result = new ArrayList<>();
        for (int i = 0; i < contacts.size(); i++) {
            int start = random.nextInt(20);
            List<Contact> friends = pool.subList(start, start + random.nextInt(5))
                    .stream()
                    .map(Contact::new)
                    .collect(Collectors.toList());

            contacts.forEach(c -> c.setFriends(friends));
            result.addAll(friends);
        }

        return result;
    }

    @SampleMethod
    private void treeGridFullParentSpan() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .onUtilityColumn(utilityColumn -> {
                    utilityColumn
                            .setTitle("First name")
                            .setSortable(true, "id");
                })
                .setMultiSelect(true)
                .addPlugin(new SortPlugin<>())
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()))
                .addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord())))
                .addPlugin(new TreeGridPlugin<Contact>((parent, itemsConsumer) -> {
                            DomGlobal.console.info("Loading items for : " + parent.getName());
                            itemsConsumer.accept(Optional.ofNullable(parent.getFriends()));
                        })
                                .configure(config -> {
                                    config
                                            .setIndentColumnElementSupplier(tableRow -> Paragraph.create(tableRow.getRecord().getName()).setMarginBottom("0").element())
                                            .setParentRowCellsSupplier((dataTable, tableRow) -> {
                                                HTMLTableCellElement cellElement = DominoElement.of(td())
                                                        .setAttribute("colspan", "8")
                                                        .element();
                                                RowCell<Contact> rowCell =
                                                        new RowCell<>(new CellRenderer.CellInfo<>(tableRow, cellElement), dataTable.getTableConfig().getColumnByName("id"));
                                                return Collections.singletonList(rowCell);
                                            })
                                            .setIndent(60)
                                            .setLazy(false);
                                })
                );

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("TREE GRID PLUGIN - Full PARENT SPAN", "Render records in tree style with expand and collapse features")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(contacts.subList(0, 25));
        });
    }

    @SampleMethod
    private void lazyTreeGridFullParentSpan() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .onUtilityColumn(utilityColumn -> {
                    utilityColumn
                            .setTitle("First name")
                            .setSortable(true, "id");
                })
                .setMultiSelect(true)
                .addPlugin(new SortPlugin<>())
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()))
                .addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord())))
                .addPlugin(new TreeGridPlugin<Contact>((parent, itemsConsumer) -> {
                            DomGlobal.console.info("Loading items for : " + parent.getName());
                            itemsConsumer.accept(Optional.ofNullable(parent.getFriends()));
                        })
                                .configure(config -> {
                                    config
                                            .setIndentColumnElementSupplier(tableRow -> Paragraph.create(tableRow.getRecord().getName()).setMarginBottom("0").element())
                                            .setParentRowCellsSupplier((dataTable, tableRow) -> {
                                                HTMLTableCellElement cellElement = DominoElement.of(td())
                                                        .setAttribute("colspan", "8")
                                                        .element();
                                                RowCell<Contact> rowCell =
                                                        new RowCell<>(new CellRenderer.CellInfo<>(tableRow, cellElement), dataTable.getTableConfig().getColumnByName("id"));
                                                return Collections.singletonList(rowCell);
                                            })
                                            .setIndent(60);
                                })
                );

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("LAZY TREE GRID PLUGIN - Full PARENT SPAN", "Render records in tree style with expand and collapse features, ")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(contacts.subList(0, 25));
        });
    }

    @SampleMethod
    private void treeGridParentColumns() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .onUtilityColumn(utilityColumn -> {
                    utilityColumn
                            .setSortable(true, "id")
                            .setTitle("First name");
                })
                .setMultiSelect(true)
                .addPlugin(new SortPlugin<>())
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()))
                .addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord())))
                .addPlugin(new TreeGridPlugin<Contact>((parent, itemsConsumer) -> {
                            DomGlobal.console.info("Loading items for : " + parent.getName());
                            itemsConsumer.accept(Optional.ofNullable(parent.getFriends()));
                        })
                                .configure(config -> {
                                    config.setIndentColumnElementSupplier(tableRow -> Paragraph.create(tableRow.getRecord().getName()).setMarginBottom("0").element())
                                            .setIndent(60);
                                })
                );

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("TREE GRID PLUGIN - PARENT WITH COLUMNS", "Render records in tree style with expand and collapse features")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(contacts.subList(0, 25));
        });
    }

    @SampleMethod
    private void lazyTreeGridParentColumns() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .onUtilityColumn(utilityColumn -> {
                    utilityColumn
                            .setSortable(true, "id")
                            .setTitle("First name");
                })
                .setMultiSelect(true)
                .addPlugin(new SortPlugin<>())
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()))
                .addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord())))
                .addPlugin(new TreeGridPlugin<Contact>((parent, itemsConsumer) -> {
                            DomGlobal.console.info("Loading items for : " + parent.getName());
                            itemsConsumer.accept(Optional.ofNullable(parent.getFriends()));
                        })
                                .configure(config -> {
                                    config.setIndentColumnElementSupplier(tableRow -> Paragraph.create(tableRow.getRecord().getName()).setMarginBottom("0").element())
                                            .setIndent(60)
                                            .setLazy(true);
                                })
                );

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("LAZY TREE GRID PLUGIN - PARENT WITH COLUMNS", "Render records in tree style with expand and collapse features, sub records wont be loaded until the row is expanded.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(contacts.subList(0, 25));
        });
    }

    private void sortChildren(TreeGridSample item, Comparator<TreeGridSample> comparator) {
        item.getItems().sort(comparator);
        for (TreeGridSample itemItem : item.getItems()) {
            sortChildren(itemItem, comparator);
        }
    }

    @SampleMethod
    private void groupingTable() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo1 -> ContactUiUtils.getBalanceElement(cellInfo1.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));
        tableConfig.addPlugin(new GroupingPlugin<>(tableRow -> tableRow.getRecord().getGender().toString(),
                cellInfo -> {
                    DominoElement.of(cellInfo.getElement())
                            .style()
                            .setCssProperty("border-bottom", "1px solid #afafaf")
                            .setPadding(px.of(5))
                            .addCss(ColorScheme.INDIGO.lighten_5().getBackground());
                    return TextNode.of(cellInfo.getRecord().getGender().getLabel());
                }));
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("GROUPING PLUGIN", "The plugin allows splitting the table data into different groups.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });
    }

    @SampleMethod
    private void basicTable() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName()))
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center")
                )

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center")
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                )

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail()))
                )

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone()))
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("BASIC TABLE", "By default a table will auto fit columns and allow custom cell content")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });
    }

    @SampleMethod
    private void editableTable() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("edit_save", "")
                        .setCellRenderer(cell -> Icons.ALL.pencil_mdi()
                                .clickable()
                                .setTooltip("Edit")
                                .addClickListener(evt -> cell.getTableRow().edit())
                                .element()
                        )
                        .setEditableCellRenderer(cell -> Icons.ALL.content_save_mdi()
                                .clickable()
                                .setTooltip("Save")
                                .addClickListener(evt -> {
                                    if (cell.getTableRow().validate().isValid()) {
                                        cell.getTableRow().save();
                                    }
                                })
                                .element())
                )
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        })
                        .setEditableCellRenderer(cell -> {
                            CheckBox activeCheckBox = CheckBox.create("")
                                    .setFieldStyle(FieldStyle.ROUNDED)
                                    .value(cell.getRecord().isActive());
                            cell.setDirtyRecordHandler(dirty -> dirty.setActive(activeCheckBox.getValue()));
                            return activeCheckBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName()))
                        .setEditableCellRenderer(cell -> {
                            TextBox nameBox = TextBox.create()
                                    .setFieldStyle(FieldStyle.ROUNDED)
                                    .value(cell.getRecord().getName());

                            cell.setDirtyRecordHandler(dirty -> dirty.setName(nameBox.getValue()));
                            return nameBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setEditableCellRenderer(cell -> {
                            Select<Gender> genderSelect = Select.<Gender>create()
                                    .styler(style -> style.setMinWidth("100px"))
                                    .setFieldStyle(FieldStyle.ROUNDED)
                                    .appendChild(SelectOption.create(Gender.male, "Male", "Male"))
                                    .appendChild(SelectOption.create(Gender.female, "female", "female"))
                                    .value(cell.getRecord().getGender());
                            cell.setDirtyRecordHandler(dirty -> dirty.setGender(genderSelect.getValue()));
                            return genderSelect.element();
                        })
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setEditableCellRenderer(cell -> {
                            Select<EyeColor> eyeColorSelect = Select.<EyeColor>create()
                                    .setFieldStyle(FieldStyle.ROUNDED)
                                    .appendChild(SelectOption.create(EyeColor.blue, "Blue", "Blue"))
                                    .appendChild(SelectOption.create(EyeColor.brown, "Brown", "Brown"))
                                    .appendChild(SelectOption.create(EyeColor.green, "Green", "Green"))
                                    .value(cell.getRecord().getEyeColor());
                            cell.setDirtyRecordHandler(dirty -> dirty.setEyeColor(eyeColorSelect.getValue()));
                            return eyeColorSelect.element();
                        })
                        .textAlign("center"))
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cell -> ContactUiUtils.getBalanceElement(cell.getRecord()))
                        .setEditableCellRenderer(cell -> {
                            DoubleBox doubleBox = DoubleBox.create()
                                    .setFieldStyle(FieldStyle.ROUNDED)
                                    .setMaxValue(4000.0)
                                    .value(cell.getRecord().getBalance());
                            cell.setDirtyRecordHandler(dirty -> dirty.setBalance(doubleBox.getValue().doubleValue()));
                            cell.setCellValidator(doubleBox::validate);
                            return doubleBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail()))
                        .setEditableCellRenderer(cell -> {
                            EmailBox emailBox = EmailBox.create()
                                    .setFieldStyle(FieldStyle.ROUNDED)
                                    .value(cell.getRecord().getEmail());
                            cell.setDirtyRecordHandler(dirty -> dirty.setEmail(emailBox.getValue()));
                            return emailBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone()))
                        .setEditableCellRenderer(cell -> {
                            TelephoneBox telephoneBox = TelephoneBox.create()
                                    .setFieldStyle(FieldStyle.ROUNDED)
                                    .value(cell.getRecord().getPhone());

                            cell.setDirtyRecordHandler(dirty -> dirty.setPhone(telephoneBox.getValue()));
                            return telephoneBox.element();
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        })
                )
                .setDirtyRecordHandlers(Contact::new, (originalRecord, dirtyRecord) -> {
                    originalRecord.setActive(dirtyRecord.isActive());
                    originalRecord.setPhone(dirtyRecord.getPhone());
                    originalRecord.setEmail(dirtyRecord.getEmail());
                    originalRecord.setBalance(dirtyRecord.getBalance());
                    originalRecord.setEyeColor(dirtyRecord.getEyeColor());
                    originalRecord.setGender(dirtyRecord.getGender());
                    originalRecord.setName(dirtyRecord.getName());
                });

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("EDITABLE TABLE", "Render cells as editable fields and save the row data.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });
    }

    @SampleMethod
    private void basicFixedTable() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setWidth("200px")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))

                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setWidth("250px")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setWidth("300px")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setWidth("150px")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .addPlugin(new SortPlugin<>());
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> defaultTable = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("BASIC TABLE - FIXED", "Fixed tables will use the specified column width and will have scrolls when elements exceeds the body height. ")
                .setCollapsible()
                .appendChild(new TableStyleActions(defaultTable))
                .appendChild(defaultTable)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });
    }

    private List<Contact> subList(List<Contact> contacts) {
        return subList(contacts, 0, 15);
    }

    private List<Contact> subList(List<Contact> contacts, int size) {
        return subList(contacts, 0, size);
    }

    private List<Contact> subList(List<Contact> contacts, int from, int to) {
        return contacts.subList(from, to).stream().map(Contact::new).collect(Collectors.toList());
    }

    @SampleMethod
    private void singleSelectionPlugin() {
        TableConfig<Contact> singleSelectionTableConfig = new TableConfig<>();
        singleSelectionTableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell1 -> {
                            if (cell1.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell1 -> ContactUiUtils.getGenderElement(cell1.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell1 -> ContactUiUtils.getEyeColorElement(cell1.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo1 -> ContactUiUtils.getBalanceElement(cellInfo1.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell1 -> {
                            if (cell1.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));
        singleSelectionTableConfig.setMultiSelect(false);
        singleSelectionTableConfig.addPlugin(new SelectionPlugin<>(ColorScheme.LIGHT_BLUE));
        LocalListDataStore<Contact> singleLocalStore = new LocalListDataStore<>();
        DataTable<Contact> singleSelectionTable = new DataTable<>(singleSelectionTableConfig, singleLocalStore);
        singleSelectionTable.addSelectionListener((selectedTableRows, selectedRecords) -> {
            Notification.create(selectedRecords.size() + "").show();
        });

        element.appendChild(Card.create("SELECTION PLUGIN", "Enable row selection by adding the selection plugin, pass different selection style colors in the constructor.")
                .setCollapsible()
                .appendChild(BlockHeader.create("SINGLE SELECTION"))
                .appendChild(new TableStyleActions(singleSelectionTable))
                .appendChild(singleSelectionTable.element())
                .element());

        contactListParseHandlers.add(contacts -> {
            singleLocalStore.setData(subList(contacts));
            singleLocalStore.load();
        });


    }

    @SampleMethod
    private void multiSelectionPlugin() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));
        tableConfig.addPlugin(new SelectionPlugin<>(ColorScheme.LIGHT_BLUE));
        LocalListDataStore<Contact> multiLocalStore = new LocalListDataStore<>();
        DataTable<Contact> multiSelectionTable = new DataTable<>(tableConfig, multiLocalStore);
        multiSelectionTable.addSelectionListener((selectedTableRows, selectedRecords) -> {
            Notification.create(selectedRecords.size() + "").show();
        });


        element.appendChild(Card.create("SELECTION PLUGIN", "Enable row selection by adding the selection plugin, pass different selection style colors in the constructor.")
                .setCollapsible()
                .appendChild(BlockHeader.create("MULTI SELECTION"))
                .appendChild(new TableStyleActions(multiSelectionTable))
                .appendChild(multiSelectionTable)
                .element());

        contactListParseHandlers.add(contacts -> {
            multiLocalStore.setData(subList(contacts));
        });


    }

    @SampleMethod
    private void markerPlugin() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));

        tableConfig.addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord())));
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> defaultTable = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("MARKER PLUGIN", "Mark the left side of the row with custom colors")
                .setCollapsible()
                .appendChild(new TableStyleActions(defaultTable))
                .appendChild(defaultTable)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });

    }

    @SampleMethod
    private void recordDetailsPlugin() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell1 -> {
                            if (cell1.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell1 -> ContactUiUtils.getGenderElement(cell1.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell1 -> ContactUiUtils.getEyeColorElement(cell1.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell1 -> {
                            if (cell1.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));

        tableConfig.addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()));
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> defaultTable = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("RECORD DETAILS PLUGIN", "Enable inline record details for rows.")
                .setCollapsible()
                .appendChild(new TableStyleActions(defaultTable))
                .appendChild(defaultTable)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });


    }

    @SampleMethod
    private void tableHeaderBarPlugin() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));

        tableConfig.addPlugin(new SelectionPlugin<>());
        tableConfig.addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                .addActionElement(dataTable -> {
                    Icon selectInactiveIcon = Icons.ALL.highlight_off()
                            .clickable()
                            .setTooltip("Select Inactive")
                            .addClickListener(evt ->
                                    dataTable.getRows().forEach(item -> {
                                        if (!item.getRecord().isActive()) {
                                            item.select();
                                        } else {
                                            item.deselect();
                                        }
                                    }));

                    return a().add(selectInactiveIcon).element();
                })
                .addActionElement(dataTable -> {
                    Icon selectInactiveIcon = Icons.ALL.check_circle()
                            .clickable()
                            .setTooltip("Select Active")
                            .addClickListener(evt ->
                                    dataTable.getRows().forEach(tableRow -> {
                                        if (tableRow.getRecord().isActive()) {
                                            tableRow.select();
                                        } else {
                                            tableRow.deselect();
                                        }
                                    }));

                    return a().add(selectInactiveIcon).element();

                }));

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> defaultTable = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("HEADER BAR PLUGIN", "Adds a title and description for the table, and allow adding elements to the top right side of the table")
                .setCollapsible()
                .appendChild(new TableStyleActions(defaultTable))
                .appendChild(defaultTable)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
        });


    }

    @SampleMethod
    private void sortAndSearch() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .sortable()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                )

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        })
                        .applyMeta(ColumnFilterMeta.of(BooleanHeaderFilter.<Contact>create("Active", "Inactive", "Both")))
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName()))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center")
                        .applyMeta(ColumnFilterMeta.of(EnumHeaderFilter.<Contact, Gender>create(Gender.values())))
                )
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center")
                        .applyMeta(ColumnFilterMeta.of(SelectHeaderFilter.<Contact>create()
                                .appendChild(SelectOption.create("blue", "Blue"))
                                .appendChild(SelectOption.create("brown", "Brown"))
                                .appendChild(SelectOption.create("green", "Green"))
                        ))
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .applyMeta(ColumnFilterMeta.of(DoubleHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail()))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone()))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));

        ColumnHeaderFilterPlugin<Contact> contactColumnHeaderFilterPlugin = ColumnHeaderFilterPlugin.<Contact>create();
        tableConfig
                .addPlugin(new SortPlugin<>())
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new HeaderBarPlugin.ClearSearch<>())
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<>())
                        .addActionElement(dataTable -> Icons.ALL.filter_menu_outline_mdi()
                                .clickable()
                                .addClickListener(evt -> contactColumnHeaderFilterPlugin.getFiltersRowElement()
                                        .toggleDisplay())
                                .element())
                )
                .addPlugin(contactColumnHeaderFilterPlugin);

        LocalListDataStore<Contact> listStore = new LocalListDataStore<>();
        listStore.setRecordsSorter(new ContactSorter());
        listStore.setSearchFilter(new ContactSearchFilter());
        DataTable<Contact> table = new DataTable<>(tableConfig, listStore);

        element.appendChild(Card.create("SORT PLUGIN & SEARCH HEADER ACTION", "Allows the table to fire events useful for datasource to sort and search the data")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            listStore.setData(subList(contacts));
        });
    }

    @SampleMethod
    private void simplePagination() {
        SimplePaginationPlugin<Contact> simplePaginationPlugin = new SimplePaginationPlugin<>(10);//page size
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .sortable()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));

        tableConfig
                .addPlugin(new SortPlugin<>())
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new HeaderBarPlugin.ClearSearch<>())
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<>())
                )
                .addPlugin(simplePaginationPlugin);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        localListDataStore.setRecordsSorter(new ContactSorter());
        localListDataStore.setSearchFilter(new ContactSearchFilter());
        localListDataStore.setPagination(simplePaginationPlugin.getSimplePagination());
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("SIMPLE PAGINATION", "Simple pagination plugin allows the table to fire pagination events helpful for the datasource")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts, 0, 100));
        });


    }

    @SampleMethod
    private void scrollingPagination() {
        ScrollingPaginationPlugin<Contact> scrollingPagination = new ScrollingPaginationPlugin<>(10, 5);//page size
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .sortable()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));

        tableConfig
                .addPlugin(new SortPlugin<>())
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new HeaderBarPlugin.ClearSearch<>())
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<>())
                )
                .addPlugin(scrollingPagination);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        localListDataStore.setRecordsSorter(new ContactSorter());
        localListDataStore.setSearchFilter(new ContactSearchFilter());
        localListDataStore.setPagination(scrollingPagination.getPagination());
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("SCROLLING PAGINATION", "Scrolling pagination plugin allows navigation through a set of page at a time in datatable")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts, 0, 100));
        });


    }

    @SampleMethod
    private void advancedPagination() {
        AdvancedPaginationPlugin<Contact> advancedPagination = new AdvancedPaginationPlugin<>(10);//page size
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .sortable()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));

        tableConfig
                .addPlugin(new SortPlugin<>())
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new HeaderBarPlugin.ClearSearch<>())
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<>())
                )
                .addPlugin(advancedPagination);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        localListDataStore.setRecordsSorter(new ContactSorter());
        localListDataStore.setSearchFilter(new ContactSearchFilter());
        localListDataStore.setPagination(advancedPagination.getPagination());
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("ADVANCED PAGINATION", "Advanced pagination plugin allows navigation through pages from a dropdown list")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts, 0, 100));
        });


    }

    @SampleMethod
    private void scrollableTable() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .styleCell(cellElement -> Style.of(cellElement).setCssProperty("vertical-align", "middle"))
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName()))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .styleHeader(head -> Style.of(head).setWidth("100px"))
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .setWidth("250px"))
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setWidth("250px")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setWidth("150px")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .addPlugin(new BodyScrollPlugin<>())
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<>())
                )

                .addPlugin(new SortPlugin<>());

        LocalListScrollingDataSource<Contact> scrollingDataSource = new LocalListScrollingDataSource<Contact>(10)
                .setSearchFilter(new ContactSearchFilter())
                .setRecordsSorter(new ContactSorter());

        DataTable<Contact> table = new DataTable<>(tableConfig, scrollingDataSource);

        element.appendChild(Card.create("SCROLL LOADING", "Scroll loading requires the table to be fixed. use the Body scroll plugin to fire scroll events.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            scrollingDataSource.setData(contacts.subList(0, 100));
        });


    }

    @SampleMethod
    private void topPanelPlugin() {
        ContactsTopPanel<Contact> topPanel = new ContactsTopPanel<>();
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .styleCell(cellElement -> Style.of(cellElement).setCssProperty("vertical-align", "middle"))
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle().element()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off().element()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName()))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .styleHeader(head -> Style.of(head).setWidth("100px"))
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .setWidth("250px"))
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setWidth("300px")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setWidth("150px")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }))
                .addPlugin(new BodyScrollPlugin<>())
                .addPlugin(new TopPanelPlugin<Contact>() {

                    @Override
                    public HTMLElement element() {
                        return topPanel.element();
                    }

                    @Override
                    public void handleEvent(TableEvent event) {
                        if (TableDataUpdatedEvent.DATA_UPDATED.equals(event.getType())) {
                            topPanel.update((TableDataUpdatedEvent<Contact>) event);
                        }
                    }
                })
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<>())
                )

                .addPlugin(new SortPlugin<>());

        LocalListScrollingDataSource<Contact> scrollingDataSource = new LocalListScrollingDataSource<Contact>(10)
                .setSearchFilter(new ContactSearchFilter())
                .setRecordsSorter(new ContactSorter());

        DataTable<Contact> table = new DataTable<>(tableConfig, scrollingDataSource);

        element.appendChild(Card.create("TOP PANEL PLUGIN", "A simple panel that listens to datatable events and update its content accordingly.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            List<Contact> data = subList(contacts, 0, 100);
            scrollingDataSource.setData(data);
            topPanel.update(data);
        });


    }

    @SampleMethod
    private void allInOne() {
        ContactsTopPanel<Contact> topPanel = new ContactsTopPanel<>();
        ScrollingPaginationPlugin<Contact> scrollingPaginationPlugin = new ScrollingPaginationPlugin<>(10, 5);
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .styleCell(cellElement -> Style.of(cellElement).setCssProperty("vertical-align", "middle"))
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                        .setWidth("70px")
                )
                .addColumn(ColumnConfig.<Contact>create("group 1", "Group 1")
                        .addColumn(ColumnConfig.<Contact>create("status", "Status")
                                .setWidth("80px")
                                .textAlign("center")
                                .setCellRenderer(cell -> {
                                    if (cell.getTableRow().getRecord().isActive()) {
                                        return Style.of(Icons.ALL.check_circle().element()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                                    } else {
                                        return Style.of(Icons.ALL.highlight_off().element()).setColor(Color.RED_DARKEN_3.getHex()).element();
                                    }
                                })
                                .applyMeta(ColumnFilterMeta.of(BooleanHeaderFilter.<Contact>create("Active", "Inactive", "Both")))

                        )
                        .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                                .sortable()
                                .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName()))
                                .setWidth("200px")
                                .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("group 2", "Group 2")
                        .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                                .setWidth("100px")
                                .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                                .textAlign("center")
                                .applyMeta(ColumnFilterMeta.of(EnumHeaderFilter.<Contact, Gender>create(Gender.values())))
                        )
                        .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                                .styleHeader(head -> Style.of(head).setWidth("100px"))
                                .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                                .textAlign("center")
                                .maxWidth("120px")
                                .applyMeta(ColumnFilterMeta.of(SelectHeaderFilter.<Contact>create()
                                                .appendChild(SelectOption.create("blue", "Blue"))
                                                .appendChild(SelectOption.create("brown", "Brown"))
                                                .appendChild(SelectOption.create("green", "Green"))
                                        )
                                )
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("group 3", "Group 3")
                        .addColumn(ColumnConfig.<Contact>create("group 2", "Group 2")
                                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                                        .sortable()
                                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                                        .setWidth("200px")
                                        .applyMeta(ColumnFilterMeta.of(DoubleHeaderFilter.<Contact>create()))
                                )
                                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                                        .setWidth("250px")
                                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail()))
                                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                                )
                        )
                        .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                                .setWidth("200px")
                                .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone()))
                                .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        })
                )
                .addPlugin(scrollingPaginationPlugin)
                .addPlugin(new TopPanelPlugin<Contact>() {

                    @Override
                    public HTMLElement element() {
                        return topPanel.element();
                    }

                    @Override
                    public void handleEvent(TableEvent event) {
                        if (TableDataUpdatedEvent.DATA_UPDATED.equals(event.getType())) {
                            topPanel.update((TableDataUpdatedEvent<Contact>) event);
                        }
                    }
                })
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(dataTable -> {
                            Icon selectInactiveIcon = Icons.ALL.highlight_off()
                                    .clickable()
                                    .setTooltip("Select Inactive")
                                    .addClickListener(evt ->
                                            dataTable.getRows().forEach(item -> {
                                                if (!item.getRecord().isActive()) {
                                                    item.select();
                                                } else {
                                                    item.deselect();
                                                }
                                            }));

                            return a().add(selectInactiveIcon).element();
                        })
                        .addActionElement(dataTable -> {
                            Icon selectInactiveIcon = Icons.ALL.check_circle()
                                    .clickable()
                                    .setTooltip("Select Active")
                                    .addClickListener(evt ->
                                            dataTable.getRows().forEach(tableRow -> {
                                                if (tableRow.getRecord().isActive()) {
                                                    tableRow.select();
                                                } else {
                                                    tableRow.deselect();
                                                }
                                            }));

                            return a().add(selectInactiveIcon).element();

                        })
                        .addActionElement(new HeaderBarPlugin.ClearSearch<>())
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<>())
                        .addActionElement(new HeaderBarPlugin.ShowHideColumnsAction<>())
                )
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).element()))
                .addPlugin(new SelectionPlugin<>(ColorScheme.BLUE))
                .addPlugin(new RowMarkerPlugin<>(cellInfo -> ContactUiUtils.getBalanceColor(cellInfo.getRecord())))
                .addPlugin(new SortPlugin<>())
                .addPlugin(ColumnHeaderFilterPlugin.<Contact>create())
                .addPlugin(new GroupingPlugin<>(tableRow -> tableRow.getRecord().getGender().toString(),
                        cellInfo -> {
                            DominoElement.of(cellInfo.getElement())
                                    .style()
                                    .setCssProperty("border-bottom", "1px solid #afafaf")
                                    .setPadding(px.of(5))
                                    .addCss(ColorScheme.INDIGO.lighten_5().getBackground());
                            return TextNode.of(cellInfo.getRecord().getGender().getLabel());
                        }));

        LocalListDataStore<Contact> localListDataSource = new LocalListDataStore<Contact>()
                .setSearchFilter(new ContactSearchFilter())
                .setRecordsSorter(new ContactSorter())
                .setPagination(scrollingPaginationPlugin.getPagination());

        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataSource);

        element.appendChild(Card.create("ALL IN ONE", "Try all plugins and feature works together.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .element());

        contactListParseHandlers.add(contacts -> {
            List<Contact> data = subList(contacts, 0, 100);
            localListDataSource.setData(data);
            topPanel.update(data);
        });


    }

    public interface ContactListParseHandler {
        void onContactsParsed(List<Contact> contacts);
    }
}
