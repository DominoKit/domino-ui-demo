package com.progressoft.brix.domino.labels.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.mvp.presenter.Presentable;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.components.shared.extension.ComponentsExtensionPoint;

public interface LabelsPresenter extends Presentable {

    @InjectContext(extensionPoint = ComponentsExtensionPoint.class)
    void contributeToComponentsModule(ComponentsContext context);
}