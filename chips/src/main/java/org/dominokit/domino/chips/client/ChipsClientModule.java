package org.dominokit.domino.chips.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Chips")
public class ChipsClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChipsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Chips frontend module ...");
		//new ModuleConfigurator().configureModule(new ChipsModuleConfiguration());
	}
}
