package org.dominokit.domino.basicforms.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.basicforms.client.views.BasicFormsView;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.forms.shared.extension.FormsContext;
import org.dominokit.domino.forms.shared.extension.FormsEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class BasicFormsPresenter extends ViewBaseClientPresenter<BasicFormsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(BasicFormsPresenter.class);

    @ListenTo(event = FormsEvent.class)
    public void onMainEvent(FormsContext context) {
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