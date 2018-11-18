package org.dominokit.domino.notifications.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Notifications")
public class NotificationsClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(NotificationsClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Notifications frontend module ...");
		//new ModuleConfigurator().configureModule(new NotificationsModuleConfiguration());
	}
}
