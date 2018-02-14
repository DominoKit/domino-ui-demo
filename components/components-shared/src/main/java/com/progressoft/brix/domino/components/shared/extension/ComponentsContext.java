package com.progressoft.brix.domino.components.shared.extension;


import com.progressoft.brix.domino.api.shared.extension.Context;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentCaseContext;

public interface ComponentsContext extends Context {

    ComponentCaseContext getComponentCaseContext();

}
