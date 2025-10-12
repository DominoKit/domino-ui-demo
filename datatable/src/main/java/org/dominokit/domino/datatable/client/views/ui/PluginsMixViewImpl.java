package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.PluginsMixProxy;
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
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnFilterMeta;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.datatable.plugins.column.PinColumnMeta;
import org.dominokit.domino.ui.datatable.plugins.column.PinColumnsPlugin;
import org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnsPlugin;
import org.dominokit.domino.ui.datatable.plugins.filter.header.BooleanHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.DoubleHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.EnumHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.SelectHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.TextHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.grouping.GroupingPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.BordersTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.TopPanelPlugin;
import org.dominokit.domino.ui.datatable.plugins.marker.RowMarkerPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.ScrollingPaginationPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.plugins.row.RecordDetailsRenderer;
import org.dominokit.domino.ui.datatable.plugins.selection.SelectionPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.DominoEvent;
import org.dominokit.domino.ui.utils.PostfixAddOn;

import java.util.List;

import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_align_middle;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_accent_d_1;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_accent_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_green_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_red_d_3;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_float_none;
import static org.dominokit.domino.ui.utils.Domino.dui_green;
import static org.dominokit.domino.ui.utils.Domino.dui_p_1;
import static org.dominokit.domino.ui.utils.Domino.dui_w_24;
import static org.dominokit.domino.ui.utils.Domino.elementOf;
import static org.dominokit.domino.ui.utils.Domino.text;

@UiView(presentable = PluginsMixProxy.class)
@SampleClass(includeClassName = true)
public class PluginsMixViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("datatable", this.getClass()));
        element.appendChild(BlockHeader.create("DATA TABLES", "For detailed demo code please visit: ")
                .appendChild(a()
                        .setAttribute("href", "https://github.com/DominoKit/domino-ui-demo/tree/master/datatable")
                        .setAttribute("target", "_blank")
                        .textContent("Data table demo source code")));

        allInOne();
        element.appendChild(CodeCard.createLazyCodeCard(PluginsMixViewImpl_CodeResource.INSTANCE.allInOne()));

        return element.element();
    }

    @SampleMethod
    private void allInOne() {
        ContactsTopPanel<Contact> topPanel = new ContactsTopPanel<>();
        ScrollingPaginationPlugin<Contact> scrollingPaginationPlugin = new ScrollingPaginationPlugin<>(10, 5);
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .onCellReady(cell-> cell.addCss(dui_align_middle))
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getIndex() + 1 + "")))
                        .setWidth("70px")
                )
                .addColumn(ColumnConfig.<Contact>create("group 1", "Group 1")
                        .addColumn(ColumnConfig.<Contact>create("status", "Status")
                                .setWidth("80px")
                                .setTextAlign(CellTextAlign.CENTER)
                                .setRenderer(cell -> {
                                    if (cell.getTableRow().getRecord().isActive()) {
                                        cell.appendChild(Icons.check_circle().addCss(dui_fg_green_d_3));
                                    } else {
                                        cell.appendChild(Icons.close_circle().addCss(dui_fg_red_d_3));
                                    }
                                })
                                .applyMeta(ColumnFilterMeta.of(BooleanHeaderFilter.<Contact>create("Active", "Inactive", "Both")))
                                .applyMeta(PinColumnMeta.left())

                        )
                        .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                                .sortable()
                                .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getName())))
                                .setWidth("200px")
                                .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("group 2", "Group 2")
                        .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                                .setWidth("100px")
                                .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                                .setTextAlign(CellTextAlign.CENTER)
                                .applyMeta(ColumnFilterMeta.of(EnumHeaderFilter.<Contact, Gender>create(Gender.values())))
                        )
                        .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                                .onHeaderReady(column-> column.getHeadElement().addCss(dui_w_24))
                                .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                                .setTextAlign(CellTextAlign.CENTER)
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
                                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                                        .setWidth("200px")
                                        .applyMeta(ColumnFilterMeta.of(DoubleHeaderFilter.<Contact>create()))
                                )
                                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                                        .setWidth("250px")
                                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getEmail())))
                                        .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                                )
                        )
                        .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                                .setWidth("200px")
                                .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getPhone())))
                                .applyMeta(ColumnFilterMeta.of(TextHeaderFilter.<Contact>create()))
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                cell.appendChild(Badge.create("Young")
                                        .addCss(dui_green, dui_float_none));
                            }else{
                            cell.appendChild(text(""));
                            }
                        })
                        .applyMeta(PinColumnMeta.right())
                )
                .addPlugin(scrollingPaginationPlugin)
                .addPlugin(new TopPanelPlugin<Contact>() {

                    @Override
                    public HTMLElement element() {
                        return topPanel.element();
                    }

                    @Override
                    public void handleEvent(DominoEvent event) {
                        if (TableDataUpdatedEvent.DATA_UPDATED.equals(event.getType())) {
                            topPanel.update((TableDataUpdatedEvent<Contact>) event);
                        }
                    }
                })
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(Icons.close_circle()
                                    .clickable()
                                    .setTooltip("Select Inactive")
                                    .addClickListener(evt ->
                                            datatable.getRows().forEach(item -> {
                                                if (!item.getRecord().isActive()) {
                                                    item.select();
                                                } else {
                                                    item.deselect();
                                                }
                                            }))))
                            .appendChild(PostfixAddOn.of(Icons.check_circle()
                                    .clickable()
                                    .setTooltip("Select Active")
                                    .addClickListener(evt ->
                                            datatable.getRows().forEach(tableRow -> {
                                                if (tableRow.getRecord().isActive()) {
                                                    tableRow.select();
                                                } else {
                                                    tableRow.deselect();
                                                }
                                            }))))
                    ;
                }))
                .addPlugin(new RecordDetailsPlugin<>((RecordDetailsRenderer<Contact>)  cell -> cell.appendChild(new ContactDetails(cell))))
                .addPlugin(new SelectionPlugin<>())
                .addPlugin(new RowMarkerPlugin<>(cellInfo -> ContactUiUtils.getBalanceColor(cellInfo.getRecord()).color().getContextColor()))
                .addPlugin(new SortPlugin<>())
                .addPlugin(ColumnHeaderFilterPlugin.<Contact>create())
                .addPlugin(new GroupingPlugin<>(tableRow -> tableRow.getRecord().getGender().toString(),
                        cellInfo -> {
                            cellInfo
                                    .addCss(dui_border,
                                            dui_border_accent_d_3,
                                            dui_border_solid,
                                            dui_p_1,
                                            dui_bg_accent_d_1, dui_fg_white
                                    );
                            return text(cellInfo.getRecord().getGender().getLabel());
                        }))
                .addPlugin(new ResizeColumnsPlugin<Contact>()
                        .configure(config -> config.setClipContent(true)))
                .addPlugin(new PinColumnsPlugin<Contact>().configure(config -> config.setShowPinMenu(true).setShowPinIcon(true)))
        ;

        LocalListDataStore<Contact> localListDataSource = new LocalListDataStore<Contact>()
                .setSearchFilter(new ContactSearchFilter())
                .setRecordsSorter(new ContactSorter())
                .setPagination(scrollingPaginationPlugin.getPagination());

        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataSource);

        element.appendChild(Card.create("ALL IN ONE", "Try all plugins and feature works together.")
                .setCollapsible(true)
                .appendChild(table)
                .element());

            List<Contact> data = ContactsProvider.instance.subList(80);
            localListDataSource.setData(data);
            topPanel.update(data);
    }

}
