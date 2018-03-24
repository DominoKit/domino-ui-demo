package org.dominokit.domino.waves.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Waves")
public class WavesClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(WavesClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Waves frontend module ...");
		new ModuleConfigurator().configureModule(new WavesModuleConfiguration());
	}
}
