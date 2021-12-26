package org.dominokit.domino.dropdown.client.views.ui;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.dropdown.client.views.ui.position.BestFitSideDropDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasSelectSupport;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.HasSelectionSupport;
import org.dominokit.domino.ui.utils.Selectable;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;

public class DropDownItem<T extends DropDownItem<T>> extends BaseDominoElement<HTMLLIElement, T> implements Selectable<T>, HasSelectionHandler {

    private final DominoElement<HTMLLIElement> root = DominoElement.of(li().css("drop-down-item"));
    private final DominoElement<HTMLAnchorElement> linkElement = DominoElement.of(a())
            .setAttribute("tabindex", "0")
            .setAttribute("aria-expanded", "true")
            .setAttribute("href", "#");
    private final FlexItem<HTMLDivElement> contentContainer = FlexItem.create();
    private final FlexLayout mainContainer = FlexLayout.create().css("drop-down-item");
    private final FlexItem<HTMLDivElement> leftAddOn = FlexItem.create().css("ddi-left-addon");
    private final FlexItem<HTMLDivElement> content = FlexItem.create().css("ddi-content");
    private final FlexItem<HTMLDivElement> rightAddOn = FlexItem.create().css("ddi-right-addon");
    private final FlexItem<HTMLDivElement> nestedIndicatorContainer = FlexItem.create().css("ddi-indicator");
    private BaseIcon<?> nestingIndicator = Icons.ALL.menu_right_mdi();

    DropDown dropDown;
    private DropDown parent;

    public DropDownItem() {
        init((T) this);
        mainContainer
                .setGap("4px")
                .appendChild(leftAddOn)
                .appendChild(content.setFlexGrow(1))
                .appendChild(rightAddOn)
                .appendChild(nestedIndicatorContainer);
        contentContainer.appendChild(mainContainer);
        root.appendChild(linkElement.appendChild(contentContainer));
    }

    public T setLeftAddOn(HTMLElement element) {
        leftAddOn.clearElement().appendChild(element);
        return (T) this;
    }

    public T setLeftAddOn(IsElement<?> element) {
        leftAddOn.clearElement().appendChild(element);
        return (T) this;
    }

    public T setRightAddOn(HTMLElement element) {
        rightAddOn.clearElement().appendChild(element);
        return (T) this;
    }

    public T setRightAddOn(IsElement<?> element) {
        rightAddOn.clearElement().appendChild(element);
        return (T) this;
    }

    public FlexItem<HTMLDivElement> getLeftAddOn() {
        return leftAddOn;
    }

    public FlexItem<HTMLDivElement> getContent() {
        return content;
    }

    public FlexItem<HTMLDivElement> getRightAddOn() {
        return rightAddOn;
    }

    public FlexItem<HTMLDivElement> getNestedIndicatorContainer() {
        return nestedIndicatorContainer;
    }

    public BaseIcon<?> getNestingIndicator() {
        return nestingIndicator;
    }

    public T setNestingIndicator(BaseIcon<?> nestingIndicator) {
        if (nonNull(nestingIndicator)) {
            if (this.nestingIndicator.isAttached()) {
                this.nestedIndicatorContainer.clearElement().appendChild(nestingIndicator);
            }
            this.nestingIndicator = nestingIndicator;
        }

        return (T) this;
    }

    public T setDropDown(DropDown dropDown) {
        this.dropDown = dropDown;
        if (nonNull(dropDown)) {
            this.dropDown.setAttribute("domino-sub-menu", true);
            this.dropDown.removeAttribute("domino-ui-root-menu");
            this.nestedIndicatorContainer.clearElement().appendChild(nestingIndicator);
            this.dropDown.setTargetElement(this);
            this.dropDown.setPosition(new BestFitSideDropDirection());
            this.addEventListener(EventType.mouseenter.getName(), evt -> openSubMenu());
            this.addEventListener("touchstart", evt -> {
                evt.preventDefault();
                evt.stopPropagation();
                openSubMenu();
            });
        } else {
            this.nestedIndicatorContainer.clearElement();
        }

        return (T) this;
    }

    private void openSubMenu() {
        DelayedExecution.execute(() -> {
            if (nonNull(parent)) {
                this.dropDown.setParent(parent);
                parent.openSubMenu(this.dropDown);
            }
        }, 200);
    }

    public void onParentClosed() {
        closeSubMenu();
    }

    public T closeSubMenu() {
        if (nonNull(this.dropDown)) {
            this.dropDown.close();
        }
        return (T) this;
    }

    @Override
    public T appendChild(Node node) {
        content.appendChild(node);
        return (T) this;
    }

    @Override
    public T appendChild(IsElement<?> isElement) {
        content.appendChild(isElement);
        return (T) this;
    }

    void setParent(DropDown dropDown) {
        this.parent = dropDown;
    }

    public boolean onSearch(String token, boolean caseSensitive) {
        if(isNull(token) || token.isEmpty()){
            this.show();
        }else{
            hide();
        }
        return false;
    }

    @Override
    public T select() {
        return null;
    }

    @Override
    public T deselect() {
        return null;
    }

    @Override
    public T select(boolean silent) {
        return null;
    }

    @Override
    public T deselect(boolean silent) {
        return null;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public HTMLElement getClickableElement() {
        return linkElement.element();
    }

    @Override
    public HTMLLIElement element() {
        return root.element();
    }
}
