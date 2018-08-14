package org.dominokit.domino.sliders.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.shared.extension.ComponentView;
import org.dominokit.domino.sliders.client.presenters.SlidersPresenter;
import org.dominokit.domino.sliders.client.views.CodeResource;
import org.dominokit.domino.sliders.client.views.SlidersView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;

import static org.jboss.gwt.elemento.core.Elements.*;

@UiView(presentable = SlidersPresenter.class)
public class SlidersViewImpl extends ComponentView<HTMLDivElement> implements SlidersView {

    private HTMLDivElement container = div().asElement();
    private Card basicCard;
    private Card colorsSlidersCard;
    private Card sampleCard;

    @Override
    public void init() {
        basicCard = Card.create("SLIDERS");
        colorsSlidersCard = Card.create("SLIDERS WITH COLORS");
        sampleCard = Card.create("SLIDERS EXAMPLE");

        initBasic();
        initColors();
        initExample();

        container.appendChild(basicCard.asElement());
        container.appendChild(Card.createCodeCard(CodeResource.INSTANCE.basic()).asElement());
        container.appendChild(colorsSlidersCard.asElement());
        container.appendChild(Card.createCodeCard(CodeResource.INSTANCE.colors()).asElement());
        container.appendChild(sampleCard.asElement());
        container.appendChild(Card.createCodeCard(CodeResource.INSTANCE.example()).asElement());
    }

