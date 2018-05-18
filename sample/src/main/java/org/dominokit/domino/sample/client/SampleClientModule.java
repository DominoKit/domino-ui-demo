package org.dominokit.domino.sample.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Sample")
public class SampleClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(SampleClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Sample frontend module ...");
		new ModuleConfigurator().configureModule(new SampleModuleConfiguration());
	}
}
