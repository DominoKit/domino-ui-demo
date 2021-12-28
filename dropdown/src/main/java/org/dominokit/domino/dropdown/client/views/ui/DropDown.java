package org.dominokit.domino.dropdown.client.views.ui;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.dominokit.domino.dropdown.client.views.ui.position.MiddleOfScreenDropDirection;
import org.dominokit.domino.dropdown.client.views.ui.position.TopLeftDropDirection;
import org.dominokit.domino.ui.dropdown.DropDownStyles;
import org.dominokit.domino.ui.dropdown.MenuNavigation;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.modals.ModalBackDrop;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.IsCollapsible;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.dropdown.client.views.ui.DropDownCloser.DOMINO_UI_AUTO_CLOSABLE;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.jboss.elemento.Elements.li;
import static org.jboss.elemento.Elements.span;
import static org.jboss.elemento.Elements.ul;

public class DropDown extends BaseDominoElement<HTMLDivElement, DropDown> {

    private FlexLayout dropDownElement = FlexLayout.create()
            .setAttribute("domino-ui-root-menu", true)
            .setAttribute(DOMINO_UI_AUTO_CLOSABLE, true);
    private ElementPosition position = new TopLeftDropDirection();
    private ElementPosition smallScreenPosition = new MiddleOfScreenDropDirection();
    private ElementPosition effectivePosition = position;
    private HTMLElement targetElement;
    private HTMLElement appendTarget = document.body;

    private FlexItem<HTMLDivElement> headContainer = FlexItem.create().css("drop-down-container", "drop-down-head");
    private FlexItem<HTMLDivElement> subHeaderContainer = FlexItem.create().css("drop-down-container", "drop-down-subheader");
    private FlexItem<HTMLDivElement> mainContainer = FlexItem.create().css("drop-down-container", "drop-down-main");
    private DominoElement<HTMLUListElement> itemsContainer = DominoElement.of(ul());

    private DominoElement<HTMLLIElement> noResultElement = DominoElement.of(li()
            .css(DropDownStyles.NO_RESULTS));

    private final DropDownHeader dropDownHeader;

    private List<DropDownItem<?>> dropDownItems = new ArrayList<>();
    private DropDown currentOpen;
    private EventListener openListener = evt -> {
        evt.stopPropagation();
        open();
    };

    private boolean caseSensitive = false;
    private final List<CloseHandler> closeHandlers = new ArrayList<>();
    private final List<OpenHandler> openHandlers = new ArrayList<>();
    private HTMLElement focusElement;
    private AppendStrategy appendStrategy = AppendStrategy.LAST;

    private DropDown parent;
    private MenuNavigation<DropDownItem<?>> menuNavigation;

    public DropDown() {
        init(this);
        dropDownHeader = new DropDownHeader(this);
        dropDownElement.setDirection(FlexDirection.TOP_TO_BOTTOM);
        this
                .appendChild(headContainer
                        .appendChild(dropDownHeader)
                )
                .appendChild(subHeaderContainer)
                .appendChild(mainContainer.setFlexGrow(1)
                        .appendChild(itemsContainer)
                )
        ;
        dropDownElement.css("dom-ui", "drop-down")
                .elevate(Elevation.LEVEL_1);
        MediaQuery.addOnMediumAndDownListener(() -> effectivePosition = smallScreenPosition);
        MediaQuery.addOnLargeAndUpListener(() -> effectivePosition = position);

        menuNavigation =
                MenuNavigation.create(dropDownItems)
                        .onSelect(DropDownItem::select)
                        .focusCondition(IsCollapsible::isExpanded)
                        .onFocus(
                                item -> {
                                    if (isOpened()) {
                                        item.focus();
                                    }
                                })
                        .onEscape(this::close);

        element.addEventListener("keydown", menuNavigation);
    }

    /**
     * @return True if the menu is opened, false otherwise
     */
    public boolean isOpened() {
        return element.isAttached();
    }

    public DropDown setIcon(BaseIcon<?> icon) {
        dropDownHeader.setIcon(icon);
        autoHideShowHeader();
        return this;
    }

    public DropDown setTitle(String title) {
        dropDownHeader.setTitle(title);
        autoHideShowHeader();
        return this;
    }

    public DropDown appendAction(HTMLElement element) {
        dropDownHeader.appendAction(element);
        autoHideShowHeader();
        return this;
    }

    public DropDown appendAction(IsElement<?> element) {
        dropDownHeader.appendAction(element);
        autoHideShowHeader();
        return this;
    }

    private void autoHideShowHeader() {
        dropDownHeader.toggleDisplay(!dropDownHeader.isEmpty());
    }

