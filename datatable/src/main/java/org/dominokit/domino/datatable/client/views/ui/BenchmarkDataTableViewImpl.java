package org.dominokit.domino.datatable.client.views.ui;

import com.google.gwt.cell.client.*;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent;
import com.google.gwt.view.client.ListDataProvider;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datatable.client.presenters.BenchmarkDatatableProxy;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.CellTextAlign;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.gwtproject.core.client.ScriptInjector;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.dominokit.domino.ui.utils.Domino.*;

@UiView(presentable = BenchmarkDatatableProxy.class)
@SampleClass(includeClassName = true)
public class BenchmarkDataTableViewImpl extends BaseDemoView<HTMLDivElement> implements DatatableView {

    static {
        String scriptCode = ""
                + "document.getElementById('generateBtn').addEventListener('click', function() {"
                + "    var rowCount = parseInt(document.getElementById('rowCount').value) || 0;"
                + "    var start = performance.now();"
                + "    var table = document.createElement('table');"
                + "    table.style.border = '1px solid #000';"
                + "    table.style.borderCollapse = 'collapse';"
                + "    for (var i = 0; i < rowCount; i++) {"
                + "        var row = document.createElement('tr');"
                + "        for (var j = 0; j < 25; j++) {"
                + "            var cell = document.createElement('td');"
                + "            cell.textContent = 'Row ' + (i + 1) + ', Col ' + (j + 1);"
                + "            cell.style.border = '1px solid #000';"
                + "            cell.style.padding = '4px';"
                + "            row.appendChild(cell);"
                + "        }"
                + "        table.appendChild(row);"
                + "    }"
                + "    var container = document.getElementById('tableContainer');"
                + "    container.innerHTML = '';"
                + "    container.appendChild(table);"
                + "    setTimeout(function() {"
                + "        var end = performance.now();"
                + "        var renderTime = end - start;"
                + "        document.getElementById('renderTime').textContent = 'Table rendered in ' + renderTime.toFixed(2) + ' milliseconds.';"
                + "    }, 0);"
                + "});";
        // Inject the JavaScript code into the page.
        DomGlobal.setTimeout(p-> {
            ScriptInjector.fromString(scriptCode)
                    .setWindow(ScriptInjector.TOP_WINDOW)
                    .inject();
        });
    }

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

        benchmarkText();
        element.appendChild(CodeCard.createLazyCodeCard(BenchmarkDataTableViewImpl_CodeResource.INSTANCE.benchmarkText()));

        benchmarkWidgets();
        element.appendChild(CodeCard.createLazyCodeCard(BenchmarkDataTableViewImpl_CodeResource.INSTANCE.benchmarkWidgets()));

        htmlNoStyling();
        element.appendChild(CodeCard.createLazyCodeCard(BenchmarkDataTableViewImpl_CodeResource.INSTANCE.htmlNoStyling()));

        gwtCellTable();
        element.appendChild(CodeCard.createLazyCodeCard(BenchmarkDataTableViewImpl_CodeResource.INSTANCE.gwtCellTable()));

