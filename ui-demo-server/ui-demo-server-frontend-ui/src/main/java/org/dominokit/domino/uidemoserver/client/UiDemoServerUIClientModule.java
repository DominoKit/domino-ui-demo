package org.dominokit.domino.uidemoserver.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="UiDemoServerUI")
public class UiDemoServerUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(UiDemoServerUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing UiDemoServer frontend UI module ...");
		new ModuleConfigurator().configureModule(new UiDemoServerUIModuleConfiguration());
	}
}
