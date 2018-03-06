package com.progressoft.brix.domino.helpers.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;
import com.progressoft.brix.domino.helpers.client.views.HelpersView;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class HelpersPresenter extends BaseClientPresenter<HelpersView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelpersPresenter.class);

    @InjectContext(extensionPoint=ComponentCaseExtensionPoint.class)
    public void contributeToComponentCaseModule(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "helpers";
            }

            @Override
            public String getMenuPath() {
                return "Helper classes";
            }

            @Override
            public String getIconName() {
                return "layers";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}