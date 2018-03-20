package org.dominokit.domino.layout.client.views;

import org.dominokit.domino.api.client.mvp.view.View;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutContext;

public interface LayoutView extends View, IsLayout{

    void addActionItem(String iconName, LayoutContext.SelectionHandler selectionHandler);
    void setRightPanelContent(Content content);
}