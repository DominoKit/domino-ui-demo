package org.dominokit.domino.datepicker.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("inlined.txt")
    ExternalTextResource inlined();

    @Source("popups.txt")
    ExternalTextResource popups();

    @Source("datebox.txt")
    ExternalTextResource datebox();

}
