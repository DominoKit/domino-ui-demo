package com.progressoft.brix.domino.ui.modals;

import com.google.gwt.core.client.JsArray;
import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.*;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.*;
import static java.util.Objects.nonNull;

@Templated
public abstract class ModalDialog implements IsElement<HTMLDivElement> {

    private static HTMLDivElement MODAL_BACKDROP = Elements.div().css("modal-backdrop fade in").asElement();

    public enum ModalSize {
        LARGE("modal-lg"),
        SMALL("modal-sm");

        private String style;

        ModalSize(String style) {
            this.style = style;
        }
    }

    @DataElement
    HTMLHeadingElement modalHeader;

    @DataElement
    HTMLDivElement modalBody;

    @DataElement
    HTMLDivElement modalDialog;

    @DataElement
    HTMLDivElement modalContent;

    @DataElement
    HTMLDivElement modalFooter;

    private boolean autoClose = true;

    private ModalSize modalSize;

    private Color color;

    private Element firstFocusElement;
    private Element lastFocusElement;
    private Element activeElementBeforeOpen;
    private List<Element> focusElements = new ArrayList<>();

    public static ModalDialog create(String title) {
        ModalDialog modalDialog = create();
        modalDialog.showHeader();
        modalDialog.modalHeader.textContent = title;

        return modalDialog;
    }

    public static ModalDialog create() {
        Templated_ModalDialog templated_modalDialog = new Templated_ModalDialog();
        templated_modalDialog.modalHeader.style.display = "none";
        templated_modalDialog.modalDialog.addEventListener("click", Event::stopPropagation);
        templated_modalDialog.addCloseHandler();

        templated_modalDialog.addTabIndexHandler();

        return templated_modalDialog;
    }

    void addCloseHandler( ) {
        asElement().addEventListener("click", event -> {
            if (autoClose)
                close();
        });
    }

    void addTabIndexHandler() {
        asElement().addEventListener(EventType.keydown.getName(), evt -> {
            KeyboardEvent keyboardEvent = Js.cast(evt);
            switch (keyboardEvent.code) {
                case "Tab":
                    if (focusElements.size() <= 1) {
                        evt.preventDefault();
                        break;
                    }
                    if (keyboardEvent.shiftKey) {
                        handleBackwardTab(evt);
                    } else {
                        handleForwardTab(evt);
                    }
                    break;
                case "Escape":
                    close();
                    break;
                default:
                    break;
            }

            if (!focusElements.contains(MyDom.document.activeElement)) {
                firstFocusElement.focus();
            }
        });



    }

    private void handleBackwardTab(Event evt) {
        if (MyDom.document.activeElement.equals(firstFocusElement)) {
            evt.preventDefault();
            lastFocusElement.focus();
        }
    }

    private void handleForwardTab(Event evt) {
        if (MyDom.document.activeElement.equals(lastFocusElement)) {
            evt.preventDefault();
            firstFocusElement.focus();
        }
    }

    public ModalDialog appendContent(Node content) {
        modalBody.appendChild(content);
        return this;
    }

    public ModalDialog appendFooterContent(Node content) {
        modalFooter.appendChild(content);
        return this;
    }

    public ModalDialog large() {
        if (nonNull(modalSize))
            modalDialog.classList.remove(modalSize.style);
        modalDialog.classList.add(ModalSize.LARGE.style);
        this.modalSize = ModalSize.LARGE;

        return this;
    }

    public ModalDialog small() {
        if (nonNull(modalSize))
            modalDialog.classList.remove(modalSize.style);
        modalDialog.classList.add(ModalSize.SMALL.style);
        this.modalSize = ModalSize.SMALL;

        return this;
    }

    public ModalDialog setModalColor(Color color) {
        if (nonNull(this.color))
            modalContent.classList.remove("modal-" + this.color.getStyle());
        modalContent.classList.add("modal-" + color.getStyle());
        this.color = color;
        return this;
    }

    public ModalDialog setAutoClose(boolean autoClose) {
        this.autoClose = autoClose;
        if (!autoClose) {
            MODAL_BACKDROP.addEventListener(EventType.keypress.getName(), evt -> {
                evt.stopPropagation();
                evt.preventDefault();
            });

            MODAL_BACKDROP.addEventListener(EventType.mousedown.getName(), evt -> {
                evt.stopPropagation();
                evt.preventDefault();
            });
        }
        return this;
    }

    public ModalDialog open() {

        NodeList<Element> elementNodeList = asElement().querySelectorAll("a[href], area[href], input:not([disabled]), select:not([disabled]), textarea:not([disabled]), button:not([disabled]), [tabindex=\"0\"]");
        List<Element> elements = elementNodeList.asList();

        if (elements.size() > 0) {
            focusElements = elements;
            firstFocusElement = focusElements.get(0);
            lastFocusElement = elements.get(elements.size() - 1);
        } else {
            lastFocusElement = modalContent;
        }

        activeElementBeforeOpen = MyDom.document.activeElement;
        MODAL_BACKDROP.remove();
        document.body.appendChild(MODAL_BACKDROP);
        asElement().classList.add("in");
        asElement().style.display = "block";
        firstFocusElement.focus();

        return this;
    }

    public ModalDialog close() {
        MODAL_BACKDROP.remove();
        asElement().classList.remove("in");
        asElement().style.display = "none";
        if (nonNull(activeElementBeforeOpen))
            activeElementBeforeOpen.focus();
        return this;
    }

    public ModalDialog hideFooter() {
        modalFooter.style.display = "none";
        return this;
    }

    public ModalDialog showFooter() {
        modalFooter.style.display = "block";
        return this;
    }

    public ModalDialog hideHeader() {
        modalHeader.style.display = "none";
        return this;
    }

    public ModalDialog showHeader() {
        modalHeader.style.display = "block";
        return this;
    }

    public ModalDialog setTitle(String title) {
        modalHeader.textContent = title;
        return this;
    }

    public HTMLDivElement getDialogElement() {
        return modalDialog;
    }

    public HTMLDivElement getContentElement() {
        return modalContent;
    }

    public HTMLHeadingElement getHeaderElement() {
        return modalHeader;
    }

    public HTMLDivElement getBodyElement() {
        return modalBody;
    }

    public HTMLDivElement getFooterElement() {
        return modalFooter;
    }
}
