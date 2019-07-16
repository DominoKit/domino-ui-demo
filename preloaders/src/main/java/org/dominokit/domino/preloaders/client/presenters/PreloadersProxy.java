package org.dominokit.domino.preloaders.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.preloaders.client.views.PreloadersView;

@PresenterProxy
@AutoRoute(token = "components/preloaders")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class PreloadersProxy extends ComponentCasePresenter<PreloadersView> {
}