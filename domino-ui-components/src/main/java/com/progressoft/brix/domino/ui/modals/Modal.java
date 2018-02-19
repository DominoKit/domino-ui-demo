package com.progressoft.brix.domino.ui.modals;

import com.progressoft.brix.domino.ui.button.Button;
import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.Color;
import com.progressoft.brix.domino.ui.style.StyleType;
import com.progressoft.brix.domino.ui.utils.HasBackground;
import elemental2.dom.*;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public class Modal implements IsElement<HTMLElement>, HasBackground<Modal> {

    private static final String HIDE_STYLE = "display: none";
    private static final String SHOW_STYLE = "display: block; padding-right: 15px;";
    private static final String MODAL_OPEN = "modal-open";
    private static final String FADE_IN = "in";
    private static final String STYLE = "style";

    private final Button button;
    private HTMLDivElement modalBackdrop = Elements.div().css("modal-backdrop fade in").asElement();
    private HTMLElement modal = Elements.div().css("modal fade").attr("tabindex", "-1")
            .attr("role", "dialog")
            .style(HIDE_STYLE).asElement();
    private HTMLDivElement modalDialog = Elements.div().css("modal-dialog").attr("role", "document").asElement();
    private HTMLDivElement modalContent = Elements.div().css("modal-content").asElement();
    private HTMLDivElement modalHeader = Elements.div().css("modal-header").asElement();
    private HTMLHeadingElement modalTitle = Elements.h(4).css("modal-title").asElement();
    private HTMLDivElement modalBody = Elements.div().css("modal-body").asElement();
    private HTMLDivElement modalFooter = Elements.div().css("modal-footer").asElement();
    private boolean autoHide;
    private Color color;
    private Background background;

    public Modal(String buttonContent) {
        initModal();
        button = Button.create(buttonContent);
        button.asElement().setAttribute("data-toggle", "modal");
        button.asElement().addEventListener("click", evt -> {
            show();
            evt.stopPropagation();
        });
    }

    public Modal(String buttonContent, StyleType type) {
        this(buttonContent);
        setStyleType(type);
    }

    private void initModal() {
        modalHeader.appendChild(modalTitle);
        modalContent.appendChild(modalHeader);
        modalContent.appendChild(modalBody);
        modalContent.appendChild(modalFooter);
        modalDialog.appendChild(modalContent);
        modal.appendChild(modalDialog);
        DomGlobal.document.body.appendChild(modal);
        initHideListeners();
    }

    private void initHideListeners() {
        modalContent.addEventListener("click", Event::stopPropagation);
        DomGlobal.window.addEventListener("click", event -> {
            if (autoHide)
                hide();
        });
    }

    private Modal setStyleType(StyleType type) {
        button.setButtonType(type);
        return this;
    }

    public void show() {
        modal.classList.add(FADE_IN);
        modal.setAttribute(STYLE, SHOW_STYLE);
        DomGlobal.document.body.classList.add(MODAL_OPEN);
        DomGlobal.document.body.appendChild(modalBackdrop);
    }

    public void hide() {
        modal.classList.remove(FADE_IN);
        modal.setAttribute(STYLE, HIDE_STYLE);
        DomGlobal.document.body.classList.remove(MODAL_OPEN);
        modalBackdrop.remove();
    }

    public static Modal create(String buttonContent) {
        return new Modal(buttonContent);
    }

    private static Modal create(String buttonContent, StyleType type) {
        return new Modal(buttonContent, type);
    }

    public static Modal createDefault(String buttonContent) {
        return create(buttonContent, StyleType.DEFAULT);
    }

    public static Modal createPrimary(String buttonContent) {
        return create(buttonContent, StyleType.PRIMARY);
    }

    public static Modal createSuccess(String buttonContent) {
        return create(buttonContent, StyleType.SUCCESS);
    }

    public static Modal createInfo(String buttonContent) {
        return create(buttonContent, StyleType.INFO);
    }

    public static Modal createWarning(String buttonContent) {
        return create(buttonContent, StyleType.WARNING);
    }

    public static Modal createDanger(String buttonContent) {
        return create(buttonContent, StyleType.DANGER);
    }

    @Override
    public HTMLElement asElement() {
        return button.asElement();
    }

    public Modal setTitle(String title) {
        modalTitle.textContent = title;
        return this;
    }

    public Modal setDescription(String description) {
        modalBody.textContent = description;
        return this;
    }

    public HTMLHeadingElement getTitleElement() {
        return modalTitle;
    }

    public HTMLDivElement getDialogElement() {
        return modalDialog;
    }

    public HTMLDivElement getContentElement() {
        return modalContent;
    }

    public HTMLDivElement getHeaderElement() {
        return modalHeader;
    }

    public HTMLDivElement getBodyElement() {
        return modalBody;
    }

    public HTMLDivElement getFooterElement() {
        return modalFooter;
    }

    public Modal addLink(Link link) {
        modalFooter.appendChild(link.asElement());
        return this;
    }

    public Modal autoHide() {
        this.autoHide = true;
        return this;
    }

    public Modal largeSize() {
        removeAllSizes();
        modalDialog.classList.add(ModalSize.LARGE.style);
        return this;
    }

    public Modal smallSize() {
        removeAllSizes();
        modalDialog.classList.add(ModalSize.SMALL.style);
        return this;
    }

    public Modal defaultSize() {
        removeAllSizes();
        return this;
    }

    private void removeAllSizes() {
        for (ModalSize modalSize : ModalSize.values()) {
            modalDialog.classList.remove(modalSize.style);
        }
    }

    public Modal setModalColor(Color color) {
        if (nonNull(this.color))
            modalContent.classList.remove("modal-" + color.getStyle());
        modalContent.classList.add("modal-" + color.getStyle());
        this.color = color;
        return this;
    }

    @Override
    public Modal setBackground(Background background) {
        button.setBackground(background);
        return this;
    }

    private enum ModalSize {
        LARGE("modal-lg"),
        SMALL("modal-sm");

        private String style;

        ModalSize(String style) {
            this.style = style;
        }
    }
}
