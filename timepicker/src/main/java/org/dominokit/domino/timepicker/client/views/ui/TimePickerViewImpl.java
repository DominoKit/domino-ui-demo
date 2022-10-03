package org.dominokit.domino.timepicker.client.views.ui;

import elemental2.dom.DomGlobal;
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
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.timepicker.ClockStyle;
import org.dominokit.domino.ui.timepicker.InputTimeBox;
import org.dominokit.domino.ui.timepicker.TimeBox;
import org.dominokit.domino.ui.timepicker.TimePicker;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_de;

import java.util.Date;

import static org.jboss.elemento.Elements.div;

@UiView(presentable = TimePickerProxy.class)
@SampleClass
public class TimePickerViewImpl extends BaseDemoView<HTMLDivElement> implements TimePickerView {

    private HTMLDivElement element = div().element();

    private Column column = Column.span4()
            .centerContent()
            .style()
            .addCss(Styles.padding_0).get();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.create("timepicker", this.getClass()).element());
        element.appendChild(BlockHeader.create("TIME PICKERS").element());

        inline();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.inline()).element());

        popups();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.popups()).element());

        timeBox();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.timeBox()).element());

        inputTimeBox();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.inputTimeBox()).element());
        return element;
    }

    @SampleMethod
    private void inputTimeBox() {
        Column column = Column.span6()
                .style()
                .removeCss(Styles.padding_0).get();

        InputTimeBox timeBox1 = InputTimeBox.create()
                .setLabel("Clock 12");

        InputTimeBox timeBox2 = InputTimeBox.create()
                .setLabel("Clock 24")
                .setClockStyle(ClockStyle._24);

        element.appendChild(Card.create("INPUT TIME BOX")
                .appendChild(Row.create()
                        .addColumn(column.copy().appendChild(timeBox1))
                        .addColumn(column.copy().appendChild(timeBox2))
                )
                .element());
    }

    @SampleMethod
    private void inline() {
        element.appendChild(Card.create("INLINED")
                .appendChild(Row.create()
                        .addColumn(column.copy().appendChild(TimePicker.create()
                                .fixedWidth("270px")
                                .showBorder()
                                .hideClearButton()
                                .hideCloseButton()
                                .addTimeSelectionHandler((time, dateTimeFormatInfo, timePicker) ->
                                        DomGlobal.console.info(timePicker.getFormattedTime())
                                )))
                        .addColumn(column.copy().appendChild(TimePicker.create(new DateTimeFormatInfoImpl_de())
                                .fixedWidth("270px")
                                .setColorScheme(ColorScheme.PINK)
                                .showBorder()
                                .hideClearButton()
                                .setShowSwitchers(true)
                                .hideCloseButton()
                                .addTimeSelectionHandler((time, dateTimeFormatInfo, timePicker) ->
                                        DomGlobal.console.info(timePicker.getFormattedTime()))
                                .todayButtonText("nu")))
                        .addColumn(column.copy().appendChild(TimePicker.create()
                                .fixedWidth("270px")
                                .setColorScheme(ColorScheme.GREEN)
                                .setClockStyle(ClockStyle._24)
                                .showBorder()
                                .hideClearButton()
                                .hideCloseButton()
                                .addTimeSelectionHandler((time, dateTimeFormatInfo, timePicker) ->
                                        DomGlobal.console.info(timePicker.getFormattedTime())))))
                .element());


    }

    @SampleMethod
    private void popups() {
        Button bluePopupButton = Button.create(Icons.ALL.calendar_mdi()).setBackground(ColorScheme.BLUE.color());
        TimePicker bluePopTimePicker = TimePicker.create()
                .showBorder()
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        Popover bluePopover = Popover.create(bluePopupButton, "Wakeup", bluePopTimePicker);

        bluePopTimePicker.addCloseHandler(() -> bluePopover.close());
        bluePopTimePicker.addClearHandler(() ->
                Notification.create("a Click on clear button")
                        .setPosition(Notification.TOP_LEFT)
                        .setBackground(ColorScheme.BLUE.color())
                        .show());


        Button pinkPopupButton = Button.create(Icons.ALL.calendar_mdi()).setBackground(ColorScheme.PINK.color());
        TimePicker pinkPopDatePicker = TimePicker.create(new DateTimeFormatInfoImpl_de())
                .setColorScheme(ColorScheme.PINK)
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        Popover pinkPopover = Popover.createPicker(pinkPopupButton, pinkPopDatePicker);

        pinkPopDatePicker.addCloseHandler(pinkPopover::close);
        pinkPopDatePicker.addClearHandler(() ->
                Notification.create("a Click on clear button")
                        .setPosition(Notification.TOP_CENTER)
                        .setBackground(ColorScheme.PINK.color())
                        .show());


        Button greenPopupButton = Button.create(Icons.ALL.calendar_mdi()).setBackground(ColorScheme.GREEN.color());
        TimePicker greenPopDatePicker = TimePicker.create()
                .setColorScheme(ColorScheme.GREEN)
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        Popover greenPopover = Popover.createPicker(greenPopupButton, greenPopDatePicker);

        greenPopDatePicker.addCloseHandler(greenPopover::close);
        greenPopDatePicker.addClearHandler(() ->
                Notification.create("a Click on clear button")
                        .setPosition(Notification.TOP_RIGHT)
                        .setBackground(ColorScheme.GREEN.color())
                        .show());


        Button blueModalButton = Button.create(Icons.ALL.calendar_mdi()).setBackground(ColorScheme.BLUE.color());
        TimePicker blueDatePicker = TimePicker.create()
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));

        ModalDialog blueModal = blueDatePicker.createModal("Wakeup");
        blueDatePicker.addCloseHandler(blueModal::close);
        blueDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_LEFT)
                .setBackground(ColorScheme.BLUE.color())
                .show());


        blueModal.appendChild(blueDatePicker.element());
        DomGlobal.document.body.appendChild(blueModal.element());

        blueModalButton.addClickListener(evt -> blueModal.open());


        Button pinkModalButton = Button.create(Icons.ALL.calendar_mdi()).setBackground(ColorScheme.PINK.color());
        TimePicker pinkDatePicker = TimePicker.create()
                .setColorScheme(ColorScheme.PINK)
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        ModalDialog pinkModal = pinkDatePicker.createModal("Wakeup");

        pinkDatePicker.addCloseHandler(pinkModal::close);
        pinkDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_CENTER)
                .setBackground(ColorScheme.PINK.color())
                .show());

        pinkModal.appendChild(pinkDatePicker);
        DomGlobal.document.body.appendChild(pinkModal.element());

        pinkModalButton.addClickListener(evt -> pinkModal.open());


        Button greenModalButton = Button.create(Icons.ALL.calendar_mdi()).setBackground(ColorScheme.GREEN.color());
        TimePicker greenDatePicker = TimePicker.create()
                .setColorScheme(ColorScheme.GREEN)
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        ModalDialog greenModal = greenDatePicker.createModal("Wakeup");
        greenDatePicker.addCloseHandler(greenModal::close);
        greenDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_RIGHT)
                .setBackground(ColorScheme.GREEN.color())
                .show());

        greenModal.appendChild(greenDatePicker);
        DomGlobal.document.body.appendChild(greenModal.element());

        greenModalButton.addClickListener(evt -> greenModal.open());


        element.appendChild(Card.create("POPUP")
                .appendChild(BlockHeader.create("POP OVER"))
                .appendChild(Row.create()
                        .addColumn(column.copy().appendChild(bluePopupButton))
                        .addColumn(column.copy().appendChild(pinkPopupButton))
                        .addColumn(column.copy().appendChild(greenPopupButton))
                )
                .appendChild(BlockHeader.create("MODAL"))
                .appendChild(Row.create()
                        .addColumn(column.copy().appendChild(blueModalButton))
                        .addColumn(column.copy().appendChild(pinkModalButton))
                        .addColumn(column.copy().appendChild(greenModalButton))
                )
                .element());


    }

    @SampleMethod
    private void timeBox() {

        Column column = this.column.copy()
                .style()
                .removeCss(Styles.padding_0).get();

        TimeBox timeBox1 = TimeBox.create()
                .setLabel("Wakeup");

        TimeBox timeBox2 = TimeBox.create("Wakeup", new Date(), new DateTimeFormatInfoImpl_de());

        timeBox2.getTimePicker().setColorScheme(ColorScheme.PINK);


        TimeBox timeBox3 = TimeBox.create()
                .setPopoverPosition(PopupPosition.TOP)
                .setPickerStyle(TimeBox.PickerStyle.POPOVER)
                .setPlaceholder("Wakeup");

        timeBox3.getTimePicker().setColorScheme(ColorScheme.GREEN);


        element.appendChild(Card.create("TIME BOX")
                .appendChild(Row.create()
                        .addColumn(column.copy().appendChild(timeBox1))
                        .addColumn(column.copy().appendChild(timeBox2))
                        .addColumn(column.copy().appendChild(timeBox3))
                )
                .element());
    }
}
