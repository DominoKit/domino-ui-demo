package org.dominokit.domino.formsamples.client.views;

import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.api.client.mvp.view.UiHandlers;
import org.dominokit.domino.api.client.mvp.view.View;
import org.dominokit.domino.componentcase.shared.extension.DemoView;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;

public interface FormSamplesView extends View, DemoView, HasUiHandlers<FormSamplesView.FormSamplesUIHandlers> {

    void onSuccessCreate(String bodyAsString);

    void onErrorCreate(String errorMessage);

    interface FormSamplesUIHandlers extends UiHandlers {
        void onCreate(LetterOfCredit letterOfCredit);
    }
}