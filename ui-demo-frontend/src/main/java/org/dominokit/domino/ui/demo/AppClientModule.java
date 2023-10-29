package org.dominokit.domino.ui.demo;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.gwt.client.app.DominoGWT;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.view.DominoViewOptions;

import java.util.logging.Logger;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {
        if (System.getProperty("superdevmode").equals("on")) {
            DominoGWT.init(DominoViewOptions.getInstance());
        }else {
            DominoGWT.init(DominoViewOptions.getInstance().setRootPath("domino-ui/demo/v2"));
        }
        DominoThemeManager.INSTANCE.applyUserThemes();
        ClientApp.make().run();
        LOGGER.info("ui-demo Application frontend have been initialized.");
    }
}
