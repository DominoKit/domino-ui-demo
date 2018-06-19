package org.dominokit.domino.basicforms.client.views;

public class CodeResource{



    public static String textboxSamples(){
        return "// -------------- Basic examples\n" +
                "\n" +
                "card.appendContent(BlockHeader.create(\"Basic Examples\").asElement())\n" +
                "                .appendContent(TextBox.create(\"Username\").asElement())\n" +
                "                .appendContent(TextBox.password(\"Password\").asElement());\n" +
                "\n" +
                "// -------------- Different widths\n" +
                "\n" +
                "Column column6Size = Column.create().onSmall(Column.OnSmall.six);\n" +
                "Column column4Size = Column.create().onSmall(Column.OnSmall.four);\n" +
                "Column column3Size = Column.create().onSmall(Column.OnSmall.three);\n" +
                "\n" +
                "\n" +
                "card.appendContent(BlockHeader.create(\"Different Widths\").asElement())\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column6Size\n" +
                "                        .addElement(TextBox.create(\"col-sm-6\").asElement()))\n" +
                "                .addColumn(column6Size.copy()\n" +
                "                        .addElement(TextBox.create(\"col-sm-6\").asElement()))\n" +
                "                .asElement())\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column4Size\n" +
                "                        .addElement(TextBox.create(\"col-sm-4\").asElement()))\n" +
                "                .addColumn(column4Size.copy()\n" +
                "                        .addElement(TextBox.create(\"col-sm-4\").asElement()))\n" +
                "                .addColumn(column4Size.copy()\n" +
                "                        .addElement(TextBox.create(\"col-sm-4\").asElement()))\n" +
                "                .asElement())\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column3Size\n" +
                "                        .addElement(TextBox.create(\"col-sm-3\").asElement()))\n" +
                "                .addColumn(column3Size.copy()\n" +
                "                        .addElement(TextBox.create(\"col-sm-3\").asElement()))\n" +
                "                .addColumn(column3Size.copy()\n" +
                "                        .addElement(TextBox.create(\"col-sm-3\").asElement()))\n" +
                "                .addColumn(column3Size.copy()\n" +
                "                        .addElement(TextBox.create(\"col-sm-3\").asElement()))\n" +
                "                .asElement());\n" +
                "\n" +
                "\n" +
                "// -------------- Different Sizes\n" +
                "\n" +
                "card.appendContent(BlockHeader.create(\"Different Sizes\").asElement())\n" +
                "                .appendContent(TextBox.create(\"Large Input\").large().asElement())\n" +
                "                .appendContent(TextBox.create(\"Default Input\").asElement())\n" +
                "                .appendContent(TextBox.create(\"Small Input\").small().asElement());\n" +
                "\n" +
                "\n" +
                "// -------------- Floating Label Examples\n" +
                "\n" +
                "card.appendContent(BlockHeader.create(\"Floating Label Examples\").asElement())\n" +
                "                .appendContent(TextBox.create(\"Username\").floating().asElement())\n" +
                "                .appendContent(TextBox.password(\"Password\").floating().asElement())\n" +
                "                .appendContent(TextBox.create(\"Large Input\").large().floating().asElement())\n" +
                "                .appendContent(TextBox.create(\"Default Input\").floating().asElement())\n" +
                "                .appendContent(TextBox.create(\"Small Input\").small().floating().asElement());\n" +
                "\n" +
                "\n" +
                "// -------------- Input Status\n" +
                "\n" +
                "Column column6Size = Column.create().onSmall(Column.OnSmall.six);\n" +
                "\n" +
                "card.appendContent(BlockHeader.create(\"Input Status\").asElement())\n" +
                "        .appendContent(Row.create()\n" +
                "                .addColumn(column6Size\n" +
                "                        .addElement(TextBox.create(\"Focused\").focus().asElement()))\n" +
                "                .addColumn(column6Size.copy()\n" +
                "                        .addElement(TextBox.create(\"Disabled\").disable().asElement())).asElement());";
    }

    public static String textareaSamples(){
        return "card.appendContent(BlockHeader.create(\"Basic Examples\").asElement())\n" +
                "                .appendContent(TextArea.create(\"Start typing here...\").asElement());\n" +
                "\n" +
                "\n" +
                "// autosize example\n" +
                "\n" +
                "card.appendContent(BlockHeader.create(\"Auto Growing Vertical Direction\").asElement())\n" +
                "        .appendContent(TextArea.create(\"Start typing here...\").autoSize().asElement());";
    }

