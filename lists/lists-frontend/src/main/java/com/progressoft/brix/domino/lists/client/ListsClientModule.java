package com.progressoft.brix.domino.lists.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Lists")
public class ListsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ListsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Lists frontend module ... ");
		new ModuleConfigurator().configureModule(new ListsModuleConfiguration());
	}
}
