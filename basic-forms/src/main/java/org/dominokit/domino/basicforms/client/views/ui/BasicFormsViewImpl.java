package org.dominokit.domino.basicforms.client.views.ui;

import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.api.shared.extension.Aggregate;
import org.dominokit.domino.basicforms.client.presenters.BasicFormsProxy;
import org.dominokit.domino.basicforms.client.views.BasicFormsView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.CheckBox;
import org.dominokit.domino.ui.forms.FieldStyle;
import org.dominokit.domino.ui.forms.Radio;
import org.dominokit.domino.ui.forms.RadioGroup;
import org.dominokit.domino.ui.forms.Select;
import org.dominokit.domino.ui.forms.SelectOption;
import org.dominokit.domino.ui.forms.SelectOptionGroup;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextArea;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.jboss.elemento.Elements.br;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.h;
import static org.jboss.elemento.Elements.hr;

@UiView(presentable = BasicFormsProxy.class)
@SampleClass
public class BasicFormsViewImpl extends BaseDemoView<HTMLDivElement> implements BasicFormsView {

    private HTMLDivElement element = div().element();
    private Card fieldsStylesCard;
    private Card inputCard;
    private Card textAreaCard;
    private Card selectCard;
    private Card checkboxCard;
    private Card radioCard;
    private Card switchCard;

    private CodeCard basicExamplesCard = new CodeCard();

    protected BasicFormsCode basicFormsCode;

    @Override
    protected HTMLDivElement init() {
        basicFormsCode = new BasicFormsCode().init(this);
        element.appendChild(LinkToSourceCode.create("basic-forms", this.getClass()).element());
        element.appendChild(BlockHeader.create("BASIC FORM ELEMENTS").element());

        fieldsStylesCard = Card.create("FIELDS STYLES", "Lined & Rounded");
        inputCard = Card.create("INPUT", "Different sizes and widths.");
        textAreaCard = Card.create("TEXTAREA");
        selectCard = Card.create("SELECT");
        checkboxCard = Card.create("CHECKBOX");
        radioCard = Card.create("RADIO");
        switchCard = Card.create("SWITCH BUTTONS");

        initDifferentStyles();
        initBasicExamples();
        initDifferentWidths();
        initFloatingLabel();
        initInputStatus();
        initBasicTextAreaExample();
        initSelectExample();
        initCheckboxExample();
        initRadioExample();
        initSwitchExample();



        element.appendChild(fieldsStylesCard.element());
        element.appendChild(CodeCard.createCodeCard(
                CodeResource.INSTANCE.initDifferentStyles()
        ).element());

        element.appendChild(inputCard.element());
        element.appendChild(basicExamplesCard.element());

        CodeCard.completeFetchCode(CodeResource.INSTANCE.initBasicExamples(), value -> basicFormsCode.completeBasicExamples(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.initDifferentWidths(), value -> basicFormsCode.completeDifferentWidths(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.initFloatingLabel(), value -> basicFormsCode.completeFloatingLabels(value));
        CodeCard.completeFetchCode(CodeResource.INSTANCE.initInputStatus(), value -> basicFormsCode.completeInputStatus(value));

        element.appendChild(textAreaCard.element());
        element.appendChild(CodeCard.createCodeCard(
                CodeResource.INSTANCE.initBasicTextAreaExample()
        ).element());


        element.appendChild(selectCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSelectExample()).element());

        element.appendChild(checkboxCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initCheckboxExample()).element());

        element.appendChild(radioCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initRadioExample()).element());

