package org.dominokit.domino.inputfields.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.forms.shared.extension.FormsContext;
import org.dominokit.domino.forms.shared.extension.FormsEvent;
import org.dominokit.domino.inputfields.client.views.InputFieldsView;

@Presenter
public class InputFieldsPresenter extends ViewBaseClientPresenter<InputFieldsView> {

    @ListenTo(event = FormsEvent.class)
    public void onFormsEvent(FormsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "input-fields";
            }

            @Override
            public String getMenuPath() {
                return "Forms/Input fields";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}