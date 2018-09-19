package org.dominokit.domino.splitPanel.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle{

    CodeResource INSTANCE= GWT.create(CodeResource.class);

    @Source("horizontalSplitPanel.txt")
    ExternalTextResource horizontalSplitPanel();

    @Source("verticalSplitPanel.txt")
    ExternalTextResource verticalSplitPanel();

    @Source("splitPanelMinMax.txt")
    ExternalTextResource splitPanelMinMax();

    @Source("multiSplit.txt")
    ExternalTextResource multiSplit();

    @Source("combined.txt")
    ExternalTextResource combined();

}
