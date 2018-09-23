package org.dominokit.domino.componentcase.client.ui.views;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.code.Code;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoDom;
import org.jboss.gwt.elemento.core.InputType;

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.code.Code.block;
import static org.jboss.gwt.elemento.core.Elements.input;

public class CodeCard extends BaseDominoElement<HTMLDivElement, CodeCard> {

    private HTMLInputElement copyInput = input(InputType.textarea).style("visibility:hidden; width: 0px; height: 0px;").asElement();
    private String code;
    private Code.Block codeBlock = block();
    private Card card = Card.create("Source Code")
            .setCollapsible()
            .collapse()
            .appendChild(codeBlock);

    public CodeCard() {
        copyInput.value = code;
        card.addHeaderAction(Icons.ALL.content_copy()
                .setTooltip("Copy code"), evt -> {
            copyInput.select();
            EventListener copyListener = e -> {
                ClipboardEvent clipboardEvent = Js.uncheckedCast(e);
                clipboardEvent.clipboardData.setData("text/plain", code);
                e.preventDefault();
            };
            DomGlobal.document.addEventListener("copy", copyListener);
            DominoDom.document.execCommand("copy");
            DomGlobal.document.removeEventListener("copy", copyListener);
            Notification.createInfo("Code copied to clipboard").show();
        });

        card.appendChild(copyInput);
    }

    public static CodeCard createCodeCard(String code) {
        CodeCard codeCard = new CodeCard();
        codeCard.codeBlock.setCode(code);
        codeCard.code = code;
        return codeCard;
    }

    public static CodeCard createCodeCard(ExternalTextResource codeResource) {
        CodeCard codeCard = new CodeCard();
        try {
            codeResource.getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load code from external resource", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    codeCard.codeBlock.setCode(resource.getText());
                    codeCard.code = resource.getText();
                }
            });
        } catch (ResourceException e) {
            DomGlobal.console.error("could not load code from external resource", e);
        }


        return codeCard;
    }


    public CodeCard setTitle(String title) {
        card.setTitle(title);
        return this;
    }

    public CodeCard setDescription(String description) {
        card.setDescription(description);
        return this;
    }

    public Card getCard() {
        return card;
    }

    @Override
    public CodeCard expand() {
        card.expand();
        return this;
    }

    @Override
    public HTMLDivElement asElement() {
        return card.asElement();
    }
}
