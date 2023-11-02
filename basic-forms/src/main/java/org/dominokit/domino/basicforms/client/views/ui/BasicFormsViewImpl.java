package org.dominokit.domino.basicforms.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.basicforms.client.presenters.BasicFormsProxy;
import org.dominokit.domino.basicforms.client.views.BasicFormsView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.*;
import org.dominokit.domino.ui.forms.suggest.MultiSelect;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.icons.lib.IconsMeta;
import org.dominokit.domino.ui.icons.LabeledIcon;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.menu.CustomMenuItem;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import java.util.Arrays;

import static org.dominokit.domino.ui.grid.Column.Span._2;
import static org.dominokit.domino.ui.grid.Column.Span._6;

@UiView(presentable = BasicFormsProxy.class)
@SampleClass
public class BasicFormsViewImpl extends BaseDemoView<HTMLDivElement> implements BasicFormsView {

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.createLink("basic-forms", this.getClass()).element());
        element.appendChild(BlockHeader.create("BASIC FORM ELEMENTS").element());

        initBasicExamples();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initBasicExamples()));
        initBasicTextAreaExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initBasicTextAreaExample()));
        initSelectExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSelectExample()));
        initCheckboxExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initCheckboxExample()));
        initRadioExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initRadioExample()));
        initSwitchExample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initSwitchExample()));


        return element.element();
    }

    @SampleMethod
    private void initBasicExamples() {
        element
                .appendChild(Card.create("INPUT", "Different sizes and widths.")
                        .setCollapsible(true)
                        .appendChild(BlockHeader.create("Basic Example"))
                        .appendChild(Row.create()
                                .span12(TextBox.create().setLabel("User name")
                                        .setPlaceholder("Username"))
                        )
                        .appendChild(Row.create()
                                .span12(PasswordBox.create().setLabel("Password").setPlaceholder("Password"))
                        )
                        .appendChild(BlockHeader.create("Different Widths"))
                        .appendChild(Row.create()
                                .appendChild(Column.span6()
                                        .appendChild(TextBox.create().setPlaceholder("col-sm-6")))
                                .appendChild(Column.span6()
                                        .appendChild(TextBox.create().setPlaceholder("col-sm-6")))
                        )
                        .appendChild(Row.create()
                                .appendChild(Column.span4()
                                        .appendChild(TextBox.create().setPlaceholder("col-sm-4")))
                                .appendChild(Column.span4()
                                        .appendChild(TextBox.create().setPlaceholder("col-sm-4")))
                                .appendChild(Column.span4()
                                        .appendChild(TextBox.create().setPlaceholder("col-sm-4")))
                        )
                        .appendChild(Row.create()
                                .appendChild(Column.span3()
                                        .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                                .appendChild(Column.span3()
                                        .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                                .appendChild(Column.span3()
                                        .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                                .appendChild(Column.span3()
                                        .appendChild(TextBox.create().setPlaceholder("col-sm-3")))
                        )
                        .appendChild(BlockHeader.create("Input Status"))
                        .appendChild(Row.create()
                                .appendChild(Column.span4()
                                        .appendChild(TextBox.create("Focused").withValue("Focused")))
                                .appendChild(Column.span4()
                                        .appendChild(TextBox.create("Disabled")
                                                .withValue("disabled")
                                                .disable()))
                                .appendChild(Column.span4()
                                        .appendChild(TextBox.create("Read only")
                                                .withValue("Sample value")
                                                .setReadOnly(true)))
                        )
                );
    }

    @SampleMethod
    private void initBasicTextAreaExample() {
        element.appendChild(Card.create("TEXTAREA")
                .setCollapsible(true)
                .appendChild(BlockHeader.create("Basic Examples"))
                .appendChild(TextAreaBox.create().setPlaceholder("Start typing here..."))
                .appendChild(BlockHeader.create("Auto Growing Vertical Direction"))
                .appendChild(TextAreaBox.create().setPlaceholder("Start typing here...").autoSize())
                .appendChild(BlockHeader.create("Text Area With Label"))
                .appendChild(TextAreaBox.create("Description").autoSize())
        );
    }

    @SampleMethod
    private void initSelectExample() {
        element.appendChild(Card.create("SELECT")
                .setCollapsible(true)
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(Select.<String>create()
                                        .appendChild(SelectOption.create("nothing", null, "-- please select --"))
                                        .appendChild(SelectOption.create("value10", "value10", "10"))
                                        .appendChild(SelectOption.create("value20", "value20", "20"))
                                        .appendChild(SelectOption.create("value30", "value30", "30"))
                                        .appendChild(SelectOption.create("value40", "value40", "40"))
                                        .appendChild(SelectOption.create("value50", "value50", "50"))
                                        .setSearchable(false)
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> Notification.create("Item selected : Old value[ " + oldValue + " ], New value [" + newValue + "]").show())))
                        .appendChild(Column.span6()
                                .appendChild(Select.<String>create()
                                        .appendChild(SelectOption.create("Disabled", "Disabled", "Disabled"))
                                        .selectAt(0)
                                        .disable()
                                ))
                )
                .appendChild(BlockHeader.create("Searchable select"))
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(Select.<String>create("Country")
                                        .setSearchable(true)
                                        .setMissingItemHandler((select, token, onComplete) -> {
                                            TextBox countryName = TextBox.create("Name")
                                                    .setRequired(true)
                                                    .withValue(token);
                                            TextBox countryCode = TextBox.create("code")
                                                    .setRequired(true);
                                            Popover.create(select.getWrapperElement())
                                                    .addCss(dui_rounded_sm)
                                                    .setPosition(DropDirection.BEST_MIDDLE_UP_DOWN)
                                                    .apply(popover -> {
                                                        popover.appendChild(Card.create("Create country")
                                                                .setIcon(Icons.map_marker())
                                                                .addCss(dui_elevation_0, dui_m_2px, dui_rounded_sm)
                                                                .appendChild(countryName)
                                                                .appendChild(countryCode)
                                                                .appendChild(div().addCss(dui_flex, dui_justify_center, dui_p_1)
                                                                        .appendChild(Button.create("Create country").addClickListener(evt -> {
                                                                            if (countryName.validate().isValid() && countryCode.validate().isValid()) {
                                                                                SelectOption<String> option = SelectOption.create(countryCode.getValue().toUpperCase(), countryCode.getValue().toUpperCase(), countryName.getValue());
                                                                                onComplete.accept(option);
                                                                                select.selectOption(option);
                                                                                popover.close();
                                                                            }
                                                                        }))
                                                                )
                                                        );
                                                    })
                                                    .addExpandListener(() -> {
                                                        select.getOptionsMenu().close();
                                                        countryName.focus();
                                                    })
                                                    .open();

                                        })
                                        .appendChild(SelectOption.create("nothing", "nothing", "-- please select --")
                                                .setSearchable(false)
                                        )
                                        .appendChild(SelectOption.create("USA", "USA", "America (USA)"))
                                        .appendChild(SelectOption.create("ARG", "ARG", "Argentina"))
                                        .appendChild(SelectOption.create("BRA", "BRA", "Brazil"))
                                        .appendChild(SelectOption.create("DEN", "DEN", "Denmark"))
                                        .appendChild(SelectOption.create("CRO", "CRO", "Croatia"))
                                        .appendChild(SelectOption.create("IND", "IND", "India"))
                                        .appendChild(SelectOption.create("SPA", "SPA", "Spain"))
                                        .appendChild(SelectOption.create("FRA", "FRA", "France"))
                                        .appendChild(SelectOption.create("JOR", "JOR", "Jordan"))
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Item selected [ " + newValue + " ]").show();
                                        })
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(Select.<String>create("Country")
                                        .setSearchable(true)
                                        .appendChild(SelectOption.create("nothing", "nothing", "-- please select --")
                                                .setSearchable(false)
                                        )
                .appendChild(SelectOption.create("USA", "USA", "America (USA)"))
                .appendChild(SelectOption.create("ARG", "ARG", "Argentina"))
                .appendChild(SelectOption.create("BRA", "BRA", "Brazil"))
                .appendChild(SelectOption.create("DEN", "DEN", "Denmark"))
                .appendChild(SelectOption.create("CRO", "CRO", "Croatia"))
                .appendChild(SelectOption.create("IND", "IND", "India"))
                .appendChild(SelectOption.create("SPA", "SPA", "Spain"))
                .appendChild(SelectOption.create("FRA", "FRA", "France"))
                .appendChild(SelectOption.create("JOR", "JOR", "Jordan"))
                .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Item selected [ " + newValue + " ]").show();
                                        })
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Grouping select"))
                                .appendChild(Select.<String>create("Country")
                                        .group(group -> {
                                                    group.withHeader((parent, header) -> header
                                                            .appendChild(PrefixAddOn.of(Icons.map_marker()))
                                                            .appendChild(PostfixAddOn.of(Badge.create("5").addCss(dui_bg_d_2, dui_rounded_full)))
                                                            .addCss(dui_h_8, dui_blue)
                                                            .setTitle("America")
                                                    );
                                                }, Arrays.asList(SelectOption.create("USA", "USA", "United States of America"),
                                                        SelectOption.create("BRA", "BRA", "Brazil"),
                                                        SelectOption.create("ARG", "ARG", "Argentina"),
                                                        SelectOption.create("MEX", "MEX", "Mexico"),
                                                        SelectOption.create("CHI", "CHI", "Chile")
                                                )
                                        )
                                        .group(group -> {
                                                    group.withHeader((parent, header) -> header
                                                            .appendChild(PrefixAddOn.of(Icons.map_marker()))
                                                            .appendChild(PostfixAddOn.of(Badge.create("5").addCss(dui_bg_d_2, dui_rounded_full)))
                                                            .addCss(dui_h_8, dui_teal)
                                                            .setTitle("Europe")
                                                    );
                                                }, Arrays.asList(SelectOption.create("FRA", "FRA", "France"),
                                                        SelectOption.create("GER", "GER", "Germany"),
                                                        SelectOption.create("SPA", "SPA", "Spain"),
                                                        SelectOption.create("ITA", "ITA", "Italy"),
                                                        SelectOption.create("UK", "UK", "United Kingdom")
                                                )

                                        )
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Item selected [ " + newValue + " ]").show();
                                        })
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Custom select"))
                                .appendChild(Select.<MdiIcon>create("Icon picker")
                                        .appendItems(IconOption::create, Icons.access_point(),
                                                IconsMeta.access_point_check(),
                                                IconsMeta.access_point_minus(),
                                                IconsMeta.access_point_network(),
                                                IconsMeta.access_point_network_off(),
                                                IconsMeta.access_point_off(),
                                                IconsMeta.access_point_plus(),
                                                IconsMeta.access_point_remove(),
                                                IconsMeta.antenna()
                                        )
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Item selected [ " + newValue.getName() + " ]").appendChild(newValue).show();
                                        })
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Multi select"))
                                .appendChild(MultiSelect.<String>create("Country")
                                        .appendChild(SelectOption.create("USA", "USA", "America (USA)"))
                                        .appendChild(SelectOption.create("ARG", "ARG", "Argentina"))
                                        .appendChild(SelectOption.create("BRA", "BRA", "Brazil"))
                                        .appendChild(SelectOption.create("DEN", "DEN", "Denmark"))
                                        .appendChild(SelectOption.create("CRO", "CRO", "Croatia"))
                                        .appendChild(SelectOption.create("IND", "IND", "India"))
                                        .appendChild(SelectOption.create("SPA", "SPA", "Spain"))
                                        .appendChild(SelectOption.create("FRA", "FRA", "France"))
                                        .appendChild(SelectOption.create("JOR", "JOR", "Jordan"))
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Item selected [ " + newValue + " ]").show();
                                        })
                                )
                        )
                        .appendChild(Column.span6()
                                .appendChild(BlockHeader.create("Multi select"))
                                .appendChild(MultiSelect.<MdiIcon>create("Icon picker")
                                        .appendItems(IconOption::create, Icons.access_point(),
                                                IconsMeta.access_point_check(),
                                                IconsMeta.access_point_minus(),
                                                IconsMeta.access_point_network(),
                                                IconsMeta.access_point_network_off(),
                                                IconsMeta.access_point_off(),
                                                IconsMeta.access_point_plus(),
                                                IconsMeta.access_point_remove(),
                                                IconsMeta.antenna()
                                        )
                                        .selectAt(0)
                                        .addChangeListener((oldValue, newValue) -> {
                                            Notification.create("Icons selected : ")
                                                    .apply(self -> newValue.forEach(self::appendChild))
                                    .show();
                                        })
                                )
                        )
                )
        );
    }

    @SampleMethod
    private void initCheckboxExample() {
        element.appendChild(Card.create("CHECKBOX")
                .setCollapsible(true)
                .appendChild(h(5).textContent("Basic Examples"))
                .appendChild(Row.create()
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Default")))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Filled In").filledIn()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Default - Disabled").check().disable()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Filled In - Disabled").check().filledIn().disable())))
                .appendChild(Row.create()
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Default").setReadOnly(true)))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Filled In").filledIn().setReadOnly(true)))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Default - Disabled").check().disable()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("Filled In - Disabled").check().filledIn().disable())))

                .appendChild(h(5).textContent("With Material Design Colors"))
                .appendChild(Row.create()
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("ACCENT").check()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("RED").addCss(dui_accent_red).check()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("AMBER").addCss(dui_accent_amber).check()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("DEEP PURPLE").addCss(dui_accent_deep_purple).check()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("INDIGO").addCss(dui_accent_indigo).check()))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("BLUE").addCss(dui_accent_blue).check()))
                )
                .appendChild(h(5).textContent("With Material Design Colors - Filled In"))
                .appendChild(Row.create()
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("ACCENT")
                                        .check()
                                        .setFilled(true)
                                ))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("RED").addCss(dui_accent_red)
                                        .check()
                                        .setFilled(true)
                                ))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("AMBER").addCss(dui_accent_amber)
                                        .check()
                                        .setFilled(true)
                                ))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("DEEP PURPLE").addCss(dui_accent_deep_purple)
                                        .check()
                                        .setFilled(true)
                                ))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("INDIGO").addCss(dui_accent_indigo)
                                        .check()
                                        .setFilled(true)
                                ))
                        .appendChild(Column.colspan(_2, _6)
                                .appendChild(CheckBox.create("BLUE").addCss(dui_accent_blue)
                                        .check()
                                        .setFilled(true)
                                ))
                )
        );
    }

    @SampleMethod
    private void initRadioExample() {
        element.appendChild(Card.create("RADIO")
                .setCollapsible(true)
                .appendChild(h(5).textContent("Basic Examples"))
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Horizontal group"))
                                .appendChild(RadioGroup.<String>create("test").setReadOnly(true)
                                        .appendChild(Radio.create("radio1", "Radio - 1").check())
                                        .appendChild(Radio.create("radio2", "Radio - 2"))
                                        .appendChild(Radio.create("radio2", "Radio - 3"))
                                        .horizontal())
                        )
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Horizontal group", "With gap"))
                                .appendChild(RadioGroup.<String>create("test")
                                        .appendChild(Radio.create("radio1_gap", "Radio 1 - With Gap").setReadOnly(true))
                                        .appendChild(Radio.create("radio2_gap", "Radio 2 - With Gap"))
                                        .appendChild(Radio.create("radio2_gap", "Radio 2 - With Gap"))
                                        .horizontal())
                        )
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Horizontal group", "Disabled"))
                                .appendChild(RadioGroup.<String>create("test").disable()
                                        .appendChild(Radio.create("radio1_disabled", "Radio 1 - Disabled").disable().check())
                                        .appendChild(Radio.create("radio2_disabled", "Radio 2 - Disabled").disable())
                                        .appendChild(Radio.create("radio3_disabled", "Radio 3 - Disabled").disable())
                                        .horizontal())
                        )
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Horizontal group", "Disabled"))
                                .appendChild(RadioGroup.<String>create("test")
                                        .appendChild(Radio.create("radio1_disabled", "Radio 1").check())
                                        .appendChild(Radio.create("radio2_disabled", "Radio 2"))
                                        .appendChild(Radio.create("radio3_disabled", "Radio 3 - Disabled").disable())
                                        .horizontal())
                        )
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("Horizontal group", "Disabled"))
                                .appendChild(RadioGroup.<String>create("test")
                                        .appendChild(Radio.create("radio1_disabled", "Radio 1 - Disabled").disable().check())
                                        .appendChild(Radio.create("radio2_disabled", "Radio 2"))
                                        .appendChild(Radio.create("radio3_disabled", "Radio 3"))
                                        .horizontal())
                        )
                )
                .appendChild(br())
                .appendChild(BlockHeader.create("With Material Design Colors"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(RadioGroup.<String>create("RED")
                                        .addCss(dui_accent_red)
                                        .appendChild(Radio.create("Radio 1", "Radio 1"))
                                        .appendChild(Radio.create("Radio 2", "Radio 2"))
                                        .appendChild(Radio.create("Radio 3", "Radio 3"))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(RadioGroup.<String>create("AMBER")
                                        .addCss(dui_accent_amber)
                                        .appendChild(Radio.create("Radio 1", "Radio 1"))
                                        .appendChild(Radio.create("Radio 2", "Radio 2"))
                                        .appendChild(Radio.create("Radio 3", "Radio 3"))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(RadioGroup.<String>create("ACCENT")
                                        .appendChild(Radio.create("Radio 1", "Radio 1"))
                                        .appendChild(Radio.create("Radio 2", "Radio 2"))
                                        .appendChild(Radio.create("Radio 3", "Radio 3"))
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(RadioGroup.<String>create("TEAL")
                                        .addCss(dui_accent_teal)
                                        .appendChild(Radio.create("Radio 1", "Radio 1"))
                                        .appendChild(Radio.create("Radio 2", "Radio 2"))
                                        .appendChild(Radio.create("Radio 3", "Radio 3"))
                                )
                        )
                )
        );
    }

    @SampleMethod
    private void initSwitchExample() {
        element.appendChild(Card.create("SWITCH BUTTONS")
                .setCollapsible(true)
                .appendChild(h(5).textContent("Basic Examples").style("margin-bottom: 25px;"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON"))
                        )
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON")
                                        .disable())
                        )
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON")
                                        .check()
                                        .disable())
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON")
                                        .setReadOnly(true)
                                )
                        )
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON")
                                        .disable())
                        )
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create("Active", "off", "on")
                                        .addChangeListener((oldValue, value) -> Notification.create("test " + value).addCss(dui_info)
                                                .show()
                                        )
                                        .setOffTitle("OFF").setOnTitle("ON")
                                        .check()
                                        .disable())
                        )
                )
                .appendChild(h(5).textContent("With Material Design Colors"))
                .appendChild(Row.create()
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create().setOffTitle("ACCENT").check()))
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create().setOffTitle("RED").addCss(dui_accent_red).check()))
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create().setOffTitle("AMBER").addCss(dui_accent_amber).check()))
                        .appendChild(Column.span3()
                                .appendChild(SwitchButton.create().setOffTitle("INDIGO").addCss(dui_accent_teal).check()))
                )
        );
    }

    public static class IconOption extends SelectOption<MdiIcon> {
        public IconOption(MdiIcon mdiIcon) {
            super(mdiIcon.getName(), mdiIcon,
                    (key, value) -> elements.div()
                            .appendChild(LabeledIcon.create(mdiIcon.copy(), mdiIcon.getName())
                                    .addCss(dui_rounded_full, dui_accent, dui_p_x_1))
                    ,
                    (key, icon) -> CustomMenuItem.<MdiIcon>create()
                            .setSearchFilter((token, caseSensitive) -> icon.getMetaInfo()
                                    .getAliases()
                                    .stream()
                                    .anyMatch(alias -> compare(alias, token, caseSensitive)) ||
                                    compare(icon.getMetaInfo().getName(), token, caseSensitive) ||
                                    icon.getMetaInfo().getTags()
                                            .stream().anyMatch(iconTag -> compare(iconTag, token, caseSensitive))
                            )
                            .appendChild(elements.div()
                                    .addCss(dui_flex, dui_gap_1, dui_items_center)
                                    .appendChild(mdiIcon)
                                    .appendChild(elements.span()
                                            .addCss(dui_grow_1)
                                            .textContent(mdiIcon.getName()))
                                    .appendChild(Badge.create("version :" + mdiIcon.getMetaInfo().getVersion())
                                            .addCss(dui_rounded_full))
                            )
            );
        }

        private static boolean compare(String left, String right, boolean caseSensitive) {
            if (caseSensitive) {
                return left.contains(right);
            } else {
                return left.toLowerCase().contains(right.toLowerCase());
            }
        }

        public static IconOption create(MdiIcon icon) {
            return new IconOption(icon);
        }
    }


}