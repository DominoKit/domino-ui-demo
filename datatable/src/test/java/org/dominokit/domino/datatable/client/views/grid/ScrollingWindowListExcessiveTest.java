package org.dominokit.domino.datatable.client.views.grid;

import static org.junit.jupiter.api.Assertions.*;

import org.dominokit.domino.datatable.client.views.datagrids.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class ScrollingWindowListExcessiveTest {

    private List<Integer> numbers;
    private ScrollingWindowList<Integer, IntegerWindowItem> windowList;
    private WindowChangeListener<Integer, IntegerWindowItem> windowChangeListener;
    private List<Integer> entered;
    private List<Integer> exited;

    @BeforeEach
    public void setup() {
        numbers = new ArrayList<>();
        // Build a list of numbers 1 to 50.
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }

        entered= new ArrayList<>();
        exited= new ArrayList<>();

        windowChangeListener = new WindowChangeListener<>() {

            @Override
            public void onItemEnterWindow(IntegerWindowItem item, int indexInList) {
                entered.add(item.get());
            }

            @Override
            public void onItemExitWindow(IntegerWindowItem item, int indexInList) {
                exited.add(item.get());
            }
        };
        windowList = new ScrollingWindowList<>(IntegerWindowItem::new, windowChangeListener);
        windowList.setList(numbers, 5);
        windowList.init();
    }

    @Test
    public void testInitialState() {
        assertEquals(List.of(1, 2, 3, 4, 5), windowList.getWindow().getItems());
        assertEquals(0, windowList.getWindowStart());
        assertEquals(entered, List.of(1, 2, 3, 4, 5));
        assertEquals(exited, List.of());
    }

    // ===================== Basic Functionality =====================

    @Test
    public void testScrollForwardByOne() {
        entered.clear();
        exited.clear();
        windowList.scroll(1);
        assertEquals(1, windowList.getWindowStart());
        assertEquals(List.of(2, 3, 4, 5, 6), windowList.getWindow().getItems());
        assertEquals(entered, List.of(6));
        assertEquals(exited, List.of(1));
    }

    @Test
    public void testScrollBackwardByOne() {
        entered.clear();
        exited.clear();
        // First, scroll forward so we can scroll backward.
        windowList.scroll(5); // windowStart becomes 5; window: [6,7,8,9,10]
        windowList.scroll(-1);
        // Expected new window: start at index 4 -> [5,6,7,8,9]
        assertEquals(4, windowList.getWindowStart());
        assertEquals(List.of(5, 6, 7, 8, 9), windowList.getWindow().getItems());
        assertEquals(List.of(6, 7, 8, 9, 10, 5), entered);
        assertEquals(List.of(1, 2, 3, 4, 5, 10), exited);
    }

    @Test
    public void testScrollForwardLargeOffsetClamped() {
        windowList.scroll(1000);
        assertEquals(95, windowList.getWindowStart());
        List<Integer> expected = new ArrayList<>();
        for (int i = 96; i <= 100; i++) {
            expected.add(i);
        }
        assertEquals(expected, windowList.getWindow().getItems());
    }

    // ===================== Clamped Scrolling =====================

    @Test
    public void testScrollBackwardLargeOffsetClamped() {
        windowList.scroll(10); // Move forward first.
        windowList.scroll(-1000);
        // Should be clamped to 0.
        assertEquals(0, windowList.getWindowStart());
        assertEquals(List.of(1, 2, 3, 4, 5), windowList.getWindow().getItems());
    }

    @Test
    public void testSequentialScrollsWithoutFilter() {
        // Sequentially scroll forward until clamped.
        int totalScroll = 0;
        while (totalScroll < numbers.size() - 5) {
            windowList.scroll(3);
            totalScroll = windowList.getWindowStart();
        }
        assertEquals(95, windowList.getWindowStart());
        // Now scroll backward step-by-step to the beginning.
        while (windowList.getWindowStart() > 0) {
            windowList.scroll(-2);
        }
        assertEquals(0, windowList.getWindowStart());
        assertEquals(List.of(1, 2, 3, 4, 5), windowList.getWindow().getItems());
    }
    // ===================== Generic Type (String) Tests =====================

    public static class IntegerWindowItem extends TestWindowItem<Integer> {
        public IntegerWindowItem(Integer value) {
            super(value);
        }

    }

    public static class StringWindowItem extends TestWindowItem<String> {
        public StringWindowItem(String value) {
            super(value);
        }
    }

    public static class TestWindowItem<T> implements WindowItem<T> {

        protected T value;
        boolean inWindow = false;

        public TestWindowItem(T value) {
            this.value = value;
        }

        @Override
        public T get() {
            return value;
        }

        @Override
        public boolean equals(Object obj) {
            return Objects.equals(this.get(), ((IntegerWindowItem)obj).get());
        }

        @Override
        public VirtualItem<T, WindowItem<T>> getVirtualItem() {
            return null;
        }

        @Override
        public void setVirtualItem(VirtualItem<T, WindowItem<T>> virtualItem) {

        }

        @Override
        public void onSelectionChanged(boolean selection) {

        }
    }
}
