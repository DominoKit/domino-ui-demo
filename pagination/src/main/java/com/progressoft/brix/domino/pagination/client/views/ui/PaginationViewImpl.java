package com.progressoft.brix.domino.pagination.client.views.ui;

import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.pagination.client.views.CodeResource;
import com.progressoft.brix.domino.pagination.client.views.PaginationView;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.pagination.client.presenters.PaginationPresenter;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.column.Column;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.pagination.Pager;
import com.progressoft.brix.domino.ui.pagination.Pagination;
import com.progressoft.brix.domino.ui.row.Row;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.b;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = PaginationPresenter.class)
public class PaginationViewImpl implements PaginationView {

    private HTMLDivElement element = div().asElement();

    public PaginationViewImpl() {
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
                .appendContent(Pagination.create(5)
                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.defaultPagination()).asElement());
    }

    private void activePageSample() {
        element.appendChild(Card.create("ACTIVE PAGE", "You can mark the current active page.")
                .appendContent(Pagination.create(5)
                        .markActivePage()
                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber))
                        .setActivePage(3)
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.activePageSample()).asElement());
    }

    private void sizesSample() {

        Column column = Column.create()
                .onLarge(Column.OnLarge.four)
                .onMedium(Column.OnMedium.four)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);


        element.appendChild(Card.create("ACTIVE PAGE", "You can mark the current active page.")
                .appendContent(Row.create()
                        .addColumn(column.copy()
                                .addElement(b().textContent("Large").asElement())
                                .addElement(Pagination.create(5)
                                        .markActivePage()
                                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber))
                                        .setActivePage(3)
                                        .large()
                                        .asElement()))
                        .addColumn(column.copy()
                                .addElement(b().textContent("Default").asElement())
                                .addElement(Pagination.create(5)
                                        .markActivePage()
                                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber))
                                        .setActivePage(3)
                                        .asElement()))
                        .addColumn(column.copy()
                                .addElement(b().textContent("Small").asElement())
                                .addElement(Pagination.create(5)
                                        .markActivePage()
                                        .onPageChanged(pageNumber -> DomGlobal.console.info(pageNumber))
                                        .setActivePage(3)
                                        .small()
                                        .asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.sizesSample()).asElement());
    }

    private void pagerNexPrevSample() {
        element.appendChild(Card.create("DEFAULT PAGER", "By default, the pager centers links.")
                .appendContent(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .asElement())
                .appendContent(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .nextText("Newer")
                        .previousText("Older")
                        .showArrows()
                        .asElement())
                .asElement());

        element.appendChild(Card.create("PAGER ALIGNED TO EDGES", "Use expand to align the pager to the edges.")
                .appendContent(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .nextText("Newer")
                        .previousText("Older")
                        .showArrows()
                        .expand()
                        .asElement())
                .asElement());


        element.appendChild(Card.create("PAGER WITH DISABLED LINK", "You can Disable/Enable pager links.")
                .appendContent(Pager.create()
                        .onNext(() -> DomGlobal.console.info("Going to next page."))
                        .onPrevious(() -> DomGlobal.console.info("Going to previous page."))
                        .nextText("Newer")
                        .previousText("Older")
                        .showArrows()
                        .expand()
                        .disablePrevious()
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.pagerSample()).asElement());

    }

    @Override
    public void showIn(Content content) {
        HTMLDivElement contentPanel = Js.cast(content.get());
        contentPanel.appendChild(element);
    }
}