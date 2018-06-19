package org.dominokit.domino.datepicker.client.views;

public class CodeResource {

    public static String inlined() {
        return "element.appendChild(Card.create(\"INLINED\")\n" +
                "    .appendContent(BlockHeader.create(\"Header visible\").asElement())\n" +
                "    .appendContent(Row.create()\n" +
                "            .addColumn(column.copy().addElement(DatePicker.create()\n" +
                "                    .hideClearButton()\n" +
                "                    .hideCloseButton()\n" +
                "                    .showBorder()\n" +
                "                    .fixedWidth(\"265px\")\n" +
                "                    .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "                        DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "                        Notification.create(dateTimeFormat.format(date))\n" +
                "                                .setPosition(Notification.TOP_LEFT)\n" +
                "                                .setBackground(Color.BLUE)\n" +
                "                                .show();\n" +
                "                    })\n" +
                "                    .asElement()))\n" +
                "            .addColumn(column.copy().addElement(DatePicker.create(new Date(), new DateTimeFormatInfoImpl_fr())\n" +
                "                    .setColorScheme(ColorScheme.AMBER)\n" +
                "                    .hideClearButton()\n" +
                "                    .hideCloseButton()\n" +
                "                    .showBorder()\n" +
                "                    .fixedWidth(\"265px\")\n" +
                "                    .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "                        DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "                        Notification.create(dateTimeFormat.format(date))\n" +
                "                                .setPosition(Notification.TOP_CENTER)\n" +
                "                                .setBackground(ColorScheme.AMBER.darker_2())\n" +
                "                                .show();\n" +
                "                    })\n" +
                "                    .todayButtonText(\"aujourd'hui\")\n" +
                "                    .asElement()))\n" +
                "            .addColumn(column.copy().addElement(DatePicker.create()\n" +
                "                    .setColorScheme(ColorScheme.GREEN)\n" +
                "                    .hideClearButton()\n" +
                "                    .hideCloseButton()\n" +
                "                    .showBorder()\n" +
                "                    .fixedWidth(\"265px\")\n" +
                "                    .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "                        DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "                        Notification.create(dateTimeFormat.format(date))\n" +
                "                                .setPosition(Notification.TOP_RIGHT)\n" +
                "                                .setBackground(ColorScheme.GREEN.darker_2())\n" +
                "                                .show();\n" +
                "                    })\n" +
                "                    .asElement()))\n" +
                "            .asElement())\n" +
                "    .appendContent(BlockHeader.create(\"Header hidden\").asElement())\n" +
                "    .appendContent(Row.create()\n" +
                "            .addColumn(column.copy().addElement(DatePicker.create()\n" +
                "                    .hideClearButton()\n" +
                "                    .hideCloseButton()\n" +
                "                    .hideHeaderPanel()\n" +
                "                    .showBorder()\n" +
                "                    .fixedWidth(\"265px\")\n" +
                "                    .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "                        DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "                        Notification.create(dateTimeFormat.format(date))\n" +
                "                                .setPosition(Notification.TOP_LEFT)\n" +
                "                                .setBackground(ColorScheme.BLUE.color())\n" +
                "                                .show();\n" +
                "                    })\n" +
                "                    .asElement()))\n" +
                "            .addColumn(column.copy().addElement(DatePicker.create(new Date(), new DateTimeFormatInfoImpl_fr())\n" +
                "                    .setColorScheme(ColorScheme.AMBER)\n" +
                "                    .hideClearButton()\n" +
                "                    .hideHeaderPanel()\n" +
                "                    .hideCloseButton()\n" +
                "                    .showBorder()\n" +
                "                    .fixedWidth(\"265px\")\n" +
                "                    .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "                        DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "                        Notification.create(dateTimeFormat.format(date))\n" +
                "                                .setPosition(Notification.TOP_CENTER)\n" +
                "                                .setBackground(ColorScheme.AMBER.darker_2())\n" +
                "                                .show();\n" +
                "                    })\n" +
                "                    .todayButtonText(\"aujourd'hui\")\n" +
                "                    .asElement()))\n" +
                "            .addColumn(column.copy().addElement(DatePicker.create()\n" +
                "                    .setColorScheme(ColorScheme.GREEN)\n" +
                "                    .hideClearButton()\n" +
                "                    .hideHeaderPanel()\n" +
                "                    .hideCloseButton()\n" +
                "                    .showBorder()\n" +
                "                    .fixedWidth(\"265px\")\n" +
                "                    .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "                        DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "                        Notification.create(dateTimeFormat.format(date))\n" +
                "                                .setPosition(Notification.TOP_RIGHT)\n" +
                "                                .setBackground(ColorScheme.GREEN.darker_2())\n" +
                "                                .show();\n" +
                "                    })\n" +
                "                    .asElement()))\n" +
                "            .asElement())\n" +
                "    .asElement());";
    }

