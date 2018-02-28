package com.progressoft.brix.domino.animation.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface AnimationView extends View{
    void showIn(Content content);
}