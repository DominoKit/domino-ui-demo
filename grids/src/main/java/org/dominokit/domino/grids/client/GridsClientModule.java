package org.dominokit.domino.grids.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Grids")
public class GridsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(GridsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Grids frontend module ...");
		new ModuleConfigurator().configureModule(new GridsModuleConfiguration());
	}
}
