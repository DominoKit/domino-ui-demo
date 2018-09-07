package org.dominokit.domino.grids.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.grids.client.views.GridsView;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.domino.api.shared.extension.MainEventContext;
import org.dominokit.domino.layouts.shared.extension.LayoutsEvent;
import org.dominokit.domino.layouts.shared.extension.LayoutsEventContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class GridsPresenter extends ViewBaseClientPresenter<GridsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GridsPresenter.class);

    @ListenTo(event=LayoutsEvent.class)
    public void listenToLayoutsEvent(LayoutsEventContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "grids";
            }

            @Override
            public String getMenuPath() {
                return "Layout/Grids";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}