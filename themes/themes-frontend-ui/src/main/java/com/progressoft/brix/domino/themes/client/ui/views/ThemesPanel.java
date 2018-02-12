package com.progressoft.brix.domino.themes.client.ui.views;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class ThemesPanel implements IsElement<HTMLDivElement> {

    @DataElement
    HTMLUListElement themesContainer;

    static ThemesPanel create() {
        return new Templated_ThemesPanel();
    }
}
