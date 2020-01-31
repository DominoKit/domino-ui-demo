package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.style.Styles;

import static org.jboss.elemento.Elements.p;

public class AuthorizationSection implements ImportSection {

    private final Card card = Card.create();

    public AuthorizationSection() {
        card
                .appendChild(p()
                        .css(Styles.LEAD)
                        .textContent("Authorization Request"))
                .appendChild(p()
                        .textContent("We Hereby Request you to issue this irrevocable Documentary Credit for our full account.risk and responsibility , and in accordance with the conditions below stated by us in this application confirm that we are familiar with and accept the standard terms and conditions of issuance of documentary credits as reflected on the last page of this application.\n" +
                                "\n" +
                                "This Documentary Credit is subject to the ICC publication Uniform Customs and Practice 600"));
    }

    @Override
    public void collect(LetterOfCredit letterOfCredit) {

    }

    @Override
    public boolean validate() {
        return true;
    }

    @Override
    public HTMLElement element() {
        return card.element();
    }
}
