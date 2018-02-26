package com.progressoft.brix.domino.icons.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.components.shared.extension.ComponentsExtensionPoint;
import com.progressoft.brix.domino.icons.client.views.IconsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class IconsPresenter extends BaseClientPresenter<IconsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(IconsPresenter.class);

    @InjectContext(extensionPoint=ComponentsExtensionPoint.class)
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/icons";
            }

            @Override
            public String getMenuPath() {
                return "Components/Icons";
            }

            @Override
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}