package org.dominokit.domino.basicforms.client.views.ui;

import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.basicforms.client.presenters.BasicFormsPresenter;
import org.dominokit.domino.basicforms.client.views.BasicFormsView;
import org.dominokit.domino.basicforms.client.views.CodeResource;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.jboss.gwt.elemento.core.Elements;

@UiView(presentable = BasicFormsPresenter.class)
public class BasicFormsViewImpl extends ComponentView<HTMLDivElement> implements BasicFormsView {

    private HTMLDivElement element = Elements.div().asElement();
    private Card inputCard;
    private Card textAreaCard;
    private Card selectCard;
    private Card checkboxCard;
    private Card radioCard;
    private Card switchCard;

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("BASIC FORM ELEMENTS").asElement());

        inputCard = Card.create("INPUT", "Different sizes and widths.");
        textAreaCard = Card.create("TEXTAREA");
        selectCard = Card.create("SELECT");
        checkboxCard = Card.create("CHECKBOX");
        radioCard = Card.create("RADIO");
        switchCard = Card.create("SWITCH BUTTONS");

        initBasicExamples();
        initDifferentWidths();
        initDifferentSizes();
        initFloatingLabel();
        initInputStatus();
        initBasicTextAreaExample();
        initSelectExample();
        initCheckboxExample();
        initRadioExample();
        initSwitchExample();

        element.appendChild(inputCard.asElement());
        element.appendChild(createCodeCard(CodeResource.textboxSamples()).asElement());
        element.appendChild(textAreaCard.asElement());
        element.appendChild(createCodeCard(CodeResource.textareaSamples()).asElement());
        element.appendChild(selectCard.asElement());
        element.appendChild(createCodeCard(CodeResource.selectSamples()).asElement());
        element.appendChild(checkboxCard.asElement());
        element.appendChild(createCodeCard(CodeResource.checkBoxSamples()).asElement());
        element.appendChild(radioCard.asElement());
        element.appendChild(createCodeCard(CodeResource.radioSamples()).asElement());
        element.appendChild(switchCard.asElement());
        element.appendChild(createCodeCard(CodeResource.switchSamples()).asElement());
    }


    private void initSwitchExample() {
        switchCard.appendContent(Elements.h(5).textContent("Basic Examples").asElement());

        Column column = Column.create()
                .onLarge(Column.OnLarge.three)
                .onXSmall(Column.OnXSmall.twelve);
        switchCard.appendContent(Row.create()
                .addColumn(column.addElement(SwitchButton.create("OFF", "ON").asElement()))
                .addColumn(column.copy().addElement(SwitchButton.create("DISABLED").disable().asElement()))
                .asElement());

        switchCard.appendContent(Elements.h(5).textContent("With Material Design Colors").asElement());

        switchCard.appendContent(Row.create()
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("RED").setColor(Color.RED).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("PINK").setColor(Color.PINK).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("DEEP PURPLE").setColor(Color.DEEP_PURPLE).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("INDIGO").setColor(Color.INDIGO).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("BLUE").setColor(Color.BLUE).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("CYAN").setColor(Color.CYAN).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("TEAL").setColor(Color.TEAL).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("GREEN").setColor(Color.GREEN).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("LIME").setColor(Color.LIME).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("YELLOW").setColor(Color.YELLOW).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("AMBER").setColor(Color.AMBER).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("ORANGE").setColor(Color.ORANGE).check().asElement()))
                .addColumn(column.copy()
                        .addElement(SwitchButton.create("GREY").setColor(Color.GREY).check().asElement()))
                .asElement());
    }

    private void initRadioExample() {
        Column column = Column.create()
                .onXSmall(Column.OnXSmall.twelve)
                .onSmall(Column.OnSmall.nine)
                .onLarge(Column.OnLarge.six);
        radioCard.appendContent(Elements.h(5).textContent("Basic Examples").asElement());

        Radio radio1 = Radio.create("radio1", "Radio - 1").check();
        Radio radio2 = Radio.create("radio2", "Radio - 2");
        Radio radio1Gap = Radio.create("radio1_gap", "Radio 1 - With Gap").withGap();
        Radio radio2Gap = Radio.create("radio2_gap", "Radio 2 - With Gap").withGap();

        RadioGroup horizontalRadioGroup = RadioGroup.create("test")
                .addRadio(radio1)
                .addRadio(radio2)
                .addRadio(radio1Gap)
                .addRadio(radio2Gap)
                .horizontal();

        Radio firstDisabledRadio = Radio.create("radio1_disabled", "Radio - Disabled").check().disable();
        Radio secondsDisabledRadio = Radio.create("radio2_disabled", "Radio - Disabled").withGap().check().disable();

        firstDisabledRadio.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");
        secondsDisabledRadio.asElement().style.margin = CSSProperties.MarginUnionType.of("5px");

        RadioGroup firstDisabledGroup = RadioGroup.create("disabled").addRadio(firstDisabledRadio);
        RadioGroup secondDisabledGroup = RadioGroup.create("disabled").addRadio(secondsDisabledRadio);

        radioCard.appendContent(Row.create()
                .addColumn(column
                        .addElement(horizontalRadioGroup.asElement())
                        .addElement(firstDisabledGroup.asElement())
                        .addElement(secondDisabledGroup.asElement()))
                .asElement());

        radioCard.appendContent(Elements.br().asElement());

        column = Column.create()
                .onLarge(Column.OnLarge.two)
                .onSmall(Column.OnSmall.six);

        radioCard.appendContent(Row.create()
                .addColumn(column.copy()
                        .addElement(Elements.h(5).textContent("With Material Design Colors").asElement())
                        .addElement(RadioGroup.create("color")
                                .addRadio(Radio.create("RED", "RED").setColor(Color.RED).check())
                                .addRadio(Radio.create("PINK", "PINK").setColor(Color.PINK))
                                .addRadio(Radio.create("DEEP PURPLE", "DEEP PURPLE").setColor(Color.DEEP_PURPLE))
                                .addRadio(Radio.create("INDIGO", "INDIGO").setColor(Color.INDIGO))
                                .addRadio(Radio.create("BLUE", "BLUE").setColor(Color.BLUE))
                                .addRadio(Radio.create("CYAN", "CYAN").setColor(Color.CYAN))
                                .addRadio(Radio.create("TEAL", "TEAL").setColor(Color.TEAL))
                                .addRadio(Radio.create("GREEN", "GREEN").setColor(Color.GREEN))
                                .addRadio(Radio.create("LIME", "LIME").setColor(Color.LIME))
                                .addRadio(Radio.create("YELLOW", "YELLOW").setColor(Color.YELLOW))
                                .addRadio(Radio.create("AMBER", "AMBER").setColor(Color.AMBER))
                                .addRadio(Radio.create("ORANGE", "ORANGE").setColor(Color.ORANGE))
                                .addRadio(Radio.create("GREY", "GREY").setColor(Color.GREY))
                                .asElement()))
                .addColumn(column.copy()
                        .addElement(Elements.h(5).textContent("With Material Design Colors with gap").asElement())
                        .addElement(RadioGroup.create("color-with-gap")
                                .addRadio(Radio.create("RED", "RED").setColor(Color.RED).withGap().check())
                                .addRadio(Radio.create("PINK", "PINK").setColor(Color.PINK).withGap())
                                .addRadio(Radio.create("DEEP PURPLE", "DEEP PURPLE").setColor(Color.DEEP_PURPLE).withGap())
                                .addRadio(Radio.create("INDIGO", "INDIGO").setColor(Color.INDIGO).withGap())
                                .addRadio(Radio.create("BLUE", "BLUE").setColor(Color.BLUE).withGap())
                                .addRadio(Radio.create("CYAN", "CYAN").setColor(Color.CYAN).withGap())
                                .addRadio(Radio.create("TEAL", "TEAL").setColor(Color.TEAL).withGap())
                                .addRadio(Radio.create("GREEN", "GREEN").setColor(Color.GREEN).withGap())
                                .addRadio(Radio.create("LIME", "LIME").setColor(Color.LIME).withGap())
                                .addRadio(Radio.create("YELLOW", "YELLOW").setColor(Color.YELLOW).withGap())
                                .addRadio(Radio.create("AMBER", "AMBER").setColor(Color.AMBER).withGap())
                                .addRadio(Radio.create("ORANGE", "ORANGE").setColor(Color.ORANGE).withGap())
                                .addRadio(Radio.create("GREY", "GREY").setColor(Color.GREY).withGap())
                                .asElement())).asElement());
    }

    private void initCheckboxExample() {
        Column column = Column.create()
                .onLarge(Column.OnLarge.two)
                .onSmall(Column.OnSmall.six);
        checkboxCard.appendContent(Elements.h(5).textContent("Basic Examples").asElement());
        checkboxCard.appendContent(Row.create()
                .addColumn(column
                        .addElement(CheckBox.create("Default").asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("Filled In").filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("Default - Disabled").check().disable().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("Filled In - Disabled").check().filledIn().disable().asElement()))
                .asElement());

        checkboxCard.appendContent(Elements.h(5).textContent("With Material Design Colors").asElement());

        checkboxCard.appendContent(Row.create()
                .addColumn(column.copy()
                        .addElement(CheckBox.create("RED").setColor(Color.RED).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("PINK").setColor(Color.PINK).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("DEEP PURPLE").setColor(Color.DEEP_PURPLE).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("INDIGO").setColor(Color.INDIGO).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("BLUE").setColor(Color.BLUE).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("CYAN").setColor(Color.CYAN).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("TEAL").setColor(Color.TEAL).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("GREEN").setColor(Color.GREEN).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("LIME").setColor(Color.LIME).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("YELLOW").setColor(Color.YELLOW).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("AMBER").setColor(Color.AMBER).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("ORANGE").setColor(Color.ORANGE).check().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("GREY").setColor(Color.GREY).check().asElement()))
                .asElement());

        checkboxCard.appendContent(Elements.h(5).textContent("With Material Design Colors - Filled In").asElement());

        checkboxCard.appendContent(Row.create()
                .addColumn(column.copy()
                        .addElement(CheckBox.create("RED").setColor(Color.RED).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("PINK").setColor(Color.PINK).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("DEEP PURPLE").setColor(Color.DEEP_PURPLE).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("INDIGO").setColor(Color.INDIGO).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("BLUE").setColor(Color.BLUE).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("CYAN").setColor(Color.CYAN).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("TEAL").setColor(Color.TEAL).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("GREEN").setColor(Color.GREEN).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("LIME").setColor(Color.LIME).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("YELLOW").setColor(Color.YELLOW).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("AMBER").setColor(Color.AMBER).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("ORANGE").setColor(Color.ORANGE).check().filledIn().asElement()))
                .addColumn(column.copy()
                        .addElement(CheckBox.create("GREY").setColor(Color.GREY).check().filledIn().asElement()))
                .asElement());
    }

    private void initSelectExample() {
        Column column = Column.create().onSmall(Column.OnSmall.six);
        Select select = Select.create()
                .addOption(SelectOption.create("nothing", "-- please select --"))
                .addOption(SelectOption.create("value10", "10"))
                .addOption(SelectOption.create("value20", "20"))
                .addOption(SelectOption.create("value30", "30"))
                .addOption(SelectOption.create("value40", "40"))
                .addOption(SelectOption.create("value50", "50"))
                .selectAt(0)
                .addSelectionHandler(option -> {
                    Notification.create("Item selected [ " + option.getValue() + " ], [ " + option.getDisplayValue() + " ]").show();
                });

        selectCard.appendContent(Row.create()
                .addColumn(column
                        .addElement(select.asElement()))
                .addColumn(column.copy()
                        .addElement(Select.create()
                                .addOption(SelectOption.create("Disabled"))
                                .selectAt(0)
                                .disable()
                                .asElement())).asElement());

        selectCard.appendContent(BlockHeader.create("Drop up example").asElement());

        selectCard.appendContent(Row.create()
                .addColumn(column.copy()
                        .addElement(Select.create()
                                .addOption(SelectOption.create("-- please select --"))
                                .addOption(SelectOption.create("10"))
                                .addOption(SelectOption.create("20"))
                                .addOption(SelectOption.create("30"))
                                .addOption(SelectOption.create("40"))
                                .addOption(SelectOption.create("50"))
                                .selectAt(0)
                                .dropup()
                                .addSelectionHandler(option -> {
                                    Notification.create("Item selected [ " + option.getValue() + " ]").show();
                                }).asElement())).asElement());
    }

    private void initBasicExamples() {
        inputCard.appendContent(BlockHeader.create("Basic Example").asElement())
                .appendContent(TextBox.create().setPlaceholder("Username").asElement())
                .appendContent(TextBox.password().setPlaceholder("Password").asElement());
    }

    private void initDifferentWidths() {
        Column column6Size = Column.create().onSmall(Column.OnSmall.six);
        Column column4Size = Column.create().onSmall(Column.OnSmall.four);
        Column column3Size = Column.create().onSmall(Column.OnSmall.three);


        inputCard.appendContent(BlockHeader.create("Different Widths").asElement())
                .appendContent(Row.create()
                        .addColumn(column6Size
                                .addElement(TextBox.create().setPlaceholder("col-sm-6").asElement()))
                        .addColumn(column6Size.copy()
                                .addElement(TextBox.create().setPlaceholder("col-sm-6").asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column4Size
                                .addElement(TextBox.create().setPlaceholder("col-sm-4").asElement()))
                        .addColumn(column4Size.copy()
                                .addElement(TextBox.create().setPlaceholder("col-sm-4").asElement()))
                        .addColumn(column4Size.copy()
                                .addElement(TextBox.create().setPlaceholder("col-sm-4").asElement()))
                        .asElement())
                .appendContent(Row.create()
                        .addColumn(column3Size
                                .addElement(TextBox.create().setPlaceholder("col-sm-3").asElement()))
                        .addColumn(column3Size.copy()
                                .addElement(TextBox.create().setPlaceholder("col-sm-3").asElement()))
                        .addColumn(column3Size.copy()
                                .addElement(TextBox.create().setPlaceholder("col-sm-3").asElement()))
                        .addColumn(column3Size.copy()
                                .addElement(TextBox.create().setPlaceholder("col-sm-3").asElement()))
                        .asElement());
    }

    private void initDifferentSizes() {
        inputCard.appendContent(BlockHeader.create("Different Sizes").asElement())
                .appendContent(TextBox.create().setPlaceholder("Large Input").large().asElement())
                .appendContent(TextBox.create().setPlaceholder("Default Input").asElement())
                .appendContent(TextBox.create().setPlaceholder("Small Input").small().asElement());
    }

    private void initFloatingLabel() {
        inputCard.appendContent(BlockHeader.create("Floating Label Examples").asElement())
                .appendContent(TextBox.create("Username").asElement())
                .appendContent(TextBox.password("Password").asElement())
                .appendContent(TextBox.create("Large Input").large().asElement())
                .appendContent(TextBox.create("Default Input").asElement())
                .appendContent(TextBox.create("Small Input").small().asElement())
                .appendContent(BlockHeader.create("Always floating").asElement())
                .appendContent(TextBox.create("Age").floating().asElement())
                .appendContent(TextBox.create("Email").floating().asElement());
    }

    private void initInputStatus() {
        Column column6Size = Column.create().onSmall(Column.OnSmall.six);

        inputCard.appendContent(BlockHeader.create("Input Status").asElement())
                .appendContent(Row.create()
                        .addColumn(column6Size
                                .addElement(TextBox.create("Focused").focus().asElement()))
                        .addColumn(column6Size.copy()
                                .addElement(TextBox.create("Disabled").disable().asElement())).asElement());
    }

    private void initBasicTextAreaExample() {
        textAreaCard.appendContent(BlockHeader.create("Basic Examples").asElement())
                .appendContent(TextArea.create().setPlaceholder("Start typing here...").asElement());

        textAreaCard.appendContent(BlockHeader.create("Auto Growing Vertical Direction").asElement())
                .appendContent(TextArea.create().setPlaceholder("Start typing here...").autoSize().asElement());

        textAreaCard.appendContent(BlockHeader.create("Text Area With Label").asElement())
                .appendContent(TextArea.create("Description").autoSize().asElement());
    }
}