package org.dominokit.domino.progress.client.views;

import org.dominokit.domino.api.client.mvp.view.View;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.DemoView;

public interface ProgressView extends View, DemoView{
    ComponentCase.ComponentRevealedHandler restartProgress();
}