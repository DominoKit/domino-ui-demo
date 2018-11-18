package org.dominokit.domino.preloaders.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Preloaders")
public class PreloadersClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(PreloadersClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Preloaders frontend module ...");
		//new ModuleConfigurator().configureModule(new PreloadersModuleConfiguration());
	}
}
