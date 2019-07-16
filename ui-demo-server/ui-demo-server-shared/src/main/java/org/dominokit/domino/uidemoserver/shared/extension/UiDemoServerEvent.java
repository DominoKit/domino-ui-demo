package org.dominokit.domino.uidemoserver.shared.extension;

import org.dominokit.domino.api.shared.extension.ActivationEvent;

public class UiDemoServerEvent extends ActivationEvent {
    public UiDemoServerEvent(boolean state) {
        super(state);
    }
}
