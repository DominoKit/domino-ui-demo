package org.dominokit.domino.home.client.views.ui;

import elemental2.dom.DomGlobal;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.home.client.presenters.HomePresenter;
import org.dominokit.domino.home.client.views.HomeView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = HomePresenter.class)
public class HomeViewImpl extends ComponentView<HTMLDivElement> implements HomeView {


    private HTMLDivElement element = Elements.div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {

        DomGlobal.console.info("hhhhhhhhhhhhhhhhhhhhhoooooommmmmmmmmeeeeee");

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