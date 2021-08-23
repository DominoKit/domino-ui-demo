package org.dominokit.domino.timepicker.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="TimePicker")
public class TimePickerClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(TimePickerClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing TimePicker frontend module ...");
		new ModuleConfigurator().configureModule(new TimePickerModuleConfiguration());
	}
}
