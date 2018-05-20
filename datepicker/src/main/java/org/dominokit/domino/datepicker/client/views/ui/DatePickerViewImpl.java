package org.dominokit.domino.datepicker.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.datepicker.client.presenters.DatePickerPresenter;
import org.dominokit.domino.datepicker.client.views.CodeResource;
import org.dominokit.domino.datepicker.client.views.DatePickerView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.IconButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.datepicker.DateBox;
import org.dominokit.domino.ui.datepicker.DatePicker;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Styles;
import org.gwtproject.i18n.client.impl.cldr.DateTimeFormatInfoImpl_fr;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;

import java.util.Date;

import static org.jboss.gwt.elemento.core.Elements.div;

@UiView(presentable = DatePickerPresenter.class)
public class DatePickerViewImpl extends ComponentView<HTMLDivElement> implements DatePickerView {

    private HTMLDivElement element = div().asElement();
    private Column column = Column.create()
            .onLarge(Column.OnLarge.four)
            .onMedium(Column.OnMedium.four)
            .onSmall(Column.OnSmall.twelve)
            .onXSmall(Column.OnXSmall.twelve)
            .addCssClass(Styles.padding_0)
            .centerContent();

    private static class Formatter extends DateTimeFormat {

        protected Formatter(String pattern) {
            super(pattern);
        }

        protected Formatter(String pattern, DateTimeFormatInfo dtfi) {
            super(pattern, dtfi);
        }

        public static DateTimeFormat getFormat(String pattern, DateTimeFormatInfo dateTimeFormatInfo) {
            return DateTimeFormat.getFormat(pattern, dateTimeFormatInfo);
        }
    }

    @Override
    public void init() {
        element.appendChild(BlockHeader.create("DATE PICKERS").asElement());

        inlined();
        popups();
        dateBox();

    }

