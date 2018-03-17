package com.progressoft.brix.domino.popover.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("tooltips.txt")
    ExternalTextResource tooltips();

    @Source("popover.txt")
    ExternalTextResource popover();
}
