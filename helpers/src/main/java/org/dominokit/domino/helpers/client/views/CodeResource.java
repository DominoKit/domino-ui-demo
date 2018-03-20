package org.dominokit.domino.helpers.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("textStyles.txt")
    ExternalTextResource textStyles();

    @Source("fontSize.txt")
    ExternalTextResource fontSize();

    @Source("textAligns.txt")
    ExternalTextResource textAligns();
}

