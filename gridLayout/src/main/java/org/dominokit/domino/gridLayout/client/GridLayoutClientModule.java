package org.dominokit.domino.gridLayout.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="GridLayout")
public class GridLayoutClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(GridLayoutClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing GridLayout frontend module ...");
		new ModuleConfigurator().configureModule(new GridLayoutModuleConfiguration());
	}
}
