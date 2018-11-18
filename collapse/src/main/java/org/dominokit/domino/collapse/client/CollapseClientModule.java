package org.dominokit.domino.collapse.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Collapse")
public class CollapseClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(CollapseClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Collapse frontend module ... ");
		//new ModuleConfigurator().configureModule(new CollapseModuleConfiguration());
	}
}
