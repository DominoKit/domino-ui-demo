package com.progressoft.brix.domino.breadcrumb.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="BreadcrumbUI")
public class BreadcrumbUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(BreadcrumbUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Breadcrumb frontend UI module ...");
		new ModuleConfigurator().configureModule(new BreadcrumbUIModuleConfiguration());
	}
}
