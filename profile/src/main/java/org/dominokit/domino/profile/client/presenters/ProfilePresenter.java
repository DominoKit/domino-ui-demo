package org.dominokit.domino.profile.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.layout.shared.extension.LayoutContext;
import org.dominokit.domino.layout.shared.extension.LayoutExtensionPoint;
import org.dominokit.domino.profile.client.views.ProfileView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class ProfilePresenter extends ViewBaseClientPresenter<ProfileView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilePresenter.class);

    @InjectContext(extensionPoint=LayoutExtensionPoint.class)
    public void contributeToLayoutModule(LayoutContext context) {
        view.setLayout(context.getLayout());
    }
}