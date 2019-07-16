package org.dominokit.domino.profile.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.profile.client.views.ProfileView;

@PresenterProxy
@AutoRoute(routeOnce = true)
@Singleton()
@AutoReveal
@Slot(IsLayout.Slots.PROFILE_PANEL)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class ProfileProxy extends ViewBaseClientPresenter<ProfileView> {

}