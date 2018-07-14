package org.dominokit.domino.datatable.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Datatable")
public class DatatableClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatatableClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Datatable frontend module ...");
		new ModuleConfigurator().configureModule(new DatatableModuleConfiguration());
	}
}
