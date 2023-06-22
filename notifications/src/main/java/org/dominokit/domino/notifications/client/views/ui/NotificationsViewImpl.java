package org.dominokit.domino.notifications.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.notifications.client.presenters.NotificationsProxy;
import org.dominokit.domino.notifications.client.views.NotificationsView;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.typography.BlockHeader;

import static org.dominokit.domino.ui.notifications.Notification.Position.BOTTOM_LEFT;
import static org.dominokit.domino.ui.notifications.Notification.Position.BOTTOM_MIDDLE;
import static org.dominokit.domino.ui.notifications.Notification.Position.BOTTOM_RIGHT;
import static org.dominokit.domino.ui.notifications.Notification.Position.TOP_LEFT;
import static org.dominokit.domino.ui.notifications.Notification.Position.TOP_MIDDLE;
import static org.dominokit.domino.ui.notifications.Notification.Position.TOP_RIGHT;

@UiView(presentable = NotificationsProxy.class)
@SampleClass
public class NotificationsViewImpl extends BaseDemoView<HTMLDivElement> implements NotificationsView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("notifications", this.getClass()));
        element.appendChild(BlockHeader.create("NOTIFICATIONS"));

        notificationsPosition();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.notificationsPosition()));

        notificationsTypes();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.notificationsTypes()));

        withMaterialColors();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withMaterialColors()));

        withAnimation();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withAnimation()));

        return element.element();
    }

    @SampleMethod
    private void notificationsPosition() {
        Button topLeft = Button.create("TOP LEFT")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(TOP_LEFT)
                                .addCss(dui_black)
                                .show());

        Button topCenter = Button.create("TOP CENTER")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(TOP_MIDDLE)
                                .addCss(dui_black)
                                .show());

        Button topRight = Button.create("TOP RIGHT")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(TOP_RIGHT)
                                .addCss(dui_black)
                                .show());


        Button bottomLeft = Button.create("BOTTOM LEFT")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(BOTTOM_LEFT)
                                .addCss(dui_black)
                                .show());

        Button bottomCenter = Button.create("BOTTOM CENTER")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(BOTTOM_MIDDLE)
                                .addCss(dui_black)
                                .show());

        Button bottomRight = Button.create("BOTTOM RIGHT")
                .addCss(dui_primary, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .setPosition(BOTTOM_RIGHT)
                                .addCss(dui_black)
                                .show());


        element.appendChild(Card.create("NOTIFICATION POSITIONS")
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(topLeft))
                        .appendChild(Column.span2().appendChild(topCenter))
                        .appendChild(Column.span2().appendChild(topRight))
                        .appendChild(Column.span2().appendChild(bottomLeft))
                        .appendChild(Column.span2().appendChild(bottomCenter))
                        .appendChild(Column.span2().appendChild(bottomRight))
                )
        );
    }

    @SampleMethod
    private void notificationsTypes() {

        Button danger = Button.create("DANGER")
                .addCss(dui_error, dui_w_full)
                .addClickListener(e ->
                        Notification.create()
                                .setDismissible(true)
                                .addCss(dui_error, dui_rounded_full)
                                .setPosition(TOP_LEFT)
                                .appendChild(div()
                                        .addCss(dui_flex, dui_items_center)
                                        .appendChild(Icons.alert_circle().addCss(dui_fg))
                                        .appendChild(span().textContent("Invalid action, please try something else.!"))
                                )
                                .show());

        Button success = Button.create("SUCCESS")
                .addCss(dui_success, dui_w_full)
                .addClickListener(e ->
                        Notification.create()
                                .setDismissible(true)
                                .addCss(dui_success, dui_rounded_full)
                                .setPosition(TOP_LEFT)
                                .appendChild(div()
                                        .addCss(dui_flex, dui_items_center)
                                        .appendChild(Icons.bell_check_outline().addCss(dui_fg))
                                        .appendChild(span().textContent("Operation completed successfully."))
                                )
                                .show());

        Button warning = Button.create("WARNING")
                .addCss(dui_warning, dui_w_full)
                .addClickListener(e ->
                        Notification.create()
                                .setDismissible(true)
                                .addCss(dui_warning, dui_rounded_full)
                                .setPosition(TOP_LEFT)
                                .appendChild(div()
                                        .addCss(dui_flex, dui_items_center, dui_gap_1)
                                        .appendChild(Icons.bell_alert_outline().addCss(dui_fg))
                                        .appendChild(span().textContent("Operation completed with warnings."))
                                        .appendChild(Badge.create("15").addCss(dui_bg_d_2, dui_fg, dui_rounded_full))
                                )
                                .show());


        Button info = Button.create("INFO")
                .addCss(dui_info, dui_w_full)
                .addClickListener(e ->
                        Notification.create()
                                .setDismissible(true)
                                .addCss(dui_info, dui_rounded_full)
                                .setPosition(TOP_LEFT)
                                .appendChild(div()
                                        .addCss(dui_flex, dui_items_center, dui_gap_2)
                                        .appendChild(Icons.information_outline().addCss(dui_fg))
                                        .appendChild(span().textContent("Follow up ID generated, click to copy."))
                                        .appendChild(Badge.create("123456789").addCss(dui_bg_d_2, dui_fg, dui_rounded_full))
                                        .appendChild(Icons.content_copy().clickable())
                                )
                                .show());

        element.appendChild(Card.create("NOTIFICATION TYPES", "Use predefined notification styles.")
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(danger))
                        .appendChild(Column.span2().appendChild(success))
                        .appendChild(Column.span2().appendChild(warning))
                        .appendChild(Column.span2().appendChild(info))
                )
        );

    }

    @SampleMethod
    private void withMaterialColors() {

        Button redButton = Button.create("RED")
                .addCss(dui_red, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_red)
                                .setPosition(TOP_LEFT)
                                .show());

        Button greenButton = Button.create("GREEN")
                .addCss(dui_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_green)
                                .setPosition(TOP_LEFT)
                                .show());

        Button orangeButton = Button.create("ORANGE")
                .addCss(dui_orange, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_orange)
                                .setPosition(TOP_LEFT)
                                .show());

        Button blueButton = Button.create("BLUE")
                .addCss(dui_blue, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_blue)
                                .setPosition(TOP_LEFT)
                                .show());

        Button tealButton = Button.create("TEAL")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_teal)
                                .setPosition(TOP_LEFT)
                                .show());

        Button cyanButton = Button.create("CYAN")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_cyan)
                                .setPosition(TOP_LEFT)
                                .show());

        Button pinkButton = Button.create("PINK")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_pink)
                                .setPosition(TOP_LEFT)
                                .show());

        Button purpleButton = Button.create("PURPLE")
                .addCss(dui_purple, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_purple)
                                .setPosition(TOP_LEFT)
                                .show());

        Button blueGreyButton = Button.create("BLUE GREY")
                .addCss(dui_blue_grey, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_blue_grey)
                                .setPosition(TOP_LEFT)
                                .show());


        Button deepOrangeButton = Button.create("DEEP ORANGE")
                .addCss(dui_deep_orange, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_deep_orange)
                                .setPosition(TOP_LEFT)
                                .show());

        Button lightGreenButton = Button.create("LIGHT GREEN")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_light_green)
                                .setPosition(TOP_LEFT)
                                .show());

        Button blackButton = Button.create("BLACK")
                .addCss(dui_black, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDismissible(true)
                                .addCss(dui_black)
                                .setPosition(TOP_LEFT)
                                .show());

        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS")
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(redButton))
                        .appendChild(Column.span2().appendChild(greenButton))
                        .appendChild(Column.span2().appendChild(orangeButton))
                        .appendChild(Column.span2().appendChild(blueButton))
                        .appendChild(Column.span2().appendChild(tealButton))
                        .appendChild(Column.span2().appendChild(cyanButton))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(pinkButton))
                        .appendChild(Column.span2().appendChild(purpleButton))
                        .appendChild(Column.span2().appendChild(blueGreyButton))
                        .appendChild(Column.span2().appendChild(deepOrangeButton))
                        .appendChild(Column.span2().appendChild(lightGreenButton))
                        .appendChild(Column.span2().appendChild(blackButton))
                )
                .element());


    }

    @SampleMethod
    private void withAnimation() {
        Button fadeInOut = Button.create("FADE IN OUT")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FADE_IN)
                                .outTransition(Transition.FADE_OUT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button fadeInOutLeft = Button.create("FADE IN OU LEFT")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FADE_IN_LEFT)
                                .outTransition(Transition.FADE_OUT_LEFT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button fadeInOutRight = Button.create("FADE IN OUT RIGHT")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FADE_IN_RIGHT)
                                .outTransition(Transition.FADE_OUT_RIGHT)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button fadeInOutUp = Button.create("FADE IN OUT UP")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FADE_IN_UP)
                                .outTransition(Transition.FADE_OUT_UP)
                                .setPosition(TOP_MIDDLE)
                                .show());

        Button fadeInOutDown = Button.create("FADE IN OUT DOWN")
                .addCss(dui_pink, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FADE_IN_DOWN)
                                .outTransition(Transition.FADE_OUT_DOWN)
                                .setPosition(TOP_LEFT)
                                .show());

        Button bouneInOut = Button.create("BOUNCE IN OUT")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.BOUNCE_IN)
                                .outTransition(Transition.BOUNCE_OUT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button bounceInOutLeft = Button.create("BOUNCE IN OUT LEFT")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.BOUNCE_IN_LEFT)
                                .outTransition(Transition.BOUNCE_OUT_LEFT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button bounceInOutRight = Button.create("BOUNCE IN OUT RIGHT")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.BOUNCE_IN_RIGHT)
                                .outTransition(Transition.BOUNCE_OUT_RIGHT)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button bounceInOutUp = Button.create("BOUNCE IN OUT UP")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.BOUNCE_IN_UP)
                                .outTransition(Transition.BOUNCE_OUT_UP)
                                .setPosition(TOP_MIDDLE)
                                .show());


        Button bounceInOutDown = Button.create("BOUNCE IN OUT DOWN")
                .addCss(dui_cyan, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.BOUNCE_IN_DOWN)
                                .outTransition(Transition.BOUNCE_OUT_DOWN)
                                .setPosition(TOP_MIDDLE)
                                .show());

        Button rotateInOut = Button.create("ROTATE IN OUT")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ROTATE_IN)
                                .outTransition(Transition.ROTATE_OUT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button rotateInOutUpLeft = Button.create("ROTATE IN OUT UP LEFT")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ROTATE_IN_UP_LEFT)
                                .outTransition(Transition.ROTATE_OUT_UP_LEFT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button rotateInOutUpRight = Button.create("ROTATE IN OUT UP RIGHT")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ROTATE_IN_UP_RIGHT)
                                .outTransition(Transition.ROTATE_OUT_UP_RIGHT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button rotateInOutDownLeft = Button.create("ROTATE IN OUT DOWN LEFT")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ROTATE_IN_DOWN_LEFT)
                                .outTransition(Transition.ROTATE_OUT_DOWN_LEFT)
                                .setPosition(TOP_LEFT)
                                .show());

        Button rotateInOutDownRight = Button.create("ROTATE IN OUT DOWN RIGHT")
                .addCss(dui_light_green, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ROTATE_IN_DOWN_RIGHT)
                                .outTransition(Transition.ROTATE_OUT_DOWN_RIGHT)
                                .setPosition(TOP_LEFT)
                                .show());


        Button zoomInOut = Button.create("ZOOM IN OUT")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ZOOM_IN)
                                .outTransition(Transition.ZOOM_OUT)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button zoomInOutLeft = Button.create("ZOOM IN OUT LEFT")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ZOOM_IN_LEFT)
                                .outTransition(Transition.ZOOM_OUT_LEFT)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button zoomInOutRight = Button.create("ZOOM IN OUT RIGHT")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ZOOM_IN_RIGHT)
                                .outTransition(Transition.ZOOM_OUT_RIGHT)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button zoomInOutUp = Button.create("ZOOM IN OUT UP")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ZOOM_IN_UP)
                                .outTransition(Transition.ZOOM_OUT_UP)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button zoomInOutDown = Button.create("ZOOM IN OUT DOWN")
                .addCss(dui_teal, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.ZOOM_IN_DOWN)
                                .outTransition(Transition.ZOOM_OUT_DOWN)
                                .setPosition(TOP_RIGHT)
                                .show());

        Button flipInOutX = Button.create("FLIP IN OUT X")
                .addCss(dui_purple, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FLIP_IN_X)
                                .outTransition(Transition.FLIP_OUT_X)
                                .setPosition(BOTTOM_LEFT)
                                .show());

        Button flipInOutY = Button.create("FLIP IN OUT Y")
                .addCss(dui_purple, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.FLIP_IN_Y)
                                .outTransition(Transition.FLIP_OUT_Y)
                                .setPosition(BOTTOM_RIGHT)
                                .show());

        Button lightSpeedInOut = Button.create("LIGHT SPEED IN OUT")
                .addCss(dui_indigo, dui_w_full)
                .addClickListener(e ->
                        Notification.create("You received a message")
                                .setDuration(2500)
                                .inTransition(Transition.LIGHT_SPEED_IN)
                                .outTransition(Transition.LIGHT_SPEED_OUT)
                                .setPosition(TOP_MIDDLE)
                                .show());

        element.appendChild(Card.create("NOTIFICATION ANIMATIONS")
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(fadeInOut))
                        .appendChild(Column.span2().appendChild(fadeInOutLeft))
                        .appendChild(Column.span2().appendChild(fadeInOutRight))
                        .appendChild(Column.span2().appendChild(fadeInOutUp))
                        .appendChild(Column.span2().appendChild(fadeInOutDown))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(bouneInOut))
                        .appendChild(Column.span2().appendChild(bounceInOutLeft))
                        .appendChild(Column.span2().appendChild(bounceInOutRight))
                        .appendChild(Column.span2().appendChild(bounceInOutUp))
                        .appendChild(Column.span2().appendChild(bounceInOutDown))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(rotateInOut))
                        .appendChild(Column.span2().appendChild(rotateInOutUpLeft))
                        .appendChild(Column.span2().appendChild(rotateInOutUpRight))
                        .appendChild(Column.span2().appendChild(rotateInOutDownLeft))
                        .appendChild(Column.span2().appendChild(rotateInOutDownRight))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(zoomInOut))
                        .appendChild(Column.span2().appendChild(zoomInOutLeft))
                        .appendChild(Column.span2().appendChild(zoomInOutRight))
                        .appendChild(Column.span2().appendChild(zoomInOutUp))
                        .appendChild(Column.span2().appendChild(zoomInOutDown))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(flipInOutX))
                        .appendChild(Column.span2().appendChild(flipInOutY))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span2().appendChild(lightSpeedInOut))
                )
                .element());


    }
}