package org.dominokit.domino.datepicker.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.datepicker.client.presenters.DatePickerProxy;
import org.dominokit.domino.datepicker.client.views.DatePickerView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datepicker.Calendar;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.DateBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.menu.direction.DropDirection;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_ar;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_es;

import java.util.Date;

@UiView(presentable = DatePickerProxy.class)
@SampleClass
public class DatePickerViewImpl extends BaseDemoView<HTMLDivElement> implements DatePickerView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("datepicker", this.getClass()));
        element.appendChild(BlockHeader.create("DATE PICKERS"));

        inlineCalendar();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.inlineCalendar()));

        withHeader();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withHeader()));

        withFooter();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.withFooter()));

        dropdownCalendar();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.dropdownCalendar()));

        dateBox();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.dateBox()));

        return element.element();
    }

    @SampleMethod
    private void inlineCalendar() {
        element
                .appendChild(Card.create("INLINE CALENDAR", "Different locales")
                        .setCollapsible(true)
                        .appendChild(Row.create()
                                .span4(Calendar.create())
                                .span4(Calendar.create(new DateTimeFormatInfoImpl_ar()))
                                .span4(Calendar.create(new DateTimeFormatInfoImpl_es()))
                        )
                );
    }

    @SampleMethod
    private void withHeader() {
        element
                .appendChild(Card.create("INLINE CALENDAR", "With header")
                        .setCollapsible(true)
                        .appendChild(Row.create()
                                .span4(Calendar.create()
                                        .withHeader()
                                )
                                .span4(Calendar.create(new DateTimeFormatInfoImpl_ar())
                                        .addCss(dui_accent_blue)
                                        .withHeader()
                                )
                                .span4(Calendar.create(new DateTimeFormatInfoImpl_es())
                                        .addCss(dui_accent_teal)
                                        .withHeader()
                                )
                        )
                );
    }

    @SampleMethod
    private void withFooter() {
        element
                .appendChild(Card.create("INLINE CALENDAR", "With footer")
                        .setCollapsible(true)
                        .appendChild(Row.create()
                                .span4(Calendar.create()
                                        .withHeader()
                                        .withFooter((calendar, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.calendar_today(), "TODAY")
                                                        .addClickListener(evt -> calendar.setDate(new Date()))
                                                )
                                        )
                                )
                                .span4(Calendar.create(new DateTimeFormatInfoImpl_ar())
                                        .addCss(dui_accent_blue)
                                        .withHeader()
                                        .withFooter((calendar, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.calendar_today(), "TODAY")
                                                        .addClickListener(evt -> calendar.setDate(new Date()))
                                                )
                                        )
                                )
                                .span4(Calendar.create(new DateTimeFormatInfoImpl_es())
                                        .addCss(dui_accent_teal)
                                        .withHeader()
                                        .withFooter((calendar, footer) -> footer
                                                .addCss(dui_flex, dui_justify_center)
                                                .appendChild(Button.create(Icons.calendar_today(), "TODAY")
                                                        .addClickListener(evt -> calendar.setDate(new Date()))
                                                )
                                        )
                                )
                        )
                );
    }

    @SampleMethod
    private void dropdownCalendar() {
        element
                .appendChild(Card.create("DROP DOWN")
                        .setCollapsible(true)
                        .appendChild(Row.create()
                                .span2(Button.create(Icons.calendar(), "Pick date")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setPosition(DropDirection.BEST_MIDDLE_UP_DOWN)
                                                    .appendChild(Calendar.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                                .span2(Button.create(Icons.calendar(), "Pick date")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setPosition(DropDirection.BEST_SIDE_UP_DOWN)
                                                    .appendChild(Calendar.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                                .span2(Button.create(Icons.calendar(), "Pick date")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setPosition(DropDirection.BEST_MIDDLE_SIDE)
                                                    .appendChild(Calendar.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                                .span2(Button.create(Icons.calendar(), "Pick date")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setPosition(DropDirection.MIDDLE_SCREEN)
                                                    .appendChild(Calendar.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                                .span2(Button.create(Icons.calendar(), "Pick date")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setModal(true)
                                                    .setPosition(DropDirection.MIDDLE_SCREEN)
                                                    .appendChild(Calendar.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                                .span2(Button.create(Icons.calendar(), "Pick date")
                                        .apply(button -> {
                                            Popover.create(button)
                                                    .setPosition(DropDirection.BEST_FIT_SIDE)
                                                    .appendChild(Calendar.create()
                                                            .withHeader()
                                                    );
                                        })
                                )
                        )
                );
    }

    @SampleMethod
    private void dateBox() {
        ;
        element
                .appendChild(Card.create("DATE BOX")
                        .setCollapsible(true)
                        .appendChild(Row.create()
                                .span4(DateBox.create("myDateBox")
                                        .setReadOnly(true)
                                        .setPattern("dd.MM.yyyy")
                                        .setParseStrict(true)
                                        .withPopover((parent, popover) -> popover.addCss(dui_accent_blue)))
                                .span4(DateBox.create("With pattern", new DateTimeFormatInfoImpl_ar())
                                        .setPattern("dd-MM-yyyy")
                                        .withPopover((parent, popover) -> popover.addCss(dui_accent_blue))
                                        .withCalendar((parent, calendar) -> calendar
                                                .withHeader())
                                )
                                .span4(DateBox.create("With parse strict", new DateTimeFormatInfoImpl_es())
                                        .setPattern("dd-MM-yyyy")
                                        .setParseStrict(true)
                                        .withPopover((parent, popover) -> popover.addCss(dui_accent_teal))
                                        .withCalendar((parent, calendar) -> calendar
                                                .withHeader())
                                )
                        )
                );
    }
}