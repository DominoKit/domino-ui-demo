package org.dominokit.domino.formsamples.client.views.ui.section;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.jboss.elemento.IsElement;

public interface ImportSection extends IsElement<HTMLElement> {

    void collect(LetterOfCredit letterOfCredit);

    boolean validate();
}
