package com.progressoft.brix.domino.layout.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.layout.client.views.LayoutView;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.layout.shared.extension.LayoutExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DefaultLayoutPresenter extends BaseClientPresenter<LayoutView> implements LayoutPresenter, LayoutContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultLayoutPresenter.class);

    @Override
    public void contributeToMainModule(MainContext context) {
        view.show();
        applyContributions(LayoutExtensionPoint.class, () -> DefaultLayoutPresenter.this);
    }

    @Override
    public IsLayout getLayout() {
        return view;
    }
}