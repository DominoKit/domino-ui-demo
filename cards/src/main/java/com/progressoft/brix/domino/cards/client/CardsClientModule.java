package com.progressoft.brix.domino.cards.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Cards")
public class CardsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(CardsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Cards frontend module ...");
		new ModuleConfigurator().configureModule(new CardsModuleConfiguration());
	}
}
