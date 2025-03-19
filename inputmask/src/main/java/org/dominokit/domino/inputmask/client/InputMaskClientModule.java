package org.dominokit.domino.inputmask.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="InputMask")
public class InputMaskClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(InputMaskClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing input mask frontend module ...");
		new ModuleConfigurator().configureModule(new InputMaskModuleConfiguration());
	}
}
