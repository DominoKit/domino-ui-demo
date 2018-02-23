package com.progressoft.brix.domino.componentcase.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.componentcase.client.presenters.ComponentCasePresenter;
import com.progressoft.brix.domino.componentcase.client.views.ComponentCaseView;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

@UiView(presentable = ComponentCasePresenter.class)
public class ComponentCaseViewImpl implements ComponentCaseView {


    private HTMLElement contentPanel;

    public ComponentCaseViewImpl() {
    }

    @Override
    public void init(IsLayout layout) {
        contentPanel = Js.cast(layout.getContentPanel().get());
    }

    @Override
    public void clear() {
        contentPanel.textContent = "";
    }

    @Override
    public void scrollTop() {
        DomGlobal.document.body.scrollTop = 0;
        DomGlobal.document.documentElement.scrollTop = 0;
    }
}