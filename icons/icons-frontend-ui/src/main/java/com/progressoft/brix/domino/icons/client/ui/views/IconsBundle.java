package com.progressoft.brix.domino.icons.client.ui.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.ImageResource;

public interface IconsBundle extends ClientBundle{

    interface Style extends CssResource {
        String Icons();
    }

    @Source("css/Icons.gss")
    Style style();
}