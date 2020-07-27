package org.dominokit.domino.samples.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.samples.client.presenters.SamplesProxy;
import org.dominokit.domino.samples.client.views.SamplesView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.elemento.Elements.*;

@UiView(presentable = SamplesProxy.class)
public class SamplesViewImpl extends BaseDemoView<HTMLDivElement> implements SamplesView {

    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        element.appendChild(BlockHeader.create("SAMPLES", " A set of apps and samples built with domino-ui").element());
        element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .styler(style -> style.add(Styles.align_center))
                        .appendChild(
                                Card.create()
                                        .styler(style -> style
                                                .add("classy-card"))
                                        .appendChild(img("./images/samples/dominodo.png")
                                                .css(Styles.img_responsive)
                                                .css(Elevation.LEVEL_1.getStyle()))
                                        .appendChild(h(4).textContent("DominoDo"))
                                        .appendChild(Paragraph.create("Simple todo app introducing good number of domino-ui components"))
                                        .appendChild(hr())
                                        .appendChild(h(6).textContent("Author"))
                                        .appendChild(h(5).textContent("DominoKit Team"))
                                        .appendChild(a()
                                                .attr("href", "https://dominokit.github.io/dominodo/index.html")
                                                .attr("target", "_blank")
                                                .add(h(5).textContent("Visit")))
                                        .appendChild(a()
                                                .attr("href", "https://github.com/DominoKit/dominodo")
                                                .attr("target", "_blank")
                                                .add(h(5).textContent("Source code")))
                                        .appendChild(div().css("bg-classy"))
                        )
                )
                .appendChild(Column.span6()
                        .styler(style -> style.add(Styles.align_center))
                        .appendChild(
                                Card.create()
                                        .styler(style -> style
                                                .add("classy-card"))
                                        .appendChild(img("./images/samples/nalu-initializer.png")
                                                .css(Styles.img_responsive)
                                                .css(Elevation.LEVEL_1.getStyle()))
                                        .appendChild(h(4).textContent("Nalu Initializer"))
                                        .appendChild(Paragraph.create("Project initializer for Nalu MVP framework"))
                                        .appendChild(hr())
                                        .appendChild(h(6).textContent("Author"))
                                        .appendChild(a()
                                                .attr("href","https://github.com/FrankHossfeld")
                                                .attr("target","_blank")
                                                .add(h(5).textContent("Frank Hossfeld")))
                                        .appendChild(a()
                                                .attr("href", "http://www.mvp4g.org/boot-starter-nalu/BootStarterNalu.html")
                                                .attr("target", "_blank")
                                                .add(h(5).textContent("Visit")))
                                        .appendChild(a()
                                                .attr("href", "https://github.com/NaluKit/gwt-boot-starter-nalu")
                                                .attr("target", "_blank")
                                                .add(h(5).textContent("Source code")))
                                        .appendChild(div().css("bg-classy"))
                        )
                )
                .element());

        return element;
    }

}
