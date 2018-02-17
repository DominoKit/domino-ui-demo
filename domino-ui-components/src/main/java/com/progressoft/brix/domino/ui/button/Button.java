package com.progressoft.brix.domino.ui.button;

import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.Waves;
import com.progressoft.brix.domino.ui.style.WavesElement;
import com.progressoft.brix.domino.ui.utils.HasClickableElement;
import com.progressoft.brix.domino.ui.utils.Justifiable;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;

import static java.util.Objects.nonNull;

public class Button extends WavesElement<Button, HTMLElement> implements Justifiable, HasClickableElement {

    final HTMLElement buttonElement = Elements.button().css("btn").asElement();
    private ButtonType type;
    private Background background;
    private ButtonSize size;
    private JustifyHandler handler;
    protected String content;

    private static Button create(String content, ButtonType type) {
        return new Button(content, type);
    }

    public static Button create() {
        return new Button();
    }

    public static Button create(String content) {
        return new Button(content);
    }

    public static Button createDefault(String content) {
        return create(content, ButtonType.DEFAULT);
    }

    public static Button createPrimary(String content) {
        return create(content, ButtonType.PRIMARY);
    }

    public static Button createSuccess(String content) {
        return create(content, ButtonType.SUCCESS);
    }

    public static Button createInfo(String content) {
        return create(content, ButtonType.INFO);
    }

    public static Button createWarning(String content) {
        return create(content, ButtonType.WARNING);
    }

    public static Button createDanger(String content) {
        return create(content, ButtonType.DANGER);
    }

    protected Button() {
        super.init(this, buttonElement);
        Waves.init();
    }

    protected Button(String content) {
        this();
        setContent(content);
    }

    protected Button(String content, ButtonType type) {
        this(content);
        setButtonType(type);
    }

    public Button setContent(String content) {
        this.content = content;
        buttonElement.textContent = this.content;
        return this;
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