    public static String popups() {
        return "Button bluePopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());\n" +
                "DatePicker bluePopDatePicker = DatePicker.create()\n" +
                "        .showBorder()\n" +
                "        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "            Notification.create(dateTimeFormat.format(date))\n" +
                "                    .setPosition(Notification.TOP_LEFT)\n" +
                "                    .setBackground(ColorScheme.BLUE.color())\n" +
                "                    .show();\n" +
                "        });\n" +
                "Popover bluePopover = Popover.create(bluePopupButton.asElement(), \"Birth date\", bluePopDatePicker\n" +
                "        .asElement());\n" +
                "\n" +
                "bluePopDatePicker.addCloseHandler(() -> bluePopover.close());\n" +
                "bluePopDatePicker.addClearHandler(() -> Notification.create(\"a Click on clear button\")\n" +
                "        .setPosition(Notification.TOP_LEFT)\n" +
                "        .setBackground(ColorScheme.BLUE.color())\n" +
                "        .show());\n" +
                "\n" +
                "\n" +
                "Button amberPopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.AMBER.color());\n" +
                "DatePicker amberPopDatePicker = DatePicker.create(new Date(), new DateTimeFormatInfoImpl_fr())\n" +
                "        .setColorScheme(ColorScheme.AMBER)\n" +
                "        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "            Notification.create(dateTimeFormat.format(date))\n" +
                "                    .setPosition(Notification.TOP_CENTER)\n" +
                "                    .setBackground(ColorScheme.AMBER.color())\n" +
                "                    .show();\n" +
                "        });\n" +
                "Popover amberPopover = Popover.createPicker(amberPopupButton.asElement(),  amberPopDatePicker\n" +
                "        .asElement());\n" +
                "\n" +
                "amberPopDatePicker.addCloseHandler(() -> amberPopover.close());\n" +
                "amberPopDatePicker.addClearHandler(() -> Notification.create(\"a Click on clear button\")\n" +
                "        .setPosition(Notification.TOP_CENTER)\n" +
                "        .setBackground(ColorScheme.AMBER.color())\n" +
                "        .show());\n" +
                "\n" +
                "\n" +
                "Button greenPopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());\n" +
                "DatePicker greenPopDatePicker = DatePicker.create()\n" +
                "        .setColorScheme(ColorScheme.GREEN)\n" +
                "        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "            Notification.create(dateTimeFormat.format(date))\n" +
                "                    .setPosition(Notification.TOP_RIGHT)\n" +
                "                    .setBackground(ColorScheme.GREEN.color())\n" +
                "                    .show();\n" +
                "        });\n" +
                "Popover greenPopover = Popover.createPicker(greenPopupButton.asElement(), greenPopDatePicker\n" +
                "        .asElement());\n" +
                "\n" +
                "greenPopDatePicker.addCloseHandler(() -> greenPopover.close());\n" +
                "greenPopDatePicker.addClearHandler(() -> Notification.create(\"a Click on clear button\")\n" +
                "        .setPosition(Notification.TOP_RIGHT)\n" +
                "        .setBackground(ColorScheme.GREEN.color())\n" +
                "        .show());\n" +
                "\n" +
                "\n" +
                "Button blueModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());\n" +
                "DatePicker blueDatePicker = DatePicker.create()\n" +
                "        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "            Notification.create(dateTimeFormat.format(date))\n" +
                "                    .setPosition(Notification.TOP_LEFT)\n" +
                "                    .setBackground(ColorScheme.BLUE.color())\n" +
                "                    .show();\n" +
                "        });\n" +
                "ModalDialog blueModal = blueDatePicker.createModal(\"Birth date\");\n" +
                "blueDatePicker.addCloseHandler(() -> blueModal.close());\n" +
                "blueDatePicker.addClearHandler(() -> Notification.create(\"a Click on clear button\")\n" +
                "        .setPosition(Notification.TOP_LEFT)\n" +
                "        .setBackground(ColorScheme.BLUE.color())\n" +
                "        .show());\n" +
                "\n" +
                "\n" +
                "\n" +
                "blueModal.appendContent(blueDatePicker.asElement());\n" +
                "DomGlobal.document.body.appendChild(blueModal.asElement());\n" +
                "\n" +
                "blueModalButton.addClickListener(evt -> blueModal.open());\n" +
                "\n" +
                "\n" +
                "Button amberModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.AMBER.color());\n" +
                "DatePicker amberDatePicker = DatePicker.create()\n" +
                "        .setColorScheme(ColorScheme.AMBER)\n" +
                "        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "            Notification.create(dateTimeFormat.format(date))\n" +
                "                    .setPosition(Notification.TOP_CENTER)\n" +
                "                    .setBackground(ColorScheme.AMBER.color())\n" +
                "                    .show();\n" +
                "        });\n" +
                "ModalDialog amberModal = amberDatePicker.createModal(\"Birth date\");\n" +
                "\n" +
                "amberDatePicker.addCloseHandler(() -> amberModal.close());\n" +
                "amberDatePicker.addClearHandler(() -> Notification.create(\"a Click on clear button\")\n" +
                "        .setPosition(Notification.TOP_CENTER)\n" +
                "        .setBackground(ColorScheme.AMBER.color())\n" +
                "        .show());\n" +
                "\n" +
                "amberModal.appendContent(amberDatePicker.asElement());\n" +
                "DomGlobal.document.body.appendChild(amberModal.asElement());\n" +
                "\n" +
                "amberModalButton.addClickListener(evt -> amberModal.open());\n" +
                "\n" +
                "\n" +
                "Button greenModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());\n" +
                "DatePicker greenDatePicker = DatePicker.create()\n" +
                "        .setColorScheme(ColorScheme.GREEN)\n" +
                "        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {\n" +
                "            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);\n" +
                "            Notification.create(dateTimeFormat.format(date))\n" +
                "                    .setPosition(Notification.TOP_RIGHT)\n" +
                "                    .setBackground(ColorScheme.GREEN.color())\n" +
                "                    .show();\n" +
                "        });\n" +
                "ModalDialog greenModal = greenDatePicker.createModal(\"Birth date\");\n" +
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
                "                .addColumn(column.copy().addElement(amberPopupButton.asElement()))\n" +
                "                .addColumn(column.copy().addElement(greenPopupButton.asElement()))\n" +
                "                .asElement())\n" +
                "        .appendContent(BlockHeader.create(\"MODAL\").asElement())\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy().addElement(blueModalButton.asElement()))\n" +
                "                .addColumn(column.copy().addElement(amberModalButton.asElement()))\n" +
                "                .addColumn(column.copy().addElement(greenModalButton.asElement()))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

    public static String datebox() {
        return "Column column=this.column.copy()\n" +
                "        .removeCssClass(Styles.padding_0);\n" +
                "\n" +
                "DateBox dateBox1 = DateBox.create()\n" +
                "        .floating()\n" +
                "        .setPlaceholder(\"Birth date\");\n" +
                "\n" +
                "DateBox dateBox2 = DateBox.create(\"Birth date\", new Date(), new DateTimeFormatInfoImpl_fr())\n" +
                "        .floating();\n" +
                "\n" +
                "dateBox2.getDatePicker().setColorScheme(ColorScheme.AMBER);\n" +
                "\n" +
                "\n" +
                "DateBox dateBox3 = DateBox.create()\n" +
                "        .floating()\n" +
                "        .setPopoverPosition(PopupPosition.TOP)\n" +
                "        .setPickerStyle(DateBox.PickerStyle.POPOVER)\n" +
                "        .setPlaceholder(\"Birth date\");\n" +
                "\n" +
                "dateBox3.getDatePicker().setColorScheme(ColorScheme.GREEN);\n" +
                "\n" +
                "\n" +
                "element.appendChild(Card.create(\"DATE BOX\")\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column.copy().addElement(dateBox1.asElement()))\n" +
                "                .addColumn(column.copy().addElement(dateBox2.asElement()))\n" +
                "                .addColumn(column.copy().addElement(dateBox3.asElement()))\n" +
                "                .asElement())\n" +
                "        .asElement());";
    }

}
