package org.dominokit.domino.splitPanel.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.layouts.shared.extension.LayoutsEvent;
import org.dominokit.domino.layouts.shared.extension.LayoutsEventContext;
import org.dominokit.domino.splitPanel.client.views.SplitPanelView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class SplitPanelPresenter extends ViewBaseClientPresenter<SplitPanelView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SplitPanelPresenter.class);

    @ListenTo(event=LayoutsEvent.class)
    public void listenToMainEvent(LayoutsEventContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "split-panel";
            }

            @Override
            public String getMenuPath() {
                return "Layout/Split panel";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}