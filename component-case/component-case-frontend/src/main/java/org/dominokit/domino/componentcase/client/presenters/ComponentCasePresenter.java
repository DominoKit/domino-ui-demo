package org.dominokit.domino.componentcase.client.presenters;

import org.dominokit.domino.api.client.mvp.StoreRegistry;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.client.mvp.view.View;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ComponentCasePresenter<V extends View> extends ViewBaseClientPresenter<V> implements DemoView.DemoViewUiHandlers {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentCasePresenter.class);

    @Override
    public void startLoading() {
        StoreRegistry.INSTANCE.<IsLayout.GlobalLoader>consumeData("loader", globalLoader -> {
            globalLoader.startLoading();
        });
    }

    @Override
    public void stopLoading() {
        StoreRegistry.INSTANCE.<IsLayout.GlobalLoader>consumeData("loader", globalLoader -> {
            globalLoader.stopLoading();
        });

    }
}