package org.dominokit.domino.uidemoserver.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.uidemoserver.client.views.UiDemoServerView;
import org.dominokit.domino.uidemoserver.shared.extension.UiDemoServerEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter.DOCUMENT_BODY;

@PresenterProxy
@AutoRoute(token = "uidemoserver")
@Slot(DOCUMENT_BODY)
@AutoReveal
@OnStateChanged(UiDemoServerEvent.class)
public class UiDemoServerProxy extends ViewBaseClientPresenter<UiDemoServerView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(UiDemoServerProxy.class);

    @OnInit
    public void onUiDemoServerInit(){
        LOGGER.info("UiDemoServer initialized");
    }

    @OnReveal
    public void onUiDemoServerRevealed() {
        LOGGER.info("UiDemoServer view revealed");
    }
}