package org.dominokit.domino.datatable.client.views.datatable;

import elemental2.dom.Text;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.style.Style;

public class SelectionPlugin<T> implements DataTablePlugin<T> {

    @Override
    public void onBeforeAddHeaders(DataTable<T> dataTable) {
        dataTable.getTableConfig().insertColumnFirst(ColumnConfig.<T>create("data-table-select-cm")
        .setHeaderElement(columnTitle -> {
            if(dataTable.isMultiSelect()){
                CheckBox checkBox = createCheckBox();
                checkBox.addCheckHandler(checked -> {
                    if(checked){
                        dataTable.selectAll();
                    }else{
                        dataTable.deselectAll();
                    }
                });

                dataTable.addSelectionListner((selectedRows, selectedRecords) -> {
                    if(selectedRows.size()!=dataTable.getItems().size()){
                        checkBox.uncheck(true);
                    }else{
                        checkBox.check(true);
                    }
                });
                return checkBox.asElement();
            }else{
                return new Text("");
            }

        })
        .setCellElement(row -> {
            CheckBox checkBox = createCheckBox();

            row.addSelectionHandler(selectable -> {
                if(selectable.isSelected()){
                    checkBox.check(true);
                }else{
                    checkBox.uncheck(true);
                }
            });

            checkBox.addCheckHandler(checked -> {
                if(checked){
                    row.select();
                    dataTable.onSelectionChange(row);
                }else{
                    row.deselect();
                    dataTable.onSelectionChange(row);
                }
            });
            return checkBox.asElement();
        }).asHeader());
    }

    private CheckBox createCheckBox() {
        CheckBox checkBox = CheckBox.create();
        Style.of(checkBox).setMargin("0px");
        Style.of(checkBox.getInputElement()).setMargin("0px");
        Style.of(checkBox.getLabelElement()).setMargin("0px");
        Style.of(checkBox.getLabelElement()).setHeight("20px");
        return checkBox;
    }

}
