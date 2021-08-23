package org.dominokit.domino.formsamples.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="FormSamples")
public class FormSamplesClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(FormSamplesClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing FormSamples frontend module ...");
		new ModuleConfigurator().configureModule(new FormSamplesModuleConfiguration());
	}
}
