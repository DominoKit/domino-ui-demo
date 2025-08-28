package org.dominokit.domino.applayout.client.views.ui;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.SampleClass;
import org.dominokit.domino.SampleMethod;
import org.dominokit.domino.api.client.annotations.UiView;
import org.dominokit.domino.applayout.client.presenters.AppLayoutProxy;
import org.dominokit.domino.applayout.client.views.AppLayoutView;
import org.dominokit.domino.componentcase.client.ui.views.BaseDemoView;
import org.dominokit.domino.componentcase.client.ui.views.CodeCard;
import org.dominokit.domino.componentcase.client.ui.views.LinkToSourceCode;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.layout.AppLayout;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.menu.Menu;
import org.dominokit.domino.ui.menu.MenuItem;
import org.dominokit.domino.ui.typography.BlockHeader;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

import static org.dominokit.domino.ui.utils.Domino.div;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_dominant_d_4;
import static org.dominokit.domino.ui.utils.Domino.dui_bg_white;
import static org.dominokit.domino.ui.utils.Domino.dui_border;
import static org.dominokit.domino.ui.utils.Domino.dui_border_accent;
import static org.dominokit.domino.ui.utils.Domino.dui_border_b;
import static org.dominokit.domino.ui.utils.Domino.dui_border_solid;
import static org.dominokit.domino.ui.utils.Domino.dui_fg_grey;
import static org.dominokit.domino.ui.utils.Domino.dui_flex;
import static org.dominokit.domino.ui.utils.Domino.dui_flex_wrap;
import static org.dominokit.domino.ui.utils.Domino.dui_gap_2;
import static org.dominokit.domino.ui.utils.Domino.dui_h_14;
import static org.dominokit.domino.ui.utils.Domino.dui_h_24;
import static org.dominokit.domino.ui.utils.Domino.dui_justify_between;
import static org.dominokit.domino.ui.utils.Domino.dui_m_2;
import static org.dominokit.domino.ui.utils.Domino.dui_m_t_4;
import static org.dominokit.domino.ui.utils.Domino.dui_w_24;
import static org.dominokit.domino.ui.utils.Domino.dui_w_56;

@UiView(presentable = AppLayoutProxy.class)
@SampleClass
public class AppLayoutViewImpl extends BaseDemoView<HTMLDivElement> implements AppLayoutView {
    private HTMLDivElement element;

    @Override
    protected HTMLDivElement init() {
        element = div().element();
        initAppLayoutSample();
        element.appendChild(CodeCard.createCodeCard(CodeResource.INSTANCE.initAppLayoutSample()).element());
        return element;
    }

