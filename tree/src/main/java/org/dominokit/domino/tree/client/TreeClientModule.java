package org.dominokit.domino.tree.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Tree")
public class TreeClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(TreeClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing MenuSample frontend module ...");
		//new ModuleConfigurator().configureModule(new TreeModuleConfiguration());
	}
}
