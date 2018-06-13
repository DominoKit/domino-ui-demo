package org.dominokit.domino.datatable.client.views.datatable;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLTableElement;
import elemental2.dom.HTMLTableSectionElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.HasMultiSelectSupport;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.*;

public class DataTable<T> implements IsElement<HTMLDivElement>, HasMultiSelectSupport<TableRow<T>> {

    private HTMLDivElement element=div().css("table-responsive").asElement();
    private HTMLTableElement tableElement = table().css("table").asElement();
    private TableConfig<T> tableConfig;
    private HTMLTableSectionElement tbody=tbody().asElement();
    private Collection<T> data=new HashSet<>();
    private boolean multiSelect=true;
    private boolean selectable=true;
    private List<TableRow<T>> tableRows =new ArrayList<>();

    private List<SelectionChangeListener<T>> selectionChangeListeners =new ArrayList<>();

    public DataTable(TableConfig<T> tableConfig) {
        this.tableConfig = tableConfig;
        init();
    }

    private void init() {
        element.appendChild(tableElement);
        tableConfig.onBeforeHeaders(this);
        tableConfig.drawHeaders(this);
        tableElement.appendChild(tbody);
    }

    public void setData(List<T> data){
        this.data = data;
        tableRows.clear();
        ElementUtil.clear(tbody);
        if(nonNull(data) && !data.isEmpty()){
            for(int index=0;index<data.size(); index++){
                TableRow<T> tableRow =new TableRow<>(data.get(index), index);
                tableConfig.drawRecord(DataTable.this, tableRow);
                tableRows.add(tableRow);
            }
        }
    }

    public DataTable<T> expand(){
        tableElement.classList.remove("table-condensed");

        return this;
    }

    public DataTable<T> condense(){
        expand();
        tableElement.classList.add("table-condensed");

        return this;
    }

    public DataTable<T> noHover(){
        tableElement.classList.remove("table-hover");
        return this;
    }

    public DataTable<T> hovered(){
        noHover();
        tableElement.classList.add("table-hover");

        return this;
    }

    public DataTable<T> noBorder(){
        tableElement.classList.remove("table-bordered");

        return this;
    }

    public DataTable<T> bordered(){
        noBorder();
        tableElement.classList.add("table-bordered");

        return this;
    }

    public DataTable<T> noStripes() {
        tableElement.classList.remove("table-striped");

        return this;
    }

    public DataTable<T> striped() {
        noStripes();
        tableElement.classList.add("table-striped");

        return this;
    }

    public HTMLTableElement tableElement(){
        return tableElement;
    }

    public HTMLTableSectionElement bodyElement(){
        return tbody;
    }

    public TableConfig<T> getTableConfig() {
        return tableConfig;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }


    @Override
    public List<TableRow<T>> getSelectedItems() {
        return tableRows.stream().filter(TableRow::isSelected).collect(Collectors.toList());
    }

    public List<T> getSelectedRecords() {
        return getSelectedItems().stream().map(TableRow::getRecord).collect(Collectors.toList());
    }

    @Override
    public boolean isMultiSelect() {
        return this.multiSelect;
    }

    @Override
    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect=multiSelect;
    }

    @Override
    public List<TableRow<T>> getItems() {
        return tableRows;
    }

    @Override
    public void onSelectionChange(TableRow<T> source) {
        selectionChangeListeners.forEach(selectionChangeListener -> selectionChangeListener.onSelectionChanged(getSelectedItems(), getSelectedRecords()));
    }

    @Override
    public void selectAll() {
        if(isMultiSelect() && !tableRows.isEmpty()) {
            tableRows.forEach(TableRow::select);
            onSelectionChange(tableRows.get(0));
        }
    }

    @Override
    public void deselectAll() {
        if(!tableRows.isEmpty()) {
            tableRows.stream().filter(TableRow::isSelected).forEach(TableRow::deselect);
            onSelectionChange(tableRows.get(0));
        }
    }

    @Override
    public boolean isSelectable() {
        return this.selectable;
    }

    public void addSelectionListner(SelectionChangeListener<T> selectionChangeListener){
        this.selectionChangeListeners.add(selectionChangeListener);
    }

    public void removeSelectionListner(SelectionChangeListener<T> selectionChangeListener){
        this.selectionChangeListeners.remove(selectionChangeListener);
    }

    @FunctionalInterface
    public interface SelectionChangeListener<T>{
        void onSelectionChanged(List<TableRow<T>> selectedTableRows, List<T> selectedRecords);
    }

}
