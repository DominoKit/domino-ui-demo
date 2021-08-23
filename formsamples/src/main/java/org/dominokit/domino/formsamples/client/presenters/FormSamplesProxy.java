package org.dominokit.domino.formsamples.client.presenters;

import org.dominokit.domino.api.client.annotations.presenter.AutoReveal;
import org.dominokit.domino.api.client.annotations.presenter.AutoRoute;
import org.dominokit.domino.api.client.annotations.presenter.DependsOn;
import org.dominokit.domino.api.client.annotations.presenter.EventsGroup;
import org.dominokit.domino.api.client.annotations.presenter.PresenterProxy;
import org.dominokit.domino.api.client.annotations.presenter.Slot;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.formsamples.client.views.FormSamplesView;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;
import org.dominokit.domino.layout.shared.extension.IsLayout;
import org.dominokit.domino.layout.shared.extension.LayoutEvent;

@PresenterProxy
@AutoRoute(token = "forms/form-sample")
@AutoReveal
@Slot(IsLayout.Slots.CONTENT)
@DependsOn(@EventsGroup(LayoutEvent.class))
public class FormSamplesProxy extends ComponentCasePresenter<FormSamplesView> implements FormSamplesView.FormSamplesUIHandlers {

    @Override
    public void onCreate(LetterOfCredit letterOfCredit) {

    }
}