package org.dominokit.domino.datepicker.client.views.ui;

import elemental2.dom.DomGlobal;
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
import org.dominokit.domino.ui.datepicker.DateBox;
import org.dominokit.domino.ui.datepicker.DatePicker;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Styles;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.cldr.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.cldr.impl.DateTimeFormatInfoImpl_fr;

import java.util.Date;

import static org.jboss.elemento.Elements.div;

@UiView(presentable = DatePickerProxy.class)
@SampleClass
public class DatePickerViewImpl extends BaseDemoView<HTMLDivElement> implements DatePickerView {

    private HTMLDivElement element;
    private Column column = Column.span4()
            .centerContent()
            .style()
            .addCss(Styles.padding_0)
            .get();

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
    protected HTMLDivElement init() {
        element = div().element();

        element.appendChild(LinkToSourceCode.create("datepicker", this.getClass()).element());
        element.appendChild(BlockHeader.create("DATE PICKERS").element());

        inline();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.inline()).element());

        popups();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.popups()).element());

        dateBox();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.dateBox()).element());

        return element;
    }

    @SampleMethod
    private void inline() {

        element.appendChild(Card.create("INLINED")
                .appendChild(BlockHeader.create("Header visible"))
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .centerContent()
                                .style()
                                .addCss(Styles.padding_0)
                                .get()
                                .appendChild(DatePicker.create()
                                        .hideClearButton()
                                        .hideCloseButton()
                                        .fixedWidth("265px")
                                        .showBorder()
                                        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                            Notification.create(dateTimeFormat.format(date))
                                                    .setPosition(Notification.TOP_LEFT)
                                                    .setBackground(Color.BLUE)
                                                    .show();
                                        })))
                        .addColumn(Column.span4()
                                .centerContent()
                                .style()
                                .addCss(Styles.padding_0)
                                .get()
                                .appendChild(DatePicker.create(new Date(), new DateTimeFormatInfoImpl_fr())
                                        .setColorScheme(ColorScheme.AMBER)
                                        .hideClearButton()
                                        .hideCloseButton()
                                        .showBorder()
                                        .fixedWidth("265px")
                                        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                            Notification.create(dateTimeFormat.format(date))
                                                    .setPosition(Notification.TOP_CENTER)
                                                    .setBackground(ColorScheme.AMBER.darker_2())
                                                    .show();
                                        })
                                        .todayButtonText("aujourd'hui")))
                        .addColumn(Column.span4()
                                .centerContent()
                                .style()
                                .addCss(Styles.padding_0)
                                .get()
                                .appendChild(DatePicker.create()
                                        .setColorScheme(ColorScheme.GREEN)
                                        .hideClearButton()
                                        .hideCloseButton()
                                        .showBorder()
                                        .fixedWidth("265px")
                                        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                            Notification.create(dateTimeFormat.format(date))
                                                    .setPosition(Notification.TOP_RIGHT)
                                                    .setBackground(ColorScheme.GREEN.darker_2())
                                                    .show();
                                        }))))
                .appendChild(BlockHeader.create("Header hidden").element())
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .centerContent()
                                .style()
                                .addCss(Styles.padding_0)
                                .get()
                                .appendChild(DatePicker.create()
                                        .hideClearButton()
                                        .hideCloseButton()
                                        .hideHeaderPanel()
                                        .showBorder()
                                        .fixedWidth("265px")
                                        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                            Notification.create(dateTimeFormat.format(date))
                                                    .setPosition(Notification.TOP_LEFT)
                                                    .setBackground(ColorScheme.BLUE.color())
                                                    .show();
                                        })))
                        .addColumn(Column.span4()
                                .centerContent()
                                .style()
                                .addCss(Styles.padding_0)
                                .get()
                                .appendChild(DatePicker.create(new Date(), new DateTimeFormatInfoImpl_fr())
                                        .setColorScheme(ColorScheme.AMBER)
                                        .hideClearButton()
                                        .hideHeaderPanel()
                                        .hideCloseButton()
                                        .showBorder()
                                        .fixedWidth("265px")
                                        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                            Notification.create(dateTimeFormat.format(date))
                                                    .setPosition(Notification.TOP_CENTER)
                                                    .setBackground(ColorScheme.AMBER.darker_2())
                                                    .show();
                                        })
                                        .todayButtonText("aujourd'hui")))
                        .addColumn(Column.span4()
                                .centerContent()
                                .style()
                                .addCss(Styles.padding_0)
                                .get()
                                .appendChild(DatePicker.create()
                                        .setColorScheme(ColorScheme.GREEN)
                                        .hideClearButton()
                                        .hideHeaderPanel()
                                        .hideCloseButton()
                                        .showBorder()
                                        .fixedWidth("265px")
                                        .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                                            DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                                            Notification.create(dateTimeFormat.format(date))
                                                    .setPosition(Notification.TOP_RIGHT)
                                                    .setBackground(ColorScheme.GREEN.darker_2())
                                                    .show();
                                        }))))
                .element());
    }

    @SampleMethod
    private void popups() {
        Button bluePopupButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());
        DatePicker bluePopDatePicker = DatePicker.create()
                .showBorder()
                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                    Notification.create(dateTimeFormat.format(date))
                            .setPosition(Notification.TOP_LEFT)
                            .setBackground(ColorScheme.BLUE.color())
                            .show();
                });
        Popover bluePopover = Popover.create(bluePopupButton, "Birth date", bluePopDatePicker)
                .style()
                .setMaxWidth("300px")
                .get();

        bluePopDatePicker.addCloseHandler(bluePopover::close);
        bluePopDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_LEFT)
                .setBackground(ColorScheme.BLUE.color())
                .show());


        Button amberPopupButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.AMBER.color());
        DatePicker amberPopDatePicker = DatePicker.create(new Date(), new DateTimeFormatInfoImpl_fr())
                .setColorScheme(ColorScheme.AMBER)
                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                    Notification.create(dateTimeFormat.format(date))
                            .setPosition(Notification.TOP_CENTER)
                            .setBackground(ColorScheme.AMBER.color())
                            .show();
                });
        Popover amberPopover = Popover.createPicker(amberPopupButton, amberPopDatePicker)
                .style()
                .setMaxWidth("300px")
                .get();

        amberPopDatePicker.addCloseHandler(amberPopover::close);
        amberPopDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_CENTER)
                .setBackground(ColorScheme.AMBER.color())
                .show());


        Button greenPopupButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());
        DatePicker greenPopDatePicker = DatePicker.create()
                .setColorScheme(ColorScheme.GREEN)
                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                    Notification.create(dateTimeFormat.format(date))
                            .setPosition(Notification.TOP_RIGHT)
                            .setBackground(ColorScheme.GREEN.color())
                            .show();
                });
        Popover greenPopover = Popover.createPicker(greenPopupButton, greenPopDatePicker)
                .style()
                .setMaxWidth("300px")
                .get();

        greenPopDatePicker.addCloseHandler(greenPopover::close);
        greenPopDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_RIGHT)
                .setBackground(ColorScheme.GREEN.color())
                .show());


        Button blueModalButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.BLUE.color());
        DatePicker blueDatePicker = DatePicker.create()
                .addDateSelectionHandler((date, dateTimeFormatInfo) -> {
                    DateTimeFormat dateTimeFormat = Formatter.getFormat(dateTimeFormatInfo.dateFormatFull(), dateTimeFormatInfo);
                    Notification.create(dateTimeFormat.format(date))
                            .setPosition(Notification.TOP_LEFT)
                            .setBackground(ColorScheme.BLUE.color())
                            .show();
                });
        ModalDialog blueModal = blueDatePicker.createModal("Birth date");
        blueDatePicker.addCloseHandler(blueModal::close);
        blueDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_LEFT)
                .setBackground(ColorScheme.BLUE.color())
                .show());


        blueModal.appendChild(blueDatePicker);
        DomGlobal.document.body.appendChild(blueModal.element());

        blueModalButton.addClickListener(evt -> blueModal.open());


        Button amberModalButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.AMBER.color());
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

        amberDatePicker.addCloseHandler(amberModal::close);
        amberDatePicker.addClearHandler(() -> Notification.create("a Click on clear button")
                .setPosition(Notification.TOP_CENTER)
                .setBackground(ColorScheme.AMBER.color())
                .show());

        amberModal.appendChild(amberDatePicker);
        DomGlobal.document.body.appendChild(amberModal.element());

        amberModalButton.addClickListener(evt -> amberModal.open());


        Button greenModalButton = Button.create(Icons.ALL.event()).setBackground(ColorScheme.GREEN.color());
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
                        .addColumn(column.copy().appendChild(amberPopupButton))
                        .addColumn(column.copy().appendChild(greenPopupButton)))
                .appendChild(BlockHeader.create("MODAL"))
                .appendChild(Row.create()
                        .addColumn(column.copy().appendChild(blueModalButton))
                        .addColumn(column.copy().appendChild(amberModalButton))
                        .addColumn(column.copy().appendChild(greenModalButton)))
                .element());
    }

    @SampleMethod
    private void dateBox() {

        Column column = this.column.copy()
                .style().removeCss(Styles.padding_0).get();

        DateBox dateBox1 = DateBox.create("Birth date")
                .setPattern("yyyy/MM/dd");

        DateBox dateBox2 = DateBox.create("Birth date", new Date(), new DateTimeFormatInfoImpl_fr());

        dateBox2.getDatePicker().setColorScheme(ColorScheme.AMBER);


        DateBox dateBox3 = DateBox.create("Birth date")
                .setPopoverPosition(PopupPosition.TOP)
                .setPickerStyle(DateBox.PickerStyle.POPOVER);

        dateBox3.getDatePicker().setColorScheme(ColorScheme.GREEN);


        element.appendChild(Card.create("DATE BOX")
                .appendChild(Row.create()
                        .addColumn(column.copy().deCenterContent().appendChild(dateBox1))
                        .addColumn(column.copy().deCenterContent().appendChild(dateBox2))
                        .addColumn(column.copy().deCenterContent().appendChild(dateBox3))
                        .element())
                .element());

    }

}