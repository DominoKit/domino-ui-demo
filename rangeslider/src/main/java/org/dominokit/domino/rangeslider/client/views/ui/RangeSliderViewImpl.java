package org.dominokit.domino.rangeslider.client.views.ui;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.rangeslider.client.presenters.RangeSliderProxy;
import org.dominokit.domino.rangeslider.client.views.RangeSliderView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.config.SlidersConfig;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.sliders.ThumbStyle;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.pro.domino.ui.sliders.RangeSlider;
import org.gwtproject.i18n.client.NumberFormat;

import static org.dominokit.domino.ui.utils.Domino.div;

@UiView(presentable = RangeSliderProxy.class)
@SampleClass
public class RangeSliderViewImpl extends BaseDemoView<HTMLDivElement> implements RangeSliderView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("rangeslider", this.getClass()));
        element.appendChild(BlockHeader.create("Range slider"));

        rangeSlider();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.rangeSlider()));

        return element.element();
    }

    @SampleMethod
    private void rangeSlider() {
        element
                .appendChild(Card.create("INLINE CALENDAR", "Different locales")
                        .appendChild(RangeSlider.create(0, 100))
                        .appendChild(RangeSlider.create(0, 100, 20)
                                .withThumb()
                        )
                        .appendChild(RangeSlider.create(0, 100)
                                .withThumb()
                                .setAutoHideThumb(false)
                                .setThumbStyle(ThumbStyle.FLAT)
                                .setConfig(new SlidersConfig() {
                                    @Override
                                    public String formatSliderThumbValue(double value) {
                                        return NumberFormat.getFormat("#0.000").format(value);
                                    }
                                })
                                .addChangeListener((oldValue, newValue) -> {
                                    DomGlobal.console.info("Old : " + oldValue + " New : " + newValue);
                                })
                        )
                        .appendChild(RangeSlider.create(0, 100, 20, 70, 10)
                                .withThumb()
                        )
                );
    }

}