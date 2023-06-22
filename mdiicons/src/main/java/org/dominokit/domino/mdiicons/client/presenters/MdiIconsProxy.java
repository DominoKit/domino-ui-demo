package org.dominokit.domino.mdiicons.client.presenters;

import elemental2.core.Global;
import org.dominokit.domino.api.client.annotations.presenter.AutoReveal;
import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.DependsOn;
import org.dominokit.domino.api.client.annotations.presenter.EventsGroup;
import org.dominokit.domino.api.client.annotations.presenter.OnReveal;
import org.dominokit.domino.api.client.annotations.presenter.PathParameter;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.domino.api.client.annotations.presenter.Singleton;
import org.dominokit.domino.api.client.annotations.presenter.Slot;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.mdiicons.client.views.MdiIconsView;

@PresenterProxy
@AutoRoute(token = "mdiicons/:tag", reRouteActivated = true)
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class MdiIconsProxy extends ComponentCasePresenter<MdiIconsView> {

    @PathParameter
    String tag;

    @OnReveal
    public void loadIconsByTag(){
        view.loadIconsByTag(Global.decodeURI(tag).replace("--", "/"));
    }

}