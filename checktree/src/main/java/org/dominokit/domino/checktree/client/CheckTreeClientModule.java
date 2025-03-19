package org.dominokit.domino.checktree.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="CheckTree")
public class CheckTreeClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckTreeClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing CheckTree Sample frontend module ...");
		new ModuleConfigurator().configureModule(new CheckTreeModuleConfiguration());
	}
}
