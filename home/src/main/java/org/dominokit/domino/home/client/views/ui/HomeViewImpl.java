package org.dominokit.domino.home.client.views.ui;

import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.home.client.presenters.HomePresenter;
import org.dominokit.domino.home.client.views.HomeView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.carousel.Carousel;
import org.dominokit.domino.ui.carousel.Slide;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = HomePresenter.class)
public class HomeViewImpl extends ComponentView<HTMLDivElement> implements HomeView {


    private HTMLDivElement element = div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {

        element.appendChild(div()
                .css(Color.THEME.getBackground(), Styles.default_shadow)
                .style("margin-top: -40px; margin-left: -30px; margin-right: -30px; margin-bottom: 20px; padding-top: 10px;")
                .add(Carousel.create()
                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/slides/domino-ui-slide-1.png", "Type safe", "Code it in JAVA and be safe"))
                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/slides/domino-ui-slide-2.png", "Elegant", "Simple, Colorful and responsive "))
                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/slides/domino-ui-slide-3.png", "Data table", "Rich beautiful data tables"))
                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/slides/domino-ui-slide-4.png", "Form", "Interactive forms with style"))
                        .appendChild(Slide.create(GWT.getModuleBaseURL() + "/images/slides/domino-ui-slide-5.png", "Icons", "Large set of easy to use font icons"))
                        .startAutoSlide(8000)
                        .asElement())
                .asElement());

        element.appendChild(BlockHeader.create("SETUP",
                "Steps required to start working with domino ui components").asElement());

        element.appendChild(Card.createCodeCard("<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-ui</artifactId>\n" +
                "  <version>1.0-SNAPSHOT</version>\n" +
                "</dependency>\n" +
                "<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-ui</artifactId>\n" +
                "  <version>1.0-SNAPSHOT</version>\n" +
                "  <classifier>sources</classifier>\n" +
                "</dependency>")
                .setTitle("Maven dependencies")
                .expand()
                .asElement());

        element.appendChild(Card.createCodeCard("<inherits name=\"org.dominokit.domino.ui.DominoUI\"/>")
                .setTitle("gwt module inheritance")
                .expand()
                .asElement());

        element.appendChild(Card.createCodeCard("<meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n" +
                "\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"{module-short-name}/css/domino-ui.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"{module-short-name}/css/themes/all-themes.css\">")
                .setTitle("Html page required imports")
                .setDescription("The path depends on your module and index page setup.")
                .expand()
                .asElement());
    }
}