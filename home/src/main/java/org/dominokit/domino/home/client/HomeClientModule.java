package org.dominokit.domino.home.client;


import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Home")
public class HomeClientModule  {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Home frontend module ...");
		//new ModuleConfigurator().configureModule(new HomeModuleConfiguration());
	}
}
