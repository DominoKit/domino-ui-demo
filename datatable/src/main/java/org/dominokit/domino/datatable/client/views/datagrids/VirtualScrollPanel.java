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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.*;

import java.util.List;

import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.keyboard.KeyboardEventOptions;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.*;

public abstract class VirtualScrollPanel<
        T,
        E extends HTMLElement,
        I extends ElementWindowItem<T, E, I>,
        C extends VirtualScrollPanel<T, E, I, C>>
        extends BaseDominoElement<HTMLDivElement, C> implements WindowChangeListener<T, I> {

    public static final CssClass dui_vscroll = () -> "dui-vscroll";
    public static final CssClass dui_vscroll_body = () -> "dui-vscroll-body";
    public static final CssClass dui_vscroll_body_main = () -> "dui-vscroll-body-main";
    public static final CssClass dui_vscroll_body_viewport = () -> "dui-vscroll-body-viewport";
    public static final CssClass dui_vscroll_viewport_group = () -> "dui-vscroll-viewport-rowgroup";
    public static final CssClass dui_vscroll_content = () -> "dui-vscroll-body-items";
    public static final CssClass dui_vscroll_body_vscroller = () -> "dui-vscroll-body-vscroller";
    public static final CssClass dui_vscroll_body_vscroller_viewport = () -> "dui-vscroll-body-vscroller-viewport";
    public static final CssClass dui_vscroll_body_vscroller_container = () -> "dui-vscroll-body-vscroller-container";
    public static final CssClass dui_vscroll_body_hscroller = () -> "dui-vscroll-body-hscroller";
    public static final CssClass dui_vscroll_body_hscroller_viewport = () -> "dui-vscroll-body-hscroller-viewport";
    public static final CssClass dui_vscroll_body_hscroller_container = () -> "dui-vscroll-body-hscroller-container";
    public static final int MAX_HEIGHT_LIMIT = 1_500_000;
    private final DivElement root;
    private final DivElement viewportItemsGroup;
    private final DivElement body;
    private final DivElement vscrollViewport;
    private final DivElement hscrollViewport;
    private final String uniqueId;
    private final String heightVar;
    private boolean forceUpdate = false;
    private ScrollingWindowList<T, I> windowList;
    private int lastSync;
    private double lastScrollTop = 0.0;
    private double itemsLastScrollTop = 0.0;
    private int itemHeight = 1;
    private int windowSize = 1;
    private int maxContainerHeight;
    private int containerHeight;
    private double lastKeyboardScroll = 0;
    private boolean updateItemsScroll = true;

    public VirtualScrollPanel(VirtualScrollItemMapper<T, I> mapper) {
        this.windowList = new ScrollingWindowList<>(mapper, this);
        this.uniqueId = DominoId.unique("svcroll-");
        this.heightVar = "--dui-" + uniqueId + "-height";
        this.root =
                div()
                        .addCss(dui_vscroll)
                        .appendChild(div()
                                .addCss(dui_vscroll_body)
                                .appendChild(div()
                                        .addCss(dui_vscroll_body_main)
                                        .appendChild(div()
                                                .addCss(dui_vscroll_body_viewport)
                                                .appendChild(viewportItemsGroup = div()
                                                        .addCss(dui_vscroll_viewport_group)
                                                        .appendChild(body = div()
                                                                .addCss(dui_vscroll_content)
                                                                .setCssProperty("height", "var(" + heightVar + ", 100%)")
                                                        )
                                                )
                                                .appendChild(div()
                                                        .addCss(dui_vscroll_body_vscroller)
                                                        .appendChild(vscrollViewport = div()
                                                                .addCss(dui_vscroll_body_vscroller_viewport)
                                                                .appendChild(div()
                                                                        .addCss(dui_vscroll_body_vscroller_container)
                                                                        .setCssProperty("height", "var(" + heightVar + ", 100%)")
                                                                )
                                                        )
                                                )
                                        )
                                        .appendChild(div()
                                                .addCss(dui_vscroll_body_hscroller)
                                                .appendChild(hscrollViewport =
                                                        div().addCss(dui_vscroll_body_hscroller_viewport)
                                                                .appendChild(div().addCss(dui_vscroll_body_hscroller_container))
                                                )
                                        )
                                )
                        );

        viewportItemsGroup.addEventListener(
                "scroll",
                Event::preventDefault);

        viewportItemsGroup.onKeyDown(keyEvents -> {
            keyEvents.onArrowUpDown(KeyboardEventOptions.create()
                    .setPreventDefault(false), evt -> {
                double scrollTop = viewportItemsGroup.element().scrollTop;
                double delta = scrollTop - lastKeyboardScroll;

                    forceUpdate = true;
                    updateItemsScroll = false;
                    vscrollViewport.element().scrollTop = vscrollViewport.element().scrollTop + delta;

                this.lastKeyboardScroll = scrollTop;
            });
        });


        viewportItemsGroup.addEventListener("wheel", evt -> {
            WheelEvent wheelEvent = Js.uncheckedCast(evt);
            if (wheelEvent.deltaY > 0) {
                double position = viewportItemsGroup.element().scrollTop + viewportItemsGroup.element().clientHeight;
                if (position >= containerHeight) {
                    forceUpdate = true;
                }
                vscrollViewport.element().scrollTop = vscrollViewport.element().scrollTop + wheelEvent.deltaY;
            } else if (wheelEvent.deltaY < 0) {
                if (viewportItemsGroup.element().scrollTop <= containerHeight) {
                    forceUpdate = true;
                }
                vscrollViewport.element().scrollTop = vscrollViewport.element().scrollTop + wheelEvent.deltaY;
            }
        });

        vscrollViewport.addEventListener(
                "scroll",
                evt -> {
                    onScrollUpdated();
                });

        viewportItemsGroup.addEventListener(
                "scroll",
                evt -> {
                    hscrollViewport.element().scrollLeft = viewportItemsGroup.element().scrollLeft;
                });

        hscrollViewport.addEventListener(
                "scroll",
                evt -> {
                    viewportItemsGroup.element().scrollLeft = hscrollViewport.element().scrollLeft;
                });

        init((C) this);
    }

    private void onScrollUpdated() {
        DomGlobal.cancelAnimationFrame(this.lastSync);
        double scrollTop = vscrollViewport.element().scrollTop;
        if(updateItemsScroll) {
            viewportItemsGroup.element().scrollTop = scrollTop % maxContainerHeight;
        }
        updateItemsScroll = true;
        double scrollDelta = scrollTop - lastScrollTop;
        int scrolledItems = Double.valueOf(Math.ceil(scrollTop / itemHeight)).intValue();
        int diffItems = Double.valueOf(Math.ceil(Math.abs(scrollDelta) / itemHeight)).intValue();

        this.lastSync =
                DomGlobal.requestAnimationFrame(
                        timestamp -> {
                            if ((diffItems >= windowList.getScrollThreshold()) || forceUpdate) {
                                forceUpdate = false;
                                int offset = scrolledItems - windowList.getWindowStart();
                                windowList.scroll(offset - windowList.getScrollThreshold());
                                lastScrollTop = vscrollViewport.element().scrollTop;
                            }
                        });
    }

    public C updateItems(List<VirtualItem<T, I>> items) {
        clearElement();
        vscrollViewport.element().scrollTop = 0;
        viewportItemsGroup.element().scrollTop = 0;
        viewportItemsGroup.element().scrollLeft = 0;
        hscrollViewport.element().scrollLeft = 0;

        windowList.setItems(items, this.windowSize);
        windowList.init();
        this.root.setCssProperty(
                heightVar, Unit.px.of(itemHeight * items.size()));
        return (C) this;
    }

    public C setItems(List<T> items) {
        clearElement();
        nowOrWhenAttached(
                () -> {
                    vscrollViewport.element().scrollTop = 0;
                    viewportItemsGroup.element().scrollTop = 0;
                    viewportItemsGroup.element().scrollLeft = 0;
                    hscrollViewport.element().scrollLeft = 0;
                    DominoElement<E> e = elementOf(windowList.getMapper().map(items.get(0)));
                    e.addCss(dui_invisible);
                    appendChild(e);
                    int itemHeight = e.element().offsetHeight;
                    setAttribute("dui-vs-item-height", String.valueOf(itemHeight));
                    int totalHeight = itemHeight * items.size();
                    int containerItemsLimit = MAX_HEIGHT_LIMIT / itemHeight;
                    maxContainerHeight = containerItemsLimit * itemHeight;
                    body.setHeight(Unit.px.of(maxContainerHeight));
                    this.root.setCssProperty(
                            heightVar, Unit.px.of(totalHeight));
                    setItemHeight(itemHeight);
                    e.remove();
                    containerHeight = this.element().offsetHeight / itemHeight;
                    this.windowSize = Math.min(containerItemsLimit, containerHeight * 5);
                    windowList.setList(items, this.windowSize);
                    windowList.init();
                });
        return (C) this;
    }

    public int getItemHeight() {
        return itemHeight;
    }

    private void setItemHeight(int itemHeight) {
        this.itemHeight = itemHeight;
    }

    @Override
    public Element getAppendTarget() {
        return body.element();
    }


    public C withBodyElement(ChildHandler<C, DivElement> handler) {
        handler.apply((C) this, this.body);
        return (C) this;
    }

    public ScrollingWindowList<T, I> getWindowList() {
        return windowList;
    }

    @Override
    public HTMLDivElement element() {
        return this.root.element();
    }

    void appendChild(ElementWindowItem<T, E, I> menuItem, int index) {
        menuItem.element().style.setProperty("top", Unit.px.of((index * itemHeight) % maxContainerHeight));
        menuItem.element().setAttribute("dui-index", String.valueOf(index));
        body.appendChild(menuItem.element());
    }

}
