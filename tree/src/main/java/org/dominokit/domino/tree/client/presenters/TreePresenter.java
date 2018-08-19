package org.dominokit.domino.tree.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsEvent;
import org.dominokit.domino.tree.client.views.TreeView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class TreePresenter extends ViewBaseClientPresenter<TreeView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TreePresenter.class);

    @ListenTo(event=ComponentsEvent.class)
    public void listenToComponentsEvent(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "tree";
            }

            @Override
            public String getMenuPath() {
                return "Components/Tree";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}