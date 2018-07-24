package org.dominokit.domino.lists.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsEvent;
import org.dominokit.domino.lists.client.views.ListsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class ListsPresenter extends ViewBaseClientPresenter<ListsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListsPresenter.class);

    @ListenTo(event=ComponentsEvent.class)
    public void contributeComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/lists";
            }

            @Override
            public String getMenuPath() {
                return "Components/Lists";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}