package org.dominokit.domino.forms.client.ui.views;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.forms.client.presenters.FormsPresenter;
import org.dominokit.domino.forms.client.views.FormsView;

@UiView(presentable = FormsPresenter.class)
public class FormsViewImpl implements FormsView {

    @Override
    public Content getContent() {
        return null;
    }
}