package com.progressoft.brix.domino.icons.client.ui.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.dom.client.Document;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.IsWidget;

import com.progressoft.brix.domino.api.client.annotations.UiView;

import com.progressoft.brix.domino.icons.client.presenters.IconsPresenter;
import com.progressoft.brix.domino.icons.client.views.IconsView;

@UiView(presentable = IconsPresenter.class)
public class DefaultIconsView extends Composite implements IconsView{

    interface DefaultIconsViewUiBinder extends UiBinder<HTMLPanel, DefaultIconsView> {
    }

    private static DefaultIconsViewUiBinder ourUiBinder = GWT.create(DefaultIconsViewUiBinder.class);

    @UiField
    DivElement mainDiv;

    public DefaultIconsView() {
        initWidget(ourUiBinder.createAndBindUi(this));
        mainDiv.setInnerHTML("<h1>Hello world!</h1>");
        Document.get().getBody().appendChild(mainDiv);
    }
}