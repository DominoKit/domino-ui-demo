package org.dominokit.domino.loaders.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Loaders")
public class LoadersClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoadersClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Loaders frontend module ...");
		new ModuleConfigurator().configureModule(new LoadersModuleConfiguration());
	}
}
