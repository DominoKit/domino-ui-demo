package com.progressoft.brix.domino.progress.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface ProgressView extends View{
    void showIn(Content content);
}