package org.dominokit.domino.themes.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.StoreRegistry;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.themes.client.views.ThemesButtonView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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