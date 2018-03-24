package org.dominokit.domino.basicforms.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="BasicForms")
public class BasicFormsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(BasicFormsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing BasicForms frontend module ...");
		new ModuleConfigurator().configureModule(new BasicFormsModuleConfiguration());
	}
}
