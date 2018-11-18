package org.dominokit.domino.formsvalidations.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="FormsValidations")
public class FormsValidationsClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(FormsValidationsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing FormsValidations frontend module ...");
		//new ModuleConfigurator().configureModule(new FormsValidationsModuleConfiguration());
	}
}
