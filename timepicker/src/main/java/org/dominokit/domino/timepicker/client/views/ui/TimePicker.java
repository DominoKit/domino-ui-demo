package org.dominokit.domino.timepicker.client.views.ui;

import elemental2.core.JsDate;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.svg.SVGCircleElement;
import elemental2.svg.SVGElement;
import elemental2.svg.SVGLineElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.CircleSize;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.gwtproject.i18n.shared.DateTimeFormat;
import org.gwtproject.i18n.shared.DateTimeFormatInfo;
import org.gwtproject.i18n.shared.impl.cldr.DateTimeFormatInfo_factory;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.timepicker.client.views.ui.TimePicker.DayPeriod.AM;
import static org.dominokit.domino.timepicker.client.views.ui.TimePicker.DayPeriod.PM;
import static org.dominokit.domino.timepicker.client.views.ui.TimePicker.TimeStyle._12;
import static org.dominokit.domino.timepicker.client.views.ui.TimePicker.TimeStyle._24;
import static org.jboss.gwt.elemento.core.Elements.div;

public class TimePicker implements IsElement<HTMLDivElement> {
    private static final String SVGNS = "http://www.w3.org/2000/svg";
    private static final double outerRadius = 112;
    private static final double innerRadius = 82;

    private final HTMLDivElement picker;
    private final HTMLDivElement clockHoursPanel;
    private JsDate jsDate = new JsDate();
    private int hour;
    private final Map<Integer, HourElement> hourElements = new HashMap<>();
    private SVGElement root;
    private SVGCircleElement clockCircle;
    private SVGCircleElement centerCircle;

    private class HourElement {
        private Map<Integer, Double> hourAngleMap = new HashMap<Integer, Double>() {{
            put(1, 5 * Math.PI / 3);
            put(2, 11 * Math.PI / 6);
            put(3, 2 * Math.PI);
            put(4, Math.PI / 6);
            put(5, Math.PI / 3);
            put(6, Math.PI / 2);
            put(7, 2 * Math.PI / 3);
            put(8, 5 * Math.PI / 6);
            put(9, Math.PI);
            put(10, 7 * Math.PI / 6);
            put(11, 4 * Math.PI / 3);
            put(12, 3 * Math.PI / 2);

            put(13, 5 * Math.PI / 3);
            put(14, 11 * Math.PI / 6);
            put(15, 2 * Math.PI);
            put(16, Math.PI / 6);
            put(17, Math.PI / 3);
            put(18, Math.PI / 2);
            put(19, 2 * Math.PI / 3);
            put(20, 5 * Math.PI / 6);
            put(21, Math.PI);
            put(22, 7 * Math.PI / 6);
            put(23, 4 * Math.PI / 3);
            put(0, 3 * Math.PI / 2);
        }};

        private final double centerX = 150;
        private final double centerY = 137;
        private final double radius = 20;
        private final double x;
        private final double y;
        private final double left;
        private final double top;

        private SVGCircleElement circle;
        private SVGLineElement line;
        private HTMLDivElement element;

        public HourElement(int hour, TimeStyle timeStyle) {
            double hoursRadius = (_24.equals(timeStyle) && hour <= 12 && hour > 0) ? innerRadius : outerRadius;

            this.x = centerX + hoursRadius * Math.cos(hourAngleMap.get(hour));
            this.y = centerY + hoursRadius * Math.sin(hourAngleMap.get(hour));

            this.left = x - radius;
            this.top = y - radius;

            this.circle = createCircle(x, y, radius, TimePicker.this.colorScheme.lighten_4().getHex());
            this.line = createLine(x, y, TimePicker.this.colorScheme.lighten_4().getHex());
            this.element = div()
                    .css("hour")
                    .style("position: absolute; left:" + left + "px; top:" + top + "px; color: " + Color.BLUE_GREY_DARKEN_1.getHex() + ";")
                    .textContent(hour + "").asElement();
        }

        private SVGLineElement createLine(double x, double y, String color) {
            SVGLineElement line = (SVGLineElement) document.createElementNS(SVGNS, "line");
            line.setAttributeNS(null, "x1", centerX);
            line.setAttributeNS(null, "y1", centerY);
            line.setAttributeNS(null, "x2", x);
            line.setAttributeNS(null, "y2", y);
            line.setAttributeNS(null, "style", "stroke: " + color + ";");
            return line;
        }

    }

    private HTMLDivElement element = div().css("time-picker").asElement();
    private HTMLDivElement headerPanel = div().css("time-panel").asElement();
    private HTMLDivElement timePanel = div().css("full-header-time").asElement();

    private HTMLDivElement hourPanel = div().css("time-hour").asElement();
    private HTMLDivElement amPmPanel = div().css("year-ampm").asElement();
    private HTMLDivElement amPmSelectorPanel = div().css("time-ampm-select").asElement();

    private ColorScheme colorScheme = ColorScheme.GREEN;

    private HTMLDivElement hoveredElement;

    private TimeStyle timeStyle = _24;
    private DayPeriod dayPeriod;
    private DateTimeFormatInfo dateTimeFormatInfo;

    public TimePicker() {
        this(DateTimeFormatInfo_factory.create());
    }

