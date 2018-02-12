package com.progressoft.brix.domino.themes.client.presenters;

import com.progressoft.brix.domino.api.client.mvp.presenter.Presentable;
import com.progressoft.brix.domino.api.shared.extension.MainExtensionPoint;
import com.progressoft.brix.domino.api.shared.extension.MainContext;
import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.layout.shared.extension.LayoutExtensionPoint;

public interface ThemesPresenter extends Presentable{

    @InjectContext(extensionPoint=LayoutExtensionPoint.class)
    void contributeToLayoutModule(LayoutContext context);
}