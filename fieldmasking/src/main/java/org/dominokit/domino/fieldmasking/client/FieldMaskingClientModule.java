package org.dominokit.domino.fieldmasking.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="FieldMasking")
public class FieldMaskingClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(FieldMaskingClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing FieldMasking frontend module ...");
		new ModuleConfigurator().configureModule(new FieldMaskingModuleConfiguration());
	}
}
