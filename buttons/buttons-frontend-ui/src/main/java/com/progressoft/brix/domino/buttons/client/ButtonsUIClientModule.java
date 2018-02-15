package com.progressoft.brix.domino.buttons.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name = "ButtonsUI")
public class ButtonsUIClientModule implements EntryPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(ButtonsUIClientModule.class);

    public void onModuleLoad() {
        LOGGER.info("Initializing Buttons frontend UI module ...");
        new ModuleConfigurator().configureModule(new ButtonsUIModuleConfiguration());
    }
}
