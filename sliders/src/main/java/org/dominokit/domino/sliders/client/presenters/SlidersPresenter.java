package org.dominokit.domino.sliders.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsEvent;
import org.dominokit.domino.sliders.client.views.SlidersView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class SlidersPresenter extends ViewBaseClientPresenter<SlidersView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SlidersPresenter.class);

    @ListenTo(event = ComponentsEvent.class)
    public void onComponentsEvent(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/sliders";
            }

            @Override
            public String getMenuPath() {
                return "Components/Sliders";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}