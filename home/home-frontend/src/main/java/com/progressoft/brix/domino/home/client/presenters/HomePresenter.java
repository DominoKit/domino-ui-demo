package com.progressoft.brix.domino.home.client.presenters;

import com.progressoft.brix.domino.api.client.mvp.presenter.Presentable;
import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;

public interface HomePresenter extends Presentable{

    @InjectContext(extensionPoint=ComponentCaseExtensionPoint.class)
    void contributeToDemoPageModule(ComponentCaseContext context);
}