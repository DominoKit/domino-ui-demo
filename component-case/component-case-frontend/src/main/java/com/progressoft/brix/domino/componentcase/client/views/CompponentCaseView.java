package com.progressoft.brix.domino.componentcase.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.layout.shared.extension.IsLayout;

public interface CompponentCaseView extends View{
    void init(IsLayout layout);
    void clear();

    void scrollTop();
}