package org.dominokit.domino.tree.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;
import elemental2.dom.Node;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("simpleTree.txt")
    ExternalTextResource simpleTree();

    @Source("nestedTree.txt")
    ExternalTextResource nestedTree();

    @Source("featuredTree.txt")
    ExternalTextResource featuredTree();
}
