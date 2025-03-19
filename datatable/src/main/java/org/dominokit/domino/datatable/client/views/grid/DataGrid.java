package org.dominokit.domino.datatable.client.views.grid;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.datatable.client.views.datagrids.ScrollingWindowList;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.Unit;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.dominokit.domino.ui.utils.Domino.div;

public class DataGrid extends BaseDominoElement<HTMLDivElement, DataGrid> {

    private final DivElement viewportRowGroup;
    private final DivElement vscrollViewport;
    private final DivElement hscrollViewport;
    private final DivElement rowsContainer;
    private DivElement root;
    private ScrollingWindowList<Integer, DivWindowItem<Integer>> windowList;
    private double itemHeight = 64.0;
    private int lastSync;
    private double lastScrollTop = 0.0;

    public DataGrid() {
        List<Integer> intList = IntStream.range(0, 500000)
                .boxed()
                .collect(Collectors.toList());
        rowsContainer = div();
//        windowList = new ScrollingWindowList<Integer, DivWindowItem<Integer>>(intList, 10){
//            @Override
//            protected DivWindowItem<Integer> wrap(Integer item) {
//                return new DivWindowItem<>(item, rowsContainer.element(), itemHeight);
//            }
//        };

        this.root = div()
                .addCss(()->"dui-data-grid")
                .appendChild(div()
                        .addCss(()->"dui-data-grid-header")
                        .appendChild(div().addCss(()->"dui-data-grid-header-main"))
                )
                .appendChild(div()
                        .addCss(()->"dui-data-grid-body")
                        .appendChild(div()
                                .addCss(()->"dui-data-grid-body-main")
                                .appendChild(div()
                                        .addCss(()->"dui-data-grid-body-viewport")
                                        .setHeight("500px")
                                        .appendChild(viewportRowGroup = div()
                                                .addCss(()->"dui-data-grid-body-viewport-rowgroup")
                                                .appendChild(rowsContainer
                                                        .addCss(()->"dui-data-grid-body-rows")
                                                        .setWidth("500px")
                                                        .setHeight(Unit.px.of(getTotalHeight()))
                                                )
                                        )
                                        .appendChild(div()
                                                .addCss(()->"dui-data-grid-body-vscroll")
                                                .appendChild(vscrollViewport = div()
                                                        .addCss(()->"dui-data-grid-body-vscroll-viewport")
                                                        .appendChild(div()
                                                                .addCss(()->"dui-data-grid-body-vscroll-container")
                                                                .setHeight(Unit.px.of(getTotalHeight()))
                                                        )
                                                )
                                        )
                                )
                                .appendChild(div()
                                        .addCss(()->"dui-data-grid-body-hscroll")
                                        .appendChild(hscrollViewport = div()
                                                .addCss(()->"dui-data-grid-body-hscroll-viewport")
                                                .appendChild(div().addCss(()->"dui-data-grid-body-hscroll-container")
                                                        .setWidth("500px")
                                                )                                        )
                                )
                        )
                )
                .appendChild(div()
                        .addCss(()->"dui-data-grid-footer")
                        .appendChild(div().addCss(()->"dui-data-grid-footer-main"))
                )
        ;

        viewportRowGroup.addEventListener("scroll", evt -> {
            vscrollViewport.element().scrollTop = viewportRowGroup.element().scrollTop;
        });

        vscrollViewport.addEventListener("scroll", evt -> {
            updateScroll();
        });

        viewportRowGroup.addEventListener("scroll", evt -> {
            hscrollViewport.element().scrollLeft = viewportRowGroup.element().scrollLeft;
        });

        hscrollViewport.addEventListener("scroll", evt -> {
            viewportRowGroup.element().scrollLeft = hscrollViewport.element().scrollLeft;
        });
//        windowList.init();
        init(this);
    }

    private void updateScroll() {
        DomGlobal.cancelAnimationFrame(this.lastSync);
        double scrollTop = vscrollViewport.element().scrollTop;
        viewportRowGroup.element().scrollTop = scrollTop;

        double scrollDelta = scrollTop - lastScrollTop;
        int scrolledItems = Double.valueOf(Math.ceil(scrollTop / itemHeight)).intValue();
        int diffItems = Double.valueOf(Math.ceil(Math.abs(scrollDelta) / itemHeight)).intValue();

        this.lastSync = DomGlobal.requestAnimationFrame(timestamp -> {
            if(diffItems >= windowList.getScrollThreshold()) {
              int offset = scrolledItems - windowList.getWindowStart();
                      DomGlobal.setTimeout(p0 -> {
                    windowList.scroll(offset - windowList.getScrollThreshold());
                lastScrollTop = viewportRowGroup.element().scrollTop;
                });
            }
        });
    }

    private double getTotalHeight() {
        return itemHeight * windowList.getAll().size();
    }

    @Override
    public HTMLDivElement element() {
        return root.element();
    }
}
