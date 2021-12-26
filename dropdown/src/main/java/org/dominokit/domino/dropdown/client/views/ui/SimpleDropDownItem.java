package org.dominokit.domino.dropdown.client.views.ui;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.h;
import static org.jboss.elemento.Elements.small;

public class SimpleDropDownItem extends DropDownItem<SimpleDropDownItem> {

    private DominoElement<HTMLElement> descriptionElement = DominoElement.of(small());
    private DominoElement<HTMLHeadingElement> textElement = DominoElement.of(h(5));

    public static SimpleDropDownItem create(String text) {
        return new SimpleDropDownItem(text);
    }

    public static SimpleDropDownItem create(String text, String description) {
        return new SimpleDropDownItem(text, description);
    }

    public SimpleDropDownItem(String text) {
        this(text, null);
    }

    public SimpleDropDownItem(String text, String description) {
        css("simple-ddi");
        if (nonNull(text)) {
            textElement.setTextContent(text);
        }

        if (nonNull(description)) {
            descriptionElement.setTextContent(description);
            textElement.appendChild(descriptionElement);
        }

        appendChild(textElement);
    }

    public DominoElement<HTMLElement> getDescriptionElement() {
        return descriptionElement;
    }

    public DominoElement<HTMLHeadingElement> getTextElement() {
        return textElement;
    }

    @Override
    public boolean onSearch(String token, boolean caseSensitive) {
        if (isNull(token) || token.isEmpty()) {
            this.show();
            return true;
        }
        if (containsToken(token, caseSensitive)) {
            if (this.isCollapsed()) {
                this.show();
            }
            return true;
        }
        if (this.isExpanded()) {
            this.hide();
        }
        return false;
    }

    private boolean containsToken(String token, boolean caseSensitive) {
        String textContent = textElement.getTextContent();
        if (isNull(textContent) || textContent.isEmpty()) {
            return false;
        }
        if (caseSensitive) {
            return textContent.contains(token) || descriptionElement.getTextContent().contains(token);
        }
        return textContent.toLowerCase().contains(token.toLowerCase()) || descriptionElement.getTextContent().toLowerCase().contains(token.toLowerCase());
    }
}
