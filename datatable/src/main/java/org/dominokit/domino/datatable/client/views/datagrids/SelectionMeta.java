package org.dominokit.domino.datatable.client.views.datagrids;

import org.dominokit.domino.ui.utils.ComponentMeta;

public class SelectionMeta implements ComponentMeta {

    public static final String DUI_SELECTION_META_KEY = "dui-selection-meta-key";
    private boolean selected;

    public SelectionMeta(boolean selected) {
        this.selected = selected;
    }

    public static SelectionMeta of(boolean selected) {
        return new SelectionMeta(selected);
    }

    public boolean isSelected() {
        return selected;
    }

    @Override
    public String getKey() {
        return DUI_SELECTION_META_KEY;
    }
}
