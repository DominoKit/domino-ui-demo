package org.dominokit.domino.home.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.home.client.presenters.HomePresenter;
import org.dominokit.domino.home.client.views.HomeView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.infoboxes.InfoBox;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = HomePresenter.class)
public class HomeViewImpl extends ComponentView<HTMLDivElement> implements HomeView {


    private HTMLDivElement element = div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {

        element.appendChild(div().css(Color.THEME.getBackground()).style("margin-top: -40px; margin-left: -30px; margin-right: -30px; margin-bottom: 20px; padding-top: 40px; padding-bottom: 30px;")
                .add(Style.of(h(2).textContent("Domino UI"))
                        .css(Styles.align_center)
                        .setProperty("font-weight","normal")
                )
                .add(Style.of(h(4)
                        .textContent("A type safe material design with bootstrap builder for java developer with GWT without dependencies on external JavaScript."))
                        .css(Styles.align_center)
                        .setMarginBottom("30px")
                        .setProperty("font-weight","normal")
                )
                .add(Style.of(div().innerHtml(new SafeHtmlBuilder().appendHtmlConstant("<iframe src=\"https://ghbtns.com/github-btn.html?user=DominoKit&amp;repo=domino-ui&amp;type=star&amp;count=true&amp;size=large\" frameborder=\"0\" scrolling=\"0\" width=\"125px\" height=\"30px\"></iframe>").toSafeHtml())).css(Styles.align_center))
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
                .setTitle("GWT module inheritance")
                .expand()
                .asElement());

        element.appendChild(Card.createCodeCard("<meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n" +
                "\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module-short-name}/font/material-icons.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module-short-name}/plugins/bootstrap/css/bootstrap.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module-short-name}/plugins/node-waves/waves.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module-short-name}/plugins/animate-css/animate.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module-short-name}/plugins/waitme/waitMe.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module-short-name}/css/style.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module-short-name}/css/themes/all-themes.css\">")
                .setTitle("Html page required imports")
                .setDescription("The path depends on your module and index page setup.")
                .expand()
                .asElement());
    }
}