    public static String selectSamples(){
        return "Column column = Column.create().onSmall(Column.OnSmall.six);\n" +
                "Select select = Select.create()\n" +
                "        .addOption(SelectOption.create(\"nothing\", \"-- please select --\"))\n" +
                "        .addOption(SelectOption.create(\"value10\", \"10\"))\n" +
                "        .addOption(SelectOption.create(\"value20\", \"20\"))\n" +
                "        .addOption(SelectOption.create(\"value30\", \"30\"))\n" +
                "        .addOption(SelectOption.create(\"value40\", \"40\"))\n" +
                "        .addOption(SelectOption.create(\"value50\", \"50\"))\n" +
                "        .selectAt(0)\n" +
                "        .addSelectionHandler(option -> {\n" +
                "            Notification.create(\"Item selected [ \" + option.getValue() + \" ], [ \" + option.getDisplayValue() + \" ]\").show();\n" +
                "        });\n" +
                "\n" +
                "selectCard.appendContent(Row.create()\n" +
                "        .addColumn(column\n" +
                "                .addElement(select.asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(Select.create()\n" +
                "                        .addOption(SelectOption.create(\"Disabled\"))\n" +
                "                        .selectAt(0)\n" +
                "                        .disable()\n" +
                "                        .asElement())).asElement());\n" +
                "\n" +
                "selectCard.appendContent(BlockHeader.create(\"Drop up example\").asElement());\n" +
                "\n" +
                "selectCard.appendContent(Row.create()\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(Select.create()\n" +
                "                        .addOption(SelectOption.create(\"-- please select --\"))\n" +
                "                        .addOption(SelectOption.create(\"10\"))\n" +
                "                        .addOption(SelectOption.create(\"20\"))\n" +
                "                        .addOption(SelectOption.create(\"30\"))\n" +
                "                        .addOption(SelectOption.create(\"40\"))\n" +
                "                        .addOption(SelectOption.create(\"50\"))\n" +
                "                        .selectAt(0)\n" +
                "                        .dropup()\n" +
                "                        .addSelectionHandler(option -> {\n" +
                "                            Notification.create(\"Item selected [ \" + option.getValue() + \" ]\").show();\n" +
                "                        }).asElement())).asElement());";
    }

