package org.dominokit.domino.colorpicker.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.colorpicker.client.presenters.ColorPickerProxy;
import org.dominokit.domino.colorpicker.client.views.ColorPickerView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.pro.domino.ui.colorpicker.ColorPicker;
import org.dominokit.pro.domino.ui.colorpicker.ColorPickerButton;

import static org.dominokit.domino.ui.utils.Domino.*;

@UiView(presentable = ColorPickerProxy.class)
@SampleClass
public class ColorPickerViewImpl extends BaseDemoView<HTMLDivElement> implements ColorPickerView {

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {

        element.appendChild(LinkToSourceCode.createLink("color-picker", ColorPickerViewImpl.class));
        element.appendChild(BlockHeader.create("Color picker")
                .element());

        inlinedColorPicker();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.inlinedColorPicker()));

        colorPickerButton();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.colorPickerButton()));

        popupColorPicker();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.popupColorPicker()));

        return element.element();
    }

    @SampleMethod
    private void inlinedColorPicker() {
        element.appendChild(Card.create("BASIC PICKER", "Inlined color picker")
                .appendChild(ColorPicker.create()
                )
        );
    }

    @SampleMethod
    private void colorPickerButton() {
        element.appendChild(Card.create("PICKER BUTTON", "Color picker button")
                .appendChild(ColorPickerButton.create("Pick color").addCss(dui_accent))
        );
    }

    @SampleMethod
    private void popupColorPicker() {
        element.appendChild(Card.create("Popover picker", "Color picker in a popover.")
                .appendChild(div().addCss(dui_w_4, dui_h_4, dui_border, dui_border_solid, dui_border_black)
                        .apply(self -> {
                            Popover.create(self)
                                    .addCss(dui_rounded_md)
                                    .appendChild(div().addCss(dui_p_2)
                                            .appendChild(ColorPicker.create().addCss(dui_w_64))
                                    );
                        })
                )
        );
    }

}