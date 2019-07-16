package org.dominokit.domino.modals.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.modals.client.views.ModalsView;

@PresenterProxy
@AutoRoute(token = "components/modals")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class ModalsProxy extends ComponentCasePresenter<ModalsView> {

    @OnRemove
    public void cleanUp() {
        view.cleanup();
    }
}