package org.dominokit.domino.menu.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.StoreRegistry;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.menu.client.views.MenuView;

@PresenterProxy
@AutoRoute(routeOnce = true)
@AutoReveal
@Slot(IsLayout.Slots.MENU_PANEL)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class MenuProxy extends ViewBaseClientPresenter<MenuView> implements MenuView.MenuUiHandlers {

    private IsLayout layout;

    @OnBeforeReveal
    public void getLayout() {
        StoreRegistry.INSTANCE.<IsLayout>consumeData("layout", isLayout -> this.layout= isLayout);
    }

    @Override
    public void onLocked() {
        layout.fixLeftPanelPosition();
    }

    @Override
    public void onUnLocked() {
        layout.unfixLeftPanelPosition();
        layout.hideLeftPanel();
    }

    @Override
    public void onXLargeMedia() {
        layout.fixLeftPanelPosition();
    }

    @Override
    public void onLargeMedia() {
        layout.fixLeftPanelPosition();
    }

    @Override
    public void onMediumMedia() {
        layout.unfixLeftPanelPosition();
        layout.hideLeftPanel();
    }

    @Override
    public void onSmallMedia() {
        layout.unfixLeftPanelPosition();
        layout.hideLeftPanel();
    }

    @Override
    public void onXSmallMedia() {
        layout.unfixLeftPanelPosition();
        layout.hideLeftPanel();
    }

    @Override
    public void onMenuItemSelected(String token) {
        this.layout.scrollTop();
        history().fireState(history().currentToken().replaceAllPaths(token).value());
    }
}