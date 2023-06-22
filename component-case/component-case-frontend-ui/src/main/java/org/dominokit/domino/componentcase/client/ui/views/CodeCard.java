package org.dominokit.domino.componentcase.client.ui.views;

import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.ResourceCallback;
import com.google.gwt.resources.client.ResourceException;
import com.google.gwt.resources.client.TextResource;
import elemental2.dom.ClipboardEvent;
import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import jsinterop.base.Js;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.collapsible.DisplayCollapseStrategy;
import org.dominokit.domino.ui.elements.PreElement;
import org.dominokit.domino.ui.elements.TextAreaElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoDom;
import org.dominokit.domino.ui.utils.ElementsFactory;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

import java.util.function.Consumer;

public class CodeCard extends BaseDominoElement<HTMLDivElement, CodeCard> {

    private TextAreaElement copyInput;
    private String code;
    private PreElement codeBlock;
    private Card card;

    public CodeCard() {
        copyInput = textarea()
                .style("visibility:hidden; width: 0px; height: 0px;");
        codeBlock = pre().addCss(()->"prettyprint");
        copyInput.element().value = code;
        card = Card.create("Source Code")
                .setCollapsible(true)
                .appendChild(codeBlock);
        card
                .withHeader((card, header) -> {
                    header.appendChild(PostfixAddOn.of(Icons.content_copy()
                            .clickable()
                            .setTooltip("Copy code")
                            .addClickListener(evt -> {
                                copyInput.element().select();
                                EventListener copyListener = e -> {
                                    ClipboardEvent clipboardEvent = Js.uncheckedCast(e);
                                    clipboardEvent.clipboardData.setData("text/plain", code);
                                    e.preventDefault();
                                };
                                DomGlobal.document.addEventListener("copy", copyListener);
                                DominoDom.document.execCommand("copy");
                                DomGlobal.document.removeEventListener("copy", copyListener);
                                Notification.create("Code copied to clipboard")
                                        .addCss(dui_info)
                                        .show();
                            })
                    ));
                });

        card.appendChild(copyInput);

        init(this);
    }

    public static CodeCard createCodeCard(String code) {
        return createCodeCard(code, null);
    }

    public static CodeCard createCodeCard(String code, String lang) {
        CodeCard codeCard = new CodeCard();
        codeCard.getCard().collapse();
        codeCard.codeBlock
                .clearElement()
                .setInnerHtml(PR.prettyPrintOne(code, lang, false));
        codeCard.code = code;
        return codeCard;
    }

    public static CodeCard createCodeCard(ExternalTextResource codeResource) {
        CodeCard codeCard = new CodeCard();
        codeCard.getCard().collapse();
        try {
            codeResource.getText(new ResourceCallback<TextResource>() {
                @Override
                public void onError(ResourceException e) {
                    DomGlobal.console.error("could not load code from external resource", e);
                }

                @Override
                public void onSuccess(TextResource resource) {
                    codeCard.codeBlock.setInnerHtml(PR.prettyPrintOne(resource.getText().replace("<", "&lt;").replace(">", "&gt;"), null, false));
                    codeCard.code = resource.getText();
                }
            });
        } catch (ResourceException e) {
            DomGlobal.console.error("could not load code from external resource", e);
        }

        return codeCard;
    }

    public static CodeCard createLazyCodeCard(ExternalTextResource codeResource) {
        CodeCard codeCard = new CodeCard();
        codeCard.getCard()
                .withBody((parent, body) -> body.setCollapseStrategy(new DisplayCollapseStrategy()));
        codeCard.getCard().collapse();
        codeCard.getCard().addExpandListener(() -> {
            try {
                codeResource.getText(new ResourceCallback<TextResource>() {
                    @Override
                    public void onError(ResourceException e) {
                        DomGlobal.console.error("could not load code from external resource", e);
                    }

                    @Override
                    public void onSuccess(TextResource resource) {
                        codeCard.codeBlock.setInnerHtml(PR.prettyPrintOne(resource.getText().replace("<", "&lt;").replace(">", "&gt;"), null, false));
                        codeCard.code = resource.getText();
                    }
                });
            } catch (ResourceException e) {
                DomGlobal.console.error("could not load code from external resource", e);
            }
        });
        codeCard.getCard().addCollapseListener(() -> {
            codeCard.codeBlock.clearElement();
        });

        return codeCard;
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

    public static PreElement preBlock(String code) {
        return ElementsFactory.elements.pre()
                .addCss("prettyprint").setInnerHtml(new SafeHtmlBuilder().appendHtmlConstant(PR.prettyPrintOne(code, null, false)).toSafeHtml());
    }

    public Card getCard() {
        return card;
    }

    public CodeCard setCode(String code) {
        this.codeBlock.setInnerHtml(PR.prettyPrintOne(code, null, false));
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

    @Override
    public HTMLDivElement element() {
        return card.element();
    }
}
