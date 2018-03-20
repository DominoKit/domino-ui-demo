package org.dominokit.domino.infobox.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("basicInfoBoxes.txt")
    ExternalTextResource basicInfoBoxes();

    @Source("hoverZoomEffect.txt")
    ExternalTextResource hoverZoomEffect();

    @Source("rightAligned.txt")
    ExternalTextResource rightAligned();
}

