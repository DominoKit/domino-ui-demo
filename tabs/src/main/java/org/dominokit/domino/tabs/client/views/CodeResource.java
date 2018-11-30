package org.dominokit.domino.tabs.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("basicSample.txt")
    ExternalTextResource basicSample();

    @Source("iconsOnly.txt")
    ExternalTextResource iconsOnly();

    @Source("withIconsAndTextSamlple.txt")
    ExternalTextResource withIconsAndTextSamlple();

    @Source("materialDesignColorsSample.txt")
    ExternalTextResource materialDesignColorsSample();

    @Source("materialDesignBackgroundsSample.txt")
    ExternalTextResource materialDesignBackgroundsSample();

    @Source("withAnimation.txt")
    ExternalTextResource withAnimation();

    @Source("differentContentContainerSample.txt")
    ExternalTextResource differentContentContainerSample();

    @Source("verticalTabs.txt")
    ExternalTextResource verticalTabs();

}
