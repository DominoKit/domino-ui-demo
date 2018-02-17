package com.progressoft.brix.domino.alerts.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.alerts.client.views.AlertsView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultAlertsPresenter extends BaseClientPresenter<AlertsView> implements AlertsPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultAlertsPresenter.class);

    @Override
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/alerts";
            }

            @Override
            public String getMenuPath() {
                return "Components/Alerts";
            }

            @Override
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}