package org.dominokit.domino.login.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("login_1.txt")
    ExternalTextResource login_1();

    @Source("login_2.txt")
    ExternalTextResource login_2();

    @Source("login_3.txt")
    ExternalTextResource login_3();

    @Source("login_4.txt")
    ExternalTextResource login_4();

    @Source("login_5.txt")
    ExternalTextResource login_5();

    @Source("login_6.txt")
    ExternalTextResource login_6();
}
