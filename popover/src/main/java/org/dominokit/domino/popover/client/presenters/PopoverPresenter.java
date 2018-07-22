package org.dominokit.domino.popover.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.ViewBaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsExtensionPoint;
import org.dominokit.domino.popover.client.views.PopoverView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class PopoverPresenter extends ViewBaseClientPresenter<PopoverView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PopoverPresenter.class);

    @InjectContext(extensionPoint=ComponentsExtensionPoint.class)
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "components/tooltips-popover";
            }

            @Override
            public String getMenuPath() {
                return "Components/Tooltips & Popover";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}