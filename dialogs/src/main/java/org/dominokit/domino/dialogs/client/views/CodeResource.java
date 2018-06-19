package org.dominokit.domino.dialogs.client.views;

public class CodeResource {

    public static String dialogs() {
        return "MessageDialog basicMessage = MessageDialog.createMessage(\"Here's a message!\",\n" +
                "        () -> Notification.create(\"Dialog closed\").show());\n" +
                "\n" +
                "MessageDialog headerAndMessage = MessageDialog.createMessage(\"Message header\",\n" +
                "        \"Here's a message body!\",\n" +
                "        () -> Notification.create(\"Dialog closed\").show());\n" +
                "\n" +
                "MessageDialog successMessage = MessageDialog.createMessage(\"Success Operation\",\n" +
                "        \"Well done! You successfully read this important alert message.\",\n" +
                "        () -> Notification.create(\"Dialog closed\").show())\n" +
                "        .success();\n" +
                "\n" +
                "MessageDialog errorMessage = MessageDialog.createMessage(\"Failed operation\",\n" +
                "        \"Oh snap! Change a few things up and try submitting again.\",\n" +
                "        () -> Notification.create(\"Dialog closed\").show())\n" +
                "        .error();\n" +
                "\n" +
                "MessageDialog customColors = MessageDialog.createMessage(\"Failed operation\",\n" +
                "        \"Oh snap! Change a few things up and try submitting again.\",\n" +
                "        () -> Notification.create(\"Dialog closed\").show())\n" +
                "        .error()\n" +
                "        .setModalColor(Color.RED)\n" +
                "        .setIconColor(Color.WHITE);\n" +
                "\n" +
                "MessageDialog warningMessage = MessageDialog.createMessage(\"Warning\",\n" +
                "        \"Warning! Better check yourself, you're not looking too good.\",\n" +
                "        () -> Notification.create(\"Dialog closed\").show())\n" +
                "        .warning();\n" +
                "\n" +
                "HTMLElement heart = Icons.ALL.favorite().asElement();\n" +
                "heart.classList.add(Styles.font_72, Styles.m_b_15, Color.RED.getStyle());\n" +
                "\n" +
                "MessageDialog customHeaderContent = MessageDialog.createMessage(\"Custom header\",\n" +
                "        \"You can customize the header content\",\n" +
                "        () -> Notification.create(\"Dialog closed\").show())\n" +
                "        .onOpen(() -> Animation.create(heart)\n" +
                "                .duration(400)\n" +
                "                .infinite()\n" +
                "                .transition(Transition.PULSE)\n" +
                "                .animate())\n" +
                "        .appendHeaderContent(heart);\n" +
                "\n" +
                "HTMLUListElement listGroup = SimpleListGroup.create()\n" +
                "        .appendItem(SimpleListItem.create(\"Cras justo odio\")\n" +
                "                .appendContent(Badge.create(\"14 new\").setBackground(Color.PINK).asElement()))\n" +
                "\n" +
                "        .appendItem(SimpleListItem.create(\"Dapibus ac facilisis in\")\n" +
                "                .appendContent(Badge.create(\"99 unread\").setBackground(Color.CYAN).asElement()))\n" +
                "\n" +
                "        .appendItem(SimpleListItem.create(\"Morbi leo risus\")\n" +
                "                .appendContent(Badge.create(\"99+\").setBackground(Color.TEAL).asElement()))\n" +
                "\n" +
                "        .appendItem(SimpleListItem.create(\"Porta ac consectetur ac\")\n" +
                "                .appendContent(Badge.create(\"21\").setBackground(Color.ORANGE).asElement()))\n" +
                "\n" +
                "        .appendItem(SimpleListItem.create(\"Vestibulum at eros\")\n" +
                "                .appendContent(Badge.create(\"Pending\").setBackground(Color.PURPLE).asElement()))\n" +
                "        .asElement();\n" +
                "\n" +
                "listGroup.style.setProperty(\"text-align\", \"left\");\n" +
                "MessageDialog customContent = MessageDialog.createMessage(\"Custom content\",\n" +
                "        \"You can customize the dialog content\",\n" +
                "        () -> Notification.create(\"Dialog closed\").show())\n" +
                "        .appendContent(listGroup);\n" +
                "\n" +
                "\n" +
                "this.element.appendChild(Card.create(\"EXAMPLES\")\n" +
                "    .appendContent(Row.create()\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(basicMessage.asElement())\n" +
                "                    .addElement(Paragraph.create(\"A basic message\").asElement())\n" +
                "                    .addElement(createDemoButton(basicMessage)))\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(headerAndMessage.asElement())\n" +
                "                    .addElement(Paragraph.create(\"Message with header\").asElement())\n" +
                "                    .addElement(createDemoButton(headerAndMessage)))\n" +
                "            .asElement())\n" +
                "    .appendContent(Row.create()\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(successMessage.asElement())\n" +
                "                    .addElement(Paragraph.create(\"Success message\").asElement())\n" +
                "                    .addElement(createDemoButton(successMessage)))\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(errorMessage.asElement())\n" +
                "                    .addElement(Paragraph.create(\"Error message\").asElement())\n" +
                "                    .addElement(createDemoButton(errorMessage)))\n" +
                "            .asElement())\n" +
                "    .appendContent(Row.create()\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(warningMessage.asElement())\n" +
                "                    .addElement(Paragraph.create(\"Warning message\").asElement())\n" +
                "                    .addElement(createDemoButton(warningMessage)))\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(customColors.asElement())\n" +
                "                    .addElement(Paragraph.create(\"Custom colors\").asElement())\n" +
                "                    .addElement(createDemoButton(customColors)))\n" +
                "            .asElement())\n" +
                "    .appendContent(Row.create()\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(customHeaderContent.asElement())\n" +
                "                    .addElement(Paragraph.create(\"Custom header content\").asElement())\n" +
                "                    .addElement(createDemoButton(customHeaderContent)))\n" +
                "            .addColumn(column.copy()\n" +
                "                    .addElement(customContent.asElement())\n" +
                "                    .addElement(Paragraph.create(\"Custom content\").asElement())\n" +
                "                    .addElement(createDemoButton(customContent)))\n" +
                "            .asElement())\n" +
                "    .asElement());\n" +
                "\n" +
                "\n" +
                "\n" +
                "    //---------------------\n" +
                "\n" +
                "\n" +
                "private HTMLElement createDemoButton(MessageDialog dialog) {\n" +
                "    return Button.createPrimary(\"CLICK ME\")\n" +
                "            .setStyleProperty(\"min-width\", \"120px\")\n" +
                "            .addClickListener(evt -> dialog.open()).asElement();\n" +
                "}";
    }
}
