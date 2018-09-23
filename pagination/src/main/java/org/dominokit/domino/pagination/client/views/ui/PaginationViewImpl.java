package org.dominokit.domino.pagination.client.views.ui;

import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.pagination.client.views.CodeResource;
import org.dominokit.domino.pagination.client.views.PaginationView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.pagination.client.presenters.PaginationPresenter;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.pagination.Pager;
import org.dominokit.domino.ui.pagination.SimplePagination;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.b;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = PaginationPresenter.class)
public class PaginationViewImpl extends ComponentView<HTMLDivElement> implements PaginationView {

    private HTMLDivElement element = div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(LinkToSourceCode.create("pagination", this.getClass()).asElement());
        element.appendChild(BlockHeader.create("PAGINATION").asElement());

        defaultPagination();
        activePageSample();
        sizesSample();
        element.appendChild(BlockHeader.create("PAGER").asElement());
        pagerNexPrevSample();

    }

    private void defaultPagination() {
        element.appendChild(Card.create("DEFAULT PAGINATION",
                "Simple pagination inspired by Rdio, great for apps and search results. The large block is hard to miss, easily scalable, and provides large click areas.")
                .appendChild(SimplePagination.create(5)
                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber+"")))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.defaultPagination()).asElement());
    }

    private void activePageSample() {
        element.appendChild(Card.create("ACTIVE PAGE", "You can mark the current active page.")
                .appendChild(SimplePagination.create(5)
                        .markActivePage()
                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber+""))
                        .gotoPage(3))
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.activePageSample()).asElement());
    }

    private void sizesSample() {

        element.appendChild(Card.create("ACTIVE PAGE", "You can mark the current active page.")
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .appendChild(b().textContent("Large"))
                                .appendChild(SimplePagination.create(5)
                                        .markActivePage()
                                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber+""))
                                        .gotoPage(3)
                                        .large()))
                        .addColumn(Column.span4()
                                .appendChild(b().textContent("Default"))
                                .appendChild(SimplePagination.create(5)
                                        .markActivePage()
                                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber+""))
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

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sizesSample()).asElement());
    }

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
                        .expand())
                .asElement());


        element.appendChild(Card.create("PAGER WITH DISABLED LINK", "You can Disable/Enable pager links.")
                .appendChild(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .nextText("Newer")
                        .previousText("Older")
                        .showArrows()
                        .expand()
                        .disablePrevious())
                .asElement());

        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.pagerSample()).asElement());

    }
}