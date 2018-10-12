package org.dominokit.domino.samples.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.samples.client.views.SamplesView;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.domino.api.shared.extension.MainEventContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class SamplesPresenter extends ViewBaseClientPresenter<SamplesView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SamplesPresenter.class);

    @ListenTo(event=MainDominoEvent.class)
    public void listenToMainEvent(MainEventContext context) {
        LOGGER.info("Main context received at presenter " + SamplesPresenter.class.getSimpleName());
    }
}