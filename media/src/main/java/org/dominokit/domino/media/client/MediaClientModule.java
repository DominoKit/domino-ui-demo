package org.dominokit.domino.media.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Media")
public class MediaClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(MediaClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Media frontend module ...");
		//new ModuleConfigurator().configureModule(new MediaModuleConfiguration());
	}
}
