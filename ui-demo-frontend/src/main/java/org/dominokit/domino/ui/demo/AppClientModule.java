package org.dominokit.domino.ui.demo;

import com.google.gwt.core.client.EntryPoint;
import elemental2.dom.DomGlobal;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.gwt.client.app.DominoGWT;
import org.dominokit.domino.view.GwtView;

import java.util.logging.Logger;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {
        if (System.getProperty("superdevmode").equals("on")) {
            DominoGWT.init();
        }else {
            DominoGWT.InitOptions initOptions = new DominoGWT.InitOptions("domino-ui/demo/v1");
            DominoGWT.init(initOptions);
        }
        GwtView.init();
        ClientApp.make().run();
        LOGGER.info("ui-demo Application frontend have been initialized.");
    }
}
