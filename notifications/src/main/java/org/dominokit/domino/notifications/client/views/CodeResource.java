package org.dominokit.domino.notifications.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("notificationsPosition.txt")
    ExternalTextResource notificationsPosition();

    @Source("notificationsTypes.txt")
    ExternalTextResource notificationsTypes();

    @Source("withMaterialColors.txt")
    ExternalTextResource withMaterialColors();

    @Source("withAnimation.txt")
    ExternalTextResource withAnimation();

}

