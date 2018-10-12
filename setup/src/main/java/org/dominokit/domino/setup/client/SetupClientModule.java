package org.dominokit.domino.setup.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Setup")
public class SetupClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(SetupClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Setup frontend module ...");
		new ModuleConfigurator().configureModule(new SetupModuleConfiguration());
	}
}
