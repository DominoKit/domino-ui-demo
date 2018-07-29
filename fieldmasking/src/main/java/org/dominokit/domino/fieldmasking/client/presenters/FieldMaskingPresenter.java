package org.dominokit.domino.fieldmasking.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.fieldmasking.client.views.FieldMaskingView;
import org.dominokit.domino.forms.shared.extension.FormsContext;
import org.dominokit.domino.forms.shared.extension.FormsExtensionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class FieldMaskingPresenter extends BaseClientPresenter<FieldMaskingView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(FieldMaskingPresenter.class);

    @InjectContext(extensionPoint = FormsExtensionPoint.class)
    public void contributeToFormsModule(FormsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "fields-masking";
            }

            @Override
            public String getMenuPath() {
                return "Forms/Field Masking";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}