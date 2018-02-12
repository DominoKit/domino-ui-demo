package com.progressoft.brix.domino.cards.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="CardsUI")
public class CardsUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(CardsUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Cards frontend UI module ...");
		new ModuleConfigurator().configureModule(new CardsUIModuleConfiguration());
	}
}
