package org.dominokit.domino.basicforms.client.views.ui;

import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.basicforms.client.presenters.BasicFormsPresenter;
import org.dominokit.domino.basicforms.client.views.BasicFormsView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;

import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = BasicFormsPresenter.class)
public class BasicFormsViewImpl extends ComponentView<HTMLDivElement> implements BasicFormsView {

    public static final String MODULE_NAME = "basic-forms";
    private HTMLDivElement element = div().asElement();
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
        element.appendChild(LinkToSourceCode.create(MODULE_NAME, this.getClass()).asElement());
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
        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"textbox-samples").asElement());
        element.appendChild(textAreaCard.asElement());
        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"textarea-samples").asElement());
        element.appendChild(selectCard.asElement());
        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"select-samples").asElement());
        element.appendChild(checkboxCard.asElement());
        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"checkbox-samples").asElement());
        element.appendChild(radioCard.asElement());
        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"radio-samples").asElement());
        element.appendChild(switchCard.asElement());
        element.appendChild(CodeCard.createCodeCard(MODULE_NAME,"switch-samples").asElement());
    }


    private void initSwitchExample() {
        switchCard.appendChild(h(5).textContent("Basic Examples").style("margin-bottom: 25px;"));

        switchCard.appendChild(Row.create()
                .addColumn(Column.span3().appendChild(SwitchButton.create().setOffTitle("OFF").setOnTitle("ON")))
                .addColumn(Column.span3().appendChild(SwitchButton.create().setOffTitle("DISABLED").disable())));

        switchCard.appendChild(h(5).textContent("With Material Design Colors"));

        switchCard.appendChild(Row.create()
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("RED").setColor(Color.RED).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("PINK").setColor(Color.PINK).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("DEEP PURPLE").setColor(Color.DEEP_PURPLE).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("INDIGO").setColor(Color.INDIGO).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("BLUE").setColor(Color.BLUE).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("CYAN").setColor(Color.CYAN).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("TEAL").setColor(Color.TEAL).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("GREEN").setColor(Color.GREEN).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("LIME").setColor(Color.LIME).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("YELLOW").setColor(Color.YELLOW).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("AMBER").setColor(Color.AMBER).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("ORANGE").setColor(Color.ORANGE).check()))
                .addColumn(Column.span3()
                        .appendChild(SwitchButton.create().setOffTitle("GREY").setColor(Color.GREY).check())));
    }

    private void initRadioExample() {
        radioCard.appendChild(h(5).textContent("Basic Examples"));

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

        radioCard.appendChild(Row.create()
                .addColumn(Column.span(6, 6, 9, 12, 12)
                        .appendChild(horizontalRadioGroup)
                        .appendChild(firstDisabledGroup)
                        .appendChild(secondDisabledGroup))
                .asElement());

        radioCard.appendChild(br());


        radioCard.appendChild(Row.create()
                .addColumn(Column.span(2, 6)
                        .appendChild(h(5).textContent("With Material Design Colors"))
                        .appendChild(RadioGroup.create("color")
                                .appendChild(Radio.create("RED", "RED").setColor(Color.RED).check())
                                .appendChild(Radio.create("PINK", "PINK").setColor(Color.PINK))
                                .appendChild(Radio.create("DEEP PURPLE", "DEEP PURPLE").setColor(Color.DEEP_PURPLE))
                                .appendChild(Radio.create("INDIGO", "INDIGO").setColor(Color.INDIGO))
                                .appendChild(Radio.create("BLUE", "BLUE").setColor(Color.BLUE))
                                .appendChild(Radio.create("CYAN", "CYAN").setColor(Color.CYAN))
                                .appendChild(Radio.create("TEAL", "TEAL").setColor(Color.TEAL))
                                .appendChild(Radio.create("GREEN", "GREEN").setColor(Color.GREEN))
                                .appendChild(Radio.create("LIME", "LIME").setColor(Color.LIME))
                                .appendChild(Radio.create("YELLOW", "YELLOW").setColor(Color.YELLOW))
                                .appendChild(Radio.create("AMBER", "AMBER").setColor(Color.AMBER))
                                .appendChild(Radio.create("ORANGE", "ORANGE").setColor(Color.ORANGE))
                                .appendChild(Radio.create("GREY", "GREY").setColor(Color.GREY))))
                .addColumn(Column.span(2, 6)
                        .appendChild(h(5).textContent("With Material Design Colors with gap"))
                        .appendChild(RadioGroup.create("color-with-gap")
                                .appendChild(Radio.create("RED", "RED").setColor(Color.RED).withGap().check())
                                .appendChild(Radio.create("PINK", "PINK").setColor(Color.PINK).withGap())
                                .appendChild(Radio.create("DEEP PURPLE", "DEEP PURPLE").setColor(Color.DEEP_PURPLE).withGap())
                                .appendChild(Radio.create("INDIGO", "INDIGO").setColor(Color.INDIGO).withGap())
                                .appendChild(Radio.create("BLUE", "BLUE").setColor(Color.BLUE).withGap())
                                .appendChild(Radio.create("CYAN", "CYAN").setColor(Color.CYAN).withGap())
                                .appendChild(Radio.create("TEAL", "TEAL").setColor(Color.TEAL).withGap())
                                .appendChild(Radio.create("GREEN", "GREEN").setColor(Color.GREEN).withGap())
                                .appendChild(Radio.create("LIME", "LIME").setColor(Color.LIME).withGap())
                                .appendChild(Radio.create("YELLOW", "YELLOW").setColor(Color.YELLOW).withGap())
                                .appendChild(Radio.create("AMBER", "AMBER").setColor(Color.AMBER).withGap())
                                .appendChild(Radio.create("ORANGE", "ORANGE").setColor(Color.ORANGE).withGap())
                                .appendChild(Radio.create("GREY", "GREY").setColor(Color.GREY).withGap()))));
    }

    private void initCheckboxExample() {
        checkboxCard.appendChild(h(5).textContent("Basic Examples"));
        checkboxCard.appendChild(Row.create()
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("Default")))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("Filled In").filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("Default - Disabled").check().disable()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("Filled In - Disabled").check().filledIn().disable())));

        checkboxCard.appendChild(h(5).textContent("With Material Design Colors"));

        checkboxCard.appendChild(Row.create()
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("RED").setColor(Color.RED).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("PINK").setColor(Color.PINK).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("DEEP PURPLE").setColor(Color.DEEP_PURPLE).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("INDIGO").setColor(Color.INDIGO).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("BLUE").setColor(Color.BLUE).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("CYAN").setColor(Color.CYAN).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("TEAL").setColor(Color.TEAL).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("GREEN").setColor(Color.GREEN).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("LIME").setColor(Color.LIME).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("YELLOW").setColor(Color.YELLOW).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("AMBER").setColor(Color.AMBER).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("ORANGE").setColor(Color.ORANGE).check()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("GREY").setColor(Color.GREY).check()))
        );

        checkboxCard.appendChild(h(5).textContent("With Material Design Colors - Filled In"));

        checkboxCard.appendChild(Row.create()
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("RED").setColor(Color.RED).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("PINK").setColor(Color.PINK).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("DEEP PURPLE").setColor(Color.DEEP_PURPLE).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("INDIGO").setColor(Color.INDIGO).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("BLUE").setColor(Color.BLUE).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("CYAN").setColor(Color.CYAN).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("TEAL").setColor(Color.TEAL).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("GREEN").setColor(Color.GREEN).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("LIME").setColor(Color.LIME).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("YELLOW").setColor(Color.YELLOW).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("AMBER").setColor(Color.AMBER).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("ORANGE").setColor(Color.ORANGE).check().filledIn()))
                .addColumn(Column.span(2, 6)
                        .appendChild(CheckBox.create("GREY").setColor(Color.GREY).check().filledIn()))
        );
    }

    private void initSelectExample() {

        selectCard.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Select.create()
                                .appendChild(SelectOption.create("nothing", "-- please select --"))
                                .appendChild(SelectOption.create("value10", "10"))
                                .appendChild(SelectOption.create("value20", "20"))
                                .appendChild(SelectOption.create("value30", "30"))
                                .appendChild(SelectOption.create("value40", "40"))
                                .appendChild(SelectOption.create("value50", "50"))
                                .setSearchable(false)
                                .selectAt(0)
                                .addSelectionHandler(option1 -> {
                                    Notification.create("Item selected [ " + option1.getValue() + " ], [ " + option1.getDisplayValue() + " ]").show();
                                })))
                .addColumn(Column.span6()
                        .appendChild(Select.<String>create()
                                .appendChild(SelectOption.create("Disabled", "Disabled"))
                                .selectAt(0)
                                .disable()
                        ))
        );

        selectCard.appendChild(BlockHeader.create("Drop up example"));

        selectCard.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Select.<Integer>create()
                                .appendChild(SelectOption.create(0, "-- please select --"))
                                .appendChild(SelectOption.create(10, "10"))
                                .appendChild(SelectOption.create(20, "20"))
                                .appendChild(SelectOption.create(30, "30"))
                                .appendChild(SelectOption.create(40, "40"))
                                .appendChild(SelectOption.create(50, "50"))
                                .setSearchable(false)
                                .selectAt(0)
                                .dropup()
                                .addSelectionHandler(option -> {
                                    Notification.create("Item selected [ " + option.getValue() + " ]").show();
                                })))
        );

        selectCard.appendChild(Style.of(BlockHeader.create("Searchable select"))
                .setMarginBottom("30px")
                .get()
        );

        selectCard.appendChild(Row.create()
                .addColumn(Column.span12()
                        .appendChild(Select.<String>create("Country")
                                .appendChild(SelectOption.create("nothing", "-- please select --"))
                                .appendChild(SelectOption.create("USA", "America (USA)"))
                                .appendChild(SelectOption.create("ARG", "Argentina"))
                                .appendChild(SelectOption.create("BRA", "Brazil"))
                                .appendChild(SelectOption.create("DEN", "Denmark"))
                                .appendChild(SelectOption.create("CRO", "Croatia"))
                                .appendChild(SelectOption.create("IND", "India"))
                                .appendChild(SelectOption.create("SPA", "Spain"))
                                .appendChild(SelectOption.create("FRA", "France"))
                                .appendChild(SelectOption.create("JOR", "Jordan"))
                                .selectAt(0)
                                .addSelectionHandler(option -> {
                                    Notification.create("Item selected [ " + option.getValue() + " ]").show();
                                })))
        );

        selectCard.appendChild(Style.of(BlockHeader.create("Grouping select"))
                .setMarginBottom("30px")
                .get()
        );

        selectCard.appendChild(Row.create()
                .addColumn(Column.span12()
                        .appendChild(Select.<String>create("Country")
                                .addGroup(SelectOptionGroup.<String>create(Badge.create("America").setBackground(Color.RED))
                                        .appendChild(SelectOption.create("USA", "United States of America"))
                                        .appendChild(SelectOption.create("BRA", "Brazil"))
                                        .appendChild(SelectOption.create("ARG", "Argentina"))
                                        .appendChild(SelectOption.create("MEX", "Mexico"))
                                        .appendChild(SelectOption.create("CHI", "Chile"))
                                )
                                .divider()
                                .addGroup(SelectOptionGroup.<String>create(Badge.create("Europe").setBackground(Color.GREEN))
                                        .appendChild(SelectOption.create("FRA", "France"))
                                        .appendChild(SelectOption.create("GER", "Germany"))
                                        .appendChild(SelectOption.create("SPA", "Spain"))
                                        .appendChild(SelectOption.create("ITA", "Italy"))
                                        .appendChild(SelectOption.create("UK", "United Kingdom"))
                                )
                                .selectAt(0)
                                .addSelectionHandler(option -> {
                                    Notification.create("Item selected [ " + option.getValue() + " ]").show();
                                })))
        );
    }

    private void initBasicExamples() {
        inputCard.appendChild(BlockHeader.create("Basic Example"))
                .appendChild(TextBox.create().setPlaceholder("Username"))
                .appendChild(TextBox.password().setPlaceholder("Password"));
    }

    private void initDifferentWidths() {

        inputCard.appendChild(BlockHeader.create("Different Widths"))
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-6")))
                        .addColumn(Column.span6()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-6")))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-4")))
                        .addColumn(Column.span4()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-4")))
                        .addColumn(Column.span4()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-4")))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                        .addColumn(Column.span3()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                        .addColumn(Column.span3()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                        .addColumn(Column.span3()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                );
    }

    private void initDifferentSizes() {
        inputCard.appendChild(BlockHeader.create("Different Sizes"))
                .appendChild(TextBox.create().setPlaceholder("Large Input").large())
                .appendChild(TextBox.create().setPlaceholder("Default Input"))
                .appendChild(TextBox.create().setPlaceholder("Small Input").small());
    }

    private void initFloatingLabel() {
        inputCard.appendChild(BlockHeader.create("Floating Label Examples"))
                .appendChild(TextBox.create("Username"))
                .appendChild(TextBox.password("Password"))
                .appendChild(TextBox.create("Large Input").large())
                .appendChild(TextBox.create("Default Input"))
                .appendChild(TextBox.create("Small Input").small())
                .appendChild(BlockHeader.create("Always floating"))
                .appendChild(TextBox.create("Age").floating())
                .appendChild(TextBox.create("Email").floating());
    }

    private void initInputStatus() {

        inputCard.appendChild(BlockHeader.create("Input Status"))
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(TextBox.create("Focused").focus()))
                        .addColumn(Column.span6()
                                .appendChild(TextBox.create("Disabled").disable())));
    }

    private void initBasicTextAreaExample() {
        textAreaCard.appendChild(BlockHeader.create("Basic Examples"))
                .appendChild(TextArea.create().setPlaceholder("Start typing here..."));

        textAreaCard.appendChild(BlockHeader.create("Auto Growing Vertical Direction"))
                .appendChild(TextArea.create().setPlaceholder("Start typing here...").autoSize());

        textAreaCard.appendChild(BlockHeader.create("Text Area With Label"))
                .appendChild(TextArea.create("Description").autoSize());
    }
}