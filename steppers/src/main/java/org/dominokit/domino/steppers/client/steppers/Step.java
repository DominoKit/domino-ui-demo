package org.dominokit.domino.steppers.client.steppers;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Style;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.li;

public class Step implements IsElement<HTMLLIElement> {

    private final HTMLLIElement element=li().css("step").asElement();
    private final HTMLDivElement contentElement=div().css("step-content").asElement();
    private  BlockHeader stepHeader;
    private Stepper stepper;

    public Step(String title) {
        stepHeader = Style.of(BlockHeader.create(title)).css("step-title").get();
        element.appendChild(stepHeader.asElement());
        element.appendChild(contentElement);
    }

    public Step(String title, String description) {
        stepHeader = Style.of(BlockHeader.create(title, description)).css("step-title").get();
        element.appendChild(stepHeader.asElement());
        element.appendChild(contentElement);
    }

    public static Step create(String title){
        return new Step(title);
    }

    public static Step create(String title, String description){
        return new Step(title, description);
    }

    public Step appendContent(Node content){
        contentElement.appendChild(content);
        return this;
    }

    public Step appendContent(IsElement content){
        return appendContent(content.asElement());
    }

    public Step activate(){
        Style.of(element).css("active");
        Style.of(contentElement).setDisplay("block");

        return this;
    }

    public Step deActivate(){
        Style.of(element).removeClass("active");
        Style.of(contentElement).setDisplay("none");

        return this;
    }

    public HTMLDivElement getContentElement() {
        return contentElement;
    }

    public BlockHeader getStepHeader() {
        return stepHeader;
    }

    void setStepper(Stepper stepper) {
        this.stepper = stepper;
    }

    @Override
    public HTMLLIElement asElement() {
        return element;
    }
}
