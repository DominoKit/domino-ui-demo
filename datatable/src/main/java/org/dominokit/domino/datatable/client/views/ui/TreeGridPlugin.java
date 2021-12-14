package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.jboss.elemento.Elements.td;

public class TreeGridPlugin<T> implements DataTablePlugin<T> {

    private final String indentColumn;
    private final Function<T, Optional<Collection<T>>> itemsFunction;
    private ParentSupplier<T> parentSupplier = item -> TextNode.of(item.toString());

    public TreeGridPlugin(String indentColumn, Function<T, Optional<Collection<T>>> itemsFunction) {
        this.indentColumn = indentColumn;
        this.itemsFunction = itemsFunction;
    }

    public TreeGridPlugin(String indentColumn, Function<T, Optional<Collection<T>>> itemsFunction, ParentSupplier<T> parentSupplier) {
        this(indentColumn, itemsFunction);
        this.parentSupplier = parentSupplier;
    }

    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
        dataTable
                .getTableConfig()
                .insertColumnFirst(
                        ColumnConfig.<T>create("tree-grid-expand-collapse")
                                .setSortable(false)
                                .setPluginColumn(true)
                                .styleHeader(element -> Style.of(element).setPadding("0px", true).setWidth("3px", true))
                                .styleCell(element -> Style.of(element).setPadding("0px", true).setWidth("3px", true))
                                .setCellRenderer(
                                        cell -> {
                                            Optional<Collection<T>> items = itemsFunction.apply(cell.getRecord());
                                            if (!isParent(items)) {
                                                return Icons.ALL.circle_medium_mdi().size18().element();
                                            }
                                            return Icons.ALL.plus_mdi().size18()
                                                    .setToggleIcon(Icons.ALL.minus_mdi().size18())
                                                    .toggleOnClick(true)
                                                    .clickable()
                                                    .addClickListener(evt -> {
                                                        Optional.ofNullable(cell.getTableRow().getMetaObject("tree-grid-sub-items"))
                                                                .map(o -> (TreeGridSubItems<T>) o)
                                                                .ifPresent(subItems -> subItems.items.forEach(BaseDominoElement::toggleDisplay));
                                                    })
                                                    .element();
                                        }));
    }

    @Override
    public void onBeforeAddRow(DataTable<T> dataTable, TableRow<T> tableRow) {
        Optional<Collection<T>> items = itemsFunction.apply(tableRow.getRecord());
        if (isParent(items)) {
            tableRow.setRowRenderer(new TreeGridRowRenderer());
        }
    }

    private boolean isParent(Optional<Collection<T>> items) {
        return items.isPresent() && !items.get().isEmpty();
    }

    @Override
    public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
        Optional<Collection<T>> itemsOptional = itemsFunction.apply(tableRow.getRecord());
        if (!itemsOptional.isPresent()) {
            return;
        }
        List<T> items = new ArrayList<>(itemsOptional.get());
        List<TableRow<T>> subRows = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            TableRow<T> subRow = new TableRow<>(items.get(i), i, dataTable);
            subRow.hide();
            TreeGridRowLevel treeGridRowLevel = Optional.ofNullable(tableRow.getMetaObject("tree-grid-row-level"))
                    .map(o -> (TreeGridRowLevel) o)
                    .orElse(new TreeGridRowLevel(2));
            tableRow.addMetaObject(treeGridRowLevel);
            subRow.addMetaObject(new TreeGridRowLevel(treeGridRowLevel.level + 1));
            dataTable.getTableConfig().getPlugins().forEach(plugin -> plugin.onBeforeAddRow(dataTable, subRow));
            dataTable.getTableConfig().drawRecord(dataTable, subRow);
            subRows.add(subRow);

            DominoElement.of(subRow.getRowCells()
                    .get(indentColumn)
                    .getCellInfo()
                    .getElement())
                    .setPaddingLeft(Unit.px.of(treeGridRowLevel.level * 10));
            DominoElement.of(subRow.getRowCells()
                    .get("tree-grid-expand-collapse")
                    .getCellInfo()
                    .getElement())
                    .setPaddingLeft(Unit.px.of(treeGridRowLevel.level * 10));
        }
        tableRow.addMetaObject(new TreeGridSubItems<>(subRows));
    }


    public static class TreeGridRowLevel implements TableRow.RowMetaObject {

        private final int level;

        public TreeGridRowLevel(int level) {
            this.level = level;
        }

        @Override
        public String getKey() {
            return "tree-grid-row-level";
        }
    }


    public static class TreeGridSubItems<T> implements TableRow.RowMetaObject {

        private final List<TableRow<T>> items;

        public TreeGridSubItems(List<TableRow<T>> items) {
            this.items = items;
        }


        @Override
        public String getKey() {
            return "tree-grid-sub-items";
        }
    }

    @FunctionalInterface
    public interface ParentSupplier<T> {
        Node get(T item);
    }

    private class TreeGridRowRenderer implements TableRow.RowRenderer<T> {
        @Override
        public void render(DataTable<T> dataTable, TableRow<T> tableRow) {
            List<ColumnConfig<T>> columns = dataTable.getTableConfig().getColumns();
            List<ColumnConfig<T>> pluginColumns = columns.stream()
                    .filter(ColumnConfig::isPluginColumn)
                    .collect(Collectors.toList());
            pluginColumns.forEach(tableRow::renderCell);

            HTMLTableCellElement cellElement = DominoElement.of(td())
                    .setAttribute("colspan", columns.size() - pluginColumns.size() + "")
                    .appendChild(parentSupplier.get(tableRow.getRecord()))
                    .element();

            RowCell<T> rowCell =
                    new RowCell<>(new CellRenderer.CellInfo<>(tableRow, cellElement), dataTable.getTableConfig().getColumnByName(indentColumn));
            tableRow.addCell(rowCell);

            tableRow.element().appendChild(cellElement);
        }
    }
}
