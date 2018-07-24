package org.dominokit.domino.components.shared.extension;


import org.dominokit.domino.api.shared.extension.EventContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;

public interface ComponentsContext extends EventContext {

    ComponentCaseContext getComponentCaseContext();

}
