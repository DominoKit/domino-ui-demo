package org.dominokit.domino.themes.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.AutoReveal;
import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.DependsOn;
import org.dominokit.domino.api.client.annotations.presenter.EventsGroup;
import org.dominokit.domino.api.client.annotations.presenter.OnBeforeReveal;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.domino.api.client.annotations.presenter.Singleton;
import org.dominokit.domino.api.client.annotations.presenter.Slot;
import org.dominokit.domino.api.client.mvp.StoreRegistry;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.themes.client.views.ThemesButtonView;

@PresenterProxy
@AutoRoute(routeOnce = true)
@Singleton
@AutoReveal
@Slot(IsLayout.Slots.TOP_BAR)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class ThemesButtonProxy extends ViewBaseClientPresenter<ThemesButtonView> implements ThemesButtonView.ThemesButtonUiHandlers {

    private IsLayout layout;

    @OnBeforeReveal
    public void getLayout() {
        StoreRegistry.INSTANCE.<IsLayout>consumeData("layout", isLayout -> this.layout = isLayout);
    }

    @Override
    public void onShowHideThemes() {
        if (layout.isRightPanelVisible()) {
            this.layout.hideRightPanel();
        } else {
            this.layout.showRightPanel();
        }
    }
}