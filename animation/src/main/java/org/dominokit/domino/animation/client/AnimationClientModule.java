package org.dominokit.domino.animation.client;


import org.dominokit.domino.api.client.annotations.ClientModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ClientModule(name="Animation")
public class AnimationClientModule {

	private static final Logger LOGGER = LoggerFactory.getLogger(AnimationClientModule.class);

	public void onModuleLoad() {
		LOGGER.info("Initializing Animation frontend module ...");
		//new ModuleConfigurator().configureModule(new AnimationModuleConfiguration());
	}
}
