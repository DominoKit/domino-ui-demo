package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.MarkerPluginProxy;
import org.dominokit.domino.datatable.client.presenters.PluginsMixProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.ContactSearchFilter;
import org.dominokit.domino.datatable.client.views.model.ContactSorter;
import org.dominokit.domino.datatable.client.views.model.Gender;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.ColumnFilterMeta;
import org.dominokit.domino.ui.datatable.plugins.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.datatable.plugins.GroupingPlugin;
import org.dominokit.domino.ui.datatable.plugins.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.RecordDetailsPlugin;
import org.dominokit.domino.ui.datatable.plugins.RowMarkerPlugin;
import org.dominokit.domino.ui.datatable.plugins.ScrollingPaginationPlugin;
import org.dominokit.domino.ui.datatable.plugins.SelectionPlugin;
import org.dominokit.domino.ui.datatable.plugins.SortPlugin;
import org.dominokit.domino.ui.datatable.plugins.TopPanelPlugin;
import org.dominokit.domino.ui.datatable.plugins.filter.header.BooleanHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.DoubleHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.EnumHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.SelectHeaderFilter;
import org.dominokit.domino.ui.datatable.plugins.filter.header.TextHeaderFilter;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.List;

import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;

@UiView(presentable = PluginsMixProxy.class)
@SampleClass(includeClassName = true)
public class PluginsMixViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();


        element.appendChild(LinkToSourceCode.create("datatable", this.getClass()).element());
        element.appendChild(BlockHeader.create("DATA TABLES", "For detailed demo code please visit: ")
                .appendChild(a().attr("href", "https://github.com/DominoKit/domino-ui-demo/tree/master/datatable")
                        .attr("target", "_blank")
                        .textContent("Data table demo source code").element())
                .element());

        allInOne();
        element.appendChild(CodeCard.createLazyCodeCard(PluginsMixViewImpl_CodeResource.INSTANCE.allInOne()).element());

        return element;
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

            List<Contact> data = ContactsProvider.instance.subList(80);
            localListDataSource.setData(data);
            topPanel.update(data);
    }

}
