package org.dominokit.domino.chips.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Chips")
public class ChipsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ChipsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Chips frontend module ...");
		new ModuleConfigurator().configureModule(new ChipsModuleConfiguration());
	}
}
