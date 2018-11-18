package org.dominokit.domino.layout.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="LayoutUI")
public class LayoutUIClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(LayoutUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Layout frontend UI module ...");
		//new ModuleConfigurator().configureModule(new LayoutUIModuleConfiguration());
	}
}
