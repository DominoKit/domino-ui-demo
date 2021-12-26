package org.dominokit.domino.dropdown.client.views.ui.position;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.dropdown.client.views.ui.DropDown;

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

public class MiddleOfScreenDropDirection implements DropDown.ElementPosition {
    @Override
    public void position(HTMLElement source, HTMLElement target) {
        DOMRect sourceRect = source.getBoundingClientRect();

        source.style.setProperty(
                "top", px.of((window.innerHeight - sourceRect.height) / 2));
        source.style.setProperty(
                "left",
                px.of((window.innerWidth - sourceRect.width) / 2));
    }
}
