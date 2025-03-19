package org.dominokit.domino.navbar.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="NavBar")
public class NavbarClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(NavbarClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Navigation Bar frontend module ...");
		new ModuleConfigurator().configureModule(new NavBarModuleConfiguration());
	}
}
