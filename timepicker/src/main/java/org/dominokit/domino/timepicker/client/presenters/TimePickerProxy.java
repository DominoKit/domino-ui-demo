package org.dominokit.domino.timepicker.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.*;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;
import org.dominokit.domino.timepicker.client.views.TimePickerView;

@PresenterProxy
@AutoRoute(token = "forms/timepicker")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class TimePickerProxy extends ComponentCasePresenter<TimePickerView> {
}