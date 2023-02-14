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
import org.dominokit.domino.datatable.client.presenters.TopPanelPluginProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.ContactSearchFilter;
import org.dominokit.domino.datatable.client.views.model.ContactSorter;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.BodyScrollPlugin;
import org.dominokit.domino.ui.datatable.plugins.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.RowMarkerPlugin;
import org.dominokit.domino.ui.datatable.plugins.SortPlugin;
import org.dominokit.domino.ui.datatable.plugins.TopPanelPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.datatable.store.LocalListScrollingDataSource;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.List;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;

@UiView(presentable = TopPanelPluginProxy.class)
@SampleClass(includeClassName = true)
public class TopPanelPluginViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

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

        topPanelPlugin();
        element.appendChild(CodeCard.createLazyCodeCard(TopPanelPluginViewImpl_CodeResource.INSTANCE.topPanelPlugin()).element());

        return element;
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

            List<Contact> data = ContactsProvider.instance.subList(90);
            scrollingDataSource.setData(data);
            table.load();
            topPanel.update(data);
    }
}
