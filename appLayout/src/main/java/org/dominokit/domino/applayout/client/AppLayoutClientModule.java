package org.dominokit.domino.applayout.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="AppLayout")
public class AppLayoutClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(AppLayoutClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing LayoutSample frontend module ...");
		//new ModuleConfigurator().configureModule(new AppLayoutModuleConfiguration());
	}
}
