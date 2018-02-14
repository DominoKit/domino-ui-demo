package com.progressoft.brix.domino.ui.header;

import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.h;
import static org.jboss.gwt.elemento.core.Elements.small;

public class BlockHeader implements IsElement<HTMLDivElement>{

    private final HTMLDivElement element;

    private BlockHeader(HTMLDivElement element) {
        this.element = element;
    }

    public static BlockHeader create(String header, String description){
        HTMLDivElement element = div().css("block-header")
                .add(h(2).textContent(header).add(small().textContent(description))).asElement();
        return new BlockHeader(element);
    }

    public static BlockHeader create(String header){
        HTMLDivElement element = div().css("block-header")
                .add(h(2).textContent(header)).asElement();
        return new BlockHeader(element);
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
