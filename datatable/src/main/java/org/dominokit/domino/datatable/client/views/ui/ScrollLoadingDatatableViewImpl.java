package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;

import static org.dominokit.domino.ui.utils.Domino.*;

import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.ScrollLoadingPluginProxy;
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
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.plugins.pagination.BodyScrollPlugin;
import org.dominokit.domino.ui.datatable.plugins.pagination.BodyScrollPluginConfig;
import org.dominokit.domino.ui.datatable.plugins.pagination.SortPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListScrollingDataSource;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;

@UiView(presentable = ScrollLoadingPluginProxy.class)
@SampleClass(includeClassName = true)
public class ScrollLoadingDatatableViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

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

        scrollableTable();
        element.appendChild(CodeCard.createLazyCodeCard(ScrollLoadingDatatableViewImpl_CodeResource.INSTANCE.scrollableTable()).element());

        return element.element();
    }

    @SampleMethod
    private void scrollableTable() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .sortable()
                        .onCellReady(cell -> cell.addCss(dui_align_middle))
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
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getName())))
                        .setWidth("200px"))
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER))
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .onHeaderReady(column -> column.getHeadElement().addCss(dui_w_24))
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER)
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .sortable()
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                        .setWidth("250px"))
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setWidth("250px")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getEmail()))))
                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setWidth("150px")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getPhone()))))
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                cell.appendChild(Badge.create("Young")
                                        .addCss(dui_green, dui_float_none));
                            } else {
                                cell.appendChild(text(""));
                            }
                        }))
                .addPlugin(new BodyScrollPlugin<Contact>().setConfig(new BodyScrollPluginConfig(3)))
                .addPlugin(new NavigationBarPlugin<>((datatable, navBar) -> {
                    navBar
                            .setTitle("Demo table")
                            .setDescription("Sample table table demonstrating the feature")
                            .appendChild(PostfixAddOn.of(HoverTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(CondenseTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(StripesTableAction.create(datatable)))
                            .appendChild(PostfixAddOn.of(BordersTableAction.create(datatable)));
                }))
                .addPlugin(new SortPlugin<>());

        LocalListScrollingDataSource<Contact> scrollingDataSource = new LocalListScrollingDataSource<Contact>(10)
                .setSearchFilter(new ContactSearchFilter())
                .setRecordsSorter(new ContactSorter());

        DataTable<Contact> table = new DataTable<>(tableConfig, scrollingDataSource);

        element.appendChild(Card.create("SCROLL LOADING", "Scroll loading requires the table to be fixed. use the Body scroll plugin to fire scroll events.")
                .setCollapsible(true)
                .appendChild(table)
                .element());

        scrollingDataSource.setData(ContactsProvider.instance.subList(90));
        scrollingDataSource.load();
    }
}
