package org.dominokit.domino.timepicker.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.timepicker.client.presenters.TimePickerPresenter;
import org.dominokit.domino.timepicker.client.views.CodeResource;
import org.dominokit.domino.timepicker.client.views.TimePickerView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.IconButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.timepicker.ClockStyle;
import org.dominokit.domino.ui.timepicker.Time;
import org.dominokit.domino.ui.timepicker.TimeBox;
import org.dominokit.domino.ui.timepicker.TimePicker;
import org.gwtproject.i18n.client.impl.cldr.DateTimeFormatInfoImpl_de;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = TimePickerPresenter.class)
public class TimePickerViewImpl extends ComponentView<HTMLDivElement> implements TimePickerView {

    private HTMLDivElement element = div().asElement();

    private Column column = Column.create()
            .onLarge(Column.OnLarge.four)
            .onMedium(Column.OnMedium.four)
            .onSmall(Column.OnSmall.twelve)
            .onXSmall(Column.OnXSmall.twelve)
            .addCssClass(Styles.padding_0)
            .centerContent();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("TIME PICKERS").asElement());

        inlined();
        popups();
        timeBox();
    }

    private void inlined() {
        element.appendChild(Card.create("INLINED")
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(TimePicker.create()
                                .fixedWidth("270px")
                                .showBorder()
                                .hideClearButton()
                                .hideCloseButton()
                                .addTimeSelectionHandler((time, dateTimeFormatInfo, timePicker) ->
                                        DomGlobal.console.info(timePicker.getFormattedTime())
                                )
                                .asElement()))
                        .addColumn(column.copy().addElement(TimePicker.create(new DateTimeFormatInfoImpl_de())
                                .fixedWidth("270px")
                                .setColorScheme(ColorScheme.PINK)
                                .showBorder()
                                .hideClearButton()
                                .setShowSwitchers(true)
                                .hideCloseButton()
                                .addTimeSelectionHandler((time, dateTimeFormatInfo, timePicker) ->
                                        DomGlobal.console.info(timePicker.getFormattedTime()))
                                .todayButtonText("nu".toUpperCase())
                                .asElement()))
                        .addColumn(column.copy().addElement(TimePicker.create()
                                .fixedWidth("270px")
                                .setColorScheme(ColorScheme.GREEN)
                                .setClockStyle(ClockStyle._24)
                                .showBorder()
                                .hideClearButton()
                                .hideCloseButton()
                                .addTimeSelectionHandler((time, dateTimeFormatInfo, timePicker) ->
                                        DomGlobal.console.info(timePicker.getFormattedTime()))
                                .asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.inlined()).asElement());
    }

    private void popups() {
        Button bluePopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());
        TimePicker bluePopTimePicker = TimePicker.create()
                .showBorder()
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        Popover bluePopover = Popover.create(bluePopupButton.asElement(), "Wakeup", bluePopTimePicker
                .asElement());

        bluePopTimePicker.addCloseHandler(() -> bluePopover.close());
        bluePopTimePicker.addClearHandler(() ->
                Notification.create("a Click on clear button")
                        .setPosition(Notification.TOP_LEFT)
                        .setBackground(ColorScheme.BLUE.color())
                        .show());


        Button pinkPopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.PINK.color());
        TimePicker pinkPopDatePicker = TimePicker.create(new DateTimeFormatInfoImpl_de())
                .setColorScheme(ColorScheme.PINK)
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        Popover pinkPopover = Popover.createPicker(pinkPopupButton.asElement(),  pinkPopDatePicker
                .asElement());

        pinkPopDatePicker.addCloseHandler(() -> pinkPopover.close());
        pinkPopDatePicker.addClearHandler(() ->
                Notification.create("a Click on clear button")
                        .setPosition(Notification.TOP_CENTER)
                        .setBackground(ColorScheme.PINK.color())
                        .show());


        Button greenPopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());
        TimePicker greenPopDatePicker = TimePicker.create()
                .setColorScheme(ColorScheme.GREEN)
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        Popover greenPopover = Popover.createPicker(greenPopupButton.asElement(), greenPopDatePicker
                .asElement());

        greenPopDatePicker.addCloseHandler(() -> greenPopover.close());
        greenPopDatePicker.addClearHandler(() ->
                Notification.create("a Click on clear button")
                        .setPosition(Notification.TOP_RIGHT)
                        .setBackground(ColorScheme.GREEN.color())
                        .show());


        Button blueModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());
        TimePicker blueDatePicker = TimePicker.create()
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));

        ModalDialog blueModal = blueDatePicker.createModal("Wakeup");
        blueDatePicker.addCloseHandler(() -> blueModal.close());
        blueDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_LEFT)
                .setBackground(ColorScheme.BLUE.color())
                .show());


        blueModal.appendContent(blueDatePicker.asElement());
        DomGlobal.document.body.appendChild(blueModal.asElement());

        blueModalButton.addClickListener(evt -> blueModal.open());


        Button pinkModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.PINK.color());
        TimePicker pinkDatePicker = TimePicker.create()
                .setColorScheme(ColorScheme.PINK)
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        ModalDialog pinkModal = pinkDatePicker.createModal("Wakeup");

        pinkDatePicker.addCloseHandler(() -> pinkModal.close());
        pinkDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_CENTER)
                .setBackground(ColorScheme.PINK.color())
                .show());

        pinkModal.appendContent(pinkDatePicker.asElement());
        DomGlobal.document.body.appendChild(pinkModal.asElement());

        pinkModalButton.addClickListener(evt -> pinkModal.open());


        Button greenModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());
        TimePicker greenDatePicker = TimePicker.create()
                .setColorScheme(ColorScheme.GREEN)
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        ModalDialog greenModal = greenDatePicker.createModal("Wakeup");
        greenDatePicker.addCloseHandler(() -> greenModal.close());
        greenDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_RIGHT)
                .setBackground(ColorScheme.GREEN.color())
                .show());

        greenModal.appendContent(greenDatePicker.asElement());
        DomGlobal.document.body.appendChild(greenModal.asElement());

        greenModalButton.addClickListener(evt -> greenModal.open());


        element.appendChild(Card.create("POPUP")
                .appendContent(BlockHeader.create("POP OVER").asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(bluePopupButton.asElement()))
                        .addColumn(column.copy().addElement(pinkPopupButton.asElement()))
                        .addColumn(column.copy().addElement(greenPopupButton.asElement()))
                        .asElement())
                .appendContent(BlockHeader.create("MODAL").asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(blueModalButton.asElement()))
                        .addColumn(column.copy().addElement(pinkModalButton.asElement()))
                        .addColumn(column.copy().addElement(greenModalButton.asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.popups()).asElement());
    }

    private void timeBox() {

        Column column = this.column.copy()
                .removeCssClass(Styles.padding_0);

        TimeBox timeBox1 = TimeBox.create()
                .floating()
                .setPlaceholder("Wakeup");

        TimeBox timeBox2 = TimeBox.create("Wakeup", new Time(), new DateTimeFormatInfoImpl_de());

        timeBox2.getTimePicker().setColorScheme(ColorScheme.PINK);


        TimeBox timeBox3 = TimeBox.create()
                .floating()
                .setPopoverPosition(PopupPosition.TOP)
                .setPickerStyle(TimeBox.PickerStyle.POPOVER)
                .setPlaceholder("Wakeup");

        timeBox3.getTimePicker().setColorScheme(ColorScheme.GREEN);


        element.appendChild(Card.create("TIME BOX")
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(timeBox1.asElement()))
                        .addColumn(column.copy().addElement(timeBox2.asElement()))
                        .addColumn(column.copy().addElement(timeBox3.asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.timebox()).asElement());

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

}