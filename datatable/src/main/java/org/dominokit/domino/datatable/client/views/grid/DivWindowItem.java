package org.dominokit.domino.datatable.client.views.grid;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.datatable.client.views.datagrids.ElementWindowItem;
import org.dominokit.domino.datatable.client.views.datagrids.VirtualItem;
import org.dominokit.domino.datatable.client.views.datagrids.WindowItem;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.SupplyOnce;
import org.dominokit.domino.ui.utils.Unit;

import static org.dominokit.domino.ui.style.DisplayCss.dui_absolute;
import static org.dominokit.domino.ui.style.SpacingCss.*;
import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.elementOf;

public class DivWindowItem<T> implements ElementWindowItem<T, HTMLDivElement, DivWindowItem<T>> {


    private T value;
    private SupplyOnce<DivElement> elementProvider;
    public DivWindowItem(T value) {
        this.value = value;
        this.elementProvider =SupplyOnce.of(()->div()
                .addCss(dui_h_16, dui_w_full, dui_absolute, dui_left_0, dui_p_1)
                .addCss(()->"dui-data-grid-row")
                .textContent(String.valueOf(value)));
    }

    @Override
    public T get() {
        return value;
    }

    public void onEnterWindow(DivWindowItem<T> item, int index, Element parent, int itemHeight) {
        elementOf(parent).appendChild(elementProvider.get()
                .setTop(Unit.px.of(itemHeight * index))
        );
    }

    public void onExitWindow(DivWindowItem<T> item, int index, Element parent, int itemHeight) {
        elementProvider.get().remove();
    }

    @Override
    public HTMLDivElement element() {
        return elementProvider.get().element();
    }

    @Override
    public VirtualItem<T, WindowItem<T>> getVirtualItem() {
        return null;
    }

    @Override
    public void setVirtualItem(VirtualItem<T, WindowItem<T>> virtualItem) {

    }

    @Override
    public void onSelectionChanged(boolean selection) {

    }
}
