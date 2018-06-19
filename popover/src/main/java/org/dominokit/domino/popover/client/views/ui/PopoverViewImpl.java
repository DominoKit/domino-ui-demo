package org.dominokit.domino.popover.client.views.ui;

import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.popover.client.views.CodeResource;
import org.dominokit.domino.popover.client.views.PopoverView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.popover.client.presenters.PopoverPresenter;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.popover.Tooltip;
import org.dominokit.domino.ui.row.Row;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = PopoverPresenter.class)
public class PopoverViewImpl extends ComponentView<HTMLDivElement> implements PopoverView {

    private HTMLDivElement element = div().asElement();
    private Column column = Column.create()
            .onLarge(Column.OnLarge.three)
            .onMedium(Column.OnMedium.three)
            .onSmall(Column.OnSmall.twelve)
            .onXSmall(Column.OnXSmall.twelve);

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("TOOLTIPS & POPOVER").asElement());

        tooltips();

        popover();
    }

    private void tooltips() {
        HTMLElement tooltip_on_right = Button.createPrimary("TOOLTIP ON RIGHT").block().asElement();

        Tooltip.create(tooltip_on_right, "Tooltip on right")
                .position(PopupPosition.RIGHT);

        HTMLElement tooltip_on_top = Button.createPrimary("TOOLTIP ON TOP").block().asElement();

        Tooltip.create(tooltip_on_top, "Tooltip on top")
                .position(PopupPosition.TOP);

        HTMLElement tooltip_on_bottom = Button.createPrimary("TOOLTIP ON BOTTOM").block().asElement();

        Tooltip.create(tooltip_on_bottom, "Tooltip on bottom")
                .position(PopupPosition.BOTTOM);

        HTMLElement tooltip_on_left = Button.createPrimary("TOOLTIP ON LEFT").block().asElement();

        Tooltip.create(tooltip_on_left, "Tooltip on left")
                .position(PopupPosition.LEFT);

        element.appendChild(Card.create("TOOLTIPS")
                .appendContent(Row.create()
                        .addColumn(column.copy()
                                .addElement(tooltip_on_right))
                        .addColumn(column.copy()
                                .addElement(tooltip_on_top))
                        .addColumn(column.copy()
                                .addElement(tooltip_on_bottom))
                        .addColumn(column.copy()
                                .addElement(tooltip_on_left))
                        .asElement())
                .asElement());

        element.appendChild(createCodeCard(CodeResource.tooltips()).asElement());
    }

    private void popover() {
        HTMLElement popover_on_right = Button.createPrimary("POPOVER ON RIGHT").block().asElement();

        Popover.create(popover_on_right, "Popover on right", Paragraph.create("Vivamus sagittis lacus vel augue laoreet rutrum faucibus.").asElement())
                .position(PopupPosition.RIGHT);

        HTMLElement popover_on_top = Button.createPrimary("POPOVER ON TOP").block().asElement();

        Popover.create(popover_on_top, "Popover on right", Paragraph.create("Vivamus sagittis lacus vel augue laoreet rutrum faucibus.").asElement())
                .position(PopupPosition.TOP);

        HTMLElement popover_on_bottom = Button.createPrimary("POPOVER ON BOTTOM").block().asElement();

        Popover.create(popover_on_bottom, "Popover on right", Paragraph.create("Vivamus sagittis lacus vel augue laoreet rutrum faucibus.").asElement())
                .position(PopupPosition.BOTTOM);

        HTMLElement popover_on_left = Button.createPrimary("POPOVER ON LEFT").block().asElement();

        Popover.create(popover_on_left, "Popover on right", Paragraph.create("Vivamus sagittis lacus vel augue laoreet rutrum faucibus.").asElement())
                .position(PopupPosition.LEFT);

        element.appendChild(Card.create("POPOVER")
                .appendContent(Row.create()
                        .addColumn(column.copy()
                                .addElement(popover_on_right))
                        .addColumn(column.copy()
                                .addElement(popover_on_top))
                        .addColumn(column.copy()
                                .addElement(popover_on_bottom))
                        .addColumn(column.copy()
                                .addElement(popover_on_left))
                        .asElement())
                .asElement());

        element.appendChild(createCodeCard(CodeResource.popover()).asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}