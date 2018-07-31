package org.dominokit.domino.steppers.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Steppers")
public class SteppersClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(SteppersClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Steppers frontend module ...");
		new ModuleConfigurator().configureModule(new SteppersModuleConfiguration());
	}
}
