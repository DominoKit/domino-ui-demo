package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.*;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.datatable.*;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.Collections.singletonList;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class TreeGridPlugin<T> implements DataTablePlugin<T> {

    public static final String TREE_GRID_ROW_LEVEL = "tree-grid-row-level";
    public static final String TREE_GRID_EXPAND_COLLAPSE = "plugin-utility-column";
    public static final int DEFAULT_INDENT = 20;
    public static final int BASE_PADDING = 10;
    public static final String ICON_ORDER = "10";

    private final String indentColumn;
    private final Function<T, Optional<Collection<T>>> itemsFunction;
    private ParentRowCellsSupplier<T> parentRowCellsSupplier;
    private Supplier<BaseIcon<?>> expandIconSupplier = () -> Icons.ALL.menu_right_mdi().size18();
    private Supplier<BaseIcon<?>> collapseIconSupplier = () -> Icons.ALL.menu_down_mdi().size18();
    private Supplier<BaseIcon<?>> leafIconSupplier = () -> Icons.ALL.circle_medium_mdi().size18();
    private Function<TableRow<T>, Node> indentColumnElementSupplier = tableRow -> TextNode.empty();
    private int indent = DEFAULT_INDENT;

    public TreeGridPlugin(String indentColumn, Function<T, Optional<Collection<T>>> itemsFunction) {
        this.indentColumn = indentColumn;
        this.itemsFunction = itemsFunction;
    }

    @Override
    public Optional<List<HTMLElement>> getUtilityElements(DataTable<T> dataTable, CellRenderer.CellInfo<T> cellInfo) {
        HTMLElement icon;
        Optional<Collection<T>> items = itemsFunction.apply(cellInfo.getRecord());
        if (!isParent(items)) {
            icon = leafIconSupplier.get().element();
        } else {
            icon = expandIconSupplier.get()
                    .setToggleIcon(collapseIconSupplier.get())
                    .toggleOnClick(true)
                    .clickable()
                    .addClickListener(evt -> {
                        Optional.ofNullable(cellInfo.getTableRow().getChildren())
                                .ifPresent(subItems -> subItems.forEach(BaseDominoElement::toggleDisplay));
                    })
                    .element();
        }
        icon.setAttribute("order", ICON_ORDER);
        DominoElement<HTMLDivElement> title = DominoElement.div()
                .setAttribute("order", "100")
                .appendChild(indentColumnElementSupplier.apply(cellInfo.getTableRow()));
        return Optional.of(Arrays.asList(icon, title.element()));
    }

    @Override
    public Optional<List<HTMLElement>> getUtilityHeaderElements(DataTable<T> dataTable, String columnTitle) {
        BaseIcon<?> baseIcon = expandIconSupplier.get();
        baseIcon.setAttribute("order", ICON_ORDER);
        return Optional.of(singletonList(baseIcon.clickable().element()));
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
            dataTable.getRows().add(subRow);
            subRow.setParent(tableRow);
            subRows.add(subRow);

//            getRowCellElement(subRow, indentColumn).setPaddingLeft(Unit.px.of(treeGridRowLevel.level * indent + BASE_PADDING));
            getRowCellElement(subRow, TREE_GRID_EXPAND_COLLAPSE).setPaddingLeft(Unit.px.of(treeGridRowLevel.level * indent + BASE_PADDING));
        }
        tableRow.setChildren(subRows);
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

    public TreeGridPlugin<T> setIndentColumnElementSupplier(Function<TableRow<T>, Node> indentColumnElementSupplier) {
        if (isNull(indentColumnElementSupplier)) {
            this.indentColumnElementSupplier = tableRow -> TextNode.empty();
        }
        this.indentColumnElementSupplier = indentColumnElementSupplier;
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
