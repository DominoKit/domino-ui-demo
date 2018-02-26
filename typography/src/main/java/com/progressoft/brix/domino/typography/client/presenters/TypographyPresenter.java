package com.progressoft.brix.domino.typography.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;
import com.progressoft.brix.domino.typography.client.views.TypographyView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class TypographyPresenter extends BaseClientPresenter<TypographyView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypographyPresenter.class);

    @InjectContext(extensionPoint=ComponentCaseExtensionPoint.class)
    public void contributeToComponentCaseModule(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "typography";
            }

            @Override
            public String getMenuPath() {
                return "Typography";
            }

            @Override
            public String getIconName() {
                return "text_fields";
            }

            @Override
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}