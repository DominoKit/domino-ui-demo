package com.progressoft.brix.domino.animation.client;

import com.google.gwt.core.client.EntryPoint;
import com.progressoft.brix.domino.api.client.ModuleConfigurator;
import com.progressoft.brix.domino.api.client.annotations.ClientModule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Animation")
public class AnimationClientModule implements EntryPoint {

	private static final Logger LOGGER = LoggerFactory.getLogger(AnimationClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Animation frontend module ...");
		new ModuleConfigurator().configureModule(new AnimationModuleConfiguration());
	}
}
