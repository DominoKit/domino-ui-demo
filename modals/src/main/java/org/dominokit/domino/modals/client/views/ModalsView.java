package org.dominokit.domino.modals.client.views;

import org.dominokit.domino.componentcase.client.presenters.DemoView;

public interface ModalsView extends DemoView<DemoView.DemoViewUiHandlers> {
    void cleanup();
}