package org.dominokit.domino.samples.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Samples")
public class SamplesClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(SamplesClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Samples frontend module ...");
		//new ModuleConfigurator().configureModule(new SamplesModuleConfiguration());
	}
}
