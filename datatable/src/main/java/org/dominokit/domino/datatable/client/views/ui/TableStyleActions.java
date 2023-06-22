package org.dominokit.domino.datatable.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class TableStyleActions extends BaseDominoElement<HTMLDivElement, TableStyleActions> {

    private DataTable<?> dataTable;
    private DivElement root;

    public TableStyleActions(DataTable<?> dataTable) {
        this.dataTable = dataTable;
        this.root = div().addCss(dui_flex, dui_gap_4, dui_justify_end, dui_p_4);
        init();
    }

    private void init() {
        this.root
                .appendChild(createAction("Condense", "Expand", Icons.arrow_collapse_vertical(), Icons.arrow_expand_vertical(), ()->dataTable.setCondensed(true), ()->dataTable.setCondensed(false), dataTable::isCondensed))
                .appendChild(createAction("No Stripes", "Stripped", Icons.view_day_outline(), Icons.view_day(), ()->dataTable.setStriped(true), ()->dataTable.setStriped(false), dataTable::isStriped))
                .appendChild(createAction("No Borders", "Borders", Icons.border_vertical(), Icons.border_none(), ()->dataTable.setBordered(true), ()->dataTable.setBordered(false), dataTable::isBordered))
                .appendChild(createAction("No Hover", "Hovered", Icons.blur_off(), Icons.blur(), ()->dataTable.setHover(false), ()->dataTable.setHover(true), () -> !dataTable.isHover()));

    }

    private ToggleMdiIcon createAction(String initialTooltip, String toggeledTooltip, MdiIcon initialIcon, MdiIcon toggeledIcon, Action initialAction, Action toggeledAction, Condition condition) {
        return ToggleMdiIcon.create(initialIcon, toggeledIcon)
                .clickable(true)
                .setTooltip(initialTooltip)
                .toggleOnClick(true)
                .apply(self -> {
                    self.addClickListener(evt -> {
                        if (condition.check()) {
                            toggeledAction.execute();
                            self.setTooltip(initialTooltip);
                        } else {
                            initialAction.execute();
                            self.setTooltip(toggeledTooltip);
                        }
                    });
                });

    }

    @Override
    public HTMLDivElement element() {
        return this.root.element();
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
