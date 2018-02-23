package com.progressoft.brix.domino.icons.client.presenters;

import com.progressoft.brix.domino.api.client.mvp.presenter.Presentable;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.components.shared.extension.ComponentsContext;
import com.progressoft.brix.domino.components.shared.extension.ComponentsExtensionPoint;

public interface IconsPresenter extends Presentable{

    @InjectContext(extensionPoint=ComponentsExtensionPoint.class)
    void contributeToComponentsModule(ComponentsContext context);
}