package org.dominokit.domino.profile.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Profile")
public class ProfileClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProfileClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Profile frontend module ...");
		new ModuleConfigurator().configureModule(new ProfileModuleConfiguration());
	}
}
