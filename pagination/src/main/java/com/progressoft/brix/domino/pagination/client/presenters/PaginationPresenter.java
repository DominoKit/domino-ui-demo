package com.progressoft.brix.domino.pagination.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.components.shared.extension.ComponentsExtensionPoint;
import com.progressoft.brix.domino.pagination.client.views.PaginationView;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class PaginationPresenter extends BaseClientPresenter<PaginationView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PaginationPresenter.class);

    @InjectContext(extensionPoint=ComponentsExtensionPoint.class)
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/pagination";
            }

            @Override
            public String getMenuPath() {
                return "Components/Pagination";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}