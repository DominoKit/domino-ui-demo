package org.dominokit.domino.sample.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.sample.client.views.SampleView;
import org.dominokit.domino.api.shared.extension.MainExtensionPoint;
import org.dominokit.domino.api.shared.extension.MainContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class SamplePresenter extends BaseClientPresenter<SampleView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SamplePresenter.class);

    @InjectContext(extensionPoint=MainExtensionPoint.class)
    public void contributeToMainModule(MainContext context) {
        LOGGER.info("Main context received at presenter " + SamplePresenter.class.getSimpleName());
    }
}