package org.dominokit.domino.applayout.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.applayout.client.views.AppLayoutView;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.layouts.shared.extension.LayoutsEvent;
import org.dominokit.domino.layouts.shared.extension.LayoutsEventContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class AppLayoutPresenter extends ViewBaseClientPresenter<AppLayoutView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AppLayoutPresenter.class);

    @ListenTo(event=LayoutsEvent.class)
    public void listenToLayoutsEvent(LayoutsEventContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "app-layout";
            }

            @Override
            public String getMenuPath() {
                return "Layout/App Layout";
            }

            @Override
            public String getIconName() {
                return "view_quilt";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}