package org.dominokit.domino.progress.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("basicSample.txt")
    ExternalTextResource basicSample();

    @Source("contextualAlternatives.txt")
    ExternalTextResource contextualAlternatives();

    @Source("stripedSample.txt")
    ExternalTextResource stripedSample();

    @Source("animatedSample.txt")
    ExternalTextResource animatedSample();

    @Source("stackedSample.txt")
    ExternalTextResource stackedSample();

    @Source("materialDesignColors.txt")
    ExternalTextResource materialDesignColors();

}
