package com.progressoft.brix.domino.layout.client.presenters;

import com.progressoft.brix.domino.api.client.mvp.presenter.Presentable;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.api.client.annotations.InjectContext;

public interface LayoutPresenter extends Presentable{

    @InjectContext(extensionPoint=MainExtensionPoint.class)
    void contributeToMainModule(MainContext context);
}