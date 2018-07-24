package org.dominokit.domino.labels.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsEvent;
import org.dominokit.domino.labels.client.views.LabelsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class LabelsPresenter extends ViewBaseClientPresenter<LabelsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LabelsPresenter.class);

    @ListenTo(event = ComponentsEvent.class)
    public void onComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/labels";
            }

            @Override
            public String getMenuPath() {
                return "Components/Labels";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}