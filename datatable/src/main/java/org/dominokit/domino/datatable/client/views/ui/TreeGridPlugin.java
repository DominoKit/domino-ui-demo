package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLTableCellElement;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class TreeGridPlugin<T> implements DataTablePlugin<T> {

    public static final String TREE_GRID_ROW_LEVEL = "tree-grid-row-level";
    public static final String TREE_GRID_EXPAND_COLLAPSE = "plugin-utility-column";
    public static final int DEFAULT_INDENT = 20;
    public static final int BASE_PADDING = 10;

    private final String indentColumn;
    private final Function<T, Optional<Collection<T>>> itemsFunction;
    private ParentRowCellsSupplier<T> parentRowCellsSupplier;
    private Supplier<BaseIcon<?>> expandIconSupplier = () -> Icons.ALL.plus_mdi().size18();
    private Supplier<BaseIcon<?>> collapseIconSupplier = () -> Icons.ALL.minus_mdi().size18();
    private Supplier<BaseIcon<?>> leafIconSupplier = () -> Icons.ALL.circle_medium_mdi().size18();
    private int indent = DEFAULT_INDENT;

    public TreeGridPlugin(String indentColumn, Function<T, Optional<Collection<T>>> itemsFunction) {
        this.indentColumn = indentColumn;
        this.itemsFunction = itemsFunction;
    }

    @Override
    public Optional<HTMLElement> getUtilityElement(DataTable<T> dataTable, CellRenderer.CellInfo<T> cellInfo) {
        Optional<Collection<T>> items = itemsFunction.apply(cellInfo.getRecord());
        if (!isParent(items)) {
            return Optional.of(leafIconSupplier.get().element());
        }
        return Optional.of(expandIconSupplier.get()
                .setToggleIcon(collapseIconSupplier.get())
                .toggleOnClick(true)
                .clickable()
                .addClickListener(evt -> {
                    Optional.ofNullable(cellInfo.getTableRow().getMetaObject("tree-grid-sub-items"))
                            .map(o -> (TreeGridSubItems<T>) o)
                            .ifPresent(subItems -> subItems.items.forEach(BaseDominoElement::toggleDisplay));
                })
                .element());
    }

    @Override
    public Optional<HTMLElement> getUtilityHeaderElement(DataTable<T> dataTable, String columnTitle) {
        return Optional.of(expandIconSupplier.get().clickable().element());
    }

    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
//        dataTable
//                .getTableConfig()
//                .insertColumnFirst(
//                        ColumnConfig.<T>create(TREE_GRID_EXPAND_COLLAPSE)
//                                .setSortable(false)
//                                .setPluginColumn(true)
//                                .styleHeader(element -> Style.of(element).setWidth("3px", true))
//                                .styleCell(element -> Style.of(element).setWidth("3px", true))
//                                .setCellRenderer(
//                                        cell -> {
//                                            Optional<Collection<T>> items = itemsFunction.apply(cell.getRecord());
//                                            if (!isParent(items)) {
//                                                return leafIconSupplier.get().element();
//                                            }
//                                            return expandIconSupplier.get()
//                                                    .setToggleIcon(collapseIconSupplier.get())
//                                                    .toggleOnClick(true)
//                                                    .clickable()
//                                                    .addClickListener(evt -> {
//                                                        Optional.ofNullable(cell.getTableRow().getMetaObject("tree-grid-sub-items"))
//                                                                .map(o -> (TreeGridSubItems<T>) o)
//                                                                .ifPresent(subItems -> subItems.items.forEach(BaseDominoElement::toggleDisplay));
//                                                    })
//                                                    .element();
//                                        }));
    }

    @Override
    public void onBeforeAddRow(DataTable<T> dataTable, TableRow<T> tableRow) {
        if (nonNull(parentRowCellsSupplier)) {
            Optional<Collection<T>> items = itemsFunction.apply(tableRow.getRecord());
            if (isParent(items)) {
                tableRow.setRowRenderer(new TreeGridRowRenderer());
            }
        }
    }

    @Override
    public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
        Optional<Collection<T>> itemsOptional = itemsFunction.apply(tableRow.getRecord());
        if (!isParent(itemsOptional)) {
            return;
        }
        List<T> items = new ArrayList<>(itemsOptional.get());
        List<TableRow<T>> subRows = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            TableRow<T> subRow = new TableRow<>(items.get(i), i, dataTable);
            subRow.hide();
            TreeGridRowLevel treeGridRowLevel = Optional.ofNullable(tableRow.getMetaObject(TREE_GRID_ROW_LEVEL))
                    .map(o -> (TreeGridRowLevel) o)
                    .orElse(new TreeGridRowLevel(1));
            tableRow.addMetaObject(treeGridRowLevel);
            subRow.addMetaObject(new TreeGridRowLevel(treeGridRowLevel.level + 1));
            dataTable.getTableConfig().getPlugins().forEach(plugin -> plugin.onBeforeAddRow(dataTable, subRow));
            dataTable.getTableConfig().drawRecord(dataTable, subRow);
            dataTable.getItems().add(subRow);
            subRows.add(subRow);

            getRowCellElement(subRow, indentColumn).setPaddingLeft(Unit.px.of(treeGridRowLevel.level * indent + BASE_PADDING));
            getRowCellElement(subRow, TREE_GRID_EXPAND_COLLAPSE).setPaddingLeft(Unit.px.of(treeGridRowLevel.level * indent + BASE_PADDING));
        }
        tableRow.addMetaObject(new TreeGridSubItems<>(subRows));
    }

    private DominoElement<HTMLTableCellElement> getRowCellElement(TableRow<T> subRow, String name) {
        return DominoElement.of(subRow.getRowCells()
                .get(name)
                .getCellInfo()
                .getElement());
    }

    public TreeGridPlugin<T> setParentRowCellsSupplier(ParentRowCellsSupplier<T> parentRowCellsSupplier) {
        this.parentRowCellsSupplier = parentRowCellsSupplier;
        return this;
    }

    public TreeGridPlugin<T> setExpandIconSupplier(Supplier<BaseIcon<?>> expandIconSupplier) {
        if (isNull(expandIconSupplier)) {
            this.expandIconSupplier = () -> Icons.ALL.plus_mdi().size18();
        }
        this.expandIconSupplier = expandIconSupplier;
        return this;
    }

    public TreeGridPlugin<T> setCollapseIconSupplier(Supplier<BaseIcon<?>> collapseIconSupplier) {
        if (isNull(collapseIconSupplier)) {
            this.collapseIconSupplier = () -> Icons.ALL.minus_mdi().size18();
        }
        this.collapseIconSupplier = collapseIconSupplier;
        return this;
    }

    public TreeGridPlugin<T> setLeafIconSupplier(Supplier<BaseIcon<?>> leafIconSupplier) {
        if (isNull(leafIconSupplier)) {
            this.leafIconSupplier = () -> Icons.ALL.circle_medium_mdi().size18();
        }
        this.leafIconSupplier = leafIconSupplier;
        return this;
    }

    public TreeGridPlugin<T> setIndent(int indent) {
        if (indent < 0) {
            this.indent = DEFAULT_INDENT;
        }
        this.indent = indent;
        return this;
    }

    private boolean isParent(Optional<Collection<T>> items) {
        return items.isPresent() && !items.get().isEmpty();
    }

    @FunctionalInterface
    public interface ParentRowCellsSupplier<T> {
        List<RowCell<T>> get(DataTable<T> dataTable, TableRow<T> tableRow);
    }

    public static class TreeGridRowLevel implements TableRow.RowMetaObject {
        private final int level;

        public TreeGridRowLevel(int level) {
            this.level = level;
        }

        @Override
        public String getKey() {
            return TREE_GRID_ROW_LEVEL;
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

    private class TreeGridRowRenderer implements TableRow.RowRenderer<T> {
        @Override
        public void render(DataTable<T> dataTable, TableRow<T> tableRow) {
            List<ColumnConfig<T>> columns = dataTable.getTableConfig().getColumns();
            ColumnConfig<T> indentColumnConfig = dataTable.getTableConfig().getColumnByName(indentColumn);
            columns.subList(0, columns.indexOf(indentColumnConfig)).forEach(tableRow::renderCell);

            List<RowCell<T>> rowCells = parentRowCellsSupplier.get(dataTable, tableRow);
            rowCells.forEach(rowCell -> {
                tableRow.addCell(rowCell);
                tableRow.element().appendChild(rowCell.getCellInfo().getElement());
            });
        }
    }
}
