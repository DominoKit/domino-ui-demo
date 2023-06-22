package org.dominokit.domino.home.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class SampleComponent extends BaseDominoElement<HTMLDivElement, SampleComponent> {

    CssClass dui_flex_grow_1 = ()-> "dui-flex-grow-1";
    private DivElement root;

    public SampleComponent() {
        Card card = Card.create()
                .addCss(dui_p_0);

        this.root = div().addCss(dui_flex)
                .setCssProperty("--dui-card-body-padding", "30px")
                .appendChild(div().appendChild(Icons.twitter()))
                .appendChild(div()
                        .addCss(dui_grow_1).appendChild(p().setTextContent("Text here")));

        onKeyDown(keyEvents -> keyEvents.onEnter(evt -> {

        }));
        init(this);
    }

    @Override
    public HTMLDivElement element() {
        return null;
    }
}
