package com.progressoft.brix.domino.alerts.client.views.ui;

import com.progressoft.brix.domino.alerts.client.presenters.AlertsPresenter;
import com.progressoft.brix.domino.alerts.client.views.AlertsView;
import com.progressoft.brix.domino.alerts.client.views.CodeResource;
import com.progressoft.brix.domino.api.client.annotations.UiView;
import com.progressoft.brix.domino.api.shared.extension.Content;
import com.progressoft.brix.domino.componentcase.shared.extension.ComponentView;
import com.progressoft.brix.domino.ui.alerts.Alert;
import com.progressoft.brix.domino.ui.cards.Card;
import com.progressoft.brix.domino.ui.header.BlockHeader;
import com.progressoft.brix.domino.ui.style.Background;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import jsinterop.base.Js;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = AlertsPresenter.class)
public class AlertsViewImpl extends ComponentView<HTMLDivElement> implements AlertsView {

    private HTMLDivElement element = Elements.div().asElement();
    public AlertsViewImpl() {

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init(){
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

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basicAlerts()).asElement());
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

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.customBackgrounds())
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

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.dismissibleAlerts()).asElement());
    }

    private void linksInAlerts() {
        element.appendChild(Card.create("LINKS IN ALERTS", "Use the appendLink utility class to quickly provide matching colored links within any alert.")
                .appendContent(Alert.success()
                        .appendStrong("Well done! ")
                        .appendText("You successfully read ")
                        .appendLink(Elements.a().add("important alert message.").asElement())
                        .asElement())
                .appendContent(Alert.info()
                        .appendStrong("Heads up! ")
                        .appendText("This ")
                        .appendLink(Elements.a().add("alert needs your attention, ").asElement())
                        .appendText("but it's not super important.")
                        .asElement())
                .appendContent(Alert.warning()
                        .appendStrong("Warning! ")
                        .appendText("Better check yourself, ")
                        .appendLink(Elements.a().add("you're not looking too good.").asElement())
                        .asElement())
                .appendContent(Alert.error()
                        .appendStrong("Oh snap! ")
                        .appendLink(Elements.a().add("Change a few things up").asElement())
                        .appendText(" and try submitting again.")
                        .asElement())
                .appendContent(Alert.create(Background.PINK)
                        .appendText("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id ")
                        .appendLink(Elements.a().add("alert link.").asElement())
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.linksInAlerts()).asElement());
    }
}