package com.progressoft.brix.domino.home.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;
import com.progressoft.brix.domino.home.client.views.HomeView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class HomePresenter extends BaseClientPresenter<HomeView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePresenter.class);

    @InjectContext(extensionPoint=ComponentCaseExtensionPoint.class)
    public void contributeToDemoPageModule(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
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
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}