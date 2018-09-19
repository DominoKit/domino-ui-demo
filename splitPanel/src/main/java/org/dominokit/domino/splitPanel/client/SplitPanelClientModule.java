package org.dominokit.domino.splitPanel.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="SplitPanel")
public class SplitPanelClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(SplitPanelClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing SplitPanel frontend module ...");
		new ModuleConfigurator().configureModule(new SplitPanelModuleConfiguration());
	}
}
