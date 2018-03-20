package org.dominokit.domino.breadcrumb.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("basicBreadcrumb.txt")
    ExternalTextResource basicBreadcrumb();

    @Source("breadcrumbWithBackground.txt")
    ExternalTextResource breadcrumbWithBackground();

    @Source("coloredBreadcrumb.txt")
    ExternalTextResource coloredBreadcrumb();

    @Source("alignment.txt")
    ExternalTextResource alignment();

}

