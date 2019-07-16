package org.dominokit.domino.layout.shared.extension;

import org.dominokit.domino.api.shared.extension.ActivationEvent;

public class LayoutEvent extends ActivationEvent {
    public LayoutEvent(boolean active) {
        super(active);
    }
}
