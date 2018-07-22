package org.dominokit.domino.infobox.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsExtensionPoint;
import org.dominokit.domino.infobox.client.views.InfoBoxView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class InfoBoxPresenter extends ViewBaseClientPresenter<InfoBoxView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(InfoBoxPresenter.class);

    @InjectContext(extensionPoint= ComponentsExtensionPoint.class)
    public void contributeToComponentModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/infobox";
            }

            @Override
            public String getMenuPath() {
                return "Components/Info box";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }

            @Override
            public ComponentRevealedHandler onComponentRevealed() {
                return () -> view.restartCounters();
            }
        });
    }
}
