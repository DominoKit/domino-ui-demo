package org.dominokit.domino.pagination.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.pagination.client.presenters.PaginationProxy;
import org.dominokit.domino.pagination.client.views.PaginationView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.pagination.AdvancedPagination;
import org.dominokit.domino.ui.pagination.Pager;
import org.dominokit.domino.ui.pagination.ScrollingPagination;
import org.dominokit.domino.ui.pagination.SimplePagination;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.gwt.elemento.core.Elements.b;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = PaginationProxy.class)
@SampleClass
public class PaginationViewImpl extends BaseDemoView<HTMLDivElement> implements PaginationView {

    private HTMLDivElement element = div().asElement();

    @Override
    protected void init(HTMLDivElement root) {
        element.appendChild(LinkToSourceCode.create("pagination", this.getClass()).asElement());
        element.appendChild(BlockHeader.create("PAGINATION").asElement());


        defaultPagination();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.defaultPagination()).asElement());

        activePageSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.activePageSample()).asElement());

        sizesSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sizesSample()).asElement());

        initScrollerPagination();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initScrollerPagination()).asElement());

        initAdvancedPagination();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initAdvancedPagination()).asElement());

        element.appendChild(BlockHeader.create("PAGER").asElement());
        pagerNexPrevSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.pagerNexPrevSample()).asElement());
    }

    @Override
    public HTMLDivElement createRoot() {
        element = div().asElement();
        return element;
    }

    @SampleMethod
    private void defaultPagination() {
        element.appendChild(Card.create("DEFAULT PAGINATION",
                "Simple pagination inspired by Rdio, great for apps and search results. The large block is hard to miss, easily scalable, and provides large click areas.")
                .appendChild(SimplePagination.create(5)
                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber+"")))
                .asElement());

    }

    @SampleMethod
    private void activePageSample() {
        element.appendChild(Card.create("ACTIVE PAGE", "You can mark the current active page.")
                .appendChild(SimplePagination.create(5)
                        .markActivePage()
                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber+""))
                        .gotoPage(3))
                .asElement());


    }

    @SampleMethod
    private void sizesSample() {

        element.appendChild(Card.create("PAGINATION SIZE", "There is three sizes for pagination")
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .appendChild(b().textContent("Large"))
                                .appendChild(SimplePagination.create(5)
                                        .markActivePage()
                                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber + ""))
                                        .gotoPage(3)
                                        .large()))
                        .addColumn(Column.span4()
                                .appendChild(b().textContent("Default"))
                                .appendChild(SimplePagination.create(5)
                                        .markActivePage()
                                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber + ""))
                                        .gotoPage(3)))
                        .addColumn(Column.span4()
                                .appendChild(b().textContent("Small"))
                                .appendChild(SimplePagination.create(5)
                                        .markActivePage()
                                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber+""))
                                        .gotoPage(3)
                                        .small()))
                        .asElement())
                .asElement());


    }

    @SampleMethod
    private void initScrollerPagination() {
        element.appendChild(Card.create("SCROLLING PAGINATION", "For large number of pages scrolling pagiation allow viewing a set of pages at a time.")
                .appendChild(ScrollingPagination.create(50, 10, 5)
                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber + "")))
                .asElement());


    }

    @SampleMethod
    private void initAdvancedPagination() {
        element.appendChild(Card.create("ADVANCED PAGINATION", "Old style pagination with advanced page select.")
                .appendChild(AdvancedPagination.create(50, 10)
                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber + "")))
                .asElement());


    }

    @SampleMethod
    private void pagerNexPrevSample() {
        element.appendChild(Card.create("DEFAULT PAGER", "By default, the pager centers links.")
                .appendChild(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page.")))
                .appendChild(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .nextText("Newer")
                        .previousText("Older")
                        .showArrows())
                .asElement());

        element.appendChild(Card.create("PAGER ALIGNED TO EDGES", "Use expand to align the pager to the edges.")
                .appendChild(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .nextText("Newer")
                        .previousText("Older")
                        .showArrows()
                        .show())
                .asElement());


        element.appendChild(Card.create("PAGER WITH DISABLED LINK", "You can Disable/Enable pager links.")
                .appendChild(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .nextText("Newer")
                        .previousText("Older")
                        .showArrows()
                        .show()
                        .disablePrevious())
                .asElement());



    }
}