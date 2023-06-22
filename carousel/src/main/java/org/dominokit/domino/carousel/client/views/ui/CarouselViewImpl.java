package org.dominokit.domino.carousel.client.views.ui;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.carousel.client.presenters.CarouselProxy;
import org.dominokit.domino.carousel.client.views.CarouselView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.carousel.Carousel;
import org.dominokit.domino.ui.carousel.Slide;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = CarouselProxy.class)
@SampleClass
public class CarouselViewImpl extends BaseDemoView<HTMLDivElement> implements CarouselView {

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.createLink("carousel", this.getClass()).element());
        element.appendChild(BlockHeader.create("CAROUSEL").element());

        basicSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicSample()).element());

        return element.element();
    }

    @SampleMethod
    private void basicSample() {
        element.appendChild(Row.create()
                .appendChild(Column.span6().appendChild(
                        Card.create()
                                .appendChild(Carousel.create()
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/11.jpg"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/12.jpg"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/19.jpg"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/9.jpg"))
                                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/image-gallery/6.jpg"))
                                )
                ))
                .appendChild(Column.span6()
                        .appendChild(Card.create()
                                .appendChild(Carousel.create()
                                        .appendChild(Slide.create(img(GWT.getModuleBaseURL() + "/images/image-gallery/11.jpg"))
                                                .setLabel("Slide 1")
                                                .setDescription("First slide description")
                                        )
                                        .appendChild(Slide.create(img(GWT.getModuleBaseURL() + "/images/image-gallery/12.jpg"))
                                                .setLabel("Slide 2")
                                                .setDescription("Second slide description")
                                        )
                                        .appendChild(Slide.create(img(GWT.getModuleBaseURL() + "/images/image-gallery/19.jpg"))
                                                .setLabel("Slide 3")
                                                .setDescription("Third slide description")
                                        )
                                        .appendChild(Slide.create(img(GWT.getModuleBaseURL() + "/images/image-gallery/9.jpg"))
                                                .setLabel("Slide 4")
                                                .setDescription("Fourth slide description")
                                        )
                                        .appendChild(Slide.create(img(GWT.getModuleBaseURL() + "/images/image-gallery/6.jpg"))
                                                .setLabel("Slide 5")
                                                .setDescription("Fifth slide description")
                                        )
                                        .startAutoSlide(3000)
                                )
                        )
                )
        );
    }
}