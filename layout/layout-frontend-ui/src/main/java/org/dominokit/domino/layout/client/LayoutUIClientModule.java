package org.dominokit.domino.layout.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="LayoutUI")
public class LayoutUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(LayoutUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Layout frontend UI module ...");
		new ModuleConfigurator().configureModule(new LayoutUIModuleConfiguration());
	}
}
