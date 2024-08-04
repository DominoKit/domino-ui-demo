package org.dominokit.domino.datepicker.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.datepicker.Calendar;
import org.dominokit.domino.ui.datepicker.CalendarDay;
import org.dominokit.domino.ui.datepicker.CalendarPlugin;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.gwtproject.i18n.client.DateTimeFormat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.ColorsCss.dui_bg_accent;
import static org.dominokit.domino.ui.style.ColorsCss.dui_fg_white;
import static org.dominokit.domino.ui.style.DisplayCss.dui_flex;
import static org.dominokit.domino.ui.style.SpacingCss.*;
import static org.dominokit.domino.ui.utils.Domino.div;

public class SimpleEventsPlugin implements CalendarPlugin {

    private Map<Long, List<CalendarEvent>> eventsMap = new HashMap<>();
    private Calendar calendar;

    public SimpleEventsPlugin(Collection<CalendarEvent> events) {
        if (nonNull(events)) {
            events.forEach(event -> {
                long longDate = toPlainDate(event.getDate());
                if (!eventsMap.containsKey(longDate)) {
                    eventsMap.put(longDate, new ArrayList<>());
                }
                eventsMap.get(longDate).add(event);
            });
        }
    }

    @Override
    public void onInit(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public void onCalendarDayAdded(CalendarDay calendarDay) {
        long longDate = toPlainDate(calendarDay.getDate());
        calendarDay.addCss(dui_justify_start);
        if (eventsMap.containsKey(longDate)) {
            calendarDay.appendChild(div()
                    .addCss(dui_w_4, dui_h_4, dui_rounded_full, dui_bg_accent, dui_self_center)
                    .apply(self -> {
                        Popover.create(self)
                                .addCss(dui_rounded_md)
                                .apply(popover -> {
                                    DivElement eventsElement = div().addCss(dui_flex, dui_flex_col, dui_gap_2, dui_p_4);
                                    popover.appendChild(eventsElement);
                                    eventsMap.get(longDate)
                                            .forEach(event -> {
                                                eventsElement.appendChild(div()
                                                         .addCss(dui_w_64, dui_rounded_md, dui_bg_accent, dui_p_2, dui_fg_white)
                                                         .appendChild(BlockHeader.create(toTimeString(event.date), event.getDescription()))
                                                 );
                                            });
                                });
                    })
            );
        }
    }

    private String toTimeString(Date date){
        return DateTimeFormat.getFormat(this.calendar.getDateTimeFormatInfo().formatHour12Minute()).format(date);
    }

    private long toPlainDate(Date date) {
        long timeInMillis = date.getTime();

        // Convert to the beginning of the day
        long millisInDay = 24 * 60 * 60 * 1000; // Milliseconds in a day
        long millisSinceMidnight = timeInMillis % millisInDay;
        return timeInMillis - millisSinceMidnight;
    }

    public static class CalendarEvent {
        private final String description;
        private final Date date;
        private String color;

        public CalendarEvent(String description, Date date) {
            this.description = description;
            this.date = date;
        }

        public CalendarEvent(String description, Date date, String color) {
            this(description, date);
            this.color = color;
        }

        public static CalendarEvent of(String description, Date date) {
            return new CalendarEvent(description, date);
        }

        public String getDescription() {
            return description;
        }

        public Date getDate() {
            return date;
        }

        public String getColor() {
            return color;
        }
    }

    public static class EventComponent extends BaseDominoElement<HTMLDivElement, EventComponent> {

        private final DivElement root;
        private final CalendarEvent event;


        public EventComponent(CalendarEvent event) {
            this.event = event;
            this.root = div();
            init(this);
        }

        public DivElement getRoot() {
            return root;
        }

        public CalendarEvent getEvent() {
            return event;
        }

        @Override
        public HTMLDivElement element() {
            return root.element();
        }
    }

}
