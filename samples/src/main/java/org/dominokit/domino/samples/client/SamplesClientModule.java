package org.dominokit.domino.samples.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Samples")
public class SamplesClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(SamplesClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Samples frontend module ...");
		new ModuleConfigurator().configureModule(new SamplesModuleConfiguration());
	}
}
