package com.progressoft.brix.domino.menu.client.presenters;

import com.progressoft.brix.domino.api.client.annotations.InjectContext;
import com.progressoft.brix.domino.api.client.annotations.Presenter;
import com.progressoft.brix.domino.api.client.mvp.presenter.BaseClientPresenter;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;
import com.progressoft.brix.domino.layout.shared.extension.LayoutExtensionPoint;
import com.progressoft.brix.domino.menu.client.views.MenuView;
import com.progressoft.brix.domino.menu.shared.extension.MenuContext;
import com.progressoft.brix.domino.menu.shared.extension.MenuExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class MenuPresenter extends BaseClientPresenter<MenuView> implements MenuContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuPresenter.class);

    @InjectContext(extensionPoint=LayoutExtensionPoint.class)
    public void contributeToLayoutModule(LayoutContext context) {
        view.init(context.getLayout());
        applyContributions(MenuExtensionPoint.class, () -> MenuPresenter.this);
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName, OnMenuSelectedHandler selectionHandler) {
        return view.addMenuItem(title, iconName, selectionHandler);
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName) {
        return view.addMenuItem(title, iconName);
    }
}