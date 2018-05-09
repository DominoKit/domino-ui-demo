package org.dominokit.domino.timepicker.client.views.ui;

import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.DomGlobal;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Text;
import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGElement;
import jsinterop.base.Js;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.timepicker.client.views.CodeResource;
import org.dominokit.domino.timepicker.client.views.TimePickerView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.timepicker.client.presenters.TimePickerPresenter;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.gwtproject.safehtml.shared.SafeHtml;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import static elemental2.dom.DomGlobal.*;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = TimePickerPresenter.class)
public class TimePickerViewImpl extends ComponentView<HTMLDivElement> implements TimePickerView{

    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("TIME PICKERS").asElement());

        Button button = Button.createPrimary("TEXT");

        HtmlContentBuilder<HTMLDivElement> div = div();
        Popover popOver = Popover.create(button.asElement(), "test", new TimePicker().asElement())

                .position(PopupPosition.RIGHT);




        element.appendChild(Card.create("TEST")
                .appendContent(button.asElement())
                .asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}