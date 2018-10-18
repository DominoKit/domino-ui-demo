package org.dominokit.domino.pagination.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("defaultPagination.txt")
    ExternalTextResource defaultPagination();

    @Source("activePageSample.txt")
    ExternalTextResource activePageSample();

    @Source("sizesSample.txt")
    ExternalTextResource sizesSample();

    @Source("pagerSample.txt")
    ExternalTextResource pagerSample();

    @Source("scrollingPagination.txt")
    ExternalTextResource scrollingPagination();

    @Source("advancedPagination.txt")
    ExternalTextResource advancedPagination();
}
