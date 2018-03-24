package org.dominokit.domino.forms.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="FormsUI")
public class FormsUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(FormsUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Forms frontend UI module ...");
		new ModuleConfigurator().configureModule(new FormsUIModuleConfiguration());
	}
}
