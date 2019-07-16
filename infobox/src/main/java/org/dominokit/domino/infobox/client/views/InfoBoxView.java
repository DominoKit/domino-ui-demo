package org.dominokit.domino.infobox.client.views;

import org.dominokit.domino.componentcase.client.presenters.DemoView;

public interface InfoBoxView extends DemoView<DemoView.DemoViewUiHandlers> {
    void restartCounters();
}