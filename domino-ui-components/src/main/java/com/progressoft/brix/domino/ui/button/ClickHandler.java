package com.progressoft.brix.domino.ui.button;

import elemental2.dom.Event;

@FunctionalInterface
public interface ClickHandler {
    void onClick(Event event);
}
