package org.dominokit.domino.carousel.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.carousel.client.presenters.CarouselPresenter;
import org.dominokit.domino.carousel.client.views.CarouselView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.carousel.Carousel;
import org.dominokit.domino.ui.carousel.Slide;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = CarouselPresenter.class)
public class CarouselViewImpl extends ComponentView<HTMLDivElement> implements CarouselView {

    public static final String MODULE_NAME = "carousel";
    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(LinkToSourceCode.create(MODULE_NAME, this.getClass()).asElement());
        element.appendChild(BlockHeader.create("CAROUSEL").asElement());

        element.appendChild(Row.create()
                .addColumn(Column.span6().appendChild(
                        Card.create()
                                .appendChild(Carousel.create()
                                        .appendChild(Slide.create("static/images/image-gallery/11.jpg"))
                                        .appendChild(Slide.create("static/images/image-gallery/12.jpg"))
                                        .appendChild(Slide.create("static/images/image-gallery/19.jpg"))
                                        .appendChild(Slide.create("static/images/image-gallery/9.jpg"))
                                        .appendChild(Slide.create("static/images/image-gallery/6.jpg"))
                                )
                        ))
                .addColumn(Column.span6().appendChild(
                        Card.create()
                                .appendChild(Carousel.create()
                                        .appendChild(Slide.create("static/images/image-gallery/11.jpg", "Slide 1", "First slide description"))
                                        .appendChild(Slide.create("static/images/image-gallery/12.jpg", "Slide 2", "Second slide description"))
                                        .appendChild(Slide.create("static/images/image-gallery/19.jpg", "Slide 3", "Third slide description"))
                                        .appendChild(Slide.create("static/images/image-gallery/9.jpg", "Slide 4", "Fourth slide description"))
                                        .appendChild(Slide.create("static/images/image-gallery/6.jpg", "Slide 5", "Fifth slide description"))
                                        .startAutoSlide(3000)
                                )
                        )
                ).asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"carousel").asElement());

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}