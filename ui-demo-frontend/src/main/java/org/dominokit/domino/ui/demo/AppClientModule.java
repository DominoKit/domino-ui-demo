package org.dominokit.domino.ui.demo;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.gwt.client.app.DominoGWT;
import org.dominokit.domino.ui.timepicker.TimeBox;
import org.dominokit.domino.view.GwtView;

import java.util.Date;
import java.util.logging.Logger;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {
        DominoGWT.init();
        GwtView.init();
        ClientApp.make().run();
        LOGGER.info("ui-demo Application frontend have been initialized.");
    }
}
