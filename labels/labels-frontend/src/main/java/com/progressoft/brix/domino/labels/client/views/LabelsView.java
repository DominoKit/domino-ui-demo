package com.progressoft.brix.domino.labels.client.views;

import com.progressoft.brix.domino.api.client.mvp.view.View;
import com.progressoft.brix.domino.api.shared.extension.Content;

public interface LabelsView extends View{
    void showIn(Content content);
}