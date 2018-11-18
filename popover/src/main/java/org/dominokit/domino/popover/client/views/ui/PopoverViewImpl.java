package org.dominokit.domino.popover.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.popover.client.presenters.PopoverPresenter;
import org.dominokit.domino.popover.client.views.PopoverView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.popover.Tooltip;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = PopoverPresenter.class)
public class PopoverViewImpl extends ComponentView<HTMLDivElement> implements PopoverView {

    public static final String MODULE_NAME = "popover";
    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(LinkToSourceCode.create(MODULE_NAME, this.getClass()).asElement());
        element.appendChild(BlockHeader.create("TOOLTIPS & POPOVER").asElement());

        tooltips();

        popover();
    }

    private void tooltips() {
        Button tooltip_on_right = Button.createPrimary("TOOLTIP ON RIGHT").block();

        Tooltip.create(tooltip_on_right, "Tooltip on right")
                .position(PopupPosition.RIGHT);

        Button tooltip_on_top = Button.createPrimary("TOOLTIP ON TOP").block();

        Tooltip.create(tooltip_on_top, "Tooltip on top")
                .position(PopupPosition.TOP);

        Button tooltip_on_bottom = Button.createPrimary("TOOLTIP ON BOTTOM").block();

        Tooltip.create(tooltip_on_bottom, "Tooltip on bottom")
                .position(PopupPosition.BOTTOM);

        Button tooltip_on_left = Button.createPrimary("TOOLTIP ON LEFT").block();

        Tooltip.create(tooltip_on_left, "Tooltip on left")
                .position(PopupPosition.LEFT);

        element.appendChild(Card.create("TOOLTIPS")
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(tooltip_on_right))
                        .addColumn(Column.span3()
                                .appendChild(tooltip_on_top))
                        .addColumn(Column.span3()
                                .appendChild(tooltip_on_bottom))
                        .addColumn(Column.span3()
                                .appendChild(tooltip_on_left))
                        )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"tooltips").asElement());
    }

    private void popover() {
        Button popover_on_right = Button.createPrimary("POPOVER ON RIGHT").block();

        Popover.create(popover_on_right, "Popover on right", Paragraph.create("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                .position(PopupPosition.RIGHT);

        Button popover_on_top = Button.createPrimary("POPOVER ON TOP").block();

        Popover.create(popover_on_top, "Popover on right", Paragraph.create("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                .position(PopupPosition.TOP);

        Button popover_on_bottom = Button.createPrimary("POPOVER ON BOTTOM").block();

        Popover.create(popover_on_bottom, "Popover on right", Paragraph.create("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                .position(PopupPosition.BOTTOM);

        Button popover_on_left = Button.createPrimary("POPOVER ON LEFT").block();

        Popover.create(popover_on_left, "Popover on right", Paragraph.create("Vivamus sagittis lacus vel augue laoreet rutrum faucibus."))
                .position(PopupPosition.LEFT);

        element.appendChild(Card.create("POPOVER")
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(popover_on_right))
                        .addColumn(Column.span3()
                                .appendChild(popover_on_top))
                        .addColumn(Column.span3()
                                .appendChild(popover_on_bottom))
                        .addColumn(Column.span3()
                                .appendChild(popover_on_left)))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"popover").asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}