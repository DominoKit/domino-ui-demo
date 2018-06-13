package org.dominokit.domino.datatable.client.views.datatable;

import elemental2.dom.HTMLTableRowElement;
import org.dominokit.domino.ui.utils.Selectable;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.jboss.gwt.elemento.core.Elements.tr;

public class TableRow<T> implements Selectable<T>, IsElement<HTMLTableRowElement> {
    private T record;
    private boolean selected=false;
    private final int index;
    private final Map<String, RowCell<T>> rowCells=new HashMap<>();

    private Map<String, String> flags=new HashMap<>();

    private HTMLTableRowElement element= tr().asElement();
    private List<SelectionHandler<T>> selectionHandlers=new ArrayList<>();

    public TableRow(T record, int index) {
        this.record = record;
        this.index = index;
    }

    @Override
    public T select() {
        this.selected=true;
        selectionHandlers.forEach(selectionHandler -> {
            selectionHandler.onSelectionChanged(TableRow.this);
        });

        return record;
    }

    @Override
    public T deselect() {
        this.selected=false;
        selectionHandlers.forEach(selectionHandler -> selectionHandler.onSelectionChanged(TableRow.this));
        return record;
    }

    @Override
    public T select(boolean silent) {
        this.selected=true;
        return record;
    }

    @Override
    public T deselect(boolean silent) {
        this.selected=false;
        return record;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    public T getRecord() {
        return record;
    }

    @Override
    public void addSelectionHandler(SelectionHandler<T> selectionHandler) {
        this.selectionHandlers.add(selectionHandler);
    }

    @Override
    public HTMLTableRowElement asElement() {
        return element;
    }

    public void setFlag(String name, String value){
        flags.put(name, value);
    }



    public String getFlag(String name){
        return flags.get(name);
    }

    public void addCell(RowCell<T> rowCell) {
        rowCells.put(rowCell.getColumnConfig().getName(), rowCell);
    }

    public RowCell<T> getCell(String name){
        return rowCells.get(name);
    }

    public int getIndex() {
        return index;
    }
}
