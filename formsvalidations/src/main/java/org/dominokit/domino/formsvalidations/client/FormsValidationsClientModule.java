package org.dominokit.domino.formsvalidations.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="FormsValidations")
public class FormsValidationsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(FormsValidationsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing FormsValidations frontend module ...");
		new ModuleConfigurator().configureModule(new FormsValidationsModuleConfiguration());
	}
}
