package com.progressoft.brix.domino.ui.modals;

import com.progressoft.brix.domino.ui.button.Button;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

public class Link implements IsElement<HTMLElement> {

    private HTMLElement button = Button.create().asElement();

    public Link(String content) {
        button.classList.add("btn-link");
        button.textContent = content;
    }

    public static Link create(String content) {
        return new Link(content);
    }

    @Override
    public HTMLElement asElement() {
        return button;
    }
}
