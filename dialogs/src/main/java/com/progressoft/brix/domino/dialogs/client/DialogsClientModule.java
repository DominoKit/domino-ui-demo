package com.progressoft.brix.domino.dialogs.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Dialogs")
public class DialogsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(DialogsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Dialogs frontend module ...");
		new ModuleConfigurator().configureModule(new DialogsModuleConfiguration());
	}
}
