package com.progressoft.brix.domino.preloaders.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface PreloadersView extends View{
    void showIn(Content content);
}