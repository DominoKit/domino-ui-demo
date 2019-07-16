package org.dominokit.domino.advancedforms.client.presenters;

import org.dominokit.domino.advancedforms.client.views.AdvancedFormsView;
import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;

@PresenterProxy
@AutoRoute(token = "forms/advanced-form-elements")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup({LayoutEvent.class}))
public class AdvancedFormsProxy extends ComponentCasePresenter<AdvancedFormsView> {
}