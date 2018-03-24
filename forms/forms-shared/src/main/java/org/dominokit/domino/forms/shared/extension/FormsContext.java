package org.dominokit.domino.forms.shared.extension;


import org.dominokit.domino.api.shared.extension.Context;
import org.dominokit.domino.componentcase.shared.extension.ComponentCaseContext;

public interface FormsContext extends Context {
    ComponentCaseContext getComponentCaseContext();
}
