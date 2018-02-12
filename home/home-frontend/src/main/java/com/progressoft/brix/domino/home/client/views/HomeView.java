package com.progressoft.brix.domino.home.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface HomeView extends View{
    void showIn(Content content);
}