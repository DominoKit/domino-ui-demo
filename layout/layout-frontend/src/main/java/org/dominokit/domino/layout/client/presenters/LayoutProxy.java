package org.dominokit.domino.layout.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.Store;
import org.dominokit.domino.api.client.mvp.StoreRegistry;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.layout.client.views.LayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;

@PresenterProxy
@AutoRoute(routeOnce = true)
@Singleton
@AutoReveal
@Slot(ViewBaseClientPresenter.DOCUMENT_BODY)
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
            history().fireState("home");
        }
    }
}