package org.dominokit.domino.splitPanel.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="SplitPanel")
public class SplitPanelClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(SplitPanelClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing SplitPanel frontend module ...");
		//new ModuleConfigurator().configureModule(new SplitPanelModuleConfiguration());
	}
}
