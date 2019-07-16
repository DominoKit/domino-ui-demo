package org.dominokit.domino.formsamples.client.views;

import org.dominokit.domino.api.client.mvp.view.ContentView;
import org.dominokit.domino.api.client.mvp.view.HasUiHandlers;
import org.dominokit.domino.componentcase.client.presenters.DemoView;
import org.dominokit.domino.formsamples.shared.model.LetterOfCredit;

public interface FormSamplesView extends ContentView , HasUiHandlers<FormSamplesView.FormSamplesUIHandlers> {

    void onSuccessCreate(String bodyAsString);

    void onErrorCreate(String errorMessage);


    interface FormSamplesUIHandlers extends DemoView.DemoViewUiHandlers {
        void onCreate(LetterOfCredit letterOfCredit);
    }
}