package org.dominokit.domino.steppers.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.steppers.client.views.SteppersView;

@PresenterProxy
@AutoRoute(token = "forms/steppers")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class SteppersProxy extends ComponentCasePresenter<SteppersView> {
}