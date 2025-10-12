package org.dominokit.domino.data.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="DataPro")
public class DataProClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataProClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Data pro frontend module ...");
		new ModuleConfigurator().configureModule(new DataProModuleConfiguration());
	}
}
