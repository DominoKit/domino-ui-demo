package org.dominokit.domino.sliders.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Sliders")
public class SlidersClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(SlidersClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Sliders frontend module ...");
		new ModuleConfigurator().configureModule(new SlidersModuleConfiguration());
	}
}
