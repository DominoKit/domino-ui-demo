package com.progressoft.brix.domino.progress.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCase;
import com.progressoft.brix.domino.componentcase.shared.extension.DemoView;

public interface ProgressView extends View, DemoView{
    ComponentCase.ComponentRevealedHandler restartProgress();
}