package org.dominokit.domino.helpers.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;
import org.dominokit.domino.helpers.client.views.HelpersView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class HelpersPresenter extends BaseClientPresenter<HelpersView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelpersPresenter.class);

    @InjectContext(extensionPoint=ComponentCaseExtensionPoint.class)
    public void contributeToComponentCaseModule(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "helpers";
            }

            @Override
            public String getMenuPath() {
                return "Helper classes";
            }

            @Override
            public String getIconName() {
                return "layers";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}