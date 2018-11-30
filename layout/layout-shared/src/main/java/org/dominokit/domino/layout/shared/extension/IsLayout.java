package org.dominokit.domino.layout.shared.extension;

import org.dominokit.domino.api.shared.extension.Content;

public interface IsLayout {
    IsLayout show();

    void toggleRightPanel();

    IsLayout showRightPanel();

    IsLayout hideRightPanel();

    void toggleLeftPanel();

    IsLayout showLeftPanel();

    IsLayout hideLeftPanel();

    Content getRightPanel();

    Content getLeftPanel();

    Content getContentPanel();

    Content getTopBar();

    IsLayout setTitle(String title);

    Content addActionItem(String icon);

    void setRightPanelContent(Content content);

    IsLayout fixLeftPanelPosition();
    IsLayout unfixLeftPanelPosition();

    IsLayout setLeftPanelSize(String size);
}
