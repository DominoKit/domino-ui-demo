package org.dominokit.domino.pagination.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsExtensionPoint;
import org.dominokit.domino.pagination.client.views.PaginationView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class PaginationPresenter extends ViewBaseClientPresenter<PaginationView> {

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