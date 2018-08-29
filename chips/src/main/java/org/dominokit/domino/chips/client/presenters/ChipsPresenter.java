package org.dominokit.domino.chips.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.chips.client.views.ChipsView;
import org.dominokit.domino.api.shared.extension.MainDominoEvent;
import org.dominokit.domino.api.shared.extension.MainEventContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class ChipsPresenter extends ViewBaseClientPresenter<ChipsView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChipsPresenter.class);

    @ListenTo(event=ComponentCaseEvent.class)
    public void listenToCompnentCaseEvent(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "chips";
            }

            @Override
            public String getMenuPath() {
                return "Components/Chips";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}