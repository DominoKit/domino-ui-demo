package com.progressoft.brix.domino.layout.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;
import com.progressoft.brix.domino.layout.client.views.LayoutView;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.layout.shared.extension.LayoutExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class LayoutPresenter extends BaseClientPresenter<LayoutView> implements LayoutContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(LayoutPresenter.class);

    @InjectContext(extensionPoint=MainExtensionPoint.class)
    public void contributeToMainModule(MainContext context) {
        view.show();
        applyContributions(LayoutExtensionPoint.class, () -> LayoutPresenter.this);
    }

    @Override
    public IsLayout getLayout() {
        return view;
    }
}