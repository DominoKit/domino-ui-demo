package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.FixedDatatableProxy;
import org.dominokit.domino.datatable.client.presenters.SelectionPluginProxy;
import org.dominokit.domino.datatable.client.task.ContactsProvider;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.datatable.client.views.model.Contact;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.events.SelectAllEvent;
import org.dominokit.domino.ui.datatable.plugins.SelectionPlugin;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.Random;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.div;

@UiView(presentable = SelectionPluginProxy.class)
@SampleClass(includeClassName = true)
public class SelectionPluginViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

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

        singleSelectionPlugin();
        element.appendChild(CodeCard.createLazyCodeCard(SelectionPluginViewImpl_CodeResource.INSTANCE.singleSelectionPlugin()).element());

        multiSelectionPlugin();
        element.appendChild(CodeCard.createLazyCodeCard(SelectionPluginViewImpl_CodeResource.INSTANCE.multiSelectionPlugin()).element());

        return element;
    }

    @SampleMethod
    private void singleSelectionPlugin() {
        TableConfig<Contact> singleSelectionTableConfig = new TableConfig<>();
        singleSelectionTableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell1 -> {
                            if (cell1.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell1 -> ContactUiUtils.getGenderElement(cell1.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell1 -> ContactUiUtils.getEyeColorElement(cell1.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo1 -> ContactUiUtils.getBalanceElement(cellInfo1.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell1 -> TextNode.of(cell1.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell1 -> {
                            if (cell1.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));
        singleSelectionTableConfig.setMultiSelect(false);
        singleSelectionTableConfig.addPlugin(new SelectionPlugin<>(ColorScheme.LIGHT_BLUE));
        LocalListDataStore<Contact> singleLocalStore = new LocalListDataStore<>();
        DataTable<Contact> singleSelectionTable = new DataTable<>(singleSelectionTableConfig, singleLocalStore);
        singleSelectionTable.addSelectionListener((selectedTableRows, selectedRecords) -> {
            Notification.create(selectedRecords.size() + "").show();
        });

        element.appendChild(Card.create("SELECTION PLUGIN", "Enable row selection by adding the selection plugin, pass different selection style colors in the constructor.")
                .setCollapsible()
                .appendChild(BlockHeader.create("SINGLE SELECTION"))
                .appendChild(new TableStyleActions(singleSelectionTable))
                .appendChild(singleSelectionTable.element())
                .element());

            singleLocalStore.setData(ContactsProvider.instance.subList());
            singleLocalStore.load();
    }

    @SampleMethod
    private void multiSelectionPlugin() {

        TableConfig<Contact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<Contact>create("id", "#")
                        .textAlign("right")
                        .asHeader()
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getIndex() + 1 + "")))

                .addColumn(ColumnConfig.<Contact>create("status", "Status")
                        .textAlign("center")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().isActive()) {
                                return Style.of(Icons.ALL.check_circle()).setColor(Color.GREEN_DARKEN_3.getHex()).element();
                            } else {
                                return Style.of(Icons.ALL.highlight_off()).setColor(Color.RED_DARKEN_3.getHex()).element();
                            }
                        }))
                .addColumn(ColumnConfig.<Contact>create("firstName", "First name")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getName())))


                .addColumn(ColumnConfig.<Contact>create("gender", "Gender")
                        .setCellRenderer(cell -> ContactUiUtils.getGenderElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("eyeColor", "Eye color")
                        .setCellRenderer(cell -> ContactUiUtils.getEyeColorElement(cell.getRecord()))
                        .textAlign("center"))

                .addColumn(ColumnConfig.<Contact>create("balance", "Balance")
                        .setCellRenderer(cellInfo -> ContactUiUtils.getBalanceElement(cellInfo.getRecord())))

                .addColumn(ColumnConfig.<Contact>create("email", "Email")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getEmail())))

                .addColumn(ColumnConfig.<Contact>create("phone", "Phone")
                        .setCellRenderer(cell -> TextNode.of(cell.getTableRow().getRecord().getPhone())))

                .addColumn(ColumnConfig.<Contact>create("badges", "Badges")
                        .setCellRenderer(cell -> {
                            if (cell.getTableRow().getRecord().getAge() < 35) {
                                return Badge.create("Young")
                                        .setBackground(ColorScheme.GREEN.color()).element();
                            }
                            return TextNode.of("");
                        }));
        tableConfig.addPlugin(new SelectionPlugin<>(ColorScheme.LIGHT_BLUE));
        LocalListDataStore<Contact> multiLocalStore = new LocalListDataStore<>();
        DataTable<Contact> multiSelectionTable = new DataTable<>(tableConfig, multiLocalStore);
        multiSelectionTable.addSelectionListener((selectedTableRows, selectedRecords) -> {
            Notification.create(selectedRecords.size() + "").show();
        });

        multiSelectionTable.addTableEventListener(SelectAllEvent.SELECT_ALL_EVENT, event -> {
            SelectAllEvent<Contact> evt = (SelectAllEvent<Contact>) event;
            DomGlobal.console.info(evt.isSelectAll(), evt.getSelectionCondition());
        });


        element.appendChild(Card.create("SELECTION PLUGIN", "Enable row selection by adding the selection plugin, pass different selection style colors in the constructor.")
                .setCollapsible()
                .appendChild(BlockHeader.create("MULTI SELECTION"))
                .appendChild(new TableStyleActions(multiSelectionTable))
                .appendChild(multiSelectionTable)
                .element());

            multiLocalStore.setData(ContactsProvider.instance.subList());


    }

}
