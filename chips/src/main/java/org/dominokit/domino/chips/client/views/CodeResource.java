package org.dominokit.domino.chips.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("simple.txt")
    ExternalTextResource simple();

    @Source("removable.txt")
    ExternalTextResource removable();

    @Source("chips-with-icons.txt")
    ExternalTextResource chipsWithIcons();

    @Source("chips-with-images.txt")
    ExternalTextResource chipsWithImages();

    @Source("chips-with-letters.txt")
    ExternalTextResource chipsWithLetters();

    @Source("selectable.txt")
    ExternalTextResource selectable();
}
