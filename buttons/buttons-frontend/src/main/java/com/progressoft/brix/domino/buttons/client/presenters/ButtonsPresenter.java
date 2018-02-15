package com.progressoft.brix.domino.buttons.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.mvp.presenter.Presentable;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.components.shared.extension.ComponentsExtensionPoint;

public interface ButtonsPresenter extends Presentable {

    @InjectContext(extensionPoint = ComponentsExtensionPoint.class)
    void contributeToComponentsModule(ComponentsContext context);
}