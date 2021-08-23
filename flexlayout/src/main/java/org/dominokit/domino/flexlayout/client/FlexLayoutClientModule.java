package org.dominokit.domino.flexlayout.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="FlexLayout")
public class FlexLayoutClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlexLayoutClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing FlexLayout frontend module ...");
		new ModuleConfigurator().configureModule(new FlexLayoutModuleConfiguration());
	}
}
