package org.dominokit.domino.spin.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("horizontalSpin.txt")
    ExternalTextResource horizontalSpin();

    @Source("verticalSpin.txt")
    ExternalTextResource verticalSpin();
}
