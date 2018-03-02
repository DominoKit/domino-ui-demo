package com.progressoft.brix.domino.media.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface MediaView extends View{
    void showIn(Content content);
}