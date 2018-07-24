package org.dominokit.domino.layout.shared.extension;


import org.dominokit.domino.api.shared.extension.EventContext;

public interface LayoutContext extends EventContext {

    IsLayout getLayout();

    interface SelectionHandler{
        void onSelected();
    }

}
