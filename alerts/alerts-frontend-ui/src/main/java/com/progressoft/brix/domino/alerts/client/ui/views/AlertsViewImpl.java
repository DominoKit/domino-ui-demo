package com.progressoft.brix.domino.alerts.client.ui.views;

import com.progressoft.brix.domino.alerts.client.presenters.AlertsPresenter;
import com.progressoft.brix.domino.alerts.client.views.AlertsView;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.ui.alerts.Alert;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = AlertsPresenter.class)
public class AlertsViewImpl implements AlertsView {

    private HTMLDivElement element = div().asElement();

    public AlertsViewImpl() {
        element.appendChild(BlockHeader.create("Alerts").asElement());

        basicAlerts();
        customBackground();
        dismissibleAlerts();
        linksInAlerts();

    }


    private void basicAlerts() {
        element.appendChild(Card.create("BASIC ALERTS", "Use one of the pre-customized alert types.")
                .appendContent(Alert.success().appendStrong("Well done! ").appendText("You successfully read this important alert message.").asElement())
                .appendContent(Alert.info().appendStrong("Heads up! ").appendText("This alert needs your attention, but it's not super important.").asElement())
                .appendContent(Alert.warning().appendStrong("Warning! ").appendText("Better check yourself, you're not looking too good.").asElement())
                .appendContent(Alert.error().appendStrong("Oh snap! ").appendText("Change a few things up and try submitting again.").asElement()).asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Alert.success()\n" +
                "      .appendStrong(\"Well done! \").appendText(\"You successfully read this important alert message.\").asElement());\n" +
                "      \n" +
                "element.appendChild(Alert.info()\n" +
                "      .appendStrong(\"Heads up! \").appendText(\"This alert needs your attention, but it's not super important.\").asElement());\n" +
                "      \n" +
                "element.appendChild(Alert.warning()\n" +
                "      .appendStrong(\"Warning! \").appendText(\"Better check yourself, you're not looking too good.\").asElement());\n" +
                "      \n" +
                "element.appendChild(Alert.error()\n" +
                "      .appendStrong(\"Oh snap! \").appendText(\"Change a few things up and try submitting again.\").asElement());").asElement());
    }

    private void customBackground() {
        element.appendChild(Card.create("MATERIAL DESIGN ALERTS", "ou can use material design colors backgrounds")
                .appendContent(Alert.create(Background.PINK).appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .asElement())
                .appendContent(Alert.create(Background.ORANGE).appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .asElement())
                .appendContent(Alert.create(Background.TEAL).appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .asElement())
                .appendContent(Alert.create(Background.GREEN).appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .asElement())
                .appendContent(Alert.create(Background.RED).appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Alert.create(Background.PINK)\n" +
                "        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "        .asElement());\n" +
                "element.appendChild(Alert.create(Background.ORANGE)\n" +
                "        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "        .asElement());\n" +
                "element.appendChild(Alert.create(Background.TEAL)\n" +
                "        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "        .asElement());\n" +
                "element.appendChild(Alert.create(Background.GREEN)\n" +
                "        .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "        .asElement());\n" +
                "element.appendChild(Alert.create(Background.RED).appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "        .asElement());")
                .asElement());

    }

    private void dismissibleAlerts() {

        element.appendChild(Card.create("DISMISSIBLE ALERTS", "Add a close button to any alert by making it dismissible")
                .appendContent(Alert.warning()
                        .appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible()
                        .asElement())
                .appendContent(Alert.create(Background.PINK)
                        .appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible()
                        .asElement())
                .appendContent(Alert.create(Background.TEAL)
                        .appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible()
                        .asElement())
                .appendContent(Alert.create(Background.GREEN)
                        .appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible()
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Alert.warning()\n" +
                "            .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "            .dismissible()\n" +
                "            .asElement());\n" +
                "element.appendChild(Alert.create(Background.PINK)\n" +
                "            .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "            .dismissible()\n" +
                "            .asElement());\n" +
                "element.appendChild(Alert.create(Background.TEAL)\n" +
                "            .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "            .dismissible()\n" +
                "            .asElement());\n" +
                "element.appendChild(Alert.create(Background.GREEN)\n" +
                "            .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id\")\n" +
                "            .dismissible()\n" +
                "            .asElement());").asElement());


    }

    private void linksInAlerts() {
        element.appendChild(Card.create("LINKS IN ALERTS", "Use the appendLink utility class to quickly provide matching colored links within any alert.")
                .appendContent(Alert.success()
                        .appendStrong("Well done! ")
                        .appendText("You successfully read ")
                        .appendLink(a().add("important alert message.").asElement())
                        .asElement())
                .appendContent(Alert.info()
                        .appendStrong("Heads up! ")
                        .appendText("This ")
                        .appendLink(a().add("alert needs your attention, ").asElement())
                        .appendText("but it's not super important.")
                        .asElement())
                .appendContent(Alert.warning()
                        .appendStrong("Warning! ")
                        .appendText("Better check yourself, ")
                        .appendLink(a().add("you're not looking too good.").asElement())
                        .asElement())
                .appendContent(Alert.error()
                        .appendStrong("Oh snap! ")
                        .appendLink(a().add("Change a few things up").asElement())
                        .appendText(" and try submitting again.")
                        .asElement())
                .appendContent(Alert.create(Background.PINK)
                        .appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id ")
                        .appendLink(a().add("alert link.").asElement())
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard("element.appendChild(Alert.success()\n" +
                "                .appendStrong(\"Well done! \")\n" +
                "                .appendText(\"You successfully read \")\n" +
                "                .appendLink(a().add(\"important alert message.\").asElement())\n" +
                "                .asElement());\n" +
                "element.appendChild(Alert.info()\n" +
                "                .appendStrong(\"Heads up! \")\n" +
                "                .appendText(\"This \")\n" +
                "                .appendLink(a().add(\"alert needs your attention, \").asElement())\n" +
                "                .appendText(\"but it's not super important.\")\n" +
                "                .asElement());\n" +
                "element.appendChild(Alert.warning()\n" +
                "                .appendStrong(\"Warning! \")\n" +
                "                .appendText(\"Better check yourself, \")\n" +
                "                .appendLink(a().add(\"you're not looking too good.\").asElement())\n" +
                "                .asElement());\n" +
                "element.appendChild(Alert.error()\n" +
                "                .appendStrong(\"Oh snap! \")\n" +
                "                .appendLink(a().add(\"Change a few things up\").asElement())\n" +
                "                .appendText(\" and try submitting again.\")\n" +
                "                .asElement());\n" +
                "element.appendChild(Alert.create(Background.PINK)\n" +
                "                .appendText(\"Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id \")\n" +
                "                .appendLink(a().add(\"alert link.\").asElement())\n" +
                "                .asElement());").asElement());

    }

    @Override
    public void showIn(Content content) {
        HTMLElement contentElement = Js.cast(content.get());
        contentElement.appendChild(element);
    }
}