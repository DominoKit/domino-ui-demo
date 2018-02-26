package com.progressoft.brix.domino.badges.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface BadgesView extends View{
    void showIn(Content content);
}