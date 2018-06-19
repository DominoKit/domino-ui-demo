package org.dominokit.domino.notifications.client.views;

public class CodeResource {

    public static String notificationsPosition() {
        return "//Show notifications on pre-defined positions\n" +
                "//Notification.TOP_LEFT\n" +
                "//Notification.TOP_CENTER\n" +
                "//Notification.TOP_RIGHT\n" +
                "//Notification.BOTTOM_LEFT\n" +
                "//Notification.BOTTOM_CENTER\n" +
                "//Notification.BOTTOM_RIGHT\n" +
                "\n" +
                "Notification.create(\"You received a message\")\n" +
                "        .setPosition(Notification.BOTTOM_RIGHT)\n" +
                "        .show());\"";
    }

    public static String notificationsTypes() {
        return "Button danger = Button.createDanger(\"DANGER\").large();\n" +
                "danger.getClickableElement().addEventListener(\"click\", e ->\n" +
                "        Notification.createDanger(\"You received a message\")\n" +
                "                .setPosition(Notification.TOP_LEFT)\n" +
                "                .show());\n" +
                "\n" +
                "Button success = Button.createSuccess(\"SUCCESS\").large();\n" +
                "success.getClickableElement().addEventListener(\"click\", e ->\n" +
                "        Notification.createSuccess(\"You received a message\")\n" +
                "                .setPosition(Notification.TOP_LEFT)\n" +
                "                .show());\n" +
                "\n" +
                "Button warning = Button.createWarning(\"WARNING\").large();\n" +
                "warning.getClickableElement().addEventListener(\"click\", e ->\n" +
                "        Notification.createWarning(\"You received a message\")\n" +
                "                .setPosition(Notification.TOP_LEFT)\n" +
                "                .show());\n" +
                "\n" +
                "\n" +
                "Button info = Button.createInfo(\"INFO\").large();\n" +
                "info.getClickableElement().addEventListener(\"click\", e ->\n" +
                "        Notification.createInfo(\"You received a message\")\n" +
                "                .setPosition(Notification.TOP_LEFT)\n" +
                "                .show());";
    }

    public static String withMaterialColors() {
        return "//Change the color of the notification by setting the background\n" +
                "Notification.create(\"You received a message\")\n" +
                "        .setBackground(Background.TEAL)\n" +
                "        .setPosition(Notification.TOP_LEFT)\n" +
                "        .show();";
    }

    public static String withAnimation() {
        return "//Use the IN transition, OUT transition for transaction appear/disappear animation\n" +
                "//use duration to set the wait time before the notification automatically disappear\n" +
                "\n" +
                "Notification.create(\"You received a message\")\n" +
                "        .duration(5000)\n" +
                "        .inTransition(Transition.LIGHT_SPEED_IN)\n" +
                "        .outTransition(Transition.LIGHT_SPEED_OUT)\n" +
                "        .setPosition(Notification.TOP_CENTER)\n" +
                "        .show();";
    }

}

