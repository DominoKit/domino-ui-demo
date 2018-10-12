package org.dominokit.domino.spin.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="SpinSelect")
public class SpinSelectClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(SpinSelectClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing SpinSelect frontend module ...");
		new ModuleConfigurator().configureModule(new SpinSelectModuleConfiguration());
	}
}
