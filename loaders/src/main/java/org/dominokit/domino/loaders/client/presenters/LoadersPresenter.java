package org.dominokit.domino.loaders.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsEvent;
import org.dominokit.domino.loaders.client.views.LoadersView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class LoadersPresenter extends ViewBaseClientPresenter<LoadersView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoadersPresenter.class);

    @ListenTo(event=ComponentsEvent.class)
    public void onComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/loaders";
            }

            @Override
            public String getMenuPath() {
                return "Components/Loaders";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}