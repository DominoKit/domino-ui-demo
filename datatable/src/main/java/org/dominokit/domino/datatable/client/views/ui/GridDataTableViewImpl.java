package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.GridDatatableProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.datagrids.CheckableDataListItem;
import org.dominokit.domino.datatable.client.views.datagrids.DataList;
import org.dominokit.domino.datatable.client.views.datagrids.DataListItem;
import org.dominokit.domino.datatable.client.views.grid.DivWindowItem;
import org.dominokit.domino.datatable.client.views.grid.TestVirtualScrollPanel;
import org.dominokit.domino.datatable.client.views.gridtable.CellTextAlign;
import org.dominokit.domino.datatable.client.views.gridtable.ColumnConfig;
import org.dominokit.domino.datatable.client.views.gridtable.DataTable;
import org.dominokit.domino.datatable.client.views.gridtable.TableConfig;
import org.dominokit.domino.datatable.client.views.gridtable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.datatable.client.views.gridtable.store.LocalListDataStore;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;
import org.dominokit.domino.ui.utils.Unit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.dominokit.domino.ui.utils.Domino.*;

@UiView(presentable = GridDatatableProxy.class)
@SampleClass(includeClassName = true)
public class GridDataTableViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

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

        dataList();
//        datagrid();


//        gridTable();
//        element.appendChild(CodeCard.createLazyCodeCard(GridDataTableViewImpl_CodeResource.INSTANCE.gridTable()));

        return element.element();
    }

    private void datagrid() {
        TestVirtualScrollPanel scrollPanel = new TestVirtualScrollPanel(DivWindowItem::new);
        element.appendChild(Card.create("Data Grid")
                .appendChild(div().setHeight("750px")
                        .appendChild(scrollPanel)
                )
        );

        List<Integer> intList = IntStream.range(0, 100)
                .boxed()
                .collect(Collectors.toList());

        scrollPanel.setItems(intList);
    }

    private void dataList() {
        DataList<DemoContact> scrollPanel = new DataList<DemoContact>(record ->
                CheckableDataListItem.create(record.getFirstName(), record)
                        .appendChild(small().textContent(record.getEmail()))
                        .appendChild(PrefixAddOn.of(Icons.drag_vertical()))
                        .appendChild(PostfixAddOn.of(Icons.information_outline()))
                        .addCss(dui_p_2, dui_border_b_grey_l_2, dui_border_b, dui_border_0, dui_border_solid)
        )

                .setIcon(Icons.file())
                .setTitle("Files")
                .setMultiSelect(true)
                .withHeader((menu, header) -> header
                        .appendChild(PostfixAddOn.of(Icons.folder_key_outline()
                                        .addCss(dui_font_size_5)
                                        .clickable()
                                        .addClickListener(evt -> {
                                            Notification.create("Action clicked").show();
                                        })
                                )
                        )
                        .appendChild(PostfixAddOn.of(Icons.folder_heart_outline()
                                        .addCss(dui_font_size_5)
                                        .clickable()
                                        .addClickListener(evt -> {
                                            Notification.create("Action clicked").show();
                                        })
                                )
                        )
                        .appendChild(PostfixAddOn.of(Icons.check_all()
                                        .addCss(dui_font_size_5)
                                        .clickable()
                                        .addClickListener(evt -> menu.selectAll())
                                )
                        )
                )
                .setSearchable((record, token, caseSensitive) -> {
                    if (caseSensitive) {
                        return (record.getFirstName()).contains(token);
                    }
                    return (record.getFirstName()).toLowerCase().contains(token.toLowerCase());
                });
        element.appendChild(Card.create("Data List")
                .appendChild(div().setHeight("500px")
                        .appendChild(scrollPanel.setWidth("500px"))
                )
        );

        scrollPanel.setItems(ContactGenerator.generateContacts(500000));
    }

    @SampleMethod
    private void gridTable() {
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setHeaderTextAlign(CellTextAlign.RIGHT)
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getIndex() + 1 + ""))

                )

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .setTextAlign(CellTextAlign.CENTER)
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Icons.check_circle().addCss(dui_fg_green_d_3).element();
                            } else {
                                return Icons.close_circle().addCss(dui_fg_red_d_2).element();
                            }
                        })
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getName()))
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                )

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .setTextAlign(CellTextAlign.CENTER)
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord()))
                )

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getEmail()))
                )

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> text(cell.getTableRow().getRecord().getPhone()))
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .addCss(dui_bg_green, dui_float_none).element();
                            }
                            return text();
                        })
                )
                .addPlugin(new HeaderBarPlugin<Contact>("Demo table", "Sample table table demonstrating the feature")
                        .addActionElement(new HeaderBarPlugin.HoverTableAction<>())
                        .addActionElement(new HeaderBarPlugin.CondenseTableAction<>())
                        .addActionElement(new HeaderBarPlugin.StripesTableAction<>())
                        .addActionElement(new HeaderBarPlugin.BordersTableAction<>())
                )
        ;

        tableConfig.addPlugin(
                new HeaderBarPlugin<Contact>("", "")
                        .addActionElement(
                                new HeaderBarPlugin.SearchTableAction<Contact>()
                                        .withSearchBox(
                                                (parent, searchBox) -> {
                                                    searchBox.getClearIcon().removeTooltip();
                                                    searchBox.getSearchIcon().hide();
                                                    searchBox.addCss(dui_max_w_64, dui_bg_dominant_l_1, dui_rounded_md);
                                                })));

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);

        element.appendChild(Card.create("BASIC TABLE", "By default a table will auto fit columns and allow custom cell content")
                .setCollapsible(true)
                .appendChild(Button.create("Update width").addClickListener(evt -> {
                    table.getTableConfig()
                            .getColumns()
                            .forEach(column -> {
                                table.getForm().clearElement();

                                table.getRows()
                                        .forEach(row -> {
                                            Node node = row.getCell(column.getName()).getCellInfo().getElement().element().cloneNode(true);
                                            table.getForm().appendChild(node);
                                        });
                                int offsetWidth = table.getForm().element().offsetWidth;
                                int originalWidth = column.getHeadElement().element().offsetWidth;
                                if (offsetWidth > originalWidth) {
                                    table.getTableConfig().getColumnByName(column.getName())
                                            .setWidth(Unit.px.of(offsetWidth));
                                    table.getTableConfig().updateGridColumnsTemplate();
                                }
                            });
                    table.getForm().remove();
                }))
                .appendChild(table)
                .element());

        localListDataStore.setData(ContactsProvider.instance.subList());
    }

}
