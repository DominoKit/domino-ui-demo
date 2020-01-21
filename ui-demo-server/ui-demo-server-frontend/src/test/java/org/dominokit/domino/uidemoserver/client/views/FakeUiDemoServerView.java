package org.dominokit.domino.uidemoserver.client.views;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.test.api.client.FakeElement;
import org.dominokit.domino.test.api.client.FakeView;
import org.dominokit.domino.uidemoserver.client.presenters.UiDemoServerProxy_Presenter;

@UiView(presentable= UiDemoServerProxy_Presenter.class)
public class FakeUiDemoServerView extends FakeView implements UiDemoServerView {

    private FakeElement root;

    @Override
    protected void initRoot(FakeElement root) {
        this.root = root;
    }
}
