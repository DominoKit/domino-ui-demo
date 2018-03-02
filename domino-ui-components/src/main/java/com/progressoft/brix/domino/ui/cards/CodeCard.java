package com.progressoft.brix.domino.ui.cards;

import com.progressoft.brix.domino.ui.code.Code;
import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;

public class CodeCard implements IsElement<HTMLDivElement> {

    private Code.Block codeBlock = Code.block();
    private final Card card = Card.create("Source Code")
            .setCollapsible()
            .collapse()
            .appendContent(codeBlock.asElement());


    public static CodeCard create() {
        return new CodeCard();
    }

    public CodeCard setCode(String code){
        codeBlock.setCode(code);
        return this;
    }

    public Code.Block appendCode(String code){
        Code.Block block= Code.block(code);
        card.appendContent(block.asElement());
        return block;
    }

    @Override
    public HTMLDivElement asElement() {
        return card.asElement();
    }

    public Card getCard() {
        return card;
    }
}
