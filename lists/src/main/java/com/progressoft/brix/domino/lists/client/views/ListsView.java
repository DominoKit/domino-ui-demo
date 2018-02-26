package com.progressoft.brix.domino.lists.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface ListsView extends View{
    void showIn(Content content);
}