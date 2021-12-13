package org.dominokit.domino.datatable.client.views.ui;

import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;

public class TreeGridPlugin<T extends TreeNode<T>> implements DataTablePlugin<T> {

    private final String indentColumn;

    public TreeGridPlugin(String indentColumn) {
        this.indentColumn = indentColumn;
    }

    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
        dataTable
                .getTableConfig()
                .insertColumnFirst(
                        ColumnConfig.<T>create("tree-grid-expand-collapse")
                                .setSortable(false)
                                .styleHeader(element -> Style.of(element).setPadding("0px", true).setWidth("3px", true))
                                .styleCell(element -> Style.of(element).setPadding("0px", true).setWidth("3px", true))
                                .setCellRenderer(
                                        cell -> {
                                            if (isNull(cell.getRecord().getItems()) || cell.getRecord().getItems().isEmpty()) {
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
    public void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow) {
        List<T> items = tableRow.getRecord().getItems();
        if (isNull(items)) {
            return;
        }
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


    public static class TreeGridSubItems<T extends TreeNode<T>> implements TableRow.RowMetaObject {

        private final List<TableRow<T>> items;

        public TreeGridSubItems(List<TableRow<T>> items) {
            this.items = items;
        }


        @Override
        public String getKey() {
            return "tree-grid-sub-items";
        }
    }
}
