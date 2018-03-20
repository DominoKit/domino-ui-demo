package org.dominokit.domino.layout.shared.extension;


import org.dominokit.domino.api.shared.extension.Context;

public interface LayoutContext extends Context {

    IsLayout getLayout();

    interface SelectionHandler{
        void onSelected();
    }

}
