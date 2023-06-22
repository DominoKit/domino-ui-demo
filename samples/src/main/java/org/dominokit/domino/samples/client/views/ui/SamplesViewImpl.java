package org.dominokit.domino.samples.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.samples.client.presenters.SamplesProxy;
import org.dominokit.domino.samples.client.views.SamplesView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = SamplesProxy.class)
public class SamplesViewImpl extends BaseDemoView<HTMLDivElement> implements SamplesView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div()
                .appendChild(BlockHeader.create("SAMPLES", " A set of apps and samples built with domino-ui"))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .addCss(dui_text_center)
                                .appendChild(
                                        Card.create()
                                                .appendChild(img("./images/samples/dominodo.png")
                                                        .addCss(dui_image_responsive, dui_elevation_1)
                                                )
                                                .appendChild(h(4).textContent("DominoDo"))
                                                .appendChild(p().textContent("Simple todo app introducing good number of domino-ui components"))
                                                .appendChild(hr())
                                                .appendChild(h(6).textContent("Author"))
                                                .appendChild(h(5).textContent("DominoKit Team"))
                                                .appendChild(a("https://dominokit.github.io/dominodo/index.html", "_blank")
                                                        .appendChild(h(5).textContent("Visit"))
                                                )
                                                .appendChild(a("https://github.com/DominoKit/dominodo", "_blank")
                                                        .appendChild(h(5).textContent("Source code"))
                                                )
                                )
                        )
                        .element());

        return element.element();
    }

}