        return element.element();
    }

    @SampleMethod
    private void benchmarkText() {
        TableConfig<DemoContact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<DemoContact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setHeaderTextAlign(CellTextAlign.RIGHT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getId() + 1 + "")))
                )
                .addColumn(ColumnConfig.<DemoContact>create("isActive", "Active")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(String.valueOf(cell.getTableRow().getRecord().isActive()))))
                )
                .addColumn(ColumnConfig.<DemoContact>create("firstName", "First Name")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getFirstName())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("lastName", "Last Name")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getLastName())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("email", "Email")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getLastName())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("phone", "Phone")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getPhone())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("address", "Address")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getAddress())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("city", "City")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getCity())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("state", "State")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getState())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("zipCode", "ZIP Code")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getZipCode())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("country", "Country")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getCountry())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("birthDate", "Birth Date")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getBirthDate().toString())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("company", "Company")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getCompany())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("jobTitle", "Job title")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getJobTitle())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("department", "Department")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getDepartment())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("website", "Website")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getDepartment())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("twitterHandle", "Twitter Handle")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getTwitterHandle())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("facebookId", "Facebook Id")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getFacebookId())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("linkedinProfile", "Linked-in Profile")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getFacebookId())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("notes", "Notes")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getFacebookId())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("createdAt", "Created At")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(new Date(cell.getTableRow().getRecord().getCreatedAt()).toString())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("updatedAt", "Updated At")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(new Date(cell.getTableRow().getRecord().getUpdatedAt()).toString())))
                )

                .addColumn(ColumnConfig.<DemoContact>create("rating", "Rating")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(String.valueOf(cell.getTableRow().getRecord().getRating()))))
                )
                .addColumn(ColumnConfig.<DemoContact>create("customField1", "Custom Field-1")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getCustomField1())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("customField2", "Custom Field-2")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(String.valueOf(cell.getTableRow().getRecord().getCustomField2()))))
                )
        ;

        LocalListDataStore<DemoContact> localListDataStore = new LocalListDataStore<>();
        DataTable<DemoContact> table = new DataTable<>(tableConfig, localListDataStore);
        List<DemoContact> data = new ArrayList<>(ContactGenerator.generateContacts(5_000));
        IntegerBox countBox = IntegerBox.create("Row Count")
                .setMarginBottom("0")
                .withValue(5_000);
        countBox.addChangeListener((oldValue, newValue) -> {
            if (countBox.validate().isValid()) {
                data.clear();
                data.addAll(ContactGenerator.generateContacts(countBox.getValue()));
            }
        });

        SpanElement timeElement = span().textContent("Took: ");
        element.appendChild(Card.create("TEXT CELLS TABLES", "Table with cells rendering text only content")
                .setCollapsible(true)
                .appendChild(countBox
                        .addCss(dui_w_96)
                        .appendChild(
                                PostfixAddOn.of(Button.create("Load Data")
                                        .addCss(dui_primary)
                                        .addClickListener(evt -> {
                                            if (countBox.validate().isValid()) {
                                                double start = DomGlobal.performance.now();
                                                localListDataStore.setData(data);
                                                DomGlobal.setTimeout(p0 -> {
                                                    double end = DomGlobal.performance.now();

                                                    double delta = end - start;
                                                    double seconds = Math.floor(delta / 1000);
                                                    double milliseconds = delta % 1000;

                                                    timeElement.textContent("Took: " + seconds + "s and " + milliseconds + "ms");
                                                });

                                            }
                                        }))
                        )
                )
                .appendChild(timeElement)
                .appendChild(table)
        );
    }

    @SampleMethod
    private void benchmarkWidgets() {
        TableConfig<DemoContact> tableConfig = new TableConfig<>();
        tableConfig
                .addColumn(ColumnConfig.<DemoContact>create("id", "#")
                        .setTextAlign(CellTextAlign.RIGHT)
                        .setHeaderTextAlign(CellTextAlign.RIGHT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getId() + 1 + "")))
                )
                .addColumn(ColumnConfig.<DemoContact>create("isActive", "Active")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> CheckBox.create()
                                .withValue(cell.getTableRow().getRecord().isActive())
                                .addCss(dui_hide_label)
                                .element())
                )
                .addColumn(ColumnConfig.<DemoContact>create("firstName", "First Name")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getFirstName())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("lastName", "Last Name")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getLastName())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("email", "Email")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(a().textContent(cell.getTableRow().getRecord().getEmail()).setHref(cell.getTableRow().getRecord().getEmail())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("rating", "Rating")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(Select.<Double>create()
                                .addCss(dui_hide_label)
                                .appendChild(SelectOption.create(1.0, "1"))
                                .appendChild(SelectOption.create(2.0, "2"))
                                .appendChild(SelectOption.create(3.0, "3"))
                                .appendChild(SelectOption.create(4.0, "4"))
                                .appendChild(SelectOption.create(5.0, "5"))
                                .withValue(cell.getTableRow().getRecord().getRating())
                        )
                        )
                )
                .addColumn(ColumnConfig.<DemoContact>create("website", "Website")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(a().textContent(cell.getTableRow().getRecord().getWebsite()).setHref(cell.getTableRow().getRecord().getWebsite())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("twitterHandle", "Twitter Handle")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(a().textContent(cell.getTableRow().getRecord().getTwitterHandle()).setHref(cell.getTableRow().getRecord().getTwitterHandle())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("facebookId", "Facebook Id")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(a().textContent(cell.getTableRow().getRecord().getFacebookId()).setHref(cell.getTableRow().getRecord().getFacebookId())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("linkedinProfile", "Linked-in Profile")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(a().textContent(cell.getTableRow().getRecord().getLinkedinProfile()).setHref(cell.getTableRow().getRecord().getLinkedinProfile())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("phone", "Phone")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getPhone())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("address", "Address")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getAddress())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("city", "City")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getCity())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("state", "State")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getState())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("zipCode", "ZIP Code")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getZipCode())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("country", "Country")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getCountry())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("birthDate", "Birth Date")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getBirthDate().toString())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("company", "Company")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getCompany())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("jobTitle", "Job title")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getJobTitle())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("department", "Department")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getDepartment())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("notes", "Notes")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(cell.getTableRow().getRecord().getNotes())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("createdAt", "Created At")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(new Date(cell.getTableRow().getRecord().getCreatedAt()).toString())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("updatedAt", "Updated At")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(text(new Date(cell.getTableRow().getRecord().getUpdatedAt()).toString())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("customField1", "Custom Field-1")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(TextBox.create().addCss(dui_hide_label).withValue(cell.getTableRow().getRecord().getCustomField1())))
                )
                .addColumn(ColumnConfig.<DemoContact>create("customField2", "Custom Field-2")
                        .setTextAlign(CellTextAlign.LEFT)
                        .setHeaderTextAlign(CellTextAlign.LEFT)
                        .setRenderer(cell -> cell.appendChild(IntegerBox.create().addCss(dui_hide_label).withValue(cell.getTableRow().getRecord().getCustomField2())))
                )
        ;

        LocalListDataStore<DemoContact> localListDataStore = new LocalListDataStore<>();
        DataTable<DemoContact> table = new DataTable<>(tableConfig, localListDataStore);
        List<DemoContact> data = new ArrayList<>(ContactGenerator.generateContacts(5_000));
        IntegerBox countBox = IntegerBox.create("Row Count")
                .setMarginBottom("0")
                .withValue(5_000);
        countBox.addChangeListener((oldValue, newValue) -> {
            if (countBox.validate().isValid()) {
                data.clear();
                data.addAll(ContactGenerator.generateContacts(countBox.getValue()));
            }
        });

        SpanElement timeElement = span().textContent("Took: ");
        element.appendChild(Card.create("TABLE WITH WIDGET")
                .setCollapsible(true)
                .appendChild(countBox
                        .addCss(dui_w_96)
                        .appendChild(
                                PostfixAddOn.of(Button.create("Load Data")
                                        .addCss(dui_primary)
                                        .addClickListener(evt -> {
                                            if (countBox.validate().isValid()) {
                                                double start = DomGlobal.performance.now();
                                                localListDataStore.setData(data);
                                                DomGlobal.setTimeout(p0 -> {
                                                    double end = DomGlobal.performance.now();

                                                    double delta = end - start;
                                                    double seconds = Math.floor(delta / 1000);
                                                    double milliseconds = delta % 1000;

                                                    timeElement.textContent("Took: " + seconds + "s and " + milliseconds + "ms");
                                                });
                                            }
                                        })
                                )
                        )
                )
                .appendChild(timeElement)
                .appendChild(table)
        );
    }

    @SampleMethod
    private void htmlNoStyling() {

        element.appendChild(Card.create("PURE HTML AND JavaScript")
                        .setCollapsible(true)
                .apply(self -> {
                    // Define the HTML snippet (excluding <html>, <head>, and <body>).
                    String htmlSnippet = ""
                            + "<label for=\"rowCount\">Number of Rows:</label>"
                            + "<input type=\"number\" id=\"rowCount\" placeholder=\"Enter number of rows\" min=\"1\" value=\"5000\">"
                            + "<button id=\"generateBtn\">Generate Table</button>"
                            + "<p id=\"renderTime\"></p>"
                            + "<div id=\"tableContainer\"></div>";

                    // Add the snippet to a GWT HTML widget.
                    self.getBody().setInnerHtml(htmlSnippet);


                })
        );

    }
    @SampleMethod
    private void gwtCellTable() {

        CellTable<DemoContact> cellTable = new CellTable<>(1_000_000,
                DemoContact::getId);

        // Do not refresh the headers and footers every time the data is updated.
        cellTable.setAutoHeaderRefreshDisabled(true);
        cellTable.setAutoFooterRefreshDisabled(true);

        ListDataProvider<DemoContact> dataProvider = new ListDataProvider<>();
        // Attach a column sort handler to the ListDataProvider to sort the list.
        ColumnSortEvent.ListHandler<DemoContact> sortHandler = new ColumnSortEvent.ListHandler<DemoContact>(dataProvider.getList());
        cellTable.addColumnSortHandler(sortHandler);

        // Initialize the columns.
        initTableColumns(cellTable, sortHandler);

        // Add the CellList to the adapter in the database.
        dataProvider.addDataDisplay(cellTable);

        List<DemoContact> data = new ArrayList<>(ContactGenerator.generateContacts(5_000));
        IntegerBox countBox = IntegerBox.create("Row Count")
                .setMarginBottom("0")
                .withValue(5_000);
        countBox.addChangeListener((oldValue, newValue) -> {
            if (countBox.validate().isValid()) {
                data.clear();
                data.addAll(ContactGenerator.generateContacts(countBox.getValue()));
            }
        });

        SpanElement timeElement = span().textContent("Took: ");
        element.appendChild(Card.create("GWT CellTable")
                .setCollapsible(true)
                .appendChild(countBox
                        .addCss(dui_w_96)
                        .appendChild(
                                PostfixAddOn.of(Button.create("Load Data")
                                        .addCss(dui_primary)
                                        .addClickListener(evt -> {
                                            if (countBox.validate().isValid()) {
                                                double start = DomGlobal.performance.now();
                                                cellTable.addLoadingStateChangeHandler(event -> {
                                                    DomGlobal.setTimeout(p0 -> {
                                                        double end = DomGlobal.performance.now();

                                                        double delta = end - start;
                                                        double seconds = Math.floor(delta / 1000);
                                                        double milliseconds = delta % 1000;

                                                        timeElement.textContent("Took: " + seconds + "s and " + milliseconds + "ms");

                                                    });
                                                });
                                                dataProvider.setList(data);
                                            }
                                        }))
                        )
                )
                .appendChild(timeElement)
                        .appendChild(div()
                                .addCss(dui_w_full, dui_overflow_x_auto)
                                .appendChild(elementOf(Js.<Element>uncheckedCast(cellTable.getElement())))
                        )

        );
    }

    private void initTableColumns(CellTable<DemoContact> cellTable, ColumnSortEvent.ListHandler<DemoContact> sortHandler) {

        Column<DemoContact, String> idColumn =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getId());
            }
        };
        cellTable.addColumn(idColumn, "id");
        cellTable.setColumnWidth(idColumn, null);

        Column<DemoContact, String> firstName =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getFirstName());
            }
        };

        cellTable.addColumn(firstName, "First name");
        cellTable.setColumnWidth(firstName, null);

        Column<DemoContact, String> lastName =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getLastName());
            }
        };
        cellTable.addColumn(lastName, "last name");
        cellTable.setColumnWidth(lastName, null);

        Column<DemoContact, String> email =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getEmail());
            }
        };
        cellTable.addColumn(email, "email");
        cellTable.setColumnWidth(email, null);

        Column<DemoContact, String> phone =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getPhone());
            }
        };
        cellTable.addColumn(phone, "phone");
        cellTable.setColumnWidth(phone, null);

        Column<DemoContact, String> address =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getAddress());
            }
        };
        cellTable.addColumn(address, "address");
        cellTable.setColumnWidth(address, null);

        Column<DemoContact, String> city =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getCity());
            }
        };
        cellTable.addColumn(city, "city");
        cellTable.setColumnWidth(city, null);

        Column<DemoContact, String> state = new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getState());
            }
        };
        cellTable.addColumn(state, "state");
        cellTable.setColumnWidth(state, null);

        Column<DemoContact, String> zipCode =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getZipCode());
            }
        };
        cellTable.addColumn(zipCode, "zipCode");
        cellTable.setColumnWidth(zipCode, null);

        Column<DemoContact, String> country =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getCountry());
            }
        };
        cellTable.addColumn(country, "country");
        cellTable.setColumnWidth(country, null);

        Column<DemoContact, String> birthDate =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getBirthDate());
            }
        };
        cellTable.addColumn(birthDate, "birthDate");
        cellTable.setColumnWidth(birthDate, null);

        Column<DemoContact, String> company =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getCompany());
            }
        };
        cellTable.addColumn(company, "company");
        cellTable.setColumnWidth(company, null);

        Column<DemoContact, String> jobTitle =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getJobTitle());
            }
        };
        cellTable.addColumn(jobTitle, "jobTitle");
        cellTable.setColumnWidth(jobTitle, null);

        Column<DemoContact, String> department =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getDepartment());
            }
        };
        cellTable.addColumn(department, "department");
        cellTable.setColumnWidth(department, null);

        Column<DemoContact, String> website =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getWebsite());
            }
        };
        cellTable.addColumn(website, "website");
        cellTable.setColumnWidth(website, null);

        Column<DemoContact, String> twitterHandle =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getTwitterHandle());
            }
        };
        cellTable.addColumn(twitterHandle, "twitterHandle");
        cellTable.setColumnWidth(twitterHandle, null);

        Column<DemoContact, String> facebookId =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getFacebookId());
            }
        };
        cellTable.addColumn(facebookId, "facebookId");
        cellTable.setColumnWidth(facebookId, null);

        Column<DemoContact, String> linkedinProfile =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getLinkedinProfile());
            }
        };
        cellTable.addColumn(linkedinProfile, "linkedinProfile");
        cellTable.setColumnWidth(linkedinProfile, null);

        Column<DemoContact, String> notes =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getNotes());
            }
        };
        cellTable.addColumn(notes, "notes");
        cellTable.setColumnWidth(notes, null);

        Column<DemoContact, String> createdAt =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(new Date(object.getCreatedAt()));
            }
        };
        cellTable.addColumn(createdAt, "createdAt");
        cellTable.setColumnWidth(createdAt, null);

        Column<DemoContact, String> updatedAt =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(new Date(object.getUpdatedAt()));
            }
        };
        cellTable.addColumn(updatedAt, "updatedAt");
        cellTable.setColumnWidth(updatedAt, null);

        Column<DemoContact, String> active =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.isActive());
            }
        };
        cellTable.addColumn(active, "active");
        cellTable.setColumnWidth(active, null);

        Column<DemoContact, String> rating =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getRating());
            }
        };
        cellTable.addColumn(rating, "rating");
        cellTable.setColumnWidth(rating, null);

        Column<DemoContact, String> customField1 =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getCustomField1());
            }
        };
        cellTable.addColumn(customField1, "customField1");
        cellTable.setColumnWidth(customField1, null);

        Column<DemoContact, String> customField2 =new Column<DemoContact, String>(
                new TextCell()) {
            @Override
            public String getValue(DemoContact object) {
                // Get the value from the selection model.
                return String.valueOf(object.getCustomField2());
            }
        };
        cellTable.addColumn(customField2, "customField2");
        cellTable.setColumnWidth(customField2, null);
    }

}
