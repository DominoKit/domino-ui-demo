package com.progressoft.brix.domino.lists.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.components.shared.extension.ComponentsExtensionPoint;
import com.progressoft.brix.domino.lists.client.views.ListsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class ListsPresenter extends BaseClientPresenter<ListsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ListsPresenter.class);

    @InjectContext(extensionPoint=ComponentsExtensionPoint.class)
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