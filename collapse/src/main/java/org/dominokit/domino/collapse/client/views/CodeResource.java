package org.dominokit.domino.collapse.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("example.txt")
    ExternalTextResource example();

    @Source("accordionSample.txt")
    ExternalTextResource accordionSample();

    @Source("colorFullWithIcons.txt")
    ExternalTextResource colorFullWithIcons();

    @Source("multiOpenItems.txt")
    ExternalTextResource multiOpenItems();
}

