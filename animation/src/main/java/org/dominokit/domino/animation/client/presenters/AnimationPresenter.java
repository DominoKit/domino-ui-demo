package org.dominokit.domino.animation.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.animation.client.views.AnimationView;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class AnimationPresenter extends ViewBaseClientPresenter<AnimationView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AnimationPresenter.class);

    @InjectContext(extensionPoint=ComponentCaseExtensionPoint.class)
    public void contributeToComponentCaseModule(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "animations";
            }

            @Override
            public String getMenuPath() {
                return "Animations";
            }

            @Override
            public String getIconName() {
                return "movie";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}