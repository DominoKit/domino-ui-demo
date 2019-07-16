package org.dominokit.domino.thumbnails.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.thumbnails.client.views.ThumbnailsView;

@PresenterProxy
@AutoRoute(token = "components/thumbnails")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class ThumbnailsProxy extends ComponentCasePresenter<ThumbnailsView> {
}