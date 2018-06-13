package org.dominokit.domino.datatable.client.views.datatable;

import elemental2.dom.HTMLTableCellElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;

import static java.util.Objects.nonNull;

public class RowCell<T> {

    private TableRow<T> tableRow;
    private final ColumnConfig<T> columnConfig;
    private final HTMLTableCellElement cellElement;


    public RowCell(TableRow<T> tableRow, ColumnConfig<T> columnConfig, HTMLTableCellElement cellElement) {
        this.tableRow = tableRow;
        this.columnConfig = columnConfig;
        this.cellElement = cellElement;
    }

    public ColumnConfig<T> getColumnConfig() {
        return columnConfig;
    }

    public void updateCell() {
        ElementUtil.clear(cellElement);
        Style<HTMLTableCellElement> style = Style.of(cellElement);
        if (nonNull(columnConfig.getMinWidth())) {
            style.setMinWidth(columnConfig.getMinWidth());
            Style.of(columnConfig.getHeadElement()).setMinWidth(columnConfig.getMinWidth());
        }

        if (nonNull(columnConfig.getMaxWidth())) {
            style.setMaxWidth(columnConfig.getMaxWidth());
            Style.of(columnConfig.getHeadElement()).setMaxWidth(columnConfig.getMaxWidth());
        }

        if (nonNull(columnConfig.getTextAlign())) {
            style.setTextAlign(columnConfig.getTextAlign());
            Style.of(columnConfig.getHeadElement()).setTextAlign(columnConfig.getTextAlign());
        }

        cellElement.appendChild(columnConfig.getCellElement().asElement(tableRow));
    }
}
