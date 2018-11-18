package org.dominokit.domino.notifications.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.notifications.client.presenters.NotificationsPresenter;
import org.dominokit.domino.notifications.client.views.NotificationsView;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = NotificationsPresenter.class)
public class NotificationsViewImpl extends ComponentView<HTMLDivElement> implements NotificationsView {

    public static final String MODULE_NAME = "notifications";
    private HTMLDivElement element = div().asElement();

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {

        element.appendChild(LinkToSourceCode.create(MODULE_NAME, this.getClass()).asElement());
        element.appendChild(BlockHeader.create("NOTIFICATIONS", "Taken by Bootstrap Notification ")
                .appendChild(a().attr("href", "https://github.com/mouse0270/bootstrap-notify")
                        .attr("target", "_blank")
                        .textContent("github.com/mouse0270/bootstrap-notify"))
                .asElement());

        notificationsPosition();
        notificationsTypes();
        withMaterialColors();
        withAnimation();

    }

    private void notificationsPosition() {
        Button topLeft = Button.createPrimary("TOP LEFT").large();
        topLeft.addClickListener( e ->
                Notification.create("You received a message")
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button topCenter = Button.createPrimary("TOP CENTER").large();
        topCenter.addClickListener( e ->
                Notification.create("You received a message")
                        .setPosition(Notification.TOP_CENTER)
                        .show());

        Button topRight = Button.createPrimary("TOP RIGHT").large();
        topRight.addClickListener( e ->
                Notification.create("You received a message")
                        .setPosition(Notification.TOP_RIGHT)
                        .show());


        Button bottomLeft = Button.createPrimary("BOTTOM LEFT").large();
        bottomLeft.addClickListener( e ->
                Notification.create("You received a message")
                        .setPosition(Notification.BOTTOM_LEFT)
                        .show());

        Button bottomCenter = Button.createPrimary("BOTTOM CENTER").large();
        bottomCenter.addClickListener( e ->
                Notification.create("You received a message")
                        .setPosition(Notification.BOTTOM_CENTER)
                        .show());

        Button bottomRight = Button.createPrimary("BOTTOM RIGHT").large();
        bottomRight.addClickListener( e ->
                Notification.create("You received a message")
                        .setPosition(Notification.BOTTOM_RIGHT)
                        .show());


        element.appendChild(Card.create("NOTIFICATION POSITIONS")
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(topLeft.block()))
                        .addColumn(Column.span2().appendChild(topCenter.block()))
                        .addColumn(Column.span2().appendChild(topRight.block()))
                        .addColumn(Column.span2().appendChild(bottomLeft.block()))
                        .addColumn(Column.span2().appendChild(bottomCenter.block()))
                        .addColumn(Column.span2().appendChild(bottomRight.block()))
                        )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"notificationsPosition")
                .asElement());
    }

    private void notificationsTypes() {

        Button danger = Button.createDanger("DANGER").large();
        danger.addClickListener( e ->
                Notification.createDanger("You received a message")
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button success = Button.createSuccess("SUCCESS").large();
        success.addClickListener( e ->
                Notification.createSuccess("You received a message")
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button warning = Button.createWarning("WARNING").large();
        warning.addClickListener( e ->
                Notification.createWarning("You received a message")
                        .setPosition(Notification.TOP_LEFT)
                        .show());


        Button info = Button.createInfo("INFO").large();
        info.addClickListener( e ->
                Notification.createInfo("You received a message")
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        element.appendChild(Card.create("NOTIFICATION TYPES", "Use predefined notification styles.")
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(danger.block()))
                        .addColumn(Column.span2().appendChild(success.block()))
                        .addColumn(Column.span2().appendChild(warning.block()))
                        .addColumn(Column.span2().appendChild(info.block()))
                        )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"notificationsTypes")
        .asElement());

    }

    private void withMaterialColors() {

        Button redButton = Button.create("RED").setBackground(Color.RED).large();
        redButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.RED)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button greenButton = Button.create("GREEN").setBackground(Color.GREEN).large();
        greenButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.GREEN)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button orangeButton = Button.create("ORANGE").setBackground(Color.ORANGE).large();
        orangeButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.ORANGE)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button blueButton = Button.create("BLUE").setBackground(Color.BLUE).large();
        blueButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.BLUE)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button tealButton = Button.create("TEAL").setBackground(Color.TEAL).large();
        tealButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.TEAL)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button cyanButton = Button.create("CYAN").setBackground(Color.CYAN).large();
        cyanButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.CYAN)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button pinkButton = Button.create("PINK").setBackground(Color.PINK).large();
        pinkButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.PINK)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button purpleButton = Button.create("PURPLE").setBackground(Color.PURPLE).large();
        purpleButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.PURPLE)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button blueGreyButton = Button.create("BLUE GREY").setBackground(Color.BLUE_GREY).large();
        blueGreyButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.BLUE_GREY)
                        .setPosition(Notification.TOP_LEFT)
                        .show());


        Button deepOrangeButton = Button.create("DEEP ORANGE").setBackground(Color.DEEP_ORANGE).large();
        deepOrangeButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.DEEP_ORANGE)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button lightGreenButton = Button.create("LIGHT GREEN").setBackground(Color.LIGHT_GREEN).large();
        lightGreenButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.LIGHT_GREEN)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button blackButton = Button.create("BLACK").setBackground(Color.BLACK).large();
        blackButton.addClickListener( e ->
                Notification.create("You received a message")
                        .setBackground(Color.BLACK)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS")
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(redButton.block()))
                        .addColumn(Column.span2().appendChild(greenButton.block()))
                        .addColumn(Column.span2().appendChild(orangeButton.block()))
                        .addColumn(Column.span2().appendChild(blueButton.block()))
                        .addColumn(Column.span2().appendChild(tealButton.block()))
                        .addColumn(Column.span2().appendChild(cyanButton.block()))
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(pinkButton.block()))
                        .addColumn(Column.span2().appendChild(purpleButton.block()))
                        .addColumn(Column.span2().appendChild(blueGreyButton.block()))
                        .addColumn(Column.span2().appendChild(deepOrangeButton.block()))
                        .addColumn(Column.span2().appendChild(lightGreenButton.block()))
                        .addColumn(Column.span2().appendChild(blackButton.block()))
                        )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"withMaterialColors")
                .asElement());

    }

    private void withAnimation() {
        Button fadeInOut = Button.create("FADE IN OUT").setBackground(Color.PINK).large();
        fadeInOut.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FADE_IN)
                        .outTransition(Transition.FADE_OUT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button fadeInOutLeft = Button.create("FADE IN OU LEFT").setBackground(Color.PINK).large();
        fadeInOutLeft.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FADE_IN_LEFT)
                        .outTransition(Transition.FADE_OUT_LEFT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button fadeInOutRight = Button.create("FADE IN OUT RIGHT").setBackground(Color.PINK).large();
        fadeInOutRight.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FADE_IN_RIGHT)
                        .outTransition(Transition.FADE_OUT_RIGHT)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button fadeInOutUp = Button.create("FADE IN OUT UP").setBackground(Color.PINK).large();
        fadeInOutUp.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FADE_IN_UP)
                        .outTransition(Transition.FADE_OUT_UP)
                        .setPosition(Notification.TOP_CENTER)
                        .show());

        Button fadeInOutDown = Button.create("FADE IN OUT DOWN").setBackground(Color.PINK).large();
        fadeInOutDown.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FADE_IN_DOWN)
                        .outTransition(Transition.FADE_OUT_DOWN)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button bouneInOut = Button.create("BOUNCE IN OUT").setBackground(Color.CYAN).large();
        bouneInOut.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.BOUNCE_IN)
                        .outTransition(Transition.BOUNCE_OUT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button bounceInOutLeft = Button.create("BOUNCE IN OUT LEFT").setBackground(Color.CYAN).large();
        bounceInOutLeft.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.BOUNCE_IN_LEFT)
                        .outTransition(Transition.BOUNCE_OUT_LEFT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button bounceInOutRight = Button.create("BOUNCE IN OUT RIGHT").setBackground(Color.CYAN).large();
        bounceInOutRight.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.BOUNCE_IN_RIGHT)
                        .outTransition(Transition.BOUNCE_OUT_RIGHT)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button bounceInOutUp = Button.create("BOUNCE IN OUT UP").setBackground(Color.CYAN).large();
        bounceInOutUp.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.BOUNCE_IN_UP)
                        .outTransition(Transition.BOUNCE_OUT_UP)
                        .setPosition(Notification.TOP_CENTER)
                        .show());


        Button bounceInOutDown = Button.create("BOUNCE IN OUT DOWN").setBackground(Color.CYAN).large();
        bounceInOutDown.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.BOUNCE_IN_DOWN)
                        .outTransition(Transition.BOUNCE_OUT_DOWN)
                        .setPosition(Notification.TOP_CENTER)
                        .show());

        Button rotateInOut = Button.create("ROTATE IN OUT").setBackground(Color.LIGHT_GREEN).large();
        rotateInOut.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ROTATE_IN)
                        .outTransition(Transition.ROTATE_OUT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button rotateInOutUpLeft = Button.create("ROTATE IN OUT UP LEFT").setBackground(Color.LIGHT_GREEN).large();
        rotateInOutUpLeft.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ROTATE_IN_UP_LEFT)
                        .outTransition(Transition.ROTATE_OUT_UP_LEFT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button rotateInOutUpRight = Button.create("ROTATE IN OUT UP RIGHT").setBackground(Color.LIGHT_GREEN).large();
        rotateInOutUpRight.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ROTATE_IN_UP_RIGHT)
                        .outTransition(Transition.ROTATE_OUT_UP_RIGHT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button rotateInOutDownLeft = Button.create("ROTATE IN OUT DOWN LEFT").setBackground(Color.LIGHT_GREEN).large();
        rotateInOutDownLeft.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ROTATE_IN_DOWN_LEFT)
                        .outTransition(Transition.ROTATE_OUT_DOWN_LEFT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());

        Button rotateInOutDownRight = Button.create("ROTATE IN OUT DOWN RIGHT").setBackground(Color.LIGHT_GREEN).large();
        rotateInOutDownRight.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ROTATE_IN_DOWN_RIGHT)
                        .outTransition(Transition.ROTATE_OUT_DOWN_RIGHT)
                        .setPosition(Notification.TOP_LEFT)
                        .show());


        Button zoomInOut = Button.create("ZOOM IN OUT").setBackground(Color.TEAL).large();
        zoomInOut.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ZOOM_IN)
                        .outTransition(Transition.ZOOM_OUT)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button zoomInOutLeft = Button.create("ZOOM IN OUT LEFT").setBackground(Color.TEAL).large();
        zoomInOutLeft.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ZOOM_IN_LEFT)
                        .outTransition(Transition.ZOOM_OUT_LEFT)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button zoomInOutRight = Button.create("ZOOM IN OUT RIGHT").setBackground(Color.TEAL).large();
        zoomInOutRight.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ZOOM_IN_RIGHT)
                        .outTransition(Transition.ZOOM_OUT_RIGHT)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button zoomInOutUp = Button.create("ZOOM IN OUT UP").setBackground(Color.TEAL).large();
        zoomInOutUp.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ZOOM_IN_UP)
                        .outTransition(Transition.ZOOM_OUT_UP)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button zoomInOutDown = Button.create("ZOOM IN OUT DOWN").setBackground(Color.TEAL).large();
        zoomInOutDown.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.ZOOM_IN_DOWN)
                        .outTransition(Transition.ZOOM_OUT_DOWN)
                        .setPosition(Notification.TOP_RIGHT)
                        .show());

        Button flipInOutX = Button.create("FLIP IN OUT X").setBackground(Color.PURPLE).large();
        flipInOutX.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FLIP_IN_X)
                        .outTransition(Transition.FLIP_OUT_X)
                        .setPosition(Notification.BOTTOM_LEFT)
                        .show());

        Button flipInOutY = Button.create("FLIP IN OUT Y").setBackground(Color.PURPLE).large();
        flipInOutY.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.FLIP_IN_Y)
                        .outTransition(Transition.FLIP_OUT_Y)
                        .setPosition(Notification.BOTTOM_RIGHT)
                        .show());

        Button lightSpeedInOut = Button.create("LIGHT SPEED IN OUT").setBackground(Color.INDIGO).large();
        lightSpeedInOut.addClickListener( e ->
                Notification.create("You received a message")
                        .inTransition(Transition.LIGHT_SPEED_IN)
                        .outTransition(Transition.LIGHT_SPEED_OUT)
                        .setPosition(Notification.TOP_CENTER)
                        .show());

        element.appendChild(Card.create("NOTIFICATION ANIMATIONS")
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(fadeInOut.block()))
                        .addColumn(Column.span2().appendChild(fadeInOutLeft.block()))
                        .addColumn(Column.span2().appendChild(fadeInOutRight.block()))
                        .addColumn(Column.span2().appendChild(fadeInOutUp.block()))
                        .addColumn(Column.span2().appendChild(fadeInOutDown.block()))
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(bouneInOut.block()))
                        .addColumn(Column.span2().appendChild(bounceInOutLeft.block()))
                        .addColumn(Column.span2().appendChild(bounceInOutRight.block()))
                        .addColumn(Column.span2().appendChild(bounceInOutUp.block()))
                        .addColumn(Column.span2().appendChild(bounceInOutDown.block()))
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(rotateInOut.block()))
                        .addColumn(Column.span2().appendChild(rotateInOutUpLeft.block()))
                        .addColumn(Column.span2().appendChild(rotateInOutUpRight.block()))
                        .addColumn(Column.span2().appendChild(rotateInOutDownLeft.block()))
                        .addColumn(Column.span2().appendChild(rotateInOutDownRight.block()))
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(zoomInOut.block()))
                        .addColumn(Column.span2().appendChild(zoomInOutLeft.block()))
                        .addColumn(Column.span2().appendChild(zoomInOutRight.block()))
                        .addColumn(Column.span2().appendChild(zoomInOutUp.block()))
                        .addColumn(Column.span2().appendChild(zoomInOutDown.block()))
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(flipInOutX.block()))
                        .addColumn(Column.span2().appendChild(flipInOutY.block()))
                        )
                .appendChild(Row.create()
                        .addColumn(Column.span2().appendChild(lightSpeedInOut.block()))
                        )
                .asElement());

        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"withAnimation")
                .asElement());
    }
}