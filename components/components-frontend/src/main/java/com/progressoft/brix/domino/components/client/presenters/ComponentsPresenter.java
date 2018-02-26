package com.progressoft.brix.domino.components.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;
import com.progressoft.brix.domino.components.client.views.ComponentsView;
import com.progressoft.brix.domino.components.shared.extension.ComponentsExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class ComponentsPresenter extends BaseClientPresenter<ComponentsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentsPresenter.class);

    @InjectContext(extensionPoint=ComponentCaseExtensionPoint.class)
    public void contributeToDemoPageModule(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "";
            }

            @Override
            public String getMenuPath() {
                return "Components";
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public String getIconName() {
                return "widgets";
            }
        });

        applyContributions(ComponentsExtensionPoint.class, () -> () -> context);

    }
}