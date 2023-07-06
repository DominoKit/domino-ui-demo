package org.dominokit.domino.layout.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.AutoReveal;
import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.OnReveal;
import org.dominokit.domino.api.client.annotations.presenter.OnStateChanged;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.domino.api.client.annotations.presenter.RegisterSlots;
import org.dominokit.domino.api.client.annotations.presenter.Singleton;
import org.dominokit.domino.api.client.annotations.presenter.Slot;
import org.dominokit.domino.api.client.mvp.Store;
import org.dominokit.domino.api.client.mvp.StoreRegistry;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.PredefinedSlots;
import org.dominokit.domino.history.StateToken;
import org.dominokit.domino.layout.client.views.LayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;

@PresenterProxy
@AutoRoute(routeOnce = true)
@Singleton
@AutoReveal
@Slot(PredefinedSlots.BODY_SLOT)
@OnStateChanged(LayoutEvent.class)
@RegisterSlots({
        IsLayout.Slots.CONTENT,
        IsLayout.Slots.MENU_PANEL,
        IsLayout.Slots.PROFILE_PANEL,
        IsLayout.Slots.TOP_BAR,
        IsLayout.Slots.RIGHT_PANEL
})
public class LayoutProxy extends ViewBaseClientPresenter<LayoutView> {

    @OnReveal
    public void onRevealed(){
        StoreRegistry.INSTANCE.registerStore("layout", new Store<IsLayout>(view));
        StoreRegistry.INSTANCE.registerStore("loader", new Store<IsLayout.GlobalLoader>(view));
        if(history().currentToken().paths().isEmpty()){
            history().fireState(StateToken.of("home"));
        }
    }
}