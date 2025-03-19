package org.dominokit.domino.menubar.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="MenuBar")
public class MenuBarClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuBarClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing MenuBar frontend module ...");
		new ModuleConfigurator().configureModule(new MenuBarModuleConfiguration());
	}
}
