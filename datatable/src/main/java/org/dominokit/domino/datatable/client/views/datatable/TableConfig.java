package org.dominokit.domino.datatable.client.views.datatable;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.HTMLTableRowElement;
import elemental2.dom.HTMLTableSectionElement;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import java.util.LinkedList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.*;

public class TableConfig<T> {

    private List<ColumnConfig<T>> columns = new LinkedList<>();
    private List<DataTablePlugin<T>> plugins= new LinkedList<>();
    private DataTable<T> dataTable;

    public void drawHeaders(DataTable<T> dataTable) {
        this.dataTable = dataTable;
        HtmlContentBuilder<HTMLTableRowElement> tr = tr();
        HtmlContentBuilder<HTMLTableSectionElement> thead = thead().add(tr.asElement());

        columns.forEach(column -> {
            HtmlContentBuilder<HTMLTableCellElement> th = th().add(column.getHeaderElement().asElement(column.getTitle()));
            tr.add(th);
            column.setHeadElement(th.asElement());
        });

        dataTable.tableElement().appendChild(thead.asElement());
    }

    public void drawRecord(DataTable<T> dataTable, TableRow<T> tableRow) {
        columns.forEach(columnConfig -> {

            HTMLTableCellElement cellElement;
            if (columnConfig.isHeader()) {
                cellElement = th().asElement();
            } else {
                cellElement = td().asElement();
            }

            RowCell<T> rowCell = new RowCell<>(tableRow, columnConfig, cellElement);
            rowCell.updateCell();
            tableRow.addCell(rowCell);

            tableRow.asElement().appendChild(cellElement);
        });
        dataTable.bodyElement().appendChild(tableRow.asElement());

        plugins.forEach(plugin -> plugin.onRowAdded(dataTable, tableRow));
    }



    public TableConfig<T> addColumn(ColumnConfig<T> column) {
        this.columns.add(column);
        return this;
    }

    public TableConfig<T> insertColumnFirst(ColumnConfig<T> column) {
        this.columns.add(0, column);
        return this;
    }

    public TableConfig<T> insertColumnLast(ColumnConfig<T> column) {
        this.columns.add(this.columns.size() - 1, column);
        return this;
    }

    public TableConfig<T> addPlugin(DataTablePlugin<T> plugin){
        this.plugins.add(plugin);
        return this;
    }

    void onBeforeHeaders(DataTable<T> dataTable) {
        plugins.forEach(plugin -> plugin.onBeforeAddHeaders(dataTable));
    }

    public List<ColumnConfig<T>> getColumns() {
        return columns;
    }
}
