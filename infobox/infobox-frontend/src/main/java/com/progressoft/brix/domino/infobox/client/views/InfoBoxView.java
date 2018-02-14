package com.progressoft.brix.domino.infobox.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface InfoBoxView extends View{
    void showIn(Content content);
}