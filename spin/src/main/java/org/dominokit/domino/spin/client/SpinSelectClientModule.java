package org.dominokit.domino.spin.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="SpinSelect")
public class SpinSelectClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpinSelectClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing SpinSelect frontend module ...");
		//new ModuleConfigurator().configureModule(new SpinSelectModuleConfiguration());
	}
}
