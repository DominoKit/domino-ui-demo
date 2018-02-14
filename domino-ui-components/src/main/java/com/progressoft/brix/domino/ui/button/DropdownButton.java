package com.progressoft.brix.domino.ui.button;

import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.utils.Justifiable;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.core.Elements;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;

public class DropdownButton implements Justifiable {

    private HTMLElement groupElement = ButtonsGroup.create().asElement();
    private HTMLUListElement actionsElement = Elements.ul().css("dropdown-menu").asElement();
    private Button button;
    private List<Justifiable> items = new LinkedList<>();
    private HTMLElement justifiedElement;
    private JustifyHandler handler;

    private DropdownButton(String content, ButtonType type) {
        this(Button.create(content, type));
    }

    private DropdownButton(String content, Background background) {
        this(Button.create(content, background));
    }

    private DropdownButton(String content) {
        this(Button.create(content));
    }

    private DropdownButton(Button button) {
        this.button = button;
        configureButton();
    }

    private void configureButton() {
        HTMLElement buttonElement = asDropDown(button.asElement(), groupElement);
        addHideListener(groupElement);
        groupElement.appendChild(buttonElement);
        groupElement.appendChild(actionsElement);
    }

    private void addHideListener(HTMLElement groupElement) {
        DomGlobal.document.addEventListener("click", evt -> {
            groupElement.classList.remove("open");
        });
    }

    private HTMLElement asDropDown(HTMLElement buttonElement, HTMLElement groupElement) {
        buttonElement.classList.add("dropdown-toggle");
        buttonElement.setAttribute("data-toggle", "dropdown");
        buttonElement.setAttribute("aria-haspopup", true);
        buttonElement.setAttribute("aria-expanded", true);
        buttonElement.appendChild(Elements.span().css("caret").asElement());
        buttonElement.setAttribute("type", "button");
        buttonElement.addEventListener("click", event -> {
            groupElement.classList.add("open");
            event.stopPropagation();
        });
        return buttonElement;
    }

    public static DropdownButton create(String content) {
        return new DropdownButton(content);
    }

    public static DropdownButton create(String content, Background background) {
        return new DropdownButton(content, background);
    }

    public static DropdownButton create(String content, ButtonType type) {
        return new DropdownButton(content, type);
    }

    public static DropdownButton createDefault(String content) {
        return create(content, ButtonType.DEFAULT);
    }

    public static DropdownButton createPrimary(String content) {
        return create(content, ButtonType.PRIMARY);
    }

    public static DropdownButton createSuccess(String content) {
        return create(content, ButtonType.SUCCESS);
    }

    public static DropdownButton createInfo(String content) {
        return create(content, ButtonType.INFO);
    }

    public static DropdownButton createDanger(String content) {
        return create(content, ButtonType.DANGER);
    }

    public DropdownButton addAction(DropdownAction action) {
        items.add(action);
        actionsElement.appendChild(action.asElement());
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return groupElement;
    }

    public DropdownButton separator() {
        JustifiableSeparator justifiableSeparator = new JustifiableSeparator();
        items.add(justifiableSeparator);
        actionsElement.appendChild(justifiableSeparator.asElement());
        return this;
    }

    @Override
    public HTMLElement justify() {
        Button button = Button.create(this.button.asElement().textContent);

        for (String style : this.button.asElement().classList.asList()) {
            button.asElement().classList.add(style);
        }

        DropdownButton cloneDropdownButton = new DropdownButton(button);
        for (Justifiable item : items) {
            cloneDropdownButton.actionsElement.appendChild(item.justify());
        }
        justifiedElement = cloneDropdownButton.asElement();
        if (nonNull(handler))
            handler.onJustifiy(justifiedElement);
        return justifiedElement;
    }

    @Override
    public void addJustifyHandler(JustifyHandler handler) {
        this.handler = handler;
    }

    private class JustifiableSeparator implements Justifiable {

        private HTMLLIElement separator = Elements.li().attr("role", "separator").css("divider").asElement();
        private JustifyHandler handler;

        @Override
        public HTMLElement justify() {
            return (HTMLElement) separator.cloneNode(true);
        }

        @Override
        public void addJustifyHandler(JustifyHandler handler) {
            // nothing
        }

        @Override
        public HTMLElement asElement() {
            return separator;
        }
    }
}
