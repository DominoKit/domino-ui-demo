package org.dominokit.domino.layout.shared.extension;

public interface IsLayout {

    interface Slots{
        String RIGHT_PANEL = "right-panel";
        String CONTENT = "content";
        String TOP_BAR = "top-bar";
        String MENU_PANEL = "menu-panel";
        String PROFILE_PANEL = "profile-panel";
    }

    interface Store{
        String LAYOUT = "layout";
    }

    interface GlobalLoader{
        void startLoading();
        void stopLoading();
    }

    void toggleRightPanel();

    IsLayout showRightPanel();

    IsLayout hideRightPanel();

    void toggleLeftPanel();

    IsLayout showLeftPanel();

    IsLayout hideLeftPanel();

    IsLayout setTitle(String title);

    boolean isRightPanelVisible();

    IsLayout fixLeftPanelPosition();
    IsLayout unfixLeftPanelPosition();

    IsLayout setLeftPanelSize(String size);

    IsLayout scrollTop();
}
