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

import elemental2.core.JsDate;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.style.ConditionalCssClass;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.TakesValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.a;
import static org.dominokit.domino.ui.utils.Domino.div;

/**
 * Represents a general purpose menu item that can be used in different types of menus.
 *
 * <p>Usage example:
 *
 * <pre>
 * AbstractMenuItem<String> item = new AbstractMenuItem<>();
 * item.setKey("item1").withValue("Value1");
 * </pre>
 *
 * @param <V> the type parameter defining the value of the menu item
 * @see BaseDominoElement
 */
public abstract class AbstractDataListItem<V> extends BaseDominoElement<HTMLDivElement, AbstractDataListItem<V>>
        implements TakesValue<V>,
        DataListStyles,
        ElementWindowItem<V, HTMLDivElement, AbstractDataListItem<V>> {

    protected DivElement root;
    protected AnchorElement linkElement;
    protected DivElement prefixElement;
    protected DivElement bodyElement;
    protected DivElement postfixElement;
    protected boolean searchable = true;
    protected boolean selectable = true;
    DataList<V> parent;
    private V value;
    private boolean clickToSelect = true;
    private VirtualItem<V, WindowItem<V>> virtualItem;

    /**
     * Default constructor to create a menu item.
     */
    public AbstractDataListItem(V value) {
        this.value = value;

            root = div().addCss(dui_datalist_item);

            root.appendChild(linkElement =
                    a("#")
                            .setAttribute("tabindex", "0")
                            .setAttribute("aria-expanded", "true")
                            .addCss(dui_datalist_item_anchor)
                            .appendChild(prefixElement = div().addCss(dui_datalist_item_prefix))
                            .appendChild(bodyElement = div().addCss(dui_datalist_item_body))
                            .appendChild(postfixElement = div().addCss(dui_datalist_item_postfix)));

            init(this);
            double[] startTime = new double[]{0};

            root.addEventListener(
                    EventType.touchstart.getName(),
                    evt -> {
                        startTime[0] = JsDate.now();
                        focus();
                    });
            root.addEventListener(
                    EventType.touchend.getName(),
                    evt -> {
                        evt.stopPropagation();
                        double endTime = JsDate.now();
                        double diff = endTime - startTime[0];
                        if (diff < 200) {
                            evt.preventDefault();
                            if(clickToSelect) {
                                onSelected();
                            }
                        }
                    });
            root.addEventListener(
                    EventType.click.getName(),
                    evt -> {
                        evt.stopPropagation();
                        evt.preventDefault();
                        if(clickToSelect) {
                            onSelected();
                        }
                    });

    }

    @Override
    public VirtualItem<V, WindowItem<V>> getVirtualItem() {
        return this.virtualItem;
    }

    @Override
    public void setVirtualItem(VirtualItem<V, WindowItem<V>> virtualItem) {
        this.virtualItem = virtualItem;
    }

    @Override
    public void onSelectionChanged(boolean selection) {
        if (selection) {
            select();
        }else {
            deselect();
        }
    }

    protected void setClickToSelect(boolean clickToSelect) {
        this.clickToSelect = clickToSelect;
    }

    public void onEnterWindow(int index, DataList<V> dataList, int itemHeight) {
        dataList.appendChild(this, index);
    }

    public void onExitWindow(int index, DataList<V> dataList, int itemHeight) {
        this.remove();
    }

    @Override
    public V get() {
        return getValue();
    }

    private void onSelected() {
        if (parent.isMultiSelect() && getVirtualItem().isSelected()) {
            getVirtualItem().deselect();
        } else {
            getVirtualItem().select();
        }
    }

    /**
     * Gets the target element to which child elements can be appended.
     *
     * @return the body element of the menu item
     */
    @Override
    public Element getAppendTarget() {
        return bodyElement.element();
    }

    /**
     * Determines whether the menu item is searchable.
     *
     * @return true if the item is searchable, false otherwise
     */
    public boolean isSearchable() {
        return searchable;
    }

    /**
     * Sets the searchable property of the menu item.
     *
     * @param searchable true to make the item searchable, false otherwise
     * @param <T>        the type of the menu item
     * @return the current instance of the menu item
     */
    public <T extends AbstractDataListItem<V>> T setSearchable(boolean searchable) {
        this.searchable = searchable;
        return (T) this;
    }

    /**
     * Performs a search on the menu item based on the given token.
     *
     * <p>This method typically determines the visibility of the menu item based on the search token.
     *
     * @param token         the search token or keyword
     * @param caseSensitive determines if the search should consider case sensitivity
     * @return always returns {@code false}; the reason for this should be provided based on the
     * method's context
     */
    public boolean onSearch(String token, boolean caseSensitive) {
        if (isNull(token) || token.isEmpty()) {
            this.show();
        } else {
            hide();
        }
        return false;
    }

    /**
     * Selects the menu item.
     *
     * <p>Adds selection styling and notifies the selection handlers if not silent.
     *
     * @return the current instance of the menu item
     */
    <T extends AbstractDataListItem<V>> T select() {
        if (!isDisabled()) {
            addCss(
                    ConditionalCssClass.of(dui_datalist_item_selected, () -> parent.isPreserveSelectionStyles()));
            setAttribute("selected", true);
        }
        return (T) this;
    }

    /**
     * Deselects the menu item.
     *
     * <p>Removes selection styling and notifies the deselection handlers if not silent.
     *
     * @return the current instance of the menu item
     */
    <T extends AbstractDataListItem<V>> T deselect() {
        if (!isDisabled()) {
            dui_datalist_item_selected.remove(this);
            setAttribute("selected", false);
        }
        return (T) this;
    }

    /**
     * Checks if the menu item is currently selected.
     *
     * @return {@code true} if the menu item is selected, {@code false} otherwise
     */
    public boolean isSelected() {
        return getVirtualItem().isSelected();
    }

    /**
     * Sets focus on the clickable element of the menu item.
     *
     * @return the current instance of the menu item
     */
    public AbstractDataListItem<V> focus() {
        getClickableElement().focus();
        return this;
    }

    /**
     * Retrieves the value associated with this menu item.
     *
     * @return the value of the menu item
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets the value for this menu item.
     *
     * <p>This can represent any associated data or context for the item.
     *
     * @param value the value to set
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Assigns a value to the menu item and returns the item instance.
     *
     * <p>This is a fluid API method to allow chained calls.
     *
     * @param value the value to set
     * @return the current instance of the menu item with the specified value set
     */
    public <T extends AbstractDataListItem<V>> T withValue(V value) {
        setValue(value);
        return (T) this;
    }

    /**
     * Retrieves the parent menu of this menu item.
     *
     * @return the parent menu of this item
     */
    public DataList<V> getParent() {
        return this.parent;
    }

    /**
     * Sets the parent datalist for this datalist item.
     *
     * @param datalist the parent datalist
     */
    void setParent(DataList<V> datalist) {
        this.parent = datalist;
    }

    /**
     * Retrieves the clickable element associated with this menu item.
     *
     * @return the HTML element that can be clicked to trigger this menu item
     */
    @Override
    public HTMLElement getClickableElement() {
        return linkElement.element();
    }

    @Override
    public PrefixElement getPrefixElement() {
        return PrefixElement.of(prefixElement);
    }

    @Override
    public PostfixElement getPostfixElement() {
        return PostfixElement.of(postfixElement);
    }

    /**
     * Check if the menu item text starts with a specific string
     *
     * @param character the text to check against.
     * @return boolean, <b>true</b> if the menu item starts with the text, <b>false</b> otherwise.
     */
    public boolean startsWith(String character) {
        return false;
    }

    /**
     * Returns the underlying DOM element.
     *
     * @return the DOM element of the menu item
     */
    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
