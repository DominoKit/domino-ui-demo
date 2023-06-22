package org.dominokit.domino.dnd.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Dnd")
public class DndClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(DndClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Dnd frontend module ...");
		new ModuleConfigurator().configureModule(new DndModuleConfiguration());
	}
}
