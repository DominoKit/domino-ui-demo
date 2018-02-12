package com.progressoft.brix.domino.profile.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.profile.client.views.ProfileView;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultProfilePresenter extends BaseClientPresenter<ProfileView> implements ProfilePresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultProfilePresenter.class);

    @Override
    public void contributeToLayoutModule(LayoutContext context) {
        view.setLayout(context.getLayout());
    }
}