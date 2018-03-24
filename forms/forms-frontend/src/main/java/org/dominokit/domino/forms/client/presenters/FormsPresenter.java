package org.dominokit.domino.forms.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseExtensionPoint;
import org.dominokit.domino.forms.client.views.FormsView;
import org.dominokit.domino.forms.shared.extension.FormsExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class FormsPresenter extends BaseClientPresenter<FormsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormsPresenter.class);

    @InjectContext(extensionPoint = ComponentCaseExtensionPoint.class)
    public void contributeToMainModule(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "";
            }

            @Override
            public boolean hasContent() {
                return false;
            }

            @Override
            public String getMenuPath() {
                return "Forms";
            }

            @Override
            public String getIconName() {
                return "assignment";
            }
        });

        applyContributions(FormsExtensionPoint.class, () -> () -> context);
    }
}