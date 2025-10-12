package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import static org.dominokit.domino.ui.utils.Domino.*;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.PaginationPluginProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.ContactSearchFilter;
import org.dominokit.domino.datatable.client.views.model.ContactSorter;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.header.BordersTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.ClearSearch;
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.SearchTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.plugins.pagination.AdvancedPaginationPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.ScrollingPaginationPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SimplePaginationPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;

@UiView(presentable = PaginationPluginProxy.class)
@SampleClass(includeClassName = true)
public class PaginationPluginViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("datatable", this.getClass()));
        element.appendChild(BlockHeader.create("DATA TABLES", "For detailed demo code please visit: ")
                .appendChild(a()
                        .setAttribute("href", "https://github.com/DominoKit/domino-ui-demo/tree/master/datatable")
                        .setAttribute("target", "_blank")
                        .textContent("Data table demo source code"))
        );

        simplePagination();
        element.appendChild(CodeCard.createLazyCodeCard(PaginationPluginViewImpl_CodeResource.INSTANCE.simplePagination()));

        scrollingPagination();
        element.appendChild(CodeCard.createLazyCodeCard(PaginationPluginViewImpl_CodeResource.INSTANCE.scrollingPagination()));

        advancedPagination();
        element.appendChild(CodeCard.createLazyCodeCard(PaginationPluginViewImpl_CodeResource.INSTANCE.advancedPagination()));

        return element.element();
    }

    @SampleMethod
    private void simplePagination() {
        SimplePaginationPlugin<Contact> simplePaginationPlugin = new SimplePaginationPlugin<>(10);//page size
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getIndex() + 1 + ""))))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                cell.appendChild(Icons.check_circle().addCss(dui_fg_green_d_3));
                            } else {
                                cell.appendChild(Icons.close_circle().addCss(dui_fg_red_d_3));
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getName()))))

                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord()))))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getEmail()))))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getPhone()))))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                cell.appendChild(Badge.create("Young")
                                        .addCss(dui_green, dui_float_none));
                            }else {
                            cell.appendChild(text("")); }
                        }));

        tableConfig
                .addPlugin(new SortPlugin<>())
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(ClearSearch.create(datatable)))
                            .appendChild(PostfixAddOn.of(SearchTableAction.create(datatable)
                                    .withSearchBox((parent, searchBox) -> {
                                searchBox.addCss(dui_max_w_64, dui_bg_dominant_d_1, dui_rounded_md);
                            })));
                }))
                .addPlugin(simplePaginationPlugin);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        localListDataStore.setRecordsSorter(new ContactSorter());
        localListDataStore.setSearchFilter(new ContactSearchFilter());
        localListDataStore.setPagination(simplePaginationPlugin.getSimplePagination());
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("SIMPLE PAGINATION", "Simple pagination plugin allows the table to fire pagination events helpful for the datasource")
                .setCollapsible(true)
                .appendChild(table)
                .element());

        localListDataStore.setData(ContactsProvider.instance.subList(50));
    }

    @SampleMethod
    private void scrollingPagination() {
        ScrollingPaginationPlugin<Contact> scrollingPagination = new ScrollingPaginationPlugin<>(10, 5);//page size
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getIndex() + 1 + ""))))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                cell.appendChild(Icons.check_circle().addCss(dui_fg_green_d_3));
                            } else {
                                cell.appendChild(Icons.close_circle().addCss(dui_fg_red_d_3));
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getName())))

                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord()))))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getEmail()))))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getPhone()))))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                cell.appendChild(Badge.create("Young")
                                        .addCss(dui_green, dui_float_none));
                            }else{
                            cell.appendChild(text(""));
                            }
                        })));

        tableConfig
                .addPlugin(new SortPlugin<>())
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(ClearSearch.create(datatable)))
                            .appendChild(PostfixAddOn.of(SearchTableAction.create(datatable)
                                    .withSearchBox((parent, searchBox) -> {
                                        searchBox.addCss(dui_max_w_64, dui_bg_dominant_d_1, dui_rounded_md);
                                    })));
                }))
                .addPlugin(scrollingPagination);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        localListDataStore.setRecordsSorter(new ContactSorter());
        localListDataStore.setSearchFilter(new ContactSearchFilter());
        localListDataStore.setPagination(scrollingPagination.getPagination());
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("SCROLLING PAGINATION", "Scrolling pagination plugin allows navigation through a set of page at a time in datatable")
                .setCollapsible(true)
                .appendChild(table)
                .element());

        localListDataStore.setData(ContactsProvider.instance.subList(50));
    }

    @SampleMethod
    private void advancedPagination() {
        AdvancedPaginationPlugin<Contact> advancedPagination = new AdvancedPaginationPlugin<>(10);//page size
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getIndex() + 1 + ""))))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                cell.appendChild(Icons.check_circle().addCss(dui_fg_green_d_3));
                            } else {
                                cell.appendChild(Icons.close_circle().addCss(dui_fg_red_d_3));
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getName()))))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord()))))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getEmail()))))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getPhone()))))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                cell.appendChild(Badge.create("Young")
                                        .addCss(dui_green, dui_float_none));
                            }else{
                            cell.appendChild(text(""));}
                        }));

        tableConfig
                .addPlugin(new SortPlugin<>())
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(ClearSearch.create(datatable)))
                            .appendChild(PostfixAddOn.of(SearchTableAction.create(datatable)
                                    .withSearchBox((parent, searchBox) -> {
                                        searchBox.addCss(dui_max_w_64, dui_bg_dominant_d_1, dui_rounded_md);
                                    })));
                }))
                .addPlugin(advancedPagination);

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        localListDataStore.setRecordsSorter(new ContactSorter());
        localListDataStore.setSearchFilter(new ContactSearchFilter());
        localListDataStore.setPagination(advancedPagination.getPagination());
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("ADVANCED PAGINATION", "Advanced pagination plugin allows navigation through pages from a dropdown list")
                .setCollapsible(true)
                .appendChild(table)
                .element());

        localListDataStore.setData(ContactsProvider.instance.subList(50));
    }

}
