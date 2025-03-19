package org.dominokit.domino.datatable.client.views.datagrids;

interface HasVirtualItem<T, I extends WindowItem<T>> {
    VirtualItem<T, I> getVirtualItem();

    void setVirtualItem(VirtualItem<T, I> virtualItem);

    void onSelectionChanged(boolean selection);
}
