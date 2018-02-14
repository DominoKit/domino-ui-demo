package com.progressoft.brix.domino.ui.lists;

import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.HTMLLIElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.h;
import static org.jboss.gwt.elemento.core.Elements.li;
import static org.jboss.gwt.elemento.core.Elements.p;

public class SimpleListItem extends BaseListItem implements IsElement<HTMLLIElement> {

    private final HTMLLIElement element;
    private String style;


    private SimpleListItem(HTMLLIElement element) {
        super(element);
        this.element = element;
    }

    public static SimpleListItem create(String text) {
        return new SimpleListItem(li().css("list-group-item").textContent(text).asElement());
    }

    public SimpleListItem setStyle(ListGroupStyle itemStyle) {
        return setStyle(itemStyle.getStyle());
    }

    private SimpleListItem setStyle(String itemStyle) {
        if (nonNull(this.style))
            element.classList.remove(this.style);
        element.classList.add(itemStyle);
        this.style = itemStyle;
        return this;
    }

    public SimpleListItem setBackground(Background background) {
        setStyle("list-group-" + background.getStyle());
        return this;
    }

    public SimpleListItem setHeading(String heading) {
        setHeaderText(heading);
        return this;
    }

    public SimpleListItem setText(String content) {
        setBodyText(content);
        return this;
    }

    @Override
    public HTMLLIElement asElement() {
        return element;
    }
}