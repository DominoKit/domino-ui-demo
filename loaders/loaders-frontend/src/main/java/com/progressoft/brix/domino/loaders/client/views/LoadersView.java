package com.progressoft.brix.domino.loaders.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface LoadersView extends View{
    void showIn(Content content);
}