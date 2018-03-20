package org.dominokit.domino.typography.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Typography")
public class TypographyClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(TypographyClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Typography frontend module ...");
		new ModuleConfigurator().configureModule(new TypographyModuleConfiguration());
	}
}
