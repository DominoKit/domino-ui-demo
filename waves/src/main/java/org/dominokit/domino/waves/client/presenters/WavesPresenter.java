package org.dominokit.domino.waves.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsEvent;
import org.dominokit.domino.waves.client.views.WavesView;

@Presenter
public class WavesPresenter extends ViewBaseClientPresenter<WavesView> {

    @ListenTo(event=ComponentsEvent.class)
    public void onComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/waves";
            }

            @Override
            public String getMenuPath() {
                return "Components/Waves";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}