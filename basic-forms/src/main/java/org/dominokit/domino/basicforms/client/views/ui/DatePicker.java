package org.dominokit.domino.basicforms.client.views.ui;

import elemental2.core.JsDate;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.DropDown;
import org.dominokit.domino.ui.forms.DropDownOption;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Background;
import org.dominokit.domino.ui.utils.HasValue;
import org.gwtproject.i18n.client.impl.cldr.DateTimeFormatInfo_factory;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.Date;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

public class DatePicker implements IsElement<HTMLDivElement>, HasValue<Date>, DatePickerMonth.DaySelectionHandler {

    private final JsDate jsDate;
    private HTMLDivElement element = div().css("calendar").asElement();
    private HTMLDivElement headerPanel = div().css("date-panel").asElement();
    private HTMLDivElement selectorsPanel = div().asElement();
    private HTMLDivElement footerPanel = div().css("footer").asElement();

    private HTMLDivElement dayName = div().css("day-name").asElement();
    private HTMLDivElement monthName = div().css("month-name").asElement();
    private HTMLDivElement dateNumber = div().css("day-number").asElement();
    private HTMLDivElement yearNumber = div().css("year-number").asElement();

    private DropDown yearSelect;
    private DropDown monthSelect;
    private Button todayButton;

    private Background background = Background.LIGHT_BLUE;

    private final DatePickerMonth datePickerMonth;

    private Column column = Column.create()
            .onXSmall(Column.OnXSmall.six)
            .onSmall(Column.OnSmall.six)
            .onMedium(Column.OnMedium.six)
            .onLarge(Column.OnLarge.six);


    public DatePicker(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        this.jsDate = new JsDate();
        this.jsDate.setTime(date.getTime());

        datePickerMonth = DatePickerMonth.create(jsDate, dateTimeFormatInfo, this);

        element.appendChild(headerPanel);
        headerPanel.classList.add(background.getStyle());
        dayName.classList.add(background.darker().getStyle());
        headerPanel.appendChild(dayName);
        headerPanel.appendChild(monthName);
        headerPanel.appendChild(dateNumber);
        headerPanel.appendChild(yearNumber);

        element.appendChild(selectorsPanel);
        initSelectors();
        element.appendChild(datePickerMonth.asElement());
        element.appendChild(footerPanel);
        initFooter();

        datePickerMonth.init();


    }

    private void initFooter() {
        Column column=Column.create()
                .onLarge(Column.OnLarge.twelve)
                .onMedium(Column.OnMedium.twelve)
                .onSmall(Column.OnSmall.twelve)
                .onXSmall(Column.OnXSmall.twelve);

        todayButton = Button.create("TODAY");
        todayButton.addClickListener(evt -> setDate(new Date()));
        footerPanel.appendChild(Row.create()
                .addColumn(column.addElement(todayButton.linkify().block().asElement()))
                .asElement());
    }

    private void initSelectors() {

        int year = jsDate.getFullYear();
        yearSelect = DropDown.create();
        for (int i = year - 20; i < year + 20; i++) {
            DropDownOption yearOption = DropDownOption.create(i + "", i + "");
            yearSelect.addOption(yearOption);

            if (i == year)
                yearSelect.select(yearOption);
        }
        yearSelect.addSelectionHandler(option -> {
            int selectedYear = Integer.parseInt(option.getValue());
            jsDate.setYear(selectedYear);
            setDate(jsDate);
        });

        int month = jsDate.getMonth();
        monthSelect = DropDown.create();

        String[] months = getDateTimeFormatInfo().monthsFull();
        for(int i=0;i<months.length;i++){
            DropDownOption monthOption=DropDownOption.create(i+"", months[i]);
            monthSelect.addOption(monthOption);
            if(i==month)
                monthSelect.select(monthOption);
        }
        monthSelect.addSelectionHandler(option -> {
            int selectedMonth=Integer.parseInt(option.getValue());
            jsDate.setMonth(selectedMonth);
            setDate(jsDate);
        });

        Column yearColumn = this.column.addElement(yearSelect.asElement());
        yearColumn.asElement().style.setProperty("padding-right","0px", "important");

        Column monthColumn = this.column.copy().addElement(monthSelect.asElement());
        monthColumn.asElement().style.setProperty("padding-left","0px", "important");

        selectorsPanel.appendChild(Row.create()
                .addColumn(yearColumn)
                .addColumn(monthColumn)
                .asElement());
    }

