package com.progressoft.brix.domino.alerts.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface AlertsView extends View{
    void showIn(Content content);
}