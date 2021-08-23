package org.dominokit.domino.datepicker.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="DatePicker")
public class DatePickerClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatePickerClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing DatePicker frontend module ...");
		new ModuleConfigurator().configureModule(new DatePickerModuleConfiguration());
	}
}
