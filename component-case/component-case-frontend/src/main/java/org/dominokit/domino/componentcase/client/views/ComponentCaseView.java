package org.dominokit.domino.componentcase.client.views;

import org.dominokit.domino.api.client.mvp.view.View;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.layout.shared.extension.IsLayout;

public interface ComponentCaseView extends View{
    void init(IsLayout layout);
    void clear();

    void scrollTop();

    void showContent(Content content);
}