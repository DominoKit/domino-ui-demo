package org.dominokit.domino.popover.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Popover")
public class PopoverClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(PopoverClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Popover frontend module ...");
		new ModuleConfigurator().configureModule(new PopoverModuleConfiguration());
	}
}
