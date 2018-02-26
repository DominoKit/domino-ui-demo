package com.progressoft.brix.domino.ui.Typography;

import com.progressoft.brix.domino.ui.style.Color;
import com.progressoft.brix.domino.ui.style.Typography;
import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.Node;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.p;

public class Paragraph implements IsElement<HTMLParagraphElement>{

    private HTMLParagraphElement element=p().asElement();
    private Color colorStyle;

    public Paragraph(){

    }

    public Paragraph(String text){
        element.textContent=text;
    }

    public static Paragraph create(){
        return new Paragraph();
    }

    public static Paragraph create(String text){
        return new Paragraph(text);
    }

    public Paragraph setText(String text){
        element.textContent=text;
        return this;
    }

    public Paragraph lead(){
        element.classList.add(Typography.LEAD);
        return this;
    }

    public Paragraph setColor(Color color){
        if(nonNull(colorStyle))
            element.classList.remove(color.getStyle());

        this.colorStyle=color;
        element.classList.add(colorStyle.getStyle());
        return this;
    }

    public Paragraph appendContent(Node content){
        element.appendChild(content);
        return this;
    }

    @Override
    public HTMLParagraphElement asElement() {
        return element;
    }

    public Paragraph bold() {
        element.classList.remove(Typography.BOLD);
        element.classList.add(Typography.BOLD);
        return this;
    }

    public Paragraph italic() {
        element.classList.remove(Typography.ITALIC);
        element.classList.add(Typography.ITALIC);
        return this;
    }

    public Paragraph underLine() {
        element.classList.remove(Typography.UNDER_LINE);
        element.classList.add(Typography.UNDER_LINE);
        return this;
    }

    public Paragraph overLine() {
        element.classList.remove(Typography.OVER_LINE);
        element.classList.add(Typography.OVER_LINE);
        return this;
    }

    public Paragraph lineThrough() {
        element.classList.remove(Typography.LINE_THROUGH);
        element.classList.add(Typography.LINE_THROUGH);
        return this;
    }
}
