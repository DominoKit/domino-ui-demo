package org.dominokit.domino.datatable.client.views.grid;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.datatable.client.views.datagrids.VirtualScrollItemMapper;
import org.dominokit.domino.datatable.client.views.datagrids.VirtualScrollPanel;

public class TestVirtualScrollPanel extends VirtualScrollPanel<Integer, HTMLDivElement,  DivWindowItem<Integer>, TestVirtualScrollPanel> {
    public TestVirtualScrollPanel(VirtualScrollItemMapper<Integer, DivWindowItem<Integer>> mapper) {
        super(mapper);
    }

    @Override
    public void onItemEnterWindow(DivWindowItem<Integer> item, int indexInList) {

    }

    @Override
    public void onItemExitWindow(DivWindowItem<Integer> item, int indexInList) {

    }
}
