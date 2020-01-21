package org.dominokit.domino.uidemoserver.client.ui.views;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.view.BaseElementView;

import org.dominokit.domino.api.client.annotations.UiView;

import org.dominokit.domino.uidemoserver.client.presenters.UiDemoServerProxy;
import org.dominokit.domino.uidemoserver.client.views.UiDemoServerView;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.h;

@UiView(presentable = UiDemoServerProxy.class)
public class UiDemoServerViewImpl extends BaseElementView<HTMLDivElement> implements UiDemoServerView{

    @Override
    public HTMLDivElement init() {
        return div().add(h(1).textContent("Hello World! from module : UiDemoServer").element()).element();
    }

}