package org.dominokit.domino.flexlayout.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.flexlayout.client.views.FlexLayoutView;
import org.dominokit.domino.layouts.shared.extension.LayoutsEvent;
import org.dominokit.domino.layouts.shared.extension.LayoutsEventContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class FlexLayoutPresenter extends ViewBaseClientPresenter<FlexLayoutView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FlexLayoutPresenter.class);

    @ListenTo(event = LayoutsEvent.class)
    public void listenToLayoutsEvent(LayoutsEventContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "flex-layout";
            }

            @Override
            public String getMenuPath() {
                return "Layout/Flex Layout";
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