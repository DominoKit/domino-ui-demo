package org.dominokit.domino.components.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseEvent;
import org.dominokit.domino.components.shared.extension.ComponentsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class ComponentsPresenter extends BaseClientPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentsPresenter.class);

    @ListenTo(event=ComponentCaseEvent.class)
    public void onDemoPageEvent(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "";
            }

            @Override
            public String getMenuPath() {
                return "Components";
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public String getIconName() {
                return "widgets";
            }
        });

        fireEvent(ComponentsEvent.class, () -> () -> context);

    }
}