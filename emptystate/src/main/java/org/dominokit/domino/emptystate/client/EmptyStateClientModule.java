package org.dominokit.domino.emptystate.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="EmptyState")
public class EmptyStateClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmptyStateClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Empty State frontend module ...");
		new ModuleConfigurator().configureModule(new EmptyStateModuleConfiguration());
	}
}
