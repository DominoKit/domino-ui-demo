package org.dominokit.domino.menu.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.layout.shared.extension.LayoutContext;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.menu.client.views.MenuView;
import org.dominokit.domino.menu.shared.extension.MenuContext;
import org.dominokit.domino.menu.shared.extension.MenuEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class MenuPresenter extends ViewBaseClientPresenter<MenuView> implements MenuContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuPresenter.class);

    @ListenTo(event=LayoutEvent.class)
    public void onLayoutEvent(LayoutContext context) {
        view.init(context.getLayout());
        fireEvent(MenuEvent.class, () -> MenuPresenter.this);
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName, OnMenuSelectedHandler selectionHandler) {
        return view.addMenuItem(title, iconName, selectionHandler);
    }

    @Override
    public CanAddMenuItem addMenuItem(String title, String iconName) {
        return view.addMenuItem(title, iconName);
    }

    @Override
    public void setMainTitle(String title) {
        view.setTitle(title);
    }
}