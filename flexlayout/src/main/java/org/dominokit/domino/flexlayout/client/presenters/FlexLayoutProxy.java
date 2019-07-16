package org.dominokit.domino.flexlayout.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.flexlayout.client.views.FlexLayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;

@PresenterProxy
@AutoRoute(token = "layout/flex-layout")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup({LayoutEvent.class}))
public class FlexLayoutProxy extends ComponentCasePresenter<FlexLayoutView> {
}