    private void inlined() {

        element.appendChild(Card.create("INLINED")
                .appendContent(BlockHeader.create("Header visible").asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(DatePicker.create()
                                .hideClearButton()
                                .hideCloseButton()
                                .fixedWidth("265px")
                                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                    Notification.create(dateTimeFormat.format(date))
                                            .setPosition(Notification.TOP_LEFT)
                                            .setBackground(Color.BLUE)
                                            .show();
                                })
                                .asElement()))
                        .addColumn(column.copy().addElement(DatePicker.create(new Date(), new DateTimeFormatInfoImpl_fr())
                                .setColorScheme(ColorScheme.AMBER)
                                .hideClearButton()
                                .hideCloseButton()
                                .fixedWidth("265px")
                                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                    Notification.create(dateTimeFormat.format(date))
                                            .setPosition(Notification.TOP_CENTER)
                                            .setBackground(ColorScheme.AMBER.darker_2())
                                            .show();
                                })
                                .todayButtonText("aujourd'hui")
                                .asElement()))
                        .addColumn(column.copy().addElement(DatePicker.create()
                                .setColorScheme(ColorScheme.GREEN)
                                .hideClearButton()
                                .hideCloseButton()
                                .fixedWidth("265px")
                                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                    Notification.create(dateTimeFormat.format(date))
                                            .setPosition(Notification.TOP_RIGHT)
                                            .setBackground(ColorScheme.GREEN.darker_2())
                                            .show();
                                })
                                .asElement()))
                        .asElement())
                .appendContent(BlockHeader.create("Header hidden").asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(DatePicker.create()
                                .hideClearButton()
                                .hideCloseButton()
                                .hideHeaderPanel()
                                .fixedWidth("265px")
                                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                    Notification.create(dateTimeFormat.format(date))
                                            .setPosition(Notification.TOP_LEFT)
                                            .setBackground(ColorScheme.BLUE.color())
                                            .show();
                                })
                                .asElement()))
                        .addColumn(column.copy().addElement(DatePicker.create(new Date(), new DateTimeFormatInfoImpl_fr())
                                .setColorScheme(ColorScheme.AMBER)
                                .hideClearButton()
                                .hideHeaderPanel()
                                .hideCloseButton()
                                .fixedWidth("265px")
                                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                    Notification.create(dateTimeFormat.format(date))
                                            .setPosition(Notification.TOP_CENTER)
                                            .setBackground(ColorScheme.AMBER.darker_2())
                                            .show();
                                })
                                .todayButtonText("aujourd'hui")
                                .asElement()))
                        .addColumn(column.copy().addElement(DatePicker.create()
                                .setColorScheme(ColorScheme.GREEN)
                                .hideClearButton()
                                .hideHeaderPanel()
                                .hideCloseButton()
                                .fixedWidth("265px")
                                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                    Notification.create(dateTimeFormat.format(date))
                                            .setPosition(Notification.TOP_RIGHT)
                                            .setBackground(ColorScheme.GREEN.darker_2())
                                            .show();
                                })
                                .asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.inlined()).asElement());
    }

    private void popups() {
        Button bluePopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());
        DatePicker bluePopDatePicker = DatePicker.create()
                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                    Notification.create(dateTimeFormat.format(date))
                            .setPosition(Notification.TOP_LEFT)
                            .setBackground(ColorScheme.BLUE.color())
                            .show();
                });
        Popover bluePopover = Popover.create(bluePopupButton.asElement(), "Birth date", bluePopDatePicker
                .asElement());

        bluePopDatePicker.addCloseHandler(() -> bluePopover.close());
        bluePopDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_LEFT)
                .setBackground(ColorScheme.BLUE.color())
                .show());


        Button amberPopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.AMBER.color());
        DatePicker amberPopDatePicker = DatePicker.create(new Date(), new DateTimeFormatInfoImpl_fr())
                .setColorScheme(ColorScheme.AMBER)
                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                    Notification.create(dateTimeFormat.format(date))
                            .setPosition(Notification.TOP_CENTER)
                            .setBackground(ColorScheme.AMBER.color())
                            .show();
                });
        Popover amberPopover = Popover.create(amberPopupButton.asElement(), "Birth date", amberPopDatePicker
                .asElement());

        amberPopDatePicker.addCloseHandler(() -> amberPopover.close());
        amberPopDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_CENTER)
                .setBackground(ColorScheme.AMBER.color())
                .show());


        Button greenPopupButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());
        DatePicker greenPopDatePicker = DatePicker.create()
                .setColorScheme(ColorScheme.GREEN)
                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                    Notification.create(dateTimeFormat.format(date))
                            .setPosition(Notification.TOP_RIGHT)
                            .setBackground(ColorScheme.GREEN.color())
                            .show();
                });
        Popover greenPopover = Popover.create(greenPopupButton.asElement(), "Birth date", greenPopDatePicker
                .asElement());

        greenPopDatePicker.addCloseHandler(() -> greenPopover.close());
        greenPopDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_RIGHT)
                .setBackground(ColorScheme.GREEN.color())
                .show());


        Button blueModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());
        DatePicker blueDatePicker = DatePicker.create()
                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                    Notification.create(dateTimeFormat.format(date))
                            .setPosition(Notification.TOP_LEFT)
                            .setBackground(ColorScheme.BLUE.color())
                            .show();
                });
        ModalDialog blueModal = blueDatePicker.createModal("Birth date");
        blueDatePicker.addCloseHandler(() -> blueModal.close());
        blueDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_LEFT)
                .setBackground(ColorScheme.BLUE.color())
                .show());



        blueModal.appendContent(blueDatePicker.asElement());
        DomGlobal.document.body.appendChild(blueModal.asElement());

        blueModalButton.addClickListener(evt -> blueModal.open());


        Button amberModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.AMBER.color());
        DatePicker amberDatePicker = DatePicker.create()
                .setColorScheme(ColorScheme.AMBER)
                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                    Notification.create(dateTimeFormat.format(date))
                            .setPosition(Notification.TOP_CENTER)
                            .setBackground(ColorScheme.AMBER.color())
                            .show();
                });
        ModalDialog amberModal = amberDatePicker.createModal("Birth date");

        amberDatePicker.addCloseHandler(() -> amberModal.close());
        amberDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_CENTER)
                .setBackground(ColorScheme.AMBER.color())
                .show());

        amberModal.appendContent(amberDatePicker.asElement());
        DomGlobal.document.body.appendChild(amberModal.asElement());

        amberModalButton.addClickListener(evt -> amberModal.open());


        Button greenModalButton = IconButton.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());
        DatePicker greenDatePicker = DatePicker.create()
                .setColorScheme(ColorScheme.GREEN)
                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                    Notification.create(dateTimeFormat.format(date))
                            .setPosition(Notification.TOP_RIGHT)
                            .setBackground(ColorScheme.GREEN.color())
                            .show();
                });
        ModalDialog greenModal = greenDatePicker.createModal("Birth date");
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
                        .addColumn(column.copy().addElement(amberPopupButton.asElement()))
                        .addColumn(column.copy().addElement(greenPopupButton.asElement()))
                        .asElement())
                .appendContent(BlockHeader.create("MODAL").asElement())
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(blueModalButton.asElement()))
                        .addColumn(column.copy().addElement(amberModalButton.asElement()))
                        .addColumn(column.copy().addElement(greenModalButton.asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.popups()).asElement());
    }

    private void dateBox() {

        Column column=this.column.copy()
                .removeCssClass(Styles.padding_0);

        DateBox dateBox1 = DateBox.create()
                .floating()
                .setPlaceholder("Birth date");

        DateBox dateBox2 = DateBox.create("Birth date", new Date(), new DateTimeFormatInfoImpl_fr())
                .floating();

        dateBox2.getDatePicker().setColorScheme(ColorScheme.AMBER);


        DateBox dateBox3 = DateBox.create()
                .floating()
                .setPopoverPosition(PopupPosition.TOP)
                .setPickerStyle(DateBox.PickerStyle.POPOVER)
                .setPlaceholder("Birth date");

        dateBox3.getDatePicker().setColorScheme(ColorScheme.GREEN);


        element.appendChild(Card.create("DATE BOX")
                .appendContent(Row.create()
                        .addColumn(column.copy().addElement(dateBox1.asElement()))
                        .addColumn(column.copy().addElement(dateBox2.asElement()))
                        .addColumn(column.copy().addElement(dateBox3.asElement()))
                        .asElement())
                .asElement());

        element.appendChild(Card.createCodeCard(CodeResource.INSTANCE.datebox()).asElement());

    }

    @Override
    public HTMLDivElement getElement() {
        return element;
    }
}