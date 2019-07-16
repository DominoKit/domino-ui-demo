package org.dominokit.domino.mdiicons.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.api.client.mvp.StoreRegistry;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.mdiicons.client.views.MdiIconsView;

@PresenterProxy
@AutoRoute(token = "mdiicons")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
@Singleton
public class MdiIconsProxy extends ComponentCasePresenter<MdiIconsView> {

}