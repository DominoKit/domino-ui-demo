package com.progressoft.brix.domino.ui.demo;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ClientApp;
import com.google.gwt.user.client.History;
import me.rjb.client.SyntaxHighlighter;
import me.rjb.client.themes.Themes;

import java.util.logging.Logger;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {
        SyntaxHighlighter.init(Themes.Eclipse);
        ClientApp.make().run();
        LOGGER.info("ui-demo Application frontend have been initialized.");
    }
}
