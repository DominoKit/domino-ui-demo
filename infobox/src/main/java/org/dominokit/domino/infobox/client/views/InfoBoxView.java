package org.dominokit.domino.infobox.client.views;

import org.dominokit.domino.api.client.mvp.view.View;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.DemoView;

public interface InfoBoxView extends View, DemoView{
    void restartCounters();
}