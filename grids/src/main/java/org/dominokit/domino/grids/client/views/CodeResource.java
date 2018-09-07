package org.dominokit.domino.grids.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("grid12Columns.txt")
    ExternalTextResource grid12Columns();

    @Source("grid16Columns.txt")
    ExternalTextResource grid16Columns();

    @Source("grid18Columns.txt")
    ExternalTextResource grid18Columns();

    @Source("grid24Columns.txt")
    ExternalTextResource grid24Columns();

    @Source("grid32Columns.txt")
    ExternalTextResource grid32Columns();

}
