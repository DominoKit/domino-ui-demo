package com.progressoft.brix.domino.infobox.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="InfoBoxUI")
public class InfoBoxUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(InfoBoxUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing InfoBox frontend UI module ...");
		new ModuleConfigurator().configureModule(new InfoBoxUIModuleConfiguration());
	}
}
