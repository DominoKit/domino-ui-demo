package org.dominokit.domino.timepicker.client.views;

public class CodeResource {

    public static String inlined() {
        return "element.appendChild(Card.create(\"INLINED\")\n" +
                "    .appendContent(Row.create()\n" +
                "            .addColumn(column.copy().addElement(TimePicker.create()\n" +
                "                    .fixedWidth(\"270px\")\n" +
                "                    .showBorder()\n" +
                "                    .hideClearButton()\n" +
                "                    .hideCloseButton()\n" +
                "                    .addTimeSelectionHandler((time, dateTimeFormatInfo, timePicker) ->\n" +
                "                            DomGlobal.console.info(timePicker.getFormattedTime())\n" +
                "                    )\n" +
                "                    .asElement()))\n" +
                "            .addColumn(column.copy().addElement(TimePicker.create(new DateTimeFormatInfoImpl_de())\n" +
                "                    .fixedWidth(\"270px\")\n" +
                "                    .setColorScheme(ColorScheme.PINK)\n" +
                "                    .showBorder()\n" +
                "                    .hideClearButton()\n" +
                "                    .setShowSwitchers(true)\n" +
                "                    .hideCloseButton()\n" +
                "                    .addTimeSelectionHandler((time, dateTimeFormatInfo, timePicker) ->\n" +
                "                            DomGlobal.console.info(timePicker.getFormattedTime()))\n" +
                "                    .todayButtonText(\"nu\")\n" +
                "                    .asElement()))\n" +
                "            .addColumn(column.copy().addElement(TimePicker.create()\n" +
                "                    .fixedWidth(\"270px\")\n" +
                "                    .setColorScheme(ColorScheme.GREEN)\n" +
                "                    .setClockStyle(ClockStyle._24)\n" +
                "                    .showBorder()\n" +
                "                    .hideClearButton()\n" +
                "                    .hideCloseButton()\n" +
                "                    .addTimeSelectionHandler((time, dateTimeFormatInfo, timePicker) ->\n" +
                "                            DomGlobal.console.info(timePicker.getFormattedTime()))\n" +
                "                    .asElement()))\n" +
                "            .asElement())\n" +
                "    .asElement());";
    }

