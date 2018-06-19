package org.dominokit.domino.cards.client;


import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Cards")
public class CardsClientModule  {

	private static final Logger LOGGER = LoggerFactory.getLogger(CardsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Cards frontend module ...");
		//new ModuleConfigurator().configureModule(new CardsModuleConfiguration());
	}
}
