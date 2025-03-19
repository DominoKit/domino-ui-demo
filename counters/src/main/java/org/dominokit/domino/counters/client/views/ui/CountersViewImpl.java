package org.dominokit.domino.counters.client.views.ui;

import com.google.gwt.i18n.client.DateTimeFormat;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.counters.client.presenters.CountersProxy;
import org.dominokit.domino.counters.client.views.CountersView;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.counter.Counter;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.IntegerBox;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.pro.domino.ui.counter.CountCircle;
import org.dominokit.pro.domino.ui.counter.DateCountDown;

import static org.dominokit.domino.ui.style.DisplayCss.dui_flex;
import static org.dominokit.domino.ui.style.GenericCss.dui_blue;
import static org.dominokit.domino.ui.style.SpacingCss.*;
import static org.dominokit.domino.ui.utils.Domino.div;

@UiView(presentable = CountersProxy.class)
@SampleClass
public class CountersViewImpl extends BaseDemoView<HTMLDivElement> implements CountersView {

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.createLink("counters", CountersViewImpl.class));
        element.appendChild(BlockHeader.create("Counters")
                .element());

        simpleCounter();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.simpleCounter()));

        autoCount();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.autoCount()));

        dateAndTimeCounters();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.dateAndTimeCounters()));

        return element.element();
    }

    @SampleMethod
    private void simpleCounter() {
        element.appendChild(Card.create("SIMPLE COUNTER", "Simple count circles")
                .appendChild(div()
                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                        .appendChild(CountCircle.create(0, 100).withValue(65))
                        .appendChild(CountCircle.create(0, 100)
                                .withValue(80)
                                .setTextExpression("items: ${value}")
                                .setSize(200.0, 40.0)
                                .setCounterColors("var(--dui-clr-blue)", "var(--dui-clr-indigo)")
                                .withTextElement((parent, self) -> self.addCss(dui_font_size_6))
                        )
                        .appendChild(div().addCss(dui_flex, dui_gap_4, dui_items_center)
                                .apply(div -> {
                                    CountCircle counter = CountCircle.create(0, 100);
                                    IntegerBox interval = IntegerBox.create("Interval")
                                            .withValue(5)
                                            .setMinValue(1)
                                            .setMaxValue(100);
                                    div
                                            .appendChild(counter)
                                            .appendChild(interval)
                                            .appendChild(Button.create("Count up", Icons.arrow_up())
                                                    .addClickListener(evt -> counter.countUp(interval.getValue()))
                                            )
                                            .appendChild(Button.create("Count down", Icons.arrow_down())
                                                    .addClickListener(evt -> counter.countDown(interval.getValue()))
                                            )
                                    ;

                                })

                        )
                )
        );
    }

    @SampleMethod
    private void autoCount() {
        element.appendChild(Card.create("AUTO COUNT", "Use timers for auto count")
                .appendChild(div()
                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                        .appendChild(CountCircle.create(0, 100)
                                .withValue(0)
                                .apply(self -> {
                                    Counter counter = Counter.countFrom(1)
                                            .countTo(100)
                                            .every(200)
                                            .incrementBy(1)
                                            .onCount(self::setValue)
                                            .startCounting();
                                    self.withInnerContainer((parent, container) -> {
                                        container
                                                .addCss(dui_flex_col)
                                                .appendChild(Button.create(Icons.restart()).circle().addClickListener(evt -> {
                                                    counter.stopCounting();
                                                    self.setValue(0);
                                                    DomGlobal.setTimeout(p0 -> {
                                                        counter.startCounting();
                                                    }, 1000);

                                                }));
                                    });
                                })
                        )
                        .appendChild(CountCircle.create(0, 100)
                                .withValue(80)
                                .setTextExpression("items: ${value}")
                                .setSize(200.0, 40.0)
                                .setCounterColors("var(--dui-clr-blue)", "var(--dui-clr-indigo)")
                                .withTextElement((parent, self) -> self.addCss(dui_font_size_6))
                                .apply(self -> {
                                    Counter counter = Counter.countFrom(1)
                                            .countTo(100)
                                            .every(100)
                                            .incrementBy(1)
                                            .onCount(self::setValue)
                                            .startCounting();
                                    self.withInnerContainer((parent, container) -> {
                                        container
                                                .addCss(dui_flex_col)
                                                .appendChild(Button.create(Icons.restart())
                                                        .addCss(dui_blue)
                                                        .circle()
                                                        .addClickListener(evt -> {
                                                            counter.stopCounting();
                                                            self.setValue(0);
                                                            DomGlobal.setTimeout(p0 -> {
                                                                counter.startCounting();
                                                            }, 1000);

                                                        }));
                                    });
                                })
                        )
                        .appendChild(CountCircle.create(0, 100)
                                .withValue(80)
                                .setTextExpression("items: ${value}")
                                .setSize(200.0, 40.0)
                                .setCounterColors("var(--dui-clr-blue)", "var(--dui-clr-indigo)")
                                .withTextElement((parent, self) -> self.addCss(dui_font_size_6))
                                .apply(self -> {
                                    Counter counter = Counter.countFrom(100)
                                            .countTo(1)
                                            .every(100)
                                            .incrementBy(1)
                                            .onCount(self::setValue)
                                            .startCounting();
                                    self.withInnerContainer((parent, container) -> {
                                        container
                                                .addCss(dui_flex_col)
                                                .appendChild(Button.create(Icons.restart())
                                                        .addCss(dui_blue)
                                                        .circle()
                                                        .addClickListener(evt -> {
                                                            counter.stopCounting();
                                                            self.setValue(100);
                                                            DomGlobal.setTimeout(p0 -> {
                                                                counter.startCounting();
                                                            }, 1000);

                                                        }));
                                    });
                                })
                        )
                )
        );
    }

    @SampleMethod
    private void dateAndTimeCounters() {
        element.appendChild(Card.create("DATE & TIME COUNTERS", "Use counters to count down date and time")
                .appendChild(div()
                        .addCss(dui_flex, dui_gap_4, dui_items_center, dui_flex_col)
                        .appendChild(DateCountDown.create()
                                .showCounters(DateCountDown.CounterUnits.MINUTES, DateCountDown.CounterUnits.SECONDS)
                                .start(30, 0)
                        )
                        .appendChild(DateCountDown.create()
                                .showCounters(DateCountDown.CounterUnits.HOURS,
                                        DateCountDown.CounterUnits.MINUTES,
                                        DateCountDown.CounterUnits.SECONDS)
                                .start(1, 30, 0)
                        )
                        .appendChild(DateCountDown.create()
                                .showCounters(DateCountDown.CounterUnits.DAYS,
                                        DateCountDown.CounterUnits.HOURS,
                                        DateCountDown.CounterUnits.MINUTES,
                                        DateCountDown.CounterUnits.SECONDS)
                                .start(4, 1, 30, 0)
                        )
                        .appendChild(DateCountDown.create()
                                .start(DateTimeFormat.getFormat("yyyy-MM-dd").parse("2030-07-01"))
                        )

                )
        );
    }
}