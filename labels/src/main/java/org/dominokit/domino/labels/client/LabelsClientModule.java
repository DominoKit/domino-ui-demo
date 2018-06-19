package org.dominokit.domino.labels.client;


import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Labels")
public class LabelsClientModule  {

	private static final Logger LOGGER = LoggerFactory.getLogger(LabelsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Labels frontend module ...");
		//new ModuleConfigurator().configureModule(new LabelsModuleConfiguration());
	}
}
