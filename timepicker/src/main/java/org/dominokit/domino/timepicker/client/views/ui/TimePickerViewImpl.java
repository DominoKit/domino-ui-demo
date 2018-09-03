package org.dominokit.domino.timepicker.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.timepicker.client.presenters.TimePickerPresenter;
import org.dominokit.domino.timepicker.client.views.CodeResource;
import org.dominokit.domino.timepicker.client.views.TimePickerView;
import org.dominokit.domino.ui.button.Button;
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
import org.dominokit.domino.ui.timepicker.Time;
import org.dominokit.domino.ui.timepicker.TimeBox;
import org.dominokit.domino.ui.timepicker.TimePicker;
import org.gwtproject.i18n.client.impl.cldr.DateTimeFormatInfoImpl_de;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = TimePickerPresenter.class)
public class TimePickerViewImpl extends ComponentView<HTMLDivElement> implements TimePickerView {

    private HTMLDivElement element = div().asElement();

    private Column column = Column.span4()
            .centerContent()
            .style()
            .css(Styles.padding_0).get();

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("TIME PICKERS").asElement());

        inlined();
        popups();
        timeBox();
    }

    private void inlined() {
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
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.inlined()).asElement());
    }

    private void popups() {
        Button bluePopupButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());
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


        Button pinkPopupButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.PINK.color());
        TimePicker pinkPopDatePicker = TimePicker.create(new DateTimeFormatInfoImpl_de())
                .setColorScheme(ColorScheme.PINK)
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));
        Popover pinkPopover = Popover.createPicker(pinkPopupButton,  pinkPopDatePicker);

        pinkPopDatePicker.addCloseHandler(pinkPopover::close);
        pinkPopDatePicker.addClearHandler(() ->
                Notification.create("a Click on clear button")
                        .setPosition(Notification.TOP_CENTER)
                        .setBackground(ColorScheme.PINK.color())
                        .show());


        Button greenPopupButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());
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


        Button blueModalButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());
        TimePicker blueDatePicker = TimePicker.create()
                .addTimeSelectionHandler((time, dateTimeFormatInfo, picker) ->
                        DomGlobal.console.info(picker.getFormattedTime()));

        ModalDialog blueModal = blueDatePicker.createModal("Wakeup");
        blueDatePicker.addCloseHandler(blueModal::close);
        blueDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_LEFT)
                .setBackground(ColorScheme.BLUE.color())
                .show());


        blueModal.appendChild(blueDatePicker.asElement());
        DomGlobal.document.body.appendChild(blueModal.asElement());

        blueModalButton.addClickListener(evt -> blueModal.open());


        Button pinkModalButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.PINK.color());
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
        DomGlobal.document.body.appendChild(pinkModal.asElement());

        pinkModalButton.addClickListener(evt -> pinkModal.open());


        Button greenModalButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());
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
        DomGlobal.document.body.appendChild(greenModal.asElement());

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
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.popups()).asElement());
    }

    private void timeBox() {

        Column column = this.column.copy()
                .style()
                .removeCss(Styles.padding_0).get();

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
                .appendChild(Row.create()
                        .addColumn(column.copy().appendChild(timeBox1))
                        .addColumn(column.copy().appendChild(timeBox2))
                        .addColumn(column.copy().appendChild(timeBox3))
                        )
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.timebox()).asElement());

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }

}