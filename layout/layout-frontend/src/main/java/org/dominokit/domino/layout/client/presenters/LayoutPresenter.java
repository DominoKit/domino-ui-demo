package org.dominokit.domino.layout.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.domino.api.shared.extension.MainEventContext;
import org.dominokit.domino.layout.client.views.LayoutView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutContext;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class LayoutPresenter extends ViewBaseClientPresenter<LayoutView> implements LayoutContext {

    private static final Logger LOGGER = LoggerFactory.getLogger(LayoutPresenter.class);

    @ListenTo(event=MainDominoEvent.class)
    public void onMainModule(MainEventContext context) {
        view.show();
        fireEvent(LayoutEvent.class, () -> LayoutPresenter.this);
    }

    @Override
    public IsLayout getLayout() {
        return view;
    }
}