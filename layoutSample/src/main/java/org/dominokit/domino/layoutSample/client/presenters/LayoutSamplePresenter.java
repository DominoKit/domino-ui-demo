package org.dominokit.domino.layoutSample.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseEvent;
import org.dominokit.domino.layoutSample.client.views.LayoutSampleView;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.domino.api.shared.extension.MainEventContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class LayoutSamplePresenter extends ViewBaseClientPresenter<LayoutSampleView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LayoutSamplePresenter.class);

    @ListenTo(event=ComponentCaseEvent.class)
    public void listenToComponentCaseEvent(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "layout";
            }

            @Override
            public String getMenuPath() {
                return "Layout";
            }

            @Override
            public String getIconName() {
                return "view_quilt";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}