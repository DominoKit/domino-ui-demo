package org.dominokit.domino.counters.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Counters")
public class CountersClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(CountersClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing counters frontend module ...");
		new ModuleConfigurator().configureModule(new CountersModuleConfiguration());
	}
}
