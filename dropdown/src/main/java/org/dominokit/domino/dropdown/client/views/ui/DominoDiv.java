package org.dominokit.domino.dropdown.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class DominoDiv extends BaseDominoElement<HTMLDivElement, DominoDiv> {
    private HTMLDivElement div;

    public DominoDiv() {
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return div;
    }
}
