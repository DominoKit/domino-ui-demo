package org.dominokit.domino.sliders.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("basic.txt")
    ExternalTextResource basic();

    @Source("example.txt")
    ExternalTextResource example();

    @Source("colors.txt")
    ExternalTextResource colors();
}
