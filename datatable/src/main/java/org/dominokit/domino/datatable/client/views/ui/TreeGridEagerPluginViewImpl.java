package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.TreeGridEagerPluginProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.ContactSearchFilter;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.CellRenderer;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.RowCellInfo;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnFilterMeta;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.datatable.plugins.filter.header.TextHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.header.BordersTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.plugins.marker.RowMarkerPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsRenderer;
import org.dominokit.domino.ui.datatable.plugins.selection.SelectionPlugin;
import org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin;
import org.dominokit.domino.ui.datatable.plugins.tree.store.LocalTreeDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.TDElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;

import java.util.Collections;
import java.util.Optional;

import static org.dominokit.domino.ui.datatable.DataTableStyles.dui_datatable_td;
import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_green_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_float_none;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_m_0;
import static org.dominokit.domino.ui.utils.Domino.p;
import static org.dominokit.domino.ui.utils.Domino.td;
import static org.dominokit.domino.ui.utils.Domino.text;

@UiView(presentable = TreeGridEagerPluginProxy.class)
@SampleClass(includeClassName = true)
public class TreeGridEagerPluginViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

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

        treeGridFullParentSpan();
        element.appendChild(CodeCard.createLazyCodeCard(TreeGridEagerPluginViewImpl_CodeResource.INSTANCE.treeGridFullParentSpan()));

        treeGridParentColumns();
        element.appendChild(CodeCard.createLazyCodeCard(TreeGridEagerPluginViewImpl_CodeResource.INSTANCE.treeGridParentColumns()));

        return element.element();
    }

    @SampleMethod
    private void treeGridFullParentSpan() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
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
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                )

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getEmail())))
                )

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
                        }))
                .onUtilityColumn(utilityColumn -> {
                    utilityColumn
                            .setTitle("First name")
                            .setSortable(true, "id");
                })
                .setMultiSelect(true)
                .addPlugin(ColumnHeaderFilterPlugin.<Contact>create())
                .addPlugin(new SortPlugin<>())
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RecordDetailsPlugin<>((RecordDetailsRenderer<Contact>)  cell -> cell.appendChild(new ContactDetails(cell))))
                .addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord()).color().getContextColor()))
                .addPlugin(new TreeGridPlugin<Contact>()
                        .configure(config -> {
                            config
                                    .setIndentColumnElementSupplier(tableRow -> p(tableRow.getRecord().getName()).addCss(dui_m_0).element())
                                    .setParentRowCellsSupplier((dataTable, tableRow) -> {
                                        TDElement cellElement = td().addCss(dui_datatable_td)
                                                .setAttribute("colspan", "8");
                                        RowCell<Contact> rowCell =
                                                new RowCell<>(new RowCellInfo<>(tableRow, cellElement.element()), dataTable.getTableConfig().getColumnByName("id"));
                                        return Collections.singletonList(rowCell);
                                    })
                                    .setIndent(60)
                                    .setLazy(false);
                        })
                )
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)));
                }));

        LocalTreeDataStore<Contact> localListDataStore = new LocalTreeDataStore<>((parent, itemsConsumer) -> {
            ContactsProvider.instance.addFriends(parent, 2, 1, 2);
            itemsConsumer.accept(Optional.ofNullable(parent.getFriends()));
        });

        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("TREE GRID PLUGIN - Full PARENT SPAN", "Render records in tree style with expand and collapse features")
                .setCollapsible(true)
                .appendChild(table)
                .element());

            localListDataStore.setData(ContactsProvider.instance.subList(10));
    }

    @SampleMethod
    private void treeGridParentColumns() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
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
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord()))))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getEmail())))
                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                )

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
                        }))
                .onUtilityColumn(utilityColumn -> {
                    utilityColumn
                            .setSortable(true, "id")
                            .setTitle("First name");
                })
                .setMultiSelect(true)
                .addPlugin(ColumnHeaderFilterPlugin.<Contact>create())
                .addPlugin(new SortPlugin<>())
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RecordDetailsPlugin<>((RecordDetailsRenderer<Contact>) cell -> cell.appendChild(new ContactDetails(cell))))
                .addPlugin(new RowMarkerPlugin<>(tableCellInfo -> ContactUiUtils.getBalanceColor(tableCellInfo.getRecord()).color().getContextColor()))
                .addPlugin(new TreeGridPlugin<Contact>()
                        .configure(config -> {
                            config.setIndentColumnElementSupplier(tableRow -> p(tableRow.getRecord().getName()).addCss(dui_m_0).element())
                                    .setIndent(60);
                        })
                )
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)));
                }));

        LocalTreeDataStore<Contact> localListDataStore = new LocalTreeDataStore<>((parent, itemsConsumer) -> {
            ContactsProvider.instance.addFriends(parent, 2, 1, 2);
            itemsConsumer.accept(Optional.ofNullable(parent.getFriends()));
        });
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);
        localListDataStore.setSearchFilter(new ContactSearchFilter());
        element.appendChild(Card.create("TREE GRID PLUGIN - PARENT WITH COLUMNS", "Render records in tree style with expand and collapse features")
                .setCollapsible(true)
                .appendChild(table)
                .element());

        localListDataStore.setData(ContactsProvider.instance.subList(10));
    }

}
