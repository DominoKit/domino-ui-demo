package org.dominokit.domino.tabs.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Tabs")
public class TabsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(TabsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Tabs frontend module ...");
		new ModuleConfigurator().configureModule(new TabsModuleConfiguration());
	}
}
