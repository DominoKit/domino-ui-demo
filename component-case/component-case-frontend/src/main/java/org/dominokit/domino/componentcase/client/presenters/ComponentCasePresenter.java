package org.dominokit.domino.componentcase.client.presenters;

import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenter;
import org.dominokit.domino.api.client.mvp.view.View;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LoaderStoreImpl;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class ComponentCasePresenter<V extends View> extends ViewablePresenter<V> implements DemoView.DemoViewUiHandlers {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentCasePresenter.class);

    @Override
    public void startLoading() {
        LoaderStoreImpl.INSTANCE.getData().ifPresent(IsLayout.GlobalLoader::startLoading);
        ElementUtil.scrollTop();
    }

    @Override
    public void stopLoading() {
        LoaderStoreImpl.INSTANCE.getData().ifPresent(IsLayout.GlobalLoader::stopLoading);
    }
}