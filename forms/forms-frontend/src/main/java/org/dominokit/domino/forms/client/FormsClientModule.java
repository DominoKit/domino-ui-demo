package org.dominokit.domino.forms.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Forms")
public class FormsClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(FormsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Forms frontend module ...");
		//new ModuleConfigurator().configureModule(new FormsModuleConfiguration());
	}
}
