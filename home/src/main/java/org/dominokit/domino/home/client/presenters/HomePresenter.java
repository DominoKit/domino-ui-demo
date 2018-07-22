package org.dominokit.domino.home.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;
import org.dominokit.domino.home.client.views.HomeView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class HomePresenter extends ViewBaseClientPresenter<HomeView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HomePresenter.class);

    @InjectContext(extensionPoint=ComponentCaseExtensionPoint.class)
    public void contributeToDemoPageModule(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "home";
            }

            @Override
            public String getMenuPath() {
                return "Home";
            }

            @Override
            public String getIconName() {
                return "home";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}