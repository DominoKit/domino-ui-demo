package org.dominokit.domino.steppers.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("verticalStepper.txt")
    ExternalTextResource verticalStepper();

    @Source("horizontalStepper.txt")
    ExternalTextResource horizontalStepper();

}
