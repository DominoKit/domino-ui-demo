package com.progressoft.brix.domino.infobox.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.infobox.client.views.InfoBoxView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultInfoBoxPresenter extends BaseClientPresenter<InfoBoxView> implements InfoBoxPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultInfoBoxPresenter.class);

    @Override
    public void contributeToComponentModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/infobox";
            }

            @Override
            public String getMenuPath() {
                return "Components/Info box";
            }

            @Override
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}
