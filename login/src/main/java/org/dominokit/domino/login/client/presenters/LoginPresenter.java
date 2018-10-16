package org.dominokit.domino.login.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseEvent;
import org.dominokit.domino.forms.shared.extension.FormsContext;
import org.dominokit.domino.forms.shared.extension.FormsEvent;
import org.dominokit.domino.login.client.views.LoginView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class LoginPresenter extends ViewBaseClientPresenter<LoginView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginPresenter.class);

    @ListenTo(event = FormsEvent.class)
    public void listenToFormsEvent(FormsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "login";
            }

            @Override
            public String getMenuPath() {
                return "Forms/Login samples";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}