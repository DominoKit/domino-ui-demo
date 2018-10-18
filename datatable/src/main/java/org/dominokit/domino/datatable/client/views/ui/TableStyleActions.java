package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.IsElement;

public class TableStyleActions implements IsElement<HTMLElement> {

    private DataTable<?> dataTable;
    private Column column = Column.span12();

    public TableStyleActions(DataTable<?> dataTable) {
        this.dataTable = dataTable;
        init();
    }

    private void init() {
        Button condenseButton = createButton("Condense", "Expand", Icons.ALL.line_weight(), Icons.ALL.format_line_spacing(), dataTable::condense, dataTable::expand, dataTable::isCondensed);
        Button strippedButton = createButton("No Stripes", "Stripped", Icons.ALL.power_input(), Icons.ALL.drag_handle(), dataTable::striped, dataTable::noStripes, dataTable::isStriped);
        Button borderedButton = createButton("No Borders", "Borders", Icons.ALL.border_vertical(), Icons.ALL.border_clear(), dataTable::bordered, dataTable::noBorder, dataTable::isBordered);
        Button hoveredButton = createButton("No Hover", "Hovered", Icons.ALL.blur_off(), Icons.ALL.blur_on(), dataTable::noHover, dataTable::hovered, () -> !dataTable.isHoverable());

        column.appendChild(condenseButton);
        column.appendChild(strippedButton);
        column.appendChild(borderedButton);
        column.appendChild(hoveredButton);
    }

    private Button createButton(String initialTooltip, String toggeledTooltip,  Icon initialIcon, Icon toggeledIcon, Action initialAction, Action toggeledAction, Condition condition) {
        Button condenseButton = Button.create(initialIcon)
                .linkify()
                .style()
                .add(Styles.pull_right)
                .setProperty("padding", "0px")
                .setProperty("padding-left", "2px")
                .setHeight("26px")
                .setColor("black", true)
                .add(Styles.pull_right, Styles.m_r_15)
                .get();

        Tooltip tooltip = Tooltip.create(condenseButton.asElement(), TextNode.of(initialTooltip));
        condenseButton.addClickListener(evt -> {
            if (condition.check()) {
                toggeledAction.execute();
                condenseButton.setIcon(initialIcon);
                tooltip.setContent(TextNode.of(initialTooltip));
            } else {
                initialAction.execute();
                condenseButton.setIcon(toggeledIcon);
                tooltip.setContent(TextNode.of(toggeledTooltip));
            }
        });
        return condenseButton;
    }

    @Override
    public HTMLElement asElement() {
        return Style.of(Row.create().addColumn(column)).setMarginBottom("20px").get().asElement();
    }

    @FunctionalInterface
    private interface Action{
        void execute();
    }

    @FunctionalInterface
    public interface Condition{
        boolean check();
    }
}
