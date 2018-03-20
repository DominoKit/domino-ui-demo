package org.dominokit.domino.labels.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("initLabels.txt")
    ExternalTextResource initLabels();

    @Source("initMaterialLabels.txt")
    ExternalTextResource initMaterialLabels();
}

