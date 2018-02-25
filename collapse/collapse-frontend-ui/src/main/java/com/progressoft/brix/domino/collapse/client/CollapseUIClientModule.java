package com.progressoft.brix.domino.collapse.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="CollapseUI")
public class CollapseUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(CollapseUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Collapse frontend UI module ... ");
		new ModuleConfigurator().configureModule(new CollapseUIModuleConfiguration());
	}
}
