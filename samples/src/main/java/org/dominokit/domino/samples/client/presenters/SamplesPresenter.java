package org.dominokit.domino.samples.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseEvent;
import org.dominokit.domino.samples.client.views.SamplesView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class SamplesPresenter extends ViewBaseClientPresenter<SamplesView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SamplesPresenter.class);

    @ListenTo(event=ComponentCaseEvent.class)
    public void listenToComponentCaseEvent(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "samples";
            }

            @Override
            public String getIconName() {
                return "pages";
            }

            @Override
            public String getMenuPath() {
                return "Samples";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}