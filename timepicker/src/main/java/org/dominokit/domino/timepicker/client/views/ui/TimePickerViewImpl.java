package org.dominokit.domino.timepicker.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.timepicker.client.presenters.TimePickerProxy;
import org.dominokit.domino.timepicker.client.views.TimePickerView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.TimeBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.timepicker.TimePicker;
import org.dominokit.domino.ui.timepicker.TimeStyle;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_es;

import java.util.Date;


@UiView(presentable = TimePickerProxy.class)
@SampleClass
public class TimePickerViewImpl extends BaseDemoView<HTMLDivElement> implements TimePickerView {

    private DivElement element = div();


    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.createLink("timepicker", this.getClass()));
        element.appendChild(BlockHeader.create("TIME PICKERS"));

        inlineTimePicker();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.inlineTimePicker()));

        withHeader();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withHeader()));

        withFooter();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withFooter()));

        dropdownTimePicker();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.dropdownTimePicker()));

        timeBox();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.timeBox()));

        return element.element();
    }

    @SampleMethod
    private void inlineTimePicker(){
        element
                .appendChild(Card.create("INLINE TIMEPICKER")
                        .setCollapsible(true)
                        .appendChild(BlockHeader.create("Different locales"))
                        .appendChild(Row.create()
                                .span4(TimePicker.create())
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar()))
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_es()))
                        )
                        .appendChild(BlockHeader.create("With seconds"))
                        .appendChild(Row.create()
                                .span4(TimePicker.create()
                                        .setShowSeconds(true)
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                        .setShowSeconds(true)
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                        .setShowSeconds(true)
                                )
                        )
                        .appendChild(BlockHeader.create("24 hours style"))
                        .appendChild(Row.create()
                                .span4(TimePicker.create()
                                        .setTimeStyle(TimeStyle._24)
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                        .setTimeStyle(TimeStyle._24)
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                        .setTimeStyle(TimeStyle._24)
                                )
                        )
                );
    }

    @SampleMethod
    private void withHeader(){
        element
                .appendChild(Card.create("INLINE TIMEPICKER", "With header")
                        .setCollapsible(true)
                        .appendChild(BlockHeader.create("Different locales"))
                        .appendChild(Row.create()
                                .span4(TimePicker.create()
                                        .withHeader()
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                        .withHeader()
                                        .addCss(dui_accent_blue)
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                        .withHeader()
                                        .addCss(dui_accent_teal)
                                )
                        )
                        .appendChild(BlockHeader.create("With seconds"))
                        .appendChild(Row.create()
                                .span4(TimePicker.create()
                                        .setShowSeconds(true)
                                        .withHeader()
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                        .setShowSeconds(true)
                                        .withHeader()
                                        .addCss(dui_accent_blue)
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                        .setShowSeconds(true)
                                        .withHeader()
                                        .addCss(dui_accent_teal)
                                )
                        )
                        .appendChild(BlockHeader.create("24 hours style"))
                        .appendChild(Row.create()
                                .span4(TimePicker.create()
                                        .setTimeStyle(TimeStyle._24)
                                        .withHeader()
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                        .setTimeStyle(TimeStyle._24)
                                        .withHeader()
                                        .addCss(dui_accent_blue)
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                        .setTimeStyle(TimeStyle._24)
                                        .withHeader()
                                        .addCss(dui_accent_teal)
                                )
                        )
                );
    }
    @SampleMethod
    private void withFooter(){
        element
                .appendChild(Card.create("INLINE TIMEPICKER", "With footer")
                        .setCollapsible(true)
                        .appendChild(BlockHeader.create("Different locales"))
                        .appendChild(Row.create()
                                .span4(TimePicker.create()
                                        .withHeader()
                                        .withFooter((timePicker, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                        .addClickListener(evt -> timePicker.setDate(new Date()))
                                                )
                                        )
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                        .withHeader()
                                        .addCss(dui_accent_blue)
                                        .withFooter((timePicker, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                        .addClickListener(evt -> timePicker.setDate(new Date()))
                                                )
                                        )
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                        .withHeader()
                                        .addCss(dui_accent_teal)
                                        .withFooter((timePicker, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                        .addClickListener(evt -> timePicker.setDate(new Date()))
                                                )
                                        )
                                )
                        )
                        .appendChild(BlockHeader.create("With seconds"))
                        .appendChild(Row.create()
                                .span4(TimePicker.create()
                                        .setShowSeconds(true)
                                        .withHeader()
                                        .withFooter((timePicker, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                        .addClickListener(evt -> timePicker.setDate(new Date()))
                                                )
                                        )
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                        .setShowSeconds(true)
                                        .withHeader()
                                        .addCss(dui_accent_blue)
                                        .withFooter((timePicker, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                        .addClickListener(evt -> timePicker.setDate(new Date()))
                                                )
                                        )
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                        .setShowSeconds(true)
                                        .withHeader()
                                        .addCss(dui_accent_teal)
                                        .withFooter((timePicker, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                        .addClickListener(evt -> timePicker.setDate(new Date()))
                                                )
                                        )
                                )
                        )
                        .appendChild(BlockHeader.create("24 hours style"))
                        .appendChild(Row.create()
                                .span4(TimePicker.create()
                                        .setTimeStyle(TimeStyle._24)
                                        .withHeader()
                                        .withFooter((timePicker, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                        .addClickListener(evt -> timePicker.setDate(new Date()))
                                                )
                                        )
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_ar())
                                        .setTimeStyle(TimeStyle._24)
                                        .withHeader()
                                        .addCss(dui_accent_blue)
                                        .withFooter((timePicker, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                        .addClickListener(evt -> timePicker.setDate(new Date()))
                                                )
                                        )
                                )
                                .span4(TimePicker.create(new DateTimeFormatInfoImpl_es())
                                        .setTimeStyle(TimeStyle._24)
                                        .withHeader()
                                        .addCss(dui_accent_teal)
                                        .withFooter((timePicker, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.clock_outline(), "NOW")
                                                        .addClickListener(evt -> timePicker.setDate(new Date()))
                                                )
                                        )
                                )
                        )
                );
    }

    @SampleMethod
    private void dropdownTimePicker() {
        element
                .appendChild(Card.create("DROP DOWN")
                        .setCollapsible(true)
                        .appendChild(Row.create()
                                .span2(Button.create(Icons.calendar(), "Pick time")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setPosition(DropDirection.BEST_MIDDLE_UP_DOWN)
                                                    .appendChild(TimePicker.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                                .span2(Button.create(Icons.calendar(), "Pick time")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setPosition(DropDirection.BEST_SIDE_UP_DOWN)
                                                    .appendChild(TimePicker.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                                .span2(Button.create(Icons.calendar(), "Pick time")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setPosition(DropDirection.BEST_MIDDLE_SIDE)
                                                    .appendChild(TimePicker.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                                .span2(Button.create(Icons.calendar(), "Pick time")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setPosition(DropDirection.MIDDLE_SCREEN)
                                                    .appendChild(TimePicker.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                                .span2(Button.create(Icons.calendar(), "Pick time")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setModal(true)
                                                    .setPosition(DropDirection.MIDDLE_SCREEN)
                                                    .appendChild(TimePicker.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                                .span2(Button.create(Icons.calendar(), "Pick time")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setPosition(DropDirection.BEST_FIT_SIDE)
                                                    .appendChild(TimePicker.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                        )
                );
    }

    @SampleMethod
    private void timeBox() {
        element
                .appendChild(Card.create("TIME BOX")
                        .setCollapsible(true)
                        .appendChild(Row.create()
                                .span4(TimeBox.create("Default"))
                                .span4(TimeBox.create("With pattern", new DateTimeFormatInfoImpl_ar())
                                        .setPattern("HH:mm:ss")
                                        .withPopover((parent, popover) -> popover.addCss(dui_accent_blue))
                                        .withTimePicker((parent, timePicker) -> timePicker
                                                .withHeader())
                                )
                                .span4(TimeBox.create("With parse strict", new DateTimeFormatInfoImpl_es())
                                        .setPattern("HH-mm-ss")
                                        .setParseStrict(true)
                                        .withPopover((parent, popover) -> popover.addCss(dui_accent_teal))
                                        .withTimePicker((parent, timePicker) -> timePicker
                                                .withHeader())
                                )
                        )
                );
    }
}
