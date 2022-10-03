package org.dominokit.domino.themes.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.layout.shared.extension.LayoutStoreImpl;
import org.dominokit.domino.themes.client.views.ThemesButtonView;

@PresenterProxy
@AutoRoute(routeOnce = true)
@Singleton
@AutoReveal
@Slot(IsLayout.Slots.TOP_BAR)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class ThemesButtonProxy extends ViewablePresenter<ThemesButtonView> implements ThemesButtonView.ThemesButtonUiHandlers {

    private IsLayout layout;

    @OnBeforeReveal
    public void getLayout() {
        LayoutStoreImpl.INSTANCE.getData().ifPresent(isLayout -> this.layout = isLayout);
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