package org.dominokit.domino.carousel.client.views.ui;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.carousel.client.presenters.CarouselPresenter;
import org.dominokit.domino.carousel.client.views.CarouselView;
import org.dominokit.domino.carousel.client.views.CodeResource;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.carousel.Carousel;
import org.dominokit.domino.ui.carousel.Slide;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.row.Row;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = CarouselPresenter.class)
public class CarouselViewImpl extends ComponentView<HTMLDivElement> implements CarouselView {

    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("CAROUSEL").asElement());

        element.appendChild(Row.create()
                .addColumn(Column.span6().addElement(
                        Card.create()
                                .appendChild(Carousel.create()
                                        .addSlide(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/11.jpg"))
                                        .addSlide(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/12.jpg"))
                                        .addSlide(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/19.jpg"))
                                        .addSlide(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/9.jpg"))
                                        .addSlide(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/6.jpg"))
                                )
                        ))
                .addColumn(Column.span6().addElement(
                        Card.create()
                                .appendChild(Carousel.create()
                                        .addSlide(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/11.jpg", "Slide 1", "First slide description"))
                                        .addSlide(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/12.jpg", "Slide 2", "Second slide description"))
                                        .addSlide(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/19.jpg", "Slide 3", "Third slide description"))
                                        .addSlide(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/9.jpg", "Slide 4", "Fourth slide description"))
                                        .addSlide(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/6.jpg", "Slide 5", "Fifth slide description"))
                                        .startAutoSlide(3000)
                                )
                        )
                ).asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.carousel()).asElement());

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}