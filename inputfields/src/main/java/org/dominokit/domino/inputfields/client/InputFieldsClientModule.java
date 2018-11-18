package org.dominokit.domino.inputfields.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="InputFields")
public class InputFieldsClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(InputFieldsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing InputFields frontend module ...");
		//new ModuleConfigurator().configureModule(new InputFieldsModuleConfiguration());
	}
}
