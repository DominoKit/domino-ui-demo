package org.dominokit.domino.modals.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("initModalsSize.txt")
    ExternalTextResource initModalsSize();

    @Source("initModalColor.txt")
    ExternalTextResource initModalColor();

    @Source("sheetModals.txt")
    ExternalTextResource sheetModals();
}

