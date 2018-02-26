package com.progressoft.brix.domino.breadcrumb.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.breadcrumb.client.views.BreadcrumbView;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.components.shared.extension.ComponentsExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class BreadcrumbPresenter extends BaseClientPresenter<BreadcrumbView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BreadcrumbPresenter.class);

    @InjectContext(extensionPoint=ComponentsExtensionPoint.class)
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/breadcrumbs";
            }

            @Override
            public String getMenuPath() {
                return "Components/Breadcrumbs";
            }

            @Override
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}