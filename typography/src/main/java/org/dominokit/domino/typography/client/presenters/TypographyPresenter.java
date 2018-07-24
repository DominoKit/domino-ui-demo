package org.dominokit.domino.typography.client.presenters;

import org.dominokit.domino.api.client.annotations.ListenTo;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseEvent;
import org.dominokit.domino.typography.client.views.TypographyView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class TypographyPresenter extends ViewBaseClientPresenter<TypographyView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypographyPresenter.class);

    @ListenTo(event=ComponentCaseEvent.class)
    public void onComponentCaseEvent(ComponentCaseContext context) {
        context.addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "typography";
            }

            @Override
            public String getMenuPath() {
                return "Typography";
            }

            @Override
            public String getIconName() {
                return "text_fields";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}