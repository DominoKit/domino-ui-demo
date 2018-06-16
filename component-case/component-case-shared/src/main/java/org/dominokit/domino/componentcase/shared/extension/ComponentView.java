package org.dominokit.domino.componentcase.shared.extension;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.DomGlobal;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.code.Code;

public abstract class ComponentView<T> implements DemoView{
    private boolean initialized=false;

    private void doInit(){
        this.initialized=true;
        init();
    }

    public abstract void init();

    public Content getContent(){
        if(!initialized)
            doInit();
        return (Content<T>) () -> getElement();
    }

    public Card createCodeCard(ExternalTextResource codeResource) {
        Code.Block block = Code.block();
        try {
            codeResource.getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load code from external resource", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    block.setCode(resource.getText());
                }
            });
        } catch (ResourceException e) {
            DomGlobal.console.error("could not load code from external resource", e);
        }
        return Card.create("Source Code")
                .setCollapsible()
                .collapse()
                .appendContent(block.asElement());
    }

    public abstract T getElement();
}