    @SampleMethod
    private void initAppLayoutSample() {
        element.appendChild(LinkToSourceCode.createLink("appLayout", this.getClass()).element());
        element.appendChild(BlockHeader.create("LAYOUT", "Default domino-ui layout has, Navigation bar - 1,2,3 -, left panel - 4 -, center panel - 5 -, hidden footer - 6 - and hidden right panel - 7 -").element());
        element.appendChild(Card.create()
                .withBody((card, body) -> body.setHeight("700px"))
                .appendChild(AppLayout.create("Layout demo")
                        .addCss(dui_border, dui_border_solid, dui_border_accent)
                        .withLeftDrawer()
                        .withRightDrawer()
                        .withNavBar()
                        .withFooter()
                        .setLeftDrawerSpanUp(true)
                        .setLeftDrawerSpanDown(true)
                        .setShrinkContent(true)
                        .setAutoCloseLeftDrawer(true)
                        .withRightDrawer((layout, drawer) -> {
                            drawer.appendChild(NavBar.create("Right drawer")
                                    .addCss(dui_h_14, dui_border_b, dui_border_solid, dui_border_accent)
                                    .appendChild(PostfixAddOn.of(Icons.close()
                                            .clickable()
                                            .addClickListener(evt -> layout.hideRightDrawer())
                                    ))
                            );
                        })
                        .withNavBar((layout, nav) -> {
                            nav
                                    .appendChild(PostfixAddOn.of(TextBox.create()
                                            .apply(self -> self.labelElement().remove())
                                            .addCss(dui_w_56)
                                            .withWrapper((parent, self) -> self.addCss(dui_bg_white, dui_fg_grey))
                                            .appendChild(PostfixAddOn.of(Icons.magnify()))
                                    ))
                                    .appendChild(PostfixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .setDropMenu(Menu.<String>create()
                                                            .appendChild(MenuItem.create("Action 1"))
                                                            .appendChild(MenuItem.create("Action 2"))
                                                            .appendChild(MenuItem.create("Action 3"))
                                                    )
                                            )
                                    )
                                    .appendChild(PrefixAddOn.of(Icons.dots_vertical()
                                                    .clickable()
                                                    .setDropMenu(Menu.<String>create()
                                                            .appendChild(MenuItem.create("Action 1"))
                                                            .appendChild(MenuItem.create("Action 2"))
                                                            .appendChild(MenuItem.create("Action 3"))
                                                    )
                                            )
                                    )
                            ;
                        })
                        .withContent((layout, content) -> {
                            content
                                    .appendChild(Card.create()
                                            .setCollapsible(true)
                                            .appendChild(Row.create().addCss(dui_gap_2)
                                                    .span2(Button.create("Toggle left")
                                                            .addClickListener(evt -> layout.toggleLeftDrawer())
                                                    )
                                                    .span2(Button.create("Open left")
                                                            .addClickListener(evt -> layout.showLeftDrawer())
                                                    )
                                                    .span2(Button.create("Close left")
                                                            .addClickListener(evt -> layout.hideLeftDrawer())
                                                    )
                                                    .span2(Button.create("Toggle right")
                                                            .addClickListener(evt -> layout.toggleRightDrawer())
                                                    )
                                                    .span2(Button.create("Open right")
                                                            .addClickListener(evt -> layout.showRightDrawer())
                                                    )
                                                    .span2(Button.create("Close right")
                                                            .addClickListener(evt -> layout.hideRightDrawer())
                                                    )
                                            )
                                            .appendChild(Row.create().addCss(dui_m_t_4, dui_gap_2)
                                                    .span2(Button.create("Span left up")
                                                            .addClickListener(evt -> layout.setLeftDrawerSpanUp(true))
                                                    )
                                                    .span2(Button.create("Un-span left up")
                                                            .addClickListener(evt -> layout.setLeftDrawerSpanUp(false))
                                                    )
                                                    .span2(Button.create("Span left down")
                                                            .addClickListener(evt -> layout.setLeftDrawerSpanDown(true))
                                                            .setDropMenu(Menu.<String>create()
                                                                    .appendChild(MenuItem.create("Action 1"))
                                                                    .appendChild(MenuItem.create("Action 2"))
                                                                    .appendChild(MenuItem.create("Action 3"))
                                                            )
                                                    )
                                                    .span2(Button.create("Un-span left down")
                                                            .addClickListener(evt -> layout.setLeftDrawerSpanDown(false))
                                                    )
                                            )
                                            .appendChild(Row.create().addCss(dui_m_t_4, dui_gap_2)
                                                    .span2(Button.create("Shrink content")
                                                            .addClickListener(evt -> layout.setShrinkContent(true))
                                                    )
                                                    .span2(Button.create("Un-Shrink content")
                                                            .addClickListener(evt -> layout.setShrinkContent(false))
                                                    )
                                                    .span2(Button.create("toggle Shrink content")
                                                            .addClickListener(evt -> layout.toggleShrinkContent())
                                                    )
                                                    .span2(Button.create("Fixed footer")
                                                            .addClickListener(evt -> layout.setFixedFooter(true))
                                                    )
                                                    .span2(Button.create("Un-Fix footer")
                                                            .addClickListener(evt -> layout.setFixedFooter(false))
                                                    )
                                                    .span2(Button.create("Toggle Fix footer")
                                                            .addClickListener(evt -> layout.toggleFixedFooter())
                                                    )
                                            )
                                            .appendChild(Row.create().addCss(dui_m_t_4, dui_gap_2)
                                                    .span3(Button.create("Fixe left drawer(true)")
                                                            .addClickListener(evt -> layout.setFixLeftDrawer(true))
                                                    )
                                                    .span3(Button.create("Fixe left drawer(false)")
                                                            .addClickListener(evt -> layout.setFixLeftDrawer(false))
                                                    )
                                                    .span3(Button.create("Auto close left(true)")
                                                            .addClickListener(evt -> layout.setAutoCloseLeftDrawer(true))
                                                    )
                                                    .span3(Button.create("Auto close left(false)")
                                                            .addClickListener(evt -> layout.setAutoCloseLeftDrawer(false))
                                                    )
                                            )
                                            .appendChild(Row.create().addCss(dui_m_t_4, dui_gap_2)
                                                    .span3(Button.create("Auto close right(true)")
                                                            .addClickListener(evt -> layout.setAutoCloseRightDrawer(true))
                                                    )
                                                    .span3(Button.create("Auto close right(false)")
                                                            .addClickListener(evt -> layout.setAutoCloseRightDrawer(false))
                                                    )
                                            )
                                    )
                                    .appendChild(div().addCss(dui_flex, dui_flex_wrap, dui_justify_between)
                                            .apply(self -> {
                                                for (int i = 0; i < 100; i++) {
                                                    self.appendChild(div().addCss(dui_w_24, dui_h_24, dui_bg_dominant_d_4, dui_m_2));
                                                }
                                            })
                                    );
                        })
                )
                .element());
    }
}