package org.dominokit.domino.thumbnails.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("basicSample.txt")
    ExternalTextResource basicSample();

    @Source("withExtraContentSample.txt")
    ExternalTextResource withExtraContentSample();

}
