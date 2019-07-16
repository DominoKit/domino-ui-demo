package org.dominokit.domino.loaders.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.loaders.client.views.LoadersView;

@PresenterProxy
@AutoRoute(token = "components/loaders")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class LoadersProxy extends ComponentCasePresenter<LoadersView> {
}