package org.dominokit.domino.typography.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("bodyCopy.txt")
    ExternalTextResource bodyCopy();

    @Source("heading.txt")
    ExternalTextResource heading();

    @Source("textStyles.txt")
    ExternalTextResource textStyles();

    @Source("blockqoute.txt")
    ExternalTextResource blockqoute();

    @Source("lists.txt")
    ExternalTextResource lists();

    @Source("fontSizes.txt")
    ExternalTextResource fontSizes();
}

