package org.dominokit.domino.samples.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.samples.client.presenters.SamplesPresenter;
import org.dominokit.domino.samples.client.views.SamplesView;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Styles;

import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = SamplesPresenter.class)
public class SamplesViewImpl extends ComponentView<HTMLDivElement> implements SamplesView {

    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("SAMPLES", " A set of apps and samples built with domino-ui").asElement());
        element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .styler(style -> style.add(Styles.align_center))
                        .appendChild(
                                Card.create()
                                        .styler(style -> style
                                                .add("classy-card"))
                                        .appendChild(img("./images/samples/dominodo.png")
                                                .css(Styles.img_responsive)
                                                .css(Styles.default_shadow))
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
                                                .css(Styles.default_shadow))
                                        .appendChild(h(4).textContent("Nalu Initializer"))
                                        .appendChild(Paragraph.create("Project initializer for Nalu MVP framework"))
                                        .appendChild(hr())
                                        .appendChild(h(6).textContent("Author"))
                                        .appendChild(a()
                                                .attr("href","https://github.com/FrankHossfeld")
                                                .attr("target","_blank")
                                                .add(h(5).textContent("Frank Hossfeld")))
                                        .appendChild(a()
                                                .attr("href", "http://www.mvp4g.org/gwt-boot-starter-nalu/GwtBootStarterNalu.html#application/setUp")
                                                .attr("target", "_blank")
                                                .add(h(5).textContent("Visit")))
                                        .appendChild(a()
                                                .attr("href", "https://github.com/NaluKit/gwt-boot-starter-nalu")
                                                .attr("target", "_blank")
                                                .add(h(5).textContent("Source code")))
                                        .appendChild(div().css("bg-classy"))
                        )
                )
                .asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}
