package org.dominokit.domino.datatable.client.views.ui;

import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.datatable.client.presenters.DatatablePresenter;
import org.dominokit.domino.datatable.client.views.CodeResource;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.ContactList;
import org.dominokit.domino.datatable.client.views.model.ContactSearchFilter;
import org.dominokit.domino.datatable.client.views.model.ContactSorter;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.events.SimplePaginationPlugin;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.*;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.datatable.store.LocalListScrollingDataSource;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = DatatablePresenter.class)
public class DataTableViewImpl extends ComponentView<HTMLDivElement> implements DatatableView {

    private HTMLDivElement element = div().asElement();
    private List<ContactListParseHandler> contactListParseHandlers = new ArrayList<>();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("DATA TABLES", "For detailed demo code please visit: ")
                .appendChild(a().attr("href","https://github.com/DominoKit/domino-ui-demo/tree/master/datatable")
                        .attr("target","_blank")
                        .textContent("Data table demo source code").asElement())
                .asElement());
        basicTable();
        basicFixedTable();
        selectionPlugin();
        markerPlugin();
        recordDetailsPlugin();
        tableHeaderBarPlugin();
        sortAndSearch();
        simplePagination();
        scrollableTable();
        topPanelPlugin();
        allInOne();
        try {
            CodeResource.INSTANCE.generatedJson().getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load json", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    ContactList contactList = ContactList.MAPPER.read(resource.getText());
                    contactListParseHandlers.forEach(contactListParseHandler ->
                            contactListParseHandler.onContactsParsed(contactList.getContacts()));
                }
            });
        } catch (ResourceException e) {
            DomGlobal.console.error("could not load json", e);
        }
    }


    private void basicTable() {
        TableConfig<Contact> tableConfig = createBasicTableConfig();
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("BASIC TABLE", "By default a table will auto fit columns and allow custom cell content")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .asElement());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
            table.load();
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basicTable()).asElement());
    }

    private void basicFixedTable() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).asElement();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).asElement();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setWidth("200px")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getName())))

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
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setWidth("150px")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).asElement();
                            }
                            return new Text("");
                        }));
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> defaultTable = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("BASIC TABLE - FIXED", "Fixed tables will use the specified column width and will have scrolls when elements exceeds the body height. ")
                .setCollapsible()
                .appendChild(new TableStyleActions(defaultTable))
                .appendChild(defaultTable)
                .asElement());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
            defaultTable.load();
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.fixedBasicTable()).asElement());
    }

    private List<Contact> subList(List<Contact> contacts) {
        return subList(contacts, 0, 15);
    }

    private List<Contact> subList(List<Contact> contacts, int from, int to) {
        return contacts.subList(from, to).stream().map(Contact::new).collect(Collectors.toList());
    }

    private void selectionPlugin() {
        TableConfig<Contact> tableConfig = createBasicTableConfig();
        tableConfig.addPlugin(new SelectionPlugin<>(ColorScheme.LIGHT_BLUE));
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> defaultTable = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("SELECTION PLUGIN", "Enable row selection by adding the selection plugin, pass different selection style colors in the constructor.")
                .setCollapsible()
                .appendChild(new TableStyleActions(defaultTable))
                .appendChild(defaultTable)
                .asElement());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
            defaultTable.load();
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.selectionPlugin()).asElement());
    }

    private void markerPlugin() {
        TableConfig<Contact> tableConfig = createBasicTableConfig();
        tableConfig.addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord())));
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> defaultTable = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("MARKER PLUGIN", "Mark the left side of the row with custom colors")
                .setCollapsible()
                .appendChild(new TableStyleActions(defaultTable))
                .appendChild(defaultTable)
                .asElement());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
            defaultTable.load();
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.markerPlugin()).asElement());
    }

    private void recordDetailsPlugin() {
        TableConfig<Contact> tableConfig = createBasicTableConfig();
        tableConfig.addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).asElement()));
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> defaultTable = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("RECORD DETAILS PLUGIN", "Enable inline record details for rows.")
                .setCollapsible()
                .appendChild(new TableStyleActions(defaultTable))
                .appendChild(defaultTable)
                .asElement());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
            defaultTable.load();
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.recordDetailsPlugin()).asElement());
    }

    private void tableHeaderBarPlugin() {
        TableConfig<Contact> tableConfig = createBasicTableConfig();
        tableConfig.addPlugin(new SelectionPlugin<>());
        tableConfig.addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                .addActionElement(dataTable -> {
                    Button selectInactiveButton = Button.create(Icons.ALL.highlight_off())
                            .linkify()
                            .style().setProperty("padding", "0px")
                            .setHeight("26px")
                            .setColor("black", true)
                            .css(Styles.pull_right, Styles.m_r_15)
                            .get();

                    Tooltip.create(selectInactiveButton, new Text("Select Inactive"));

                    selectInactiveButton.addClickListener(evt -> {
                        dataTable.getTableRows().forEach(tableRow -> {
                            if (!tableRow.getRecord().isActive()) {
                                tableRow.select();
                            } else {
                                tableRow.deselect();
                            }
                        });
                    });

                    return selectInactiveButton.asElement();
                })
                .addActionElement(dataTable -> {
                    Button selectInactiveButton = Button.create(Icons.ALL.check_circle())
                            .linkify()
                            .style().setProperty("padding", "0px")
                            .setHeight("26px")
                            .setColor("black", true)
                            .css(Styles.pull_right, Styles.m_r_15)
                            .get();

                    Tooltip.create(selectInactiveButton, new Text("Select Active"));

                    selectInactiveButton.addClickListener(evt -> {
                        dataTable.getTableRows().forEach(tableRow -> {
                            if (tableRow.getRecord().isActive()) {
                                tableRow.select();
                            } else {
                                tableRow.deselect();
                            }
                        });
                    });

                    return selectInactiveButton.asElement();
                }));

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> defaultTable = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("HEADER BAR PLUGIN", "Adds a title and description for the table, and allow adding elements to the top right side of the table")
                .setCollapsible()
                .appendChild(new TableStyleActions(defaultTable))
                .appendChild(defaultTable)
                .asElement());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts));
            defaultTable.load();
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.headerBarPlugin()).asElement());
    }

    private void sortAndSearch() {
        TableConfig<Contact> tableConfig = createSortableTableConfig();

        LocalListDataStore<Contact> listStore = new LocalListDataStore<>();
        listStore.setRecordsSorter(new ContactSorter());
        listStore.setSearchFilter(new ContactSearchFilter());
        DataTable<Contact> table = new DataTable<>(tableConfig, listStore);

        element.appendChild(Card.create("SORT PLUGIN & SEARCH HEADER ACTION", "Allows the table to fire events useful for datasource to sort and search the data")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .asElement());

        contactListParseHandlers.add(contacts -> {
            listStore.setData(subList(contacts));
            table.load();
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.sortAndSearch()).asElement());
    }

    private void simplePagination() {
        SimplePaginationPlugin<Contact> simplePaginationPlugin = new SimplePaginationPlugin<>(10);//page size
        TableConfig<Contact> tableConfig = createSortableTableConfig();
        tableConfig.addPlugin(simplePaginationPlugin);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        localListDataStore.setRecordsSorter(new ContactSorter());
        localListDataStore.setSearchFilter(new ContactSearchFilter());
        localListDataStore.setPagination(simplePaginationPlugin.getSimplePagination());
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("SIMPLE PAGINATION", "Simple pagination plugin allows the table to fire pagination events helpful for the datasource")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .asElement());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(subList(contacts, 0, 100));
            table.load();
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.simplePagination()).asElement());
    }

    private TableConfig<Contact> createSortableTableConfig() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .sortable()
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).asElement();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).asElement();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getName())))


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
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).asElement();
                            }
                            return new Text("");
                        }));

        tableConfig
                .addPlugin(new SortPlugin<>())
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<Contact>()
                                .addSearchField(SelectOption.create("", "Name, Email"), true)
                                .addSearchField(SelectOption.create("name", "Name"))
                                .addSearchField(SelectOption.create("email", "Email"))
                        )
                );
        return tableConfig;
    }

    private TableConfig<Contact> createBasicTableConfig() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).asElement();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).asElement();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).asElement();
                            }
                            return new Text("");
                        }));
        return tableConfig;
    }

    private void scrollableTable() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .styleCell(cellElement -> Style.of(cellElement).setProperty("vertical-align", "middle"))
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                        .setWidth("70px"))
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setWidth("80px")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).asElement();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).asElement();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getName()))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setWidth("100px")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .styleHeader(head -> Style.of(head).setWidth("100px"))
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center")
                        .maxWidth("120px"))
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setWidth("250px")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getEmail())))
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setWidth("200px")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getPhone())))
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).asElement();
                            }
                            return new Text("");
                        }))
                .addPlugin(new BodyScrollPlugin<>())
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<Contact>()
                                .addSearchField(SelectOption.create("", "Name, Email"), true)
                                .addSearchField(SelectOption.create("name", "Name"))
                                .addSearchField(SelectOption.create("email", "Email"))
                        )
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
                .asElement());

        contactListParseHandlers.add(contacts -> {
            scrollingDataSource.setData(contacts.subList(0, 100));
            table.load();
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.scrollLoading()).asElement());

    }

    private void topPanelPlugin() {
        ContactsTopPanel<Contact> topPanel = new ContactsTopPanel<>();
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .styleCell(cellElement -> Style.of(cellElement).setProperty("vertical-align", "middle"))
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                        .setWidth("70px"))
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setWidth("80px")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle().asElement()).setColor(Color.GREEN_DARKEN_3.getHex()).asElement();
                            } else {
                                return Style.of(Icons.ALL.highlight_off().asElement()).setColor(Color.RED_DARKEN_3.getHex()).asElement();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getName()))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setWidth("100px")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .styleHeader(head -> Style.of(head).setWidth("100px"))
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center")
                        .maxWidth("120px"))
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setWidth("250px")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getEmail())))
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setWidth("200px")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getPhone())))
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).asElement();
                            }
                            return new Text("");
                        }))
                .addPlugin(new BodyScrollPlugin<>())
                .addPlugin(new TopPanelPlugin<Contact>() {

                    @Override
                    public HTMLElement asElement() {
                        return topPanel.asElement();
                    }

                    @Override
                    public void handleEvent(TableEvent event) {
                        if (TableDataUpdatedEvent.DATA_UPDATED.equals(event.getType())) {
                            topPanel.update((TableDataUpdatedEvent<Contact>) event);
                        }
                    }
                })
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<Contact>()
                                .addSearchField(SelectOption.create("", "Name, Email"), true)
                                .addSearchField(SelectOption.create("name", "Name"))
                                .addSearchField(SelectOption.create("email", "Email"))
                        )
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
                .asElement());

        contactListParseHandlers.add(contacts -> {
            List<Contact> data = subList(contacts, 0, 100);
            scrollingDataSource.setData(data);
            table.load();
            topPanel.update(data);
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.topPanelPlugin()).asElement());

    }

    private void allInOne() {
        ContactsTopPanel<Contact> topPanel = new ContactsTopPanel<>();
        SimplePaginationPlugin<Contact> simplePaginationPlugin = new SimplePaginationPlugin<>(10);
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .styleCell(cellElement -> Style.of(cellElement).setProperty("vertical-align", "middle"))
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                        .setWidth("70px"))
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setWidth("80px")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle().asElement()).setColor(Color.GREEN_DARKEN_3.getHex()).asElement();
                            } else {
                                return Style.of(Icons.ALL.highlight_off().asElement()).setColor(Color.RED_DARKEN_3.getHex()).asElement();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getName()))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setWidth("100px")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .styleHeader(head -> Style.of(head).setWidth("100px"))
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center")
                        .maxWidth("120px"))
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setWidth("250px")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getEmail())))
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setWidth("200px")
                        .setCellRenderer(cell -> new Text(cell.getTableRow().getRecord().getPhone())))
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).asElement();
                            }
                            return new Text("");
                        }))
                .addPlugin(simplePaginationPlugin)
                .addPlugin(new TopPanelPlugin<Contact>() {

                    @Override
                    public HTMLElement asElement() {
                        return topPanel.asElement();
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
                            Button selectInactiveButton = Button.create(Icons.ALL.highlight_off())
                                    .linkify()
                                    .style()
                                    .setProperty("padding", "0px")
                                    .setHeight("26px")
                                    .setColor("black", true)
                                    .css(Styles.pull_right, Styles.m_r_15)
                                    .get();

                            Tooltip.create(selectInactiveButton.asElement(), new Text("Select Inactive"));

                            selectInactiveButton.addClickListener(evt -> {
                                dataTable.getTableRows().forEach(tableRow -> {
                                    if (!tableRow.getRecord().isActive()) {
                                        tableRow.select();
                                    } else {
                                        tableRow.deselect();
                                    }
                                });
                            });

                            return selectInactiveButton.asElement();
                        })
                        .addActionElement(dataTable -> {
                            Button selectInactiveButton = Button.create(Icons.ALL.check_circle())
                                    .linkify()
                                    .style()
                                    .setProperty("padding", "0px")
                                    .setHeight("26px")
                                    .setColor("black", true)
                                    .css(Styles.pull_right, Styles.m_r_15)
                                    .get();

                            Tooltip.create(selectInactiveButton.asElement(), new Text("Select Active"));

                            selectInactiveButton.addClickListener(evt -> {
                                dataTable.getTableRows().forEach(tableRow -> {
                                    if (tableRow.getRecord().isActive()) {
                                        tableRow.select();
                                    } else {
                                        tableRow.deselect();
                                    }
                                });
                            });

                            return selectInactiveButton.asElement();
                        })
                        .addActionElement(new HeaderBarPlugin.SearchTableAction<Contact>()
                                .addSearchField(SelectOption.create("", "Name, Email"), true)
                                .addSearchField(SelectOption.create("name", "Name"))
                                .addSearchField(SelectOption.create("email", "Email"))
                        )
                )
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).asElement()))
                .addPlugin(new SelectionPlugin<>(ColorScheme.BLUE))
                .addPlugin(new RowMarkerPlugin<>(cellInfo -> ContactUiUtils.getBalanceColor(cellInfo.getRecord())))

                .addPlugin(new SortPlugin<>());

        LocalListDataStore<Contact> localListDataSource = new LocalListDataStore<Contact>()
                .setSearchFilter(new ContactSearchFilter())
                .setRecordsSorter(new ContactSorter())
                .setPagination(simplePaginationPlugin.getSimplePagination());

        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataSource);

        element.appendChild(Card.create("ALL IN ONE", "Try all plugins and feature works together.")
                .setCollapsible()
                .appendChild(new TableStyleActions(table))
                .appendChild(table)
                .asElement());

        contactListParseHandlers.add(contacts -> {
            List<Contact> data = subList(contacts, 0, 100);
            localListDataSource.setData(data);
            table.load();
            topPanel.update(data);
        });

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.allInOne()).asElement());
    }

    public interface ContactListParseHandler {
        void onContactsParsed(List<Contact> contacts);
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}