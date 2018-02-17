package com.progressoft.brix.domino.alerts.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="AlertsUI")
public class AlertsUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlertsUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Alerts frontend UI module ...");
		new ModuleConfigurator().configureModule(new AlertsUIModuleConfiguration());
	}
}
