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
import org.dominokit.domino.ui.utils.DominoElement;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.InputType;

import java.util.function.Consumer;

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.code.Code.block;
import static org.jboss.gwt.elemento.core.Elements.input;
import static org.jboss.gwt.elemento.core.Elements.pre;

public class CodeCard extends BaseDominoElement<HTMLDivElement, CodeCard> {

    private HTMLInputElement copyInput = input(InputType.textarea)
            .style("visibility:hidden; width: 0px; height: 0px;").element();
    private String code;
    private HTMLPreElement codeBlock = Elements.pre().css("prettyprint").element();
    private Card card = Card.create("Source Code")
            .setCollapsible()
            .hide()
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

        init(this);
    }

    public static CodeCard createCodeCard(String code) {
        return createCodeCard(code, null);
    }

    public static CodeCard createCodeCard(String code, String lang) {
        CodeCard codeCard = new CodeCard();
        DominoElement.of(codeCard.codeBlock)
                .clearElement()
                .setInnerHtml(PR.prettyPrintOne(code, lang, false));
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
                    DominoElement.of(codeCard.codeBlock).setInnerHtml(PR.prettyPrintOne(resource.getText(), null, false));
                    codeCard.code = resource.getText();
                }
            });
        } catch (ResourceException e) {
            DomGlobal.console.error("could not load code from external resource", e);
        }

        return codeCard;
    }

    public CodeCard setCode(String code) {
        DominoElement.of(this.codeBlock).setInnerHtml(PR.prettyPrintOne(code, null, false));
        this.code = code;
        return this;
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

    public static void completeFetchCode(ExternalTextResource resource, Consumer<String> consumer) {
        try {
            resource.getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load code from external resource", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    consumer.accept(resource.getText());
                }
            });
        } catch (Exception e) {
            DomGlobal.console.error("could not load code from external resource", e);
        }
    }

    public static HTMLPreElement preBlock(String code) {
        return Elements.pre().css("prettyprint").innerHtml(new SafeHtmlBuilder().appendHtmlConstant(PR.prettyPrintOne(code, null, false)).toSafeHtml()).element();
    }

    @Override
    public HTMLDivElement element() {
        return card.element();
    }
}
