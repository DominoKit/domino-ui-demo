package org.dominokit.domino.carousel.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Carousel")
public class CarouselClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(CarouselClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Carousel frontend module ...");
		new ModuleConfigurator().configureModule(new CarouselModuleConfiguration());
	}
}
