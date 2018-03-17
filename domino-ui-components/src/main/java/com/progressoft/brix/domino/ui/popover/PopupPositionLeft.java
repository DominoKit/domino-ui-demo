package com.progressoft.brix.domino.ui.popover;

import elemental2.dom.ClientRect;
import elemental2.dom.HTMLElement;

public class PopupPositionLeft implements PopupPosition {
    @Override
    public void position(HTMLElement tooltip, HTMLElement target) {
        ClientRect targetRect = target.getBoundingClientRect();
        ClientRect tooltipRect = tooltip.getBoundingClientRect();
        tooltip.style.setProperty("top", targetRect.top+((targetRect.height-tooltipRect.height)/2)+"px");
        tooltip.style.setProperty("left", targetRect.left-tooltipRect.width+"px");
    }

    @Override
    public String getDirectionClass() {
        return "left";
    }
}
