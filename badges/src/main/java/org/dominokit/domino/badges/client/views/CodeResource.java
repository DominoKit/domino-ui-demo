package org.dominokit.domino.badges.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("buttonExample.txt")
    ExternalTextResource buttonExample();

    @Source("buttonExamplesWithMaterialDesignColors.txt")
    ExternalTextResource buttonExamplesWithMaterialDesignColors();

    @Source("listExample.txt")
    ExternalTextResource listExample();

}

