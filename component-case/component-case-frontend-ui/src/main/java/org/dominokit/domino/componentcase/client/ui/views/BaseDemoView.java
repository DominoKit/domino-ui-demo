package org.dominokit.domino.componentcase.client.ui.views;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.componentcase.client.presenters.DemoView;
import org.dominokit.domino.view.BaseElementView;

public abstract class BaseDemoView<T extends HTMLElement> extends BaseElementView<T> implements DemoView<DemoView.DemoViewUiHandlers> {

    protected DemoViewUiHandlers uiHandlers;

    @Override
    public void setUiHandlers(DemoViewUiHandlers uiHandlers) {
        this.uiHandlers = uiHandlers;
    }
}
