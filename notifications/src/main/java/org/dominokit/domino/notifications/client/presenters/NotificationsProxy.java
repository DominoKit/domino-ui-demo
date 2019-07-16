package org.dominokit.domino.notifications.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.notifications.client.views.NotificationsView;

@PresenterProxy
@AutoRoute(token = "components/notifications")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class NotificationsProxy extends ComponentCasePresenter<NotificationsView> {
}