        element.appendChild(switchCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSwitchExample()).element());

        return element;
    }

    @SampleMethod
    private void initDifferentStyles() {

        fieldsStylesCard
                .apply(self -> self.getBody().style().setPadding("50px"))
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(BlockHeader.create("LINED"))
                                .appendChild(hr())
                                .appendChild(BlockHeader.create("Normal"))
                                .appendChild(TextBox.create("Domain email")
                                        .value("ahmad.bawaneh")
                                )
                                .appendChild(TextBox.create("Domain email")
                                        .setFieldStyle(FieldStyle.LINED)
                                        .setMaxLength(50)
                                        .addLeftAddOn(Icons.ALL.email_mdi().clickable())
                                        .addRightAddOn(Icons.ALL.plus_mdi().clickable())
                                        .setHelperText("Should be a subdomain of dominokit")
                                        .value("ahmad.bawaneh")
                                        .setReadOnly(false)
                                        .setPrefix("domino.")
                                        .setPostFix("@dominokit.org")
                                )
                                .appendChild(BlockHeader.create("Invalid"))
                                .appendChild(TextBox.create("Domain email")
                                        .setFieldStyle(FieldStyle.LINED)
                                        .setMaxLength(50)
                                        .addLeftAddOn(Icons.ALL.email_mdi().clickable())
                                        .addRightAddOn(Icons.ALL.plus_mdi().clickable())
                                        .setHelperText("Should be a subdomain of dominokit")
                                        .value("random.name")
                                        .setReadOnly(false)
                                        .setPrefix("domino.")
                                        .setPostFix("@dominokit.org")
                                        .invalidate("Sub domain not found")
                                )
                                .appendChild(BlockHeader.create("Readonly"))
                                .appendChild(TextBox.create("Domain email")
                                        .setFieldStyle(FieldStyle.LINED)
                                        .setMaxLength(50)
                                        .addLeftAddOn(Icons.ALL.email_mdi().clickable())
                                        .addRightAddOn(Icons.ALL.plus_mdi().clickable())
                                        .setHelperText("Should be a subdomain of dominokit")
                                        .value("random.name")
                                        .setReadOnly(true)
                                        .setPrefix("domino.")
                                        .setPostFix("@dominokit.org")
                                )
                                .appendChild(BlockHeader.create("Disabled"))
                                .appendChild(TextBox.create("Domain email")
                                        .setFieldStyle(FieldStyle.LINED)
                                        .setMaxLength(50)
                                        .addLeftAddOn(Icons.ALL.email_mdi().clickable())
                                        .addRightAddOn(Icons.ALL.plus_mdi().clickable())
                                        .setHelperText("Should be a subdomain of dominokit")
                                        .value("random.name")
                                        .disable()
                                        .setPrefix("domino.")
                                        .setPostFix("@dominokit.org")
                                )
                        )
                        .appendChild(Column.span4()
                                .offset6()
                                .appendChild(BlockHeader.create("ROUNDED"))
                                .appendChild(hr())
                                .appendChild(BlockHeader.create("Normal"))
                                .appendChild(TextBox.create("Domain email")
                                        .setFieldStyle(FieldStyle.ROUNDED)
                                        .setMaxLength(50)
                                        .addLeftAddOn(Icons.ALL.account_mdi().clickable())
                                        .addRightAddOn(Icons.ALL.account_mdi().clickable())
                                        .setHelperText("Should be a subdomain of dominokit")
                                        .value("ahmad.bawaneh")
                                        .setReadOnly(false)
                                        .setPrefix("domino.")
                                        .setPostFix("@dominokit.org")
                                )
                                .appendChild(BlockHeader.create("Invalid"))
                                .appendChild(TextBox.create("Domain email")
                                        .setFieldStyle(FieldStyle.ROUNDED)
                                        .setMaxLength(50)
                                        .addLeftAddOn(Icons.ALL.account_mdi().clickable())
                                        .addRightAddOn(Icons.ALL.account_mdi().clickable())
                                        .setHelperText("Should be a subdomain of dominokit")
                                        .value("random.name")
                                        .setReadOnly(false)
                                        .setPrefix("domino.")
                                        .setPostFix("@dominokit.org")
                                        .invalidate("Sub domain not found")
                                )
                                .appendChild(BlockHeader.create("Readonly"))
                                .appendChild(TextBox.create("Domain email")
                                        .setFieldStyle(FieldStyle.ROUNDED)
                                        .setMaxLength(50)
                                        .addLeftAddOn(Icons.ALL.account_mdi().clickable())
                                        .addRightAddOn(Icons.ALL.account_mdi().clickable())
                                        .setHelperText("Should be a subdomain of dominokit")
                                        .value("random.name")
                                        .setReadOnly(true)
                                        .setPrefix("domino.")
                                        .setPostFix("@dominokit.org")
                                )
                                .appendChild(BlockHeader.create("Disabled"))
                                .appendChild(TextBox.create("Domain email")
                                        .setFieldStyle(FieldStyle.ROUNDED)
                                        .setMaxLength(50)
                                        .addLeftAddOn(Icons.ALL.account_mdi().clickable())
                                        .addRightAddOn(Icons.ALL.account_mdi().clickable())
                                        .setHelperText("Should be a subdomain of dominokit")
                                        .value("random.name")
                                        .disable()
                                        .setPrefix("domino.")
                                        .setPostFix("@dominokit.org")
                                )
                        )
                );
    }

    @Aggregate(name = "BasicFormsCode")
    public void onCodeLoaded(String basicExamples, String differentWidths, String floatingLabels, String inputStatus) {
        basicExamplesCard.setCode("// -------------- Basic examples\n" +
                basicExamples +
                "\n\n// -------------- Different widths\n" +
                differentWidths +
                "\n\n// -------------- Floating Label Examples\n" +
                floatingLabels +
                "\n\n// -------------- Input Status\n" +
                inputStatus);
    }

    @SampleMethod
    private void initSwitchExample() {
        switchCard.appendChild(h(5).textContent("Basic Examples").style("margin-bottom: 25px;"));

        switchCard.appendChild(Row.create()
                .addColumn(Column.span3().appendChild(SwitchButton.create("Active", "off", "on")
                        .addChangeHandler(value -> Notification.createInfo("test " + value).show())
                        .setOffTitle("OFF").setOnTitle("ON")))
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

    @SampleMethod
    private void initRadioExample() {
        radioCard.appendChild(h(5).textContent("Basic Examples"));

        Radio<String> radio1 = Radio.create("radio1", "Radio - 1").check();
        Radio<String> radio2 = Radio.create("radio2", "Radio - 2");
        Radio<String> radio1Gap = Radio.create("radio1_gap", "Radio 1 - With Gap").withGap();
        Radio<String> radio2Gap = Radio.create("radio2_gap", "Radio 2 - With Gap").withGap();

        RadioGroup<String> horizontalRadioGroup = RadioGroup.<String>create("test")
                .appendChild(radio1)
                .appendChild(radio2)
                .appendChild(radio1Gap)
                .appendChild(radio2Gap)
                .horizontal();

        Radio<String> firstDisabledRadio = Radio.<String>create("radio1_disabled", "Radio - Disabled").check().disable();
        Radio<String> secondsDisabledRadio = Radio.<String>create("radio2_disabled", "Radio - Disabled").withGap().check().disable();

        firstDisabledRadio.element().style.margin = CSSProperties.MarginUnionType.of("5px");
        secondsDisabledRadio.element().style.margin = CSSProperties.MarginUnionType.of("5px");

        RadioGroup<String> firstDisabledGroup = RadioGroup.<String>create("disabled").appendChild(firstDisabledRadio);
        RadioGroup<String> secondDisabledGroup = RadioGroup.<String>create("disabled").appendChild(secondsDisabledRadio);

        radioCard.appendChild(Row.create()
                .addColumn(Column.span(6, 6, 9, 12, 12)
                        .appendChild(horizontalRadioGroup)
                        .appendChild(firstDisabledGroup)
                        .appendChild(secondDisabledGroup))
                .element());

        radioCard.appendChild(br());


        radioCard.appendChild(Row.create()
                .addColumn(Column.span(3, 6)
                        .appendChild(h(5).textContent("With Material Design Colors"))
                        .appendChild(RadioGroup.<String>create("color")
                                .appendChild(Radio.create("RED", "RED").setColor(Color.RED))
                                .appendChild(Radio.create("PINK", "PINK").setColor(Color.PINK))
                                .appendChild(Radio.create("DEEP PURPLE", "DEEP PURPLE").setColor(Color.DEEP_PURPLE))
                                .appendChild(Radio.create("INDIGO", "INDIGO").setColor(Color.INDIGO))
                                .appendChild(Radio.create("BLUE", "BLUE").setColor(Color.BLUE).check())
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
                        .appendChild(RadioGroup.<String>create("color-with-gap")
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

    @SampleMethod
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

    @SampleMethod
    private void initSelectExample() {

        selectCard.appendChild(Row.create()
                .addColumn(Column.span6()
                        .appendChild(Select.<String>create()
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
                                .setCreatable(true)
                                .apply(self -> {
                                    self.setOnAddOptionHandler((input, completeHandler) -> {
                                        TextBox countryName = TextBox.create("Name").value(input).focus();
                                        TextBox countryCode = TextBox.create("code");
                                        self.closeMenu(countryName::focus);
                                        Button addButton = Button.createPrimary("Add");
                                        Popover.create(self, "Add country", DominoElement.div()
                                                .appendChild(Row.create()
                                                        .appendChild(Column.span12()
                                                                .appendChild(countryName)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Column.span12()
                                                                .appendChild(countryCode)
                                                        )
                                                )
                                                .appendChild(Row.create()
                                                        .appendChild(Column.span12()
                                                                .appendChild(addButton)
                                                        )
                                                ).element()
                                        )
                                                .apply(popover -> addButton.addClickListener(evt -> {
                                                    completeHandler.accept(SelectOption.create(countryCode.getValue().toUpperCase(), countryName.getValue()));
                                                    popover.close();
                                                }))
                                                .position(PopupPosition.BEST_FIT)
                                                .show();

                                    });

                                })
                                .appendChild(SelectOption.create("nothing", "-- please select --")
                                        .setExcludeFromSearchResults(true)
                                )
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

    @SampleMethod
    private void initBasicExamples() {
        inputCard.appendChild(BlockHeader.create("Basic Example"))
                .appendChild(TextBox.create().setLabel("User name").setPlaceholder("Username"))
                .appendChild(TextBox.password().setLabel("Password").setPlaceholder("Password"));
    }

    @SampleMethod
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

    @SampleMethod
    private void initFloatingLabel() {
        inputCard.appendChild(BlockHeader.create("Floating Label Examples"))
                .appendChild(TextBox.create("Username"))
                .appendChild(TextBox.password("Password"))
                .appendChild(TextBox.create("Default Input"))
                .appendChild(BlockHeader.create("Always floating"))
                .appendChild(TextBox.create("Age").floating())
                .appendChild(TextBox.create("Email").floating());
    }

    @SampleMethod
    private void initInputStatus() {

        inputCard.appendChild(BlockHeader.create("Input Status"))
                .appendChild(Row.create()
                        .addColumn(Column.span6()
                                .appendChild(TextBox.create("Focused")))
                        .addColumn(Column.span6()
                                .appendChild(TextBox.create("Disabled").disable())));
    }

    @SampleMethod
    private void initBasicTextAreaExample() {
        textAreaCard.appendChild(BlockHeader.create("Basic Examples"))
                .appendChild(TextArea.create().setPlaceholder("Start typing here..."));

        textAreaCard.appendChild(BlockHeader.create("Auto Growing Vertical Direction"))
                .appendChild(TextArea.create().setPlaceholder("Start typing here...").autoSize());

        textAreaCard.appendChild(BlockHeader.create("Text Area With Label"))
                .appendChild(TextArea.create("Description").autoSize());
    }
}