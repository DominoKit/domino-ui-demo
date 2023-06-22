package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.ColumnsGroupsProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta;
import org.dominokit.domino.ui.datatable.plugins.column.PinColumnsPlugin;
import org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnMeta;
import org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnsPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = ColumnsGroupsProxy.class)
@SampleClass(includeClassName = true)
public class ColumnsGroupsViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

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

        groupColumns();
        element.appendChild(CodeCard.createLazyCodeCard(ColumnsGroupsViewImpl_CodeResource.INSTANCE.groupColumns()));

        groupPinResizeColumns();
        element.appendChild(CodeCard.createLazyCodeCard(ColumnsGroupsViewImpl_CodeResource.INSTANCE.groupPinResizeColumns()));

        return element.element();
    }

    @SampleMethod
    private void groupColumns() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("personalInfo", "Personal info")
                        .addColumn(ColumnConfig.<Contact>create("identity", "Identity")
                                .addColumn(ColumnConfig.<Contact>create("id", "#")
                                        .setTextAlign(CellTextAlign.RIGHT)
                                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                                )
                                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getName()))
                                )
                        )
                        .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                                .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                                .setTextAlign(CellTextAlign.CENTER)
                        )
                        .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                                .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                                .setTextAlign(CellTextAlign.CENTER)
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Icons.check_circle().addCss(dui_fg_green_d_3).element();
                            } else {
                                return Icons.close_circle().addCss(dui_fg_red_d_3).element();
                            }
                        })
                )

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                )
                .addColumn(ColumnConfig.<Contact>create("contact", "Contact")
                        .addColumn(ColumnConfig.<Contact>create("email", "Email")
                                .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail()))
                        )

                        .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                                .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone()))
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .addCss(dui_green, dui_float_none)
                                        .element();
                            }
                            return text("");
                        })
                )
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                );

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);
        element.appendChild(Card.create("GROUP COLUMNS", "Group columns together for resize and pinning.")
                .setCollapsible(true)
                .appendChild(table)
                .element());

            localListDataStore.setData(ContactsProvider.instance.subList());
    }


    @SampleMethod
    private void groupPinResizeColumns() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("identity", "Identity")
                        .addColumn(ColumnConfig.<Contact>create("id", "#")
                                .applyMeta(ResizeColumnMeta.create(false))
                                .setTextAlign(CellTextAlign.RIGHT)
                                .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getIndex() + 1 + ""))
                        )
                        .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                                .setWidth("200px")
                                .minWidth("100px")
                                .maxWidth("400px")
                                .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getName()))
                        )
                        .applyMeta(PinColumnMeta.left())
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                )
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                )
                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Icons.check_circle().addCss(dui_fg_green_d_3).element();
                            } else {
                                return Icons.close_circle().addCss(dui_fg_red_d_3).element();
                            }
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                )
                .addColumn(ColumnConfig.<Contact>create("contact", "Contact")
                        .addColumn(ColumnConfig.<Contact>create("email", "Email")
                                .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail()))
                        )

                        .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                                .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone()))
                        )
                ).addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                                        .setCellRenderer(cell -> {
                                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                                return Badge.create("Young")
                                                        .addCss(dui_green, dui_float_none)
                                                        .element();
                                            }
                                            return text("");
                                        })
                                )
                        )
                )
                .addPlugin(new PinColumnsPlugin<Contact>()
                        .configure(config -> config
                                .setShowPinIcon(true)
                                .setShowPinMenu(true))
                )
                .addPlugin(new ResizeColumnsPlugin<>())
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                )
        ;

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);
        element.appendChild(Card.create("GROUP, PIN, RESIZE COLUMNS", "Column groups works with ping and resize plugins.")
                .setCollapsible(true)
                .appendChild(table)
                .element());

            localListDataStore.setData(ContactsProvider.instance.subList());
    }

}
