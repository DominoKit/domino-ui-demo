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

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScrollingWindowList<T, I extends WindowItem<T>> {

    private final VirtualScrollItemMapper<T, I> mapper;
    private final WindowChangeListener<T, I> listener;
    private List<VirtualItem<T, I>> list;
    private int windowSize;
    private int windowStart;
    private boolean scrolled = false;

    public ScrollingWindowList(
            VirtualScrollItemMapper<T, I> mapper, WindowChangeListener<T, I> listener) {
        this.mapper = mapper;
        this.listener = listener;
        this.windowSize = 0;
        this.windowStart = 0;
    }

    public void setList(List<T> list, int windowSize) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null.");
        }
        if (windowSize < 1) {
            throw new IllegalArgumentException("Window size must be between 1 and the size of the list.");
        }
        if (scrolled) {
            reset();
        }

        this.list = new ArrayList<>();
        for (T t : list) {
            this.list.add(new VirtualItem<>(t, mapper));
        }
        this.windowSize = Math.min(windowSize, list.size());
        this.windowStart = 0;
    }

    public void setItems(List<VirtualItem<T, I>> list, int windowSize) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null.");
        }
        if (windowSize < 1) {
            throw new IllegalArgumentException("Window size must be between 1 and the size of the list.");
        }
        if (scrolled) {
            reset();
        }

        this.list = new ArrayList<>(list);
        this.windowSize = Math.min(windowSize, list.size());
        this.windowStart = 0;
    }

    public void init() {
        scroll(0);
    }

    private void reset() {
        for (int i = windowStart; i < windowStart + windowSize; i++) {
            listener.onItemExitWindow(list.get(i).windowItem(), i);
        }
        this.windowStart = 0;
        this.scrolled = false;
    }

    public int getScrollThreshold() {
        return Math.min(getVisibleWindowSize() * 2, list.size());
    }

    private int getVisibleWindowSize() {
        return windowSize / 5;
    }

    public int getWindowSize() {
        return windowSize;
    }

    /**
     * Returns a view of the current window. If no filter is set, we simply return a subList of the
     * original list. If a filter is active, we use an AbstractList that maps filtered indices to the
     * original list.
     */
    public ListWindow<T, I> getWindow() {
        return new ListWindow<>(list.subList(windowStart, windowStart + windowSize).stream().map(VirtualItem::windowItem).collect(Collectors.toList()));
    }

    /**
     * Returns the current window start position (in the effective view).
     */
    public int getWindowStart() {
        return windowStart;
    }

    public List<VirtualItem<T, I>> getAll() {
        return list;
    }

    public VirtualScrollItemMapper<T, I> getMapper() {
        return mapper;
    }

    /**
     * Scrolls the window by the given offset (positive = forward, negative = backward). For a forward
     * scroll in a filtered view, additional filtering is done on-demand. The scroll operation returns
     * a ScrollEvent detailing which elements entered/exited.
     */
    public void scroll(int offset) {
        int newStart = windowStart + offset;
        // Clamp newStart so that the window stays within the list bounds.
        newStart = Math.max(0, Math.min(newStart, list.size() - windowSize));
        if (offset == 0 && !scrolled) {
            scrolled = true;
            for (int i = newStart; i < windowSize; i++) {
                listener.onItemEnterWindow(list.get(i).windowItem(), i);
            }
            windowStart = newStart;
            return;
        }
        int limit = Math.min(list.size(), newStart + windowSize);
        int oldLimit = Math.min(list.size(), windowStart + windowSize);
        for (int i = newStart; i < limit; i++) {
            if (!(i >= windowStart && i < oldLimit)) {
                listener.onItemEnterWindow(list.get(i).windowItem(), i);
            }
        }

        for (int i = windowStart; i < oldLimit; i++) {
            if (!(i >= newStart && i < limit)) {
                listener.onItemExitWindow(list.get(i).windowItem(), i);
            }
        }
        windowStart = newStart;
    }

    @Override
    public String toString() {
        return getWindow().toString();
    }

}
