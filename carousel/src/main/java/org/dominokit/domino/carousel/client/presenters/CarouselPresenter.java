package org.dominokit.domino.carousel.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.carousel.client.views.CarouselView;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class CarouselPresenter extends ViewBaseClientPresenter<CarouselView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarouselPresenter.class);

    @ListenTo(event=ComponentsEvent.class)
    public void listenToCompnentCaseEvent(ComponentsContext context) {
        LOGGER.info("Main context received at presenter " + CarouselPresenter.class.getSimpleName());
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "carousel";
            }

            @Override
            public String getMenuPath() {
                return "Components/Carousel";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}