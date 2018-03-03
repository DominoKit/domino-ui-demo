package com.progressoft.brix.domino.pagination.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface PaginationView extends View{
    void showIn(Content content);
}