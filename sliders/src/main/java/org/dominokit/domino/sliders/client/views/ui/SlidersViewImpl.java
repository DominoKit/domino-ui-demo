package org.dominokit.domino.sliders.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.sliders.client.presenters.SlidersProxy;
import org.dominokit.domino.sliders.client.views.SlidersView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.elemento.Elements.*;

@UiView(presentable = SlidersProxy.class)
@SampleClass
public class SlidersViewImpl extends BaseDemoView<HTMLDivElement> implements SlidersView {

    private HTMLDivElement element;
    private Card basicCard;
    private Card colorsSlidersCard;
    private Card sampleCard;

    @Override
    protected HTMLDivElement init() {
        element = div().element();

        element.appendChild(LinkToSourceCode.create("sliders", this.getClass()).element());
        basicCard = Card.create("BASIC SLIDERS");
        colorsSlidersCard = Card.create("SLIDERS WITH COLORS");
        sampleCard = Card.create("SLIDERS EXAMPLE");

        initBasic();
        initColors();
        initExample();

        element.appendChild(BlockHeader.create("SLIDERS").element());
        element.appendChild(basicCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initBasic()).element());
        element.appendChild(colorsSlidersCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initColors()).element());
        element.appendChild(sampleCard.element());
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initExample()).element());

        return element;
    }

    @SampleMethod
    private void initBasic() {
        basicCard
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(BlockHeader.create("SIMPLE SLIDERS")))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(Slider.create(200)
                                        .withoutThumb()
                                        .addChangeHandler(this::showNotification)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(hr())))

                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(BlockHeader.create("SLIDERS WITH THUMB")))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(Slider.create(200, 20)
                                        .setValue(50)
                                        .withThumb()
                                        .addChangeHandler(this::showNotification)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(hr())))

                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(BlockHeader.create("SLIDERS CAN HAVE MIN AND MAX VALUES")
                                        .appendChild(span().textContent("Min: 100").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("Max: 200").element())
                                ))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(Slider.create(200, 100)
                                        .setValue(150)
                                        .withThumb()
                                        .addChangeHandler(this::showNotification)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(hr())))

                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(BlockHeader.create("SLIDERS WITH STEP")
                                        .appendChild(span().textContent("MIN: 100").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("MAX: 200").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("STEP: 10").element())
                                ))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(Slider.create(200, 100)
                                        .setStep(10)
                                        .withThumb()
                                        .addChangeHandler(this::showNotification)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(hr())))

                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(BlockHeader.create("SLIDERS WITH ANY STEP")
                                        .appendChild(span().textContent("MIN: 100").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("MAX: 200").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("STEP: ANY").element())
                                ))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span12()
                                .appendChild(Slider.create(200, 100)
                                        .anyStep()
                                        .withoutThumb()
                                        .addChangeHandler(this::showNotification)))
                );
    }

    @SampleMethod
    private void initColors() {
        colorsSlidersCard
                .appendChild(Row.create()
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.RED).setThumbColor(Color.RED)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.RED_LIGHTEN_4).setThumbColor(Color.RED_DARKEN_4)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setThumbColor(Color.RED)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.GREEN).setThumbColor(Color.GREEN)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.GREEN_LIGHTEN_4).setThumbColor(Color.GREEN_DARKEN_4)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setThumbColor(Color.GREEN)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.BLUE).setThumbColor(Color.BLUE)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.BLUE_LIGHTEN_4).setThumbColor(Color.BLUE_DARKEN_4)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setThumbColor(Color.BLUE)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.PURPLE).setThumbColor(Color.PURPLE)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.PURPLE_LIGHTEN_4).setThumbColor(Color.PURPLE_DARKEN_4)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setThumbColor(Color.PURPLE)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.ORANGE).setThumbColor(Color.ORANGE)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.ORANGE_LIGHTEN_4).setThumbColor(Color.ORANGE_DARKEN_4)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setThumbColor(Color.ORANGE)))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.CYAN).setThumbColor(Color.CYAN)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setBackgroundColor(Color.CYAN_LIGHTEN_4).setThumbColor(Color.CYAN_DARKEN_4)))
                        .addColumn(Column.span4().appendChild(Slider.create(100).setThumbColor(Color.CYAN)))
                );
    }

    @SampleMethod
    private void initExample() {
        HTMLDivElement rgbColorsDiv = div()
                .style("height: 190px;")
                .element();

        Slider redSlider = Slider.create(255, 0)
                .style()
                .setMarginTop("17px")
                .get()
                .anyStep()
                .withoutThumb()
                .setThumbColor(Color.RED_DARKEN_2)
                .setBackgroundColor(Color.RED_LIGHTEN_3);
        Slider greenSlider = Slider.create(255, 0)
                .style()
                .setMarginTop("17px")
                .get()
                .anyStep()
                .withoutThumb()
                .setThumbColor(Color.GREEN_DARKEN_2)
                .setBackgroundColor(Color.GREEN_LIGHTEN_3);
        Slider blueSlider = Slider.create(255, 0)
                .style()
                .setMarginTop("17px")
                .get()
                .anyStep()
                .withoutThumb()
                .setThumbColor(Color.BLUE_DARKEN_2)
                .setBackgroundColor(Color.BLUE_LIGHTEN_3);

        TextBox redTextBox = TextBox.create()
                .addChangeHandler(value -> {
                    redSlider.setValue(Double.parseDouble(value), true);
                    updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
                });
        TextBox greenTextBox = TextBox.create()
                .addChangeHandler(value -> {
                    greenSlider.setValue(Double.parseDouble(value), true);
                    updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
                });
        TextBox blueTextBox = TextBox.create()
                .addChangeHandler(value -> {
                    blueSlider.setValue(Double.parseDouble(value), true);
                    updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
                });


        HTMLDivElement colorsDiv = div()
                .add(rgbColorsDiv)
                .add(Row.create()
                        .style()
                        .setMarginTop("20px")
                        .get()
                        .addColumn(Column.span4()
                                .appendChild(Row.create()
                                        .addColumn(Column.span2().appendChild(h(5).textContent("R")))
                                        .addColumn(Column.span10().appendChild(redTextBox))
                                ))
                        .addColumn(Column.span4()
                                .appendChild(Row.create()
                                        .addColumn(Column.span2().appendChild(h(5).textContent("G")))
                                        .addColumn(Column.span10().appendChild(greenTextBox))
                                ))
                        .addColumn(Column.span4()
                                .appendChild(Row.create()
                                        .addColumn(Column.span2().appendChild(h(5).textContent("B")))
                                        .addColumn(Column.span10().appendChild(blueTextBox))
                                ))
                        .element())
                .element();

        redSlider.addSlideHandler(value -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });
        redSlider.addChangeHandler(value -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });

        greenSlider.addSlideHandler(value -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });
        greenSlider.addChangeHandler(value -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });

        blueSlider.addSlideHandler(value -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });
        blueSlider.addChangeHandler(value -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });

        redSlider.setValue(255);
        greenSlider.setValue(0);
        blueSlider.setValue(0);

        TextBox stepTextBox = TextBox.create("STEP").value("any")
                .addChangeHandler(value -> {
                    if ("any".equalsIgnoreCase(value)) {
                        redSlider.anyStep();
                        greenSlider.anyStep();
                        blueSlider.anyStep();
                    } else {
                        redSlider.setStep(Double.parseDouble(value));
                        greenSlider.setStep(Double.parseDouble(value));
                        blueSlider.setStep(Double.parseDouble(value));
                    }
                });
        SwitchButton thumbSwitch = SwitchButton.create()
                .setOffTitle("Without thumb")
                .setOnTitle("With thumb")
                .addChangeHandler(value -> {
                    redSlider.setWithThumb(value);
                    greenSlider.setWithThumb(value);
                    blueSlider.setWithThumb(value);
                });

        sampleCard
                .setBodyPaddingTop("40px")
                .appendChild(Row.create()
                        .addColumn(Column.span3()
                                .appendChild(stepTextBox))
                        .addColumn(Column.span3()
                                .appendChild(thumbSwitch))
                )
                .appendChild(Row.create()
                        .addColumn(Column.span4()
                                .appendChild(Row.create()
                                        .addColumn(Column.span12()
                                                .appendChild(Row.create()
                                                        .addColumn(Column.span1()
                                                                .appendChild(h(4).textContent("R")))
                                                        .addColumn(Column.span11()
                                                                .centerContent()
                                                                .appendChild(redSlider))
                                                ))
                                        .addColumn(Column.span12()
                                                .appendChild(Row.create()
                                                        .addColumn(Column.span1()
                                                                .appendChild(h(4).textContent("G")))
                                                        .addColumn(Column.span11()
                                                                .centerContent()
                                                                .appendChild(greenSlider))
                                                ))
                                        .addColumn(Column.span12()
                                                .appendChild(Row.create()
                                                        .addColumn(Column.span1()
                                                                .appendChild(h(4).textContent("B")))
                                                        .addColumn(Column.span11()
                                                                .centerContent()
                                                                .appendChild(blueSlider))
                                                )))
                        )
                        .addColumn(Column.span8()
                                .appendChild(colorsDiv))
                );
    }

    private void updateColorAndTextBoxes(HTMLDivElement rgbColorsDiv, Slider redSlider, Slider greenSlider, Slider blueSlider, TextBox redTextBox, TextBox greenTextBox, TextBox blueTextBox) {
        updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
        redTextBox.setValue(redSlider.getValue() + "");
        greenTextBox.setValue(greenSlider.getValue() + "");
        blueTextBox.setValue(blueSlider.getValue() + "");
    }

    private void updateBackgroundColor(HTMLDivElement rgbColorsDiv, Slider redSlider, Slider greenSlider, Slider blueSlider) {
        rgbColorsDiv.style.background = "rgb(" + redSlider.getValue()+ ", " + greenSlider.getValue() + ", " + blueSlider.getValue() + ")";
    }

    private void showNotification(Double value) {
        Notification.createInfo("Value " + value + " out of 200").show();
    }

}