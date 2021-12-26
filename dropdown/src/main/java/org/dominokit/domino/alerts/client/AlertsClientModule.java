package org.dominokit.domino.alerts.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Alerts")
public class AlertsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(AlertsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Alerts frontend module ...");
		new ModuleConfigurator().configureModule(new AlertsModuleConfiguration());
	}
}
