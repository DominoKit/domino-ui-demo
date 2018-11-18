package org.dominokit.domino.lists.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Lists")
public class ListsClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(ListsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Lists frontend module ... ");
		//new ModuleConfigurator().configureModule(new ListsModuleConfiguration());
	}
}
