package com.progressoft.brix.domino.loaders.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.loaders.client.views.LoadersView;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultLoadersPresenter extends BaseClientPresenter<LoadersView> implements LoadersPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultLoadersPresenter.class);

    @Override
    public void contributeToComponentsModule(ComponentsContext context) {
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
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}