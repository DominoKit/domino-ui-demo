package org.dominokit.domino.flexlayout.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("layoutPlayground.txt")
    ExternalTextResource layoutPlayground();

    @Source("flexItems.txt")
    ExternalTextResource flexItems();
}
