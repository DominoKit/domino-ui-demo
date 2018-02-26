package com.progressoft.brix.domino.collapse.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Collapse")
public class CollapseClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(CollapseClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Collapse frontend module ... ");
		new ModuleConfigurator().configureModule(new CollapseModuleConfiguration());
	}
}