    public static String checkBoxSamples(){
        return "Column column = Column.create()\n" +
                "                .onLarge(Column.OnLarge.two)\n" +
                "                .onSmall(Column.OnSmall.six);\n" +
                "checkboxCard.appendContent(Elements.h(5).textContent(\"Basic Examples\").asElement());\n" +
                "checkboxCard.appendContent(Row.create()\n" +
                "        .addColumn(column\n" +
                "                .addElement(CheckBox.create(\"Default\").asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"Filled In\").filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"Default - Disabled\").check().disable().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"Filled In - Disabled\").check().filledIn().disable().asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "checkboxCard.appendContent(Elements.h(5).textContent(\"With Material Design Colors\").asElement());\n" +
                "\n" +
                "checkboxCard.appendContent(Row.create()\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"RED\").setColor(Color.RED).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"PINK\").setColor(Color.PINK).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"DEEP PURPLE\").setColor(Color.DEEP_PURPLE).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"INDIGO\").setColor(Color.INDIGO).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"BLUE\").setColor(Color.BLUE).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"CYAN\").setColor(Color.CYAN).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"TEAL\").setColor(Color.TEAL).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"GREEN\").setColor(Color.GREEN).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"LIME\").setColor(Color.LIME).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"YELLOW\").setColor(Color.YELLOW).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"AMBER\").setColor(Color.AMBER).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"ORANGE\").setColor(Color.ORANGE).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"GREY\").setColor(Color.GREY).check().asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "checkboxCard.appendContent(Elements.h(5).textContent(\"With Material Design Colors - Filled In\").asElement());\n" +
                "\n" +
                "checkboxCard.appendContent(Row.create()\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"RED\").setColor(Color.RED).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"PINK\").setColor(Color.PINK).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"DEEP PURPLE\").setColor(Color.DEEP_PURPLE).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"INDIGO\").setColor(Color.INDIGO).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"BLUE\").setColor(Color.BLUE).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"CYAN\").setColor(Color.CYAN).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"TEAL\").setColor(Color.TEAL).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"GREEN\").setColor(Color.GREEN).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"LIME\").setColor(Color.LIME).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"YELLOW\").setColor(Color.YELLOW).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"AMBER\").setColor(Color.AMBER).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"ORANGE\").setColor(Color.ORANGE).check().filledIn().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(CheckBox.create(\"GREY\").setColor(Color.GREY).check().filledIn().asElement()))\n" +
                "        .asElement());";
    }

    public static String radioSamples(){
        return "Column column = Column.create()\n" +
                "                .onXSmall(Column.OnXSmall.twelve)\n" +
                "                .onSmall(Column.OnSmall.one)\n" +
                "                .onLarge(Column.OnLarge.six);\n" +
                "radioCard.appendContent(Elements.h(5).textContent(\"Basic Examples\").asElement());\n" +
                "\n" +
                "Radio radio1 = Radio.create(\"Radio - 1\").check();\n" +
                "Radio radio2 = Radio.create(\"Radio - 2\");\n" +
                "Radio radio1Gap = Radio.create(\"Radio 1 - With Gap\").withGap();\n" +
                "Radio radio2Gap = Radio.create(\"Radio 2 - With Gap\").withGap();\n" +
                "\n" +
                "radio1.asElement().style.margin = CSSProperties.MarginUnionType.of(\"5px\");\n" +
                "radio2.asElement().style.margin = CSSProperties.MarginUnionType.of(\"5px\");\n" +
                "radio1Gap.asElement().style.margin = CSSProperties.MarginUnionType.of(\"5px\");\n" +
                "radio2Gap.asElement().style.margin = CSSProperties.MarginUnionType.of(\"5px\");\n" +
                "\n" +
                "RadioGroup horizontalRadioGroup = RadioGroup.create()\n" +
                "        .addRadio(radio1)\n" +
                "        .addRadio(radio2)\n" +
                "        .addRadio(radio1Gap)\n" +
                "        .addRadio(radio2Gap)\n" +
                "        .horizontal();\n" +
                "\n" +
                "Radio firstDisabledRadio = Radio.create(\"Radio - Disabled\").check().disable();\n" +
                "Radio secondsDisabledRadio = Radio.create(\"Radio - Disabled\").withGap().check().disable();\n" +
                "\n" +
                "firstDisabledRadio.asElement().style.margin = CSSProperties.MarginUnionType.of(\"5px\");\n" +
                "secondsDisabledRadio.asElement().style.margin = CSSProperties.MarginUnionType.of(\"5px\");\n" +
                "\n" +
                "RadioGroup firstDisabledGroup = RadioGroup.create().addRadio(firstDisabledRadio);\n" +
                "RadioGroup secondDisabledGroup = RadioGroup.create().addRadio(secondsDisabledRadio);\n" +
                "\n" +
                "radioCard.appendContent(Row.create()\n" +
                "        .addColumn(column\n" +
                "                .addElement(horizontalRadioGroup.asElement())\n" +
                "                .addElement(firstDisabledGroup.asElement())\n" +
                "                .addElement(secondDisabledGroup.asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "radioCard.appendContent(Elements.br().asElement());\n" +
                "\n" +
                "column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.two)\n" +
                "        .onSmall(Column.OnSmall.six);\n" +
                "\n" +
                "radioCard.appendContent(Row.create()\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(Elements.h(5).textContent(\"With Material Design Colors\").asElement())\n" +
                "                .addElement(RadioGroup.create()\n" +
                "                        .addRadio(Radio.create(\"RED\").setColor(Color.RED).check())\n" +
                "                        .addRadio(Radio.create(\"PINK\").setColor(Color.PINK))\n" +
                "                        .addRadio(Radio.create(\"DEEP PURPLE\").setColor(Color.DEEP_PURPLE))\n" +
                "                        .addRadio(Radio.create(\"INDIGO\").setColor(Color.INDIGO))\n" +
                "                        .addRadio(Radio.create(\"BLUE\").setColor(Color.BLUE))\n" +
                "                        .addRadio(Radio.create(\"CYAN\").setColor(Color.CYAN))\n" +
                "                        .addRadio(Radio.create(\"TEAL\").setColor(Color.TEAL))\n" +
                "                        .addRadio(Radio.create(\"GREEN\").setColor(Color.GREEN))\n" +
                "                        .addRadio(Radio.create(\"LIME\").setColor(Color.LIME))\n" +
                "                        .addRadio(Radio.create(\"YELLOW\").setColor(Color.YELLOW))\n" +
                "                        .addRadio(Radio.create(\"AMBER\").setColor(Color.AMBER))\n" +
                "                        .addRadio(Radio.create(\"ORANGE\").setColor(Color.ORANGE))\n" +
                "                        .addRadio(Radio.create(\"GREY\").setColor(Color.GREY))\n" +
                "                        .asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(Elements.h(5).textContent(\"With Material Design Colors with gap\").asElement())\n" +
                "                .addElement(RadioGroup.create()\n" +
                "                        .addRadio(Radio.create(\"RED\").setColor(Color.RED).withGap().check())\n" +
                "                        .addRadio(Radio.create(\"PINK\").setColor(Color.PINK).withGap())\n" +
                "                        .addRadio(Radio.create(\"DEEP PURPLE\").setColor(Color.DEEP_PURPLE).withGap())\n" +
                "                        .addRadio(Radio.create(\"INDIGO\").setColor(Color.INDIGO).withGap())\n" +
                "                        .addRadio(Radio.create(\"BLUE\").setColor(Color.BLUE).withGap())\n" +
                "                        .addRadio(Radio.create(\"CYAN\").setColor(Color.CYAN).withGap())\n" +
                "                        .addRadio(Radio.create(\"TEAL\").setColor(Color.TEAL).withGap())\n" +
                "                        .addRadio(Radio.create(\"GREEN\").setColor(Color.GREEN).withGap())\n" +
                "                        .addRadio(Radio.create(\"LIME\").setColor(Color.LIME).withGap())\n" +
                "                        .addRadio(Radio.create(\"YELLOW\").setColor(Color.YELLOW).withGap())\n" +
                "                        .addRadio(Radio.create(\"AMBER\").setColor(Color.AMBER).withGap())\n" +
                "                        .addRadio(Radio.create(\"ORANGE\").setColor(Color.ORANGE).withGap())\n" +
                "                        .addRadio(Radio.create(\"GREY\").setColor(Color.GREY).withGap())\n" +
                "                        .asElement())).asElement());";
    }

    public static String switchSamples(){
        return "switchCard.appendContent(Elements.h(5).textContent(\"Basic Examples\").asElement());\n" +
                "\n" +
                "Column column = Column.create()\n" +
                "        .onLarge(Column.OnLarge.three)\n" +
                "        .onSmall(Column.OnSmall.six);\n" +
                "switchCard.appendContent(Row.create()\n" +
                "        .addColumn(column.addElement(SwitchButton.create(\"OFF\", \"ON\").asElement()))\n" +
                "        .addColumn(column.copy().addElement(SwitchButton.create(\"DISABLED\").disable().asElement()))\n" +
                "        .asElement());\n" +
                "\n" +
                "switchCard.appendContent(Elements.h(5).textContent(\"With Material Design Colors\").asElement());\n" +
                "\n" +
                "switchCard.appendContent(Row.create()\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"RED\").setColor(Color.RED).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"PINK\").setColor(Color.PINK).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"DEEP PURPLE\").setColor(Color.DEEP_PURPLE).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"INDIGO\").setColor(Color.INDIGO).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"BLUE\").setColor(Color.BLUE).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"CYAN\").setColor(Color.CYAN).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"TEAL\").setColor(Color.TEAL).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"GREEN\").setColor(Color.GREEN).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"LIME\").setColor(Color.LIME).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"YELLOW\").setColor(Color.YELLOW).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"AMBER\").setColor(Color.AMBER).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"ORANGE\").setColor(Color.ORANGE).check().asElement()))\n" +
                "        .addColumn(column.copy()\n" +
                "                .addElement(SwitchButton.create(\"GREY\").setColor(Color.GREY).check().asElement()))\n" +
                "        .asElement());";
    }
}