    public static DatePicker create() {
        DateTimeFormatInfo dateTimeFormatInfo = DateTimeFormatInfo_factory.create();
        Date date = new Date();

        return new DatePicker(date, dateTimeFormatInfo);
    }

    public static DatePicker create(Date date) {
        DateTimeFormatInfo dateTimeFormatInfo = DateTimeFormatInfo_factory.create();
        return new DatePicker(date, dateTimeFormatInfo);
    }

    public static DatePicker create(Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        return new DatePicker(date, dateTimeFormatInfo);
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    @Override
    public void setValue(Date value) {
        datePickerMonth.setValue(value);
    }

    @Override
    public Date getValue() {
        return datePickerMonth.getValue();
    }

    public DatePicker setDate(Date date) {
        this.setValue(date);
        return this;
    }

    public Date getDate() {
        return this.getValue();
    }

    public DatePicker setDate(JsDate jsDate) {
        this.setValue(new Date(new Double(jsDate.getTime()).longValue()));
        return this;
    }

    public JsDate getJsDate() {
        return new JsDate((double) getValue().getTime());
    }

    public DatePicker addDaySelectionHandler(DatePickerMonth.DaySelectionHandler daySelectionHandler) {
        datePickerMonth.addDaySelectionHandler(daySelectionHandler);
        return this;
    }

    public DatePicker removeDaySelectionHandler(DatePickerMonth.DaySelectionHandler daySelectionHandler) {
        datePickerMonth.removeDaySelectionHandler(daySelectionHandler);
        return this;
    }

    public List<DatePickerMonth.DaySelectionHandler> getDaySelectionHandlers() {
        return datePickerMonth.getDaySelectionHandlers();
    }

    public DatePicker clearDaySelectionHandlers() {
        datePickerMonth.clearDaySelectionHandlers();
        return this;
    }

    public DatePicker setDateTimeFormatInfo(DateTimeFormatInfo dateTimeFormatInfo) {
        this.datePickerMonth.setDateTimeFormatInfo(dateTimeFormatInfo);
        return this;
    }

    public DateTimeFormatInfo getDateTimeFormatInfo() {
        return datePickerMonth.getDateTimeFormatInfo();
    }

    public DatePicker setBackground(Background background) {
        this.headerPanel.classList.remove(this.background.getStyle());
        this.dayName.classList.remove(this.background.darker().getStyle());
        this.background = background;
        this.headerPanel.classList.add(this.background.getStyle());
        this.dayName.classList.add(this.background.darker().getStyle());
        this.datePickerMonth.setBackground(background);
        return this;
    }

    @Override
    public void onDaySelected(DatePickerElement datePickerElement) {
        this.dayName.textContent = getDateTimeFormatInfo().weekdaysFull()[datePickerElement.getWeekDay()];
        this.monthName.textContent = getDateTimeFormatInfo().monthsFull()[datePickerElement.getMonth()];
        this.dateNumber.textContent = datePickerElement.getDay() + "";
        this.yearNumber.textContent = datePickerElement.getYear() + "";
        this.monthSelect.selectAt(datePickerElement.getMonth(), true);
        this.yearSelect.setValue(datePickerElement.getYear()+"", true);
    }

    public DatePicker showHeaderPanel() {
        headerPanel.style.display = "block";
        return this;
    }

    public DatePicker hideHeaderPanel() {
        headerPanel.style.display = "none";
        return this;
    }

    public DatePicker showTodayButton(){
        this.todayButton.asElement().style.display="block";
        return this;
    }

    public DatePicker hideTodayButton(){
        this.todayButton.asElement().style.display="none";
        return this;
    }
}
