package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import static org.dominokit.domino.ui.utils.Domino.*;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.SummaryPluginProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.datatable.client.views.model.ContactSummary;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnMeta;
import org.dominokit.domino.ui.datatable.plugins.header.BordersTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.CondenseTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.HeaderBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.HoverTableAction;
import org.dominokit.domino.ui.datatable.plugins.header.NavigationBarPlugin;
import org.dominokit.domino.ui.datatable.plugins.header.StripesTableAction;
import org.dominokit.domino.ui.datatable.plugins.summary.SummaryMeta;
import org.dominokit.domino.ui.datatable.plugins.summary.SummaryPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

@UiView(presentable = SummaryPluginProxy.class)
@SampleClass(includeClassName = true)
public class SummaryPluginViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

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

        summaryPlugin();
        element.appendChild(CodeCard.createLazyCodeCard(SummaryPluginViewImpl_CodeResource.INSTANCE.summaryPlugin()));

        return element.element();
    }

    @SampleMethod
    private void summaryPlugin() {
        SummaryPlugin<Contact, ContactSummary> summaryPlugin = new SummaryPlugin<>();
        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .setFixed(true)
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .applyMeta(ResizeColumnMeta.create(false))
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getIndex() + 1 + "")))
                        .applyMeta(SummaryMeta.<Contact, ContactSummary>of(cell -> {
                                    elementOf(cell.getElement())
                                            .setAttribute("colspan", "5")
                                            .setTextAlign("right")
                                            .setCssProperty("font-weight", "600")
                                    ;
                                    return text(cell.getRecord().getType() + " :");
                                })
                        )
                )
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getName())))
                )
                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getGenderElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER)
                )
                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getEyeColorElement(cell.getRecord())))
                        .setTextAlign(CellTextAlign.CENTER)
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
                )
                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setRenderer(cell -> cell.appendChild(ContactUiUtils.getBalanceElement(cell.getRecord())))
                        .applyMeta(SummaryMeta.<Contact, ContactSummary>of(cell -> div().addCss(dui_flex)
                                .appendChild(div().appendChild(text(cell.getRecord().getBalance() + "")))
                                .element()))
                )
                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getEmail())))
                )

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getPhone())))
                )
                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                cell.appendChild(Badge.create("Young")
                                        .addCss(dui_green, dui_float_none));
                            }else{
                            cell.appendChild(text(""));}
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
                }))
                .addPlugin(summaryPlugin)
        ;

        LocalListDataStore<Contact> localListDataStore = new LocalListDataStore<>();
        DataTable<Contact> table = new DataTable<>(tableConfig, localListDataStore);
        element.appendChild(Card.create("SUMMARY PLUGIN", "Show data aggregation and summary in the table footer.")
                .setCollapsible(true)
                .appendChild(table)
                .element());

        List<Contact> contacts = ContactsProvider.instance.subList();
        localListDataStore.setData(contacts);
        double sum = contacts.stream().mapToDouble(Contact::getBalance).sum();
        OptionalDouble balanceAverage = contacts.stream().mapToDouble(Contact::getBalance).average();
        OptionalDouble ageAverage = contacts.stream().mapToInt(Contact::getAge).average();
        summaryPlugin.setSummaryRecords(Arrays.asList(
                new ContactSummary("Sum", sum, -1),
                new ContactSummary("Average", balanceAverage.orElse(0), Double.valueOf(ageAverage.orElse(-1)).intValue()))
        );
    }

}
