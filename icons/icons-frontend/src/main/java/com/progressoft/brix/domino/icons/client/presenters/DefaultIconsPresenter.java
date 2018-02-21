package com.progressoft.brix.domino.icons.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.icons.client.views.IconsView;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultIconsPresenter extends BaseClientPresenter<IconsView> implements IconsPresenter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultIconsPresenter.class);

    @Override
    public void contributeToMainModule(MainContext context) {
        LOGGER.info("Main context received at presenter " + DefaultIconsPresenter.class.getSimpleName());
    }
}