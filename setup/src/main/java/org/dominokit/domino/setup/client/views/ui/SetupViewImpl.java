package org.dominokit.domino.setup.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.setup.client.presenters.SetupPresenter;
import org.dominokit.domino.setup.client.views.SetupView;
import org.dominokit.domino.ui.header.BlockHeader;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = SetupPresenter.class)
public class SetupViewImpl extends ComponentView<HTMLDivElement> implements SetupView{

    private HTMLDivElement element = div().asElement();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("SETUP",
                "Steps required to start working with domino ui components").asElement());


        element.appendChild(CodeCard.createCodeCard("<dependency>\n" +
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

        element.appendChild(CodeCard.createCodeCard("<inherits name=\"org.dominokit.domino.ui.DominoUI\"/>")
                .setTitle("gwt module inheritance")
                .expand()
                .asElement());

        element.appendChild(CodeCard.createCodeCard("<meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n" +
                "\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"{module-short-name}/css/domino-ui.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"{module-short-name}/css/themes/all-themes.css\">")
                .setTitle("Html page required imports")
                .setDescription("The path depends on your module and index page setup.")
                .expand()
                .asElement());
    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}