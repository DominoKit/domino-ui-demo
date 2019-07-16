package org.dominokit.domino.splitPanel.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.splitPanel.client.presenters.SplitPanelProxy;
import org.dominokit.domino.splitPanel.client.views.SplitPanelView;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.splitpanel.HSplitPanel;
import org.dominokit.domino.ui.splitpanel.SplitPanel;
import org.dominokit.domino.ui.splitpanel.VSplitPanel;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;

import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.hr;

@UiView(presentable = SplitPanelProxy.class)
@SampleClass
public class SplitPanelViewImpl extends BaseDemoView<HTMLDivElement> implements SplitPanelView {

    private HTMLDivElement element = div().asElement();

    @Override
    protected void init(HTMLDivElement root) {
        element.appendChild(LinkToSourceCode.create("splitPanel", this.getClass()).asElement());
        element.appendChild(BlockHeader.create("SPLIT PANEL").asElement());

        horizontalSplitPanel();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.horizontalSplitPanel()).asElement());

        verticalSplitPanel();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.verticalSplitPanel()).asElement());


        splitPanelMinMax();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.splitPanelMinMax()).asElement());

        multiSplit();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.multiSplit()).asElement());

        combined();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.combined()).asElement());
    }

    @Override
    public HTMLDivElement createRoot() {
        element = div().asElement();
        return element;
    }

    @SampleMethod
    private void horizontalSplitPanel() {

        element.appendChild(Card.create("HORIZONTAL SPLIT PANEL")
                .appendChild(HSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .appendChild(div().css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                        .appendChild(SplitPanel.create()
                                .appendChild(div().css("demo-split-div", Color.BLUE_GREY_LIGHTEN_5.getBackground())))
                        .setHeight("400px")
                )
                .asElement());


    }

    @SampleMethod
    private void verticalSplitPanel() {
        element.appendChild(Card.create("VERTICAL SPLIT PANEL")
                .appendChild(VSplitPanel.create()
                        .setColorScheme(ColorScheme.TEAL)
                        .appendChild(SplitPanel.create()
                                .appendChild(div().css("demo-split-div", Color.GREEN_LIGHTEN_5.getBackground())))
                        .appendChild(SplitPanel.create()
                                .appendChild(div().css("demo-split-div", Color.GREEN_LIGHTEN_4.getBackground())))
                        .setHeight("400px")
                )
                .asElement());


    }

    @SampleMethod
    private void splitPanelMinMax() {
        element.appendChild(Card.create("SPLIT PANEL MIN & MAX")
                .appendChild(HSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .setMinPercent(20)
                                .setMaxPercent(70)
                                .appendChild(div().css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .appendChild(div().css("demo-split-div", Color.BLUE_GREY_LIGHTEN_5.getBackground())))
                        .setHeight("400px")
                )
                .appendChild(hr())
                .appendChild(VSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .setMinPercent(20)
                                .setMaxPercent(70)
                                .appendChild(div().css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .appendChild(div().css("demo-split-div", Color.BLUE_GREY_LIGHTEN_5.getBackground())))
                        .setHeight("400px")
                )
                .asElement());


    }

    @SampleMethod
    private void multiSplit() {
        element.appendChild(Card.create("MULTI SPLIT")
                .appendChild(HSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setWidth("20%")
                                .appendChild(div()
                                        .css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .appendChild(div().css("demo-split-div", Color.BLUE_GREY_LIGHTEN_5.getBackground())))
                        .appendChild(SplitPanel.create()
                                .setWidth("30%")
                                .appendChild(div().css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                        .setHeight("400px")
                )
                .appendChild(hr())
                .appendChild(VSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setHeight("20%")
                                .appendChild(div().css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                        .appendChild(SplitPanel.create()
                                .setHeight("50%")
                                .appendChild(div().css("demo-split-div", Color.BLUE_GREY_LIGHTEN_5.getBackground())))
                        .appendChild(SplitPanel.create()
                                .setHeight("30%")
                                .appendChild(div().css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                        .setHeight("400px")
                )
                .asElement());


    }

    @SampleMethod
    private void combined() {
        element.appendChild(Card.create("COMBINED SPLIT PANELS")
                .appendChild(HSplitPanel.create()
                        .appendChild(SplitPanel.create()
                                .setWidth("20%")
                                .appendChild(div().css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                        .appendChild(SplitPanel.create()
                                .setWidth("50%")
                                .appendChild(VSplitPanel.create()
                                        .appendChild(SplitPanel.create()
                                                .setHeight("20%")
                                                .appendChild(div().css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                                        .appendChild(SplitPanel.create()
                                                .setHeight("50%")
                                                .appendChild(div().css("demo-split-div", Color.BLUE_GREY_LIGHTEN_5.getBackground())))
                                        .appendChild(SplitPanel.create()
                                                .setHeight("30%")
                                                .appendChild(div().css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                                        .setHeight("100%")))
                        .appendChild(SplitPanel.create()
                                .setWidth("30%")
                                .appendChild(div().css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
                        .setHeight("400px")
                )
                .asElement());


    }
}