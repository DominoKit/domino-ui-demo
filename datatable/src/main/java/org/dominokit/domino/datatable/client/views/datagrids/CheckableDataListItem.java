package org.dominokit.domino.datatable.client.views.datagrids;

import elemental2.dom.DomGlobal;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import java.util.Set;

import static org.dominokit.domino.ui.style.GenericCss.dui_minified;
import static org.dominokit.domino.ui.style.SpacingCss.dui_hide_label;

public class CheckableDataListItem<V> extends DataListItem<V> {

    private final CheckBox checkBox;

    /**
     * Constructs a menu item with the specified text.
     *
     * @param text  the text for the menu item
     * @param value
     */
    public CheckableDataListItem(String text, V value) {
        super(text, value);
        checkBox = CheckBox.create();
        appendChild(PrefixAddOn.of(checkBox
                        .addCss(dui_minified, dui_hide_label)
                        .addChangeListener((oldValue, newValue) -> {
                            if(newValue) {
                                getVirtualItem().select();
                            } else {
                                getVirtualItem().deselect();
                            }
                        })
                )
        );
        setClickToSelect(false);
    }

    /**
     * Creates a menu item with the specified text.
     *
     * @param text the text for the menu item
     * @return the created menu item
     */
    public static <V> CheckableDataListItem<V> create(String text, V value) {
        return new CheckableDataListItem<>(text, value);
    }

    @Override
    public Set<CloseListener<? super AbstractDataListItem<V>>> getCollapseListeners() {
        return super.getCollapseListeners();
    }

    @Override
    public void onSelectionChanged(boolean selection) {
        checkBox.withValue(selection, true);
    }

    @Override
    public void setVirtualItem(VirtualItem<V, WindowItem<V>> virtualItem) {
        super.setVirtualItem(virtualItem);
        virtualItem.setSelectable(true);
    }
}
