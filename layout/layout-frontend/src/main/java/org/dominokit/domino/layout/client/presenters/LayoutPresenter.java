package org.dominokit.domino.layout.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.api.shared.extension.MainContext;
import org.dominokit.domino.api.shared.extension.MainExtensionPoint;
import org.dominokit.domino.layout.client.views.LayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutContext;
import org.dominokit.domino.layout.shared.extension.LayoutExtensionPoint;
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