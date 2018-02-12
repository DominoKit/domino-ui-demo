package com.progressoft.brix.domino.components.client.presenters;

import com.progressoft.brix.domino.api.client.mvp.presenter.Presentable;
import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;

public interface ComponentsPresenter extends Presentable{

    @InjectContext(extensionPoint=ComponentCaseExtensionPoint.class)
    void contributeToDemoPageModule(ComponentCaseContext context);
}