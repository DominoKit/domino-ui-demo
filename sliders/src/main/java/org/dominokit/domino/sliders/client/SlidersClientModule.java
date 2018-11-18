package org.dominokit.domino.sliders.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Sliders")
public class SlidersClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(SlidersClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Sliders frontend module ...");
		//new ModuleConfigurator().configureModule(new SlidersModuleConfiguration());
	}
}
