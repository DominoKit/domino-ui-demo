package org.dominokit.domino.preloaders.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.preloaders.client.presenters.PreloadersProxy;
import org.dominokit.domino.preloaders.client.views.CodeResource;
import org.dominokit.domino.preloaders.client.views.PreloadersView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.preloaders.Preloader;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = PreloadersProxy.class)
@SampleClass
public class PreloadersViewImpl extends BaseDemoView<HTMLDivElement> implements PreloadersView {

    private DivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div();

        element.appendChild(LinkToSourceCode.createLink("preloaders", this.getClass()));
        element.appendChild(BlockHeader.create("PRELOADERS"));

        sizesSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.sizesSample()));
        colorsSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.colorsSample()));

        return element.element();
    }

    @SampleMethod
    private void sizesSample() {
        element.appendChild(Card.create("PRELOADERS - DIFFERENT SIZES")
                .appendChild(div().addCss(dui_flex, dui_gap_4, dui_items_center)
                        .appendChild(Preloader.create()
                                .addCss(dui_xlarge))
                        .appendChild(Preloader.create()
                                .addCss(dui_large))
                        .appendChild(Preloader.create()
                                .addCss(dui_medium))
                        .appendChild(Preloader.create()
                                .addCss(dui_small))
                        .appendChild(Preloader.create()
                                .addCss(dui_xsmall))
                )
        );
    }

    @SampleMethod
    private void colorsSample() {

        element.appendChild(Card.create("WITH MATERIAL DESIGN COLORS", "You can use the material design colors.")
                .appendChild(div().addCss(dui_flex, dui_gap_4)
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_red))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_black))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_blue_grey))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_blue))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_grey))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_brown))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_deep_orange))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_orange))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_lime))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_light_green))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_teal))
                        .appendChild(Preloader.create()
                                .addCss(dui_fg_indigo)))
        );
    }
}