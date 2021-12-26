package org.dominokit.domino.dropdown.client.views.ui.position;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.dropdown.client.views.ui.DropDown;

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

public class RightDownDropDirection implements DropDown.ElementPosition {
    @Override
    public void position(HTMLElement source, HTMLElement target) {
        DOMRect targetRect = target.getBoundingClientRect();
        DOMRect sourceRect = source.getBoundingClientRect();

        double delta = 0;
        double availableSpace = window.innerHeight - targetRect.top;
        if(availableSpace < sourceRect.height){
            delta=sourceRect.height - availableSpace;
        }

        source.style.setProperty(
                "top", px.of((targetRect.top + window.pageYOffset - delta)));

        source.style.setProperty(
                "left", px.of(targetRect.left + window.pageXOffset + targetRect.width + 1));
    }
}
