package com.progressoft.brix.domino.cards.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("cardsWithHeaders.txt")
    ExternalTextResource cardsWithHeaders();

    @Source("coloredCards.txt")
    ExternalTextResource coloredCards();

    @Source("collapsibleCards.txt")
    ExternalTextResource collapsibleCards();

    @Source("noHeaderCards.txt")
    ExternalTextResource noHeaderCards();

}

