package org.dominokit.domino.sliders.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.sliders.client.presenters.SlidersProxy;
import org.dominokit.domino.sliders.client.views.SlidersView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.forms.SwitchButton;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.domino.ui.sliders.Slider;
import org.dominokit.domino.ui.style.SpacingCss;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = SlidersProxy.class)
@SampleClass
public class SlidersViewImpl extends BaseDemoView<HTMLDivElement> implements SlidersView {

    private DivElement element;
    private Card basicCard;
    private Card colorsSlidersCard;
    private Card sampleCard;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("sliders", this.getClass()));
        basicCard = Card.create("BASIC SLIDERS");
        colorsSlidersCard = Card.create("SLIDERS WITH COLORS");
        sampleCard = Card.create("SLIDERS EXAMPLE");

        initBasic();
        initColors();
        initExample();

        element.appendChild(BlockHeader.create("SLIDERS"));
        element.appendChild(basicCard);
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initBasic()));
        element.appendChild(colorsSlidersCard);
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initColors()));
        element.appendChild(sampleCard);
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initExample()));

        return element.element();
    }

    @SampleMethod
    private void initBasic() {
        basicCard
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("SIMPLE SLIDERS")))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(Slider.create(200)
                                        .setShowThumb(true)
                                        .addChangeListener((oldValue, newValue) -> showNotification(newValue))
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(hr())))

                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("SLIDERS WITH THUMB")))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(Slider.create(200, 20)
                                        .setValue(50)
                                        .setReadOnly(true)
                                        .withThumb()
                                        .addChangeListener((oldValue, newValue) -> showNotification(newValue))
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(hr())))

                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("SLIDERS CAN HAVE MIN AND MAX VALUES")
                                        .appendChild(span().textContent("Min: 100").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("Max: 200").element())
                                ))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(Slider.create(200, 100)
                                        .setValue(150)
                                        .withThumb()
                                        .addChangeListener((oldValue, newValue) -> showNotification(newValue))
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(hr())))

                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("SLIDERS WITH STEP")
                                        .appendChild(span().textContent("MIN: 100").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("MAX: 200").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("STEP: 10").element())
                                ))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(Slider.create(200, 100)
                                        .setStep(10)
                                        .withThumb()
                                        .addChangeListener((oldValue, newValue) -> showNotification(newValue))
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(hr())))

                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(BlockHeader.create("SLIDERS WITH ANY STEP")
                                        .appendChild(span().textContent("MIN: 100").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("MAX: 200").element())
                                        .appendChild(br().element())
                                        .appendChild(span().textContent("STEP: ANY").element())
                                ))
                )
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(Slider.create(200, 100)
                                        .anyStep()
                                        .setShowThumb(true)
                                        .addChangeListener((oldValue, newValue) -> showNotification(newValue))
                                )
                        )
                );
    }

    @SampleMethod
    private void initColors() {
        colorsSlidersCard
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100).addCss(dui_accent_red))
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .addCss(dui_accent_red)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_red_d_2, dui_fg))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_red_d_2, dui_fg))
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100).addCss(dui_accent_green))
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .addCss(dui_accent_green)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_green_d_2, dui_fg))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_green_d_2, dui_fg))
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100).addCss(dui_accent_blue))
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .addCss(dui_accent_blue)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_blue_d_2, dui_fg))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_blue_d_2, dui_fg))
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100).addCss(dui_accent_purple))
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .addCss(dui_accent_purple)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_purple_d_2, dui_fg))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_purple_d_2, dui_fg))
                                )
                        )
                )
                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100).addCss(dui_accent_orange))
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .addCss(dui_accent_orange)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_orange_d_2, dui_fg))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_orange_d_2, dui_fg))
                                )
                        )
                )

                .appendChild(Row.create()
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100).addCss(dui_accent_cyan))
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .addCss(dui_accent_cyan)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_cyan_d_2, dui_fg))
                                )
                        )
                        .appendChild(Column.span4()
                                .appendChild(Slider.create(100)
                                        .withThumb((parent, thumb) -> thumb.addCss(dui_bg_cyan_d_2, dui_fg))
                                )
                        )
                );
    }

    @SampleMethod
    private void initExample() {
        DivElement rgbColorsDiv = div()
                .addCss(dui_h_full, dui_w_full);

        Slider redSlider = Slider.create(255, 0)
                .addCss(dui_accent_red)
                .anyStep()
                .setShowThumb(false);
        Slider greenSlider = Slider.create(255, 0)
                .addCss(dui_accent_green)
                .anyStep()
                .setShowThumb(false);;
        Slider blueSlider = Slider.create(255, 0)
                .addCss(dui_accent_blue)
                .anyStep()
                .setShowThumb(false);;

        TextBox redTextBox = TextBox.create()
                .addChangeListener((oldValue, value) -> {
                    redSlider.setValue(Double.parseDouble(value), true);
                    updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
                });
        TextBox greenTextBox = TextBox.create()
                .addChangeListener((oldValue, value) -> {
                    greenSlider.setValue(Double.parseDouble(value), true);
                    updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
                });
        TextBox blueTextBox = TextBox.create()
                .addChangeListener((oldValue, value) -> {
                    blueSlider.setValue(Double.parseDouble(value), true);
                    updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
                });


        redSlider.addChangeListener((oldValue,value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });
        redSlider.addChangeListener((oldValue,value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });

        greenSlider.addChangeListener((oldValue,value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });
        greenSlider.addChangeListener((oldValue,value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });

        blueSlider.addChangeListener((oldValue,value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });
        blueSlider.addChangeListener((oldValue,value) -> {
            updateColorAndTextBoxes(rgbColorsDiv, redSlider, greenSlider, blueSlider, redTextBox, greenTextBox, blueTextBox);
        });

        redSlider.setValue(0);
        greenSlider.setValue(128);
        blueSlider.setValue(128);

        TextBox stepTextBox = TextBox.create("Step")
                .withValue("any")
                .addChangeListener((oldValue, value) -> {
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
                .setLabel("Show thumb")
                .setOffTitle("No")
                .setOnTitle("Yes")
                .addChangeListener((oldValue, value) -> {
                    redSlider.setShowThumb(value);
                    greenSlider.setShowThumb(value);
                    blueSlider.setShowThumb(value);
                });

        sampleCard
                .withBody((parent, body) -> body.addCss(dui_p_10))
                .appendChild(Row.create()
                        .addCss(dui_gap_4)
                        .span6(rgbColorsDiv)
                        .span6(div().addCss(dui_flex, dui_flex_col)
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(stepTextBox)
                                        .appendChild(thumbSwitch)
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("R"))
                                        .appendChild(redSlider.addCss(dui_grow_1))
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("G"))
                                        .appendChild(greenSlider.addCss(dui_grow_1))
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("B"))
                                        .appendChild(blueSlider.addCss(dui_grow_1))
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("R"))
                                        .appendChild(redTextBox)
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("G"))
                                        .appendChild(greenTextBox)
                                )
                                .appendChild(div()
                                        .addCss(dui_flex, dui_gap_4, dui_items_center)
                                        .appendChild(h(4).textContent("B"))
                                        .appendChild(blueTextBox)
                                )
                        )

                );
    }

    private void showNotification(Double value) {
        Notification.create("Value " + value + " out of 200").addCss(dui_info).show();
    }

    private void updateBackgroundColor(DivElement rgbColorsDiv, Slider redSlider, Slider greenSlider, Slider blueSlider) {
        rgbColorsDiv.setBackgroundColor("rgb(" + redSlider.getValue() + ", " + greenSlider.getValue() + ", " + blueSlider.getValue() + ")");
    }

    private void updateColorAndTextBoxes(DivElement rgbColorsDiv, Slider redSlider, Slider greenSlider, Slider blueSlider, TextBox redTextBox, TextBox greenTextBox, TextBox blueTextBox) {
        updateBackgroundColor(rgbColorsDiv, redSlider, greenSlider, blueSlider);
        redTextBox.setValue(String.valueOf(redSlider.getValue()));
        greenTextBox.setValue(String.valueOf(greenSlider.getValue()));
        blueTextBox.setValue(String.valueOf(blueSlider.getValue()));
    }

}