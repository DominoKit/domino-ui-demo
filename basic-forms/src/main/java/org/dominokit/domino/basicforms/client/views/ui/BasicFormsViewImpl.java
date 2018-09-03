package org.dominokit.domino.basicforms.client.views.ui;

import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.basicforms.client.presenters.BasicFormsPresenter;
import org.dominokit.domino.basicforms.client.views.BasicFormsView;
import org.dominokit.domino.basicforms.client.views.CodeResource;
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
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.textboxSamples()).asElement());
        element.appendChild(textAreaCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.textareaSamples()).asElement());
        element.appendChild(selectCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.selectSamples()).asElement());
        element.appendChild(checkboxCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.checkBoxSamples()).asElement());
        element.appendChild(radioCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.radioSamples()).asElement());
        element.appendChild(switchCard.asElement());
        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.switchSamples()).asElement());
    }


    private void initSwitchExample() {
        switchCard.appendChild(h(5).textContent("Basic Examples").style("margin-bottom: 25px;"));

        Column column = Column.span3();
        switchCard.appendChild(Row.create()
                .addColumn(column.appendChild(SwitchButton.create().setOffTitle("OFF").setOnTitle("ON")))
                .addColumn(column.copy().appendChild(SwitchButton.create().setOffTitle("DISABLED").disable())));

        switchCard.appendChild(h(5).textContent("With Material Design Colors"));

        switchCard.appendChild(Row.create()
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("RED").setColor(Color.RED).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("PINK").setColor(Color.PINK).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("DEEP PURPLE").setColor(Color.DEEP_PURPLE).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("INDIGO").setColor(Color.INDIGO).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("BLUE").setColor(Color.BLUE).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("CYAN").setColor(Color.CYAN).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("TEAL").setColor(Color.TEAL).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("GREEN").setColor(Color.GREEN).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("LIME").setColor(Color.LIME).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("YELLOW").setColor(Color.YELLOW).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("AMBER").setColor(Color.AMBER).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("ORANGE").setColor(Color.ORANGE).check()))
                .addColumn(column.copy()
                        .appendChild(SwitchButton.create().setOffTitle("GREY").setColor(Color.GREY).check())));
    }

    private void initRadioExample() {
        Column column = Column.span(6, 6, 9, 12, 12);
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
                .addColumn(column
                        .appendChild(horizontalRadioGroup)
                        .appendChild(firstDisabledGroup)
                        .appendChild(secondDisabledGroup))
                .asElement());

        radioCard.appendChild(br());

        column = Column.span(2, 6);

        radioCard.appendChild(Row.create()
                .addColumn(column.copy()
                        .appendChild(h(5).textContent("With Material Design Colors"))
                        .appendChild(RadioGroup.create("color")
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
                                .addRadio(Radio.create("GREY", "GREY").setColor(Color.GREY))))
                .addColumn(column.copy()
                        .appendChild(h(5).textContent("With Material Design Colors with gap"))
                        .appendChild(RadioGroup.create("color-with-gap")
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
                                .addRadio(Radio.create("GREY", "GREY").setColor(Color.GREY).withGap()))));
    }

    private void initCheckboxExample() {
        Column column = Column.span(2,6);

        checkboxCard.appendChild(h(5).textContent("Basic Examples"));
        checkboxCard.appendChild(Row.create()
                .addColumn(column
                        .appendChild(CheckBox.create("Default")))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("Filled In").filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("Default - Disabled").check().disable()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("Filled In - Disabled").check().filledIn().disable())));

        checkboxCard.appendChild(h(5).textContent("With Material Design Colors"));

        checkboxCard.appendChild(Row.create()
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("RED").setColor(Color.RED).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("PINK").setColor(Color.PINK).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("DEEP PURPLE").setColor(Color.DEEP_PURPLE).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("INDIGO").setColor(Color.INDIGO).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("BLUE").setColor(Color.BLUE).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("CYAN").setColor(Color.CYAN).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("TEAL").setColor(Color.TEAL).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("GREEN").setColor(Color.GREEN).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("LIME").setColor(Color.LIME).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("YELLOW").setColor(Color.YELLOW).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("AMBER").setColor(Color.AMBER).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("ORANGE").setColor(Color.ORANGE).check()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("GREY").setColor(Color.GREY).check()))
                );

        checkboxCard.appendChild(h(5).textContent("With Material Design Colors - Filled In"));

        checkboxCard.appendChild(Row.create()
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("RED").setColor(Color.RED).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("PINK").setColor(Color.PINK).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("DEEP PURPLE").setColor(Color.DEEP_PURPLE).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("INDIGO").setColor(Color.INDIGO).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("BLUE").setColor(Color.BLUE).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("CYAN").setColor(Color.CYAN).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("TEAL").setColor(Color.TEAL).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("GREEN").setColor(Color.GREEN).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("LIME").setColor(Color.LIME).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("YELLOW").setColor(Color.YELLOW).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("AMBER").setColor(Color.AMBER).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("ORANGE").setColor(Color.ORANGE).check().filledIn()))
                .addColumn(column.copy()
                        .appendChild(CheckBox.create("GREY").setColor(Color.GREY).check().filledIn()))
                );
    }

    private void initSelectExample() {
        Column column = Column.span6();

        selectCard.appendChild(Row.create()
                .addColumn(column
                        .appendChild(Select.create()
                                .addOption(SelectOption.create("nothing", "-- please select --"))
                                .addOption(SelectOption.create("value10", "10"))
                                .addOption(SelectOption.create("value20", "20"))
                                .addOption(SelectOption.create("value30", "30"))
                                .addOption(SelectOption.create("value40", "40"))
                                .addOption(SelectOption.create("value50", "50"))
                                .setSearchable(false)
                                .selectAt(0)
                                .addSelectionHandler(option1 -> {
                                    Notification.create("Item selected [ " + option1.getValue() + " ], [ " + option1.getDisplayValue() + " ]").show();
                                })))
                .addColumn(column.copy()
                        .appendChild(Select.<String>create()
                                .addOption(SelectOption.create("Disabled", "Disabled"))
                                .selectAt(0)
                                .disable()
                        ))
                );

        selectCard.appendChild(BlockHeader.create("Drop up example"));

        selectCard.appendChild(Row.create()
                .addColumn(column.copy()
                        .appendChild(Select.<Integer>create()
                                .addOption(SelectOption.create(0, "-- please select --"))
                                .addOption(SelectOption.create(10, "10"))
                                .addOption(SelectOption.create(20, "20"))
                                .addOption(SelectOption.create(30, "30"))
                                .addOption(SelectOption.create(40, "40"))
                                .addOption(SelectOption.create(50, "50"))
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
                                .addOption(SelectOption.create("nothing", "-- please select --"))
                                .addOption(SelectOption.create("USA", "America (USA)"))
                                .addOption(SelectOption.create("ARG", "Argentina"))
                                .addOption(SelectOption.create("BRA", "Brazil"))
                                .addOption(SelectOption.create("DEN", "Denmark"))
                                .addOption(SelectOption.create("CRO", "Croatia"))
                                .addOption(SelectOption.create("IND", "India"))
                                .addOption(SelectOption.create("SPA", "Spain"))
                                .addOption(SelectOption.create("FRA", "France"))
                                .addOption(SelectOption.create("JOR", "Jordan"))
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
                                        .addOption(SelectOption.create("USA", "United States of America"))
                                        .addOption(SelectOption.create("BRA", "Brazil"))
                                        .addOption(SelectOption.create("ARG", "Argentina"))
                                        .addOption(SelectOption.create("MEX", "Mexico"))
                                        .addOption(SelectOption.create("CHI", "Chile"))
                                )
                                .divider()
                                .addGroup(SelectOptionGroup.<String>create(Badge.create("Europe").setBackground(Color.GREEN))
                                        .addOption(SelectOption.create("FRA", "France"))
                                        .addOption(SelectOption.create("GER", "Germany"))
                                        .addOption(SelectOption.create("SPA", "Spain"))
                                        .addOption(SelectOption.create("ITA", "Italy"))
                                        .addOption(SelectOption.create("UK", "United Kingdom"))
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
        Column column6Size = Column.span6();
        Column column4Size = Column.span4();
        Column column3Size = Column.span3();


        inputCard.appendChild(BlockHeader.create("Different Widths"))
                .appendChild(Row.create()
                        .addColumn(column6Size
                                .appendChild(TextBox.create().setPlaceholder("col-sm-6")))
                        .addColumn(column6Size.copy()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-6")))
                        )
                .appendChild(Row.create()
                        .addColumn(column4Size
                                .appendChild(TextBox.create().setPlaceholder("col-sm-4")))
                        .addColumn(column4Size.copy()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-4")))
                        .addColumn(column4Size.copy()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-4")))
                        )
                .appendChild(Row.create()
                        .addColumn(column3Size
                                .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                        .addColumn(column3Size.copy()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                        .addColumn(column3Size.copy()
                                .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                        .addColumn(column3Size.copy()
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
        Column column6Size = Column.span6();

        inputCard.appendChild(BlockHeader.create("Input Status"))
                .appendChild(Row.create()
                        .addColumn(column6Size
                                .appendChild(TextBox.create("Focused").focus()))
                        .addColumn(column6Size.copy()
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