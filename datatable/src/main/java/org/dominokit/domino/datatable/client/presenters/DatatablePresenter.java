package org.dominokit.domino.datatable.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseEvent;
import org.dominokit.domino.datatable.client.views.DatatableView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DatatablePresenter extends ViewBaseClientPresenter<DatatableView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatatablePresenter.class);

    @ListenTo(event=ComponentCaseEvent.class)
    public void onComponentCaseEvent(ComponentCaseContext context) {

        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "datatable";
            }

            @Override
            public String getIconName() {
                return "view_list";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }

            @Override
            public String getMenuPath() {
                return "Data table";
            }
        });
    }
}