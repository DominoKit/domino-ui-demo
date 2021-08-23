package org.dominokit.domino.mdiicons.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="MdiIcons")
public class MdiIconsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(MdiIconsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing MdiIcons frontend module ...");
		new ModuleConfigurator().configureModule(new MdiIconsModuleConfiguration());
	}
}
