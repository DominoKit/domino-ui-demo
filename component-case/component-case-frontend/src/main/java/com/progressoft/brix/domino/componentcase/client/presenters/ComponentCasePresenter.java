package com.progressoft.brix.domino.componentcase.client.presenters;

import com.progressoft.brix.domino.api.client.mvp.presenter.Presentable;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.layout.shared.extension.LayoutExtensionPoint;
import com.progressoft.brix.domino.menu.shared.extension.MenuContext;
import com.progressoft.brix.domino.menu.shared.extension.MenuExtensionPoint;

public interface ComponentCasePresenter extends Presentable{

    @InjectContext(extensionPoint=MenuExtensionPoint.class)
    void contributeToMenuModule(MenuContext context);

    @InjectContext(extensionPoint=LayoutExtensionPoint.class)
    void contributeToLayoutModule(LayoutContext context);
}