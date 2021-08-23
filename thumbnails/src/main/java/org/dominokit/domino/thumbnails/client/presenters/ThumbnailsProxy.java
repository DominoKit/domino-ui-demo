package org.dominokit.domino.thumbnails.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.AutoReveal;
import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.DependsOn;
import org.dominokit.domino.api.client.annotations.presenter.EventsGroup;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.domino.api.client.annotations.presenter.Slot;
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