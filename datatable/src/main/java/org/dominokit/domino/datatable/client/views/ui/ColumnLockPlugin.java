package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLTableCellElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.RowCell;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.List;

public class ColumnLockPlugin<T> implements DataTablePlugin<T> {

    private final int count;

    public static <T> ColumnLockPlugin<T> create(int count) {
        return new ColumnLockPlugin<>(count);
    }

    public ColumnLockPlugin(int count) {
        this.count = count;
    }

    @Override
    public void onBodyAdded(DataTable<T> dataTable) {
        dataTable.bodyElement().setDisplay("table-row-group");
        dataTable.headerElement().setDisplay("table-header-group");
    }

    @Override
    public void onHeaderAdded(DataTable<T> dataTable, ColumnConfig<T> column) {
        List<ColumnConfig<T>> columns = dataTable.getTableConfig().getColumns();
        int columnIndex = columns.indexOf(column);
        if (columnIndex - count < 0) {
            if(columnIndex>0) {
                column.getHeadElement().css("locked-column");
                column.getHeadElement().onAttached(mutationRecord -> {
                    ColumnConfig<T> prevColumn = columns.get(columnIndex - 1);
                    column.getHeadElement().setLeft(prevColumn.getHeadElement().element().offsetLeft - 35 +  prevColumn.getHeadElement().getBoundingClientRect().width + "px");
                });
            }else {
                column.getHeadElement().css("locked-column");
                column.getHeadElement().onAttached(mutationRecord -> {
                    column.getHeadElement().setLeft(0 + "px");
                });
            }
        }
    }

    @Override
    public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
        List<ColumnConfig<T>> columns = dataTable.getTableConfig().getColumns();
        List<RowCell<T>> cells = new ArrayList<>(tableRow.getRowCells().values());
        cells.forEach(cell -> {
            ColumnConfig<T> column = cell.getColumnConfig();
            int cellIndex = columns.indexOf(column);
            if (cellIndex - count < 0) {
                DominoElement<HTMLTableCellElement> cellElement = DominoElement.of(cell.getCellInfo().getElement());
                cellElement.css("locked-column");
                cellElement.setLeft(cellElement.element().offsetLeft - 35 + "px");
            }
        });
    }
}
