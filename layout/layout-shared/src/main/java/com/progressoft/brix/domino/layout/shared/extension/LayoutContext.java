package com.progressoft.brix.domino.layout.shared.extension;


import com.progressoft.brix.domino.api.shared.extension.Context;

public interface LayoutContext extends Context {

    IsLayout getLayout();

    interface SelectionHandler{
        void onSelected();
    }

}
