package org.dominokit.domino.colorpicker.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="ColorPicker")
public class ColorPickerClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(ColorPickerClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Color Picker frontend module ...");
		new ModuleConfigurator().configureModule(new ColorPickerModuleConfiguration());
	}
}
