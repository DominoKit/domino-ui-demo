package org.dominokit.domino.progress.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsExtensionPoint;
import org.dominokit.domino.progress.client.views.ProgressView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class ProgressPresenter extends ViewBaseClientPresenter<ProgressView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProgressPresenter.class);

    @InjectContext(extensionPoint=ComponentsExtensionPoint.class)
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/progress";
            }

            @Override
            public String getMenuPath() {
                return "Components/Progress bars";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }

            @Override
            public ComponentRevealedHandler onComponentRevealed() {
                return view.restartProgress();
            }
        });
    }
}