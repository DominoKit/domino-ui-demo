package com.progressoft.brix.domino.home.client.views.ui;

import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentView;
import com.progressoft.brix.domino.home.client.presenters.HomePresenter;
import com.progressoft.brix.domino.home.client.views.HomeView;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
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

        element.appendChild(BlockHeader.create("SETUP",
                "Steps required to start working with domino ui components").asElement());

        element.appendChild(Card.createCodeCard("<dependency>\n" +
                "    <groupId>com.progressoft.brix.domino</groupId>\n" +
                "    <artifactId>domino-ui-components</artifactId>\n" +
                "    <version>1.0-SNAPSHOT</version>\n" +
                "</dependency>")
                .setTitle("Maven dependencies")
                .expand()
                .asElement());

        element.appendChild(Card.createCodeCard("<inherits name=\"com.progressoft.brix.domino.ui.components\"/>")
                .setTitle("GWT module inheritance")
                .expand()
                .asElement());

        element.appendChild(Card.createCodeCard("<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/font/material-icons.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/plugins/bootstrap/css/bootstrap.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/plugins/node-waves/waves.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/plugins/animate-css/animate.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/plugins/waitme/waitMe.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/css/style.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"/{module short name}/css/themes/all-themes.css\">\n" +
                "<script src=\"/{module short name}/plugins/node-waves/waves.js\" type=\"text/javascript\"></script>)")
                .setTitle("Html page required imports")
                .setDescription("The path depends on your module and index page setup.")
                .expand()
                .asElement());
    }
}