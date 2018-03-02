package com.progressoft.brix.domino.lists.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("basicListsSample.txt")
    ExternalTextResource basicListsSample();

    @Source("selectableSample.txt")
    ExternalTextResource selectableSample();

    @Source("coloredSample.txt")
    ExternalTextResource coloredSample();

    @Source("richItems.txt")
    ExternalTextResource richItems();
}

