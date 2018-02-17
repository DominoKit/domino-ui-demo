package com.progressoft.brix.domino.badges.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.badges.client.views.BadgesView;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultBadgesPresenter extends BaseClientPresenter<BadgesView> implements BadgesPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultBadgesPresenter.class);

    @Override
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/badges";
            }

            @Override
            public String getMenuPath() {
                return "Components/Badges";
            }

            @Override
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}