package org.dominokit.domino.gridLayout.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.gridLayout.client.views.GridLayoutView;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.domino.api.shared.extension.MainEventContext;
import org.dominokit.domino.layouts.shared.extension.LayoutsEvent;
import org.dominokit.domino.layouts.shared.extension.LayoutsEventContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class GridLayoutPresenter extends ViewBaseClientPresenter<GridLayoutView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(GridLayoutPresenter.class);

    @ListenTo(event=LayoutsEvent.class)
    public void listenToLayoutsEvent(LayoutsEventContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "grid-layout";
            }

            @Override
            public String getMenuPath() {
                return "Layout/Grid layout";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}