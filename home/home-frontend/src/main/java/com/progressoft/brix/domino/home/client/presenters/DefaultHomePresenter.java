package com.progressoft.brix.domino.home.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;
import com.progressoft.brix.domino.home.client.views.HomeView;
import com.progressoft.brix.domino.home.shared.extension.HomeContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultHomePresenter extends BaseClientPresenter<HomeView> implements HomePresenter, HomeContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultHomePresenter.class);

    @Override
    public void contributeToDemoPageModule(ComponentCaseContext context) {
        context.addDemoPage(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "home";
            }

            @Override
            public String getMenuPath() {
                return "Home";
            }

            @Override
            public String getIconName() {
                return "home";
            }

            @Override
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}