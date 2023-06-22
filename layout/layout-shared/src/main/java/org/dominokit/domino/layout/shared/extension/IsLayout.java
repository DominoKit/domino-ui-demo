package org.dominokit.domino.layout.shared.extension;

import org.dominokit.domino.api.shared.annotations.events.EventContext;
import org.dominokit.domino.api.shared.extension.IsDominoEvent;

@EventContext
public interface IsLayout {

    void spanDown(boolean spanDown);
    void spanUp(boolean spanUp);

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

    @EventContext
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
