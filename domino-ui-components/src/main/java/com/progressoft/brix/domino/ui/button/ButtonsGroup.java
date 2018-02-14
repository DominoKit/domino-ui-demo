package com.progressoft.brix.domino.ui.button;

import com.progressoft.brix.domino.ui.utils.Justifiable;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;

public class ButtonsGroup implements IsElement<HTMLElement> {

    private static final String BTN_GROUP = "btn-group";
    private static final String BTN_GROUP_VERTICAL = "btn-group-vertical";

    private List<Justifiable> justifiables = new LinkedList<>();
    private List<HTMLElement> justifiedElements = new LinkedList<>();

    private HTMLElement groupElement = Elements.div().css(BTN_GROUP).attr("role", "group").asElement();
    private ButtonSize size;

    public static ButtonsGroup create() {
        return new ButtonsGroup();
    }

    public ButtonsGroup addButton(Button button) {
        justifiables.add(button);
        appendChild(button.asElement());
        return this;
    }

    public ButtonsGroup addDropDown(DropdownButton nestedDropDown) {
        justifiables.add(nestedDropDown);
        appendChild(nestedDropDown.asElement());
        return this;
    }

    private void appendChild(HTMLElement element) {
        groupElement.appendChild(element);
    }

    public ButtonsGroup removeButton(Button button) {
        removeNode(button.asElement());
        justifiables.remove(button);
        return this;
    }

    public ButtonsGroup removeButtonAt(int index) {
        if (index < 0 || index > groupElement.childElementCount)
            return this;
        Node childAt = groupElement.childNodes.getAt(index);
        if (nonNull(childAt))
            removeNode(childAt);
        justifiables.remove(index);
        return this;
    }

    private void removeNode(Node child) {
        if (groupElement.childNodes.asList().contains(child))
            groupElement.removeChild(child);
    }

    @Override
    public HTMLElement asElement() {
        return groupElement;
    }

    public ButtonsGroup setSize(ButtonSize size) {
        if (nonNull(this.size))
            groupElement.classList.remove("btn-group-" + this.size.getStyle());
        groupElement.classList.add("btn-group-" + size.getStyle());
        this.size = size;
        return this;
    }

    public ButtonsGroup verticalAlign() {
        return switchClasses(BTN_GROUP, BTN_GROUP_VERTICAL);
    }

    public ButtonsGroup horizontalAlign() {
        return switchClasses(BTN_GROUP_VERTICAL, BTN_GROUP);
    }

    private ButtonsGroup switchClasses(String toRemove, String toAdd) {
        groupElement.classList.remove(toRemove);
        groupElement.classList.add(toAdd);
        return this;
    }

    public ButtonsGroup unjustify() {
        removeJustified();
        justifiedElements.clear();

        for (Justifiable justifiable : justifiables) {
            appendChild(justifiable.asElement());
        }
        groupElement.classList.remove(BTN_GROUP + "-justified");
        return this;
    }

    public ButtonsGroup justify() {
        removeJustifiables();
        for (Justifiable justifiable : justifiables) {
            HTMLElement justifiedElement = justifiable.justify();
            groupElement.appendChild(justifiedElement);
            justifiedElements.add(justifiedElement);
        }
        groupElement.classList.add(BTN_GROUP + "-justified");
        return this;
    }

    private void removeJustifiables() {
        for (Justifiable justifiable : justifiables) {
            justifiable.asElement().remove();
        }
    }

    private void removeJustified() {
        for (HTMLElement justifiedElement : justifiedElements) {
            justifiedElement.remove();
        }
    }
}
