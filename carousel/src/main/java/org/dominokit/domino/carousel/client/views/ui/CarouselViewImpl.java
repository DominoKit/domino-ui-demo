package org.dominokit.domino.carousel.client.views.ui;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.carousel.client.presenters.CarouselProxy;
import org.dominokit.domino.carousel.client.views.CarouselView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.carousel.Carousel;
import org.dominokit.domino.ui.carousel.Slide;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = CarouselProxy.class)
@SampleClass
public class CarouselViewImpl extends BaseDemoView<HTMLDivElement> implements CarouselView {

    private HTMLDivElement element = div().element();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.create("carousel", this.getClass()).element());
        element.appendChild(BlockHeader.create("CAROUSEL").element());

        basicSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicSample()).element());

        return element;
    }

    @SampleMethod
    private void basicSample() {
        element.appendChild(Row.create()
                .addColumn(Column.span6().appendChild(
                        Card.create()
                                .appendChild(Carousel.create()
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/11.jpg"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/12.jpg"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/19.jpg"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/9.jpg"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/6.jpg"))
                                )
                ))
                .addColumn(Column.span6().appendChild(
                        Card.create()
                                .appendChild(Carousel.create()
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/11.jpg", "Slide 1", "First slide description"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/12.jpg", "Slide 2", "Second slide description"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/19.jpg", "Slide 3", "Third slide description"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/9.jpg", "Slide 4", "Fourth slide description"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/6.jpg", "Slide 5", "Fifth slide description"))
                                        .startAutoSlide(3000)
                                )
                        )
                ).element());
    }
}