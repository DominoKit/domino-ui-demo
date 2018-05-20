package org.dominokit.domino.formsvalidations.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.forms.shared.extension.FormsContext;
import org.dominokit.domino.forms.shared.extension.FormsExtensionPoint;
import org.dominokit.domino.formsvalidations.client.views.FormsValidationsView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class FormsValidationsPresenter extends BaseClientPresenter<FormsValidationsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FormsValidationsPresenter.class);

    @InjectContext(extensionPoint = FormsExtensionPoint.class)
    public void contributeToFormsModule(FormsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "forms-validations";
            }

            @Override
            public String getMenuPath() {
                return "Forms/Forms Validations";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}