    private void initBasic() {
        basicCard
                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(BlockHeader.create("SIMPLE SLIDERS")))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(Slider.create(200)
                                        .withoutThumb()
                                        .addChangeHandler(this::showNotification)))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(hr())))

                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(BlockHeader.create("SLIDERS WITH THUMB")))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(Slider.create(200, 20)
                                        .setValue(50)
                                        .withThumb()
                                        .addChangeHandler(this::showNotification)))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(hr())))

                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(BlockHeader.create("SLIDERS CAN HAVE MIN AND MAX VALUES")
                                        .appendContent(span().textContent("Min: 100").asElement())
                                        .appendContent(br().asElement())
                                        .appendContent(span().textContent("Max: 200").asElement())
                                ))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(Slider.create(200, 100)
                                        .setValue(150)
                                        .withThumb()
                                        .addChangeHandler(this::showNotification)))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(hr())))

                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(BlockHeader.create("SLIDERS WITH STEP")
                                        .appendContent(span().textContent("MIN: 100").asElement())
                                        .appendContent(br().asElement())
                                        .appendContent(span().textContent("MAX: 200").asElement())
                                        .appendContent(br().asElement())
                                        .appendContent(span().textContent("STEP: 10").asElement())
                                ))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(Slider.create(200, 100)
                                        .setStep(10)
                                        .withThumb()
                                        .addChangeHandler(this::showNotification)))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(hr())))

                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(BlockHeader.create("SLIDERS WITH ANY STEP")
                                        .appendContent(span().textContent("MIN: 100").asElement())
                                        .appendContent(br().asElement())
                                        .appendContent(span().textContent("MAX: 200").asElement())
                                        .appendContent(br().asElement())
                                        .appendContent(span().textContent("STEP: ANY").asElement())
                                ))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span12()
                                .addElement(Slider.create(200, 100)
                                        .anyStep()
                                        .withoutThumb()
                                        .addChangeHandler(this::showNotification)))
                );
    }

    private void initColors() {
        colorsSlidersCard
                .appendContent(Row.create()
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.RED).setThumbColor(Color.RED)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.RED_LIGHTEN_4).setThumbColor(Color.RED_DARKEN_4)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setThumbColor(Color.RED)))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.GREEN).setThumbColor(Color.GREEN)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.GREEN_LIGHTEN_4).setThumbColor(Color.GREEN_DARKEN_4)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setThumbColor(Color.GREEN)))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.BLUE).setThumbColor(Color.BLUE)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.BLUE_LIGHTEN_4).setThumbColor(Color.BLUE_DARKEN_4)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setThumbColor(Color.BLUE)))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.PURPLE).setThumbColor(Color.PURPLE)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.PURPLE_LIGHTEN_4).setThumbColor(Color.PURPLE_DARKEN_4)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setThumbColor(Color.PURPLE)))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.ORANGE).setThumbColor(Color.ORANGE)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.ORANGE_LIGHTEN_4).setThumbColor(Color.ORANGE_DARKEN_4)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setThumbColor(Color.ORANGE)))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.CYAN).setThumbColor(Color.CYAN)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setBackgroundColor(Color.CYAN_LIGHTEN_4).setThumbColor(Color.CYAN_DARKEN_4)))
                        .addColumn(Column.span4().addElement(Slider.create(100).setThumbColor(Color.CYAN)))
                );
    }

    private void initExample() {
        HTMLDivElement rgbColorsDiv = div()
                .style("height: 190px;")
                .asElement();

        Slider redSlider = Style.of(Slider.create(255, 0))
                .setMarginTop("17px")
                .get()
                .anyStep()
                .withoutThumb()
                .setThumbColor(Color.RED_DARKEN_2)
                .setBackgroundColor(Color.RED_LIGHTEN_3);
        Slider greenSlider = Style.of(Slider.create(255, 0))
                .setMarginTop("17px")
                .get()
                .anyStep()
                .withoutThumb()
                .setThumbColor(Color.GREEN_DARKEN_2)
                .setBackgroundColor(Color.GREEN_LIGHTEN_3);
        Slider blueSlider = Style.of(Slider.create(255, 0))
                .setMarginTop("17px")
                .get()
                .anyStep()
                .withoutThumb()
                .setThumbColor(Color.BLUE_DARKEN_2)
                .setBackgroundColor(Color.BLUE_LIGHTEN_3);

        TextBox redTextBox = TextBox.create()
                .addChangeHandler(value -> {
                    redSlider.setValue(Double.parseDouble(value));
                });
        TextBox greenTextBox = TextBox.create()
                .addChangeHandler(value -> {
                    greenSlider.setValue(Double.parseDouble(value));
                });
        TextBox blueTextBox = TextBox.create()
                .addChangeHandler(value -> {
                    blueSlider.setValue(Double.parseDouble(value));
                });


        HTMLDivElement colorsDiv = div()
                .add(rgbColorsDiv)
                .add(Row.create()
                        .style()
                        .setMarginTop("20px")
                        .get()
                        .addColumn(Column.span4()
                                .addElement(Row.create()
                                        .addColumn(Column.span2().addElement(h(5).textContent("R")))
                                        .addColumn(Column.span10().addElement(redTextBox))
                                ))
                        .addColumn(Column.span4()
                                .addElement(Row.create()
                                        .addColumn(Column.span2().addElement(h(5).textContent("G")))
                                        .addColumn(Column.span10().addElement(greenTextBox))
                                ))
                        .addColumn(Column.span4()
                                .addElement(Row.create()
                                        .addColumn(Column.span2().addElement(h(5).textContent("B")))
                                        .addColumn(Column.span10().addElement(blueTextBox))
                                ))
                        .asElement())
                .asElement();

        redSlider.addSlideHandler(value -> {
            rgbColorsDiv.style.background = "rgb(" + value + ", " + greenSlider.getValue() + ", " + blueSlider.getValue() + ")";
            redTextBox.setValue(redSlider.getValue() + "");
            greenTextBox.setValue(greenSlider.getValue() + "");
            blueTextBox.setValue(blueSlider.getValue() + "");
        });
        redSlider.addChangeHandler(value -> {
            rgbColorsDiv.style.background = "rgb(" + value + ", " + greenSlider.getValue() + ", " + blueSlider.getValue() + ")";
            redTextBox.setValue(redSlider.getValue() + "");
            greenTextBox.setValue(greenSlider.getValue() + "");
            blueTextBox.setValue(blueSlider.getValue() + "");
        });

        greenSlider.addSlideHandler(value -> {
            rgbColorsDiv.style.background = "rgb(" + redSlider.getValue() + ", " + value + ", " + blueSlider.getValue() + ")";
            redTextBox.setValue(redSlider.getValue() + "");
            greenTextBox.setValue(greenSlider.getValue() + "");
            blueTextBox.setValue(blueSlider.getValue() + "");
        });
        greenSlider.addChangeHandler(value -> {
            rgbColorsDiv.style.background = "rgb(" + redSlider.getValue() + ", " + value + ", " + blueSlider.getValue() + ")";
            redTextBox.setValue(redSlider.getValue() + "");
            greenTextBox.setValue(greenSlider.getValue() + "");
            blueTextBox.setValue(blueSlider.getValue() + "");
        });

        blueSlider.addSlideHandler(value -> {
            rgbColorsDiv.style.background = "rgb(" + redSlider.getValue() + ", " + greenSlider.getValue() + ", " + value + ")";
            redTextBox.setValue(redSlider.getValue() + "");
            greenTextBox.setValue(greenSlider.getValue() + "");
            blueTextBox.setValue(blueSlider.getValue() + "");
        });
        blueSlider.addChangeHandler(value -> {
            rgbColorsDiv.style.background = "rgb(" + redSlider.getValue() + ", " + greenSlider.getValue() + ", " + value + ")";
            redTextBox.setValue(redSlider.getValue() + "");
            greenTextBox.setValue(greenSlider.getValue() + "");
            blueTextBox.setValue(blueSlider.getValue() + "");
        });

        redSlider.setValue(255);
        greenSlider.setValue(0);
        blueSlider.setValue(0);

        TextBox stepTextBox = TextBox.create("STEP").setValue("any")
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
                .appendContent(Row.create()
                        .addColumn(Column.span3()
                                .addElement(stepTextBox))
                        .addColumn(Column.span3()
                                .addElement(thumbSwitch))
                )
                .appendContent(Row.create()
                        .addColumn(Column.span4()
                                .addElement(Row.create()
                                        .addColumn(Column.span12()
                                                .addElement(Row.create()
                                                        .addColumn(Column.span1()
                                                                .addElement(h(4).textContent("R")))
                                                        .addColumn(Column.span11()
                                                                .centerContent()
                                                                .addElement(redSlider))
                                                ))
                                        .addColumn(Column.span12()
                                                .addElement(Row.create()
                                                        .addColumn(Column.span1()
                                                                .addElement(h(4).textContent("G")))
                                                        .addColumn(Column.span11()
                                                                .centerContent()
                                                                .addElement(greenSlider))
                                                ))
                                        .addColumn(Column.span12()
                                                .addElement(Row.create()
                                                        .addColumn(Column.span1()
                                                                .addElement(h(4).textContent("B")))
                                                        .addColumn(Column.span11()
                                                                .centerContent()
                                                                .addElement(blueSlider))
                                                )))
                        )
                        .addColumn(Column.span8()
                                .addElement(colorsDiv))
                );
    }

    private void showNotification(Double value) {
        Notification.createInfo("Value " + value + " out of 200").show();
    }

    @Override
    public HTMLDivElement getElement() {
        return container;
    }
}