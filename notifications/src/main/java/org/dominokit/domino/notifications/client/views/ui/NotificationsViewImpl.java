package org.dominokit.domino.notifications.client.views.ui;

import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.notifications.client.presenters.NotificationsPresenter;
import org.dominokit.domino.notifications.client.views.CodeResource;
import org.dominokit.domino.notifications.client.views.NotificationsView;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Background;
import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = NotificationsPresenter.class)
public class NotificationsViewImpl extends ComponentView<HTMLDivElement> implements NotificationsView {

    private HTMLDivElement element = div().asElement();
    private final Column column = Column.create()
            .onLarge(Column.OnLarge.two)
            .onMedium(Column.OnMedium.two)
            .onSmall(Column.OnSmall.twelve)
            .onXSmall(Column.OnXSmall.twelve);

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {

        element.appendChild(BlockHeader.create("NOTIFICATIONS", "Taken by Bootstrap Notification ")
                .appendContent(a().attr("href", "https://github.com/mouse0270/bootstrap-notify")
                        .attr("target", "_blank")
                        .textContent("github.com/mouse0270/bootstrap-notify").asElement())
                .asElement());

        notificationsPosition();
        notificationsTypes();
        withMaterialColors();
        withAnimation();

    }

    private void notificationsPosition() {
        Button topLeft = Button.createPrimary("TOP LEFT").large();
        topLeft.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button topCenter = Button.createPrimary("TOP CENTER").large();
        topCenter.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setPosition(Notification.TOP_CENTER)
                        .show());

