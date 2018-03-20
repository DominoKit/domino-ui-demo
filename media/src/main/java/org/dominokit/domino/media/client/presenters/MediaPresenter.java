package org.dominokit.domino.media.client.presenters;

import org.dominokit.domino.api.client.annotations.InjectContext;
import org.dominokit.domino.api.client.annotations.Presenter;
import org.dominokit.domino.api.client.mvp.presenter.BaseClientPresenter;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.shared.extension.ComponentCase;
import org.dominokit.domino.components.shared.extension.ComponentsContext;
import org.dominokit.domino.components.shared.extension.ComponentsExtensionPoint;
import org.dominokit.domino.media.client.views.MediaView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Presenter
public class MediaPresenter extends BaseClientPresenter<MediaView> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MediaPresenter.class);

    @InjectContext(extensionPoint=ComponentsExtensionPoint.class)
    public void contributeToComponentsModule(ComponentsContext context) {
        context.getComponentCaseContext().addComponentCase(new ComponentCase() {
            @Override
            public String getHistoryToken() {
                return "component/media";
            }

            @Override
            public String getMenuPath() {
                return "Components/Media Objects";
            }

            @Override
            public Content getContent() {
                return view.getContent();
            }
        });
    }
}