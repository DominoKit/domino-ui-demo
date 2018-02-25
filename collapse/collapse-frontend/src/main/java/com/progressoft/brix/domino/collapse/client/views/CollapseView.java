package com.progressoft.brix.domino.collapse.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface CollapseView extends View{
    void showIn(Content content);
}