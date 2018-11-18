package org.dominokit.domino.login.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Login")
public class LoginClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Login frontend module ...");
		//new ModuleConfigurator().configureModule(new LoginModuleConfiguration());
	}
}
