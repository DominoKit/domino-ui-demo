package org.dominokit.domino.samples.client.views.ui;

import org.dominokit.domino.samples.client.views.SamplesView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.samples.client.presenters.SamplesPresenter;

@UiView(presentable = SamplesPresenter.class)
public class SamplesViewImpl implements SamplesView{

    public SamplesViewImpl() {
    }
}