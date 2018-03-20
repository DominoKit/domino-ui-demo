package org.dominokit.domino.buttons.client.views;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;

public interface CodeResource extends ClientBundle {

    CodeResource INSTANCE = GWT.create(CodeResource.class);

    @Source("initBootstrapButtons.txt")
    ExternalTextResource initBootstrapButtons();

    @Source("initMaterialDesignButtons.txt")
    ExternalTextResource initMaterialDesignButtons();

    @Source("initButtonSizes.txt")
    ExternalTextResource initButtonSizes();

    @Source("initBlockButtons.txt")
    ExternalTextResource initBlockButtons();

    @Source("initDisabledButtons.txt")
    ExternalTextResource initDisabledButtons();

    @Source("initIconButtons.txt")
    ExternalTextResource initIconButtons();

    @Source("initTextIconButtons.txt")
    ExternalTextResource initTextIconButtons();

    @Source("initButtonsBasicGroup.txt")
    ExternalTextResource initButtonsBasicGroup();

    @Source("initButtonsToolbar.txt")
    ExternalTextResource initButtonsToolbar();

    @Source("initSizingGroup.txt")
    ExternalTextResource initSizingGroup();

    @Source("initNestingGroup.txt")
    ExternalTextResource initNestingGroup();

    @Source("initVerticalGroup.txt")
    ExternalTextResource initVerticalGroup();

    @Source("initJustifyGroup.txt")
    ExternalTextResource initJustifyGroup();

    @Source("initSingleDropdownButtons.txt")
    ExternalTextResource initSingleDropdownButtons();

    @Source("initSplitButton.txt")
    ExternalTextResource initSplitButton();

    @Source("initDropUp.txt")
    ExternalTextResource initDropUp();


}

