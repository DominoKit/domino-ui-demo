package org.dominokit.domino.alerts.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.alerts.client.presenters.AlertsPresenter;
import org.dominokit.domino.alerts.client.views.AlertsView;
import org.dominokit.domino.alerts.client.views.CodeResource;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.Typography.Strong;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.Elements;

import static org.jboss.gwt.elemento.core.Elements.a;

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
    public void init() {
        element.appendChild(LinkToSourceCode.create("alerts", AlertsViewImpl.class).asElement());
        element.appendChild(BlockHeader.create("Alerts")
                .asElement());

        basicAlerts();
        customBackground();
        dismissibleAlerts();
        linksInAlerts();
    }

    private void basicAlerts() {
        element.appendChild(Card.create("BASIC ALERTS", "Use one of the pre-customized alert types.")
                .appendChild(Alert.success().appendChild(Strong.of("Well done! ")).appendChild("You successfully read this important alert message."))
                .appendChild(Alert.info().appendChild(Strong.of("Heads up! ")).appendChild("This alert needs your attention, but it's not super important."))
                .appendChild(Alert.warning().appendChild(Strong.of("Warning! ")).appendChild("Better check yourself, you're not looking too good."))
                .appendChild(Alert.error().appendChild(Strong.of("Oh snap! ")).appendChild("Change a few things up and try submitting again."))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basicAlerts()).asElement());
    }

    private void customBackground() {
        element.appendChild(Card.create("MATERIAL DESIGN ALERTS", "ou can use material design colors backgrounds")
                .appendChild(Alert.create(Color.PINK)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id"))
                .appendChild(Alert.create(Color.ORANGE)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id"))
                .appendChild(Alert.create(Color.TEAL)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id"))
                .appendChild(Alert.create(Color.GREEN)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id"))
                .appendChild(Alert.create(Color.RED)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id"))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.customBackgrounds())
                .asElement());

    }

    private void dismissibleAlerts() {

        element.appendChild(Card.create("DISMISSIBLE ALERTS", "Add a close button to any alert by making it dismissible")
                .appendChild(Alert.warning()
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .appendChild(Alert.create(Color.PINK)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .appendChild(Alert.create(Color.TEAL)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .appendChild(Alert.create(Color.GREEN)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.dismissibleAlerts()).asElement());
    }

    private void linksInAlerts() {
        element.appendChild(Card.create("LINKS IN ALERTS", "Use the appendLink utility class to quickly provide matching colored links within any alert.")
                .appendChild(Alert.success()
                        .appendChild(Strong.of("Well done! "))
                        .appendChild("You successfully read ")
                        .appendChild(a().add("important alert message.").asElement()))
                .appendChild(Alert.info()
                        .appendChild(Strong.of("Heads up! "))
                        .appendChild("This ")
                        .appendChild(a().add("alert needs your attention, ").asElement())
                        .appendChild("but it's not super important."))
                .appendChild(Alert.warning()
                        .appendChild(Strong.of("Warning! "))
                        .appendChild("Better check yourself, ")
                        .appendChild(a().add("you're not looking too good.").asElement()))
                .appendChild(Alert.error()
                        .appendChild(Strong.of("Oh snap! "))
                        .appendChild(a().add("Change a few things up").asElement())
                        .appendChild(" and try submitting again."))
                .appendChild(Alert.create(Color.PINK)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id ")
                        .appendChild(a().add("alert link.").asElement()))
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.linksInAlerts()).asElement());
    }
}