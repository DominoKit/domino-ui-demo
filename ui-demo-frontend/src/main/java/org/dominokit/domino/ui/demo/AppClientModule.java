package org.dominokit.domino.ui.demo;

import com.google.gwt.core.client.EntryPoint;
import org.dominokit.domino.api.client.ClientApp;
import org.dominokit.domino.gwt.client.app.DominoGWT;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.utils.DominoUIConfig;
import org.dominokit.domino.ui.utils.ElementsFactoryDelegate;
import org.dominokit.domino.view.DominoViewOptions;

import java.util.logging.Logger;

import static org.dominokit.domino.ui.utils.DomElements.dom;

public class AppClientModule implements EntryPoint {

    private static final Logger LOGGER = Logger.getLogger(AppClientModule.class.getName());

    public void onModuleLoad() {
        DominoUIConfig.CONFIG.setElementsFactory(new ElementsFactoryDelegate() {
            @Override
            public AnchorElement a() {
                return new AnchorElement(dom.a())
                        .setAttribute("tabindex", "0")
                        .setAttribute("aria-expanded", "true");
            }
        });
        DominoGWT.init(DominoViewOptions.getInstance());
        DominoThemeManager.INSTANCE.applyUserThemes();
        ClientApp.make().run();
        LOGGER.info("ui-demo Application frontend have been initialized.");
    }
}
