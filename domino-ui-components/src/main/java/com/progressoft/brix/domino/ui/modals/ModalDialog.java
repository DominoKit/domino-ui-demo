package com.progressoft.brix.domino.ui.modals;

import com.progressoft.brix.domino.ui.style.Color;
import elemental2.dom.*;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import static java.util.Objects.nonNull;

@Templated
public abstract class ModalDialog implements IsElement<HTMLDivElement>{

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

    boolean autoHide=true;

    private ModalSize modalSize;

    private Color color;

    public static ModalDialog create(String title){
        ModalDialog modalDialog = create();
        modalDialog.showHeader();
        modalDialog.modalHeader.textContent=title;

        return modalDialog;
    }

    public static ModalDialog create(){
        Templated_ModalDialog templated_modalDialog = new Templated_ModalDialog();
        templated_modalDialog.modalHeader.style.display="none";
        templated_modalDialog.modalDialog.addEventListener("click", Event::stopPropagation);
        templated_modalDialog.asElement().addEventListener("click", event -> {
            if (templated_modalDialog.autoHide)
                templated_modalDialog.close();
        });

        return templated_modalDialog;
    }

    public ModalDialog appendContent(Node content){
        modalBody.appendChild(content);
        return this;
    }

    public ModalDialog appendFooterContent(Node content){
        modalFooter.appendChild(content);
        return this;
    }

    public ModalDialog large(){
        if(nonNull(modalSize))
            modalDialog.classList.remove(modalSize.style);
        modalDialog.classList.add(ModalSize.LARGE.style);
        this.modalSize=ModalSize.LARGE;

        return this;
    }

    public ModalDialog small(){
        if(nonNull(modalSize))
            modalDialog.classList.remove(modalSize.style);
        modalDialog.classList.add(ModalSize.SMALL.style);
        this.modalSize=ModalSize.SMALL;

        return this;
    }

    public ModalDialog setModalColor(Color color){
        if(nonNull(this.color))
            modalContent.classList.remove("modal-"+this.color.getStyle());
        modalContent.classList.add("modal-"+color.getStyle());
        this.color=color;
        return this;
    }

    public ModalDialog open(){

        MODAL_BACKDROP.remove();
        DomGlobal.document.body.appendChild(MODAL_BACKDROP);
        asElement().classList.add("in");
        asElement().style.display="block";

        return this;
    }

    public ModalDialog close(){
        MODAL_BACKDROP.remove();
        asElement().classList.remove("in");
        asElement().style.display="none";
        return this;
    }

    public ModalDialog hideFooter(){
        modalFooter.style.display="none";
        return this;
    }

    public ModalDialog showFooter(){
        modalFooter.style.display="block";
        return this;
    }

    public ModalDialog hideHeader(){
        modalHeader.style.display="none";
        return this;
    }

    public ModalDialog showHeader(){
        modalHeader.style.display="block";
        return this;
    }

    public ModalDialog setTitle(String title){
        modalHeader.textContent=title;
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
