package org.dominokit.domino.alerts.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.alerts.client.presenters.AlertsProxy;
import org.dominokit.domino.alerts.client.views.AlertsView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.client.ui.views.PR;
import org.dominokit.domino.ui.Typography.Strong;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.Elements;

import static org.jboss.gwt.elemento.core.Elements.a;

@UiView(presentable = AlertsProxy.class)
@SampleClass
public class AlertsViewImpl extends BaseDemoView<HTMLDivElement> implements AlertsView {

    private HTMLDivElement element = Elements.div().element();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.create("alerts", AlertsViewImpl.class).element());
        element.appendChild(BlockHeader.create("Alerts")
                .element());

        basicAlerts();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.basicAlerts()).element());

        customBackground();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.customBackground())
                .element());

        dismissibleAlerts();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.dismissibleAlerts()).element());

        linksInAlerts();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.linksInAlerts()).element());

        return element;
    }

    @SampleMethod
    private void basicAlerts() {
        element.appendChild(Card.create("BASIC ALERTS", "Use one of the pre-customized alert types.")
                .appendChild(Alert.success().appendChild(Strong.of("Well done! ")).appendChild("You successfully read this important alert message."))
                .appendChild(Alert.info().appendChild(Strong.of("Heads up! ")).appendChild("This alert needs your attention, but it's not super important."))
                .appendChild(Alert.warning().appendChild(Strong.of("Warning! ")).appendChild("Better check yourself, you're not looking too good."))
                .appendChild(Alert.error().appendChild(Strong.of("Oh snap! ")).appendChild("Change a few things up and try submitting again."))
                .element());
    }

    @SampleMethod
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
                .element());
    }

    @SampleMethod
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
                .element());
    }

    @SampleMethod
    private void linksInAlerts() {
        element.appendChild(Card.create("LINKS IN ALERTS", "Use the appendLink utility class to quickly provide matching colored links within any alert.")
                .appendChild(Alert.success()
                        .appendChild(Strong.of("Well done! "))
                        .appendChild("You successfully read ")
                        .appendChild(a().add("important alert message.").element()))
                .appendChild(Alert.info()
                        .appendChild(Strong.of("Heads up! "))
                        .appendChild("This ")
                        .appendChild(a().add("alert needs your attention, ").element())
                        .appendChild("but it's not super important."))
                .appendChild(Alert.warning()
                        .appendChild(Strong.of("Warning! "))
                        .appendChild("Better check yourself, ")
                        .appendChild(a().add("you're not looking too good.").element()))
                .appendChild(Alert.error()
                        .appendChild(Strong.of("Oh snap! "))
                        .appendChild(a().add("Change a few things up").element())
                        .appendChild(" and try submitting again."))
                .appendChild(Alert.create(Color.PINK)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id ")
                        .appendChild(a().add("alert link.").element()))
                .element());
    }
}