    public DropDown appendSubHeaderChild(HTMLElement element) {
        subHeaderContainer.appendChild(element);
        autoHideShowSubHeader();
        return this;
    }

    public DropDown appendSunHeaderChild(IsElement<?> element) {
        subHeaderContainer.appendChild(element);
        autoHideShowSubHeader();
        return this;
    }

    private void autoHideShowSubHeader() {
        subHeaderContainer.toggleDisplay(!subHeaderContainer.isEmptyElement());
    }

    public DropDown appendChild(DropDownItem<?> dropDownItem) {
        if (nonNull(dropDownItem)) {
            itemsContainer.appendChild(dropDownItem);
            dropDownItems.add(dropDownItem);
            dropDownItem.setParent(this);
        }
        return this;
    }

    public DropDown removeDropdownItem(DropDownItem<?> dropDownItem) {
        if (this.dropDownItems.contains(dropDownItem)) {
            dropDownItem.remove();
            this.dropDownItems.remove(dropDownItem);
            dropDownItem.setParent(this);
        }

        return this;
    }

    public DropDown appendSeparator() {
        this.itemsContainer.appendChild(DominoElement.of(li().add(span().css("ddi-separator"))));
        return this;
    }

    /**
     * Opens the menu with a boolean to indicate if the first element should be focused
     *
     * @param focus true to focus the first element
     */
    public void open(boolean focus) {
        closeOthers();
        onAttached(
                mutationRecord -> {
                    effectivePosition.position(element.element(), targetElement);
                    if (focus) {
                        focus();
                    }
                    element.setCssProperty("z-index", ModalBackDrop.getNextZIndex() + 10 + "");
                    openHandlers.forEach(OpenHandler::onOpen);
                    DominoElement.of(targetElement).onDetached(targetDetach -> close());
                    DominoElement.of(getAppendTarget()).onDetached(targetDetach -> close());
                    onDetached(detachRecord -> closeHandlers.forEach(CloseHandler::onClose));
                });

        onDetached(mutationRecord -> close());

        if (!getAppendTarget().contains(element.element())) {
            appendStrategy.onAppend(getAppendTarget(), element.element());
        }
    }

    private void closeOthers() {
        if (this.hasAttribute("domino-sub-menu") && Boolean.parseBoolean(this.getAttribute("domino-sub-menu"))) {
            return;
        }
        DropDownCloser.closeDropdowns();
    }

    private void focus() {
        getFocusElement().focus();
    }

    public HTMLElement getAppendTarget() {
        return appendTarget;
    }

    public DropDown setAppendTarget(HTMLElement appendTarget) {
        if (isNull(appendTarget)) {
            this.appendTarget = document.body;
        } else {
            this.appendTarget = appendTarget;
        }
        return this;
    }

    /**
     * Opens the select dropdown menu
     *
     * @return same component instance
     */
    public DropDown open() {
        open(true);
        return this;
    }

    public FlexItem<HTMLDivElement> getHeadContainer() {
        return headContainer;
    }

    public FlexItem<HTMLDivElement> getSubHeaderContainer() {
        return subHeaderContainer;
    }

    public FlexItem<HTMLDivElement> getMainContainer() {
        return mainContainer;
    }

    @Override
    public HTMLDivElement element() {
        return dropDownElement.element();
    }

    public HTMLElement getTargetElement() {
        if (isNull(targetElement)) {
            setTargetElement(DominoElement.body());
        }
        return targetElement;
    }

    public DropDown setTargetElement(IsElement<?> targetElement) {
        return setTargetElement(targetElement.element());
    }

    public DropDown setTargetElement(HTMLElement targetElement) {
        if (nonNull(this.targetElement)) {
            this.targetElement.removeEventListener(EventType.click.getName(), openListener);
        }
        this.targetElement = targetElement;
        effectivePosition.init(this.element(), targetElement);
        targetElement.addEventListener(EventType.click.getName(), openListener);
        return this;
    }

    public DropDown openSubMenu(DropDown dropDown) {
        if (nonNull(currentOpen)) {
            currentOpen.close();
        }
        dropDown.open();
        this.currentOpen = dropDown;
        return this;
    }

    public DropDown close() {
        if (isAttached()) {
            this.remove();
        }
        dropDownItems.forEach(DropDownItem::onParentClosed);
        closeHandlers.forEach(CloseHandler::onClose);
        return this;
    }

    private void clearSearch() {
        this.onSearch("");
    }

    public ElementPosition getPosition() {
        return position;
    }

