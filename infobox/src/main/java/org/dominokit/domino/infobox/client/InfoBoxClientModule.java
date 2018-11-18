package org.dominokit.domino.infobox.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="InfoBox")
public class InfoBoxClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(InfoBoxClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing InfoBox frontend module ...");
		//new ModuleConfigurator().configureModule(new InfoBoxModuleConfiguration());
	}
}
