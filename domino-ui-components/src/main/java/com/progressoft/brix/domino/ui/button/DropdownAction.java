package com.progressoft.brix.domino.ui.button;

import com.progressoft.brix.domino.ui.utils.HasClickableElement;
import com.progressoft.brix.domino.ui.utils.Justifiable;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public class DropdownAction implements Justifiable, HasClickableElement {

    private HTMLLIElement iElement = Elements.li().asElement();
    private HTMLAnchorElement aElement;
    private JustifyHandler handler;

    private DropdownAction(String content) {
        aElement = Elements.a()
                .attr("href", "javascript:void(0);")
                .textContent(content)
                .asElement();
        iElement.appendChild(aElement);
    }

    public static DropdownAction create(String content) {
        return new DropdownAction(content);
    }

    @Override
    public HTMLElement asElement() {
        return iElement;
    }

    @Override
    public HTMLElement justify() {
        HTMLLIElement justifiedAElement = (HTMLLIElement) asElement().cloneNode(true);
        if (nonNull(handler))
            handler.onJustifiy(justifiedAElement);
        return justifiedAElement;
    }

    @Override
    public void addJustifyHandler(JustifyHandler handler) {
        this.handler = handler;
    }

    @Override
    public HTMLElement getClickableElement() {
        return aElement;
    }
}
