package com.progressoft.brix.domino.layout.shared.extension;

import com.progressoft.brix.domino.api.shared.extension.Content;

public interface IsLayout {
    IsLayout show();

    IsLayout show(String theme);

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
}
