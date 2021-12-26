package org.dominokit.domino.dropdown.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ScreenMedia;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.elemento.IsElement;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

public class DropDownHeader extends BaseDominoElement<HTMLDivElement, DropDownHeader> {

    private final FlexLayout root = FlexLayout.create().css("drop-down-header");
    private final FlexItem<HTMLDivElement> backArrowContainer = FlexItem.create().setOrder(0).css("back-arrow-icon");
    private final FlexItem<HTMLDivElement> iconContainer = FlexItem.create().setOrder(1).css("header-icon");
    private final FlexItem<HTMLDivElement> titleContainer = FlexItem.create().setOrder(2).css("header-title");
    private final FlexItem<HTMLDivElement> actionsContainer = FlexItem.create().setOrder(3).css("header-actions");
    private final FlexLayout actionsElement = FlexLayout.create()
            .css("actions-element")
            .setGap("4px");
    private DropDown dropDown;

    public DropDownHeader(DropDown dropDown) {
        init(this);
        this.dropDown = dropDown;

        backArrowContainer
                .appendChild(Icons.ALL.keyboard_backspace()
                        .clickable()
                        .addClickListener(this::backToParent)
                        .addEventListener("touchend", this::backToParent)
                        .addEventListener("touchstart", Event::stopPropagation)
                );

        root.setDirection(FlexDirection.LEFT_TO_RIGHT)
                .appendChild(backArrowContainer)
                .appendChild(iconContainer)
                .appendChild(titleContainer.setFlexGrow(1))
                .appendChild(actionsContainer
                        .appendChild(actionsElement));
    }

    private void backToParent(Event evt) {
        evt.stopPropagation();
        evt.preventDefault();

        if (nonNull(this.dropDown)) {
            DomGlobal.console.info("CURRENT : "+this.titleContainer.getTextContent());
            this.dropDown.close();
        }
        if (nonNull(this.dropDown.getParent())) {
            DomGlobal.console.info("PARENT : "+this.dropDown.getParent().getDropDownHeader().getTitleContainer().getTextContent());
            this.dropDown.getParent().open(true);
        }
    }

    public DropDownHeader setIcon(BaseIcon<?> icon) {
        if (isNull(icon)) {
            iconContainer.clearElement();
        } else {
            iconContainer.appendChild(icon);
        }
        return this;
    }

    public DropDownHeader setTitle(String title) {
        if (isNull(title)) {
            titleContainer.clearElement();
        } else {
            titleContainer.clearElement().appendChild(TextNode.of(title));
        }
        return this;
    }

    public DropDownHeader appendAction(HTMLElement element) {
        actionsElement.appendChild(FlexItem.of(element).css("header-action"));
        return this;
    }

    public DropDownHeader appendAction(IsElement<?> element) {
        actionsElement.appendChild(FlexItem.of(element).css("header-action"));
        return this;
    }

    boolean isEmpty() {
        return iconContainer.isEmptyElement() && isEmptyTitle() && actionsElement.isEmptyElement();
    }

    private boolean isEmptyTitle() {
        return titleContainer.isEmptyElement() && (isNull(titleContainer.getTextContent()) || titleContainer.getTextContent().isEmpty());
    }

    public FlexItem<HTMLDivElement> getBackArrowContainer() {
        return backArrowContainer;
    }

    public FlexItem<HTMLDivElement> getIconContainer() {
        return iconContainer;
    }

    public FlexItem<HTMLDivElement> getTitleContainer() {
        return titleContainer;
    }

    public FlexItem<HTMLDivElement> getActionsContainer() {
        return actionsContainer;
    }

    public FlexLayout getActionsElement() {
        return actionsElement;
    }

    public DropDown getDropDown() {
        return dropDown;
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
