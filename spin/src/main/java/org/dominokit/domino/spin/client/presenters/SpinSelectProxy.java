package org.dominokit.domino.spin.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.spin.client.views.SpinSelectView;

@PresenterProxy
@AutoRoute(token = "components/spin")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class SpinSelectProxy extends ComponentCasePresenter<SpinSelectView> {
}