    public TimePicker(DateTimeFormatInfo dateTimeFormatInfo) {
        this.dateTimeFormatInfo = dateTimeFormatInfo;
        this.hour = jsDate.getHours();
        this.dayPeriod = this.hour > 11 ? PM : AM;

        element.appendChild(headerPanel);
        Style.of(element).setWidth("300px");
        headerPanel.classList.add(colorScheme.color().getBackground());
        timePanel.classList.add(colorScheme.darker_2().getBackground());
        headerPanel.appendChild(timePanel);
        headerPanel.appendChild(hourPanel);
        headerPanel.appendChild(amPmPanel);

        amPmPanel.textContent = "AM";
        clockHoursPanel = div().css("hour-picker").asElement();
        picker = div().style("position: relative;").asElement();
        picker.appendChild(clockHoursPanel);
        element.appendChild(picker);

        ElementUtil.builderFor(picker)
                .on(EventType.mouseout, event -> {
                    if (nonNull(hoveredElement)) {
                        hoveredElement.classList.remove(colorScheme.lighten_4().getBackground());
                    }
                });

        drawHours();

        element.appendChild(amPmSelectorPanel);
        HTMLElement am = Button.createDefault("AM").setBackground(colorScheme.color()).circle(CircleSize.LARGE).asElement();
        am.style.setProperty("float", "left");

        amPmSelectorPanel.appendChild(am);
        HTMLElement pm = Button.createDefault("PM").setBackground(colorScheme.color()).circle(CircleSize.LARGE).asElement();
        pm.style.setProperty("float", "right");
        amPmSelectorPanel.appendChild(pm);
        selectHour(this.hour);
        setTimeStyle(this.timeStyle);
    }


    private void drawHours() {
        int startHour = _12.equals(timeStyle) ? 1 : 0;
        int endHour = _12.equals(timeStyle) ? 12 : 23;
        root = (SVGElement) document.createElementNS(SVGNS, "svg");
        root.setAttribute("width", "300");
        root.setAttribute("height", "274");

        int centerX = 150;
        int centerY = 137;

        clockCircle = createCircle(centerX, centerY, 135, Color.BLUE_GREY_LIGHTEN_5.getHex());
        root.appendChild(clockCircle);

        centerCircle = createCircle(centerX, centerY, 2, colorScheme.color().getHex());

        picker.appendChild(root);

        for (int hour = startHour; hour <= endHour; hour++) {
            HourElement hourElement = makeHourElement(hour);
            hourElements.put(hour, hourElement);
            clockHoursPanel.appendChild(hourElement.element);
        }

    }

    private HourElement makeHourElement(int hour) {
        HourElement hourElement = new HourElement(hour, timeStyle);
        ElementUtil.builderFor(hourElement.element)
                .on(EventType.mouseenter, event -> {
                    if (nonNull(hoveredElement)) {
                        hoveredElement.classList.remove(colorScheme.lighten_4().getBackground());
                    }
                    hourElement.element.classList.add(colorScheme.lighten_4().getBackground());
                    hoveredElement = hourElement.element;
                })
                .on(EventType.click, event -> {
                    event.stopPropagation();
                    selectHour(hour);

                });

        return hourElement;
    }

    private void selectHour(int hour) {
        int elementHour = hour;
        if (_12.equals(timeStyle) && hour > 12)
            elementHour = hour - 12;
        HourElement hourElement = hourElements.get(elementHour);
        ElementUtil.clear(root);
        root.appendChild(clockCircle);
        root.appendChild(hourElement.circle);
        root.appendChild(hourElement.line);
        root.appendChild(centerCircle);
        updateHour(hour);
        formatTime();

    }

    public void setHour(int hour) {
        this.hour = hour;
        selectHour(hour);
    }

    private void updateHour(int hour) {
        this.jsDate.setHours(this.timeStyle.getActualHour(hour, dayPeriod));
    }

    public void setHeaderPanelVisibility(boolean visible) {
        if (visible)
            hourPanel.style.display = "block";
        else
            hourPanel.style.display = "none";
    }

    public void setTimeStyle(TimeStyle timeStyle) {
        this.timeStyle = timeStyle;
        if (_12.equals(timeStyle)) {
            amPmSelectorPanel.style.display = "block";
            amPmPanel.style.display = "block";
        } else {
            amPmSelectorPanel.style.display = "none";
            amPmPanel.style.display = "none";
        }

        formatTime();
    }

    private void formatTime() {
        timePanel.textContent = this.timeStyle.formatTime(dateTimeFormatInfo, jsDate);
        hourPanel.textContent = this.timeStyle.formatTime(dateTimeFormatInfo, jsDate);
    }


    private SVGCircleElement createCircle(double x, double y, double r, String color) {
        SVGCircleElement circle = (SVGCircleElement) document.createElementNS(SVGNS, "circle");
        circle.setAttributeNS(null, "cx", x);
        circle.setAttributeNS(null, "cy", y);
        circle.setAttributeNS(null, "r", r);
        circle.setAttributeNS(null, "style", "stroke: none; fill: " + color + ";");
        return circle;
    }


    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    public enum TimeStyle {
        _12,
        _24;

        public String formatTime(DateTimeFormatInfo dateTimeFormatInfo, JsDate date) {
            if (_12.equals(this)) {
                return DateTimeFormat.getFormat(dateTimeFormatInfo.formatHour12Minute()).format(new Date(new Double(date.getTime()).longValue()));
            } else {
                return DateTimeFormat.getFormat(dateTimeFormatInfo.formatHour24Minute()).format(new Date(new Double(date.getTime()).longValue()));
            }
        }

        public int getActualHour(int hour, DayPeriod period) {
            if (_12.equals(this)) {
                return asAmPmHour(hour, period);
            } else {
                return hour;
            }
        }

        private int asAmPmHour(int hour, DayPeriod period) {
            if (PM.equals(period) && hour > 12)
                return hour;
            return hour + 12;
        }

    }

    public enum DayPeriod {
        AM,
        PM
    }

}
