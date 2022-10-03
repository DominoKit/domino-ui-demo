package org.dominokit.domino.profile.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.AutoReveal;
import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.DependsOn;
import org.dominokit.domino.api.client.annotations.presenter.EventsGroup;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.domino.api.client.annotations.presenter.Singleton;
import org.dominokit.domino.api.client.annotations.presenter.Slot;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.profile.client.views.ProfileView;

@PresenterProxy
@AutoRoute(routeOnce = true)
@Singleton()
@AutoReveal
@Slot(IsLayout.Slots.PROFILE_PANEL)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class ProfileProxy extends ViewablePresenter<ProfileView> {

}