package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.style.Style;
import org.jboss.elemento.IsElement;

import static org.jboss.elemento.Elements.a;

public class TableStyleActions implements IsElement<HTMLElement> {

    private DataTable<?> dataTable;
    private Column column = Column.span12();

    public TableStyleActions(DataTable<?> dataTable) {
        this.dataTable = dataTable;
        init();
    }

    private void init() {
        HTMLAnchorElement condenseAnchor = createButton("Condense", "Expand", Icons.ALL.format_line_weight_mdi(), Icons.ALL.format_line_spacing_mdi(), dataTable::condense, dataTable::show, dataTable::isCondensed);
        HTMLAnchorElement strippedAnchor = createButton("No Stripes", "Stripped", Icons.ALL.power_on_mdi(), Icons.ALL.drag_mdi(), dataTable::striped, dataTable::noStripes, dataTable::isStriped);
        HTMLAnchorElement borderedAnchor = createButton("No Borders", "Borders", Icons.ALL.border_vertical_mdi(), Icons.ALL.border_none_mdi(), dataTable::bordered, dataTable::noBorder, dataTable::isBordered);
        HTMLAnchorElement hoveredAnchor = createButton("No Hover", "Hovered", Icons.ALL.blur_off_mdi(), Icons.ALL.blur_mdi(), dataTable::noHover, dataTable::hovered, () -> !dataTable.isHoverable());

        column.appendChild(condenseAnchor);
        column.appendChild(strippedAnchor);
        column.appendChild(borderedAnchor);
        column.appendChild(hoveredAnchor);
    }

    private HTMLAnchorElement createButton(String initialTooltip, String toggeledTooltip, MdiIcon initialIcon, MdiIcon toggeledIcon, Action initialAction, Action toggeledAction, Condition condition) {
        initialIcon
                .clickable()
                .setToggleIcon(toggeledIcon)
                .setTooltip(initialTooltip)
                .toggleOnClick(true)
                .styler(Style::pullRight)
                .apply(icon -> icon.addClickListener(evt -> {
                    if (condition.check()) {
                        toggeledAction.execute();
                        icon.setTooltip(initialTooltip);
                    } else {
                        initialAction.execute();
                        icon.setTooltip(toggeledTooltip);
                    }
                }));

        return a().add(initialIcon).element();
    }

    @Override
    public HTMLElement element() {
        return Style.of(Row.create()
                .addColumn(column)).get().element();
    }

    @FunctionalInterface
    private interface Action {
        void execute();
    }

    @FunctionalInterface
    public interface Condition {
        boolean check();
    }
}
