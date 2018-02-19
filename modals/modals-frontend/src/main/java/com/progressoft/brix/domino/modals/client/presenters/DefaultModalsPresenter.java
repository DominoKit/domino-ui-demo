package com.progressoft.brix.domino.modals.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.modals.client.views.ModalsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultModalsPresenter extends BaseClientPresenter<ModalsView> implements ModalsPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultModalsPresenter.class);

    @Override
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/modals";
            }

            @Override
            public String getMenuPath() {
                return "Components/Modals";
            }

            @Override
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}