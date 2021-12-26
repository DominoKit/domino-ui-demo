package org.dominokit.domino.dropdown.client.views.ui.position;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.dropdown.client.views.ui.DropDown;

import static elemental2.dom.DomGlobal.console;
import static elemental2.dom.DomGlobal.window;

public class BestFitSideDropDirection implements DropDown.ElementPosition {

    private DropDown.ElementPosition currentPosition;
    @Override
    public void position(HTMLElement source, HTMLElement target) {

        DOMRect targetRect = target.getBoundingClientRect();
        DOMRect sourceRect = source.getBoundingClientRect();
        int innerWidth = window.innerWidth;
        int innerHeight = window.innerHeight;

        double sourceWidth = sourceRect.width;
        double sourceHeight = sourceRect.height;
        double rightSpace = innerWidth - targetRect.right - window.pageXOffset;
        double downSpace = innerHeight - targetRect.height;

        if(hasSpaceOnRightSide(sourceWidth, rightSpace)){
            if(hasSpaceBelow(sourceHeight, downSpace)){
                currentPosition =  new RightDownDropDirection();
                console.info("RIGHT-DOWN");
            }else{
                currentPosition =  new RightUpDropDirection();
                console.info("RIGHT-UP");
            }
        }else {
            if(hasSpaceBelow(sourceHeight, downSpace)){
                currentPosition =  new LeftDownDropDirection();
                console.info("LEFT-DOWN");
            }else{
                currentPosition =  new LeftUpDropDirection();
                console.info("LEFT-UP");
            }
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
