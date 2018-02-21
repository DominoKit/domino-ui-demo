package com.progressoft.brix.domino.icons.client.presenters;

import com.progressoft.brix.domino.icons.client.presenters.DefaultIconsPresenter;
import com.progressoft.brix.domino.api.shared.extension.MainContext;

public class IconsPresenterSpy extends DefaultIconsPresenter{

    private MainContext mainContext;

    @Override
    public void contributeToMainModule(MainContext context) {
        super.contributeToMainModule(context);
        this.mainContext=context;
    }

    public MainContext getMainContext() {
        return mainContext;
    }

    @Override
    protected String getConcrete() {
        return DefaultIconsPresenter.class.getCanonicalName();
    }
}
