package org.dominokit.domino.mdiicons.client.views;

import org.dominokit.domino.componentcase.client.presenters.DemoView;

public interface MdiIconsView extends DemoView<DemoView.DemoViewUiHandlers> {
    void loadIconsByTag(String tag);
}