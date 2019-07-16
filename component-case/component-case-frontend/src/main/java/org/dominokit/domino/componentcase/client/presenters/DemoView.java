package org.dominokit.domino.componentcase.client.presenters;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;

public interface DemoView<T extends DemoView.DemoViewUiHandlers> extends ContentView, HasUiHandlers<T> {

    interface DemoViewUiHandlers extends UiHandlers{
        void startLoading();
        void stopLoading();
    }
}
