package org.dominokit.domino.datatable.client.views.grid;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.CssProperty;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoId;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.span;

public class GridColumnConfig<T> extends BaseDominoElement<HTMLDivElement, GridColumnConfig<T>> implements GridTableStyles {

    private final DivElement root;
    private final String uniqueId;
    private String name;
    private String title;
    private String width;
    private String minWidth;
    private String maxWidth;
    private SpanElement titleElement;

    public GridColumnConfig(String name) {
        this.name = name;
        this.title = name;
        this.uniqueId = DominoId.unique("col-");
        this.root = div()
                .appendChild(titleElement = span()
                        .addCss(dui_grid_table_column_title)
                        .textContent(this.title))
                .addCss(dui_grid_table_column);
        init(this);
    }

    public static <T> GridColumnConfig<T> create(String name) {
        return new GridColumnConfig<>(name);
    }

    public static <T> GridColumnConfig<T> create(String name, String title) {
        GridColumnConfig<T> column = new GridColumnConfig<>(name);
        return column.setTitle(title);
    }

    public String getName() {
        return name;
    }

    public GridColumnConfig<T> setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public GridColumnConfig<T> setTitle(String title) {
        this.title = title;
        this.titleElement.textContent(this.title);
        return this;
    }

    public String getWidth() {
        return width;
    }

    public GridColumnConfig<T> setWidth(String width) {
        this.width = width;
        return this;
    }

    public String getMinWidth() {
        return minWidth;
    }

    public GridColumnConfig<T> setMinWidth(String minWidth) {
        this.minWidth = minWidth;
        return this;
    }

    public String getMaxWidth() {
        return maxWidth;
    }

    public GridColumnConfig<T> setMaxWidth(String maxWidth) {
        this.maxWidth = maxWidth;
        return this;
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }

    public CssProperty getWidthProperty() {
        return CssProperty.of("--dui-table-" + uniqueId + "-width", GridUtil.buildGridColumnValue(width, minWidth, maxWidth));
    }
}
