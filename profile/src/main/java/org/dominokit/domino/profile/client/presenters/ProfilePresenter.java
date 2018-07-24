package org.dominokit.domino.profile.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.layout.shared.extension.LayoutContext;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.profile.client.views.ProfileView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class ProfilePresenter extends ViewBaseClientPresenter<ProfileView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilePresenter.class);

    @ListenTo(event=LayoutEvent.class)
    public void onLayoutEvent(LayoutContext context) {
        view.setLayout(context.getLayout());
    }
}