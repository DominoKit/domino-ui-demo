package org.dominokit.domino.dropdown.client.views.ui.position;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.dropdown.client.views.ui.DropDown;

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

public class LeftMiddleDropDirection implements DropDown.ElementPosition {
    @Override
    public void position(HTMLElement source, HTMLElement target) {
        DOMRect targetRect = target.getBoundingClientRect();
        DOMRect sourceRect = source.getBoundingClientRect();

        double delta = 0;
        double availableBelowSpace = window.innerHeight - targetRect.top;
        if (availableBelowSpace < (sourceRect.height/2)) {
            delta = ((sourceRect.height/2) - availableBelowSpace)*-1;
        }

        double availableUpSpace = targetRect.top - window.pageYOffset;
        if (availableUpSpace < (sourceRect.height/2)) {
            delta = ((sourceRect.height/2) - availableUpSpace);
        }

        source.style.setProperty(
                "top", px.of(targetRect.top + window.pageYOffset - ((sourceRect.height - targetRect.height) / 2) + delta));

        source.style.setProperty(
                "left", px.of(targetRect.left + window.pageXOffset - sourceRect.width - 1));
    }
}
