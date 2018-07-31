package org.dominokit.domino.steppers.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseEvent;
import org.dominokit.domino.forms.shared.extension.FormsContext;
import org.dominokit.domino.forms.shared.extension.FormsEvent;
import org.dominokit.domino.steppers.client.views.SteppersView;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.domino.api.shared.extension.MainEventContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class SteppersPresenter extends ViewBaseClientPresenter<SteppersView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(SteppersPresenter.class);

    @ListenTo(event = FormsEvent.class)
    public void onFormsReadyEvent(FormsContext formsContext){
        formsContext.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "steppers";
            }

            @Override
            public String getMenuPath() {
                return "Forms/Steppers";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}