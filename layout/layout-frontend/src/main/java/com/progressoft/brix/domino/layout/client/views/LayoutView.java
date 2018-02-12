package com.progressoft.brix.domino.layout.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import com.progressoft.brix.domino.layout.shared.extension.LayoutContext;

public interface LayoutView extends View, IsLayout{

    void addActionItem(String iconName, LayoutContext.SelectionHandler selectionHandler);
    void setRightPanelContent(Content content);
}