package org.dominokit.domino.dropdown.client.views.ui.position;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.dropdown.client.views.ui.DropDown;

import static elemental2.dom.DomGlobal.console;
import static elemental2.dom.DomGlobal.window;

public class BestMiddleUpDownDropDirection implements DropDown.ElementPosition {

    private DropDown.ElementPosition currentPosition;
    @Override
    public void position(HTMLElement source, HTMLElement target) {

        DOMRect targetRect = target.getBoundingClientRect();
        DOMRect sourceRect = source.getBoundingClientRect();
        int innerHeight = window.innerHeight;

        double sourceHeight = sourceRect.height;
        double downSpace = innerHeight - targetRect.height;

            if(hasSpaceBelow(sourceHeight, downSpace)){
                currentPosition =  new BottomMiddleDropDirection();
            }else{
                currentPosition =  new TopMiddleDropDirection();
            }

        currentPosition.position(source, target);
    }

    private boolean hasSpaceBelow(double sourceHeight, double downSpace) {
        return downSpace > sourceHeight;
    }

    private boolean hasSpaceOnRightSide(double sourceWidth, double rightSpace) {
        return rightSpace > sourceWidth;
    }
}
