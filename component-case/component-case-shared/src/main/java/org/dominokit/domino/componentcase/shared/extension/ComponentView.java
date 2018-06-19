package org.dominokit.domino.componentcase.shared.extension;

import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.ui.cards.Card;

public abstract class ComponentView<T> implements DemoView {
    private boolean initialized = false;

    private void doInit() {
        this.initialized = true;
        init();
    }

    public abstract void init();

    public Content getContent() {
        if (!initialized)
            doInit();
        return (Content<T>) () -> getElement();
    }

    public Card createCodeCard(String codeResource) {
        return Card.createCodeCard(codeResource);
    }

    public abstract T getElement();
}
