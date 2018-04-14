package org.dominokit.domino.basicforms.client.views.ui;

import org.dominokit.domino.ui.forms.ValueBox;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.PopupPosition;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;

import java.util.Date;

import static java.util.Objects.isNull;

public class DateField extends ValueBox<DateField, Date> {

    private DatePicker datePicker;
    private String pattern;

    public DateField() {
        this(new Date());
    }

    public DateField(Date date) {
        this.datePicker = DatePicker.create(date);
        init();
    }

    public DateField(String placeholder, Date date) {
        super("text", placeholder);
        this.datePicker = DatePicker.create(date);
        init();
    }

    public DateField(String placeholder, Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        super("text", placeholder);
        this.datePicker = DatePicker.create(date, dateTimeFormatInfo);
        init();

    }

    private void init(){
        this.pattern = this.datePicker.getDateTimeFormatInfo().dateFormatFull();
        this.datePicker.addDaySelectionHandler(datePickerElement -> DateField.this.setStringValue(this.datePicker.getDate()));
        Popover popover = Popover.create(this.asElement(), getPlaceholder(), this.datePicker.asElement());
        popover.getContentElement().style.setProperty("padding","0px", "important");
        popover.position(PopupPosition.BOTTOM)
                .asElement().style.setProperty("max-width", "none", "important");
    }

    public static DateField create() {
        return new DateField();
    }

    public static DateField create(Date date) {
        return new DateField(date);
    }

    public static DateField create(String placeHolder, Date date) {
        return new DateField(placeHolder, date);
    }

    public static DateField create(String placeholder, Date date, DateTimeFormatInfo dateTimeFormatInfo) {
        return new DateField(placeholder, date, dateTimeFormatInfo);
    }

    public DateField setPattern(Pattern pattern) {
        switch (pattern){
            case FULL:
                this.pattern=datePicker.getDateTimeFormatInfo().dateFormatFull();
                return this;
            case LONG:
                this.pattern=datePicker.getDateTimeFormatInfo().dateFormatLong();
                return this;
            case MEDIUM:
                this.pattern=datePicker.getDateTimeFormatInfo().dateFormatMedium();
                return this;
            case SHORT:
                this.pattern=datePicker.getDateTimeFormatInfo().dateFormatShort();
                return this;
                default:
                    return this;
        }
    }

    public DateField setPattern(String pattern) {
        this.pattern=pattern;
        return this;
    }

    @Override
    public boolean isEmpty() {
        return isNull(datePicker.getDate());
    }

    @Override
    public void setValue(Date value) {
        this.datePicker.setDate(value);
        setStringValue(value);
    }

    private void setStringValue(Date date) {
        this.inputElement.value = Formatter.getFormat(this.pattern, this.datePicker.getDateTimeFormatInfo()).format(this.datePicker.getDate());
    }

    @Override
    public Date getValue() {
        return datePicker.getDate();
    }

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

    public enum Pattern {
        FULL,
        LONG,
        MEDIUM,
        SHORT
    }
}
