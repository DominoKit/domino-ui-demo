package org.dominokit.domino.datatable.client.views.grid;


import elemental2.dom.DomGlobal;
import org.dominokit.domino.ui.style.CssProperty;

import java.util.ArrayList;
import java.util.List;

public class GridTableConfig<T> implements GridTableStyles{

private final List<GridColumnConfig<? extends T>> columns = new ArrayList<>();

    /**
     * Adds a column to the configuration.
     *
     * @param column Column configuration.
     * @return Current instance of {@link GridTableConfig} for chaining.
     */
    public GridTableConfig<T> addColumn(GridColumnConfig<T> column) {
//        column.applyMeta(ColumnHeaderMeta.create());
        this.columns.add(column);
        return this;
    }

    public GridTableConfig<T> drawHeaders(GridTable<T> table) {

        StringBuilder columnsTemplate = new StringBuilder();
        StringBuilder templateValue = new StringBuilder();

        columns.forEach(col -> {
            CssProperty widthProperty = col.getWidthProperty();
            table.setCssProperty(widthProperty);
            columnsTemplate.append("var(");
            columnsTemplate.append(widthProperty.getName());
            columnsTemplate.append(") ");
            table.getHeader().appendChild(col);
            templateValue.append(widthProperty.getValue()).append(" ");
        });
        table.getHeader().setCssProperty(CssProperty.of("grid-template-columns", columnsTemplate.toString()));
        DomGlobal.console.log(templateValue.toString());

        return this;
    }
}
