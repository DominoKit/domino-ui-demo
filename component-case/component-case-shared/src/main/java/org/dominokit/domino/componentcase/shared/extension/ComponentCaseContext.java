package org.dominokit.domino.componentcase.shared.extension;


import org.dominokit.domino.api.shared.extension.EventContext;

public interface ComponentCaseContext extends EventContext {
    void addComponentCase(ComponentCase componentCase);
}
