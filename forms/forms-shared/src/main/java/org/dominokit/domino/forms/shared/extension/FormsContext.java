package org.dominokit.domino.forms.shared.extension;


import org.dominokit.domino.api.shared.extension.EventContext;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;

public interface FormsContext extends EventContext {
    ComponentCaseContext getComponentCaseContext();
}
