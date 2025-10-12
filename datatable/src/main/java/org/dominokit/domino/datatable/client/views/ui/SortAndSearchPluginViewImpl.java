package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;

import static org.dominokit.domino.ui.utils.Domino.*;

import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.SortAndSearchPluginsProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.ContactSearchFilter;
import org.dominokit.domino.datatable.client.views.model.ContactSorter;
import org.dominokit.domino.datatable.client.views.model.Gender;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.events.SortEvent;
import org.dominokit.domino.ui.datatable.plugins.header.BordersTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.ClearSearch;
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnFilterMeta;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.datatable.plugins.filter.header.*;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.SearchTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;

@UiView(presentable = SortAndSearchPluginsProxy.class)
@SampleClass(includeClassName = true)
public class SortAndSearchPluginViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

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

        sortAndSearch();
        element.appendChild(CodeCard.createLazyCodeCard(SortAndSearchPluginViewImpl_CodeResource.INSTANCE.sortAndSearch()));

        return element.element();
    }

    @SampleMethod
    private void sortAndSearch() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getIndex() + 1 + "")))
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                cell.appendChild(Icons.check_circle().addCss(dui_fg_green_d_3));
                            } else {
                                cell.appendChild(Icons.close_circle().addCss(dui_fg_red_d_3));
                            }
                        })
                        .applyMeta(ColumnFilterMeta.of(BooleanHeaderFilter.<Contact>create("Active", "Inactive", "Both")))
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getName())))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER)
                        .applyMeta(ColumnFilterMeta.of(EnumHeaderFilter.<Contact, Gender>create(Gender.values())))
                )
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER)
                        .applyMeta(ColumnFilterMeta.of(SelectHeaderFilter.<Contact>create()
                                .withSelect((parent, self) -> {
                                    self.<String>appendItems(item -> SelectOption.<String>create(item, item, item), "blue", "brown", "green");
                                })
                                .appendChild(SelectOption.create("blue", "blue", "Blue"))
                                .appendChild(SelectOption.create("brown", "brown", "Brown"))
                                .appendChild(SelectOption.create("green", "green", "Green"))
                        ))
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                        .applyMeta(ColumnFilterMeta.of(DoubleHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getEmail())))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getPhone())))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                cell.appendChild(Badge.create("Young")
                                        .addCss(dui_green, dui_float_none));
                            } else {
                                cell.appendChild(text(""));
                            }
                        }));

        ColumnHeaderFilterPlugin<Contact> contactColumnHeaderFilterPlugin = ColumnHeaderFilterPlugin.<Contact>create();
        tableConfig
                .addPlugin(new SortPlugin<Contact>()
                        .configure(sortPluginConfig -> {
                            sortPluginConfig.setShowIconOnSortedColumnOnly(true);
                            sortPluginConfig.setShowSortOptionsInColumnMenu(true);
                        }))
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(Icons.filter_menu_outline()
                                    .clickable()
                                    .addClickListener(evt -> contactColumnHeaderFilterPlugin.getFiltersRowElement()
                                            .toggleDisplay())))
                            .appendChild(PostfixAddOn.of(ClearSearch.create(datatable)))
                            .appendChild(PostfixAddOn.of(SearchTableAction.create(datatable)
                                    .withSearchBox((parent, searchBox) -> {
                                        searchBox.addCss(dui_max_w_64, dui_bg_dominant_d_1, dui_rounded_md);
                                    })))

                    ;
                }))
                .addPlugin(contactColumnHeaderFilterPlugin);

        LocalListDataStore<Contact> listStore = new LocalListDataStore<>();
        listStore.setRecordsSorter(new ContactSorter());
        listStore.setSearchFilter(new ContactSearchFilter());
        DataTable<Contact> table = new DataTable<>(tableConfig, listStore);

        element.appendChild(Card.create("SORT PLUGIN & SEARCH HEADER ACTION", "Allows the table to fire events useful for datasource to sort and search the data")
                .setCollapsible(true)
                .appendChild(table)
                .element());

        listStore.setData(ContactsProvider.instance.subList());
    }

}
