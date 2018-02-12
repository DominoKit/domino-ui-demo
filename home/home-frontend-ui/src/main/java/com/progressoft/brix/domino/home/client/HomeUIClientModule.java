package com.progressoft.brix.domino.home.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import me.rjb.client.SyntaxHighlighter;
import me.rjb.client.themes.Themes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="HomeUI")
public class HomeUIClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(HomeUIClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Home frontend UI module ...");
		new ModuleConfigurator().configureModule(new HomeUIModuleConfiguration());
	}
}
