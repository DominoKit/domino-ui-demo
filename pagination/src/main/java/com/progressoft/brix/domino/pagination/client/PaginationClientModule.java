package com.progressoft.brix.domino.pagination.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Pagination")
public class PaginationClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaginationClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Pagination frontend module ...");
		new ModuleConfigurator().configureModule(new PaginationModuleConfiguration());
	}
}
