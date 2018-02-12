package com.progressoft.brix.domino.home.client.ui.views;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.home.client.presenters.HomePresenter;
import com.progressoft.brix.domino.home.client.views.HomeView;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import me.rjb.client.SyntaxHighlighter;
import me.rjb.client.brushes.Brushes;
import me.rjb.client.themes.Themes;

import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = HomePresenter.class)
public class DefaultHomeView implements HomeView{


    private HTMLDivElement root=div().asElement();

    public DefaultHomeView() {

        root.appendChild(BlockHeader.create("SETUP",
                "Steps required to start working with domino ui components").asElement());

        Card mavenCard=Card.create("Maven dependencies");
        mavenCard.getBody().appendChild(
                SyntaxHighlighter.create(Brushes.XML, "<dependency>\n" +
                "    <groupId>com.progressoft.brix.domino</groupId>\n" +
                "    <artifactId>domino-ui-components</artifactId>\n" +
                "    <version>1.0-SNAPSHOT</version>\n" +
                "</dependency>")
                .setToolbar(false)
                .setGutter(false)
                .highlight()
                .getElement());

        root.appendChild(mavenCard.asElement());


        Card gwtInheritsCard=Card.create("GWT module inheritance");
        gwtInheritsCard.getBody().appendChild(SyntaxHighlighter.create(Brushes.XML, "<inherits name=\"com.progressoft.brix.domino.ui.components\"/>")
                        .setToolbar(false)
                        .setGutter(false)
                        .highlight()
                        .getElement());

        root.appendChild(gwtInheritsCard.asElement());

        Card htmlImportsCard=Card.create("Html page required imports", "The path depends on your module and index page setup");

        htmlImportsCard.getBody().appendChild(SyntaxHighlighter.create(Brushes.XML, "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/font/material-icons.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/plugins/bootstrap/css/bootstrap.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/plugins/node-waves/waves.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/plugins/animate-css/animate.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/plugins/morrisjs/morris.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/plugins/waitme/waitMe.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/css/style.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/css/themes/all-themes.css\">\n" +
                "<script src=\"/{module short name}/plugins/node-waves/waves.js\" type=\"text/javascript\"></script>")
                        .setToolbar(false)
                        .setGutter(false)
                        .highlight()
                        .getElement());

        root.appendChild(htmlImportsCard.asElement());

    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement= Js.cast(content.get());
        contentElement.appendChild(root);
    }
}