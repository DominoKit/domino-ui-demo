package org.dominokit.domino.notifications.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsEvent;
import org.dominokit.domino.notifications.client.views.NotificationsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class NotificationsPresenter extends ViewBaseClientPresenter<NotificationsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsPresenter.class);

    @ListenTo(event=ComponentsEvent.class)
    public void onComponentCaseEvent(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "notifications";
            }

            @Override
            public String getMenuPath() {
                return "Components/Notifications";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}