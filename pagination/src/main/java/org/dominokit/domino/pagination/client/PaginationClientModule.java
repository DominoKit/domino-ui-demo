package org.dominokit.domino.pagination.client;


import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Pagination")
public class PaginationClientModule  {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaginationClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Pagination frontend module ...");
		//new ModuleConfigurator().configureModule(new PaginationModuleConfiguration());
	}
}
