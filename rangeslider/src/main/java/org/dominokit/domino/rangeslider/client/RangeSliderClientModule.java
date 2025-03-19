package org.dominokit.domino.rangeslider.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="RangeSlider")
public class RangeSliderClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(RangeSliderClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Range slider frontend module ...");
		new ModuleConfigurator().configureModule(new RangeSliderModuleConfiguration());
	}
}
