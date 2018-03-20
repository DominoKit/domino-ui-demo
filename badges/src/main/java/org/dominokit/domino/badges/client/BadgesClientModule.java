package org.dominokit.domino.badges.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Badges")
public class BadgesClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(BadgesClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Badges frontend module ...");
		new ModuleConfigurator().configureModule(new BadgesModuleConfiguration());
	}
}
