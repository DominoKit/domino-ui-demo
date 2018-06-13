package org.dominokit.domino.datatable.client.views.datatable;

public interface DataTablePlugin<T> {

    default void onBeforeAddTable(DataTable<T> dataTable){}
    default void onBeforeAddHeaders(DataTable<T> dataTable){}
    default void onBodyAdded(DataTable<T> dataTable){}
    default void onBeforeAddRow(DataTable<T> dataTable){}
    default void onRowAdded(DataTable<T> dataTable, TableRow<T> tableRow){}
    default void onAllRowsAdded(DataTable<T> dataTable, TableRow<T> tableRow){}

}
