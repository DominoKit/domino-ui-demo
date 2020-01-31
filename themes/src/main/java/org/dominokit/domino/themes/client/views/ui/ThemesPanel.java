package org.dominokit.domino.themes.client.views.ui;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLUListElement;
import org.jboss.elemento.IsElement;

import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.ul;

public class ThemesPanel implements IsElement<HTMLDivElement> {

    private final HTMLDivElement root;
    final HTMLUListElement themesContainer;

    public ThemesPanel() {
        this.root = div().style("position: relative; width: auto")
                .add(themesContainer = ul().css("demo-choose-skin").style("width: auto").element())
                .element();
    }

    @Override
    public HTMLDivElement element() {
        return root;
    }

    static ThemesPanel create() {
        return new ThemesPanel();
    }
}
