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
import org.dominokit.domino.ui.datatable.store.RecordsSorter;
import org.dominokit.domino.ui.datatable.store.SearchFilter;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = DatatablePresenter.class)
public class DatatableViewImpl extends ComponentView<HTMLDivElement> implements DatatableView {

    private HTMLDivElement element = div().asElement();
    private ContactsTopPanel<Contact> topPanel = new ContactsTopPanel<>();
    private List<ContactListParseHandler> contactListParseHandlers = new ArrayList<>();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("DATA TABLES").asElement());
        basicTable();
        scrollableTable();
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
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> defaultTable = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("BASIC TABLE", "By default a table will auto fit columns and allow custom cell content")
                .appendContent(new TableStyleActions(defaultTable))
                .appendContent(defaultTable.asElement())
                .asElement());

        contactListParseHandlers.add(contacts -> {
            localListDataStore.setData(contacts.subList(0, 15));
            defaultTable.load();
        });
    }

    private void scrollableTable() {


        SimplePaginationPlugin<Contact> simplePagination = new SimplePaginationPlugin<>(10);
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
                .addPlugin(new TableActionsPlugin<Contact>("Demo table", "this a sample table with all features")
                        .addActionElement(new TableActionsPlugin.CondenseTableAction<>())
                        .addActionElement(new TableActionsPlugin.StripesTableAction<>())
                        .addActionElement(new TableActionsPlugin.BordersTableAction<>())
                        .addActionElement(new TableActionsPlugin.HoverTableAction<>())
                        .addActionElement(new TableActionsPlugin.SearchTableAction<>())
                )
                .addPlugin(new RecordDetailsPlugin<>(cell -> new ContactDetails(cell).asElement()))
                .addPlugin(new SelectionPlugin<>(ColorScheme.BLUE))
                .addPlugin(new RowMarkerPlugin<>(cellInfo -> ContactUiUtils.getBalanceColor(cellInfo.getRecord())))

                .addPlugin(simplePagination)
                .addPlugin(new DataTableSortPlugin<>());

//        try {

        SearchFilter<Contact> localSearch = new ContactSearchFilter();
        RecordsSorter<Contact> localSorter = new ContactSorter();
        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<Contact>()
                .setSearchFilter(localSearch)
                .setPagination(simplePagination.getSimplePagination())
                .setRecordsSorter(localSorter);

        LocalListScrollingDataSource<Contact> scrollingDataSource = new LocalListScrollingDataSource<Contact>(10)
                .setSearchFilter(localSearch)
                .setRecordsSorter(localSorter);

        DataTable<Contact> dataTable = new DataTable<>(tableConfig, scrollingDataSource);

        element.appendChild(Card.create("SIMPLE TABLE")
                .appendContent(dataTable.asElement())
                .asElement());
        element.appendChild(Card.create("test", "test").asElement());

//            CodeResource.INSTANCE.generatedJson().getText(new ResourceCallback<TextResource>() {
//                @Override
//                public void onError(ResourceException e) {
//                    DomGlobal.console.error("could not load json", e);
//                }
//
//                @Override
//                public void onSuccess(TextResource resource) {
//                    ContactList contactList = ContactList.MAPPER.read(resource.getText());
//
//                    localListDataStore.setData(contactList.getContacts());
//                    scrollingDataSource.setData(contactList.getContacts());
//                    dataTable.load();
//                    topPanel.update(contactList.getContacts());
//                }
//            });
//        } catch (ResourceException e) {
//            DomGlobal.console.error("could not load json", e);
//        }
    }

    public interface ContactListParseHandler {
        void onContactsParsed(List<Contact> contacts);
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}