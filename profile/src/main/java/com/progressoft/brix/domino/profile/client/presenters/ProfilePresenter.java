package com.progressoft.brix.domino.profile.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.layout.shared.extension.LayoutExtensionPoint;
import com.progressoft.brix.domino.profile.client.views.ProfileView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class ProfilePresenter extends BaseClientPresenter<ProfileView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfilePresenter.class);

    @InjectContext(extensionPoint=LayoutExtensionPoint.class)
    public void contributeToLayoutModule(LayoutContext context) {
        view.setLayout(context.getLayout());
    }
}