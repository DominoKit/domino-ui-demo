package com.progressoft.brix.domino.tabs.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface TabsView extends View{
    void showIn(Content content);
}