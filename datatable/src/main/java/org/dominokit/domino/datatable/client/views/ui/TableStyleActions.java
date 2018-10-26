package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.a;

public class TableStyleActions implements IsElement<HTMLElement> {

    private DataTable<?> dataTable;
    private Column column = Column.span12();

    public TableStyleActions(DataTable<?> dataTable) {
        this.dataTable = dataTable;
        init();
    }

    private void init() {
        HTMLAnchorElement condenseAnchor = createButton("Condense", "Expand", Icons.ALL.line_weight(), Icons.ALL.format_line_spacing(), dataTable::condense, dataTable::expand, dataTable::isCondensed);
        HTMLAnchorElement strippedAnchor = createButton("No Stripes", "Stripped", Icons.ALL.power_input(), Icons.ALL.drag_handle(), dataTable::striped, dataTable::noStripes, dataTable::isStriped);
        HTMLAnchorElement borderedAnchor = createButton("No Borders", "Borders", Icons.ALL.border_vertical(), Icons.ALL.border_clear(), dataTable::bordered, dataTable::noBorder, dataTable::isBordered);
        HTMLAnchorElement hoveredAnchor = createButton("No Hover", "Hovered", Icons.ALL.blur_off(), Icons.ALL.blur_on(), dataTable::noHover, dataTable::hovered, () -> !dataTable.isHoverable());

        column.appendChild(condenseAnchor);
        column.appendChild(strippedAnchor);
        column.appendChild(borderedAnchor);
        column.appendChild(hoveredAnchor);
    }

    private HTMLAnchorElement createButton(String initialTooltip, String toggeledTooltip, Icon initialIcon, Icon toggeledIcon, Action initialAction, Action toggeledAction, Condition condition) {
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

        return a().add(initialIcon).asElement();
    }

    @Override
    public HTMLElement asElement() {
        return Style.of(Row.create()
                .addColumn(column)).get().asElement();
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
