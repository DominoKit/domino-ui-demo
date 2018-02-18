package com.progressoft.brix.domino.labels.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name = "LabelsUI")
public class LabelsUIClientModule implements EntryPoint {

    private static final Logger LOGGER = LoggerFactory.getLogger(LabelsUIClientModule.class);

    public void onModuleLoad() {
        LOGGER.info("Initializing Labels frontend UI module ...");
        new ModuleConfigurator().configureModule(new LabelsUIModuleConfiguration());
    }
}
