package com.progressoft.brix.domino.preloaders.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("sizesSample.txt")
    ExternalTextResource sizesSample();

    @Source("colorsSample.txt")
    ExternalTextResource colorsSample();
}
