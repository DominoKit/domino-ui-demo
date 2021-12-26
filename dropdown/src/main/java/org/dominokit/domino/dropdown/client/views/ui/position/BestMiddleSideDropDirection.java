package org.dominokit.domino.dropdown.client.views.ui.position;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.dropdown.client.views.ui.DropDown;

import static elemental2.dom.DomGlobal.window;

public class BestMiddleSideDropDirection implements DropDown.ElementPosition {

    private DropDown.ElementPosition currentPosition;

    @Override
    public void position(HTMLElement source, HTMLElement target) {

        DOMRect targetRect = target.getBoundingClientRect();
        DOMRect sourceRect = source.getBoundingClientRect();
        int innerWidth = window.innerWidth;

        double sourceWidth = sourceRect.width;
        double rightSpace = innerWidth - targetRect.right - window.pageXOffset;

        if (hasSpaceOnRightSide(sourceWidth, rightSpace)) {
            currentPosition = new RightMiddleDropDirection();
        } else {
            currentPosition = new LeftMiddleDropDirection();
        }
        currentPosition.position(source, target);
    }

    private boolean hasSpaceOnRightSide(double sourceWidth, double rightSpace) {
        return rightSpace > sourceWidth;
    }
}
