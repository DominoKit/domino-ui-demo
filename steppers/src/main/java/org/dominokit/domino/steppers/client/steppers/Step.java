package org.dominokit.domino.steppers.client.steppers;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.li;

public class Step implements IsElement<HTMLLIElement> {

    private final HTMLLIElement element = li().css("step").asElement();
    private final HTMLDivElement contentElement = div().css("step-content").asElement();
    private String title;
    private BlockHeader stepHeader;
    private Stepper stepper;
    private boolean expanded = false;
    Collapsible collapsible = Collapsible.create(contentElement);


    public Step(String title) {
        this.title = title;
        init(BlockHeader.create(title));

    }

    public Step(String title, String description) {
        this.title = title;
        init(BlockHeader.create(title, description));
    }

    private void init(BlockHeader blockHeader) {
        stepHeader = Style.of(blockHeader).css("step-title").get();
        element.appendChild(stepHeader.asElement());
        element.appendChild(contentElement);
        collapsible.collapse();
        ElementUtil.onAttach(asElement(), mutationRecord -> {
            if (expanded) {
                collapsible.expand();
            }
        });
    }

    public static Step create(String title) {
        return new Step(title);
    }

    public static Step create(String title, String description) {
        return new Step(title, description);
    }

    public Step appendContent(Node content) {
        contentElement.appendChild(content);
        return this;
    }

    public Step appendContent(IsElement content) {
        return appendContent(content.asElement());
    }

    Step activate() {
        Style.of(element).css("active");
        collapsible.expand();
        this.expanded = true;
        return this;
    }

    Step deActivate() {
        Style.of(element).removeClass("active");
        collapsible.collapse();
        this.expanded = false;
        return this;
    }

    public void setDone(boolean done) {
        Style.of(element).removeClass("done");
        if (done) {
            Style.of(element).css("done");
        }
    }

    public void invalidate() {
        if (!Style.of(element).hasClass("wrong")) {
            Style.of(element).css("wrong");
        }
    }

    public void clearInvalid() {
        Style.of(element).removeClass("wrong");
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
