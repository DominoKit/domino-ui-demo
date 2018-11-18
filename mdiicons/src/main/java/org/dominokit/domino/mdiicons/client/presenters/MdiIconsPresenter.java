package org.dominokit.domino.mdiicons.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseEvent;
import org.dominokit.domino.mdiicons.client.views.MdiIconsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class MdiIconsPresenter extends ViewBaseClientPresenter<MdiIconsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MdiIconsPresenter.class);

    @ListenTo(event=ComponentCaseEvent.class)
    public void listenToComponentsCaseEvent(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "mdiicons";
            }

            @Override
            public String getIconName() {
                return "local_florist";
            }

            @Override
            public String getMenuPath() {
                return "MDI Icons";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}