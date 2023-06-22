package org.dominokit.domino.collapse.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.collapse.client.presenters.CollapseProxy;
import org.dominokit.domino.collapse.client.views.CollapseView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.LinkButton;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.collapsible.Accordion;
import org.dominokit.domino.ui.collapsible.AccordionPanel;
import org.dominokit.domino.ui.collapsible.AnimationCollapseStrategy;
import org.dominokit.domino.ui.collapsible.CollapseDuration;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.collapsible.DisplayCollapseStrategy;
import org.dominokit.domino.ui.collapsible.HeightCollapseStrategy;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

@UiView(presentable = CollapseProxy.class)
@SampleClass
public class CollapseViewImpl extends BaseDemoView<HTMLDivElement> implements CollapseView {

    private static final String SAMPLE_CONTENT = "Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.";

    private DivElement element = div();

    @Override
    protected HTMLDivElement init() {
        element.appendChild(LinkToSourceCode.createLink("collapse", this.getClass()));

        example();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.example()));

        accordionSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.accordionSample()));

        colorFullWithIcons();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.colorFullWithIcons()));

        multiOpenItems();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.multiOpenItems()));

        return element.element();
    }

    @SampleMethod
    private void example() {

        element.appendChild(BlockHeader.create("COLLAPSE").element());
        DivElement heightDiv = div()
                .addCss(dui_h_24, dui_m_y_4)
                .appendChild(div()
                        .addCss(dui_bg_accent_l_5, dui_p_4)
                        .textContent(SAMPLE_CONTENT));

        DivElement displayDiv = div()
                .addCss(dui_h_24, dui_m_y_4)
                .appendChild(div()
                        .addCss(dui_bg_accent_l_5, dui_p_4)
                        .textContent(SAMPLE_CONTENT));

        DivElement animationDiv = div()
                .addCss(dui_h_24, dui_m_y_4)
                .appendChild(div()
                        .addCss(dui_bg_accent_l_5, dui_p_4)
                        .textContent(SAMPLE_CONTENT));

        Collapsible heightCollapsible = Collapsible.create(heightDiv)
                .setStrategy(new HeightCollapseStrategy(CollapseDuration._300ms));

        Collapsible displayCollapsible = Collapsible.create(displayDiv)
                .setStrategy(new DisplayCollapseStrategy());

        Collapsible animationCollapsible = Collapsible.create(animationDiv)
                .setStrategy(new AnimationCollapseStrategy(Transition.FADE_IN, Transition.FADE_OUT, CollapseDuration._500ms));

        Button heightCollapseButton = Button.create("Height collapse");
        heightCollapseButton.getClickableElement().addEventListener("click", evt -> heightCollapsible.toggleCollapse());

        Button displayCollapseButton = Button.create("Display collapse");
        displayCollapseButton.getClickableElement().addEventListener("click", evt -> displayCollapsible.toggleCollapse());

        Button animationCollapseButton = Button.create("Animation collapse");
        animationCollapseButton.getClickableElement().addEventListener("click", evt -> animationCollapsible.toggleCollapse());

        element
                .appendChild(Row.create()
                        .appendChild(Column.span12()
                                .appendChild(Card.create("EXAMPLE", "click the buttons below to show and hide another element via class changes.")
                                        .setCollapsible(true)
                                        .appendChild(Row.create()
                                                .appendChild(Column.span12()
                                                        .appendChild(heightCollapseButton
                                                                .addCss(dui_accent)
                                                        )
                                                        .appendChild(heightDiv)
                                                )
                                        )
                                        .appendChild(Row.create()
                                                .appendChild(Column.span12()
                                                        .appendChild(displayCollapseButton
                                                                .addCss(dui_accent)
                                                        )
                                                        .appendChild(displayDiv)
                                                )
                                        )
                                        .appendChild(Row.create()
                                                .appendChild(Column.span12()
                                                        .appendChild(animationCollapseButton
                                                                .addCss(dui_accent)
                                                        )
                                                        .appendChild(animationDiv)
                                                )
                                        )
                                )
                        )
                        .element()
                );
    }

    @SampleMethod
    private void accordionSample() {
        element.appendChild(BlockHeader.create("ACCORDION").element());
        element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .appendChild(Card.create("BASIC EXAMPLES", "Extend the default collapse behavior to create an accordion with the panel component.")
                                .setCollapsible(true)
                                .appendChild(b().textContent("Panel Accent"))
                                .appendChild(Accordion.create().addCss(dui_accent, dui_ignore_bg, dui_ignore_fg)
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_accent_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_accent_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_accent_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                )
                                .appendChild(b().textContent("Panel Primary"))
                                .appendChild(Accordion.create().addCss(dui_primary, dui_ignore_bg, dui_ignore_fg, dui_rounded_md)
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_primary_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_primary_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_primary_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                )
                                .appendChild(b().textContent("Panel Orange"))
                                .appendChild(Accordion.create().addCss(dui_orange, dui_ignore_bg, dui_ignore_fg)
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_orange_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_orange_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_orange_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        ))
                                .appendChild(b().textContent("Panel Teal").element())
                                .appendChild(Accordion.create().addCss(dui_teal, dui_ignore_bg, dui_ignore_fg)
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_teal_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_teal_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_teal_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                )
                        )
                )
                .appendChild(Column.span6()
                        .appendChild(Card.create("FULL BODY EXAMPLES", "If you want to also colorful body, you need to use fullBody method.")
                                .setCollapsible(true)
                                .appendChild(b().textContent("Panel Accent"))
                                .appendChild(Accordion.create().addCss(dui_accent)
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_accent_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_accent_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_accent_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        ))
                                .appendChild(b().textContent("Panel Primary"))
                                .appendChild(Accordion.create().addCss(dui_primary, dui_rounded_lg)
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_primary_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_primary_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_primary_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        ))
                                .appendChild(b().textContent("Panel Orange"))
                                .appendChild(Accordion.create().addCss(dui_orange)
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_orange_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_orange_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_orange_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                )
                                .appendChild(b().textContent("Panel Teal"))
                                .appendChild(Accordion.create().addCss(dui_teal)
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_teal_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_teal_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_teal_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                )
                        )
                )
        );
    }

    @SampleMethod
    private void colorFullWithIcons() {

        element.appendChild(Row.create()
                .appendChild(Column.span6()
                        .appendChild(Card.create("COLORFUL PANEL ITEMS WITH ICON")
                                .setCollapsible(true)
                                .appendChild(b().textContent("Panel Primary"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_accent)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_accent_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_primary)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_primary_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_teal)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_teal_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 4")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_orange)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_orange_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                )
                        )
                )
                .appendChild(Column.span6()
                        .appendChild(Card.create("FULL BODY COLORFUL PANEL ITEMS WITH ICON")
                                .setCollapsible(true)
                                .appendChild(b().textContent("Panel Accent"))
                                .appendChild(Accordion.create()
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_bg_accent_d_2, dui_fg_white)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_accent_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent_d_4)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .withContent((parent, content) -> content.addCss(dui_accent))
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_bg_primary_d_2, dui_fg_white)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_primary_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_primary_d_4)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .withContent((parent, content) -> content.addCss(dui_primary))
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_bg_teal_d_2, dui_fg_white)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_teal_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_teal_d_3)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .withContent((parent, content) -> content.addCss(dui_teal))
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 4")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_bg_amber_d_2, dui_fg_white)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_orange_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_white)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .withContent((parent, content) -> content.addCss(dui_deep_orange))
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                )
                        )
                )
        );


    }

    @SampleMethod
    private void multiOpenItems() {

        element.appendChild(Row.create()
                .appendChild(Column.span12()
                        .appendChild(Card.create("MULTIPLE ITEMS TO BE OPEN")
                                .setCollapsible(true)
                                .appendChild(Accordion.create()
                                        .setMultiOpen(true)
                                        .appendChild(AccordionPanel.create("Collapsible item 1")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_accent)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_accent_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                                .expand()
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 2")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_primary)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_primary_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 3")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_teal)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_teal_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                        .appendChild(AccordionPanel.create("Collapsible item 4")
                                                .withHeader((parent, header) -> header
                                                        .addCss(dui_orange)
                                                        .appendChild(PrefixAddOn.of(Icons.bus_clock()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("15").addCss(dui_rounded_full, dui_bg_orange_d_3)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_end()))
                                                )
                                                .withContentHeader((parent, contentHeader) -> contentHeader
                                                        .setTitle("Content header")
                                                        .appendChild(PrefixAddOn.of(Icons.clock_alert_outline()))
                                                        .appendChild(PostfixAddOn.of(Badge.create("On time").addCss(dui_rounded_full, dui_warning)))
                                                        .appendChild(PostfixAddOn.of(Icons.clock_in().addCss(dui_fg_accent)))
                                                )
                                                .withContentFooter((parent, footer) -> footer
                                                        .appendChild(PrefixAddOn.of(Icons.dots_vertical().clickable()))
                                                        .appendChild(PostfixAddOn.of(LinkButton.create("Remove")))
                                                        .appendChild(PostfixAddOn.of(Button.create("Accept").addCss(dui_success, dui_w_28)))
                                                )
                                                .appendChild(text(SAMPLE_CONTENT))
                                        )
                                )
                        )
                )
        );
    }
}
