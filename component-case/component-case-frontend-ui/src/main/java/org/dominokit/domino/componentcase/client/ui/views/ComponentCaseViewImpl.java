package org.dominokit.domino.componentcase.client.ui.views;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.shared.extension.Content;
import org.dominokit.domino.componentcase.client.presenters.ComponentCasePresenter;
import org.dominokit.domino.componentcase.client.views.ComponentCaseView;
import org.dominokit.domino.layout.shared.extension.IsLayout;

import static java.util.Objects.nonNull;

@UiView(presentable = ComponentCasePresenter.class)
public class ComponentCaseViewImpl implements ComponentCaseView {


    private HTMLElement contentPanel;
    private Content content;

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

    @Override
    public void showContent(Content content) {
        this.content = content;
        if(nonNull(content))
            contentPanel.appendChild(Js.cast(content.get()));
    }

    @Override
    public Content getContent() {
        return content;
    }
}