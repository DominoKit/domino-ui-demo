package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.button.IconButton;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.jboss.gwt.elemento.core.IsElement;

public class TableStyleActions implements IsElement<HTMLElement> {

    private DataTable<?> dataTable;
    private Column column = Column.create();

    public TableStyleActions(DataTable<?> dataTable) {
        this.dataTable = dataTable;
        init();
    }

    private void init() {
        IconButton condenseButton = createButton("Condense", "Expand", Icons.ALL.line_weight(), Icons.ALL.format_line_spacing(), () -> dataTable.condense(), () -> dataTable.expand(), () -> dataTable.isCondensed());
        IconButton strippedButton = createButton("No Stripes", "Stripped", Icons.ALL.power_input(), Icons.ALL.drag_handle(), () -> dataTable.striped(), () -> dataTable.noStripes(), () -> dataTable.isStriped());
        IconButton borderedButton = createButton("No Stripes", "Stripped", Icons.ALL.power_input(), Icons.ALL.drag_handle(), () -> dataTable.striped(), () -> dataTable.noStripes(), () -> dataTable.isStriped());

        column.addElement(condenseButton);
        column.addElement(strippedButton);
    }

    private IconButton createButton(String initialTooltip, String toggeledTooltip,  Icon initialIcon, Icon toggeledIcon, Action initialAction, Action toggeledAction, Condition condition) {
        IconButton condenseButton = IconButton.create(initialIcon)
                .linkify();
        Style.of(condenseButton).css(Styles.pull_right);

        Tooltip tooltip = Tooltip.create(condenseButton.asElement(), new Text(initialTooltip));
        Style.of(condenseButton)
                .setProperty("padding", "0px")
                .setProperty("padding-left", "2px")
                .setHeight("26px")
                .setColor("black", true)
                .css(Styles.pull_right, Styles.m_r_15);
        condenseButton.addClickListener(evt -> {
            if (condition.check()) {
                toggeledAction.execute();
                condenseButton.setIcon(initialIcon);
                tooltip.setContent(new Text(initialTooltip));
            } else {
                initialAction.execute();
                condenseButton.setIcon(toggeledIcon);
                tooltip.setContent(new Text(toggeledTooltip));
            }
        });
        return condenseButton;
    }

    @Override
    public HTMLElement asElement() {
        return Style.of(Row.create().addColumn(column).asElement()).setMarginBottom("20px").get().asElement();
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
