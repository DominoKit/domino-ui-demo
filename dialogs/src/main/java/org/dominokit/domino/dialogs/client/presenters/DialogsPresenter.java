package org.dominokit.domino.dialogs.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsExtensionPoint;
import org.dominokit.domino.dialogs.client.views.DialogsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class DialogsPresenter extends BaseClientPresenter<DialogsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DialogsPresenter.class);

    @InjectContext(extensionPoint=ComponentsExtensionPoint.class)
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/dialogs";
            }

            @Override
            public String getMenuPath() {
                return "Components/Dialogs";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}