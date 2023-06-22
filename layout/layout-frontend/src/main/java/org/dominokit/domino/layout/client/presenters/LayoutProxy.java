package org.dominokit.domino.layout.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewablePresenter;
import org.dominokit.domino.api.shared.extension.PredefinedSlots;
import org.dominokit.domino.layout.client.views.LayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.layout.shared.extension.LayoutStoreImpl;
import org.dominokit.domino.layout.shared.extension.LoaderStoreImpl;

import javax.annotation.PostConstruct;

@PresenterProxy
@AutoRoute(routeOnce = true)
@Singleton
@AutoReveal
@Slot(PredefinedSlots.BODY_SLOT)
@OnStateChanged(LayoutEvent.class)
@RegisterSlots({
        IsLayout.Slots.CONTENT,
        IsLayout.Slots.MENU_PANEL,
        IsLayout.Slots.TOP_BAR,
        IsLayout.Slots.RIGHT_PANEL
})
public class LayoutProxy extends ViewablePresenter<LayoutView> {

    @PostConstruct
    public void onInit(){
        LayoutStoreImpl.INSTANCE.setData(view);
    }

    @OnReveal
    public void onRevealed(){
        if(history().currentToken().paths().isEmpty()){
            history().fireState("home");
        }
    }
}