    public static String popups() {
        return "Button bluePopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());\n" +
                "TimePicker bluePopTimePicker = TimePicker.create()\n" +
                "        .showBorder()\n" +
                "        .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->\n" +
                "                DomGlobal.console.info(picker.getFormattedTime()));\n" +
                "Popover bluePopover = Popover.create(bluePopupButton.asElement(), \"Wakeup\", bluePopTimePicker\n" +
                "        .asElement());\n" +
                "\n" +
                "bluePopTimePicker.addCloseHandler(() -> bluePopover.close());\n" +
                "bluePopTimePicker.addClearHandler(() ->\n" +
                "        Notification.create(\"a Click on clear button\")\n" +
                "                .setPosition(Notification.TOP_LEFT)\n" +
                "                .setBackground(ColorScheme.BLUE.color())\n" +
                "                .show());\n" +
                "\n" +
                "\n" +
                "Button pinkPopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.PINK.color());\n" +
                "TimePicker pinkPopDatePicker = TimePicker.create(new DateTimeFormatInfoImpl_de())\n" +
                "        .setColorScheme(ColorScheme.PINK)\n" +
                "        .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->\n" +
                "                DomGlobal.console.info(picker.getFormattedTime()));\n" +
                "Popover pinkPopover = Popover.createPicker(pinkPopupButton.asElement(),  pinkPopDatePicker\n" +
                "        .asElement());\n" +
                "\n" +
                "pinkPopDatePicker.addCloseHandler(() -> pinkPopover.close());\n" +
                "pinkPopDatePicker.addClearHandler(() ->\n" +
                "        Notification.create(\"a Click on clear button\")\n" +
                "                .setPosition(Notification.TOP_CENTER)\n" +
                "                .setBackground(ColorScheme.PINK.color())\n" +
                "                .show());\n" +
                "\n" +
                "\n" +
                "Button greenPopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());\n" +
                "TimePicker greenPopDatePicker = TimePicker.create()\n" +
                "        .setColorScheme(ColorScheme.GREEN)\n" +
                "        .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->\n" +
                "                DomGlobal.console.info(picker.getFormattedTime()));\n" +
                "Popover greenPopover = Popover.createPicker(greenPopupButton.asElement(), greenPopDatePicker\n" +
                "        .asElement());\n" +
                "\n" +
                "greenPopDatePicker.addCloseHandler(() -> greenPopover.close());\n" +
                "greenPopDatePicker.addClearHandler(() ->\n" +
                "        Notification.create(\"a Click on clear button\")\n" +
                "                .setPosition(Notification.TOP_RIGHT)\n" +
                "                .setBackground(ColorScheme.GREEN.color())\n" +
                "                .show());\n" +
                "\n" +
                "\n" +
                "Button blueModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());\n" +
                "TimePicker blueDatePicker = TimePicker.create()\n" +
                "        .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->\n" +
                "                DomGlobal.console.info(picker.getFormattedTime()));\n" +
                "\n" +
                "ModalDialog blueModal = blueDatePicker.createModal(\"Wakeup\");\n" +
                "blueDatePicker.addCloseHandler(() -> blueModal.close());\n" +
                "blueDatePicker.addClearHandler(() -> Notification.create(\"a Click on clear button\")\n" +
                "        .setPosition(Notification.TOP_LEFT)\n" +
                "        .setBackground(ColorScheme.BLUE.color())\n" +
                "        .show());\n" +
                "\n" +
                "\n" +
                "blueModal.appendContent(blueDatePicker.asElement());\n" +
                "DomGlobal.document.body.appendChild(blueModal.asElement());\n" +
                "\n" +
                "blueModalButton.addClickListener(evt -> blueModal.open());\n" +
                "\n" +
                "\n" +
                "Button pinkModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.PINK.color());\n" +
                "TimePicker pinkDatePicker = TimePicker.create()\n" +
                "        .setColorScheme(ColorScheme.PINK)\n" +
                "        .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->\n" +
                "                DomGlobal.console.info(picker.getFormattedTime()));\n" +
                "ModalDialog pinkModal = pinkDatePicker.createModal(\"Wakeup\");\n" +
                "\n" +
                "pinkDatePicker.addCloseHandler(() -> pinkModal.close());\n" +
                "pinkDatePicker.addClearHandler(() -> Notification.create(\"a Click on clear button\")\n" +
                "        .setPosition(Notification.TOP_CENTER)\n" +
                "        .setBackground(ColorScheme.PINK.color())\n" +
                "        .show());\n" +
                "\n" +
                "pinkModal.appendContent(pinkDatePicker.asElement());\n" +
                "DomGlobal.document.body.appendChild(pinkModal.asElement());\n" +
                "\n" +
                "pinkModalButton.addClickListener(evt -> pinkModal.open());\n" +
                "\n" +
                "\n" +
                "Button greenModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());\n" +
                "TimePicker greenDatePicker = TimePicker.create()\n" +
                "        .setColorScheme(ColorScheme.GREEN)\n" +
                "        .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->\n" +
                "                DomGlobal.console.info(picker.getFormattedTime()));\n" +
                "ModalDialog greenModal = greenDatePicker.createModal(\"Wakeup\");\n" +
                "greenDatePicker.addCloseHandler(() -> greenModal.close());\n" +
                "greenDatePicker.addClearHandler(() -> Notification.create(\"a Click on clear button\")\n" +
                "        .setPosition(Notification.TOP_RIGHT)\n" +
                "        .setBackground(ColorScheme.GREEN.color())\n" +
                "        .show());\n" +
                "\n" +
                "greenModal.appendContent(greenDatePicker.asElement());\n" +
                "DomGlobal.document.body.appendChild(greenModal.asElement());\n" +
                "\n" +
                "greenModalButton.addClickListener(evt -> greenModal.open());\n" +
                "\n" +
                "\n" +
                "element.appendChild(Card.create(\"POPUP\")\n" +
                "        .appendContent(BlockHeader.create(\"POP OVER\").asElement())\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy().addElement(bluePopupButton.asElement()))\n" +
                "                .addColumn(column.copy().addElement(pinkPopupButton.asElement()))\n" +
                "                .addColumn(column.copy().addElement(greenPopupButton.asElement()))\n" +
                "                .asElement())\n" +
                "        .appendContent(BlockHeader.create(\"MODAL\").asElement())\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy().addElement(blueModalButton.asElement()))\n" +
                "                .addColumn(column.copy().addElement(pinkModalButton.asElement()))\n" +
                "                .addColumn(column.copy().addElement(greenModalButton.asElement()))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String timebox() {
        return "Column column = this.column.copy()\n" +
                "        .removeCssClass(Styles.padding_0);\n" +
                "\n" +
                "TimeBox timeBox1 = TimeBox.create()\n" +
                "        .floating()\n" +
                "        .setPlaceholder(\"Wakeup\");\n" +
                "\n" +
                "TimeBox timeBox2 = TimeBox.create(\"Wakeup\", new Time(), new DateTimeFormatInfoImpl_de())\n" +
                "        .floating();\n" +
                "\n" +
                "timeBox2.getTimePicker().setColorScheme(ColorScheme.PINK);\n" +
                "\n" +
                "\n" +
                "TimeBox timeBox3 = TimeBox.create()\n" +
                "        .floating()\n" +
                "        .setPopoverPosition(PopupPosition.TOP)\n" +
                "        .setPickerStyle(TimeBox.PickerStyle.POPOVER)\n" +
                "        .setPlaceholder(\"Wakeup\");\n" +
                "\n" +
                "timeBox3.getTimePicker().setColorScheme(ColorScheme.GREEN);\n" +
                "\n" +
                "\n" +
                "element.appendChild(Card.create(\"TIME BOX\")\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy().addElement(timeBox1.asElement()))\n" +
                "                .addColumn(column.copy().addElement(timeBox2.asElement()))\n" +
                "                .addColumn(column.copy().addElement(timeBox3.asElement()))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

}
