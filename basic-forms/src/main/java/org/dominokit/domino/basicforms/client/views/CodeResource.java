package org.dominokit.domino.basicforms.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("textbox-samples.txt")
    ExternalTextResource textboxSamples();

    @Source("textarea-samples.txt")
    ExternalTextResource textareaSamples();

    @Source("dropdown-samples.txt")
    ExternalTextResource dropdownSamples();

    @Source("checkbox-samples.txt")
    ExternalTextResource checkBoxSamples();

    @Source("radio-samples.txt")
    ExternalTextResource radioSamples();
}
