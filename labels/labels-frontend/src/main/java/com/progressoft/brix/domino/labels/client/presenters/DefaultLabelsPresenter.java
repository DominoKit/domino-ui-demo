package com.progressoft.brix.domino.labels.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.labels.client.views.LabelsView;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultLabelsPresenter extends BaseClientPresenter<LabelsView> implements LabelsPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultLabelsPresenter.class);

    @Override
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/labels";
            }

            @Override
            public String getMenuPath() {
                return "Components/Labels";
            }

            @Override
            public void showIn(Content content) {
                view.showIn(content);
            }
        });
    }
}