package org.dominokit.domino.popover.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.popover.client.views.PopoverView;

@PresenterProxy
@AutoRoute(token = "components/tooltips-popover")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class PopoverProxy extends ComponentCasePresenter<PopoverView> {
}