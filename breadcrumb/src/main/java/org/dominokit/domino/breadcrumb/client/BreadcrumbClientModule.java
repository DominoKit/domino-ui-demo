package org.dominokit.domino.breadcrumb.client;


import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Breadcrumb")
public class BreadcrumbClientModule  {

	private static final Logger LOGGER = LoggerFactory.getLogger(BreadcrumbClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Breadcrumb frontend module ...");
		//new ModuleConfigurator().configureModule(new BreadcrumbModuleConfiguration());
	}
}
