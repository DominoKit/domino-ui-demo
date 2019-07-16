package org.dominokit.domino.infobox.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.infobox.client.views.InfoBoxView;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;

@PresenterProxy
@AutoRoute(token = "components/infobox")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class InfoBoxProxy extends ComponentCasePresenter<InfoBoxView> {

    @OnReveal
    public void restartCounters(){
        view.restartCounters();
    }
}
