package org.dominokit.domino.alerts.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.alerts.client.presenters.AlertsProxy;
import org.dominokit.domino.alerts.client.views.AlertsView;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.alerts.Alert;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = AlertsProxy.class)
@SampleClass
public class AlertsViewImpl extends BaseDemoView<HTMLDivElement> implements AlertsView {

    private HTMLDivElement element = div().element();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.createLink("alerts", AlertsViewImpl.class).element());
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
                .appendChild(Alert.success()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Well done! "))
                        .appendChild("You successfully read this important alert message."))
                .appendChild(Alert.info()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Heads up! "))
                        .appendChild("This alert needs your attention, but it's not super important."))
                .appendChild(Alert.warning()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Warning! "))
                        .appendChild("Better check yourself, you're not looking too good."))
                .appendChild(Alert.error()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Oh snap! "))
                        .appendChild("Change a few things up and try submitting again."))
                .element());
    }

    @SampleMethod
    private void customBackground() {
        element.appendChild(Card.create("MATERIAL DESIGN ALERTS", "ou can use material design colors backgrounds")
                .appendChild(Alert.create()
                        .addCss(dui_bg_pink, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id"))
                .appendChild(Alert.create()
                        .addCss(dui_bg_orange, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id"))
                .appendChild(Alert.create()
                        .addCss(dui_bg_teal, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id"))
                .appendChild(Alert.create()
                        .addCss(dui_bg_green, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id"))
                .appendChild(Alert.create()
                        .addCss(dui_bg_red, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id"))
                .element());
    }

    @SampleMethod
    private void dismissibleAlerts() {

        element.appendChild(Card.create("DISMISSIBLE ALERTS", "Add a close button to any alert by making it dismissible")
                .appendChild(Alert.warning()
                        .addCss(dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .appendChild(Alert.create()
                        .addCss(dui_bg_pink, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .appendChild(Alert.create()
                        .addCss(dui_bg_teal, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .appendChild(Alert.create()
                        .addCss(dui_bg_green, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id")
                        .dismissible())
                .element());
    }

    @SampleMethod
    private void linksInAlerts() {
        element.appendChild(Card.create("LINKS IN ALERTS", "Use the appendLink utility class to quickly provide matching colored links within any alert.")
                .appendChild(Alert.success()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Well done! "))
                        .appendChild("You successfully read ")
                        .appendChild(a().appendChild("important alert message.")))
                .appendChild(Alert.info()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Heads up! "))
                        .appendChild("This ")
                        .appendChild(a().appendChild("alert needs your attention, "))
                        .appendChild("but it's not super important."))
                .appendChild(Alert.warning()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Warning! "))
                        .appendChild("Better check yourself, ")
                        .appendChild(a().appendChild("you're not looking too good.")))
                .appendChild(Alert.error()
                        .addCss(dui_m_b_4)
                        .appendChild(strong().textContent("Oh snap!    "))
                        .appendChild(a().appendChild("Change a few things up"))
                        .appendChild(" and try submitting again."))
                .appendChild(Alert.create()
                        .addCss(dui_bg_pink, dui_fg_white, dui_m_b_4)
                        .appendChild("Lorem ipsum dolor sit amet, id fugit tollit pro, illud nostrud aliquando ad est, quo esse dolorum id ")
                        .appendChild(a().appendChild("alert link.")))
                .element());
    }
}