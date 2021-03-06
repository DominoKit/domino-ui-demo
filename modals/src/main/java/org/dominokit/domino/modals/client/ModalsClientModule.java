package org.dominokit.domino.modals.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Modals")
public class ModalsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ModalsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Modals frontend module ...");
		new ModuleConfigurator().configureModule(new ModalsModuleConfiguration());
	}
}
