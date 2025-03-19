package org.dominokit.domino.datatable.client.views.grid;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.footer;

public class GridTable<T> extends BaseDominoElement<HTMLDivElement, GridTable<T>> implements GridTableStyles{

    private final DivElement root;
    private final DivElement header;
    private final DivElement body;
    private final DivElement footer;

    public GridTable(GridTableConfig<T> config) {
        this.root = div()
                .addCss(dui_grid_table)
                .appendChild(header = div().addCss(dui_grid_table_header))
                .appendChild(body = div().addCss(dui_grid_table_body))
                .appendChild(footer = div().addCss(dui_grid_table_footer))
        ;
        init(this);
        config.drawHeaders(this);
    }

    public DivElement getHeader() {
        return header;
    }

    public DivElement getBody() {
        return body;
    }

    public DivElement getFooter() {
        return footer;
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
