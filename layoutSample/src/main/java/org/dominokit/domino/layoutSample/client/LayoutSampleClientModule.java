package org.dominokit.domino.layoutSample.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="LayoutSample")
public class LayoutSampleClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(LayoutSampleClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing LayoutSample frontend module ...");
		new ModuleConfigurator().configureModule(new LayoutSampleModuleConfiguration());
	}
}
