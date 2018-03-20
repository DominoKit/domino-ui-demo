package org.dominokit.domino.animation.client;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ModuleConfigurator;
import org.dominokit.domino.api.client.annotations.ClientModule;

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
