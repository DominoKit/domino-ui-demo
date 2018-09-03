package org.dominokit.domino.layouts.shared.extension;


import org.dominokit.domino.api.shared.extension.EventContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;

public interface LayoutsEventContext extends EventContext {
    ComponentCaseContext getComponentCaseContext();
}
