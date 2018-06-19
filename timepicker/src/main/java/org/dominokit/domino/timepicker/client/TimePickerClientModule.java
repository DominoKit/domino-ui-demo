package org.dominokit.domino.timepicker.client;


import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="TimePicker")
public class TimePickerClientModule  {

	private static final Logger LOGGER = LoggerFactory.getLogger(TimePickerClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing TimePicker frontend module ...");
		//new ModuleConfigurator().configureModule(new TimePickerModuleConfiguration());
	}
}
