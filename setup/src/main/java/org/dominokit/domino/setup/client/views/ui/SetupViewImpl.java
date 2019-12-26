package org.dominokit.domino.setup.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.setup.client.presenters.SetupProxy;
import org.dominokit.domino.setup.client.views.SetupView;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.gwtproject.safehtml.shared.SafeHtmlBuilder;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = SetupProxy.class)
public class SetupViewImpl extends BaseDemoView<HTMLDivElement> implements SetupView{

    private HTMLDivElement element;

    @Override
    protected void init(HTMLDivElement root) {
        element.appendChild(BlockHeader.create("SETUP",
                "Steps required to start working with domino ui components").element());


        element.appendChild(CodeCard.createCodeCard(new SafeHtmlBuilder()
                .appendEscaped("<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-ui</artifactId>\n" +
                "  <version>1.0-SNAPSHOT</version>\n" +
                "</dependency>\n" +
                "<dependency>\n" +
                "  <groupId>org.dominokit</groupId>\n" +
                "  <artifactId>domino-ui</artifactId>\n" +
                "  <version>1.0-SNAPSHOT</version>\n" +
                "  <classifier>sources</classifier>\n" +
                "</dependency>").toSafeHtml().asString())
                .setTitle("Maven dependencies")
                .apply(self -> self.getCard().show())
                .element());

        element.appendChild(CodeCard.createCodeCard(new SafeHtmlBuilder()
                .appendEscaped("<!-- To use the snapshot dependency you will need to add the snapshots repositories to your maven settings  -->\n\n" +
                        "<repository>\n" +
                        "\t<id>sonatype-snapshots-repo</id>\n" +
                        "\t<url>https://oss.sonatype.org/content/repositories/snapshots</url>\n" +
                        "\t<snapshots>\n" +
                        "\t\t<enabled>true</enabled>\n" +
                        "\t\t<updatePolicy>always</updatePolicy>\n" +
                        "\t\t<checksumPolicy>fail</checksumPolicy>\n" +
                        "\t</snapshots>\n" +
                        "</repository>\n" +
                        "<repository>\n" +
                        "\t<id>vertispan-snapshots</id>\n" +
                        "\t<name>Vertispan Snapshots</name>\n" +
                        "\t<url>https://repo.vertispan.com/gwt-snapshot/</url>\n" +
                        "\t<snapshots>\n" +
                        "\t\t<enabled>true</enabled>\n" +
                        "\t\t<updatePolicy>always</updatePolicy>\n" +
                        "\t\t<checksumPolicy>fail</checksumPolicy>\n" +
                        "\t</snapshots>\n" +
                        "</repository>").toSafeHtml().asString())
                .setTitle("Snapshot repositories")
                .apply(self -> self.getCard().show())
                .element());

        element.appendChild(CodeCard.createCodeCard(new SafeHtmlBuilder().appendEscaped("<inherits name=\"org.dominokit.domino.ui.DominoUI\"/>").toSafeHtml().asString())
                .setTitle("gwt module inheritance")
                .apply(self -> self.getCard().show())
                .element());

        element.appendChild(CodeCard.createCodeCard(new SafeHtmlBuilder().appendEscaped("<meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n" +
                "\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"{module-short-name}/css/domino-ui.css\">\n" +
                "<link type=\"text/css\" rel=\"stylesheet\" href=\"{module-short-name}/css/themes/all-themes.css\">").toSafeHtml().asString())
                .setTitle("Html page required imports")
                .setDescription("The path depends on your module and index page setup.")
                .apply(self -> self.getCard().show())
                .element());
    }

    @Override
    public HTMLDivElement createRoot() {
        element = div().element();
        return element;
    }
}