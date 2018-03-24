package org.dominokit.domino.basicforms.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.basicforms.client.views.BasicFormsView;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.forms.shared.extension.FormsContext;
import org.dominokit.domino.forms.shared.extension.FormsExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class BasicFormsPresenter extends BaseClientPresenter<BasicFormsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicFormsPresenter.class);

    @InjectContext(extensionPoint = FormsExtensionPoint.class)
    public void contributeToMainModule(FormsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "basic-form-elements";
            }

            @Override
            public String getMenuPath() {
                return "Forms/Basic Form Elements";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}