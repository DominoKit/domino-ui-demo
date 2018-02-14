package com.progressoft.brix.domino.ui.button;

import com.progressoft.brix.domino.ui.icons.Icon;
import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.utils.HasClickableElement;
import com.progressoft.brix.domino.ui.utils.Justifiable;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public class Button implements Justifiable, HasClickableElement {

    private final HTMLElement buttonElement = Elements.button().css("btn").asElement();
    private ButtonType type;
    private Background background;
    private ButtonSize size;
    private JustifyHandler handler;

    private Button(String content) {
        setContent(content);
    }

    private Button(String content, ButtonType type) {
        this(content);
        setButtonType(type);
    }

    private Button(String content, Background background) {
        this(content);
        setBackground(background);
    }

    private Button(String content, Icon icon) {
        this(icon);
        buttonElement.appendChild(Elements.span().textContent(content).asElement());
    }

    private Button(String content, Icon icon, ButtonType type) {
        this(content, icon);
        setButtonType(type);
    }

    public Button(String content, Icon icon, Background background) {
        this(content, icon);
        setBackground(background);
    }

    private Button(Icon icon) {
        buttonElement.appendChild(icon.asElement());
    }

    private Button(Icon icon, ButtonType type) {
        this(icon);
        setButtonType(type);
    }

    private Button(Icon icon, Background background) {
        this(icon);
        setBackground(background);
    }

    public Button setContent(String content) {
        buttonElement.textContent = content;
        return this;
    }

    public static Button create(String content) {
        return new Button(content);
    }

    public static Button create(String content, ButtonType type) {
        return new Button(content, type);
    }

    public static Button create(String content, Background background) {
        return new Button(content, background);
    }

    public static Button create(String content, Icon icon) {
        return new Button(content, icon);
    }

    public static Button create(String content, Icon icon, Background background) {
        return new Button(content, icon, background);
    }

    public static Button create(Icon icon) {
        return new Button(icon);
    }

    public static Button create(Icon icon, ButtonType type) {
        return new Button(icon, type);
    }

    public static Button create(Icon icon, Background background) {
        return new Button(icon, background);
    }

    public static Button create(String content, Icon icon, ButtonType type) {
        return new Button(content, icon, type);
    }

    public static Button createDefault(String content) {
        return create(content, ButtonType.DEFAULT);
    }

    public static Button createDefault(Icon icon) {
        return create(icon, ButtonType.DEFAULT);
    }

    public static Button createDefault(String content, Icon icon) {
        return create(content, icon, ButtonType.DEFAULT);
    }

    public static Button createPrimary(String content) {
        return create(content, ButtonType.PRIMARY);
    }

    public static Button createPrimary(Icon icon) {
        return create(icon, ButtonType.PRIMARY);
    }

    public static Button createPrimary(String content, Icon icon) {
        return create(content, icon, ButtonType.PRIMARY);
    }

    public static Button createSuccess(String content) {
        return create(content, ButtonType.SUCCESS);
    }

    public static Button createSuccess(Icon icon) {
        return create(icon, ButtonType.SUCCESS);
    }

    public static Button createSuccess(String content, Icon icon) {
        return create(content, icon, ButtonType.SUCCESS);
    }

    public static Button createInfo(String content) {
        return create(content, ButtonType.INFO);
    }

    public static Button createInfo(Icon icon) {
        return create(icon, ButtonType.INFO);
    }

    public static Button createInfo(String content, Icon icon) {
        return create(content, icon, ButtonType.INFO);
    }

    public static Button createWarning(String content) {
        return create(content, ButtonType.WARNING);
    }

    public static Button createWarning(Icon icon) {
        return create(icon, ButtonType.WARNING);
    }

    public static Button createWarning(String content, Icon icon) {
        return create(content, icon, ButtonType.WARNING);
    }

    public static Button createDanger(String content) {
        return create(content, ButtonType.DANGER);
    }

    public static Button createDanger(Icon icon) {
        return create(icon, ButtonType.DANGER);
    }

    public static Button createDanger(String content, Icon icon) {
        return create(content, icon, ButtonType.DANGER);
    }


    public Button setSize(ButtonSize size) {
        if (nonNull(this.size))
            buttonElement.classList.remove("btn-" + this.size.getStyle());
        buttonElement.classList.add("btn-" + size.getStyle());
        this.size = size;
        return this;
    }

    public Button setBlock(boolean block) {
        if (block)
            buttonElement.classList.add("btn-block");
        else
            buttonElement.classList.remove("btn-block");
        return this;
    }

    public Button setBackground(Background background) {
        if (nonNull(this.background))
            buttonElement.classList.remove(this.background.getStyle());
        buttonElement.classList.add(background.getStyle());
        this.background = background;
        return this;
    }

    public Button setButtonType(ButtonType type) {
        if (nonNull(this.type))
            buttonElement.classList.remove("btn-" + this.type.getStyle());
        buttonElement.classList.add("btn-" + type.getStyle());
        this.type = type;
        return this;
    }

    public Button disable() {
        buttonElement.setAttribute("disabled", "disabled");
        return this;
    }

    public Button enable() {
        buttonElement.removeAttribute("disabled");
        return this;
    }

    public Button circle() {
        buttonElement.classList.add("btn-circle");
        return this;
    }

    public Button largeCircle() {
        buttonElement.classList.add("btn-circle-lg");
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return buttonElement;
    }

    @Override
    public HTMLElement justify() {
        HTMLAnchorElement justifiedElement = Elements.a()
                .attr("href", "javascript:void(0);")
                .css(asElement().className)
                .attr("role", "button")
                .textContent(asElement().textContent).asElement();
        if (nonNull(handler))
            handler.onJustifiy(justifiedElement);
        return justifiedElement;
    }

    @Override
    public void addJustifyHandler(JustifyHandler handler) {
        this.handler = handler;
    }


    @Override
    public HTMLElement getClickableElement() {
        return asElement();
    }
}
