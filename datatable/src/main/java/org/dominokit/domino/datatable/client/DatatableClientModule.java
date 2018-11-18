package org.dominokit.domino.datatable.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Datatable")
public class DatatableClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatatableClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Datatable frontend module ...");
		//new ModuleConfigurator().configureModule(new DatatableModuleConfiguration());
	}
}
