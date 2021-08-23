package org.dominokit.domino.thumbnails.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Thumbnails")
public class ThumbnailsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ThumbnailsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Thumbnails frontend module ...");
		new ModuleConfigurator().configureModule(new ThumbnailsModuleConfiguration());
	}
}