        Button topRight = Button.createPrimary("TOP RIGHT").large();
        topRight.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setPosition(Notification.TOP_RIGHT)
                        .show());


        Button bottomLeft = Button.createPrimary("BOTTOM LEFT").large();
        bottomLeft.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setPosition(Notification.BOTTOM_LEFT)
                        .show());

        Button bottomCenter = Button.createPrimary("BOTTOM CENTER").large();
        bottomCenter.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setPosition(Notification.BOTTOM_CENTER)
                        .show());

        Button bottomRight = Button.createPrimary("BOTTOM RIGHT").large();
        bottomRight.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setPosition(Notification.BOTTOM_RIGHT)
                        .show());


        element.appendChild(Card.create("NOTIFICATION POSITIONS")
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(topLeft.block().asElement()))
                        .addColumn(column.copy().addElement(topCenter.block().asElement()))
                        .addColumn(column.copy().addElement(topRight.block().asElement()))
                        .addColumn(column.copy().addElement(bottomLeft.block().asElement()))
                        .addColumn(column.copy().addElement(bottomCenter.block().asElement()))
                        .addColumn(column.copy().addElement(bottomRight.block().asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.notificationsPosition())
                .asElement());
    }

    private void notificationsTypes() {

        Button danger = Button.createDanger("DANGER").large();
        danger.getClickableElement().addEventListener("click", e ->
                Notification.createDanger("You received a message")
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button success = Button.createSuccess("SUCCESS").large();
        success.getClickableElement().addEventListener("click", e ->
                Notification.createSuccess("You received a message")
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button warning = Button.createWarning("WARNING").large();
        warning.getClickableElement().addEventListener("click", e ->
                Notification.createWarning("You received a message")
                        .setPosition(Notification.TOP_LEFT)
                        .show());


        Button info = Button.createInfo("INFO").large();
        info.getClickableElement().addEventListener("click", e ->
                Notification.createInfo("You received a message")
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        element.appendChild(Card.create("NOTIFICATION TYPES", "Use predefined notification styles.")
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(danger.block().asElement()))
                        .addColumn(column.copy().addElement(success.block().asElement()))
                        .addColumn(column.copy().addElement(warning.block().asElement()))
                        .addColumn(column.copy().addElement(info.block().asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.notificationsTypes())
        .asElement());

    }

    private void withMaterialColors() {

        Button redButton = Button.create("RED").setBackground(Background.RED).large();
        redButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.RED)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button greenButton = Button.create("GREEN").setBackground(Background.GREEN).large();
        greenButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.GREEN)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button orangeButton = Button.create("ORANGE").setBackground(Background.ORANGE).large();
        orangeButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.ORANGE)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button blueButton = Button.create("BLUE").setBackground(Background.BLUE).large();
        blueButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.BLUE)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button tealButton = Button.create("TEAL").setBackground(Background.TEAL).large();
        tealButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.TEAL)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button cyanButton = Button.create("CYAN").setBackground(Background.CYAN).large();
        cyanButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.CYAN)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button pinkButton = Button.create("PINK").setBackground(Background.PINK).large();
        pinkButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.PINK)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button purpleButton = Button.create("PURPLE").setBackground(Background.PURPLE).large();
        purpleButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.PURPLE)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button blueGreyButton = Button.create("BLUE GREY").setBackground(Background.BLUE_GREY).large();
        blueGreyButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.BLUE_GREY)
                        .setPosition(Notification.TOP_LEFT)
                        .show());


        Button deepOrangeButton = Button.create("DEEP ORANGE").setBackground(Background.DEEP_ORANGE).large();
        deepOrangeButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.DEEP_ORANGE)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button lightGreenButton = Button.create("LIGHT GREEN").setBackground(Background.LIGHT_GREEN).large();
        lightGreenButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.LIGHT_GREEN)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button blackButton = Button.create("BLACK").setBackground(Background.BLACK).large();
        blackButton.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .setBackground(Background.BLACK)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS")
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(redButton.block().asElement()))
                        .addColumn(column.copy().addElement(greenButton.block().asElement()))
                        .addColumn(column.copy().addElement(orangeButton.block().asElement()))
                        .addColumn(column.copy().addElement(blueButton.block().asElement()))
                        .addColumn(column.copy().addElement(tealButton.block().asElement()))
                        .addColumn(column.copy().addElement(cyanButton.block().asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(pinkButton.block().asElement()))
                        .addColumn(column.copy().addElement(purpleButton.block().asElement()))
                        .addColumn(column.copy().addElement(blueGreyButton.block().asElement()))
                        .addColumn(column.copy().addElement(deepOrangeButton.block().asElement()))
                        .addColumn(column.copy().addElement(lightGreenButton.block().asElement()))
                        .addColumn(column.copy().addElement(blackButton.block().asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.withMaterialColors())
                .asElement());

    }

    private void withAnimation() {
        Button fadeInOut = Button.create("FADE IN OUT").setBackground(Background.PINK).large();
        fadeInOut.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FADE_IN)
                        .outTransition(Transition.FADE_OUT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button fadeInOutLeft = Button.create("FADE IN OU LEFT").setBackground(Background.PINK).large();
        fadeInOutLeft.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FADE_IN_LEFT)
                        .outTransition(Transition.FADE_OUT_LEFT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button fadeInOutRight = Button.create("FADE IN OUT RIGHT").setBackground(Background.PINK).large();
        fadeInOutRight.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FADE_IN_RIGHT)
                        .outTransition(Transition.FADE_OUT_RIGHT)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button fadeInOutUp = Button.create("FADE IN OUT UP").setBackground(Background.PINK).large();
        fadeInOutUp.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FADE_IN_UP)
                        .outTransition(Transition.FADE_OUT_UP)
                        .setPosition(Notification.TOP_CENTER)
                        .show());

        Button fadeInOutDown = Button.create("FADE IN OUT DOWN").setBackground(Background.PINK).large();
        fadeInOutDown.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FADE_IN_DOWN)
                        .outTransition(Transition.FADE_OUT_DOWN)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button bouneInOut = Button.create("BOUNCE IN OUT").setBackground(Background.CYAN).large();
        bouneInOut.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.BOUNCE_IN)
                        .outTransition(Transition.BOUNCE_OUT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button bounceInOutLeft = Button.create("BOUNCE IN OUT LEFT").setBackground(Background.CYAN).large();
        bounceInOutLeft.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.BOUNCE_IN_LEFT)
                        .outTransition(Transition.BOUNCE_OUT_LEFT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button bounceInOutRight = Button.create("BOUNCE IN OUT RIGHT").setBackground(Background.CYAN).large();
        bounceInOutRight.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.BOUNCE_IN_RIGHT)
                        .outTransition(Transition.BOUNCE_OUT_RIGHT)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button bounceInOutUp = Button.create("BOUNCE IN OUT UP").setBackground(Background.CYAN).large();
        bounceInOutUp.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.BOUNCE_IN_UP)
                        .outTransition(Transition.BOUNCE_OUT_UP)
                        .setPosition(Notification.TOP_CENTER)
                        .show());


        Button bounceInOutDown = Button.create("BOUNCE IN OUT DOWN").setBackground(Background.CYAN).large();
        bounceInOutDown.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.BOUNCE_IN_DOWN)
                        .outTransition(Transition.BOUNCE_OUT_DOWN)
                        .setPosition(Notification.TOP_CENTER)
                        .show());

        Button rotateInOut = Button.create("ROTATE IN OUT").setBackground(Background.LIGHT_GREEN).large();
        rotateInOut.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ROTATE_IN)
                        .outTransition(Transition.ROTATE_OUT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button rotateInOutUpLeft = Button.create("ROTATE IN OUT UP LEFT").setBackground(Background.LIGHT_GREEN).large();
        rotateInOutUpLeft.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ROTATE_IN_UP_LEFT)
                        .outTransition(Transition.ROTATE_OUT_UP_LEFT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button rotateInOutUpRight = Button.create("ROTATE IN OUT UP RIGHT").setBackground(Background.LIGHT_GREEN).large();
        rotateInOutUpRight.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ROTATE_IN_UP_RIGHT)
                        .outTransition(Transition.ROTATE_OUT_UP_RIGHT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button rotateInOutDownLeft = Button.create("ROTATE IN OUT DOWN LEFT").setBackground(Background.LIGHT_GREEN).large();
        rotateInOutDownLeft.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ROTATE_IN_DOWN_LEFT)
                        .outTransition(Transition.ROTATE_OUT_DOWN_LEFT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button rotateInOutDownRight = Button.create("ROTATE IN OUT DOWN RIGHT").setBackground(Background.LIGHT_GREEN).large();
        rotateInOutDownRight.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ROTATE_IN_DOWN_RIGHT)
                        .outTransition(Transition.ROTATE_OUT_DOWN_RIGHT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());


        Button zoomInOut = Button.create("ZOOM IN OUT").setBackground(Background.TEAL).large();
        zoomInOut.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ZOOM_IN)
                        .outTransition(Transition.ZOOM_OUT)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button zoomInOutLeft = Button.create("ZOOM IN OUT LEFT").setBackground(Background.TEAL).large();
        zoomInOutLeft.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ZOOM_IN_LEFT)
                        .outTransition(Transition.ZOOM_OUT_LEFT)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button zoomInOutRight = Button.create("ZOOM IN OUT RIGHT").setBackground(Background.TEAL).large();
        zoomInOutRight.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ZOOM_IN_RIGHT)
                        .outTransition(Transition.ZOOM_OUT_RIGHT)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button zoomInOutUp = Button.create("ZOOM IN OUT UP").setBackground(Background.TEAL).large();
        zoomInOutUp.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ZOOM_IN_UP)
                        .outTransition(Transition.ZOOM_OUT_UP)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button zoomInOutDown = Button.create("ZOOM IN OUT DOWN").setBackground(Background.TEAL).large();
        zoomInOutDown.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ZOOM_IN_DOWN)
                        .outTransition(Transition.ZOOM_OUT_DOWN)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button flipInOutX = Button.create("FLIP IN OUT X").setBackground(Background.PURPLE).large();
        flipInOutX.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FLIP_IN_X)
                        .outTransition(Transition.FLIP_OUT_X)
                        .setPosition(Notification.BOTTOM_LEFT)
                        .show());

        Button flipInOutY = Button.create("FLIP IN OUT Y").setBackground(Background.PURPLE).large();
        flipInOutY.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FLIP_IN_Y)
                        .outTransition(Transition.FLIP_OUT_Y)
                        .setPosition(Notification.BOTTOM_RIGHT)
                        .show());

        Button lightSpeedInOut = Button.create("LIGHT SPEED IN OUT").setBackground(Background.INDIGO).large();
        lightSpeedInOut.getClickableElement().addEventListener("click", e ->
                Notification.create("You received a message")
                        .inTransition(Transition.LIGHT_SPEED_IN)
                        .outTransition(Transition.LIGHT_SPEED_OUT)
                        .setPosition(Notification.TOP_CENTER)
                        .show());

        element.appendChild(Card.create("NOTIFICATION ANIMATIONS")
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(fadeInOut.block().asElement()))
                        .addColumn(column.copy().addElement(fadeInOutLeft.block().asElement()))
                        .addColumn(column.copy().addElement(fadeInOutRight.block().asElement()))
                        .addColumn(column.copy().addElement(fadeInOutUp.block().asElement()))
                        .addColumn(column.copy().addElement(fadeInOutDown.block().asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(bouneInOut.block().asElement()))
                        .addColumn(column.copy().addElement(bounceInOutLeft.block().asElement()))
                        .addColumn(column.copy().addElement(bounceInOutRight.block().asElement()))
                        .addColumn(column.copy().addElement(bounceInOutUp.block().asElement()))
                        .addColumn(column.copy().addElement(bounceInOutDown.block().asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(rotateInOut.block().asElement()))
                        .addColumn(column.copy().addElement(rotateInOutUpLeft.block().asElement()))
                        .addColumn(column.copy().addElement(rotateInOutUpRight.block().asElement()))
                        .addColumn(column.copy().addElement(rotateInOutDownLeft.block().asElement()))
                        .addColumn(column.copy().addElement(rotateInOutDownRight.block().asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(zoomInOut.block().asElement()))
                        .addColumn(column.copy().addElement(zoomInOutLeft.block().asElement()))
                        .addColumn(column.copy().addElement(zoomInOutRight.block().asElement()))
                        .addColumn(column.copy().addElement(zoomInOutUp.block().asElement()))
                        .addColumn(column.copy().addElement(zoomInOutDown.block().asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(flipInOutX.block().asElement()))
                        .addColumn(column.copy().addElement(flipInOutY.block().asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(lightSpeedInOut.block().asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.withAnimation())
                .asElement());
    }
}