package org.dominokit.domino.notifications.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Notifications")
public class NotificationsClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Notifications frontend module ...");
		new ModuleConfigurator().configureModule(new NotificationsModuleConfiguration());
	}
}
