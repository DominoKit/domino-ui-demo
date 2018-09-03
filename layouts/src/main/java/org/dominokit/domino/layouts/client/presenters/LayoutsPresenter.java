package org.dominokit.domino.layouts.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseEvent;
import org.dominokit.domino.layouts.shared.extension.LayoutsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class LayoutsPresenter extends BaseClientPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(LayoutsPresenter.class);

    @ListenTo(event=ComponentCaseEvent.class)
    public void listenToCompnentCaseEvent(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "";
            }

            @Override
            public String getMenuPath() {
                return "Layout";
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public String getIconName() {
                return "dashboard";
            }
        });

        fireEvent(LayoutsEvent.class, () -> () -> context);

    }
}