    public DropDown setPosition(ElementPosition position) {
        if (effectivePosition.equals(this.position)) {
            this.position = position;
            this.effectivePosition = this.position;
        } else {
            this.position = position;
        }
        return this;
    }

    public boolean onSearch(String token) {
        if (emptyToken(token)) {
            this.removeCss("has-search");
        } else {
            this.css("has-search");
        }
        long count = this.dropDownItems.stream()
                .map(DropDownItem::closeSubMenu)
                .filter(dropDownItem -> dropDownItem.onSearch(token, isCaseSensitive()))
                .count();

        if (count < 1) {
            this.itemsContainer.appendChild(noResultElement.setTextContent("No results matched" + " \"" + token + "\""));
        } else {
            noResultElement.remove();
        }
        return count > 0;
    }

    private boolean emptyToken(String token) {
        return isNull(token) || token.isEmpty();
    }

    public List<DropDownItem<?>> getDropDownItems() {
        return dropDownItems;
    }

    public DominoElement<HTMLLIElement> getNoResultElement() {
        return noResultElement;
    }

    public DropDown setNoResultElement(HTMLLIElement noResultElement) {
        if (nonNull(noResultElement)) {
            this.noResultElement = DominoElement.of(noResultElement);
        }
        return this;
    }

    public DropDown setNoResultElement(IsElement<HTMLLIElement> noResultElement) {
        if (nonNull(noResultElement)) {
            setNoResultElement(noResultElement.element());
        }
        return this;
    }

    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    public DropDown setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }

    public HTMLElement getFocusElement() {
        if (isNull(this.focusElement)) {
            if (!this.dropDownItems.isEmpty()) {
                return dropDownItems.get(0).getClickableElement();
            } else {
                return this.itemsContainer.element();
            }
        }
        return focusElement;
    }

    public DropDown setFocusElement(HTMLElement focusElement) {
        this.focusElement = focusElement;
        return this;
    }

    public DropDown setFocusElement(IsElement<? extends HTMLElement> focusElement) {
        return setFocusElement(focusElement.element());
    }

    /**
     * Adds a close handler to be called when the menu is closed
     *
     * @param closeHandler The {@link CloseHandler} to add
     * @return same instance
     */
    public DropDown addCloseHandler(CloseHandler closeHandler) {
        closeHandlers.add(closeHandler);
        return this;
    }

    /**
     * Removes a close handler
     *
     * @param closeHandler The {@link CloseHandler} to remove
     * @return same instance
     */
    public DropDown removeCloseHandler(CloseHandler closeHandler) {
        closeHandlers.remove(closeHandler);
        return this;
    }

    /**
     * Adds an open handler to be called when the menu is opened
     *
     * @param openHandler The {@link OpenHandler} to add
     * @return same instance
     */
    public DropDown addOpenHandler(OpenHandler openHandler) {
        openHandlers.add(openHandler);
        return this;
    }

    /**
     * Removes an open handler
     *
     * @param openHandler The {@link OpenHandler} to remove
     * @return same instance
     */
    public DropDown removeOpenHandler(OpenHandler openHandler) {
        openHandlers.remove(openHandler);
        return this;
    }

    public void setParent(DropDown parent) {
        this.parent = parent;
    }

    public DropDown getParent() {
        return parent;
    }

    public DropDownHeader getDropDownHeader() {
        return dropDownHeader;
    }

    /**
     * Positions the menu on the bottom right of the mouse click location
     */
    public static class PositionMouseBottomRight implements ElementPosition {

        private MouseEvent mouseEvent;

        @Override
        public ElementPosition init(HTMLElement source, HTMLElement targetElement) {
            targetElement.addEventListener(EventType.click.getName(), evt -> {
                this.mouseEvent = Js.uncheckedCast(evt);
            });
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public void position(HTMLElement actionsMenu, HTMLElement target) {
            actionsMenu.style.setProperty("top", px.of(mouseEvent.clientY));
            actionsMenu.style.setProperty("left", px.of(mouseEvent.clientX));
        }
    }

    public interface ElementPosition {
        default ElementPosition init(HTMLElement source, HTMLElement targetElement) {
            return this;
        }

        void position(HTMLElement source, HTMLElement target);
    }

    /**
     * A handler that will be called when closing the menu
     */
    @FunctionalInterface
    public interface CloseHandler {
        /**
         * Will be called when the menu is closed
         */
        void onClose();
    }

    /**
     * A handler that will be called when opening the menu
     */
    @FunctionalInterface
    public interface OpenHandler {
        /**
         * Will be called when the menu is opened
         */
        void onOpen();
    }
}
