/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.datatable.client.views.datagrids;

import elemental2.dom.*;
import elemental2.dom.EventListener;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.MenuConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.menu.MenuTarget;
import org.dominokit.domino.ui.menu.direction.*;
import org.dominokit.domino.ui.search.SearchBox;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.utils.*;

import java.util.*;
import java.util.function.Predicate;

import static elemental2.dom.DomGlobal.document;
import static elemental2.dom.DomGlobal.window;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;
import static org.dominokit.domino.ui.utils.PopupsCloser.DOMINO_UI_AUTO_CLOSABLE;

/**
 * Represents a UI Menu component that supports different configurations, items, and behaviors.
 *
 * <p><b>Usage Example:</b>
 *
 * <pre>
 * Menu<String> myMenu = Menu.create()
 *    .setTitle("My Menu")
 *    .setIcon(Icons.ALL.menu())
 *    .appendChild(new MenuItem<>("Menu Item 1"));
 * </pre>
 *
 * @param <V> The type of the item value that the menu holds.
 * @see BaseDominoElement
 */
public class DataList<V> extends BaseDominoElement<HTMLDivElement, DataList<V>>
        implements HasSelectionListeners<DataList<V>, VirtualItem<V, AbstractDataListItem<V>>, List<VirtualItem<V, AbstractDataListItem<V>>>>,
        IsPopup<DataList<V>>,
        HasComponentConfig<MenuConfig>,
        DataListStyles {

    public static final String ANY = "*";
    protected final Set<
            SelectionListener<? super VirtualItem<V, AbstractDataListItem<V>>, ? super List<VirtualItem<V, AbstractDataListItem<V>>>>>
            selectionListeners = new LinkedHashSet<>();
    protected final Set<
            SelectionListener<? super VirtualItem<V, AbstractDataListItem<V>>, ? super List<VirtualItem<V, AbstractDataListItem<V>>>>>
            deselectionListeners = new LinkedHashSet<>();
    private final LazyChild<NavBar> dataListHeader;
    private final LazyChild<DivElement> dataListSearchContainer;
    private final LazyChild<SearchBox> searchBox;
    private final LazyChild<DivElement> dataListSubHeader;
    private final DivElement dataListItemsList;
    private final DataListVirtualScroll<V> virtualScrollPanel;
    private final LazyChild<DivElement> dataListFooter;
    private final EventListener closeOnScrollListener;
    private final List<VirtualItem<V, AbstractDataListItem<V>>> selectedValues = new ArrayList<>();
    private final DropDirection contextMenuDropDirection = new MouseBestFitDirection();
    private final DropDirection smallScreenDropDirection = new MiddleOfScreenDropDirection();
    private final EventListener autoCloseListener =
            evt -> {
                if (isAutoClose()) {
                    remove();
                }
            };
    protected DivElement dataListElement;
    protected KeyboardNavigation<AbstractDataListItem<V>> keyboardNavigation;
    protected boolean caseSensitive = false;
    protected boolean autoCloseOnSelect = true;
    protected boolean headerVisible = false;
    private DataFilter<V> filter;
    private LazyChild<DivElement> noResultElement;
    private HTMLElement focusElement;
    private DataList<V> currentOpen;
    private boolean smallScreen;
    private DropDirection dropDirection = new BestSideUpDownDropDirection();
    private DropDirection effectiveDropDirection = dropDirection;
    private Map<String, MenuTarget> targets;
    private MenuTarget lastTarget;
    private Element dataListAppendTarget = document.body;
    private AppendStrategy appendStrategy = AppendStrategy.LAST;
    private boolean selectionListenersPaused = false;
    private boolean multiSelect = false;
    private boolean autoOpen = true;
    private boolean preserveSelectionStyles = true;
    private boolean contextMenu = false;
    private boolean useSmallScreensDirection = true;
    private boolean dropDown = false;
    private boolean fitToTargetWidth = false;
    private EventListener repositionListener =
            evt -> {
                if (isOpened()) {
                    position();
                }
            };
    private boolean centerOnSmallScreens = false;
    private EventListener lostFocusListener;
    private boolean closeOnBlur = DominoUIConfig.CONFIG.isClosePopupOnBlur();
    private Predicate<DataList<V>> openCondition = (menu) -> true;
    private final EventListener openListener =
            evt -> {
                evt.stopPropagation();
                evt.preventDefault();

                MenuTarget newTarget =
                        targets.get(elementOf(Js.<HTMLElement>uncheckedCast(evt.currentTarget)).getDominoId());
                if (isNull(newTarget)) {
                    newTarget =
                            targets.get(elementOf(Js.<HTMLElement>uncheckedCast(evt.target)).getDominoId());
                }
                if (!Objects.equals(newTarget, lastTarget)) {
                    if (nonNull(lastTarget)) {
                        lastTarget.getTargetElement().removeCss(dui_context_datalist_target_open);
                    }
                    newTarget.getTargetElement().addCss(dui_context_datalist_target_open);
                    getSelection().forEach(item -> item.deselect());
                }

                lastTarget = newTarget;
                if (isAutoOpen()) {
                    if (isOpened() && !isContextMenu()) {
                        close();
                    } else {
                        open(evt);
                    }
                }
            };
    private List<MediaQuery.MediaQueryListenerRecord> mediaQueryRecords = new ArrayList<>();
    private EventListener windowResizeListener;
    private List<VirtualItem<V, AbstractDataListItem<V>>> items;

    /**
     * Default constructor to initialize the Menu component.
     */
    public DataList(VirtualScrollItemMapper<V, AbstractDataListItem<V>> mapper) {
        this.virtualScrollPanel = new DataListVirtualScroll<>(mapper, this);
        dataListElement = div().addCss(dui_datalist);

        dataListHeader = LazyChild.of(NavBar.create(), dataListElement);
        dataListSearchContainer = LazyChild.of(div().addCss(dui_datalist_search), dataListElement);
        searchBox =
                LazyChild.of(
                        SupplyOnce.of(() -> SearchBox.create().addCss(dui_datalist_search_box)),
                        dataListSearchContainer);
        init(this);
        closeOnScrollListener = evt -> close();

        onAttached(
                (target, mutationRecord) -> {
                    if (isCloseOnScroll()) {
                        window.addEventListener("scroll", closeOnScrollListener, true);
                    }
                });

        onDetached(
                (target, mutationRecord) -> {
                    if (isCloseOnScroll()) {
                        window.removeEventListener("scroll", closeOnScrollListener, true);
                    }
                });

        windowResizeListener = evt -> position();
        nowAndWhenAttached(
                () -> {
                    if (isDropDown()) {
                        window.addEventListener("resize", windowResizeListener);
                    }
                });
        onDetached(
                (target, mutationRecord) -> {
                    if (isDropDown()) {
                        window.removeEventListener("resize", windowResizeListener);
                    }
                });

        addClickListener(Event::stopPropagation);

        onKeyDown(
                keyEvents -> {
                    keyEvents.alphanumeric(
                            evt -> {
                                KeyboardEvent keyboardEvent = Js.uncheckedCast(evt);
                                focusFirstMatch(keyboardEvent.key);
                            });
                });

        dataListSubHeader = LazyChild.of(div().addCss(dui_datalist_sub_header), dataListElement);

        dataListItemsList = div().addCss(dui_datalist_items_list);

        noResultElement = LazyChild.of(div().addCss(dui_datalist_no_results, dui_order_last), dataListElement);
        dataListItemsList.appendChild(virtualScrollPanel.addCss(dui_datalist_vscroll));
        dataListElement.appendChild(dataListItemsList);

        dataListFooter = LazyChild.of(div().addCss(dui_datalist_footer), dataListItemsList);

        searchBox.whenInitialized(
                () -> {
                    searchBox.element().addSearchListener(this::onSearch);
                    this.searchBox
                            .element()
                            .getTextBox()
                            .getInputElement()
                            .onKeyDown(
                                    keyEvents ->
                                            keyEvents
                                                    .onArrowDown(
                                                            evt -> {
                                                                evt.stopPropagation();
                                                                evt.preventDefault();
                                                                Optional<AbstractDataListItem<V>> topFocusableItem =
                                                                        keyboardNavigation.getTopFocusableItem();
                                                                if (topFocusableItem.isPresent()) {
                                                                    keyboardNavigation.focusTopFocusableItem();
                                                                }
                                                            })
                                                    .onArrowUp(
                                                            evt -> {
                                                                evt.stopPropagation();
                                                                evt.preventDefault();
                                                                keyboardNavigation.focusBottomFocusableItem();
                                                            })
                                                    .onEscape(evt -> close())
                                                    .onEnter(
                                                            evt ->
                                                                    keyboardNavigation
                                                                            .getTopFocusableItem()
                                                                            .ifPresent(AbstractDataListItem::select)));
                });

        keyboardNavigation =
                KeyboardNavigation.create(()-> getWindowItems())
                        .setTabOptions(new KeyboardNavigation.EventOptions(false, true))
                        .setTabHandler(
                                (event, item) -> {
                                    if (keyboardNavigation.isLastFocusableItem(item)) {
                                        event.preventDefault();
                                        if (isSearchable()) {
                                            this.searchBox.get().getTextBox().getInputElement().element().focus();
                                        } else {
                                            keyboardNavigation.focusTopFocusableItem();
                                        }
                                    }
                                })
                        .setEnterHandler((event, item) -> item.select())
                        .onSelect((event, item) -> item.select())
                        .focusCondition(item -> !item.isCollapsed() && !item.isDisabled())
                        .onFocus(
                                item -> {
                                    if (isDropDown()) {
                                        if (isOpened()) {
                                            item.focus();
                                        }
                                    } else {
                                        item.focus();
                                    }
                                })
                        .onEscape(this::close)
                        .setOnEndReached(
                                navigation -> {
                                    if (isSearchable()) {
                                        this.searchBox.get().getTextBox().getInputElement().element().focus();
                                    } else {
                                        navigation.focusTopFocusableItem();
                                    }
                                })
                        .setOnStartReached(
                                navigation -> {
                                    if (isSearchable()) {
                                        this.searchBox.get().getTextBox().getInputElement().element().focus();
                                    } else {
                                        navigation.focusBottomFocusableItem();
                                    }
                                });
        ;

        element.addEventListener("keydown", keyboardNavigation);

        lostFocusListener =
                evt -> {
                    if (isDropDown() && isCloseOnBlur()) {
                        DomGlobal.setTimeout(
                                p0 -> {
                                    Element e = DomGlobal.document.activeElement;
                                    if (getTarget().isPresent()) {
                                        Element target = getTarget().get().getTargetElement().element();
                                        if (!(target.contains(e)
                                                || e.equals(target)
                                                || this.element().contains(e)
                                                || e.equals(this.element()))) {
                                            close();
                                        }
                                    } else {
                                        if (!(this.element().contains(e) || e.equals(this.element()))) {
                                            close();
                                        }
                                    }
                                },
                                0);
                    }
                };

        nowAndWhenAttached(
                () -> {
                    document.addEventListener(PopupsCloser.DUI_AUTO_CLOSE, autoCloseListener);
                    mediaQueryRecords.add(
                            MediaQuery.addOnSmallAndDownListener(
                                    () -> {
                                        if (centerOnSmallScreens) {
                                            this.smallScreen = true;
                                        }
                                    }));

                    mediaQueryRecords.add(
                            MediaQuery.addOnMediumAndUpListener(
                                    () -> {
                                        if (centerOnSmallScreens) {
                                            this.smallScreen = false;
                                        }
                                    }));

                    DomGlobal.document.body.addEventListener("blur", lostFocusListener, true);
                    if (this.dropDown) {
                        document.addEventListener("scroll", repositionListener, true);
                    }
                });

        nowAndWhenDetached(
                () -> {
                    DomGlobal.document.body.removeEventListener("blur", lostFocusListener, true);
                    document.removeEventListener("scroll", repositionListener, true);
                    mediaQueryRecords.forEach(MediaQuery.MediaQueryListenerRecord::remove);
                    document.removeEventListener(PopupsCloser.DUI_AUTO_CLOSE, autoCloseListener);
                });

        this.addEventListener(EventType.touchstart.getName(), Event::stopPropagation);
        this.addEventListener(EventType.touchend.getName(), Event::stopPropagation);
    }

    /**
     * Factory method to create a new Menu instance.
     *
     * @param <V> The type of the menu item value.
     * @return A new menu instance.
     */
    public static <V> DataList<V> create(VirtualScrollItemMapper<V, AbstractDataListItem<V>> mapper) {
        return new DataList<>(mapper);
    }

    private List<VirtualItem<V, AbstractDataListItem<V>>> getItems() {
        if (isNull(this.items) || this.items.isEmpty()) {
            this.items = new ArrayList<>(virtualScrollPanel.getWindowList().getAll());
        }
        return this.items;
    }

    public DataList<V> setItems(List<V> items) {
        this.virtualScrollPanel.setItems(items);
        if (nonNull(this.items)) {
            this.items.clear();
        }
        return this;
    }

    private void setScrollItems(List<VirtualItem<V, AbstractDataListItem<V>>> items) {
        this.virtualScrollPanel.updateItems(items);
    }

    public void focusFirstMatch(String token) {
        findOptionStarsWith(token).ifPresent(AbstractDataListItem::focus);
    }

    public Optional<AbstractDataListItem<V>> findOptionStarsWith(String token) {
        return this.getWindowItems().stream()
                .filter(dropDownItem -> dropDownItem.startsWith(token))
                .findFirst();
    }

    /**
     * Determines if the menu is set to be centered on small screen devices.
     *
     * @return true if the menu should be centered on small screens, false otherwise.
     */
    public boolean isCenterOnSmallScreens() {
        return centerOnSmallScreens;
    }

    /**
     * Sets the behavior for the menu to be centered or not on small screen devices.
     *
     * @param centerOnSmallScreens true to center the menu on small screens, false otherwise.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setCenterOnSmallScreens(boolean centerOnSmallScreens) {
        this.centerOnSmallScreens = centerOnSmallScreens;
        return this;
    }

    /**
     * Allows adding an icon to the menu header.
     *
     * @param icon The icon to be set.
     * @return The current Menu instance.
     */
    public DataList<V> setIcon(Icon<?> icon) {
        dataListHeader.get().appendChild(PrefixAddOn.of(icon));
        return this;
    }

    /**
     * Sets the title for the menu header.
     *
     * @param title The title to be set.
     * @return The current Menu instance.
     */
    public DataList<V> setTitle(String title) {
        dataListHeader.get().setTitle(title);
        return this;
    }

    /**
     * Appends a subheader addon to the menu.
     *
     * @param addon The subheader addon to be added.
     * @return The current Menu instance.
     */
    public DataList<V> appendChild(SubheaderAddon<?> addon) {
        dataListSubHeader.get().appendChild(addon);
        return this;
    }

    public DataList<V> appendChild(SubheaderAddon<?>... addons) {
        Arrays.stream(addons).forEach(this::appendChild);
        return this;
    }

    /**
     * Appends a menu item to the menu.
     *
     * @param menuItem The menu item to be added.
     * @return The current Menu instance.
     */
    DataList<V> appendChild(AbstractDataListItem<V> menuItem, int index) {
        if (nonNull(menuItem)) {
            virtualScrollPanel.appendChild(menuItem, index);
        }
        return this;
    }

    /**
     * {@inheritDoc}
     *
     * <p>Retrieves the main HTMLDivElement element representing this menu.
     *
     * @return the main HTMLDivElement element.
     */
    @Override
    public HTMLDivElement element() {
        return dataListElement.element();
    }

    /**
     * Clears the contents of the search box within the menu.
     */
    private void clearSearch() {
        searchBox.get().clearSearch();
    }

    /**
     * Clears the current selection of menu items.
     *
     * @param silent if true, does not trigger the deselection listeners; otherwise, does.
     */
    public void clearSelection(boolean silent) {
        selectedValues.clear();
        if (!silent) {
            triggerDeselectionListeners(null, selectedValues);
        }
    }

    /**
     * Filters the menu items based on a given search token.
     *
     * <p>If no results match, a "no results" message is displayed.
     *
     * @param token the string to use for filtering the menu items.
     * @return true if one or more items match the search token, false otherwise.
     */
    public boolean onSearch(String token) {
        List<VirtualItem<V, AbstractDataListItem<V>>> originalItems = getItems();
        boolean emptyToken = emptyToken(token);
        if (emptyToken) {
            if (this.virtualScrollPanel.getWindowList().getAll().size() < originalItems.size()) {
                List<VirtualItem<V, AbstractDataListItem<V>>> records = new ArrayList<>(originalItems);
                setScrollItems(records);
                return true;
            }
        }
        List<VirtualItem<V, AbstractDataListItem<V>>> foundItems = new ArrayList<>();
        for (int i = 0; i < originalItems.size(); i++) {
            if (filter.onSearch(originalItems.get(i).getRecord(), token, caseSensitive)) {
                foundItems.add(originalItems.get(i));
            }
        }

        if (foundItems.isEmpty() && !originalItems.isEmpty()) {
            noResultElement.get().setInnerHtml(getConfig().getNoResultMatchMessage(token));
            setScrollItems(new ArrayList<>());
        } else {
            setScrollItems(foundItems);
            noResultElement.remove();
        }

        position();
        return !foundItems.isEmpty();
    }

    /**
     * Determines if the provided search token is empty or null.
     *
     * @param token the search string.
     * @return true if the token is null or empty, false otherwise.
     */
    private boolean emptyToken(String token) {
        return isNull(token) || token.isEmpty();
    }

    /**
     * Retrieves the list of direct menu items (excluding sub-menu items) contained in this menu.
     *
     * @return the list of direct menu items.
     */
    public List<AbstractDataListItem<V>> getWindowItems() {
        return virtualScrollPanel.getWindowList().getWindow().getWindowItems();
    }

    /**
     * Retrieves the element used to display a "no results" message when a search yields no results.
     *
     * @return the "no results" element wrapped in a {@link LazyChild} container.
     */
    public LazyChild<DivElement> getNoResultElement() {
        return noResultElement;
    }

    /**
     * Sets the element used to display a "no results" message when a search yields no results.
     *
     * @param noResultElement the HTMLLIElement to be used for displaying "no results".
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setNoResultElement(HTMLDivElement noResultElement) {
        if (nonNull(noResultElement)) {
            this.noResultElement.remove();
            this.noResultElement =
                    LazyChild.of(DivElement.of(noResultElement).addCss(dui_datalist_no_results), dataListItemsList);
        }
        return this;
    }

    /**
     * Sets the element used to display a "no results" message when a search yields no results.
     *
     * @param noResultElement the IsElement wrapping an HTMLLIElement to be used for displaying "no
     *                        results".
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setNoResultElement(IsElement<HTMLDivElement> noResultElement) {
        if (nonNull(noResultElement)) {
            setNoResultElement(noResultElement.element());
        }
        return this;
    }

    /**
     * Checks if the menu's search functionality is case-sensitive.
     *
     * @return true if the search is case-sensitive, false otherwise.
     */
    public boolean isCaseSensitive() {
        return caseSensitive;
    }

    /**
     * Sets the menu's search functionality to be case-sensitive or not.
     *
     * @param caseSensitive a boolean indicating whether to enable or disable case-sensitivity.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setCaseSensitive(boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }

    /**
     * Retrieves the current focus element of the menu.
     *
     * <p>The focus element is determined based on the following criteria: - If a custom focus element
     * has been set, it will be returned. - If the menu is searchable, the search box input will be
     * the focus element. - If the menu contains menu items, the first item will be the focus element.
     * - Otherwise, the root element of the menu items list will be the focus element.
     *
     * @return the current focus element of the menu.
     */
    public HTMLElement getFocusElement() {
        if (isNull(this.focusElement)) {
            if (isSearchable()) {
                return this.searchBox.get().getTextBox().getInputElement().element();
            } else {
                List<AbstractDataListItem<V>> dataListItems = this.getWindowItems();
                if (!dataListItems.isEmpty()) {
                    return dataListItems.get(0).getClickableElement();
                } else {
                    return this.dataListItemsList.element();
                }
            }
        }
        return focusElement;
    }

    /**
     * Sets the focus element for the menu.
     *
     * @param focusElement the HTMLElement to set as the focus element.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setFocusElement(HTMLElement focusElement) {
        this.focusElement = focusElement;
        return this;
    }

    /**
     * Sets the focus element for the menu.
     *
     * @param focusElement the IsElement wrapping an HTMLElement to be set as the focus element.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setFocusElement(IsElement<? extends HTMLElement> focusElement) {
        return setFocusElement(focusElement.element());
    }

    /**
     * Retrieves the search box component used within the menu.
     *
     * @return the {@link SearchBox} instance.
     */
    public SearchBox getSearchBox() {
        return searchBox.get();
    }

    /**
     * Retrieves the keyboard navigation handler for the menu items.
     *
     * @return the keyboard navigation instance.
     */
    public KeyboardNavigation<AbstractDataListItem<V>> getKeyboardNavigation() {
        return keyboardNavigation;
    }

    /**
     * Retrieves the header component of the menu.
     *
     * @return the {@link NavBar} instance representing the menu's header.
     */
    public NavBar getDataListHeader() {
        return dataListHeader.get();
    }

    /**
     * Toggles the visibility of the menu's header.
     *
     * @param visible true to make the header visible, false to hide it.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setHeaderVisible(boolean visible) {
        dataListHeader.get().toggleDisplay(visible);
        this.headerVisible = visible;
        return this;
    }

    /**
     * Checks if the menu has a search functionality enabled.
     *
     * @return true if the menu is searchable, false otherwise.
     */
    public boolean isSearchable() {
        return nonNull(filter);
    }

    /**
     * Enables or disables the search functionality within the menu.
     *
     * @param dataFilter a non-null value to enable search, null to disable it.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setSearchable(DataFilter<V> dataFilter) {
        if (nonNull(dataFilter)) {
            searchBox.get();
        } else {
            searchBox.remove();
            dataListSearchContainer.remove();
        }
        this.filter = dataFilter;
        return this;
    }

    /**
     * Selects a given menu item.
     *
     * @param item The menu item to select.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> select(VirtualItem<V, AbstractDataListItem<V>> item) {
        return select(item, isSelectionListenersPaused());
    }

    /**
     * Selects a given menu item with the option to silence selection events.
     *
     * @param item The menu item to select.
     * @param silent   If true, selection listeners will be paused; otherwise, they will be active.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> select(VirtualItem<V, AbstractDataListItem<V>> item, boolean silent) {
        item.select();
        if(!silent) {
            getSelectionListeners().forEach(selectionListener -> selectionListener.onSelectionChanged(Optional.of(item), getSelection()));
        }
        return this;
    }

    /**
     * Selects a given menu item.
     *
     * @param item The menu item to select.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> deselect(VirtualItem<V, AbstractDataListItem<V>> item) {
        return deselect(item, isSelectionListenersPaused());
    }

    /**
     * Selects a given menu item with the option to silence selection events.
     *
     * @param item The menu item to select.
     * @param silent   If true, selection listeners will be paused; otherwise, they will be active.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> deselect(VirtualItem<V, AbstractDataListItem<V>> item, boolean silent) {
        item.deselect();
        if(!silent) {
            getDeselectionListeners().forEach(selectionListener -> selectionListener.onSelectionChanged(Optional.of(item), getSelection()));
        }
        return this;
    }

    public DataList<V> selectAll() {
        return selectAll(isSelectionListenersPaused());
    }

    public DataList<V> selectAll(boolean silent) {
        getItems().forEach(v -> select(v, silent));
        return this;
    }

    public DataList<V> deselectAll() {
        return deselectAll(isSelectionListenersPaused());
    }

    public DataList<V> deselectAll(boolean silent) {
        getVirtualScrollPanel().getWindowList().getAll().forEach(v -> deselect(v, silent));
        return this;
    }

    /**
     * Selects a menu item at a specified index.
     *
     * @param index The index of the menu item to select.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> selectAt(int index) {
        return selectAt(index, isSelectionListenersPaused());
    }

    /**
     * Selects a menu item at a specified index with the option to silence selection events.
     *
     * @param index  The index of the menu item to select.
     * @param silent If true, selection listeners will be paused; otherwise, they will be active.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> selectAt(int index, boolean silent) {
        List<VirtualItem<V, AbstractDataListItem<V>>> dataListItems = getItems();
        if (index < dataListItems.size() && index >= 0) {
            select(dataListItems.get(index), silent);
        }
        return this;
    }

    /**
     * Selects a menu item at a specified index.
     *
     * @param index The index of the menu item to select.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> deselectAt(int index) {
        return deselectAt(index, isSelectionListenersPaused());
    }

    /**
     * Selects a menu item at a specified index with the option to silence selection events.
     *
     * @param index  The index of the menu item to select.
     * @param silent If true, selection listeners will be paused; otherwise, they will be active.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> deselectAt(int index, boolean silent) {
        List<VirtualItem<V, AbstractDataListItem<V>>> dataListItems = getItems();
        if (index < dataListItems.size() && index >= 0) {
            deselect(dataListItems.get(index), silent);
        }
        return this;
    }

    /**
     * Checks if the menu is set to automatically close upon selection of an item.
     *
     * @return true if the menu will auto-close on selection, false otherwise.
     */
    public boolean isAutoCloseOnSelect() {
        return autoCloseOnSelect;
    }

    /**
     * Sets whether the menu should automatically close upon selecting an item.
     *
     * @param autoCloseOnSelect If true, the menu will auto-close on selection.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setAutoCloseOnSelect(boolean autoCloseOnSelect) {
        this.autoCloseOnSelect = autoCloseOnSelect;
        return this;
    }

    /**
     * Checks if the menu supports selecting multiple items simultaneously.
     *
     * @return true if the menu supports multi-selection, false otherwise.
     */
    public boolean isMultiSelect() {
        return multiSelect;
    }

    /**
     * Enables or disables the ability to select multiple items in the menu.
     *
     * @param multiSelect If true, multi-selection will be enabled.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
        return this;
    }

    /**
     * Checks if the menu is set to automatically open.
     *
     * @return true if the menu will auto-open, false otherwise.
     */
    public boolean isAutoOpen() {
        return autoOpen;
    }

    /**
     * Sets whether the menu should automatically open.
     *
     * @param autoOpen If true, the menu will auto-open.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setAutoOpen(boolean autoOpen) {
        this.autoOpen = autoOpen;
        return this;
    }

    /**
     * Checks if the menu is set to fit the width of its target.
     *
     * @return true if the menu fits the target width, false otherwise.
     */
    public boolean isFitToTargetWidth() {
        return fitToTargetWidth;
    }

    /**
     * Sets whether the menu should fit the width of its target.
     *
     * @param fitToTargetWidth If true, the menu will fit the target width.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setFitToTargetWidth(boolean fitToTargetWidth) {
        this.fitToTargetWidth = fitToTargetWidth;
        return this;
    }

    /**
     * Pauses the selection listeners of the menu.
     *
     * @return The current {@link DataList} instance.
     */
    @Override
    public DataList<V> pauseSelectionListeners() {
        this.togglePauseSelectionListeners(true);
        return this;
    }

    /**
     * Resumes the paused selection listeners of the menu.
     *
     * @return The current {@link DataList} instance.
     */
    @Override
    public DataList<V> resumeSelectionListeners() {
        this.togglePauseSelectionListeners(false);
        return this;
    }

    /**
     * Toggles the pause state of the selection listeners.
     *
     * @param toggle If true, pauses the selection listeners; if false, resumes them.
     * @return The current {@link DataList} instance.
     */
    @Override
    public DataList<V> togglePauseSelectionListeners(boolean toggle) {
        this.selectionListenersPaused = toggle;
        return this;
    }

    /**
     * Retrieves the set of selection listeners associated with the menu.
     *
     * @return A set of selection listeners.
     */
    @Override
    public Set<SelectionListener<? super VirtualItem<V, AbstractDataListItem<V>>, ? super List<VirtualItem<V, AbstractDataListItem<V>>>>>
    getSelectionListeners() {
        return selectionListeners;
    }

    /**
     * Retrieves the set of deselection listeners associated with the menu.
     *
     * @return A set of deselection listeners.
     */
    @Override
    public Set<SelectionListener<? super VirtualItem<V, AbstractDataListItem<V>>, ? super List<VirtualItem<V, AbstractDataListItem<V>>>>>
    getDeselectionListeners() {
        return deselectionListeners;
    }

    /**
     * Checks if the selection listeners of the menu are currently paused.
     *
     * @return true if the selection listeners are paused, false otherwise.
     */
    @Override
    public boolean isSelectionListenersPaused() {
        return this.selectionListenersPaused;
    }

    /**
     * Triggers the selection listeners of the menu.
     *
     * @param source    The source menu item that caused the selection.
     * @param selection A list of selected menu items.
     * @return The current {@link DataList} instance.
     */
    @Override
    public DataList<V> triggerSelectionListeners(
            VirtualItem<V, AbstractDataListItem<V>> source, List<VirtualItem<V, AbstractDataListItem<V>>> selection) {
        selectionListeners.forEach(
                listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
        return this;
    }

    /**
     * Triggers the deselection listeners of the menu.
     *
     * @param source    The source menu item that caused the deselection.
     * @param selection A list of deselected menu items.
     * @return The current {@link DataList} instance.
     */
    @Override
    public DataList<V> triggerDeselectionListeners(
            VirtualItem<V, AbstractDataListItem<V>> source, List<VirtualItem<V, AbstractDataListItem<V>>> selection) {
        deselectionListeners.forEach(
                listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
        return this;
    }

    /**
     * Returns the current selection of menu items.
     *
     * @return A list of currently selected menu items.
     */
    @Override
    public List<VirtualItem<V, AbstractDataListItem<V>>> getSelection() {
        return selectedValues;
    }

    /**
     * Sets the menu to have a bordered appearance.
     *
     * @param bordered If true, the menu will have a border; if false, it will not.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setBordered(boolean bordered) {
        removeCss("menu-bordered");
        if (bordered) {
            css("menu-bordered");
        }
        return this;
    }

    private boolean hasVisibleItems() {
        List<AbstractDataListItem<V>> dataListItems = getWindowItems();
        for (int index = 0; index < dataListItems.size(); index++) {
            if (dataListItems.get(index).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Sets the current open submenu.
     *
     * @param dropMenu The submenu to be set as currently open.
     */
    void setCurrentOpen(DataList<V> dropMenu) {
        this.currentOpen = dropMenu;
    }

    /**
     * Closes the currently open submenu.
     */
    void closeCurrentOpen() {
        if (nonNull(currentOpen)) {
            currentOpen.close();
        }
    }

    /**
     * Checks if the menu is currently open.
     *
     * @return true if the menu is open, false otherwise.
     */
    public boolean isOpened() {
        return isDropDown() && isAttached();
    }

    /**
     * Opens the menu based on a triggering event.
     *
     * @param evt The event that triggered the open action.
     */
    private void open(Event evt) {
        getEffectiveDropDirection().init(evt);
        open();
    }

    /**
     * Opens the menu and optionally sets focus on it.
     *
     * @param focus If true, the menu will be focused upon opening.
     */
    public void open(boolean focus) {
        if (isDropDown() && openCondition.test(this)) {
            if (getTarget().isPresent()) {
                DominoElement<Element> targetElement = getTarget().get().getTargetElement();
                targetElement.addCss(dui_context_datalist_target_open);
                if (!(targetElement.isReadOnly() || targetElement.isDisabled())) {
                    doOpen(focus);
                }
            } else {
                doOpen(focus);
            }
        }
    }

    /**
     * Opens the menu and manages the necessary UI changes and events.
     *
     * @param focus If true, the menu will be focused upon opening.
     */
    private void doOpen(boolean focus) {
        getConfig().getZindexManager().onPopupOpen(this);
        if (isOpened()) {
            position();
        } else {
            closeOthers();
            if (isSearchable()) {
                searchBox.get().clearSearch();
            }
            triggerOpenListeners(this);
            boolean shouldFocus = focus;
            onAttached(
                    (e, mutationRecord) -> {
                        position();
                        if (shouldFocus) {
                            focus();
                        }
                        elementOf(getDataListAppendTarget()).onDetached((targetElement, targetDetach) -> close());
                    });
            appendStrategy.onAppend(getDataListAppendTarget(), element.element());
            onDetached(
                    (e, mutationRecord) -> {
                        close();
                        if (isDropDown()) {
                            triggerCloseListeners(this);
                        }
                    });
            show();
        }
    }

    /**
     * Adjusts the position of the menu relative to its target element.
     */
    private void position() {
        if (isDropDown() && isOpened()) {
            Optional<MenuTarget> menuTarget = getTarget();
            menuTarget.ifPresent(
                    target -> {
                        getEffectiveDropDirection()
                                .position(DropDirectionContext.of(element.element(), target.getTargetElement().element(),fitToTargetWidth));
                    });
        }
    }

    /**
     * Determines the effective drop direction of the menu based on various conditions.
     *
     * @return The drop direction for the menu.
     */
    protected DropDirection getEffectiveDropDirection() {
        if (isUseSmallScreensDirection() && smallScreen) {
            return smallScreenDropDirection;
        } else {
            if (isContextMenu()) {
                return contextMenuDropDirection;
            } else {
                return dropDirection;
            }
        }
    }

    /**
     * Closes other menus if they are opened.
     */
    private void closeOthers() {
        if (this.hasAttribute("domino-sub-menu")
                && Boolean.parseBoolean(this.getAttribute("domino-sub-menu"))) {
            return;
        }
        PopupsCloser.close();
    }

    /**
     * Sets the focus on the menu.
     */
    public void focus() {
        getFocusElement().focus();
    }

    /**
     * Gets the current target element for the menu.
     *
     * @return An optional containing the menu target, or empty if no target is set.
     */
    public Optional<MenuTarget> getTarget() {
        if (isNull(lastTarget) && targets().size() == 1) {
            return targets().values().stream().findFirst();
        }
        return Optional.ofNullable(lastTarget);
    }

    /**
     * Sets the menu target.
     *
     * @param menuTarget The {@link MenuTarget} instance representing the menu's target.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setTarget(MenuTarget menuTarget) {
        this.targets()
                .values()
                .forEach(
                        target -> {
                            target
                                    .getTargetElement()
                                    .removeEventListener(
                                            isContextMenu() ? EventType.contextmenu.getName() : EventType.click.getName(),
                                            openListener);
                            target.getTargetElement().removeDetachObserver(menuTarget.getTargetDetachObserver());
                            target.getTargetElement().removeAttachObserver(menuTarget.getTargetAttachObserver());
                        });
        this.targets().clear();
        return addTarget(menuTarget);
    }

    /**
     * Sets the target element for the menu.
     *
     * @param targetElement The element to be set as the menu's target.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setTargetElement(IsElement<?> targetElement) {
        return setTargetElement(targetElement.element());
    }

    /**
     * Sets the target element for the menu.
     *
     * @param targetElement The element to be set as the menu's target.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setTargetElement(Element targetElement) {
        setTarget(MenuTarget.of(targetElement));
        return this;
    }

    /**
     * Adds a new target for the menu.
     *
     * @param menuTarget The new target to add.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> addTarget(MenuTarget menuTarget) {
        if (nonNull(menuTarget)) {
            this.targets().put(menuTarget.getTargetElement().getDominoId(), menuTarget);
            menuTarget.setTargetDetachObserver(
                    (e, mutationRecord) -> {
                        if (Objects.equals(menuTarget, lastTarget)) {
                            close();
                        }

                        this.targets().remove(menuTarget.getTargetElement().getDominoId());
                    });

            menuTarget.setTargetAttachObserver(
                    (e, mutationRecord) -> {
                        this.targets().put(menuTarget.getTargetElement().getDominoId(), menuTarget);
                    });

            elementOf(menuTarget.getTargetElement()).onDetached(menuTarget.getTargetDetachObserver());
            elementOf(menuTarget.getTargetElement()).onAttached(menuTarget.getTargetAttachObserver());
        }
        if (!this.targets().isEmpty()) {
            applyTargetListeners(menuTarget);
            setDropDown(true);
        } else {
            setDropDown(false);
        }
        return this;
    }

    /**
     * Gets the element to which the menu is appended in the DOM.
     *
     * @return The append target element.
     */
    public Element getDataListAppendTarget() {
        return dataListAppendTarget;
    }

    /**
     * Sets the element to which the menu will be appended in the DOM.
     *
     * @param appendTarget The new append target element.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setDataListAppendTarget(Element appendTarget) {
        if (isNull(appendTarget)) {
            this.dataListAppendTarget = document.body;
        } else {
            this.dataListAppendTarget = appendTarget;
        }
        return this;
    }

    /**
     * Opens the menu if it is a dropdown type.
     *
     * @return The current {@link DataList} instance.
     */
    public DataList<V> open() {
        if (isDropDown()) {
            open(true);
        }
        return this;
    }

    /**
     * Closes the menu if it is a dropdown type and if it is currently open.
     *
     * @return The current {@link DataList} instance.
     */
    public DataList<V> close() {
        if (isDropDown()) {
            if (isOpened()) {
                this.remove();
                getTarget()
                        .ifPresent(
                                menuTarget -> {
                                    menuTarget.getTargetElement().element().focus();
                                    menuTarget.getTargetElement().removeCss(dui_context_datalist_target_open);
                                });
                if (isSearchable()) {
                    searchBox.get().clearSearch();
                }
                triggerCloseListeners(this);
            }
        }
        return this;
    }

    /**
     * Retrieves the direction in which the menu will drop when opened.
     *
     * @return The current drop direction for the menu.
     */
    public DropDirection getDropDirection() {
        return dropDirection;
    }

    /**
     * Sets the direction in which the menu will drop when opened.
     *
     * @param dropDirection The desired drop direction.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setDropDirection(DropDirection dropDirection) {
        if (nonNull(this.dropDirection)) {
            this.dropDirection.cleanup(this.element());
        }

        if (nonNull(this.effectiveDropDirection)) {
            this.effectiveDropDirection.cleanup(this.element());
        }

        if (effectiveDropDirection.equals(this.dropDirection)) {
            this.dropDirection = dropDirection;
            this.effectiveDropDirection = this.dropDirection;
        } else {
            this.dropDirection = dropDirection;
        }
        return this;
    }

    /**
     * Checks if the menu is set as a context menu.
     *
     * @return {@code true} if the menu is a context menu, {@code false} otherwise.
     */
    public boolean isContextMenu() {
        return contextMenu;
    }

    /**
     * Sets the menu as a context menu or not.
     *
     * @param contextMenu {@code true} to set the menu as a context menu, {@code false} otherwise.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setContextMenu(boolean contextMenu) {
        this.contextMenu = contextMenu;
        addCss(BooleanCssClass.of(dui_context_datalist, contextMenu));
        targets().values().forEach(this::applyTargetListeners);
        return this;
    }

    /**
     * Applies the appropriate event listeners to the target element based on whether the menu is a
     * context menu or not.
     *
     * @param menuTarget The target menu to which the listeners should bce applied.
     */
    private void applyTargetListeners(MenuTarget menuTarget) {
        if (isContextMenu()) {
            menuTarget.getTargetElement().removeEventListener(EventType.click.getName(), openListener);
            menuTarget.getTargetElement().addEventListener(EventType.contextmenu.getName(), openListener);
        } else {
            menuTarget
                    .getTargetElement()
                    .removeEventListener(EventType.contextmenu.getName(), openListener);
            menuTarget.getTargetElement().addEventListener(EventType.click.getName(), openListener);
        }
    }

    /**
     * Handles the event when an item is selected in the menu.
     *
     * @param item   The item that was selected.
     * @param silent Indicates whether the selection was silent or should trigger events.
     */
    protected void onItemSelected(VirtualItem<V, AbstractDataListItem<V>> item, boolean silent) {

        if (!this.selectedValues.contains(item)) {
            if (!multiSelect && !this.selectedValues.isEmpty()) {
                this.selectedValues.get(0).deselect();
                this.selectedValues.clear();
                triggerDeselectionListeners(item, getSelection());
            }
            this.selectedValues.add(item);
            if (!silent) {
                triggerSelectionListeners(item, getSelection());
            }
        }

    }

    /**
     * Handles the event when an item is deselected in the menu.
     *
     * @param item   The item that was deselected.
     * @param silent Indicates whether the deselection was silent or should trigger events.
     */
    protected void onItemDeselected(VirtualItem<V, AbstractDataListItem<V>> item, boolean silent) {
        this.selectedValues.remove(item);
        if (!silent) {
            triggerDeselectionListeners(item, getSelection());
        }

    }

    /**
     * Checks if the menu is configured to use the small screens direction for dropping.
     *
     * @return {@code true} if the menu uses the small screens direction, {@code false} otherwise.
     */
    public boolean isUseSmallScreensDirection() {
        return useSmallScreensDirection;
    }

    /**
     * Sets whether the menu should use the small screens drop direction.
     *
     * @param useSmallScreensDropDirection {@code true} to enable small screens drop direction, {@code
     *                                     false} otherwise.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setUseSmallScreensDirection(boolean useSmallScreensDropDirection) {
        this.useSmallScreensDirection = useSmallScreensDropDirection;
        if (!useSmallScreensDropDirection && getEffectiveDropDirection() == smallScreenDropDirection) {
            this.effectiveDropDirection = dropDirection;
        }
        return this;
    }

    /**
     * Determines if the menu acts as a drop-down or a context menu.
     *
     * @return {@code true} if the menu acts as a drop-down or a context menu, {@code false}
     * otherwise.
     */
    public boolean isDropDown() {
        return dropDown || isContextMenu();
    }

    /**
     * Sets the menu's behavior to be a dropdown or not. It also adjusts attributes and listeners
     * accordingly.
     *
     * @param dropdown {@code true} to set the menu as a dropdown, {@code false} otherwise.
     */
    private void setDropDown(boolean dropdown) {
        if (dropdown) {
            this.setAttribute("domino-ui-root-menu", true).setAttribute(DOMINO_UI_AUTO_CLOSABLE, true);
            dataListElement.elevate(Elevation.LEVEL_1);
        } else {
            this.removeAttribute("domino-ui-root-menu").removeAttribute(DOMINO_UI_AUTO_CLOSABLE);
            dataListElement.elevate(Elevation.NONE);
            document.removeEventListener("scroll", repositionListener);
        }
        addCss(BooleanCssClass.of(dui_datalist_drop, dropdown));
        this.dropDown = dropdown;
        setAutoClose(this.dropDown);
    }


    /**
     * Configures the menu to include a header.
     *
     * @return The current {@link DataList} instance.
     */
    public DataList<V> withHeader() {
        dataListHeader.get();
        return this;
    }

    /**
     * Configures the menu to include a customized header.
     *
     * @param handler A handler to customize the header.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> withHeader(ChildHandler<DataList<V>, NavBar> handler) {
        handler.apply(this, dataListHeader.get());
        return this;
    }

    /**
     * Checks if the menu is modal.
     *
     * @return {@code false} since the menu isn't a modal.
     */
    @Override
    public boolean isModal() {
        return false;
    }

    /**
     * Checks if the menu is set to auto-close.
     *
     * @return {@code true} if the menu is set to auto-close, {@code false} otherwise.
     */
    @Override
    public boolean isAutoClose() {
        return Boolean.parseBoolean(getAttribute(DOMINO_UI_AUTO_CLOSABLE, "false"));
    }

    /**
     * Sets the auto-close behavior for the menu.
     *
     * @param autoClose {@code true} to set the menu to auto-close, {@code false} otherwise.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setAutoClose(boolean autoClose) {
        if (autoClose) {
            setAttribute(DOMINO_UI_AUTO_CLOSABLE, "true");
        } else {
            removeAttribute(DOMINO_UI_AUTO_CLOSABLE);
        }
        return this;
    }

    /**
     * Sets the condition for opening the menu.
     *
     * @param openCondition A condition that needs to be met for the menu to open. If null,
     *                      defaults to always allow the menu to open.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setOpenCondition(Predicate<DataList<V>> openCondition) {
        if (isNull(openCondition)) {
            this.openCondition = menu -> true;
            return this;
        }
        this.openCondition = openCondition;
        return this;
    }

    /**
     * Checks if the menu is set to close when it loses focus.
     *
     * @return {@code true} if the menu is set to close on blur, {@code false} otherwise.
     */
    public boolean isCloseOnBlur() {
        return closeOnBlur;
    }

    /**
     * Sets the close-on-blur behavior for the menu.
     *
     * @param closeOnBlur {@code true} to set the menu to close when it loses focus, {@code false}
     *                    otherwise.
     * @return The current {@link DataList} instance.
     */
    public DataList<V> setCloseOnBlur(boolean closeOnBlur) {
        this.closeOnBlur = closeOnBlur;
        return this;
    }

    private boolean isCloseOnScroll() {
        return hasAttribute("d-close-on-scroll")
                && "true".equalsIgnoreCase(getAttribute("d-close-on-scroll"));
    }

    public DataList<V> setCloseOnScroll(boolean closeOnScroll) {
        if (!closeOnScroll) {
            window.removeEventListener("scroll", closeOnScrollListener);
        }
        setAttribute("d-close-on-scroll", closeOnScroll);
        return this;
    }

    private Map<String, MenuTarget> targets() {
        if (isNull(this.targets)) {
            this.targets = new HashMap<>();
        }
        return this.targets;
    }

    /**
     * @return boolean true if the selection style should be preserved after the menu item loses the
     * selection focus, otherwise false.
     */
    public boolean isPreserveSelectionStyles() {
        return preserveSelectionStyles;
    }

    /**
     * if true selecting an Item in the menu will preserve the selection style when the menu loses the
     * focus.
     *
     * @param preserveSelectionStyles boolean, true to preserve the style, false to remove the style.
     * @return same Menu instance.
     */
    public DataList<V> setPreserveSelectionStyles(boolean preserveSelectionStyles) {
        this.preserveSelectionStyles = preserveSelectionStyles;
        return this;
    }

    @Override
    public ZIndexLayer getZIndexLayer() {
        if (isDropDown()) {
            return getTarget()
                    .map(t -> t.getTargetElement().getZIndexLayer())
                    .orElse(ZIndexLayer.Z_LAYER_1);
        }
        return super.getZIndexLayer();
    }

    public DataListVirtualScroll<V> getVirtualScrollPanel() {
        return virtualScrollPanel;
    }
}
