package org.dominokit.domino.datatable.client.views.datagrids;

import elemental2.dom.HTMLDivElement;

public class DataListVirtualScroll<V> extends VirtualScrollPanel<V, HTMLDivElement, AbstractDataListItem<V>, DataListVirtualScroll<V>>{
    private final DataList<V> dataList;

    public DataListVirtualScroll(VirtualScrollItemMapper<V, AbstractDataListItem<V>> mapper, DataList<V> dataList) {
        super(mapper);
        this.dataList = dataList;
    }

    @Override
    public void onItemEnterWindow(AbstractDataListItem<V> item, int indexInList) {
        item.setParent(this.dataList);
        item.onEnterWindow(indexInList, dataList, this.dataList.getVirtualScrollPanel().getItemHeight());
    }

    @Override
    public void onItemExitWindow(AbstractDataListItem<V> item, int indexInList) {
        item.onExitWindow(indexInList, dataList, this.dataList.getVirtualScrollPanel().getItemHeight());
    }
}
