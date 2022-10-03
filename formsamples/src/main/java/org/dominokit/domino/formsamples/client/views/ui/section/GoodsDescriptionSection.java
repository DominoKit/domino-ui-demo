package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.TextArea;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;

import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.isInvalidatedCard;
import static org.dominokit.domino.formsamples.client.views.ui.CustomElements.markCardValidation;
import static org.jboss.elemento.Elements.div;

public class GoodsDescriptionSection implements ImportSection {

    private TextArea goodsDescriptionTextArea;
    private Card card;
    private HTMLDivElement element = div().element();

    public GoodsDescriptionSection() {
        element.appendChild(BlockHeader.create("Goods Description *").element());

        goodsDescriptionTextArea = TextArea.create("Goods Description")
                .setAutoValidation(true)
                .setRequired(true)
                .autoSize()
                .setRows(3)
                .addLeftAddOn(Icons.ALL.note_mdi());

        goodsDescriptionTextArea.getInputElement().addEventListener("input", evt -> revalidate());

        card = Card.create()
                .style()
                .setPaddingTop("20px").get();

        element.appendChild(card
                .appendChild(goodsDescriptionTextArea)
                .element());
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {
        letterOfCredit.setDescriptionOfGoods(goodsDescriptionTextArea.getValue());
    }

    @Override
    public boolean validate() {
        boolean valid = isValid();
        markCardValidation(card, valid);
        return valid;
    }

    public void revalidate(){
        if(isInvalidatedCard(card) && isValid()){
            markCardValidation(card, true, false);
        }
    }

    private boolean isValid() {
        return goodsDescriptionTextArea.validate().isValid();
    }

    @Override
    public HTMLElement element() {
        return element;
    }
}
