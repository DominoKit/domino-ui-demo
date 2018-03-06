package com.progressoft.brix.domino.tabs.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.components.shared.extension.ComponentsExtensionPoint;
import com.progressoft.brix.domino.tabs.client.views.TabsView;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class TabsPresenter extends BaseClientPresenter<TabsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TabsPresenter.class);

    @InjectContext(extensionPoint=ComponentsExtensionPoint.class)
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/tabs";
            }

            @Override
            public String getMenuPath() {
                return "Components/Tabs";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}