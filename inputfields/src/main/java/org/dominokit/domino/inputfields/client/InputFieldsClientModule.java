package org.dominokit.domino.inputfields.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="InputFields")
public class InputFieldsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(InputFieldsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing InputFields frontend module ...");
		new ModuleConfigurator().configureModule(new InputFieldsModuleConfiguration());
	}
}
