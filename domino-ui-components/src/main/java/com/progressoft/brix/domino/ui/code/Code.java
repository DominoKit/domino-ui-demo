package com.progressoft.brix.domino.ui.code;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLPreElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.code;
import static org.jboss.gwt.elemento.core.Elements.pre;

public class Code{

    public static class Block implements IsElement<HTMLPreElement>{
        private final HTMLPreElement element;

        private Block(HTMLPreElement element) {
            this.element = element;
        }

        @Override
        public HTMLPreElement asElement() {
            return element;
        }
    }

    public static class Statement implements IsElement<HTMLElement>{
        private final HTMLElement element;

        private Statement(HTMLElement element) {
            this.element = element;
        }

        @Override
        public HTMLElement asElement() {
            return element;
        }
    }

    public static Block block(String code){
        return new Block(pre().add(code().textContent(code)).asElement());
    }

    public static Statement statement(String code){
        return new Statement(code().textContent(code).asElement());
    }

}
