package com.progressoft.brix.domino.breadcrumb.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface BreadcrumbView extends View{
    void showIn(Content content);
}