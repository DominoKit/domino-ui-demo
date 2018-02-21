package com.progressoft.brix.domino.icons.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;
import com.progressoft.brix.domino.icons.client.ui.views.Bundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.progressoft.brix.domino.icons.client.ui.views.IconsBundle;

@ClientModule(name="IconsUI")
public class IconsUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(IconsUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Icons frontend UI module ...");
		Bundle.INSTANCE.style().ensureInjected();
		new ModuleConfigurator().configureModule(new IconsUIModuleConfiguration());
	}
}
