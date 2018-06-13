package org.dominokit.domino.datatable.client.views.datatable;

import elemental2.dom.Node;

@FunctionalInterface
public interface CellElement<T> {
    Node asElement(TableRow<T> tableRow);
}
