package org.dominokit.domino.splitPanel.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.splitPanel.client.presenters.SplitPanelProxy;
import org.dominokit.domino.splitPanel.client.views.SplitPanelView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.splitpanel.HSplitPanel;
import org.dominokit.domino.ui.splitpanel.SplitPanel;
import org.dominokit.domino.ui.splitpanel.VSplitPanel;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.typography.BlockHeader;

@UiView(presentable = SplitPanelProxy.class)
@SampleClass
public class SplitPanelViewImpl extends BaseDemoView<HTMLDivElement> implements SplitPanelView {

    private final CssClass demo_split_div = () -> "demo-split-div";
    private HTMLDivElement element = div().element();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.createLink("splitPanel", this.getClass()).element());
        element.appendChild(BlockHeader.create("SPLIT PANEL").element());

        horizontalSplitPanel();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.horizontalSplitPanel()).element());

        verticalSplitPanel();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.verticalSplitPanel()).element());


        splitPanelMinMax();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.splitPanelMinMax()).element());

        multiSplit();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.multiSplit()).element());

        combined();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.combined()).element());

        return element;
    }

    @SampleMethod
    private void horizontalSplitPanel() {

        element.appendChild(Card.create("HORIZONTAL SPLIT PANEL")
                .appendChild(HSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_d_2)))
                        .addCss(dui_h_96, dui_w_full)
                )
                .element());
    }

    @SampleMethod
    private void verticalSplitPanel() {
        element.appendChild(Card.create("VERTICAL SPLIT PANEL")
                .appendChild(VSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_d_2)))
                        .addCss(dui_h_96, dui_w_full)
                )
                .element());
    }

    @SampleMethod
    private void splitPanelMinMax() {
        element.appendChild(Card.create("SPLIT PANEL MIN & MAX")
                .appendChild(HSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .setMinPercent(20)
                                .setMaxPercent(70)
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_d_2)))
                        .addCss(dui_h_96, dui_w_full)
                )
                .appendChild(hr())
                .appendChild(VSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .setMinPercent(20)
                                .setMaxPercent(70)
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_d_2)))
                        .addCss(dui_h_96, dui_w_full)
                )
                .element());


    }

    @SampleMethod
    private void multiSplit() {
        element.appendChild(Card.create("MULTI SPLIT")
                .appendChild(HSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setWidth("20%")
                                .appendChild(div()
                                        .addCss(demo_split_div, dui_bg_accent_l_2)))
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_d_2)))
                        .appendChild(SplitPanel.create()
                                .setWidth("30%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .addCss(dui_h_96, dui_w_full)
                )
                .appendChild(hr())
                .appendChild(VSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setHeight("20%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_d_2)))
                        .appendChild(SplitPanel.create()
                                .setHeight("30%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .addCss(dui_h_96, dui_w_full)
                )
                .element());
    }

    @SampleMethod
    private void combined() {
        element.appendChild(Card.create("COMBINED SPLIT PANELS")
                .appendChild(HSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setWidth("20%")
                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .appendChild(VSplitPanel.create()
                                        .appendChild(SplitPanel.create()
                                                .setHeight("20%")
                                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                                        .appendChild(SplitPanel.create()
                                                .setHeight("50%")
                                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_d_2)))
                                        .appendChild(SplitPanel.create()
                                                .setHeight("30%")
                                                .appendChild(div().addCss(demo_split_div, dui_bg_accent_l_2)))
                                        .addCss(dui_h_full, dui_w_full)
                                ))
                        .appendChild(SplitPanel.create()
                                .setWidth("30%")
                                .appendChild(div().addCss(demo_split_div,dui_bg_accent_l_2)))
                        .addCss(dui_h_96, dui_w_full)
                )
                .element());


    }
}