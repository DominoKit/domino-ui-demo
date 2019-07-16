package org.dominokit.domino.menu.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface MenuView extends ContentView, HasUiHandlers<MenuView.MenuUiHandlers> {

    interface MenuUiHandlers extends UiHandlers{
        void onLocked();
        void onUnLocked();
        void onXLargeMedia();
        void onLargeMedia();
        void onMediumMedia();
        void onSmallMedia();
        void onXSmallMedia();
        void onMenuItemSelected(String token);
    }
}