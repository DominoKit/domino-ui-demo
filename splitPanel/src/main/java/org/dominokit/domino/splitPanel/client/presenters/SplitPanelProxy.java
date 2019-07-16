package org.dominokit.domino.splitPanel.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.splitPanel.client.views.SplitPanelView;

@PresenterProxy
@AutoRoute(token = "layout/split-panel")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class SplitPanelProxy extends ComponentCasePresenter<SplitPanelView> {
}