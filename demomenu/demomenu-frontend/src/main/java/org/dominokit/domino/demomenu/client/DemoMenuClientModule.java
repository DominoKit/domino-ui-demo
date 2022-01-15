package org.dominokit.domino.demomenu.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="DemoMenu")
public class DemoMenuClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(DemoMenuClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing DemoMenu frontend module ...");
		new ModuleConfigurator().configureModule(new DemoMenuModuleConfiguration());
	}
}
