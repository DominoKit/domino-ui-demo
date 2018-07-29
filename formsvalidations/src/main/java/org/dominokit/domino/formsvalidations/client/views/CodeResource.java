package org.dominokit.domino.formsvalidations.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("helper-text.txt")
    ExternalTextResource helperText();

    @Source("addons.txt")
    ExternalTextResource addons();

    @Source("word-count.txt")
    ExternalTextResource wordCount();

    @Source("validations.txt")
    ExternalTextResource validations();

    @Source("read-only.txt")
    ExternalTextResource readOnly();
}
