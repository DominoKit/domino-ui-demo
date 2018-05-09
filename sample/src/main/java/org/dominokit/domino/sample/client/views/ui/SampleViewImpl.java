package org.dominokit.domino.sample.client.views.ui;

import org.dominokit.domino.sample.client.views.SampleView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.sample.client.presenters.SamplePresenter;

@UiView(presentable = SamplePresenter.class)
public class SampleViewImpl implements SampleView{

    public SampleViewImpl() {
    }
}