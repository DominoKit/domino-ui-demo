package org.dominokit.domino.componentcase.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="ComponentCase")
public class ComponentCaseClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(ComponentCaseClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing ComponentCase frontend module ...");
		//new ModuleConfigurator().configureModule(new ComponentCaseModuleConfiguration());
	}
}
