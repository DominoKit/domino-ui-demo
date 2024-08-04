package org.dominokit.domino.datepicker.client.views.ui;

import org.dominokit.domino.ui.datepicker.CalendarDay;
import org.dominokit.domino.ui.datepicker.CalendarPlugin;

public class DisableWeekendDaysPlugin implements CalendarPlugin {

    @Override
    public void onCalendarDayAdded(CalendarDay calendarDay) {
        if (calendarDay.isWeekend()) {
            calendarDay.disable();
            calendarDay.addCss("dui-mark-weekend-day");
        }
    }
}
