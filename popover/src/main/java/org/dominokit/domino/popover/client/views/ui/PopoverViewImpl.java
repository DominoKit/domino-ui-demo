package org.dominokit.domino.popover.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.popover.client.presenters.PopoverProxy;
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
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = PopoverProxy.class)
@SampleClass
public class PopoverViewImpl extends BaseDemoView<HTMLDivElement> implements PopoverView {

    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        element.appendChild(LinkToSourceCode.create("popover", this.getClass()).element());
        element.appendChild(BlockHeader.create("TOOLTIPS & POPOVER").element());

        tooltips();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.tooltips()).element());

        popover();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.popover()).element());

        return element;
    }

    @SampleMethod
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
                .element());


    }

    @SampleMethod
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
                .element());


    }
}