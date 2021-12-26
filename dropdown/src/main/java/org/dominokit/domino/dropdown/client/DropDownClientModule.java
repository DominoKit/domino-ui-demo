package org.dominokit.domino.dropdown.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Dropdown")
public class DropDownClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(DropDownClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing DropDown frontend module ...");
		new ModuleConfigurator().configureModule(new DropdownModuleConfiguration());
	}
}
